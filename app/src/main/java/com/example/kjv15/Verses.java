package com.example.kjv15;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.List;

public class Verses extends AppCompatActivity  {
    ListView versesLView;
    DatabaseHelper databaseHelper;
    Context context;
    private int book;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verses);
        versesLView=findViewById(R.id.verseView);

        databaseHelper=new DatabaseHelper(this);
        Intent intent=getIntent();

       book = intent.getIntExtra("book",1);

       List<VersesModel>verses = databaseHelper.getAllVerses(book);
       ArrayAdapter versesArrayAdapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,verses);
       versesLView.setAdapter(versesArrayAdapter);

    }
}