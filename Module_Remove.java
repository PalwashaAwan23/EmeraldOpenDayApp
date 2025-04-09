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

public class Module_Remove extends AppCompatActivity {

    private EditText moduleIdInput, moduleNameInput;
    private Button removeButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_remove);

        // Initialize API client
        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        // Find views
        moduleIdInput = findViewById(R.id.etPassword2);
        moduleNameInput = findViewById(R.id.etPassword9);
        removeButton = findViewById(R.id.button4);

        // Button click listener
        removeButton.setOnClickListener(v -> removeModule());
    }

    private void removeModule() {
        String moduleIdStr = moduleIdInput.getText().toString().trim();
        String moduleNameStr = moduleNameInput.getText().toString().trim();

        if (!moduleIdStr.isEmpty()) {
            // Remove by ID
            int degreeId = Integer.parseInt(moduleIdStr);
            deleteModuleById(degreeId);
        } else if (!moduleNameStr.isEmpty()) {
            // Remove by Name
            deleteModuleByName(moduleNameStr);
        } else {
            Toast.makeText(this, "Please enter either Module ID or Module Name", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteModuleById(int moduleId) {
        adminApi.removeModuleById(moduleId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Module_Remove.this, "Module removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(Module_Remove.this, "Failed to remove module", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(Module_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteModuleByName(String moduleName) {
        adminApi.removeModuleByName(moduleName).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Module_Remove.this, "Module removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(Module_Remove.this, "Failed to remove Module", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(Module_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}