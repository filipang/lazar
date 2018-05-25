package com.ceamaitareechipa.h44x.ochiullazarului;

import android.app.Activity;
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

        final Button buttonO = findViewById(R.id.orar);
        buttonO.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ORARActivity.class);
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


        final Button buttonP = findViewById(R.id.detalii);
        buttonP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InformatiiActivity.class);
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





        final Button buttonE = findViewById(R.id.gotoexamen);
        buttonE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ExameneActivity.class);
                startActivity(intent);
            }
        });

}}