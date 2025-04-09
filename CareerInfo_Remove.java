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

public class CareerInfo_Remove extends AppCompatActivity {

    private EditText careerInfoIdInput, careerInfoNameInput;
    private Button removeButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_info_remove);

        // Initialize API client
        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        // Find views
        careerInfoIdInput = findViewById(R.id.etPassword2);
        careerInfoNameInput = findViewById(R.id.etPassword11);
        removeButton = findViewById(R.id.button4);

        // Button click listener
        removeButton.setOnClickListener(v -> removecareerInfo());
    }

    private void removecareerInfo() {
        String careerInfoIdStr = careerInfoIdInput.getText().toString().trim();
        String careerInfoNameStr = careerInfoNameInput.getText().toString().trim();

        if (!careerInfoIdStr.isEmpty()) {
            // Remove by ID
            int degreeId = Integer.parseInt(careerInfoIdStr);
            deleteCareerInfoById(degreeId);
        } else if (!careerInfoNameStr.isEmpty()) {
            // Remove by Name
            deleteCareerInfoByName(careerInfoNameStr);
        } else {
            Toast.makeText(this, "Please enter either careerInfo ID or careerInfo Name", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteCareerInfoById(int careerInfoId) {
        adminApi.removeCareerById(careerInfoId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CareerInfo_Remove.this, "Career removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(CareerInfo_Remove.this, "Failed to remove career", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(CareerInfo_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteCareerInfoByName(String careerInfoName) {
        adminApi.removeCareerByName(careerInfoName).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CareerInfo_Remove.this, "Career removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(CareerInfo_Remove.this, "Failed to remove career", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(CareerInfo_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}