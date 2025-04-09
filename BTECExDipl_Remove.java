package com.example.emeraldopendayapp;

import android.os.Bundle;
import android.util.Log;
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

public class BTECExDipl_Remove extends AppCompatActivity {

    private EditText maxGradeInput, minGradeInput, BtecIdInput;
    private Button removeButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btecex_dipl_remove);

        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        minGradeInput = findViewById(R.id.etPassword7);
        maxGradeInput = findViewById(R.id.etPassword8);
        BtecIdInput = findViewById(R.id.etPassword2);
        removeButton = findViewById(R.id.button4);

        removeButton.setOnClickListener(v -> removeBTEC());
    }

    private void removeBTEC() {
        String minGradeStr = minGradeInput.getText().toString().trim();
        String maxGradeStr = maxGradeInput.getText().toString().trim();
        String btecIdStr = BtecIdInput.getText().toString().trim();

        if (!btecIdStr.isEmpty()) {
            int btecId = Integer.parseInt(btecIdStr);
            Log.d("Remove BTEC", "Deleting BTEC with ID: " + btecId);
            deleteBTECByBTECId(btecId);
        } else if (!minGradeStr.isEmpty()) {
            Log.d("Remove BTEC", "Deleting BTEC with MinGrade: " + minGradeStr);
            deleteBTECByMinGrade(minGradeStr);
        } else if (!maxGradeStr.isEmpty()) {
            Log.d("Remove BTEC", "Deleting BTEC with MaxGrade: " + maxGradeStr);
            deleteBTECByMaxGrade(maxGradeStr);
        } else {
            Toast.makeText(this, "Please enter either ID or Max/Min Grades", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteBTECByMinGrade(String minGrade) {
        adminApi.removeBTECByMinGrade(minGrade).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(BTECExDipl_Remove.this, "BTEC removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(BTECExDipl_Remove.this, "Failed to remove BTEC", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(BTECExDipl_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteBTECByMaxGrade(String maxGrade) {
        adminApi.removeBTECByMaxGrade(maxGrade).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(BTECExDipl_Remove.this, "BTEC removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(BTECExDipl_Remove.this, "Failed to remove BTEC", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(BTECExDipl_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteBTECByBTECId(int btecID) {
        adminApi.removeBTECById(btecID).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(BTECExDipl_Remove.this, "BTEC removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(BTECExDipl_Remove.this, "Failed to remove BTEC", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(BTECExDipl_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}