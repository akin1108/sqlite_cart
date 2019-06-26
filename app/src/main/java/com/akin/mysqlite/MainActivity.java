package com.akin.mysqlite;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText fName, lName;
    Button insert,update,delete,read;
    TextView output;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fName = (EditText)findViewById(R.id.firstName_et);
        lName = (EditText)findViewById(R.id.lastName_et);
        insert = (Button)findViewById(R.id.insert_button);
        delete = (Button)findViewById(R.id.delete_button);
        update = (Button)findViewById(R.id.update_button);
        read = (Button)findViewById(R.id.read_button);
        output = (TextView) findViewById(R.id.result_tv);

        databaseHelper = new DatabaseHelper(this,"Student.db",null,1);

    }

    public void btn_click(View view) {
        switch (view.getId()){
            case R.id.insert_button:
            {
                try{
                    databaseHelper.insert_student(fName.getText().toString().trim(),lName.getText().toString().trim());
                }
                catch (SQLiteException e){
                    Toast.makeText(MainActivity.this,"Student already exists",Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.update_button:
            {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Enter New FirstName");

                final EditText new_FirstName = new EditText(this);
                dialog.setView(new_FirstName);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        databaseHelper.update_student(new_FirstName.getText().toString().trim(),fName.getText().toString().trim());
                    }
                });
                dialog.show();
                break;
            }
            case R.id.delete_button:
            {
                databaseHelper.delete_student(fName.getText().toString().trim());
                break;
            }
            case R.id.read_button:
            {
                databaseHelper.get_names(output);
                Intent intent = new Intent(MainActivity.this, DisplayData.class);
//                intent.putExtra("FirstName",fName.getText().toString().trim());
//                intent.putExtra("Last Name",lName.getText().toString().trim());
                startActivity(intent);
                break;
            }
        }
    }
}
