package com.example.hackathonchellenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;


public class agricultureActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    String[] countries = {"Select a Country", "China", "India", "USA"};
    int spinnerSelection;

    CheckBox checkbox_Contribution_to_GDP;
    CheckBox checkbox_Credit;
    CheckBox checkbox_Fertilizers;
    CheckBox checkbox_FertilizerProduction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agriculture_checkbox);

        spinner = (Spinner) findViewById(R.id.countrySpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(agricultureActivity.this,
                android.R.layout.simple_spinner_item, countries);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        checkbox_Contribution_to_GDP = (CheckBox) findViewById(R.id.checkbox_Contribution_to_GDP);
        Boolean checkbox_Contribution_to_GDPState = checkbox_Contribution_to_GDP.isChecked();//initiate a check box

        checkbox_Credit = (CheckBox) findViewById(R.id.checkbox_Credit);
        Boolean checkbox_CreditState = checkbox_Credit.isChecked();//initiate a check box

        checkbox_Fertilizers = (CheckBox) findViewById(R.id.checkbox_Fertilizers);
        Boolean checkbox_FertilizersState = checkbox_Fertilizers.isChecked();//initiate a check box

        checkbox_FertilizerProduction = (CheckBox) findViewById(R.id.checkbox_FertilizerProduction);
        Boolean checkbox_FertilizerProductionState = checkbox_FertilizerProduction.isChecked();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        spinnerSelection = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void AgricultureChart(View view) {
        Intent intent = new Intent(agricultureActivity.this, AgricultureChart.class);
        intent.putExtra("countrySelection", spinnerSelection);
        intent.putExtra("checkbox_Contribution_to_GDPState", checkbox_Contribution_to_GDP.isChecked());
        intent.putExtra("checkbox_CreditState", checkbox_Credit.isChecked());
        intent.putExtra("checkbox_FertilizersState", checkbox_Fertilizers.isChecked());
        intent.putExtra("checkbox_FertilizerProductionState", checkbox_FertilizerProduction.isChecked());
        startActivity(intent);
    }
}