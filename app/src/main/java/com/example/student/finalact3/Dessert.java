package com.example.student.finalact3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    Button mcdelivery,order1,order2,order3,order4,order5;
    TextView Users;
    DatabaseReference databaseProductsDesserts,databaseUsernamesPasswords;;
    ArrayList<String> DessertName = new ArrayList<String>();
    ArrayList<String> DessertPrice = new ArrayList<String>();
    ArrayList<String> User = new ArrayList<String>();
    ArrayList<String> Pass = new ArrayList<String>();
    ArrayList<String> Fname = new ArrayList<String>();
    ArrayList<String> Lname = new ArrayList<String>();
    ArrayList<String> Mnumber = new ArrayList<String>();
    ArrayList<String> Add = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);
        databaseProductsDesserts = FirebaseDatabase.getInstance().getReference("Products").child("Desserts");
        databaseUsernamesPasswords = FirebaseDatabase.getInstance().getReference("Users");
        mcdelivery = (Button) findViewById(R.id.mcdelivery);
        order1 = (Button) findViewById(R.id.Dessertorder1);
        order2 = (Button) findViewById(R.id.Dessertorder2);
        order3 = (Button) findViewById(R.id.Dessertorder3);
        order4 = (Button) findViewById(R.id.Dessertorder4);
        order5 = (Button) findViewById(R.id.Dessertorder5);
        Users = (TextView) findViewById(R.id.txtUser);
        final Bundle b = getIntent().getExtras();
        Users.setText("Hi,  "+b.getString("firstname")+"!");

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

                    Intent in = new Intent(Dessert.this,OrderConfirmation.class);
                Bundle c = new Bundle();
                    c.putString("name", DessertName.get(0));
                    c.putString("price", DessertPrice.get(0));
                c.putString("firstname", Fname.get(0));
                c.putString("lastname", Lname.get(0));
                c.putString("mobilenumber", Mnumber.get(0));
                c.putString("address", Add.get(0));
                c.putString("password", Pass.get(0));
                    in.putExtras(c);
                    startActivity(in);
                    finish();

            }

        });
        order2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dessert.this,OrderConfirmation.class);
                Bundle de = new Bundle();
                de.putString("prodname", DessertName.get(1));
                de.putString("prodprice", DessertPrice.get(1));
                intent.putExtras(de);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
        order3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dessert.this,OrderConfirmation.class);
                Bundle de = new Bundle();
                de.putString("prodname", DessertName.get(2));
                de.putString("prodprice", DessertPrice.get(2));
                intent.putExtras(de);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
        order4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dessert.this,OrderConfirmation.class);
                Bundle de = new Bundle();
                de.putString("prodname", DessertName.get(3));
                de.putString("prodprice", DessertPrice.get(3));
                intent.putExtras(de);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
        order5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dessert.this,OrderConfirmation.class);
                Bundle de = new Bundle();
                de.putString("prodname", DessertName.get(4));
                de.putString("prodprice", DessertPrice.get(4));
                intent.putExtras(de);
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
                    String price = value.get("Price");
                    String user = value.get("Email");
                    String pass = value.get("Password");
                    String fname = value.get("First Name");
                    String lname = value.get("Last Name");
                    String mnumber = value.get("Mobile Number");
                    String add = value.get("Address");
                    User.add(user);
                    Pass.add(pass);
                    Fname.add(fname);
                    Lname.add(lname);
                    Mnumber.add(mnumber);
                    Add.add(add);
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
