package com.example.test;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

public class App extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }

    public static ArrayList<String> arrayListStringSelected = new ArrayList<>();
    public static ArrayList<Integer> arrayListIntegerSelected = new ArrayList<>();


}
