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
    private FirebaseDatabase database;
    private DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    User user;
    private Spinner city_name_spinner , route_spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        city_name_spinner = (Spinner)findViewById(R.id.city_spinner);
        route_spinner = (Spinner)findViewById(R.id.route_spinner);

        String cityname = city_name_spinner.getSelectedItem().toString().trim();
        String routenumber = route_spinner.getSelectedItem().toString().trim();


        user = new User();
        listView = (ListView)findViewById(R.id.busroutelistview);

        toolbarofretrieveactivity =findViewById(R.id.toolbarofretrieveactivity);
        toolbarofretrieveactivity.setTitle("Your Route Info");
        setSupportActionBar(toolbarofretrieveactivity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        database = FirebaseDatabase.getInstance();
        ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Delhi").child("Route 1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren() )
                {
                    User user = snapshot.getValue(User.class);
                    System.out.println(user.getBusStopName());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.bus_info,R.id.bus_stop_text,list);

//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                for(DataSnapshot ds: dataSnapshot.getChildren())
//                {
//                    user = ds.getValue(User.class);
//                    list.add(user.getBusStopName().toString() + "  " + user.getBusStopNumber().toString());
//                }
//
//                listView.setAdapter(adapter);
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//
//
//            }
//        });

    }
}
