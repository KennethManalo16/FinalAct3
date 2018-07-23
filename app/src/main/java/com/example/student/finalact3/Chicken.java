package com.example.student.finalact3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Chicken extends AppCompatActivity {
    Button mcdelivery;
    TextView User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken);
        mcdelivery = (Button) findViewById(R.id.mcdelivery);
        User = (TextView) findViewById(R.id.txtUser);
        final Bundle b = getIntent().getExtras();
        User.setText("Hi,  "+b.getString("firstname")+"!");

        mcdelivery.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Chicken.this,home.class);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
    }
}
