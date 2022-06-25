package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.text.TextUtils;


public class MainActivity extends AppCompatActivity {

   private TextView  meeting, usertype ;
   private EditText username1,password ;
   private Button sign;
   private Spinner spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meeting = (TextView) findViewById(R.id.text1);
        usertype =(TextView) findViewById(R.id.usertype);
        username1 =(EditText) findViewById(R.id.username1);
        password =(EditText) findViewById(R.id.password1);
        sign=(Button) findViewById(R.id.login);

        helper = new DatabaseHelper(this);


    }
    public void addUser(View view){
     String t1 = username1.getText().toString();
     String





    }
}