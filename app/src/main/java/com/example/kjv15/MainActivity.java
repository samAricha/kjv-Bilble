package com.example.kjv15;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lView, verseView;
    DatabaseHelper dbHelper;
    private static MainActivity instance;//declaring an instance of MainActivity class.

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view=View.inflate(MainActivity.this,R.layout.verses,null);
        verseView=(ListView) findViewById(R.id.verseView);
        lView=findViewById(R.id.listView);
        dbHelper = new DatabaseHelper(MainActivity.this);
        instance=this;//initializing an instance of MainActivity class.

        displayBooks();

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getBaseContext(), Verses.class);
                intent.putExtra("book",position+1);
                startActivity(intent);
            }
        });

    }


    //method for displaying the books in a list view.
    private void displayBooks(){
        List<BookModel>bookList=dbHelper.getBooks();
        ArrayAdapter booksArrayAdapter=new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_dropdown_item_1line,bookList);
        lView.setAdapter(booksArrayAdapter);
    }


    //calling  method from main activity to another class.
    public static MainActivity getInstance(){
        return instance;
    }

}