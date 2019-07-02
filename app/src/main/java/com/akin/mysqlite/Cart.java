package com.akin.mysqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.akin.mysqlite.adapter.CartAdapter;
import com.akin.mysqlite.model.CartModel;
import com.akin.mysqlite.model.Student;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {

    RecyclerView recycler_View;
    List<CartModel> cartModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recycler_View = (RecyclerView)findViewById(R.id.recycleView);
        recycler_View.setHasFixedSize(true);
        recycler_View.setLayoutManager(new LinearLayoutManager(this));

        // Get added products data
        // for(){cartModels.add();}

        Bundle args = getIntent().getBundleExtra("cartList");
        ArrayList<Student> cartList = (ArrayList<Student>) args.getSerializable("ARRAYLIST");
        CartAdapter cartAdapter = new CartAdapter(this, cartList);
        recycler_View.setAdapter(cartAdapter);
    }
}
