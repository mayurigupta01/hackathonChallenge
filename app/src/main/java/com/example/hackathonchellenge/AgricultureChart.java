package com.example.hackathonchellenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.MarkerType;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.graphics.vector.Stroke;

import java.util.ArrayList;
import java.util.List;

public class AgricultureChart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agriculture_chart);

        int spinnerSelection = getIntent().getExtras().getInt("countrySelection");
        Boolean checkbox_Contribution_to_GDPState = getIntent().getBooleanExtra("checkbox_Contribution_to_GDPState", false);
        Boolean checkbox_CreditState = getIntent().getBooleanExtra("checkbox_CreditState", false);
        Boolean checkbox_Fertilizers = getIntent().getBooleanExtra("checkbox_Fertilizers", false);
        Boolean checkbox_FertilizerProduction = getIntent().getBooleanExtra("checkbox_FertilizerProduction", false);

        List<Double> data = new ArrayList<Double>();
        List<Double> data2 = new ArrayList<Double>();
        String countrySelection;

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(findViewById(R.id.progress_bar));

        Cartesian cartesian = AnyChart.line();

        cartesian.animation(true);

        cartesian.padding(10d, 20d, 5d, 20d);

        cartesian.crosshair().enabled(true);
        cartesian.crosshair()
                .yLabel(true)
                // TODO ystroke
                .yStroke((Stroke) null, null, null, (String) null, (String) null);

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);

//        cartesian.title("Trend of Sales of the Most Popular Products of ACME Corp.");
//        cartesian.yAxis(0).title("Number of Bottles Sold (thousands)");
        cartesian.xAxis(0).labels().padding(5d, 5d, 5d, 5d);

        // Uncomment for two charts
//        if(spinnerSelection == 1) {
//            if(checkbox_GDP == true) {
//                data = showChinaGDPData();
//            }
//            if(checkbox_FDIInflowUSD == true) {
//                data2 = FDIInflowChinaGDPData();
//            }
//        }

        if(spinnerSelection == 1) {
            if(checkbox_Contribution_to_GDPState == true) {
                data = showChinaGDPData();
            }
            if(checkbox_CreditState == true) {
                data = creditChina();
            }
            if(checkbox_Fertilizers == true) {
                data = fertilizerConsumptionChina();
            }
            if(checkbox_FertilizerProduction == true) {
                data = fertilizerProductionChina();
            }
        }

        if(spinnerSelection == 2) {
            if(checkbox_Contribution_to_GDPState == true) {
                data = showIndiaGDPData();
            }
            if(checkbox_CreditState == true) {
                data = creditIndia();
            }
            if(checkbox_Fertilizers == true) {
                data = fertilizerConsumptionIndia();
            }
            if(checkbox_FertilizerProduction == true) {
                data = fertilizerProductionIndia();
            }
        }

        if(spinnerSelection == 3) {
            if(checkbox_Contribution_to_GDPState == true) {
                data = showUSAGDPData();
            }
            if(checkbox_CreditState == true) {
                data = creditUSA();
            }
            if(checkbox_Fertilizers == true) {
                data = fertilizerConsumptionUSA();
            }
            if(checkbox_FertilizerProduction == true) {
                data = fertilizerProductionUSA();
            }
        }


        if(data.isEmpty()) {
            System.out.println("No chart data!");
        } else {
            List<DataEntry> seriesData = new ArrayList<>();
            List<DataEntry> seriesData2 = new ArrayList<>();

            int year = 1960;
            for (int i = 0; i < 61; i++) {
                seriesData.add(new AgricultureChart.CustomDataEntry(Integer.toString(year), data.get(i)));
                year++;
            }

//            year = 1960;
//            for (int i = 0; i < 61; i++) {
//                seriesData2.add(new CustomDataEntry(Integer.toString(year), data2.get(i)));
//                year++;
//            }

            Set set = Set.instantiate();
            set.data(seriesData);
            Mapping series1Mapping = set.mapAs("{ x: 'x', value: 'value' }");
//            Set set2 = Set.instantiate();
//            set2.data(seriesData2);
//            Mapping series2Mapping = set2.mapAs("{ x: 'x', value: 'value2' }");

            //        Mapping series3Mapping = set.mapAs("{ x: 'x', value: 'value3' }");

            Line series1 = cartesian.line(series1Mapping);
            // series1.name("Brandy");
            series1.hovered().markers().enabled(true);
            series1.hovered().markers()
                    .type(MarkerType.CIRCLE)
                    .size(4d);
            series1.tooltip()
                    .position("right")
                    .anchor(Anchor.LEFT_CENTER)
                    .offsetX(5d)
                    .offsetY(5d);

//            Line series2 = cartesian.line(series2Mapping);
//            // series2.name("Whiskey");
//            series2.hovered().markers().enabled(true);
//            series2.hovered().markers()
//                    .type(MarkerType.CIRCLE)
//                    .size(4d);
//            series2.tooltip()
//                    .position("right")
//                    .anchor(Anchor.LEFT_CENTER)
//                    .offsetX(5d)
//                    .offsetY(5d);

//            Line series3 = cartesian.line(series3Mapping);
//            series3.name("Tequila");
//            series3.hovered().markers().enabled(true);
//            series3.hovered().markers()
//                    .type(MarkerType.CIRCLE)
//                    .size(4d);
//            series3.tooltip()
//                    .position("right")
//                    .anchor(Anchor.LEFT_CENTER)
//                    .offsetX(5d)
//                    .offsetY(5d);

            cartesian.legend().enabled(true);
            cartesian.legend().fontSize(13d);
            cartesian.legend().padding(0d, 0d, 10d, 0d);

            anyChartView.setChart(cartesian);
        }
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

    private class CustomDataEntry extends AgricultureChart.ValueDataEntry {

        CustomDataEntry(String x, Number value, Number value2, Number value3) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
        }

        CustomDataEntry(String x, Number value) {
            super(x, value);
        }
    }

    public class ValueDataEntry extends DataEntry {

        public ValueDataEntry(String x, Number value) {
            setValue("x", x);
            setValue("value", value);
        }
    }

}

