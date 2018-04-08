package com.ceamaitareechipa.h44x.ochiullazarului;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

public class LitereActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litere);
        final String clasa = getIntent().getStringExtra("numar_clasa");
        final JSONObject finalTest = HomrActivity.orarJSON;
        char litera_clasa = 'a';
        for(int i =1; i<= 3;i++) {
            final char litera_final = litera_clasa;
            final Button button2 = findViewById(getResources().getIdentifier("button_" + litera_clasa, "id", getPackageName()));
            button2.setText(clasa + litera_clasa);
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(LitereActivity.this, TabelActivity.class);
                    intent.putExtra("clasa", clasa + litera_final);
                    intent.putExtra("orar", finalTest.optJSONObject(clasa + litera_final).toString());
                    startActivity(intent);
                }
            });
            litera_clasa = (char)((int)litera_clasa + 1);
        }




    }
}
