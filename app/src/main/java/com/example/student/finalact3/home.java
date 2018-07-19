package com.example.student.finalact3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
