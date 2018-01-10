package com.ceamaitareechipa.h44x.ochiullazarului;

/**
 * Created by tiberiuureche on 10/01/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "OrarInfo";
    // Contacts table name
    private static final String TABLE_TIMETABLE = "orar";
    // Shops Table Columns names
    private static final String KEY_CODE = "CODUL";
    private static final String KEY_ID = "INDEX";
    private static final String KEY_PASS = "PAROLA";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE" + TABLE_TIMETABLE + "(" + KEY_ID + "INT,"
                + KEY_CODE + " INT," + KEY_PASS + " TEXT," + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TIMETABLE);
// Creating tables again
        onCreate(db);
    }
    // Adding new shop
    public void addShop(Shop shop) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CODE, shop.getCode()); // Shop Name
        values.put(KEY_PASS, shop.getPass());// Shop Phone Number
        values.put(KEY_ID, shop.getId());

// Inserting Row
        db.insert(TABLE_TIMETABLE, null, values);
        db.close(); // Closing database connection
    }


    // Getting one shop
    public Shop getShop(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_TIMETABLE, new String[]{KEY_ID,
                KEY_CODE, KEY_PASS}, KEY_ID + "=?",
        new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Shop contact = new Shop(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
// return shop
        return contact;
    }
    // Getting All Shops
    public List<Shop> getAllShops() {
        List<Shop> shopList = new ArrayList<Shop>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_TIMETABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Shop shop = new Shop();
                shop.setID(Integer.getInteger(String.valueOf(0)));
                shop.setCode(cursor.getString(1));
                shop.setPass(cursor.getString(2));
// Adding contact to list
                shopList.add(shop);
            } while (cursor.moveToNext());
        }

// return contact list
        return shopList;
    }

    // Updating a shop
    public int updateShop(Shop shop) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CODE, shop.getCode());
        values.put(KEY_PASS, shop.getPass());

// updating row
        return db.update(TABLE_TIMETABLE, values, KEY_ID + " = ?",
        new String[]{String.valueOf(shop.getId())});
    }


}