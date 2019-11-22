package com.lib.secondone;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.lib.mylibrary.ITracking;

public class MyService extends Service {
    Context mContext;
    Sensor sensor;
    SensorEventListener listener;
    SensorManager sensorManager;

    public MyService(Context context) {
        mContext = context;
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }


   /* void registerCallback(ITrackingCallback callback);
    void unregisterCallback(ITrackingCallback callback);*/


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

            if(sensorManager != null){
                sensor =  sensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR);
            }

                    if(sensor!= null){
                        Toast.makeText(mContext,"Sensor Not available",Toast.LENGTH_LONG).show();
                    }

        return new SimpleSer();
    }

    public class SimpleSer extends ITracking.Stub {
        @Override
        public void onOrientationUpdate(float x, float y, float z) throws RemoteException {


        }

    }
}
