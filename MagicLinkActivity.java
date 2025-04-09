package com.example.emeraldopendayapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;

public class MagicLinkActivity extends AppCompatActivity {

    private EditText emailEditText;
    private Button sendLinkButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_login);

        emailEditText = findViewById(R.id.etPassword2); // Corrected ID
        sendLinkButton = findViewById(R.id.button4);
        mAuth = FirebaseAuth.getInstance();

        // Handle deep link (when the user clicks the magic link)
        Uri deepLink = getIntent().getData();
        if (deepLink != null && deepLink.toString().contains("magic-login")) {
            handleMagicLinkSignIn(deepLink.toString());
        }

        sendLinkButton.setOnClickListener(v -> sendSignInLink());
    }

    private void sendSignInLink() {
        String email = emailEditText.getText().toString().trim();

        if (email.isEmpty()) {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return;
        }

        ActionCodeSettings actionCodeSettings = ActionCodeSettings.newBuilder()
                .setUrl(" https://emeraldopendayapp.com/magic-login") // Corrected deep link
                .setHandleCodeInApp(true)
                .setAndroidPackageName(getPackageName(), true, null) // Fixed package name
                .build();

        mAuth.sendSignInLinkToEmail(email, actionCodeSettings)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Magic sign-in link sent to your email", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed to send sign-in link", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void handleMagicLinkSignIn(String link) {
        if (mAuth.isSignInWithEmailLink(link)) {
            String email = getIntent().getStringExtra("email"); // Retrieve email if stored
            if (email == null) {
                Toast.makeText(this, "Error: No email found.", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailLink(email, link)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            FirebaseUser user = task.getResult().getUser();
                            Toast.makeText(this, "Signed in as " + user.getEmail(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(this, User.class)); // Change to the correct next page
                            finish();
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(this, "Invalid or expired link.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(this, "Sign-in failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}
