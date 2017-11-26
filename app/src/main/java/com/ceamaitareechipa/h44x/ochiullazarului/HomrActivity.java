package com.ceamaitareechipa.h44x.ochiullazarului;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        final EditText email = findViewById(R.id.editText);
        final EditText password = findViewById(R.id.editText2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (email.getText().length()!=0 && password.getText().length()!=0){
                    Intent intent = new Intent(HomrActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HomrActivity.this);
                    final TextView text = new TextView(HomrActivity.this);
                    text.setText("Introdu parola si adresa de email!");
                    text.setPadding(50,50,0,0);
                    // set prompts.xml to alertdialog builder
                    alertDialogBuilder.setView(text);
                    // set dialog message
                    alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    // show it
                    alertDialog.show();
                }

            }
        });


    }

}
