package com.ceamaitareechipa.h44x.ochiullazarului;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.sql.SQLData;

import java.util.List;

public class ListaEleviActivity extends AppCompatActivity  {

//    DBHandler db = new DBHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DBHandler db = new DBHandler(this);

        setContentView(R.layout.activity_lista_elevi);
        LinearLayout mainLayout = findViewById(R.id.laylay);
        for (int i = 1; i <= 5; i++) {
            db.addShop(new Shop(i, "eA2d2Sd98" + i, "1234" + i));
        }
        List<Shop> list = db.getAllShops();
        for (int j = 1; j <= 4; j++) {
            TextView text = new TextView(this);
            Shop shop = list.get(j);
            text.setText(shop.getId() + " " + shop.getCode() + " " + shop.getPass());
            mainLayout.addView(text);
        }
    }

}

