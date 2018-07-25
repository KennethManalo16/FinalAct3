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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class Dessert extends AppCompatActivity {
    Button order1,order2,order3,order4,order5,myaccount,ordersummary,logout;
    ImageView mcdelivery;
    DatabaseReference databaseProductsDesserts;
    ArrayList<String> DessertName = new ArrayList<String>();
    ArrayList<String> DessertPrice = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);
        databaseProductsDesserts = FirebaseDatabase.getInstance().getReference("Desserts");

        mcdelivery = (ImageView) findViewById(R.id.mcdelivery);
        order1 = (Button) findViewById(R.id.Dessertorder1);
        order2 = (Button) findViewById(R.id.Dessertorder2);
        order3 = (Button) findViewById(R.id.Dessertorder3);
        order4 = (Button) findViewById(R.id.Dessertorder4);
        order5 = (Button) findViewById(R.id.Dessertorder5);
        final Bundle b = getIntent().getExtras();
        myaccount = (Button) findViewById(R.id.btnMyAccount);
        ordersummary = (Button) findViewById(R.id.btnOrderSummary);
        logout = (Button) findViewById(R.id.btnLogOut);


        mcdelivery.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dessert.this,home.class);
                intent.putExtras(b);
                startActivity(intent);
                finish();

            }

        });

        order1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ ;
                Intent intent = new Intent(Dessert.this, OrderConfirmation.class);

                b.putString("prodname",  DessertName.get(0));
                b.putString("prodprice", DessertPrice.get(0));
                b.putString("imagename", "applepie");
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
        order2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dessert.this, OrderConfirmation.class);
                b.putString("prodname",  DessertName.get(1));
                b.putString("prodprice", DessertPrice.get(1));
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
        order3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dessert.this, OrderConfirmation.class);
                b.putString("prodname",  DessertName.get(2));
                b.putString("prodprice", DessertPrice.get(2));
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
        order4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dessert.this, OrderConfirmation.class);
                b.putString("prodname",  DessertName.get(3));
                b.putString("prodprice", DessertPrice.get(3));
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
        order5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dessert.this, OrderConfirmation.class);
                b.putString("prodname",  DessertName.get(4));
                b.putString("prodprice", DessertPrice.get(4));
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
        myaccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dessert.this,MyAccount.class);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
        ordersummary.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dessert.this,ordersummary.class);
                String osbe = "dessert";
                b.putString("ordersummaryback", osbe);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dessert.this, MainActivity.class);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
        databaseProductsDesserts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot child: dataSnapshot.getChildren()) {
                    HashMap<String, String> value = (HashMap<String, String>) child.getValue();

                    String name = value.get("Name");
                    String price = String.valueOf(value.get("Price"));
                    DessertName.add(name);
                    DessertPrice.add(price);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}
