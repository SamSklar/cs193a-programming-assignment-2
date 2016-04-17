/*
This is a To-Do list application.  It allows users to enter
items to the list, view the tasks they need to do on screen,
and remove items by long clicking on them.  By Sam Sklar.
 */

package com.example.samsklar.to_do_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<String> toDoItems = new ArrayList<String>();
    android.widget.ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, toDoItems);
        android.widget.ListView list = (android.widget.ListView) findViewById(R.id.myList);
        list.setAdapter(adapter);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                toDoItems.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }





    public void addButtonClicked(View view) {
        TextView textView = (TextView) findViewById(R.id.newItemText);
        String currText = textView.getText().toString();
        toDoItems.add(currText);
        adapter.notifyDataSetChanged();

    }
}
