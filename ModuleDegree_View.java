package com.example.emeraldopendayapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModuleDegree_View extends AppCompatActivity {

    private EditText inputModuleDegreeId, inputDegreeId, inputModuleId;
    private Button fetchButton;
    private TextView ModuleDegreeDetails;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_degree_view);


        inputModuleDegreeId = findViewById(R.id.etPassword2);
        inputDegreeId = findViewById(R.id.etPassword15);
        inputModuleId = findViewById(R.id.etPassword16);
        fetchButton = findViewById(R.id.button4);
        ModuleDegreeDetails = findViewById(R.id.textView74);


        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        fetchButton.setOnClickListener(v -> fetchModuleDegree());
    }

    private void fetchModuleDegree() {
        String ModuleDegreeIdStr = inputModuleDegreeId.getText().toString().trim();
        String DegreeStr = inputDegreeId.getText().toString().trim();
        String ModuleStr = inputModuleId.getText().toString().trim();

        if (!ModuleDegreeIdStr.isEmpty()) {
            int ModuleDegreeId = Integer.parseInt(ModuleDegreeIdStr);
            viewModuleDegreeById(ModuleDegreeId);
        } else if (!DegreeStr.isEmpty()) {
            int DegID = Integer.parseInt(DegreeStr);
            viewModuleDegreeByDegreeID(DegID);
        } else if (!ModuleStr.isEmpty()) {
            int ModID = Integer.parseInt(ModuleStr);
            viewModuleDegreeByModuleID(ModID);
        } else {
            Toast.makeText(this, "Please enter either Module Degree ID, Degree ID, or Module ID", Toast.LENGTH_SHORT).show();
        }
    }

    private void viewModuleDegreeById(int moduleDegreeID) {
        adminApi.getModulesDegreeByID(moduleDegreeID).enqueue(new Callback<ModuleDegreeResponse>() {
            @Override
            public void onResponse(Call<ModuleDegreeResponse> call, Response<ModuleDegreeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    updateUI(response.body());
                } else {
                    ModuleDegreeDetails.setText("Error: Module Degree not found!");
                }
            }

            @Override
            public void onFailure(Call<ModuleDegreeResponse> call, Throwable t) {
                ModuleDegreeDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void viewModuleDegreeByDegreeID(int DegreeID) {
        adminApi.getModulesDegreeByDegreeID(DegreeID).enqueue(new Callback<List<ModuleDegreeResponse>>() { // FIXED: Using List
            @Override
            public void onResponse(Call<List<ModuleDegreeResponse>> call, Response<List<ModuleDegreeResponse>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    updateUIList(response.body());
                } else {
                    ModuleDegreeDetails.setText("Error: No Module Degrees found for this Degree ID!");
                }
            }

            @Override
            public void onFailure(Call<List<ModuleDegreeResponse>> call, Throwable t) {
                ModuleDegreeDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void viewModuleDegreeByModuleID(int ModuleID) {
        adminApi.getModulesDegreeByModuleID(ModuleID).enqueue(new Callback<List<ModuleDegreeResponse>>() { // FIXED: Using List
            @Override
            public void onResponse(Call<List<ModuleDegreeResponse>> call, Response<List<ModuleDegreeResponse>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    updateUIList(response.body());
                } else {
                    ModuleDegreeDetails.setText("Error: No Module Degrees found for this Module ID!");
                }
            }

            @Override
            public void onFailure(Call<List<ModuleDegreeResponse>> call, Throwable t) {
                ModuleDegreeDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void updateUI(ModuleDegreeResponse Module) {
        String details = "Module Degree ID: " + Module.getModuleDegreeID() +
                "\nDegree ID: " + Module.getDegreeMDId().getDegreeId() +
                "\nDegree Name: " + Module.getDegreeMDId().getDegreeName() +
                "\nModule ID: " + Module.getModuleMDId().getModuleId() +
                "\nModule Name: " + Module.getModuleMDId().getModuleName();

        ModuleDegreeDetails.setText(details);
    }

    private void updateUIList(List<ModuleDegreeResponse> modules) {
        StringBuilder details = new StringBuilder();
        for (ModuleDegreeResponse Module : modules) {
            details.append("Module Degree ID: ").append(Module.getModuleDegreeID())
                    .append("\nDegree ID: ").append(Module.getDegreeMDId().getDegreeId())
                    .append("\nDegree Name: ").append(Module.getDegreeMDId().getDegreeName())
                    .append("\nModule ID: ").append(Module.getModuleMDId().getModuleId())
                    .append("\nModule Name: ").append(Module.getModuleMDId().getModuleName())
                    .append("\n\n");
        }
        ModuleDegreeDetails.setText(details.toString());
    }
}
