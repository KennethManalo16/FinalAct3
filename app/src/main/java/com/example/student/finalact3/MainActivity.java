package com.example.student.finalact3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this is my testing

        register = (Button)findViewById(R.id.btnRegister);

        System.out.print("Ayoko na mag IT");
        // Dito kame Ditoo

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent SignUp = new Intent(MainActivity.this, Register.class);
                startActivity(SignUp);
            }
        });
    }
}
