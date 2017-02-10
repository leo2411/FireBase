package com.example.leo.firebasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private EditText mName,mvalue;
    private Button mButton;
    private Firebase mRootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootRef = new Firebase("https://fir-demo-b8cb9.firebaseio.com/Users");

        mName = (EditText) findViewById(R.id.editText);
        mvalue = (EditText) findViewById(R.id.value);
        mButton = (Button) findViewById(R.id.addbutton);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = mName.getText().toString();
                String value = mvalue.getText().toString();

                Firebase childRef = mRootRef.child(value);

                childRef.setValue(name);
            }
        });

    }
}
