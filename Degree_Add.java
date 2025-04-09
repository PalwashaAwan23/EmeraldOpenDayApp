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

public class Degree_Add extends AppCompatActivity {

    private EditText degreeNameInput, ucasCodeInput, courseLengthInput;
    private Button submitButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degree_add);

        // Initialize API client
        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        // Find views
        degreeNameInput = findViewById(R.id.etPassword3);
        ucasCodeInput = findViewById(R.id.etPassword1);
        courseLengthInput = findViewById(R.id.etPassword4);
        submitButton = findViewById(R.id.button4);

        // Button click listener
        submitButton.setOnClickListener(v -> addDegree());
    }

    private void addDegree() {
        String degreeName = degreeNameInput.getText().toString().trim();
        String ucasCode = ucasCodeInput.getText().toString().trim();
        String courseLength = courseLengthInput.getText().toString().trim();

        if (degreeName.isEmpty() || courseLength.isEmpty()) {
            Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show();
            return;
        }

        DegreeResponse degree = new DegreeResponse(null, degreeName, ucasCode, courseLength);

        adminApi.addDegree(degree).enqueue(new Callback<DegreeResponse>() {
            @Override
            public void onResponse(Call<DegreeResponse> call, Response<DegreeResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Degree_Add.this, "Degree added successfully!", Toast.LENGTH_SHORT).show();
                    finish(); // Close activity
                } else {
                    Toast.makeText(Degree_Add.this, "Failed to add degree", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DegreeResponse> call, Throwable t) {
                Toast.makeText(Degree_Add.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
