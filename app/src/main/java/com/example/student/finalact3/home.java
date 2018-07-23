package com.example.student.finalact3;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

public class home extends AppCompatActivity {
    TextView User;
    Button burgers,chickens,desserts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        burgers = (Button) findViewById(R.id.btnBurgers);
        chickens = (Button) findViewById(R.id.btnChicken);
        desserts = (Button) findViewById(R.id.btnDesserts);

        User = (TextView) findViewById(R.id.txtUser);
        final Bundle b = getIntent().getExtras();
        User.setText("Hi,  "+b.getString("firstname")+"!");


      burgers.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Intent intent = new Intent(home.this,Burgers.class);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }

    });
        chickens.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(home.this,Chicken.class);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });

        desserts.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(home.this, Dessert.class);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });


}}
