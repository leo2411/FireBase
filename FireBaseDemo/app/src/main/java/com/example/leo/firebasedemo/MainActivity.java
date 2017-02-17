package com.example.leo.firebasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText mvalue;
    private Button mButton;
    private Firebase mRootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootRef = new Firebase("https://fir-demo-b8cb9.firebaseio.com/Name");

        mvalue = (EditText) findViewById(R.id.value);

        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String,String> map = dataSnapshot.getValue(Map.class);
                String name = map.get("Name");
                String age = map.get("Age");
                String profession = map.get("Profession");

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
}
