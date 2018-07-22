package com.example.student.finalact3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Register extends AppCompatActivity {
    EditText FirstName, LastName, MobileNumber, EmailAddress, Password, ConfirmPassword;
    Button Submit,Cancel;
    DatabaseReference databaseUsernamesPasswords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseUsernamesPasswords = FirebaseDatabase.getInstance().getReference("Users");
        FirstName = (EditText) findViewById(R.id.txtRegisterFirstName);
        LastName = (EditText) findViewById(R.id.txtRegisterLastName);
        MobileNumber = (EditText) findViewById(R.id.txtRegisterMobileNumber);
        EmailAddress = (EditText) findViewById(R.id.txtRegisterEmailAddress);
        Password = (EditText) findViewById(R.id.txtRegisterPassword);
        ConfirmPassword =(EditText) findViewById(R.id.txtRegisterConfirmPassword);
        Submit = (Button) findViewById(R.id.btnSubmit);
        Cancel = (Button) findViewById(R.id.btnCancel);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = FirstName.getText().toString().trim();
                String lname = LastName.getText().toString().trim();
                String mnumber = MobileNumber.getText().toString();
                String emailadd = EmailAddress.getText().toString().trim();
                String pass = Password.getText().toString();
                String cpass = ConfirmPassword.getText().toString();
                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("First Name", fname);
                dataMap.put("Last Name", lname);
                dataMap.put("Mobile Number", mnumber);
                dataMap.put("Email", emailadd);
                dataMap.put("Password", pass);
                if(!TextUtils.isEmpty(fname) && !TextUtils.isEmpty(lname) && !TextUtils.isEmpty(mnumber) && !TextUtils.isEmpty(emailadd) && !TextUtils.isEmpty(pass) && (pass.equals(cpass))){
                    databaseUsernamesPasswords.push().setValue(dataMap);
                    Toast.makeText(Register.this,"Registered",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if(TextUtils.isEmpty(fname) && !TextUtils.isEmpty(lname) && !TextUtils.isEmpty(mnumber) && !TextUtils.isEmpty(emailadd) && !TextUtils.isEmpty(pass)){
                    Toast.makeText(Register.this,"Please enter your First Name",Toast.LENGTH_LONG).show();
                }
                else if(!TextUtils.isEmpty(fname) && TextUtils.isEmpty(lname) && !TextUtils.isEmpty(mnumber) && !TextUtils.isEmpty(emailadd) && !TextUtils.isEmpty(pass)){
                    Toast.makeText(Register.this,"Please enter your Last Name",Toast.LENGTH_LONG).show();
                }
                else if(!TextUtils.isEmpty(fname) && !TextUtils.isEmpty(lname) && TextUtils.isEmpty(mnumber) && !TextUtils.isEmpty(emailadd) && !TextUtils.isEmpty(pass)){
                    Toast.makeText(Register.this,"Please enter your Mobile Number",Toast.LENGTH_LONG).show();
                }
                else if(!TextUtils.isEmpty(fname) && !TextUtils.isEmpty(lname) && !TextUtils.isEmpty(mnumber) && TextUtils.isEmpty(emailadd) && !TextUtils.isEmpty(pass)){
                    Toast.makeText(Register.this,"Please enter your Email Address",Toast.LENGTH_LONG).show();
                }
                else if(!TextUtils.isEmpty(fname) && !TextUtils.isEmpty(lname) && !TextUtils.isEmpty(mnumber) && !TextUtils.isEmpty(emailadd) && TextUtils.isEmpty(pass)){
                    Toast.makeText(Register.this,"Please enter your Password",Toast.LENGTH_LONG).show();
                }
                else if(!TextUtils.isEmpty(fname) && !TextUtils.isEmpty(lname) && !TextUtils.isEmpty(mnumber) && !TextUtils.isEmpty(emailadd) && !TextUtils.isEmpty(pass) && (!pass.equals(cpass))){
                    Toast.makeText(Register.this,"Password don't match please re-enter your Password",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Register.this,"Please fill the blanks",Toast.LENGTH_LONG).show();
                }
            }
        });


        Cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
