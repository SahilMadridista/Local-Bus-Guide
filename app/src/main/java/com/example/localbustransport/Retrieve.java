package com.example.localbustransport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Retrieve extends AppCompatActivity{

    androidx.appcompat.widget.Toolbar toolbarofretrieveactivity;
    private ListView listView;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    City city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        listView = (ListView)findViewById(R.id.busroutelistview);

        city = new City();


        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.bus_info,R.id.bus_stop_text,list);

        toolbarofretrieveactivity =findViewById(R.id.toolbarofretrieveactivity);
        toolbarofretrieveactivity.setTitle("Your Route Info");
        setSupportActionBar(toolbarofretrieveactivity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference("Delhi");

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
}
