package com.ceamaitareechipa.h44x.ochiullazarului;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button3 = findViewById(R.id.profil);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfilulMeu.class);
                startActivity(intent);
            }
        });
        final Button button2 = findViewById(R.id.orarultuturor);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ORARActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonC = findViewById(R.id.sali);
        buttonC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SALIActivity.class);
                startActivity(intent);
            }
            });


        final Button buttonD = findViewById(R.id.evenimente);
        buttonD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivitatiActivity.class);
                startActivity(intent);

            }
        });

        final Button buttonJ = findViewById(R.id.credits);
        buttonJ.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Credits.class);
                startActivity(intent);
            }
        });

        final Button buttonE = findViewById(R.id.gotoexamen);
        buttonE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ExameneActivity.class);
                startActivity(intent);
            }
        });
    final Button buttonF = findViewById(R.id.button2);
    buttonF.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this , Chat.class);
            startActivity(intent);



        }
    });
    final Button buttonSMC = findViewById(R.id.buttonsmc);
    buttonSMC.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this, Test.class);
            startActivity(intent);
        }
    });

    }

}