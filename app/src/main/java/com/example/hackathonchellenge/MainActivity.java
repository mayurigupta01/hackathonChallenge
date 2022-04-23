package com.example.hackathonchellenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    private SQLhelper sqlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlhelper = new SQLhelper(MainActivity.this);
        SQLiteDatabase db = new SQLhelper(this).getWritableDatabase();
        InputStream csvFile = getResources().openRawResource(R.raw.macroeconomic1);
        Log.e("LoadData", "Loading Macroeconomics Data into SqlLite DB");
        try {
            readDataFromCSV(csvFile);
            Log.e("Import", "Successfully Updated Database.");
        } catch (Exception e) {
            Log.e("Import", "Error in Uploading");
            e.printStackTrace();

        }


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

                System.out.println(Arrays.toString(str));
                String year = str[0].toString();
                String PerAnnualGDPGrowthIndia = str[1].toString();
                String PerAnnualGDPGrowthChina = str[2].toString();
                String PerAnnualGDPGrowthUSA = str[3].toString();
                String DollarGDPGrowthIndia = str[4].toString();
                String  DollarGDPGrowthChina = str[5].toString();
                String  DollarGDPGrowthUSA = str[6].toString();
                String  CurrentAccountBalanceChina = str[7].toString();
                String  CurrentAccountBalanceIndia = str[8].toString();
                String  CurrentAccountBalanceUSA = str[9].toString();
                String  FDIPercentGDPChina = str[10].toString();
                String  FDIPercentGDPIndia = str[11].toString();
                String  FDIPercentGDPUSA = str[12].toString();
                String  FDIOutflowDollarBOPChina = str[13].toString();
                String  FDIOutflowDollarBOPIndia = str[14].toString();
                String  FDIOutflowDollarBOPUSA = str[15].toString();
                sqlhelper.addCSVRowtoDB(year, PerAnnualGDPGrowthIndia, PerAnnualGDPGrowthChina, PerAnnualGDPGrowthUSA,
                        DollarGDPGrowthIndia, DollarGDPGrowthChina, DollarGDPGrowthUSA, CurrentAccountBalanceChina,
                        CurrentAccountBalanceIndia, CurrentAccountBalanceUSA, FDIPercentGDPChina, FDIPercentGDPIndia,
                        FDIPercentGDPUSA, FDIOutflowDollarBOPChina, FDIOutflowDollarBOPIndia, FDIOutflowDollarBOPUSA);



            }
        }
        catch (Exception e){
            Log.e("add data", "No able to add Data");
            e.printStackTrace();
        }

    }

}