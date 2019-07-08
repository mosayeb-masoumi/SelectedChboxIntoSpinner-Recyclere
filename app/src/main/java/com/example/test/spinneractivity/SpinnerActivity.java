package com.example.test.spinneractivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.test.App;
import com.example.test.R;
import com.example.test.mainactivity.AdapterMainActivity;

public class SpinnerActivity extends AppCompatActivity {

    Spinner spinner;
    AdapterMainActivity adapterMainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner = findViewById(R.id.spinner);


        if (App.arrayListStringSelected != null) {
            // Creating adapterMainActivity for spinner
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, App.arrayListStringSelected);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(dataAdapter);


            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                    String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(SpinnerActivity.this, item, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        } else {
            Toast.makeText(this, " List is null", Toast.LENGTH_SHORT).show();
        }













    }
}
