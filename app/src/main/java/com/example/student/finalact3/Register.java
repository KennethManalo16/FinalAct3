package com.example.student.finalact3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Register extends AppCompatActivity {

    EditText mmusername,mmpassword;
    Button mmsignup;
    private DatabaseReference mdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mmusername = (EditText) findViewById(R.id.LogInUserName);
        mmpassword = (EditText) findViewById(R.id.LogInPassword);


        mmsignup = (Button)findViewById(R.id.btnRegistered);

        mdatabase = FirebaseDatabase.getInstance().getReference();

        mmsignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = mmusername.getText().toString().trim();
                String password = mmpassword.getText().toString().trim();

                Toast.makeText(Register.this,name+password,Toast.LENGTH_LONG).show();

            /*    if(TextUtils.isEmpty(name)){
                    Toast.makeText(Register.this,"Please enter email",Toast.LENGTH_LONG).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Register.this,"Please enter password",Toast.LENGTH_LONG).show();
                    return;
                } */

              /*  HashMap<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("Username", name);
                dataMap.put("Password", password); */


                mdatabase.child("Username").setValue("josadjkla");




            }
        });
    }
}
