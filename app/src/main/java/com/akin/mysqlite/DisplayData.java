package com.akin.mysqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.akin.mysqlite.adapter.MyAdapter;

public class DisplayData extends AppCompatActivity {

    RecyclerView recycler_View;
    DatabaseHelper databaseHelper = new DatabaseHelper(this,"student.db",null,1);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);


        recycler_View = (RecyclerView)findViewById(R.id.recyclerView);
        recycler_View.setHasFixedSize(true);
        recycler_View.setLayoutManager(new LinearLayoutManager(this));

        if (databaseHelper.getAllData() != null) {
            MyAdapter adapter = new MyAdapter(this, databaseHelper.getAllData());
            recycler_View.setAdapter(adapter);
        }
    }
}
