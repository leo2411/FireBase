package com.example.leo.firebasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fir-demo-b8cb9.firebaseio.com/Users");

        mListView = (ListView) findViewById(R.id.listview);
        FirebaseListAdapter<String> firebaseListAdapter = new FirebaseListAdapter<String>(
                this,String.class,android.R.layout.simple_list_item_1,databaseReference) {
            @Override
            protected void populateView(View v, String model, int position) {
                TextView textView = (TextView) v.findViewById(android.R.id.text1);
                textView.setText(model);
            }
        };
        mListView.setAdapter(firebaseListAdapter);
    }
}
