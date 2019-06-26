package com.akin.mysqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.akin.mysqlite.model.Student;

public class LagreActivity extends AppCompatActivity {
    TextView firstName, lastName, quant;
    Student student;
    Button proceed2cart;
    DatabaseHelper databaseHelper = new DatabaseHelper(this,"student.db",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lagre);

        firstName = (TextView)findViewById(R.id.first__name);
        lastName = (TextView)findViewById(R.id.last__name);
        quant = (TextView)findViewById(R.id.text_counter);
        proceed2cart = (Button)findViewById(R.id.move_to_cart) ;

        proceed2cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Cart.class));
            }
        });


        String firstnamee = getIntent().getStringExtra("firstname");
        String lastnamee = getIntent().getStringExtra("lastname");
        String quantity =  getIntent().getStringExtra("count");

        firstName.setText(firstnamee);
        lastName.setText(lastnamee);
        quant.setText(quantity);



    }
}
