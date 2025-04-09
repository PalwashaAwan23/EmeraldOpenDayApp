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

public class CareerInfo_View extends AppCompatActivity {

    private EditText inputCareerInfoId, inputCareerInfoName;
    private Button fetchButton;
    private TextView CareerInfoDetails;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_info_view);

        inputCareerInfoId = findViewById(R.id.etPassword2);
        inputCareerInfoName = findViewById(R.id.etPassword12);
        fetchButton = findViewById(R.id.button4);
        CareerInfoDetails = findViewById(R.id.textView73);

        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        fetchButton.setOnClickListener(v -> fetchCareerInfo());
    }

    private void fetchCareerInfo() {
        String CareerInfoIdStr = inputCareerInfoId.getText().toString().trim();
        String CareerInfoNameStr = inputCareerInfoName.getText().toString().trim();

        if (!CareerInfoIdStr.isEmpty()) {
            int CareerInfoId = Integer.parseInt(CareerInfoIdStr);
            viewCareerInfoById(CareerInfoId);
        } else if (!CareerInfoNameStr.isEmpty()) {
            viewCareerInfoByName(CareerInfoNameStr);
        } else {
            Toast.makeText(this, "Please enter either CareerInfo ID or CareerInfo Name", Toast.LENGTH_SHORT).show();
        }
    }

    private void viewCareerInfoById(int CareerInfoId) {
        adminApi.getCareerById(CareerInfoId).enqueue(new Callback<CareerInfoResponse>() {
            @Override
            public void onResponse(Call<CareerInfoResponse> call, Response<CareerInfoResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    CareerInfoResponse CareerInfo = response.body();
                    updateUI(CareerInfo);
                } else {
                    CareerInfoDetails.setText("Error: CareerInfo not found!");
                }
            }

            @Override
            public void onFailure(Call<CareerInfoResponse> call, Throwable t) {
                CareerInfoDetails.setText("Network error: " + t.getMessage());

            }
        });
    }

    private void viewCareerInfoByName(String CareerInfoName) {
        adminApi.getCareerByName(CareerInfoName).enqueue(new Callback<CareerInfoResponse>() {
            @Override
            public void onResponse(Call<CareerInfoResponse> call, Response<CareerInfoResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    CareerInfoResponse CareerInfo = response.body();
                    updateUI(CareerInfo);

                } else {
                    CareerInfoDetails.setText("Error: CareerInfo not found!");
                }
            }

            @Override
            public void onFailure(Call<CareerInfoResponse> call, Throwable t) {
                CareerInfoDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void updateUI(CareerInfoResponse CareerInfo) {
        String details = "CareerInfo ID: " + CareerInfo.getCareerId() +
                "\nCareerInfo Name: " + CareerInfo.getCareerName() +
                "\nStarting Salary: £" + CareerInfo.getStartingSalary() +
                "\nAverage Salary: £" + CareerInfo.getAverageSalary();

        CareerInfoDetails.setText(details);
    }
}