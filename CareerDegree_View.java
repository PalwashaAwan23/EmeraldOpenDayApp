package com.example.emeraldopendayapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CareerDegree_View extends AppCompatActivity {

    private EditText inputCareerDegreeId, inputDegreeId, inputCareerId;
    private Button fetchButton;
    private TextView CareerDegreeDetails;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_degree_view);


        inputCareerDegreeId = findViewById(R.id.etPassword2);
        inputDegreeId = findViewById(R.id.etPassword19);
        inputCareerId = findViewById(R.id.etPassword20);
        fetchButton = findViewById(R.id.button4);
        CareerDegreeDetails = findViewById(R.id.textView75);


        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        fetchButton.setOnClickListener(v -> fetchCareerDegree());
    }

    private void fetchCareerDegree() {
        String CareerDegreeIdStr = inputCareerDegreeId.getText().toString().trim();
        String DegreeStr = inputDegreeId.getText().toString().trim();
        String CareerStr = inputCareerId.getText().toString().trim();

        if (!CareerDegreeIdStr.isEmpty()) {
            int CareerDegreeId = Integer.parseInt(CareerDegreeIdStr);
            viewCareerDegreeById(CareerDegreeId);
        } else if (!DegreeStr.isEmpty()) {
            int DegID = Integer.parseInt(DegreeStr);
            viewCareerDegreeByDegreeID(DegID);
        } else if (!CareerStr.isEmpty()) {
            int ModID = Integer.parseInt(CareerStr);
            viewCareerDegreeByCareerID(ModID);
        } else {
            Toast.makeText(this, "Please enter either Career Degree ID, Degree ID, or Career ID", Toast.LENGTH_SHORT).show();
        }
    }

    private void viewCareerDegreeById(int CareerDegreeID) {
        adminApi.getCareerDegreeByID(CareerDegreeID).enqueue(new Callback<CareerDegreeResponse>() {
            @Override
            public void onResponse(Call<CareerDegreeResponse> call, Response<CareerDegreeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    updateUI(response.body());
                } else {
                    CareerDegreeDetails.setText("Error: Career Degree not found!");
                }
            }

            @Override
            public void onFailure(Call<CareerDegreeResponse> call, Throwable t) {
                CareerDegreeDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void viewCareerDegreeByDegreeID(int DegreeID) {
        adminApi.getCareerDegreeByDegreeID(DegreeID).enqueue(new Callback<List<CareerDegreeResponse>>() { // FIXED: Using List
            @Override
            public void onResponse(Call<List<CareerDegreeResponse>> call, Response<List<CareerDegreeResponse>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    updateUIList(response.body());
                } else {
                    CareerDegreeDetails.setText("Error: No Career Degrees found for this Degree ID!");
                }
            }

            @Override
            public void onFailure(Call<List<CareerDegreeResponse>> call, Throwable t) {
                CareerDegreeDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void viewCareerDegreeByCareerID(int CareerID) {
        adminApi.getCareerDegreeByCareerID(CareerID).enqueue(new Callback<List<CareerDegreeResponse>>() { // FIXED: Using List
            @Override
            public void onResponse(Call<List<CareerDegreeResponse>> call, Response<List<CareerDegreeResponse>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    updateUIList(response.body());
                } else {
                    CareerDegreeDetails.setText("Error: No Career Degrees found for this Career ID!");
                }
            }

            @Override
            public void onFailure(Call<List<CareerDegreeResponse>> call, Throwable t) {
                CareerDegreeDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void updateUI(CareerDegreeResponse Career) {
        String details = "Career Degree ID: " + Career.getCareerDegreeID() +
                "\nDegree ID: " + Career.getDegreeCDId().getDegreeId() +
                "\nDegree Name: " + Career.getDegreeCDId().getDegreeName() +
                "\nCareer ID: " + Career.getCareerInfoCDId().getCareerId() +
                "\nCareer Name: " + Career.getCareerInfoCDId().getCareerName();

        CareerDegreeDetails.setText(details);
    }

    private void updateUIList(List<CareerDegreeResponse> Careers) {
        StringBuilder details = new StringBuilder();
        for (CareerDegreeResponse Career : Careers) {
            details.append("Career Degree ID: ").append(Career.getCareerDegreeID())
                    .append("\nDegree ID: ").append(Career.getDegreeCDId().getDegreeId())
                    .append("\nDegree Name: ").append(Career.getDegreeCDId().getDegreeName())
                    .append("\nCareer ID: ").append(Career.getCareerInfoCDId().getCareerId())
                    .append("\nCareer Name: ").append(Career.getCareerInfoCDId().getCareerName())
                    .append("\n\n");
        }
        CareerDegreeDetails.setText(details.toString());
    }
}