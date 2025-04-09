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

public class Modules_View extends AppCompatActivity {

    private EditText inputModuleId, inputModuleName;
    private Button fetchButton;
    private TextView ModuleDetails;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules_view);

        inputModuleId = findViewById(R.id.etPassword2);
        inputModuleName = findViewById(R.id.etPassword10);
        fetchButton = findViewById(R.id.button4);
        ModuleDetails = findViewById(R.id.textView72);

        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        fetchButton.setOnClickListener(v -> fetchModule());
    }

    private void fetchModule() {
        String ModuleIdStr = inputModuleId.getText().toString().trim();
        String ModuleNameStr = inputModuleName.getText().toString().trim();

        if (!ModuleIdStr.isEmpty()) {
            int ModuleId = Integer.parseInt(ModuleIdStr);
            viewModuleById(ModuleId);
        } else if (!ModuleNameStr.isEmpty()) {
            viewModuleByName(ModuleNameStr);
        } else {
            Toast.makeText(this, "Please enter either Module ID or Module Name", Toast.LENGTH_SHORT).show();
        }
    }

    private void viewModuleById(int ModuleId) {
        adminApi.getModuleById(ModuleId).enqueue(new Callback<ModulesResponse>() {
            @Override
            public void onResponse(Call<ModulesResponse> call, Response<ModulesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ModulesResponse Module = response.body();
                    updateUI(Module);
                } else {
                    ModuleDetails.setText("Error: Module not found!");
                }
            }

            @Override
            public void onFailure(Call<ModulesResponse> call, Throwable t) {
                ModuleDetails.setText("Network error: " + t.getMessage());

            }
        });
    }

    private void viewModuleByName(String ModuleName) {
        adminApi.getModuleByName(ModuleName).enqueue(new Callback<ModulesResponse>() {
            @Override
            public void onResponse(Call<ModulesResponse> call, Response<ModulesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ModulesResponse Module = response.body();
                    updateUI(Module);

                } else {
                    ModuleDetails.setText("Error: Module not found!");
                }
            }

            @Override
            public void onFailure(Call<ModulesResponse> call, Throwable t) {
                ModuleDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void updateUI(ModulesResponse Module) {
        String details = "Module ID: " + Module.getModuleId() +
                "\nModule Name: " + Module.getModuleName() +
                "\nCredits: " + Module.getCredits();

        ModuleDetails.setText(details);
    }
}