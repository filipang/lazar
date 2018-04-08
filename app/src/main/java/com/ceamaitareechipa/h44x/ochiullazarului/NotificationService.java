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
        boolean notify = true;
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        Calendar calendar = Calendar.getInstance();
        int dayValue = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int timeValue = calendar.get(Calendar.HOUR_OF_DAY) * 60 * 60 + calendar.get(Calendar.MINUTE)*60 + calendar.get(Calendar.SECOND);
        int hourIndex, offset;
        if(timeValue <= TimeSec(18,30) && timeValue >= TimeSec(7,30)){
            if(timeValue < 12*60*60+45*60 && timeValue >= 12*60*60 + 25*60){
                offset = 12*60*60 + 45*60 - timeValue;
                try {
                    if (!HomrActivity.orarJSON.getJSONObject("9c").getJSONObject("" + dayValue).optString("" + (7)).equals("")) {
                        if (offset/60 == 19) {
                            if (60 - offset % 60 == 1) {
                                text = "Ora de " + HomrActivity.orarJSON.getJSONObject("9c").getJSONObject("" + dayValue).optString("" + 7) + " incepe peste " + offset/ 60 + " minut si " + offset % 60 + " secunda.";
                            } else {
                                text = "Ora de " + HomrActivity.orarJSON.getJSONObject("9c").getJSONObject("" + dayValue).optString("" + 7) + " incepe peste " + offset / 60 + " minut si " + offset % 60 + " secunde.";

                            }
                        } else {
                            if (60 - offset % 60 == 1) {
                                text = "Ora de " + HomrActivity.orarJSON.getJSONObject("9c").getJSONObject("" + dayValue).optString("" + 7) + " incepe peste " + offset / 60 + " minute si " + offset % 60 + " secunda.";
                            } else {
                                text = "Ora de " + HomrActivity.orarJSON.getJSONObject("9c").getJSONObject("" + dayValue).optString("" + 7) + " incepe peste " + offset / 60 + " minute si " + offset % 60 + " secunda.";
                            }
                        }
                    } else {
                        notify = false;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else {
                if (timeValue >= TimeSec(12, 45, 0)) {
                    timeValue = timeValue - 15 * 60;
                    hourIndex = (timeValue - 7 * 60 * 60 - 30 * 60) / (50 * 60) + 1;
                    offset = (timeValue - 7 * 60 * 60 - 30 * 60) % (50 * 60);
                } else {
                    hourIndex = (timeValue - 7 * 60 * 60 - 30 * 60) / (50 * 60) + 1;
                    offset = (timeValue - 7 * 60 * 60 - 30 * 60) % (50 * 60);
                }
                try {
                    if (offset < 45 * 60) {
                        if (!HomrActivity.orarJSON.getJSONObject("9c").getJSONObject("" + dayValue).optString("" + hourIndex).equals("")) {
                            if (offset / 60 == 1) {
                                if (offset % 60 == 1) {
                                    text = "Ora de " + HomrActivity.orarJSON.getJSONObject("9c").getJSONObject("" + dayValue).optString("" + hourIndex) + " a inceput acum " + offset / 60 + " minut si " + offset % 60 + " secunda.";
                                } else {
                                    text = "Ora de " + HomrActivity.orarJSON.getJSONObject("9c").getJSONObject("" + dayValue).optString("" + hourIndex) + " a inceput acum " + offset / 60 + " minut si " + offset % 60 + " secunde.";

                                }
                            } else {
                                if (60 - offset % 60 == 1) {
                                    text = "Ora de " + HomrActivity.orarJSON.getJSONObject("9c").getJSONObject("" + dayValue).optString("" + hourIndex) + " a inceput acum " + offset / 60 + " minute si " + offset % 60 + " secunda.";
                                } else {
                                    text = "Ora de " + HomrActivity.orarJSON.getJSONObject("9c").getJSONObject("" + dayValue).optString("" + hourIndex) + " a inceput acum " + offset / 60 + " minute si " + offset % 60 + " secunde.";
                                }
                            }
                        } else {
                            notify = false;
                        }
                    } else {
                        if (!HomrActivity.orarJSON.getJSONObject("9c").getJSONObject("" + dayValue).optString("" + (hourIndex + 1)).equals("")) {
                            if (offset/60 == 49) {
                                if (60 - offset % 60 == 1) {
                                    text = "Ora de " + HomrActivity.orarJSON.getJSONObject("9c").getJSONObject("" + dayValue).optString("" + (hourIndex + 1)) + " incepe peste " + (50 - offset / 60) + " minut si " + (60 - offset % 60) + " secunda.";
                                } else {
                                    text = "Ora de " + HomrActivity.orarJSON.getJSONObject("9c").getJSONObject("" + dayValue).optString("" + (hourIndex + 1)) + " incepe peste " + (50 - offset / 60) + " minut si " + (60 - offset % 60) + "secunde.";

                                }
                            } else {
                                if (60 - offset % 60 == 1) {
                                    text = "Ora de " + HomrActivity.orarJSON.getJSONObject("9c").getJSONObject("" + dayValue).optString("" + (hourIndex + 1)) + " incepe peste " + (50 - offset / 60) + " minute si " + (60 - offset % 60) + " secunda.";
                                } else {
                                    text = "Ora de " + HomrActivity.orarJSON.getJSONObject("9c").getJSONObject("" + dayValue).optString("" + (hourIndex + 1)) + " incepe peste " + (50 - offset / 60) + " minute si " + (60 - offset % 60) + " secunda.";
                                }
                            }
                        } else {
                            notify = false;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            notify = false;
        }



        if(notify) {
            mBuilder.setOngoing(true);
            mBuilder.setContentText(text);
            mBuilder.setContentTitle(title);
            mBuilder.setSmallIcon(R.drawable.logolzr3);

            Notification notification = mBuilder.build();
            manager.notify(0, notification);
        }
    }

    public static int TimeSec(int h, int m, int s){
        return h*60*60 + m*60 + s;
    }
    public static int TimeSec(int h, int m){
        return h*60*60 + m*60;
    }

}
