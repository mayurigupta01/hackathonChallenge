package com.example.hackathonchellenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class macroeconomicActivity extends AppCompatActivity {

    public  SQLhelper sqlhelper;
    ArrayList<MacroeconomicsModel> macroEconomics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_macroeconomic);

        macroEconomics = sqlhelper.readMacroeconomicsData();
        System.out.println(macroEconomics.toString());
        Pie pie = AnyChart.pie();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("John", 10000));
        data.add(new ValueDataEntry("Jake", 12000));
        data.add(new ValueDataEntry("Peter", 18000));
        pie.data(data);

        showIndiaData();

        AnyChartView anyChartView = (AnyChartView) findViewById(R.id.any_chart_view);
        anyChartView.setChart(pie);

        setContentView(R.layout.macroeconomy_checkbox);

        CheckBox checkbox_GDP = (CheckBox) findViewById(R.id.checkbox_GDP);
        Boolean checkbox_GDPState = checkbox_GDP.isChecked();//initiate a check box

        CheckBox checkbox_FDIInflowUSD = (CheckBox) findViewById(R.id.checkbox_FDIInflowUSD);
        Boolean checkbox_FDIInflowUSDState = checkbox_FDIInflowUSD.isChecked();//initiate a check box

        CheckBox checkbox_FDIOutflowUSD = (CheckBox) findViewById(R.id.checkbox_FDIOutflowUSD);
        Boolean checkbox_FDIOutflowUSDState = checkbox_FDIOutflowUSD.isChecked();//initiate a check box

        CheckBox checkbox_ImportExportFlow = (CheckBox) findViewById(R.id.checkbox_ImportExportFlow);
        Boolean checkbox_ImportExportFlowUSState = checkbox_ImportExportFlow.isChecked();

//        Pie pie = AnyChart.pie();
//
//        List<DataEntry> data = new ArrayList<>();
//        data.add(new ValueDataEntry("John", 10000));
//        data.add(new ValueDataEntry("Jake", 12000));
//        data.add(new ValueDataEntry("Peter", 18000));
//
//        pie.data(data);
//
//        AnyChartView anyChartView = (AnyChartView) findViewById(R.id.any_chart_view);
//        anyChartView.setChart(pie);

    }



    public void showIndiaData() {
        for (int i = 0; i < macroEconomics.size(); i++) {
            System.out.println(macroEconomics.get(i).getYear());
            System.out.println(macroEconomics.get(i).getCurrentAccountBalanceIndia());

        }
    }

    public void showUSAData(){

    }

    public void showChinaData(){


    }
}