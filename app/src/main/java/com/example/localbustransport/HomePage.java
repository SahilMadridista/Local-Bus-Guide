package com.example.localbustransport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.common.api.Api;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity{

    private long backpressedtime;
    private Toast backtoast;
//    private DrawerLayout drawer;
    private ListView listView;
    private DatabaseReference databaseReference;
    private Spinner city_name_spinner , route_spinner;
    private Button locatebusbutton , locatebystopbutton;
    androidx.appcompat.widget.Toolbar toolbar;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    City city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        city = new City();
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.bus_info,R.id.bus_stop_text,list);

        listView = (ListView)findViewById(R.id.listviewofroutes);

        city_name_spinner = (Spinner) findViewById(R.id.city_spinner);
        route_spinner = (Spinner) findViewById(R.id.route_spinner);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Delhi");

        toolbar = findViewById(R.id.toolbarhomepage);
        toolbar.setTitle("Local Bus Guide");
        setSupportActionBar(toolbar);

        locatebystopbutton = (Button)findViewById(R.id.findusingstop);
        locatebystopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this,FindUsingStop.class));
            }
        });

        locatebusbutton = (Button)findViewById(R.id.locatebusbutton);
        locatebusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for(DataSnapshot ds : dataSnapshot.getChildren())
                        {
                            city = ds.getValue(City.class);
                            list.add(city.getStop_1().toString());
                            list.add(city.getStop_2().toString());
                            list.add(city.getStop_3().toString());
                            list.add(city.getStop_4().toString());
                            list.add(city.getStop_5().toString());
                        }

                        listView.setAdapter(adapter);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
        });



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
                        //databaseReference = FirebaseDatabase.getInstance().getReference().child(cityonetext);
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
