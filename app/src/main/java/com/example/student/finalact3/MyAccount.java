package com.example.student.finalact3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MyAccount extends AppCompatActivity {
    ImageView mcdelivery;
    EditText fname,lname,bdaymonth,bdayday,bdayyear,mobilenumber,address;
    Button myaccount,ordersummary,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        mcdelivery = (ImageView) findViewById(R.id.mcdelivery);
        fname = (EditText) findViewById(R.id.txtMyAccountFirstName);
        lname = (EditText) findViewById(R.id.txtMyAccountLastName);
        bdaymonth = (EditText) findViewById(R.id.txtMyAccountMonth);
        bdayday = (EditText) findViewById(R.id.txtMyAccountDay);
        bdayyear = (EditText) findViewById(R.id.txtMyAccountYear);
        mobilenumber = (EditText) findViewById(R.id.txtMyAccountMobileNumber);
        address = (EditText) findViewById(R.id.txtMyAccountAddress);
        final Bundle b = getIntent().getExtras();
        myaccount = (Button) findViewById(R.id.btnMyAccount);
        ordersummary = (Button) findViewById(R.id.btnOrderSummary);
        logout = (Button) findViewById(R.id.btnLogOut);
        fname.setText(b.getString("firstname"));
        lname.setText(b.getString("lastname"));
        mobilenumber.setText(b.getString("mobilenumber"));
        address.setText(b.getString("address"));
        mcdelivery.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MyAccount.this,home.class);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
        myaccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MyAccount.this,MyAccount.class);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
        ordersummary.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MyAccount.this,ordersummary.class);
                String osbe = "myaccount";
                b.putString("ordersummaryback", osbe);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MyAccount.this, MainActivity.class);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
    }
}
