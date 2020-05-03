package com.example.kjv15;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Verses extends AppCompatActivity {
    ListView verseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verses);
        verseView=findViewById(R.id.verseView);
    }


    public void displayVerses(int position){
        verseView=(ListView) findViewById(R.id.verseView);
        DatabaseHelper databaseHelper=new DatabaseHelper(this);
        List<VersesModel> verses=databaseHelper.getAllVerses(position);
        ArrayAdapter versesArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,verses);
        verseView.setAdapter(versesArrayAdapter);

    }
}