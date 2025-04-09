package com.example.emeraldopendayapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class db_control_panel extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String selectedTable;
    private String selectedTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        Spinner spinner2 = findViewById(R.id.spinner2);
        Button continueButton = findViewById(R.id.button4);

        // Adapter for table names
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.table_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        // Adapter for task names
        ArrayAdapter<CharSequence> taskAdapter = ArrayAdapter.createFromResource(
                this, R.array.task_names, android.R.layout.simple_spinner_item);
        taskAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(taskAdapter);
        spinner2.setOnItemSelectedListener(this);

        // Set default selections
        selectedTable = spinner.getSelectedItem().toString();
        selectedTask = spinner2.getSelectedItem().toString();

        // Handle continue button click
        continueButton.setOnClickListener(v -> navigateToPage());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinner) {
            selectedTable = parent.getItemAtPosition(position).toString();
        } else if (parent.getId() == R.id.spinner2) {
            selectedTask = parent.getItemAtPosition(position).toString();
        }

        Log.d("db_control_panel", "Selected Table: " + selectedTable);
        Log.d("db_control_panel", "Selected Task: " + selectedTask);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // No action needed
    }

    private void navigateToPage() {
        Log.d("db_control_panel", "Navigating with: " + selectedTable + ", " + selectedTask);

        if (selectedTable == null || selectedTask == null || selectedTable.isEmpty() || selectedTask.isEmpty()) {
            Toast.makeText(this, "Please select both options first", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = null;

        if (selectedTable.equals("ALevel") && selectedTask.equals("Add")) {
            intent = new Intent(this, alevel_add.class);
        } else if (selectedTable.equals("ALevel") && selectedTask.equals("Remove")) {
            intent = new Intent(this, alevel_remove.class);
        } else if (selectedTable.equals("ALevel") && selectedTask.equals("View")) {
            intent = new Intent(this, alevel_view.class);
        } else if (selectedTable.equals("BTECExDipl") && selectedTask.equals("Add")) {
            intent = new Intent(this, BTECExDipl_Add.class);
        } else if (selectedTable.equals("BTECExDipl") && selectedTask.equals("Remove")) {
            intent = new Intent(this, BTECExDipl_Remove.class);
        } else if (selectedTable.equals("BTECExDipl") && selectedTask.equals("View")) {
            intent = new Intent(this, BTECExDipl_View.class);
        } else if (selectedTable.equals("CambrExDip") && selectedTask.equals("Add")) {
            intent = new Intent(this, CambrExDip_Add.class);
        } else if (selectedTable.equals("CambrExDip") && selectedTask.equals("Remove")) {
            intent = new Intent(this, CambrExDip_Remove.class);
        } else if (selectedTable.equals("CambrExDip") && selectedTask.equals("View")) {
            intent = new Intent(this, CambrExDip_View.class);
        } else if (selectedTable.equals("CareerDegree") && selectedTask.equals("Add")) {
            intent = new Intent(this, CareerDegree_Add.class);
        } else if (selectedTable.equals("CareerDegree") && selectedTask.equals("Remove")) {
            intent = new Intent(this, CareerDegree_Remove.class);
        } else if (selectedTable.equals("CareerDegree") && selectedTask.equals("View")) {
            intent = new Intent(this, CareerDegree_View.class);
        } else if (selectedTable.equals("CareerInfo") && selectedTask.equals("Add")) {
            intent = new Intent(this, CareerInfo_Add.class);
        } else if (selectedTable.equals("CareerInfo") && selectedTask.equals("Remove")) {
            intent = new Intent(this, CareerInfo_Remove.class);
        } else if (selectedTable.equals("CareerInfo") && selectedTask.equals("View")) {
            intent = new Intent(this, CareerInfo_View.class);
        } else if (selectedTable.equals("Degree") && selectedTask.equals("Add")) {
            intent = new Intent(this, Degree_Add.class);
        } else if (selectedTable.equals("Degree") && selectedTask.equals("Remove")) {
            intent = new Intent(this, Degree_Remove.class);
        } else if (selectedTable.equals("Degree") && selectedTask.equals("View")) {
            intent = new Intent(this, Degree_View.class);
        } else if (selectedTable.equals("EntryRequirement") && selectedTask.equals("Add")) {
            intent = new Intent(this, EntryRequirement_Add.class);
        } else if (selectedTable.equals("EntryRequirement") && selectedTask.equals("Remove")) {
            intent = new Intent(this, EntryRequirement_Remove.class);
        } else if (selectedTable.equals("EntryRequirement") && selectedTask.equals("View")) {
            intent = new Intent(this, EntryRequirement_View.class);
        } else if (selectedTable.equals("HEDiploma") && selectedTask.equals("Add")) {
            intent = new Intent(this, HEDiploma_Add.class);
        } else if (selectedTable.equals("HEDiploma") && selectedTask.equals("Remove")) {
            intent = new Intent(this, HEDiploma_Remove.class);
        } else if (selectedTable.equals("HEDiploma") && selectedTask.equals("View")) {
            intent = new Intent(this, HEDiploma_View.class);
        } else if (selectedTable.equals("ModuleDegree") && selectedTask.equals("Add")) {
            intent = new Intent(this, ModuleDegree_Add.class);
        } else if (selectedTable.equals("ModuleDegree") && selectedTask.equals("Remove")) {
            intent = new Intent(this, ModuleDegree_Remove.class);
        } else if (selectedTable.equals("ModuleDegree") && selectedTask.equals("View")) {
            intent = new Intent(this, ModuleDegree_View.class);
        } else if (selectedTable.equals("Modules") && selectedTask.equals("Add")) {
            intent = new Intent(this, Modules_Add.class);
        } else if (selectedTable.equals("Modules") && selectedTask.equals("Remove")) {
            intent = new Intent(this, Module_Remove.class);
        } else if (selectedTable.equals("Modules") && selectedTask.equals("View")) {
            intent = new Intent(this, Modules_View.class);
        }


        if (intent != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid selection", Toast.LENGTH_SHORT).show();
        }
    }
}
