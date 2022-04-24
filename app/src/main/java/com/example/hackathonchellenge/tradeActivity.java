package com.example.hackathonchellenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

public class tradeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    String[] countries = {"Select a Country", "China", "India", "USA"};
    int spinnerSelection;

    CheckBox checkbox_Reserve;
    CheckBox checkbox_GNI;
    CheckBox checkbox_Total_Debt;
    CheckBox checkbox_GNICurrentUS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trade_checkbox);

        spinner = (Spinner)findViewById(R.id.countrySpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(tradeActivity.this,
                android.R.layout.simple_spinner_item,countries);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        checkbox_Reserve = (CheckBox) findViewById(R.id.checkbox_Reserve);
        Boolean checkbox_ReserveState = checkbox_Reserve.isChecked();//initiate a check box

        checkbox_GNI = (CheckBox) findViewById(R.id.checkbox_GNI);
        Boolean checkbox_GNIState = checkbox_GNI.isChecked();//initiate a check box

        checkbox_Total_Debt = (CheckBox) findViewById(R.id.checkbox_Total_Debt);
        Boolean checkbox_Total_DebtState = checkbox_Total_Debt.isChecked();//initiate a check box

        checkbox_GNICurrentUS = (CheckBox) findViewById(R.id.checkbox_GNICurrentUS);
        Boolean checkbox_GNICurrentUSState = checkbox_GNICurrentUS.isChecked();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        spinnerSelection = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void tradeActivity(View view) {
        Intent intent = new Intent(tradeActivity.this, Tradechart.class);
        intent.putExtra("countrySelection", spinnerSelection);
        intent.putExtra("checkbox_Reserve", checkbox_Reserve.isChecked());
        intent.putExtra("checkbox_GNI", checkbox_GNI.isChecked());
        intent.putExtra("checkbox_Total_Debt", checkbox_Total_Debt.isChecked());
        intent.putExtra("checkbox_GNICurrentUS", checkbox_GNICurrentUS.isChecked());
        startActivity(intent);
    }
}