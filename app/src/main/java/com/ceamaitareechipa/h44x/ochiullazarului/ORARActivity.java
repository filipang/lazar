package com.ceamaitareechipa.h44x.ochiullazarului;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ORARActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orar);

        final Button button3 = findViewById(R.id.cls9);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ORARActivity.this, LitereActivity.class);
                intent.putExtra("numar_clasa", "9");
                startActivity(intent);
            }
        });

        final Button button4 = findViewById(R.id.cls10);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ORARActivity.this, LitereActivity.class);
                intent.putExtra("numar_clasa", "10");
                startActivity(intent);
            }
        });

        final Button button5 = findViewById(R.id.cls11);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ORARActivity.this, LitereActivity.class);
                intent.putExtra("numar_clasa", "11");
                startActivity(intent);
            }
        });

        final Button button6 = findViewById(R.id.cls12);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ORARActivity.this, LitereActivity.class);
                intent.putExtra("numar_clasa", "12");
                startActivity(intent);
            }
        });


        final Button buttonev = findViewById(R.id.evenimente);
        buttonev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ORARActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
