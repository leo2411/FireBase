package com.example.leo.firebasedemo;

import android.app.Application;
import com.firebase.client.Firebase;

/**
 * Created by Leo on 10.2.2017..
 */

public class FireBaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
