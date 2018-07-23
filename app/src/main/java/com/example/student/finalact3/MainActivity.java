package com.example.student.finalact3;

import android.content.Intent;
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

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText LogInEmailAddress,LogInPassword;
    Button LogIn,Register;
    DatabaseReference databaseUsernamesPasswords;
    ArrayList<String> User = new ArrayList<String>();
    ArrayList<String> Pass = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseUsernamesPasswords = FirebaseDatabase.getInstance().getReference("Users");
        LogInEmailAddress = (EditText) findViewById(R.id.txtLogInEmailAddress);
        LogInPassword = (EditText) findViewById(R.id.txtLogInPassword);
        LogIn = (Button) findViewById(R.id.btnLogIn);
        Register = (Button) findViewById(R.id.btnRegister);

        Register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
                finish();
            }

        });
        LogIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String email = LogInEmailAddress.getText().toString().trim();
                String password = LogInPassword.getText().toString();
                if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
                    try{
                        for(int x=0;x<=User.size();x++){
                            if(email .equals(User.get(x)) && password .equals(Pass.get(x))) {
                                Toast.makeText(MainActivity.this, "Successfully logged in", Toast.LENGTH_LONG).show();
                                x=User.size();
                            }
                        }
                    }catch(Exception e){
                        Toast.makeText(MainActivity.this, "Wrong email or password", Toast.LENGTH_LONG).show();
                    }
                }
                else if(TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity.this,"Please enter your email",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(password) && !TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity.this,"Please enter your password",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Please fill the blanks",Toast.LENGTH_LONG).show();
                }
            }

        });
        databaseUsernamesPasswords.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot child: dataSnapshot.getChildren()) {
                    HashMap<String, String> value = (HashMap<String, String>) child.getValue();

                    String user = value.get("Email");
                    String pass = value.get("Password");
                    User.add(user);
                    Pass.add(pass);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}

