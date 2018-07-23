package com.example.student.finalact3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class home extends AppCompatActivity {
    TextView User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        User = (TextView) findViewById(R.id.txtUser);
        Bundle b = getIntent().getExtras();
        User.setText("Hi,  "+b.getString("firstname")+"!");
    }

    public void Burgers(View v) {
        Intent intent = new Intent(this, Burgers.class);
        startActivity(intent);
        finish();
    }

    public void Chicken(View v){
        Intent intent = new Intent(this, Chicken.class);
        startActivity(intent);
        finish();
    }

    public void Dessert(View v) {
        Intent intent = new Intent(this, Dessert.class);
        startActivity(intent);
        finish();
    }
}
