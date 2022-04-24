package com.example.hackathonchellenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class macroeconomicActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    String[] countries = {"Select a Country", "China", "India", "USA"};
    int spinnerSelection;

    CheckBox checkbox_GDP;
    CheckBox checkbox_FDIInflowUSD;
    CheckBox checkbox_FDIOutflowUSD;
    CheckBox checkbox_ImportExportFlow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.macroeconomy_checkbox);

        spinner = (Spinner)findViewById(R.id.countrySpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(macroeconomicActivity.this,
                android.R.layout.simple_spinner_item,countries);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        checkbox_GDP = (CheckBox) findViewById(R.id.checkbox_GDP);
        Boolean checkbox_GDPState = checkbox_GDP.isChecked();//initiate a check box

        checkbox_FDIInflowUSD = (CheckBox) findViewById(R.id.checkbox_FDIInflowUSD);
        Boolean checkbox_FDIInflowUSDState = checkbox_FDIInflowUSD.isChecked();//initiate a check box

        checkbox_FDIOutflowUSD = (CheckBox) findViewById(R.id.checkbox_FDIOutflowUSD);
        Boolean checkbox_FDIOutflowUSDState = checkbox_FDIOutflowUSD.isChecked();//initiate a check box

        checkbox_ImportExportFlow = (CheckBox) findViewById(R.id.checkbox_ImportExportFlow);
        Boolean checkbox_ImportExportFlowUSState = checkbox_ImportExportFlow.isChecked();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        spinnerSelection = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void macroeconomicChart(View view) {
        Intent intent = new Intent(macroeconomicActivity.this, MacroeconomyChart.class);
        intent.putExtra("countrySelection", spinnerSelection);
        intent.putExtra("checkbox_GDP", checkbox_GDP.isChecked());
        intent.putExtra("checkbox_FDIInflowUSD", checkbox_FDIInflowUSD.isChecked());
        intent.putExtra("checkbox_FDIOutflowUSD", checkbox_FDIOutflowUSD.isChecked());
        intent.putExtra("checkbox_ImportExportFlow", checkbox_ImportExportFlow.isChecked());
        startActivity(intent);
    }
}