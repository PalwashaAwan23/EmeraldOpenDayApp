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

public class alevel_remove extends AppCompatActivity {

    private EditText maxGradeInput, minGradeInput, ALevelIdInput;
    private Button removeButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alevel_remove);

        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        minGradeInput = findViewById(R.id.etPassword3);
        maxGradeInput = findViewById(R.id.etPassword4);
        ALevelIdInput = findViewById(R.id.etPassword2);
        removeButton = findViewById(R.id.button4);

        removeButton.setOnClickListener(v -> removeDegree());
    }

    private void removeDegree() {
        String minGradeStr = minGradeInput.getText().toString().trim();
        String maxGradeStr = maxGradeInput.getText().toString().trim();
        String alevelIdStr = ALevelIdInput.getText().toString().trim();

        if (!alevelIdStr.isEmpty()) {
            int alevelId = Integer.parseInt(alevelIdStr);
            Log.d("Remove ALevel", "Deleting HEDiploma with ID: " + alevelId);
            deleteALevelByALevelId(alevelId);
        } else if (!minGradeStr.isEmpty()) {
            Log.d("Remove ALevel", "Deleting HEDiploma with MinGrade: " + minGradeStr);
            deleteALevelByMinGrade(minGradeStr);
        } else if (!maxGradeStr.isEmpty()) {
            Log.d("Remove ALevel", "Deleting HEDiploma with MaxGrade: " + maxGradeStr);
            deleteALevelByMaxGrade(maxGradeStr);
        } else {
            Toast.makeText(this, "Please enter either ID or Max/Min Grades", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteALevelByMinGrade(String minGrade) {
        adminApi.removeALevelByMinGrade(minGrade).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(alevel_remove.this, "HEDiploma removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(alevel_remove.this, "Failed to remove HEDiploma", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(alevel_remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteALevelByMaxGrade(String maxGrade) {
        adminApi.removeALevelByMaxGrade(maxGrade).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(alevel_remove.this, "HEDiploma removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(alevel_remove.this, "Failed to remove HEDiploma", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(alevel_remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteALevelByALevelId(int alevelId) {
        adminApi.removeALevelByALevelID(alevelId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(alevel_remove.this, "HEDiploma removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(alevel_remove.this, "Failed to remove HEDiploma", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(alevel_remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
