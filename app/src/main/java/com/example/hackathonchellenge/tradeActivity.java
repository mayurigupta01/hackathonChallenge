package com.example.hackathonchellenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class tradeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trade_checkbox);

        CheckBox simpleCheckBox = (CheckBox) findViewById(R.id.checkbox_Reserve);
        Boolean simpleCheckBoxState = simpleCheckBox.isChecked();//initiate a check box

        CheckBox checkbox_GNI = (CheckBox) findViewById(R.id.checkbox_GNI);
        Boolean checkbox_GNIState = checkbox_GNI.isChecked();//initiate a check box

        CheckBox checkbox_Total_Debt = (CheckBox) findViewById(R.id.checkbox_Total_Debt);
        Boolean checkbox_Total_DebtState = checkbox_Total_Debt.isChecked();//initiate a check box

        CheckBox checkbox_GNICurrentUS = (CheckBox) findViewById(R.id.checkbox_GNICurrentUS);
        Boolean checkbox_GNICurrentUSState = checkbox_GNICurrentUS.isChecked();
    }

    public void tradeActivity(View view) {
        Intent intent = new Intent(tradeActivity.this, Tradechart.class);
        startActivity(intent);
    }
}