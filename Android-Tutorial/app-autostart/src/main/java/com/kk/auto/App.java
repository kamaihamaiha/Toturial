package com.kk.auto;

import android.app.Application;
import android.content.Intent;

import com.kk.auto.service.StartSelfService;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(getApplicationContext(), StartSelfService.class));
    }
}
