package com.example.emeraldopendayapp;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 100;
    private EditText emailEditText, passwordEditText;
    private Button loginButton, signupButton, googleSignInButton;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private SignInClient oneTapClient;
    private BeginSignInRequest signInRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.etEmail);
        passwordEditText = findViewById(R.id.etPassword);
        loginButton = findViewById(R.id.etloginButton);
        signupButton = findViewById(R.id.etSignButton2);
        googleSignInButton = findViewById(R.id.btnGoogleSignIn);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        // Google Sign-In Configuration
        oneTapClient = Identity.getSignInClient(this);
        signInRequest = BeginSignInRequest.builder()
                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                        .setSupported(true)
                        .setServerClientId(getString(R.string.default_web_client_id)) // Add this in strings.xml
                        .setFilterByAuthorizedAccounts(false)
                        .build())
                .build();

        loginButton.setOnClickListener(v -> loginUser());

        signupButton.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, User.class);
            startActivity(intent);
        });

        googleSignInButton.setOnClickListener(v -> signInWithGoogle());
    }

    // ✅ Function to log in with Email & Password
    private void loginUser() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            checkUserInFirestore(user);
                        } else {
                            Toast.makeText(this, "Login failed: User is null", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Login failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    // ✅ Function to log in with Google
    private void signInWithGoogle() {
        oneTapClient.beginSignIn(signInRequest)
                .addOnSuccessListener(this, result -> {
                    try {
                        startIntentSenderForResult(result.getPendingIntent().getIntentSender(), RC_SIGN_IN, null, 0, 0, 0);
                    } catch (Exception e) {
                        Log.e("GoogleSignIn", "Error starting sign-in intent", e);
                    }
                })
                .addOnFailureListener(this, e -> Log.e("GoogleSignIn", "Sign-in failed", e));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            try {
                SignInCredential credential = oneTapClient.getSignInCredentialFromIntent(data);
                String idToken = credential.getGoogleIdToken();
                if (idToken != null) {
                    AuthCredential firebaseCredential = GoogleAuthProvider.getCredential(idToken, null);
                    mAuth.signInWithCredential(firebaseCredential)
                            .addOnCompleteListener(this, task -> {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    if (user != null) {
                                        checkUserInFirestore(user);
                                    }
                                } else {
                                    Toast.makeText(LoginActivity.this, "Google Sign-In failed", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            } catch (Exception e) {
                Log.e("GoogleSignIn", "Error processing sign-in result", e);
            }
        }
    }

    // ✅ Check if user exists in Firestore
    private void checkUserInFirestore(FirebaseUser user) {
        db.collection("users").document(user.getUid()).get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        boolean isAdmin = documentSnapshot.getBoolean("isAdmin");
                        Intent intent = isAdmin ? new Intent(LoginActivity.this, db_control_panel.class)
                                : new Intent(LoginActivity.this, User.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(this, "User not found, registering...", Toast.LENGTH_SHORT).show();
                        createUserInFirestore(user);
                    }
                })
                .addOnFailureListener(e -> Toast.makeText(this, "Error fetching user data", Toast.LENGTH_SHORT).show());
    }

    private void createUserInFirestore(FirebaseUser user) {
        db.collection("users").document(user.getUid()).set(new UserModel(user.getEmail(), false))
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "User registered!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, User.class));
                    finish();
                })
                .addOnFailureListener(e -> Toast.makeText(this, "Error saving user data", Toast.LENGTH_SHORT).show());
    }

    // Simple model for storing user info
    private static class UserModel {
        String email;
        boolean isAdmin;

        public UserModel(String email, boolean isAdmin) {
            this.email = email;
            this.isAdmin = isAdmin;
        }
    }
}
