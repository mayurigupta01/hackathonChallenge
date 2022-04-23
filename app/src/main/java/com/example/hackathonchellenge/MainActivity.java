package com.example.hackathonchellenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    String[] countries = {"Select a Country", "China", "India", "USA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}