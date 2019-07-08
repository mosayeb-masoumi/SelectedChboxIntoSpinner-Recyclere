package com.example.test.recycler_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.test.App;
import com.example.test.R;


public class RecyclerActivity extends AppCompatActivity {

    Adapter adapter;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        //SETUP RECYCLER
        rv=  findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));


        //adapter
        adapter=new Adapter(this, App.arrayListStringSelected);
        rv.setAdapter(adapter);

    }
}
