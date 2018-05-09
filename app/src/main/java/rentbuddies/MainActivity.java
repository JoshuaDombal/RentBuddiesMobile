package com.example.dombalj.rentbuddies;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;
import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView rent;
    public EditText monthlyValueText;
    public EditText numRoomatesText;

    static String houseName = "Unnamed";
    static double monthlyValue = 0;
    static double numRoomates = 0;
    static double totalRent = 0;


    public TextView totalRentView;
    public TextView numRoomatesView;
    public TextView houseNameView;

    House house = new House(" ", 0, 0);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        House newHouse = new House("hi", 0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        totalRentView = findViewById(R.id.totalMonthlyRent);
        totalRentView.setText(totalRentView.getText().toString() + totalRent);

        numRoomatesView = findViewById(R.id.numberOfRoomates);
        numRoomatesView.setText(numRoomatesView.getText().toString() + new DecimalFormat("#").format(numRoomates));

        houseNameView = findViewById(R.id.housename);
        houseNameView.setText(houseNameView.getText().toString() + houseName);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });

        Button button1 = (Button)findViewById(R.id.CalculateRent);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                //Intent intent=new Intent(MainActivity.this,HouseInfo.class);
                //startActivityForResult(intent, 2);// Activity is started with requestCode 2

                rent = findViewById(R.id.monthlyRent);

                if (monthlyValue == 0 || numRoomates == 0) {
                    rent.setText(" ");

                    rent.setText(rent.getText().toString() + "  Enter info in Edit");
                } else {
                    //monthlyValueText = findViewById(R.id.totalRent);
                    //numRoomatesText = findViewById(R.id.numRoomates);
                    //monthlyValue = Double.parseDouble(monthlyValueText.getText().toString());
                    //numRoomates = Integer.parseInt(numRoomatesText.getText().toString());

                    double price = monthlyValue/numRoomates;

                    rent.setText("Monthly Rent: ");
                    rent.setText(rent.getText().toString() + " $" +  new DecimalFormat("#.##").format(price));
                }


            }
        });


        Button button2 = (Button)findViewById(R.id.Edit);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HouseInfo.class);
                startActivity(intent);
            }
        });

        Button button3 = (Button)findViewById(R.id.Map);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });




    }


    @Override
    public void onResume(){
        super.onResume();


        totalRentView = findViewById(R.id.totalMonthlyRent);
        totalRentView.setText("Total Rent: $" + monthlyValue);


        numRoomatesView = findViewById(R.id.numberOfRoomates);
        numRoomatesView.setText("Number of Roomates: " + new DecimalFormat("#").format(numRoomates));

        houseNameView = findViewById(R.id.housename);
        houseNameView.setText("House Name: " + houseName);

    }


/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            //do the things u wanted
            monthlyValue = 2000;
            numRoomates = 5;


        }
    }

*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public House giveHouse(House h) {
        return h;
    }

    //public void updateDisplay(View v){
    //    rent.setText(rent.getText().toString() + ((Button)v).getText());
    //}


    public static void setHouseName(String newHouseName) {
        houseName = newHouseName;
    }

    public static void setHousePrice(double newHousePrice) {
        monthlyValue = newHousePrice;
    }

    public static void setNumRoomates(double newNumRoomates) {
        numRoomates = newNumRoomates;
    }



    public String getHouseName() {
        return houseName;
    }

    public double getHousePrice() {

        return monthlyValue;
    }

    public double getNumRoomates() {
        return numRoomates;
    }


}
