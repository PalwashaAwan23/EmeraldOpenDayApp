package com.example.emeraldopendayapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.AlphabetIndexer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.checkerframework.checker.units.qual.C;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntryRequirement_Add extends AppCompatActivity {

    private EditText ucasPoints, degreeInput, alevelInput, btecInput, ocrInput, heInput;
    private Button submitButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_requirement_add);

        // Initialize API client
        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        // Find views
        ucasPoints = findViewById(R.id.ucasPointsInput);
        degreeInput = findViewById(R.id.degreeIDInput);
        alevelInput = findViewById(R.id.alevelIDInput);
        btecInput = findViewById(R.id.btecIDInput);
        ocrInput = findViewById(R.id.ocrIDInput);
        heInput = findViewById(R.id.heIDInput);
        submitButton = findViewById(R.id.addButton);

        // Button click listener
        submitButton.setOnClickListener(v -> fetchDataAndSubmit());
    }

    private void fetchDataAndSubmit() {
        String ucasString = ucasPoints.getText().toString().trim();
        if (ucasString.isEmpty()) {
            Toast.makeText(this, "Please enter UCAS points", Toast.LENGTH_SHORT).show();
            return;
        }
        int ucasPointsValue = Integer.parseInt(ucasString);

        int degreeID = getIntFromEditText(degreeInput);
        int alevelID = getIntFromEditText(alevelInput);
        int btecID = getIntFromEditText(btecInput);
        int ocrID = getIntFromEditText(ocrInput);
        int heID = getIntFromEditText(heInput);

        // Fetch all required data asynchronously
        fetchDegree(degreeID, degree ->
                fetchALevel(alevelID, alevel ->
                        fetchBTEC(btecID, btec ->
                                fetchOCR(ocrID, ocr ->
                                        fetchHEDiploma(heID, hediploma ->
                                                submitEntryRequirement(ucasPointsValue, degree, alevel, btec, ocr, hediploma)
                                        )
                                )
                        )
                )
        );
    }

    private void submitEntryRequirement(int ucasPoints, DegreeResponse degree, ALevelResponse alevel, BTECResponse btec, OCRResponse ocr, HEDiplomaResponse hediploma) {
        EntryRequirementResponse entryRequirement = new EntryRequirementResponse(null, ucasPoints, degree, alevel, btec, ocr, hediploma);

        adminApi.addEntryRequirement(entryRequirement).enqueue(new Callback<EntryRequirementResponse>() {
            @Override
            public void onResponse(Call<EntryRequirementResponse> call, Response<EntryRequirementResponse> response) {
                Toast.makeText(EntryRequirement_Add.this, "Entry Requirement Added", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<EntryRequirementResponse> call, Throwable t) {
                Toast.makeText(EntryRequirement_Add.this, "Error Adding Entry Requirement", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Helper method to safely get integer values from EditText
    private int getIntFromEditText(EditText editText) {
        String text = editText.getText().toString().trim();
        if (text.isEmpty()) return -1; // Return -1 if empty
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input: " + editText.getHint(), Toast.LENGTH_SHORT).show();
            return -1;
        }
    }

    private void fetchDegree(int degreeID, OnFetchComplete<DegreeResponse> callback) {
        if (degreeID == -1) {
            callback.onFetchComplete(null);
            return;
        }

        adminApi.getDegreeById(degreeID).enqueue(new Callback<DegreeResponse>() {
            @Override
            public void onResponse(Call<DegreeResponse> call, Response<DegreeResponse> response) {
                callback.onFetchComplete(response.isSuccessful() ? response.body() : null);
            }

            @Override
            public void onFailure(Call<DegreeResponse> call, Throwable t) {
                Log.e("Degree Fetch", "Failed: " + t.getMessage());
                callback.onFetchComplete(null);
            }
        });
    }

    private void fetchALevel(int alevelID, OnFetchComplete<ALevelResponse> callback) {
        if (alevelID == -1) {
            callback.onFetchComplete(null);
            return;
        }

        adminApi.getAlevelById(alevelID).enqueue(new Callback<ALevelResponse>() {
            @Override
            public void onResponse(Call<ALevelResponse> call, Response<ALevelResponse> response) {
                callback.onFetchComplete(response.isSuccessful() ? response.body() : null);
            }

            @Override
            public void onFailure(Call<ALevelResponse> call, Throwable t) {
                Log.e("Alevel Fetch", "Failed: " + t.getMessage());
                callback.onFetchComplete(null);
            }
        });
    }

    private void fetchBTEC(int btecID, OnFetchComplete<BTECResponse> callback) {
        if (btecID == -1) {
            callback.onFetchComplete(null);
            return;
        }

        adminApi.getBTECById(btecID).enqueue(new Callback<BTECResponse>() {
            @Override
            public void onResponse(Call<BTECResponse> call, Response<BTECResponse> response) {
                callback.onFetchComplete(response.isSuccessful() ? response.body() : null);
            }

            @Override
            public void onFailure(Call<BTECResponse> call, Throwable t) {
                Log.e("BTEC Fetch", "Failed: " + t.getMessage());
                callback.onFetchComplete(null);
            }
        });
    }

    private void fetchOCR(int ocrID, OnFetchComplete<OCRResponse> callback) {
        if (ocrID == -1) {
            callback.onFetchComplete(null);
            return;
        }

        adminApi.getOCRById(ocrID).enqueue(new Callback<OCRResponse>() {
            @Override
            public void onResponse(Call<OCRResponse> call, Response<OCRResponse> response) {
                callback.onFetchComplete(response.isSuccessful() ? response.body() : null);
            }

            @Override
            public void onFailure(Call<OCRResponse> call, Throwable t) {
                Log.e("OCR Fetch", "Failed: " + t.getMessage());
                callback.onFetchComplete(null);
            }
        });
    }

    private void fetchHEDiploma(int heID, OnFetchComplete<HEDiplomaResponse> callback) {
        if (heID == -1) {
            callback.onFetchComplete(null);
            return;
        }

        adminApi.getHEById(heID).enqueue(new Callback<HEDiplomaResponse>() {
            @Override
            public void onResponse(Call<HEDiplomaResponse> call, Response<HEDiplomaResponse> response) {
                callback.onFetchComplete(response.isSuccessful() ? response.body() : null);
            }

            @Override
            public void onFailure(Call<HEDiplomaResponse> call, Throwable t) {
                Log.e("HEDiploma Fetch", "Failed: " + t.getMessage());
                callback.onFetchComplete(null);
            }
        });
    }

    // Callback Interface for Asynchronous Fetching
    interface OnFetchComplete<T> {
        void onFetchComplete(T result);
    }
}
