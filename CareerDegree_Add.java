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

public class CareerDegree_Add extends AppCompatActivity {

    private EditText degreeInput, careerInput;
    private Button submitButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_degree_add);

        // Initialize API client
        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        // Find views
        degreeInput = findViewById(R.id.etPassword3);
        careerInput = findViewById(R.id.etPassword1);
        submitButton = findViewById(R.id.button4);

        // Button click listener
        submitButton.setOnClickListener(v -> addModules());
    }

    private void addModules() {
        String degreeNum = degreeInput.getText().toString().trim();
        String careerNum = careerInput.getText().toString().trim();

        if (degreeNum.isEmpty() || careerNum.isEmpty()) {
            Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show();
            return;
        }


        adminApi.getDegreeByName(degreeNum).enqueue(new Callback<DegreeResponse>() {
            @Override
            public void onResponse(Call<DegreeResponse> call, Response<DegreeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    DegreeResponse degree = response.body();

                    // Step 2: Fetch Module After Degree is Retrieved
                    adminApi.getCareerByName(careerNum).enqueue(new Callback<CareerInfoResponse>() {
                        @Override
                        public void onResponse(Call<CareerInfoResponse> call, Response<CareerInfoResponse> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                CareerInfoResponse career = response.body();

                                // Step 3: Create ModuleDegreeResponse and Send Data
                                CareerDegreeResponse careerDegree = new CareerDegreeResponse(null, degree, career);

                                adminApi.addCareerDegree(careerDegree).enqueue(new Callback<CareerDegreeResponse>() {
                                    @Override
                                    public void onResponse(Call<CareerDegreeResponse> call, Response<CareerDegreeResponse> response) {
                                        if (response.isSuccessful()) {
                                            Toast.makeText(CareerDegree_Add.this, "Module Degree added successfully!", Toast.LENGTH_SHORT).show();
                                            finish(); // Close activity
                                        } else {
                                            Toast.makeText(CareerDegree_Add.this, "Failed to add Module Degree", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<CareerDegreeResponse> call, Throwable t) {
                                        Toast.makeText(CareerDegree_Add.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });

                            } else {
                                Toast.makeText(CareerDegree_Add.this, "Failed to get Module", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<CareerInfoResponse> call, Throwable t) {
                            Toast.makeText(CareerDegree_Add.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                } else {
                    Toast.makeText(CareerDegree_Add.this, "Failed to get Degree", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DegreeResponse> call, Throwable t) {
                Toast.makeText(CareerDegree_Add.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}