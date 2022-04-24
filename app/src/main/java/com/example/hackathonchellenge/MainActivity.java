package com.example.hackathonchellenge;

import androidx.appcompat.app.AppCompatActivity;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
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


public class MainActivity extends AppCompatActivity {

    private SQLhelper sqlhelper;
    static List<MacroeconomicsModel> modelList;

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



}