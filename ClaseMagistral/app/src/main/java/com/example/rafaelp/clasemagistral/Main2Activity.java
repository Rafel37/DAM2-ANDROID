package com.example.rafaelp.clasemagistral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdaptadorRecycler adaptadorRecycler;
    ArrayList<String> arrayListMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        arrayListMain = new ArrayList<>();
        arrayListMain.add("dfdsf");
        arrayListMain.add("21332");
        arrayListMain.add("k87i87");
        recyclerView = findViewById(R.id.recycler);
        adaptadorRecycler = new AdaptadorRecycler(getApplicationContext(), arrayListMain);
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager( new GridLayoutManager(getApplicationContext(), 1, LinearLayoutManager.VERTICAL, false));
    }
}
