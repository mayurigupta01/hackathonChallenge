package com.example.hackathonchellenge;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;

        import java.util.ArrayList;
        import java.util.List;

public class MacroeconomyChart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.macro_economy_chart);

    }
    private List<MacroeconomicsModel> list_my = MainActivity.modelList;

    public List<Double> showIndiaGDPData(){
        List<Double> gdpGrowthDataIndia = new ArrayList<>();
        for(int i = 0 ; i<list_my.size() ; i++){
            Double value = Double.parseDouble(list_my.get(i).PerAnnualGDPGrowthIndia);
            gdpGrowthDataIndia.add(value);
        }
        return gdpGrowthDataIndia;
    }

    public List<Double> showChinaGDPData(){
        List<Double> gdpGrowthDataChina = new ArrayList<>();
        for(int i = 0 ; i<list_my.size() ; i++){
            Double value = Double.parseDouble(list_my.get(i).PerAnnualGDPGrowthChina);
            gdpGrowthDataChina.add(value);
        }

        return gdpGrowthDataChina;
    }

    public List<Double> showUSAGDPData(){
        List<Double> gdpGrowthUSA = new ArrayList<>();
        for(int i = 0 ; i<list_my.size() ; i++){
            Double value = Double.parseDouble(list_my.get(i).PerAnnualGDPGrowthUSA);
            gdpGrowthUSA.add(value);
        }
        return gdpGrowthUSA;
    }

    public List<Double> FDIInflowIndiaGDPData(){
        List<Double> FDIInflowIndia = new ArrayList<>();
        for(int i = 0 ; i<list_my.size() ; i++){
            Double value = Double.parseDouble(list_my.get(i).FDIPercentGDPIndia);
            FDIInflowIndia.add(value);
        }
        return FDIInflowIndia;
    }

    public List<Double> FDIInflowChinaGDPData(){
        List<Double> FDIInflowChina = new ArrayList<>();
        for(int i = 0 ; i<list_my.size() ; i++){
            if(list_my.get(i)!=null) {
                Double value = Double.parseDouble(list_my.get(i).FDIPercentGDPChina);
                FDIInflowChina.add(value);
            }
        }
        return FDIInflowChina;
    }

    public List<Double> FDIInflowUSAGDPData(){
        List<Double> FDIInflowUSA = new ArrayList<>();
        for(int i = 0 ; i<list_my.size() ; i++){
            if(list_my.get(i)!=null) {
                Double value = Double.parseDouble(list_my.get(i).FDIPercentGDPUSA);
                FDIInflowUSA.add(value);
            }
        }
        return FDIInflowUSA;

    }


    public List<Double> FDIOutflowIndiaGDPData(){
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for(int i = 0 ; i<list_my.size() ; i++){
            if(list_my.get(i)!=null) {
                Double value = Double.parseDouble(list_my.get(i).FDIOutflowDollarBOPIndia);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }

    public List<Double> FDIOutflowChinaGDPData(){
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for(int i = 0 ; i<list_my.size() ; i++){
            if(list_my.get(i)!=null) {
                Double value = Double.parseDouble(list_my.get(i).FDIOutflowDollarBOPChina);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }

    public List<Double> FDIOutflowUSAGDPData(){
        List<Double> FDIOutflowIndia = new ArrayList<>();
        for(int i = 0 ; i<list_my.size() ; i++){
            if(list_my.get(i)!=null) {
                Double value = Double.parseDouble(list_my.get(i).FDIOutflowDollarBOPUSA);
                FDIOutflowIndia.add(value);
            }
        }
        return FDIOutflowIndia;
    }

}
