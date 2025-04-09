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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HEDiploma_View extends AppCompatActivity {

    private EditText inputMinGrade, inputMaxGrade, inputHeID;
    private Button fetchButton;
    private TextView heDetails;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hediploma_view);

        inputHeID = findViewById(R.id.etPassword2);
        inputMinGrade = findViewById(R.id.etPassword3);
        inputMaxGrade = findViewById(R.id.etPassword4);
        heDetails = findViewById(R.id.textView7);
        fetchButton = findViewById(R.id.button4);

        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        fetchButton.setOnClickListener(v -> fetchDegree());
    }

    private void fetchDegree() {
        String minGrade = inputMinGrade.getText().toString().trim();
        String maxGrade = inputMaxGrade.getText().toString().trim();
        String heId = inputHeID.getText().toString().trim();


        if (!heId.isEmpty()) {
            int HEId = Integer.parseInt(heId);
            viewHEById(HEId);
        } else if (!maxGrade.isEmpty()) {
            viewHEByMaxGrade(maxGrade);
        } else if (!minGrade.isEmpty()) {
            viewHEByMinGrade(minGrade);
        } else {
            Toast.makeText(this, "Please enter either HEDiploma ID or Grade", Toast.LENGTH_SHORT).show();
        }
    }

    private void viewHEById (int HEId) {
        adminApi.getHEById(HEId).enqueue(new Callback<HEDiplomaResponse>() {
            @Override
            public void onResponse(Call<HEDiplomaResponse> call, Response<HEDiplomaResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    HEDiplomaResponse heDiploma = response.body();
                    updateUI(heDiploma);
                } else {
                    heDetails.setText("Error: HEDiploma not found!");
                }
            }

            @Override
            public void onFailure(Call<HEDiplomaResponse> call, Throwable t) {
                heDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void viewHEByMaxGrade(String maxgrade) {
        adminApi.getHEByMaxGrade(maxgrade).enqueue(new Callback<HEDiplomaResponse>() {
            @Override
            public void onResponse(Call<HEDiplomaResponse> call, Response<HEDiplomaResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    HEDiplomaResponse heDiploma = response.body();
                    updateUI(heDiploma);
                } else {
                    heDetails.setText("Error: HEDiploma not found!");
                }
            }

            @Override
            public void onFailure(Call<HEDiplomaResponse> call, Throwable t) {
                heDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void viewHEByMinGrade(String mingrade) {
        adminApi.getHEByMinGrade(mingrade).enqueue(new Callback<HEDiplomaResponse>() {
            @Override
            public void onResponse(Call<HEDiplomaResponse> call, Response<HEDiplomaResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    HEDiplomaResponse heDiploma = response.body();
                    updateUI(heDiploma);
                } else {
                    heDetails.setText("Error: HEDiploma not found!");
                }
            }

            @Override
            public void onFailure(Call<HEDiplomaResponse> call, Throwable t) {
                heDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void updateUI(HEDiplomaResponse heDiploma) {
        String details = "HE ID: " + heDiploma.getHeID() +
                "\nMax Grade: " + heDiploma.getMaxGrade() +
                "\nMin Grade: " + heDiploma.getMinGrade();

        heDetails.setText(details);
    }
}