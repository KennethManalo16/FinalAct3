package com.example.student.finalact3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ordersummary extends AppCompatActivity {
    Button CloseBag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordersummary);
        final Bundle b = getIntent().getExtras();
        CloseBag = (Button) findViewById(R.id.btnCloseBag);

        CloseBag.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(b.get("ordersummaryback").equals("home")){
                Intent intent = new Intent(ordersummary.this, home.class);
                intent.putExtras(b);
                startActivity(intent);
                finish();}
                else if (b.get("ordersummaryback").equals("myaccount")){
                    Intent intent = new Intent(ordersummary.this, MyAccount.class);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
                else if (b.get("ordersummaryback").equals("chicken")){
                    Intent intent = new Intent(ordersummary.this, Chicken.class);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
                else if (b.get("ordersummaryback").equals("burger")){
                    Intent intent = new Intent(ordersummary.this, Chicken.class);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
                else if (b.get("ordersummaryback").equals("dessert")){
                    Intent intent = new Intent(ordersummary.this, Chicken.class);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(ordersummary.this, "Fail equivalent", Toast.LENGTH_LONG).show();
                }

            }

        });
    }
}
