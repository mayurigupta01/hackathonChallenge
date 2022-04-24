package com.example.hackathonchellenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class macroeconomicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.macroeconomy_checkbox);

        CheckBox checkbox_GDP = (CheckBox) findViewById(R.id.checkbox_GDP);
        Boolean checkbox_GDPState = checkbox_GDP.isChecked();//initiate a check box

        CheckBox checkbox_FDIInflowUSD = (CheckBox) findViewById(R.id.checkbox_FDIInflowUSD);
        Boolean checkbox_FDIInflowUSDState = checkbox_FDIInflowUSD.isChecked();//initiate a check box

        CheckBox checkbox_FDIOutflowUSD = (CheckBox) findViewById(R.id.checkbox_FDIOutflowUSD);
        Boolean checkbox_FDIOutflowUSDState = checkbox_FDIOutflowUSD.isChecked();//initiate a check box

        CheckBox checkbox_ImportExportFlow = (CheckBox) findViewById(R.id.checkbox_ImportExportFlow);
        Boolean checkbox_ImportExportFlowUSState = checkbox_ImportExportFlow.isChecked();

    }

    public void macroeconomicActivity(View view) {
        Intent intent = new Intent(macroeconomicActivity.this, MacroeconomyChart.class);
        startActivity(intent);
    }
}