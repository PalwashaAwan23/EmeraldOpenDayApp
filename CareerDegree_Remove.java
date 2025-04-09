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

public class CareerDegree_Remove extends AppCompatActivity {

    private EditText careerDegreeIdInput, degreeNameInput, careerNameInput;
    private Button removeButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_degree_remove);

        // Initialize API client
        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        // Find views
        careerDegreeIdInput = findViewById(R.id.etPassword2);
        degreeNameInput = findViewById(R.id.etPassword17);
        careerNameInput = findViewById(R.id.etPassword18);
        removeButton = findViewById(R.id.button4);

        // Button click listener
        removeButton.setOnClickListener(v -> removeModule());
    }

    private void removeModule() {
        String careerDegreeId = careerDegreeIdInput.getText().toString().trim();
        String degreeNameStr = degreeNameInput.getText().toString().trim();
        String careerNameStr = careerNameInput.getText().toString().trim();

        if (!careerDegreeId.isEmpty()) {
            // Remove by ID
            int carDegId = Integer.parseInt(careerDegreeId);
            deleteCareerDegreeById(carDegId);
        } else if (!degreeNameStr.isEmpty()) {
            // Remove by Name
            int degID = Integer.parseInt(degreeNameStr);
            deleteCareerDegreeByDegreeName(degID);
        } else if (!careerNameStr.isEmpty()) {
            int carID = Integer.parseInt(careerNameStr);
            deleteCareerDegreeByCareerName(carID);
        } else {
            Toast.makeText(this, "Please enter either Module ID or Module Name", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteCareerDegreeById(int careerDegreeId) {
        adminApi.deleteCareerDegreeByID(careerDegreeId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CareerDegree_Remove.this, "Career Degree removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(CareerDegree_Remove.this, "Failed to remove Career Degree", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(CareerDegree_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteCareerDegreeByDegreeName(Integer degreeID) {
        adminApi.deleteCareerDegreeByDegreeID(degreeID).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CareerDegree_Remove.this, "Career Degree removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(CareerDegree_Remove.this, "Failed to remove Career Degree", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(CareerDegree_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteCareerDegreeByCareerName(Integer CareerID) {
        adminApi.deleteCareerDegreeByCareerID(CareerID).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CareerDegree_Remove.this, "Career Degree removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(CareerDegree_Remove.this, "Failed to remove Career Degree", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(CareerDegree_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}