package com.ceamaitareechipa.h44x.ochiullazarului;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivitatiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitati);

        final Button buttonP = findViewById(R.id.detalii);
        buttonP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ActivitatiActivity.this, InformatiiActivity.class);
                startActivity(intent);
            }
        });
    }
}