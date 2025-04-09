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

public class EntryRequirement_Remove extends AppCompatActivity {

    private EditText EntryRequirementIdInput, degreeInput, alevelInput, btecInput, ocrInput, heInput;
    private Button removeButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_requirement_remove);

        // Initialize API client
        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        // Find views
        EntryRequirementIdInput = findViewById(R.id.etPassword2);
        degreeInput = findViewById(R.id.etPassword21);
        alevelInput = findViewById(R.id.etPassword22);
        btecInput = findViewById(R.id.etPassword23);
        ocrInput = findViewById(R.id.etPassword24);
        heInput = findViewById(R.id.etPassword25);
        removeButton = findViewById(R.id.button4);

        // Button click listener
        removeButton.setOnClickListener(v -> removeEntryRequirement());
    }

    private void removeEntryRequirement() {
        String EntryRequirementId =EntryRequirementIdInput.getText().toString().trim();
        String degreeStr = degreeInput.getText().toString().trim();
        String alevelStr = alevelInput.getText().toString().trim();
        String btecStr = btecInput.getText().toString().trim();
        String ocrStr = ocrInput.getText().toString().trim();
        String heStr = heInput.getText().toString().trim();

        if (!EntryRequirementId.isEmpty()) {
            int modDegId = Integer.parseInt(EntryRequirementId);
            deleteEntryRequirementById(modDegId);
        } else if (!degreeStr.isEmpty()) {
            int degID = Integer.parseInt(degreeStr);
            deleteEntryRequirementByDegreeID(degID);
        } else if (!alevelStr.isEmpty()) {
            int alevelID = Integer.parseInt(alevelStr);
            deleteEntryRequirementByALevelID(alevelID);
        } else if (!btecStr.isEmpty()) {
            int btecID = Integer.parseInt(btecStr);
            deleteEntryRequirementByBTECID(btecID);
        } else if (!ocrStr.isEmpty()) {
            int ocrID = Integer.parseInt(ocrStr);
            deleteEntryRequirementByOCRID(ocrID);
        } else if (!heStr.isEmpty()) {
            int heID = Integer.parseInt(heStr);
            deleteEntryRequirementByHEID(heID);
        } else {
            Toast.makeText(this, "Please enter any ID", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteEntryRequirementById(int EntryRequirementId) {
        adminApi.deleteEntryRequirementByID(EntryRequirementId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(EntryRequirement_Remove.this, "Entry Requirement Degree removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(EntryRequirement_Remove.this, "Failed to remove Entry Requirement", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(EntryRequirement_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteEntryRequirementByDegreeID(Integer degreeID) {
        adminApi.deleteEntryRequirementByDegreeID(degreeID).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(EntryRequirement_Remove.this, "Entry Requirement removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(EntryRequirement_Remove.this, "Failed to remove Entry Requirement", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(EntryRequirement_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteEntryRequirementByALevelID(Integer alevelID) {
        adminApi.deleteEntryRequirementByALevelID(alevelID).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(EntryRequirement_Remove.this, "Entry Requirement removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(EntryRequirement_Remove.this, "Failed to remove Entry Requirement", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(EntryRequirement_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void deleteEntryRequirementByBTECID(Integer btecID) {
        adminApi.deleteEntryRequirementByBtecID(btecID).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(EntryRequirement_Remove.this, "Entry Requirement removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(EntryRequirement_Remove.this, "Failed to remove Entry Requirement", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(EntryRequirement_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteEntryRequirementByOCRID(Integer ocrID) {
        adminApi.deleteEntryRequirementByOcrCaID(ocrID).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(EntryRequirement_Remove.this, "Entry Requirement removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(EntryRequirement_Remove.this, "Failed to remove Entry Requirement", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(EntryRequirement_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteEntryRequirementByHEID(Integer heID) {
        adminApi.deleteEntryRequirementByHeDiplomaID(heID).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(EntryRequirement_Remove.this, "Entry Requirement removed successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(EntryRequirement_Remove.this, "Failed to remove Entry Requirement", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(EntryRequirement_Remove.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}