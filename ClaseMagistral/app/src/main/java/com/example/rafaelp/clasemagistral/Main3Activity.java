package com.example.rafaelp.clasemagistral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    Spinner spinner;
    ArrayList<Integer> arrayList;
    AdaptadorSpinner adaptadorSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        spinner = findViewById(R.id.spinner);
        arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        adaptadorSpinner = new AdaptadorSpinner(getApplicationContext(), arrayList);
        spinner.setAdapter(adaptadorSpinner);
    }
}
