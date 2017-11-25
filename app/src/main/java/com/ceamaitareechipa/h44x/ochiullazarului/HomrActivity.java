package com.ceamaitareechipa.h44x.ochiullazarului;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_homr);

        final Button button3 = findViewById(R.id.button_sign_up);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomrActivity.this, SignUp.class);
                startActivity(intent);
            }
        });
        final Button button2 = findViewById(R.id.button_log_in);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomrActivity.this, MainActivity.class);
                startActivity(intent);


            }
        });


    }

}
