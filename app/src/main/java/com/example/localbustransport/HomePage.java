package com.example.localbustransport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class HomePage extends AppCompatActivity{

    private long backpressedtime;
    private Toast backtoast;
    private DrawerLayout drawer;
    private Spinner city_name_spinner , route_spinner;
    private Button locatebusbutton , locatebystopbutton;
    androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        toolbar = findViewById(R.id.toolbarhomepage);
        toolbar.setTitle("Local Bus Guide");
        setSupportActionBar(toolbar);

        locatebusbutton = (Button)findViewById(R.id.findusingstop);
        locatebusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this,FindUsingStop.class));
            }
        });

        locatebusbutton = (Button) findViewById(R.id.locatebusbutton);
        locatebusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, Retrieve.class));
            }
        });


        city_name_spinner = (Spinner) findViewById(R.id.city_spinner);

        ArrayAdapter<CharSequence> adapterforcity = ArrayAdapter.createFromResource(this,
                R.array.city_names, android.R.layout.simple_spinner_item);
        adapterforcity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city_name_spinner.setAdapter(adapterforcity);
        city_name_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {
                    case 0:
                        String text = adapterView.getItemAtPosition(i).toString();
//                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                        break;

                    case 1:
                        String cityonetext = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(HomePage.this,cityonetext+" is selected",Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        String citytwotext = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(HomePage.this,citytwotext+" is selected",Toast.LENGTH_SHORT).show();
                        break;

                    case 3:
                        String citythreetext = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(HomePage.this,citythreetext+" is selected",Toast.LENGTH_SHORT).show();
                        break;

                    case 4:
                        String cityfourtext = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(HomePage.this,cityfourtext+" is selected",Toast.LENGTH_SHORT).show();
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        route_spinner = (Spinner) findViewById(R.id.route_spinner);

        ArrayAdapter<CharSequence> adapterforroute = ArrayAdapter.createFromResource(this,
                R.array.route_numbers, android.R.layout.simple_spinner_item);
        adapterforroute.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        route_spinner.setAdapter(adapterforroute);
        route_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {

                    case 0:
                        String text = adapterView.getItemAtPosition(i).toString();
                        break;

                    case 1:
                        String routeonetext = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(HomePage.this,routeonetext+" is selected",Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        String routetwotext = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(HomePage.this,routetwotext+" is selected",Toast.LENGTH_SHORT).show();
                        break;

                    case 3:
                        String routethreetext = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(HomePage.this,routethreetext+" is selected",Toast.LENGTH_SHORT).show();
                        break;

                    case 4:
                        String routefourtext = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(HomePage.this,routefourtext+" is selected",Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    //End of OnCreate

    @Override
    public void onBackPressed() {
        if(backpressedtime+2000>System.currentTimeMillis()){
            backtoast.cancel();
            super.onBackPressed();
            return;
        }
        else {
            backtoast= Toast.makeText(HomePage.this,
                    "Press back again to Exit",Toast.
                            LENGTH_SHORT);
            backtoast.show();

        }
        backpressedtime = System.currentTimeMillis();
    }


    //End of OnBackPressed method

}
