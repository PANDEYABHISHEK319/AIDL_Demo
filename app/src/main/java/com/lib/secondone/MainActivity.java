package com.lib.secondone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import com.lib.mylibrary.ITracking;

public class MainActivity extends AppCompatActivity {


    Context context;
    Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        service = new MyService(context);

    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = new Intent(getContext(), service.getClass());
        bindService(intent, connection, BIND_AUTO_CREATE);

    }


    private Context getContext() {

        return context;
    }


    private ITracking tracking;
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            try {
                tracking.onOrientationUpdate(2,2,2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };


}
