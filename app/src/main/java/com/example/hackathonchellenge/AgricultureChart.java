package com.example.hackathonchellenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class AgricultureChart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agriculture_chart);

        }

    private List<AgricultureModel> list_my = MainActivity.agriList;

    public List<Double> showIndiaGDPData() {
        List<Double> gdpGrowthDataIndia = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            Double value = Double.parseDouble(list_my.get(i).PerAFFGDPChina);
            gdpGrowthDataIndia.add(value);
        }
        return gdpGrowthDataIndia;
    }

    public List<Double> showChinaGDPData() {
        List<Double> gdpGrowthDataChina = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            Double value = Double.parseDouble(list_my.get(i).PerAFFGDPChina);
            gdpGrowthDataChina.add(value);
        }

        return gdpGrowthDataChina;
    }

    public List<Double> showUSAGDPData() {
        List<Double> gdpGrowthUSA = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            Double value = Double.parseDouble(list_my.get(i).PerAFFGDPUSA);
            gdpGrowthUSA.add(value);
        }
        return gdpGrowthUSA;
    }

    public List<Double> creditChina() {
        List<Double> FDIInflowIndia = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            Double value = Double.parseDouble(list_my.get(i).AnnaulAFFChina);
            FDIInflowIndia.add(value);
        }
        return FDIInflowIndia;
    }

    public List<Double> creditIndia() {
        List<Double> FDIInflowChina = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            if (list_my.get(i) != null) {
                Double value = Double.parseDouble(list_my.get(i).AnnaulAFFIndia);
                FDIInflowChina.add(value);
            }
        }
        return FDIInflowChina;
    }

    public List<Double> creditUSA() {
        List<Double> FDIInflowUSA = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            if (list_my.get(i) != null) {
                Double value = Double.parseDouble(list_my.get(i).AnnaulAFFUSA);
                FDIInflowUSA.add(value);
            }
        }
        return FDIInflowUSA;

    }

    public List<Double> fertilizerConsumptionIndia() {
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            if (list_my.get(i) != null) {
                Double value = Double.parseDouble(list_my.get(i).FertilizerConsumptionIndia);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }

    public List<Double> fertilizerConsumptionChina() {
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            if (list_my.get(i) != null) {
                Double value = Double.parseDouble(list_my.get(i).FertilizerConsumptionChina);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }

    public List<Double> fertilizerConsumptionUSA() {
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            if (list_my.get(i) != null) {
                Double value = Double.parseDouble(list_my.get(i).FertilizerConsumptionUSA);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }


    public List<Double> fertilizerProductionIndia() {
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            if (list_my.get(i) != null) {
                Double value = Double.parseDouble(list_my.get(i).FertilizerPerConsumptionIndia);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }

    public List<Double> fertilizerProductionChina() {
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            if (list_my.get(i) != null) {
                Double value = Double.parseDouble(list_my.get(i).FertilizerPerConsumptionChina);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }

    public List<Double> fertilizerProductionUSA() {
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for (int i = 0; i < list_my.size(); i++) {
            if (list_my.get(i) != null) {
                Double value = Double.parseDouble(list_my.get(i).FertilizerPerConsumptionUSA);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }

}

