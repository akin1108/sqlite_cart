package com.akin.mysqlite.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.akin.mysqlite.Cart;
import com.akin.mysqlite.model.CartModel;
import com.akin.mysqlite.LagreActivity;
import com.akin.mysqlite.R;
import com.akin.mysqlite.model.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.DataViewHolder> {

    private Context context;
    private List<Student> studentList;
    private List<Student> cartModelList;
    private Map<Integer, Student> cartList = new HashMap<>();
    CartModel cart = new CartModel();

    public MyAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }


    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.custom, null);
        DataViewHolder dataViewHolder = new DataViewHolder(view);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final DataViewHolder dataViewHolder, final int position) {
        final Student data = studentList.get(position);
        dataViewHolder.firstName_std.setText(data.getFirstName());
        dataViewHolder.lastName_std.setText(data.getLastName());
        dataViewHolder.increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int inc = data.getCount();
                inc = inc + 1;
                data.setCount(inc);
                dataViewHolder.counter.setText(String.valueOf(inc));
                cartList.put(position, data);
            }
        });
        dataViewHolder.decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dec = data.getCount();
                if (dec == 0) {
                    Toast.makeText(context, "Already 0, can't decrease more", Toast.LENGTH_SHORT).show();
                }
                if (dec > 0) {
                    dec = dec - 1;
                    data.setCount(dec);
                    dataViewHolder.counter.setText(String.valueOf(dec));
                    cartList.put(position, data);
                }
            }
        });
        dataViewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cartModelList = new ArrayList<>(cartList.values());
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST", (Serializable) cartModelList);

                Intent intent = new Intent(context, Cart.class);
                intent.putExtra("cartList", args);
                context.startActivity(intent);

                cart.setMedicine(data.getFirstName());
                cart.setQuantity(data.getCount());
                cart.setTotal(data.getCount() * cart.getRate());
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }


    class DataViewHolder extends RecyclerView.ViewHolder {
        TextView firstName_std, lastName_std, counter;
        Button button;
        ImageButton increase, decrease;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            firstName_std = (TextView) itemView.findViewById(R.id.first_name);
            lastName_std = (TextView) itemView.findViewById(R.id.last_name);
            counter = (TextView) itemView.findViewById(R.id.count);
            button = (Button) itemView.findViewById(R.id.btn);
            increase = (ImageButton) itemView.findViewById(R.id.plus);
            decrease = (ImageButton) itemView.findViewById(R.id.minus);


        }
    }
}
