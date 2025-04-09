package com.example.emeraldopendayapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Degree_View extends AppCompatActivity {
    private EditText inputDegreeId, inputDegreeName;
    private Button fetchButton;
    private TextView degreeDetails;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degree_view);

        inputDegreeId = findViewById(R.id.etPassword2);
        inputDegreeName = findViewById(R.id.etPassword3);
        fetchButton = findViewById(R.id.button4);
        degreeDetails = findViewById(R.id.textView44);

        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        fetchButton.setOnClickListener(v -> fetchDegree());
    }

    private void fetchDegree() {
        String degreeIdStr = inputDegreeId.getText().toString().trim();
        String degreeNameStr = inputDegreeName.getText().toString().trim();

        if (!degreeIdStr.isEmpty()) {
            int degreeId = Integer.parseInt(degreeIdStr);
            viewDegreeById(degreeId);
        } else if (!degreeNameStr.isEmpty()) {
            viewDegreeByName(degreeNameStr);
        } else {
            Toast.makeText(this, "Please enter either Degree ID or Degree Name", Toast.LENGTH_SHORT).show();
        }
    }

    private void viewDegreeById(int degreeId) {
        adminApi.getDegreeById(degreeId).enqueue(new Callback<DegreeResponse>() {
            @Override
            public void onResponse(Call<DegreeResponse> call, Response<DegreeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    DegreeResponse degree = response.body();
                    updateUI(degree);
                } else {
                    degreeDetails.setText("Error: Degree not found!");
                }
            }

            @Override
            public void onFailure(Call<DegreeResponse> call, Throwable t) {
                degreeDetails.setText("Network error: " + t.getMessage());

            }
        });
    }

    private void viewDegreeByName(String degreeName) {
        adminApi.getDegreeByName(degreeName).enqueue(new Callback<DegreeResponse>() {
            @Override
            public void onResponse(Call<DegreeResponse> call, Response<DegreeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    DegreeResponse degree = response.body();
                    updateUI(degree);

                } else {
                    degreeDetails.setText("Error: Degree not found!");
                }
            }

            @Override
            public void onFailure(Call<DegreeResponse> call, Throwable t) {
                degreeDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void updateUI(DegreeResponse degree) {
        String details = "Degree ID: " + degree.getDegreeId() +
                "\nDegree Name: " + degree.getDegreeName() +
                "\nCourse Length: " + degree.getCourseLength() +
                "\nUCAS Code: " + degree.getUCASCode();

        degreeDetails.setText(details);
    }
}
