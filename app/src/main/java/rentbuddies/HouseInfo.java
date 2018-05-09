package com.example.dombalj.rentbuddies;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.dombalj.rentbuddies.House.*;

public class HouseInfo extends AppCompatActivity {

    House h = new House(" ", 0, 0);

    EditText houseName;
    EditText monthlyRent;
    EditText numberRoomates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        Button button = (Button)findViewById(R.id.update);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                houseName = findViewById(R.id.houseName);
               // house.setHouseName(houseName.getText().toString());
                MainActivity.setHouseName(houseName.getText().toString());


                monthlyRent = findViewById(R.id.totalRent);
                String dString = monthlyRent.getText().toString();
                if (!dString.isEmpty()) {
                    Double d = Double.parseDouble(dString);
                    MainActivity.setHousePrice(d);
                }

                numberRoomates = findViewById(R.id.numRoomates);
                String iString = numberRoomates.getText().toString();
                if (!iString.isEmpty()) {
                    double i = Double.parseDouble(iString);
                    MainActivity.setNumRoomates(i);
                }


                //giveHouse(h);
            }
        });


        /*
        EditText edit1 = findViewById(R.id.totalRent);
        edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double monthlyValue = 10000;


                String message="hello ";
                Intent intent=new Intent();
                intent.putExtra("MESSAGE",message);
                setResult(2,intent);
                finish();//finishing activity
            }
        });*/



    }

}
