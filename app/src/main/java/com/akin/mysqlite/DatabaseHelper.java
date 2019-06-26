package com.akin.mysqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import com.akin.mysqlite.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version) {
        super(context,"Student.db",factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE STUDENTS(ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRSTNAME TEXT, LASTNAME TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS STUDENTS");
        onCreate(db);
    }

    public void insert_student(String firstname, String lastname){
        ContentValues contentValues = new ContentValues();
        contentValues.put("FIRSTNAME",firstname);
        contentValues.put("LASTNAME",lastname);
        this.getWritableDatabase().insertOrThrow("STUDENTS","",contentValues);
    }
    public void delete_student(String firstname){
        this.getWritableDatabase().delete("STUDENTS","FIRSTNAME='"+firstname+"'",null);
    }

    public void update_student(String new_firstname,String old_firstname){
        this.getWritableDatabase().execSQL("UPDATE STUDENTS SET FIRTSNAME='"+new_firstname+"' WHERE FIRSTNAME='"+old_firstname+"'");
    }

    public void get_names(TextView textView){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM STUDENTS",null);
        textView.setText(" ");
        while(cursor.moveToNext()){
            String firstname = cursor.getString(1);
            String lastname = cursor.getString(2);
            textView.append(firstname+" "+lastname+"\n");
        }
    }

    public List<Student> getAllData() {
       List<Student> list = new ArrayList<>();
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM STUDENTS",null);
        while (cursor.moveToNext()) {
            String firstname = cursor.getString(1);
            String lastname = cursor.getString(2);

            Student stud = new Student(firstname,lastname);
            stud.setFirstName(firstname);
            stud.setLastName(lastname);
            list.add(stud);


        }
        return list;
    }
}
