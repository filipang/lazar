package com.ceamaitareechipa.h44x.ochiullazarului;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;


import org.json.JSONException;
import org.json.JSONObject;

public class TabelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabel);
        int row;
        int col;
        for (col = 1; col <= 5; col++){
            for (row = 1; row <= 13; row++){
                int id = getResources().getIdentifier("ziua_"+col+"_ora_"+row, "id", getPackageName());
                TextView textView = findViewById(id);
                try {
                    JSONObject obj = new JSONObject("{\"9a\":\"Romana\"}");
                    textView.setText(obj.getString("9a"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }


        }


    }


