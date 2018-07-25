package com.example.student.finalact3;

import android.content.Intent;
import android.graphics.Picture;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class OrderConfirmation extends AppCompatActivity {
    int quantity=1;
    Double price=0.00;
    Button numdecrement,numincrement,cancel;
    TextView displayquantityy,productname,productprice;
    ImageView Picture;
    String imagename,select;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);
        Picture = (ImageView) findViewById(R.id.Picture);

        numdecrement = (Button) findViewById(R.id.minus);
        numincrement = (Button) findViewById(R.id.plus);
        cancel = (Button) findViewById(R.id.cancel);
        displayquantityy = (TextView)findViewById(R.id.number);
        final Bundle b = getIntent().getExtras();
        productname = (TextView) findViewById(R.id.txtProductName);
        productprice = (TextView) findViewById(R.id.txtPrice);
        productname.setText(b.getString("prodname"));
        productprice.setText("PHP:"+b.getString("prodprice"));
        price = Double.parseDouble(String.valueOf(b.getString("prodprice")));
        select = b.getString("prodname");

        if(select.equals("Apple Pie")){
            Picture.setImageResource(R.drawable.applepie);
        }
        else if(select.equals("Caramel Sundae")){
            Picture.setImageResource(R.drawable.caramel);
        }
        else if(select.equals("McFloat")){
            Picture.setImageResource(R.drawable.floats);
        }
        else if(select.equals("Sundae")){
            Picture.setImageResource(R.drawable.hotfudge);
        }
        else if(select.equals("McFlurry")){
            Picture.setImageResource(R.drawable.flurry);
        }
        else if(select.equals("Big Mac")){
            Picture.setImageResource(R.drawable.bigmac);
        }
        else if(select.equals("Cheeseburger")){
            Picture.setImageResource(R.drawable.cheese);
        }
        else if(select.equals("Crispy Chicken Sandwich")){
            Picture.setImageResource(R.drawable.crispy);
        }
        else if(select.equals("Fillet O-Fish")){
            Picture.setImageResource(R.drawable.fish);
        }
        else if(select.equals("McChicken")){
            Picture.setImageResource(R.drawable.mcchicken);
        }
        else if(select.equals("Chicken w/ Fries")){
            Picture.setImageResource(R.drawable.chickenfries);
        }
        else if(select.equals("Chicken w/ Soup")){
            Picture.setImageResource(R.drawable.chickensoup);
        }
        else if(select.equals("Chicken w/ Spaghetti")){
            Picture.setImageResource(R.drawable.chickenspag);
        }
        else if(select.equals("Chicken w/ Sundae")){
            Picture.setImageResource(R.drawable.chickensundae);
        }
        else if(select.equals("Spicy Chicken")){
            Picture.setImageResource(R.drawable.spicychicken);
        }

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
                   Double priceequivalent = price * quantity;
                   productprice.setText("PHP:"+priceequivalent);
               }
            }

        });
        numincrement.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                quantity = quantity + 1;
                displayquantityy.setText(""+quantity);
                Double priceequivalent = price * quantity;
                productprice.setText("PHP:"+priceequivalent);
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
