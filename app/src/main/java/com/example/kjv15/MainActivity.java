package com.example.kjv15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lView;
    DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lView=findViewById(R.id.listView);

        displayBooks();

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private void displayBooks(){
        dbHelper = new DatabaseHelper(MainActivity.this);
        List<BookModel>bookList=dbHelper.getBooks();
        ArrayAdapter booksArrayAdapter=new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_dropdown_item_1line,bookList);
        lView.setAdapter(booksArrayAdapter);
    }

}