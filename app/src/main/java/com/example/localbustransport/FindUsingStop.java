package com.example.localbustransport;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class FindUsingStop extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar toolbarfindbystop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_using_stop);

        toolbarfindbystop =findViewById(R.id.toolbarfindbystop);
        toolbarfindbystop.setTitle("Local Bus Guide");
        setSupportActionBar(toolbarfindbystop);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
