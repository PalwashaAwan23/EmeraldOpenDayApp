package com.example.emeraldopendayapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Modules_Add extends AppCompatActivity {

    private EditText moduleNameInput, creditsInput;
    private Button submitButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules_add);

        // Initialize API client
        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        // Find views
        moduleNameInput = findViewById(R.id.etPassword4);
        creditsInput = findViewById(R.id.etPassword3);
        submitButton = findViewById(R.id.button4);

        // Button click listener
        submitButton.setOnClickListener(v -> addModules());
    }

    private void addModules() {
        String moduleName = moduleNameInput.getText().toString().trim();
        String credits = creditsInput.getText().toString().trim();


        if (moduleName.isEmpty() || credits.isEmpty()) {
            Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show();
            return;
        }
        int creditsVal = Integer.parseInt(credits);
        ModulesResponse modules = new ModulesResponse(null, moduleName, creditsVal);

        adminApi.addModule(modules).enqueue(new Callback<ModulesResponse>() {
            @Override
            public void onResponse(Call<ModulesResponse> call, Response<ModulesResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Modules_Add.this, "Module added successfully!", Toast.LENGTH_SHORT).show();
                    finish(); // Close activity
                } else {
                    Toast.makeText(Modules_Add.this, "Failed to add module", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModulesResponse> call, Throwable t) {
                Toast.makeText(Modules_Add.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}