package com.example.student.finalact3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OrderConfirmation extends AppCompatActivity {
    int quantity=1;
    Button numdecrement,numincrement,cancel;
    TextView displayquantityy,productname,productprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

        numdecrement = (Button) findViewById(R.id.minus);
        numincrement = (Button) findViewById(R.id.plus);
        cancel = (Button) findViewById(R.id.cancel);
        displayquantityy = (TextView)findViewById(R.id.number);
        final Bundle b = getIntent().getExtras();
        productname = (TextView) findViewById(R.id.txtProductName);
        productprice = (TextView) findViewById(R.id.txtPrice);
        productname.setText(b.getString("name"));
        productprice.setText(b.getString("price"));

        numdecrement.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
               if(quantity==1) {
                quantity =quantity+0;
                   displayquantityy.setText(""+quantity);
               }
               else {
                   quantity = quantity - 1;
                   displayquantityy.setText(""+quantity);
               }
            }

        });
        numincrement.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                quantity = quantity + 1;
                displayquantityy.setText(""+quantity);
            }

        });

        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(OrderConfirmation.this,home.class);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
    }


}
