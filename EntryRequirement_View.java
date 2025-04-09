package com.example.emeraldopendayapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class EntryRequirement_View extends AppCompatActivity {

    private String selectedID;
    private Spinner spinner;
    private EditText id, entryDetails;
    private TextView entryRequirementDetails;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_entry_requirement_view);

        spinner = findViewById(R.id.spinner3);
        id = findViewById(R.id.etPassword30);
        entryRequirementDetails = findViewById(R.id.textView19);
        Button viewButton = findViewById(R.id.button4);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.entryrequirementids, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedID = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedID = null;
            }
        });

        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        viewButton.setOnClickListener(v -> viewByID());
    }

    private void viewByID() {
        String idVal = id.getText().toString().trim();
        if (selectedID == null || idVal.isEmpty()) {
            Toast.makeText(this, "Please select both options first", Toast.LENGTH_SHORT).show();
            return;
        }
        int idValue = Integer.parseInt(idVal);

        switch (selectedID) {
            case "Entry Requirement ID":
                getByID(idValue);
                break;
            case "Degree ID":
                getByDegreeID(idValue);
                break;
            case "ALevel ID":
                getALevelID(idValue);
                break;
            case "BTEC ID":
                getBTECID(idValue);
                break;
            case "OCR ID":
                getOCRID(idValue);
                break;
            case "HEDiploma ID":
                getHEID(idValue);
                break;
        }
    }

    private void getByID(int id) {
        adminApi.getEntryRequirementByID(id).enqueue(new Callback<EntryRequirementResponse>() {
            @Override
            public void onResponse(Call<EntryRequirementResponse> call, Response<EntryRequirementResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    updateUI(response.body()); // FIXED: Single object response
                } else {
                    entryRequirementDetails.setText("Error: No Entry Requirements found for this Entry Requirement ID!");
                }
            }

            @Override
            public void onFailure(Call<EntryRequirementResponse> call, Throwable t) {
                entryRequirementDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void getByDegreeID(int id) {
        adminApi.getEntryRequirementByDegreeID(id).enqueue(new Callback<List<EntryRequirementResponse>>() {
            @Override
            public void onResponse(Call<List<EntryRequirementResponse>> call, Response<List<EntryRequirementResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    updateUIList(response.body()); // FIXED: List response
                } else {
                    entryRequirementDetails.setText("Error: No Entry Requirements found for this Degree ID!");
                }
            }

            @Override
            public void onFailure(Call<List<EntryRequirementResponse>> call, Throwable t) {
                entryRequirementDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void getALevelID(int id) {
        adminApi.getEntryRequirementByALevelID(id).enqueue(new Callback<List<EntryRequirementResponse>>() {
            @Override
            public void onResponse(Call<List<EntryRequirementResponse>> call, Response<List<EntryRequirementResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    updateUIList(response.body());
                } else {
                    entryRequirementDetails.setText("Error: No Entry Requirements found for this ALevel ID!");
                }
            }

            @Override
            public void onFailure(Call<List<EntryRequirementResponse>> call, Throwable t) {
                entryRequirementDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void getOCRID(int id) {
        adminApi.getEntryRequirementByOcrCaID(id).enqueue(new Callback<List<EntryRequirementResponse>>() {
            @Override
            public void onResponse(Call<List<EntryRequirementResponse>> call, Response<List<EntryRequirementResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    updateUIList(response.body());
                } else {
                    entryRequirementDetails.setText("Error: No Entry Requirements found for this OCR ID!");
                }
            }

            @Override
            public void onFailure(Call<List<EntryRequirementResponse>> call, Throwable t) {
                entryRequirementDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void getBTECID(int id) {
        adminApi.getEntryRequirementByBtecID(id).enqueue(new Callback<List<EntryRequirementResponse>>() {
            @Override
            public void onResponse(Call<List<EntryRequirementResponse>> call, Response<List<EntryRequirementResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    updateUIList(response.body());
                } else {
                    entryRequirementDetails.setText("Error: No Entry Requirements found for this BTEC ID!");
                }
            }

            @Override
            public void onFailure(Call<List<EntryRequirementResponse>> call, Throwable t) {
                entryRequirementDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void getHEID(int id) {
        adminApi.getEntryRequirementByHeDiplomaID(id).enqueue(new Callback<List<EntryRequirementResponse>>() {
            @Override
            public void onResponse(Call<List<EntryRequirementResponse>> call, Response<List<EntryRequirementResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    updateUIList(response.body());
                } else {
                    entryRequirementDetails.setText("Error: No Entry Requirements found for this HE Diploma ID!");
                }
            }

            @Override
            public void onFailure(Call<List<EntryRequirementResponse>> call, Throwable t) {
                entryRequirementDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void updateUI(EntryRequirementResponse entry) {
        String details = "Entry Requirement ID: " + entry.getRequirementID() +
                "\nDegree ID: " + entry.getDegreeER().getDegreeId() +
                "\nDegree Name: " + entry.getDegreeER().getDegreeName() +
                "\nALevel: " + entry.getALevel().getAlevelID() +
                "\nBTEC: " + entry.getBtec().getBTECID() +
                "\nOCR: " + entry.getOcr().getOcrCaID() +
                "\nHEDiploma: " + entry.getHeD().getHeID();

        entryRequirementDetails.setText(details);
    }

    private void updateUIList(List<EntryRequirementResponse> entries) {
        StringBuilder details = new StringBuilder();
        for (EntryRequirementResponse entry : entries) {
            details.append("Entry Requirement ID: ").append(entry.getRequirementID())
                    .append("\nDegree ID: ").append(entry.getDegreeER().getDegreeId())
                    .append("\nDegree Name: ").append(entry.getDegreeER().getDegreeName())
                    .append("\nALevel: ").append(entry.getALevel().getAlevelID())
                    .append("\nBTEC: ").append(entry.getBtec().getBTECID())
                    .append("\nOCR: ").append(entry.getOcr().getOcrCaID())
                    .append("\nHEDiploma: ").append(entry.getHeD().getHeID())
                    .append("\n\n");
        }
        entryRequirementDetails.setText(details.toString());
    }
}
