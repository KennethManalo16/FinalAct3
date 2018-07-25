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
        select = b.getString("imagename");
        imagename = "Picture";
        int resID = getResources().getIdentifier(imagename,"id","package.name");
        Picture.setImageResource(resID);

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
