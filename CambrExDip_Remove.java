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

public class CambrExDip_Remove extends AppCompatActivity {

    private EditText maxGradeInput, minGradeInput, OcrIdInput;
    private Button removeButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambr_ex_dip_remove);

        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        minGradeInput = findViewById(R.id.etPassword3);
        maxGradeInput = findViewById(R.id.etPassword4);
        OcrIdInput = findViewById(R.id.etPassword2);
        removeButton = findViewById(R.id.button4);

        removeButton.setOnClickListener(v -> removeOCR());
    }

    private void removeOCR() {
        String minGradeStr = minGradeInput.getText().toString().trim();
        String maxGradeStr = maxGradeInput.getText().toString().trim();
        String OcrIdStr = OcrIdInput.getText().toString().trim();

        if (!OcrIdStr.isEmpty()) {
            int ocrId = Integer.parseInt(OcrIdStr);
            Log.d("Remove OCR", "Deleting OCR with ID: " + ocrId);
            deleteOCRByOCRId(ocrId);
        } else if (!minGradeStr.isEmpty()) {
            Log.d("Remove OCR", "Deleting OCR with MinGrade: " + minGradeStr);
            deleteOCRByMinGrade(minGradeStr);
        } else if (!maxGradeStr.isEmpty()) {
            Log.d("Remove OCR", "Deleting OCR with MaxGrade: " + maxGradeStr);
            deleteOCRByMaxGrade(maxGradeStr);
        } else {
            Toast.makeText(this, "Please enter either ID or Max/Min Grades", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteOCRByMinGrade(String minGrade) {
        adminApi.removeOCRByMinGrade(minGrade).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CambrExDip_Remove.this, "OCR removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(CambrExDip_Remove.this, "Failed to remove BTEC", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(CambrExDip_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteOCRByMaxGrade(String maxGrade) {
        adminApi.removeOCRByMaxGrade(maxGrade).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CambrExDip_Remove.this, "OCR removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(CambrExDip_Remove.this, "Failed to remove OCR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(CambrExDip_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteOCRByOCRId(int btecID) {
        adminApi.removeOCRById(btecID).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CambrExDip_Remove.this, "OCR removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(CambrExDip_Remove.this, "Failed to remove OCR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(CambrExDip_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}