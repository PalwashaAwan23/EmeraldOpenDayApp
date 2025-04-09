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

public class ModuleDegree_Add extends AppCompatActivity {

    private EditText degreeInput, modulesInput;
    private Button submitButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_degree_add);

        // Initialize API client
        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        // Find views
        degreeInput = findViewById(R.id.etPassword4);
        modulesInput = findViewById(R.id.etPassword3);
        submitButton = findViewById(R.id.button4);

        // Button click listener
        submitButton.setOnClickListener(v -> addModules());
    }

    private void addModules() {
        String degreeNum = degreeInput.getText().toString().trim();
        String modulesNum = modulesInput.getText().toString().trim();

        if (degreeNum.isEmpty() || modulesNum.isEmpty()) {
            Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show();
            return;
        }

//        int degreeNumber = Integer.parseInt(degreeNum);
//        int modulesNumber = Integer.parseInt(modulesNum);

        // Step 1: Fetch Degree First
        adminApi.getDegreeByName(degreeNum).enqueue(new Callback<DegreeResponse>() {
            @Override
            public void onResponse(Call<DegreeResponse> call, Response<DegreeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    DegreeResponse degree = response.body();

                    // Step 2: Fetch Module After Degree is Retrieved
                    adminApi.getModuleByName(modulesNum).enqueue(new Callback<ModulesResponse>() {
                        @Override
                        public void onResponse(Call<ModulesResponse> call, Response<ModulesResponse> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                ModulesResponse module = response.body();

                                // Step 3: Create ModuleDegreeResponse and Send Data
                                ModuleDegreeResponse moduleDegree = new ModuleDegreeResponse(null, degree, module);

                                adminApi.addModuleDegree(moduleDegree).enqueue(new Callback<ModuleDegreeResponse>() {
                                    @Override
                                    public void onResponse(Call<ModuleDegreeResponse> call, Response<ModuleDegreeResponse> response) {
                                        if (response.isSuccessful()) {
                                            Toast.makeText(ModuleDegree_Add.this, "Module Degree added successfully!", Toast.LENGTH_SHORT).show();
                                            finish(); // Close activity
                                        } else {
                                            Toast.makeText(ModuleDegree_Add.this, "Failed to add Module Degree", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<ModuleDegreeResponse> call, Throwable t) {
                                        Toast.makeText(ModuleDegree_Add.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });

                            } else {
                                Toast.makeText(ModuleDegree_Add.this, "Failed to get Module", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ModulesResponse> call, Throwable t) {
                            Toast.makeText(ModuleDegree_Add.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                } else {
                    Toast.makeText(ModuleDegree_Add.this, "Failed to get Degree", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DegreeResponse> call, Throwable t) {
                Toast.makeText(ModuleDegree_Add.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}