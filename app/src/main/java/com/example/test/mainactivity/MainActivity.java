package com.example.test.mainactivity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.test.R;
import com.example.test.recycler_activity.RecyclerActivity;
import com.example.test.spinneractivity.SpinnerActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    AdapterMainActivity adapterMainActivity;
    ArrayList<Model> models = new ArrayList<>();
    RecyclerView recyclerView;

    Button btnSpinner , btnshowlist , btnRecyclereView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycler);

        adapterMainActivity =new AdapterMainActivity(models,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapterMainActivity);

        getData();


        Toast.makeText(this, adapterMainActivity.getList(), Toast.LENGTH_SHORT).show();



        btnSpinner=findViewById(R.id.btnSpinner);
        btnSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SpinnerActivity.class));
            }
        });



        btnshowlist=findViewById(R.id.btnshowlist);
        btnshowlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, adapterMainActivity.getList(), Toast.LENGTH_SHORT).show();
            }
        });

        btnRecyclereView=findViewById(R.id.btnRecyclereView);
        btnRecyclereView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RecyclerActivity.class));
            }
        });



    }

    private void getData() {

        models.add(new Model("ali"));
        models.add(new Model("reza"));
        models.add(new Model("nabi"));
        models.add(new Model("neda"));
    }
}


