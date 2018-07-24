package com.example.student.finalact3;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

public class home extends AppCompatActivity {
    TextView User;
    Button burgers,chickens,desserts,myaccount,ordersummary,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final Bundle b = getIntent().getExtras();
        burgers = (Button) findViewById(R.id.btnBurgers);
        chickens = (Button) findViewById(R.id.btnChicken);
        desserts = (Button) findViewById(R.id.btnDesserts);
        myaccount = (Button) findViewById(R.id.btnMyAccount);
        ordersummary = (Button) findViewById(R.id.btnOrderSummary);
        logout = (Button) findViewById(R.id.btnLogOut);

        User = (TextView) findViewById(R.id.txtUser);

        User.setText("Hi,  "+b.getString("firstname")+" Welcome to Mcdonalds!");

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

        myaccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(home.this,MyAccount.class);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
        ordersummary.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(home.this,ordersummary.class);
                String osbe = "home";
                b.putString("ordersummaryback", osbe);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(home.this, MainActivity.class);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
    }
}
