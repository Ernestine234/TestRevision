package com.example.department_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.text.TextUtils;

import android.os.Bundle;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    private TextView registration;
    private EditText mfirstname, mlastname, mmobilenumber ,mdepartment,mpassword;
    private Button register;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        registration = (TextView)findViewById(R.id.registration);
        mfirstname=(EditText)findViewById(R.id.firstname);
        mlastname=(EditText)findViewById(R.id.lastname);
        mmobilenumber=(EditText)findViewById(R.id.mobilenumber);
        mdepartment=(EditText)findViewById(R.id.department);
        mpassword=(EditText)findViewById(R.id.password);

       register =(Button)findViewById(R.id.register);//inserting button
        db = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t1 = mfirstname.getText().toString();
                String t2 = mlastname.getText().toString();
                String t3 = mmobilenumber.getText().toString();
                String t4 = mdepartment.getText().toString();
                String t5 = mpassword.getText().toString();

                Boolean checkinsertdata = db.insertuserdata(mfirstname, mlastname, mmobilenumber,mdepartment, mpassword);
                if(checkinsertdata==true) {

                    Toast.makeText(Registration.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Registration.this, "New Entry not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    }
