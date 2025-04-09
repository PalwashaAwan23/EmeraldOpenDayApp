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

public class BTECExDipl_Add extends AppCompatActivity {
    private EditText minGrade, maxGrade;
    private Button submitButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btecex_dipl_add);

        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        minGrade = findViewById(R.id.etPassword3);
        maxGrade = findViewById(R.id.etPassword1);
        submitButton = findViewById(R.id.button4);

        submitButton.setOnClickListener( v -> addBTEC());
    }

    private void addBTEC() {
        String MinGrade = minGrade.getText().toString().trim();
        String MaxGrade = maxGrade.getText().toString().trim();

        if (MinGrade.isEmpty() || MaxGrade.isEmpty()) {
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        BTECResponse btecDiploma = new BTECResponse(null, MinGrade, MaxGrade);

        adminApi.addBTEC(btecDiploma).enqueue(new Callback<BTECResponse>() {
            @Override
            public void onResponse(Call<BTECResponse> call, Response<BTECResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(BTECExDipl_Add.this, "BTEC added successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(BTECExDipl_Add.this, "Failed to add BTEC!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BTECResponse> call, Throwable t) {
                Toast.makeText(BTECExDipl_Add.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}