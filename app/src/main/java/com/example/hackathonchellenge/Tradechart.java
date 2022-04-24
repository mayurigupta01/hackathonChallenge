package com.example.hackathonchellenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Tradechart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tradechart);
    }


    private List<TradeModel> list_my = MainActivity.tradeList;

    public List<Double> showIndiaReserve() {
        List<Double> gdpGrowthDataIndia = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            Double value = Double.parseDouble(list_my.get(i).reservesIndia);
            gdpGrowthDataIndia.add(value);
        }
        return gdpGrowthDataIndia;
    }

    public List<Double> showChinaReserve() {
        List<Double> gdpGrowthDataChina = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            Double value = Double.parseDouble(list_my.get(i).reservesChina);
            gdpGrowthDataChina.add(value);
        }

        return gdpGrowthDataChina;
    }

    public List<Double> showUSAReserve() {
        List<Double> gdpGrowthUSA = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            Double value = Double.parseDouble(list_my.get(i).reservesUSA);
            gdpGrowthUSA.add(value);
        }
        return gdpGrowthUSA;
    }

    public List<Double> debitChina() {
        List<Double> FDIInflowIndia = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            Double value = Double.parseDouble(list_my.get(i).debtChina);
            FDIInflowIndia.add(value);
        }
        return FDIInflowIndia;
    }

    public List<Double> debitIndia() {
        List<Double> FDIInflowChina = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            if (list_my.get(i) != null) {
                Double value = Double.parseDouble(list_my.get(i).debtIndia);
                FDIInflowChina.add(value);
            }
        }
        return FDIInflowChina;
    }

    public List<Double> debitUSA() {
        List<Double> FDIInflowUSA = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            if (list_my.get(i) != null) {
                Double value = Double.parseDouble(list_my.get(i).debtUSA);
                FDIInflowUSA.add(value);
            }
        }
        return FDIInflowUSA;

    }

    public List<Double> GNIChina() {
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            if (list_my.get(i) != null) {
                Double value = Double.parseDouble(list_my.get(i).GNIChina);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }

    public List<Double> GNIIndia() {
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            if (list_my.get(i) != null) {
                Double value = Double.parseDouble(list_my.get(i).GNIIndia);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }

    public List<Double> GNIUSA() {
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            if (list_my.get(i) != null) {
                Double value = Double.parseDouble(list_my.get(i).GNIUSA);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }


    public List<Double> CurrentGNIChina() {
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            if (list_my.get(i) != null) {
                Double value = Double.parseDouble(list_my.get(i).CurrentGNIChina);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }

    public List<Double> CurrentGNIIndia() {
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            if (list_my.get(i) != null) {
                Double value = Double.parseDouble(list_my.get(i).CurrentGNIIndia);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }

    public List<Double> CurrentGNIUSA() {
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            if (list_my.get(i) != null) {
                Double value = Double.parseDouble(list_my.get(i).CurrentGNIUSA);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }

}