package com.example.hackathonchellenge;

import androidx.appcompat.app.AppCompatActivity;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import android.content.Intent;
import android.util.MonthDisplayHelper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    String[] countries = {"Select a Country", "China", "India", "USA"};

    private SQLhelper sqlhelper;
    List<MacroeconomicsModel> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlhelper = new SQLhelper(MainActivity.this);
        SQLiteDatabase db = new SQLhelper(this).getWritableDatabase();
        InputStream csvFile = getResources().openRawResource(R.raw.macroeconomic);
        Log.e("LoadData", "Loading Macroeconomics Data into SqlLite DB");
        try {
            readDataFromCSV(csvFile);
            Log.e("Import", "Successfully Updated Database.");
        } catch (Exception e) {
            Log.e("Import", "Error in Uploading");
            e.printStackTrace();

        }
         modelList = ReaderController.getMacroEconomicsData(sqlhelper);

        spinner = (Spinner)findViewById(R.id.countrySpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,countries);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the third item gets selected
                break;
            case 3:
                // Whatever you want to happen when the fourth item gets selected
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void macroeconomicActivity(View view) {
        Intent intent = new Intent(MainActivity.this, macroeconomicActivity.class);
        startActivity(intent);
    }

    public void agricultureActivity(View view) {
        Intent intent = new Intent(MainActivity.this, agricultureActivity.class);
        startActivity(intent);
    }

    public void tradeActivity(View view) {
        Intent intent = new Intent(MainActivity.this, tradeActivity.class);
        startActivity(intent);
    }


    private void readDataFromCSV(InputStream csvFile) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(csvFile));
        String line = "";
        try {
            int k = 0;
            while ((line = buffer.readLine()) != null) {
                if(k==0){
                    k++;
                    continue;
                }
                String[] str = line.split(",", 16);
                sqlhelper.addCSVRowtoDB(str);
            }
        }
        catch (Exception e){
            Log.e("add data", "No able to add Data");
            e.printStackTrace();
        }

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