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

public class ModuleDegree_Remove extends AppCompatActivity {

    private EditText moduleDegreeIdInput, degreeNameInput, moduleNameInput;
    private Button removeButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_degree_remove);

        // Initialize API client
        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        // Find views
        moduleDegreeIdInput = findViewById(R.id.etPassword2);
        degreeNameInput = findViewById(R.id.etPassword13);
        moduleNameInput = findViewById(R.id.etPassword14);
        removeButton = findViewById(R.id.button4);

        // Button click listener
        removeButton.setOnClickListener(v -> removeModule());
    }

    private void removeModule() {
        String moduleDegreeId =moduleDegreeIdInput.getText().toString().trim();
        String degreeNameStr = degreeNameInput.getText().toString().trim();
        String moduleNameStr = moduleNameInput.getText().toString().trim();

        if (!moduleDegreeId.isEmpty()) {
            // Remove by ID
            int modDegId = Integer.parseInt(moduleDegreeId);
            deleteModuleDegreeById(modDegId);
        } else if (!degreeNameStr.isEmpty()) {
            // Remove by Name
            int degID = Integer.parseInt(degreeNameStr);
            deleteModuleDegreeByDegreeName(degID);
        } else if (!moduleNameStr.isEmpty()) {
            int modID = Integer.parseInt(moduleNameStr);
            deleteModuleDegreeByModuleName(modID);
        } else {
            Toast.makeText(this, "Please enter either Module ID or Module Name", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteModuleDegreeById(int moduleDegreeId) {
        adminApi.deleteModuleDegreeByID(moduleDegreeId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ModuleDegree_Remove.this, "Module Degree removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(ModuleDegree_Remove.this, "Failed to remove Module Degree", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(ModuleDegree_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteModuleDegreeByDegreeName(Integer degreeID) {
        adminApi.deleteModuleDegreeByDegreeID(degreeID).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ModuleDegree_Remove.this, "Module Degree removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(ModuleDegree_Remove.this, "Failed to remove Module Degree", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(ModuleDegree_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteModuleDegreeByModuleName(Integer moduleID) {
        adminApi.deleteModuleDegreeByModuleID(moduleID).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ModuleDegree_Remove.this, "Module Degree removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(ModuleDegree_Remove.this, "Failed to remove Module Degree", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(ModuleDegree_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}