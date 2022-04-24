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

    public  SQLhelper sqlhelper;
    List<MacroeconomicsModel> modelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_macroeconomic);

        Pie pie = AnyChart.pie();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("John", 10000));
        data.add(new ValueDataEntry("Jake", 12000));
        data.add(new ValueDataEntry("Peter", 18000));
        pie.data(data);

        modelList = ReaderController.getMacroEconomicsData(sqlhelper);

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

    }

    public void macroeconomicActivity(View view) {
        Intent intent = new Intent(macroeconomicActivity.this, MacroeconomyChart.class);
        startActivity(intent);

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

    public  List<Double> showIndiaGDPData(){
        List<Double> gdpGrowthDataIndia = new ArrayList<>();
        for(int i = 0 ; i<modelList.size() ; i++){
            Double value = Double.parseDouble(modelList.get(i).PerAnnualGDPGrowthIndia);
            gdpGrowthDataIndia.add(value);
        }
        return gdpGrowthDataIndia;
    }


    public List<Double> showChinaGDPData(){
        List<Double> gdpGrowthDataChina = new ArrayList<>();
        for(int i = 0 ; i<modelList.size() ; i++){
            Double value = Double.parseDouble(modelList.get(i).PerAnnualGDPGrowthChina);
            gdpGrowthDataChina.add(value);
        }

        return gdpGrowthDataChina;
    }

    public List<Double> showUSAGDPData(){
        List<Double> gdpGrowthUSA = new ArrayList<>();
        for(int i = 0 ; i<modelList.size() ; i++){
            Double value = Double.parseDouble(modelList.get(i).PerAnnualGDPGrowthUSA);
            gdpGrowthUSA.add(value);
        }
        return gdpGrowthUSA;
    }

    public List<Double> FDIInflowIndiaGDPData(){
        List<Double> FDIInflowIndia = new ArrayList<>();
        for(int i = 0 ; i<modelList.size() ; i++){
            Double value = Double.parseDouble(modelList.get(i).FDIPercentGDPIndia);
            FDIInflowIndia.add(value);
        }
        return FDIInflowIndia;
    }

    public List<Double> FDIInflowChinaGDPData(){
        List<Double> FDIInflowChina = new ArrayList<>();
        for(int i = 0 ; i<modelList.size() ; i++){
            if(modelList.get(i)!=null) {
                Double value = Double.parseDouble(modelList.get(i).FDIPercentGDPChina);
                FDIInflowChina.add(value);
            }
        }
        return FDIInflowChina;
    }

    public List<Double> FDIInflowUSAGDPData(){
        List<Double> FDIInflowUSA = new ArrayList<>();
        for(int i = 0 ; i<modelList.size() ; i++){
            if(modelList.get(i)!=null) {
                Double value = Double.parseDouble(modelList.get(i).FDIPercentGDPUSA);
                FDIInflowUSA.add(value);
            }
        }
        return FDIInflowUSA;


    }


    public List<Double> FDIOutflowIndiaGDPData(){
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for(int i = 0 ; i<modelList.size() ; i++){
            if(modelList.get(i)!=null) {
                Double value = Double.parseDouble(modelList.get(i).FDIOutflowDollarBOPIndia);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }

    public List<Double> FDIOutflowChinaGDPData(){
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for(int i = 0 ; i<modelList.size() ; i++){
            if(modelList.get(i)!=null) {
                Double value = Double.parseDouble(modelList.get(i).FDIOutflowDollarBOPChina);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }

    public List<Double> FDIOutflowUSAGDPData(){
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for(int i = 0 ; i<modelList.size() ; i++){
            if(modelList.get(i)!=null) {
                Double value = Double.parseDouble(modelList.get(i).FDIOutflowDollarBOPUSA);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }

}