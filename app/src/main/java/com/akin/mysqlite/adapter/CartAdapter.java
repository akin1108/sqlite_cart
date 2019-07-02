package com.akin.mysqlite.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akin.mysqlite.model.CartModel;
import com.akin.mysqlite.R;
import com.akin.mysqlite.model.Student;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private Context contxt;
    private List<Student> cartModelList;

    public CartAdapter(Context contxt, List<Student> cartModelList) {
        this.contxt = contxt;
        this.cartModelList = cartModelList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(contxt);
        View view = layoutInflater.inflate(R.layout.cart_custom, null);
        CartViewHolder cartViewHolder = new CartViewHolder(view);
        return cartViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder cartViewHolder, int position) {
        final Student cart = cartModelList.get(position);
        cartViewHolder.medName.setText(cart.getFirstName());
        cartViewHolder.totalprice.setText(String.valueOf(cart.getPrice()));
        cartViewHolder.counter.setText(String.valueOf(cart.getCount()));
        cartViewHolder.priceamt.setText(String.valueOf(cart.getRate()));
    }


    @Override
    public int getItemCount() {
        return cartModelList.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder {
        TextView medName, counter, totalprice, priceamt;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            medName = (TextView) itemView.findViewById(R.id.medicine);
            counter = (TextView) itemView.findViewById(R.id.qty);
            totalprice = (TextView) itemView.findViewById(R.id.total);
            priceamt = (TextView) itemView.findViewById(R.id.price);

        }
    }
}
