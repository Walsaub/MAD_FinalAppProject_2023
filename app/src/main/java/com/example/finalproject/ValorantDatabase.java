package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.finalproject.pojo.Weapon;

import java.util.ArrayList;

public class ValorantDatabase extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "valorantdb";

    /** Weapons Table **/
    public static final String TABLE_WEAPON = "weapon";
    public static final String COLUMN_WEAPON_ID = "id";
    public static final String COLUMN_WEAPON_NAME = "name";
    public static final String COLUMN_WEAPON_CATEGORY = "category";
    public static final String COLUMN_WEAPON_DISPLAYICON = "displayIcon";
    public static final String CREATE_WEAPONS_TABLE = "CREATE TABLE " +
            TABLE_WEAPON + "(" + COLUMN_WEAPON_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_WEAPON_NAME + " TEXT, "
            + COLUMN_WEAPON_CATEGORY + "TEXT, "
            + COLUMN_WEAPON_DISPLAYICON + " TEXT)";

    public ValorantDatabase(@Nullable Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_WEAPONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public void addWeapon(Weapon weapon){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_WEAPON_NAME, weapon.getName());
        values.put(COLUMN_WEAPON_CATEGORY, weapon.getCategory());
        values.put(COLUMN_WEAPON_DISPLAYICON, weapon.getDisplayIcon());
        db.insert(TABLE_WEAPON, null, values);
        db.close();
        Log.d("SQL", "Weapon Added");
    }

    public Weapon getWeapon(int id){
        SQLiteDatabase db  = this.getReadableDatabase();
        Weapon weapon = null;
        Cursor cursor = db.query(TABLE_WEAPON,
                new String[]{COLUMN_WEAPON_ID, COLUMN_WEAPON_NAME, COLUMN_WEAPON_CATEGORY, COLUMN_WEAPON_DISPLAYICON},
                COLUMN_WEAPON_ID + "= ?"
                , new String[]{String.valueOf(id)},
                null, null, null);
        if(cursor.moveToFirst()){ //Checking that we have a value and select it to be read
            weapon = new Weapon(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3));
        }
        db.close();
        return weapon;
    }

    public ArrayList<Weapon> getAllWeapons(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Weapon> weapons = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_WEAPON, null);
        Log.d("SQL", "Weapon Table: " + cursor.getCount() + " records");
        while(cursor.moveToNext()){
            weapons.add(new Weapon(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)));
        }
        db.close();
        return weapons;
    }


    /** UPDATING (for the future)
    public int updateLocation(Location location){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, location.getName());
        values.put(COLUMN_DESCRIPTION, location.getDescription());
        values.put(COLUMN_GEO, location.getLocation());
        values.put(COLUMN_LONGITUDE, location.getLongitude());
        values.put(COLUMN_LATITUDE, location.getLatitude());
        values.put(COLUMN_TEMP, location.getTemp());
        values.put(COLUMN_LAST_UPDATE, location.getLastUpdated());
        return db.update(TABLE_LOCATION, values, COLUMN_ID + "=?",
                new String[]{String.valueOf(location.getId())});
     }

     DELETING
     public void deleteLocation(int location){
     SQLiteDatabase db = this.getWritableDatabase();
     db.delete(TABLE_LOCATION, COLUMN_ID + "=?",
     new String[]{String.valueOf(location)});
     db.close();
     }
     **/
}
