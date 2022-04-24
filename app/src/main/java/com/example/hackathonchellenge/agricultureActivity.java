package com.example.hackathonchellenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class agricultureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agriculture_checkbox);



        CheckBox checkbox_Contribution_to_GDP = (CheckBox) findViewById(R.id.checkbox_Contribution_to_GDP);
        Boolean checkbox_Contribution_to_GDPState = checkbox_Contribution_to_GDP.isChecked();//initiate a check box

        CheckBox checkbox_Credit = (CheckBox) findViewById(R.id.checkbox_Credit);
        Boolean checkbox_CreditState = checkbox_Credit.isChecked();//initiate a check box

        CheckBox checkbox_Fertilizers = (CheckBox) findViewById(R.id.checkbox_Fertilizers);
        Boolean checkbox_FertilizersState = checkbox_Fertilizers.isChecked();//initiate a check box

        CheckBox checkbox_FertilizerProduction = (CheckBox) findViewById(R.id.checkbox_FertilizerProduction);
        Boolean checkbox_FertilizerProductionState = checkbox_FertilizerProduction.isChecked();



    }
    public void AgricultureChart(View view) {
        Intent intent = new Intent(agricultureActivity.this, AgricultureChart.class);
        startActivity(intent);
    }
}