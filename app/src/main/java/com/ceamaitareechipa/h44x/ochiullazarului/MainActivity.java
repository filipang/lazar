package com.ceamaitareechipa.h44x.ochiullazarului;

import android.content.Intent;
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
                Intent intent = new Intent(MainActivity.this, CreditsActivity.class);
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

}}