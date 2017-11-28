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
        final String clasa = "9a";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litere);
        JSONObject test = null;
        try {
            test = new JSONObject("{\n" +
                    "  \"9a\": {\n" +
                    "    \"1\":\n" +
                    "    [\n" +
                    "      {\n" +
                    "        \"8\": \"Matematica\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"9\": \"Romana\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"10\": \"Informatica\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"11\": \"Biologie\"\n" +
                    "      },\n" +
                    "\n" +
                    "      {\n" +
                    "        \"12\": \"Muzica\"\n" +
                    "      },\n" +
                    "\n" +
                    "      {\n" +
                    "        \"13\": \"Sport\"\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  },\n" +
                    "  \"9b\": {\n" +
                    "    \"1\":\n" +
                    "    [\n" +
                    "      {\n" +
                    "        \"08\": \"Romana\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"09\": \"Matematica\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"10\": \"Desen\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"11\": \"Informatica\"\n" +
                    "      },\n" +
                    "\n" +
                    "      {\n" +
                    "        \"12\": \"Biologie\"\n" +
                    "      },\n" +
                    "\n" +
                    "      {\n" +
                    "        \"13\": \"Fizica\"\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  }\n" +
                    "}");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final Button button2 = findViewById(R.id.buttonA);
        final JSONObject finalTest = test;
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LitereActivity.this, TabelActivity.class);
                intent.putExtra("orar", finalTest.optJSONObject(clasa).toString());
                startActivity(intent);
            }
        });


    }
}
