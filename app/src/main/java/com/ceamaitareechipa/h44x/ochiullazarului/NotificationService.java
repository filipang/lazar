package com.ceamaitareechipa.h44x.ochiullazarului;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import org.json.JSONException;

import java.util.Calendar;
import java.util.Date;

public class NotificationService extends Service {

    public boolean isRepeating = false;

    public class LocalBinder extends Binder {
        NotificationService getService() {
            return NotificationService.this;
        }
    }

    private final IBinder mBinder = new LocalBinder();


    public NotificationService() {
    }

    android.app.NotificationManager manager;

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
    }

    private int mInterval = 1000;
    static public Handler mHandler;
    static public Runnable mStatusChecker;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        mHandler = new Handler();
        mStatusChecker = new Runnable() {
            @Override
            public void run() {
                UpdateOrarNotification();
                mHandler.postDelayed(mStatusChecker, mInterval);
            }
        };
        mStatusChecker.run();

        return START_NOT_STICKY;
    }

    public void UpdateOrarNotification(){
        String text = "", title = "LZR App Orar";
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        Calendar calendar = Calendar.getInstance();
        int dayValue = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int timeValue = calendar.get(Calendar.HOUR_OF_DAY) * 60 + calendar.get(Calendar.MINUTE);
        int hourIndex, offset;
        if(timeValue <= 18*60 + 30 && timeValue >= 7*60 + 30){
            if(timeValue < 12*60+45 && timeValue >= 12*60 + 25){
                hourIndex = (timeValue - 7*60 - 30)/50 + 1;
                offset = 12*60 + 45 - timeValue;
            }
            else{
                if(timeValue >= 12*60 + 45){
                    timeValue = timeValue - 15;
                    hourIndex = (timeValue - 7*60 - 30)/50 + 1;
                    offset = (timeValue - 7*60 - 30)%50;
                }
                else{
                    hourIndex = (timeValue - 7*60 - 30)/50 + 1;
                    offset = (timeValue - 7*60 - 30)%50;
                }
            }
            try {
                text = HomrActivity.orarJSON.getJSONObject("9c").getJSONObject("" + dayValue).optString("" + hourIndex) + " acum " + offset/60 + " minute si " + offset % 60 + " secunde.";
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else {
            text = "Sweet Freedom";
        }




        mBuilder.setOngoing(true);
        mBuilder.setContentText(text);
        mBuilder.setContentTitle(title);
        mBuilder.setSmallIcon(R.drawable.logolzr3);

        Notification notification = mBuilder.build();
        manager.notify(0, notification);

    }

}
