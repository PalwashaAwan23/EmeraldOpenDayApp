package com.example.emeraldopendayapp;

import android.os.Bundle;
import android.widget.AlphabetIndexer;
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

public class alevel_view extends AppCompatActivity {

    private EditText inputMinGrade, inputMaxGrade, inputALevelID;
    private Button fetchButton;
    private TextView alevelDetails;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alevel_view);

        inputALevelID = findViewById(R.id.etPassword2);
        inputMinGrade = findViewById(R.id.etPassword4);
        inputMaxGrade = findViewById(R.id.etPassword3);
        alevelDetails = findViewById(R.id.textView7);
        fetchButton = findViewById(R.id.button4);

        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        fetchButton.setOnClickListener(v -> fetchDegree());
    }

    private void fetchDegree() {
        String minGrade = inputMinGrade.getText().toString().trim();
        String maxGrade = inputMaxGrade.getText().toString().trim();
        String alevelId = inputALevelID.getText().toString().trim();


        if (!alevelId.isEmpty()) {
            int AlevelId = Integer.parseInt(alevelId);
            viewALevelById(AlevelId);
        } else if (!maxGrade.isEmpty()) {
            viewALevelByMaxGrade(maxGrade);
        } else if (!minGrade.isEmpty()) {
            viewALevelByMinGrade(minGrade);
        } else {
            Toast.makeText(this, "Please enter either Degree ID or Degree Name", Toast.LENGTH_SHORT).show();
        }
    }

    private void viewALevelById (int alevelId) {
        adminApi.getAlevelById(alevelId).enqueue(new Callback<ALevelResponse>() {
            @Override
            public void onResponse(Call<ALevelResponse> call, Response<ALevelResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ALevelResponse alevel = response.body();
                    updateUI(alevel);
                } else {
                    alevelDetails.setText("Error: Alevel not found!");
                }
            }

            @Override
            public void onFailure(Call<ALevelResponse> call, Throwable t) {
                alevelDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void viewALevelByMaxGrade(String maxgrade) {
        adminApi.getAlevelByMaxGrade(maxgrade).enqueue(new Callback<ALevelResponse>() {
            @Override
            public void onResponse(Call<ALevelResponse> call, Response<ALevelResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ALevelResponse alevel = response.body();
                    updateUI(alevel);

                } else {
                    alevelDetails.setText("Error: Alevel not found!");
                }
            }

            @Override
            public void onFailure(Call<ALevelResponse> call, Throwable t) {
                alevelDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void viewALevelByMinGrade(String mingrade) {
        adminApi.getAlevelByMinGrade(mingrade).enqueue(new Callback<ALevelResponse>() {
            @Override
            public void onResponse(Call<ALevelResponse> call, Response<ALevelResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ALevelResponse alevel = response.body();
                    updateUI(alevel);

                } else {
                    alevelDetails.setText("Error: Alevel not found!");
                }
            }

            @Override
            public void onFailure(Call<ALevelResponse> call, Throwable t) {
                alevelDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void updateUI(ALevelResponse alevel) {
        String details = "ALevel ID: " + alevel.getAlevelID() +
                "\nMax Grade: " + alevel.getMaxGrade() +
                "\nMin Grade: " + alevel.getMinGrade();

        alevelDetails.setText(details);
    }
}