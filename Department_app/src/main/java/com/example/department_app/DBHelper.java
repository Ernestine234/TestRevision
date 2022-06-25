package com.example.department_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context,"Userdata.bd", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL("create Table Userdetails(firstname TEXT primary key,contact TEXT,dob TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("drop Table if exists Userdetails");
    }

    public Boolean insertuserdata(EditText firstname, EditText lastname, EditText mobilenumber, EditText password, EditText department) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Firstname", firstname);
        contentValues.put("Lastname",lastname);
        contentValues.put("MobileNumber", mobilenumber);
        contentValues.put("Password", password);
        contentValues.put("Department", department);
        long result = db.insert("Userdetails", null,contentValues);
         if(result == -1){
             return false;
         }else{
             return true;
         }
    }

    public Boolean updateuserdata(String firstname, String lastname, int mobilenumber, String password, String department) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Lastname", lastname);
        contentValues.put("MobileNumber", mobilenumber);
        contentValues.put("Password", password);
        contentValues.put("Department", department);
        Cursor cursor = db.rawQuery("Select * from Userdetails where firstname=?", new String[]{firstname});
        if (cursor.getCount() > 0) {


            long result = db.update("Userdetails", contentValues, "firstname=?", new String[]{firstname});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else
        {
            return false;
        }
    }
    public Boolean deleteuserdata(String firstname) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from Userdetails where firstname=?", new String[]{firstname});
        if (cursor.getCount() > 0) {


            long result = db.delete("Userdetails", "firstname=?", new String[]{firstname});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else
        {
            return false;
        }
    }

    public Cursor getdata () {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from Userdetails", null);
        return cursor;
    }
}
