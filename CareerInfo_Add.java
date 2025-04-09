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

public class CareerInfo_Add extends AppCompatActivity {

    private EditText careerNameInput, averageSalaryInput, startingSalaryInput;
    private Button submitButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_info_add);

        // Initialize API client
        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        // Find views
        careerNameInput = findViewById(R.id.etPassword3);
        averageSalaryInput = findViewById(R.id.etPassword1);
        startingSalaryInput = findViewById(R.id.editText);
        submitButton = findViewById(R.id.button4);

        // Button click listener
        submitButton.setOnClickListener(v -> addCareerInfo());
    }

    private void addCareerInfo() {
        String careerName = careerNameInput.getText().toString().trim();
        String averageSalary = averageSalaryInput.getText().toString().trim();
        String startingSalary = startingSalaryInput.getText().toString().trim();


        if (careerName.isEmpty() || startingSalary.isEmpty() || averageSalary.isEmpty()) {
            Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show();
            return;
        }
        int startSal = Integer.parseInt(startingSalary);
        int averageSal = Integer.parseInt(averageSalary);
        CareerInfoResponse career = new CareerInfoResponse(null, careerName, startSal, averageSal);

        adminApi.addCareerInfo(career).enqueue(new Callback<CareerInfoResponse>() {
            @Override
            public void onResponse(Call<CareerInfoResponse> call, Response<CareerInfoResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CareerInfo_Add.this, "Module added successfully!", Toast.LENGTH_SHORT).show();
                    finish(); // Close activity
                } else {
                    Toast.makeText(CareerInfo_Add.this, "Failed to add career", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CareerInfoResponse> call, Throwable t) {
                Toast.makeText(CareerInfo_Add.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}