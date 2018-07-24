package com.example.student.finalact3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class Burgers extends AppCompatActivity {
    Button mcdelivery,order1,order2,order3,order4,order5;
    DatabaseReference databaseProductsBurgers;
    ArrayList<String> BurgerName = new ArrayList<String>();
    ArrayList<String> BurgerPrice = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burgers);
        databaseProductsBurgers = FirebaseDatabase.getInstance().getReference("Burgers");
        mcdelivery = (Button) findViewById(R.id.mcdelivery);
        order1 = (Button) findViewById(R.id.Burgerorder1);
        order2 = (Button) findViewById(R.id.Burgerorder2);
        order3 = (Button) findViewById(R.id.Burgerorder3);
        order4 = (Button) findViewById(R.id.Burgerorder4);
        order5 = (Button) findViewById(R.id.Burgerorder5);
        final Bundle b = getIntent().getExtras();
        ;

        mcdelivery.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Burgers.this,home.class);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });

        order1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ ;
                Intent intent = new Intent(Burgers.this, OrderConfirmation.class);
                b.putString("prodname",  BurgerName.get(0));
                b.putString("prodprice", BurgerPrice.get(0));
                intent.putExtras(b);
                startActivity(intent);
                finish();

            }

        });
        order2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Burgers.this, OrderConfirmation.class);
                b.putString("prodname",  BurgerName.get(1));
                b.putString("prodprice", BurgerPrice.get(1));
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
        order3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Burgers.this, OrderConfirmation.class);
                b.putString("prodname",  BurgerName.get(2));
                b.putString("prodprice", BurgerPrice.get(2));
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
        order4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Burgers.this, OrderConfirmation.class);
                b.putString("prodname",  BurgerName.get(3));
                b.putString("prodprice", BurgerPrice.get(3));
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
        order5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Burgers.this, OrderConfirmation.class);
                b.putString("prodname",  BurgerName.get(4));
                b.putString("prodprice", BurgerPrice.get(4));
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });

        databaseProductsBurgers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot child: dataSnapshot.getChildren()) {
                    HashMap<String, String> value = (HashMap<String, String>) child.getValue();

                    String name = value.get("Name");
                    String price = String.valueOf(value.get("Price"));
                    BurgerName.add(name);
                    BurgerPrice.add(price);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}
