package com.example.emeraldopendayapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Degree_Remove extends AppCompatActivity {

    private EditText degreeIdInput, degreeNameInput;
    private Button removeButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degree_remove);

        // Initialize API client
        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        // Find views
        degreeIdInput = findViewById(R.id.etPassword2);  // For Degree ID
        degreeNameInput = findViewById(R.id.etPassword3); // For Degree Name
        removeButton = findViewById(R.id.button4);

        // Button click listener
        removeButton.setOnClickListener(v -> removeDegree());
    }

    private void removeDegree() {
        String degreeIdStr = degreeIdInput.getText().toString().trim();
        String degreeNameStr = degreeNameInput.getText().toString().trim();

        if (!degreeIdStr.isEmpty()) {
            // Remove by ID
            int degreeId = Integer.parseInt(degreeIdStr);
            deleteDegreeById(degreeId);
        } else if (!degreeNameStr.isEmpty()) {
            // Remove by Name
            deleteDegreeByName(degreeNameStr);
        } else {
            Toast.makeText(this, "Please enter either Degree ID or Degree Name", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteDegreeById(int degreeId) {
        adminApi.removeDegree(degreeId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Degree_Remove.this, "Degree removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(Degree_Remove.this, "Failed to remove degree", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(Degree_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteDegreeByName(String degreeName) {
        adminApi.removeDegreeByName(degreeName).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Degree_Remove.this, "Degree removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(Degree_Remove.this, "Failed to remove degree", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(Degree_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

