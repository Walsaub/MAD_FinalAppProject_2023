package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.finalproject.pojo.Agent;
import com.example.finalproject.pojo.Map;
import com.example.finalproject.pojo.Skin;
import com.example.finalproject.pojo.Weapon;

import java.util.ArrayList;
import java.util.Collection;

public class ValorantDatabase extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "valorantdb";

    /** Weapons Table **/
    public static final String TABLE_WEAPON = "weapon";
    public static final String COLUMN_WEAPON_ID = "id";
    public static final String COLUMN_WEAPON_NAME = "name";
    public static final String COLUMN_WEAPON_CATEGORY = "category";
    public static final String COLUMN_WEAPON_DISPLAYICON = "displayIcon";
    public static final String COLUMN_WEAPON_COST = "cost";
    public static final String COLUMN_WEAPON_FIRERATE = "firerate";
    public static final String COLUMN_WEAPON_MAGAZINESIZE = "size";
    public static final String COLUMN_WEAPON_RELOADTIME = "reloadTime";
    public static final String COLUMN_WEAPON_ZOOMMULTIPLIER = "zoomMultiplier";

    public static final String CREATE_WEAPONS_TABLE = "CREATE TABLE " +
            TABLE_WEAPON + "(" + COLUMN_WEAPON_ID + " INTEGER PRIMARY KEY, "
            + COLUMN_WEAPON_NAME + " TEXT, "
            + COLUMN_WEAPON_CATEGORY + " TEXT, "
            + COLUMN_WEAPON_DISPLAYICON + " TEXT, "
            + COLUMN_WEAPON_COST + " INTEGER, "
            + COLUMN_WEAPON_FIRERATE + " REAL, "
            + COLUMN_WEAPON_MAGAZINESIZE + " INTEGER, "
            + COLUMN_WEAPON_RELOADTIME + " REAL, "
            + COLUMN_WEAPON_ZOOMMULTIPLIER + " REAL)";
    //skins table

    public static final String TABLE_SKIN = "skin";
    public static final String COLUMN_SKIN_ID = "id";
    public static final String COLUMN_SKIN_IMAGE = "skinImage";
    public static final String COLUMN_SKIN_NAME = "skinName";
    public static final String COLUMN_SKIN_TIER = "skinTier";
    public static final String COLUMN_SKIN_SKINPRICE = "skinPrice";

    public static final String CREATE_SKINS_TABLE = "CREATE TABLE " +
            TABLE_SKIN + "(" + COLUMN_SKIN_ID + " INTEGER PRIMARY KEY, "
            + COLUMN_SKIN_IMAGE + " TEXT, "
            + COLUMN_SKIN_NAME + " TEXT, "
            + COLUMN_SKIN_TIER + " TEXT, "
            + COLUMN_SKIN_SKINPRICE + " INTEGER)";

    /* Maps table */

    //table name
    public static final String TABLE_MAP = "map";
    //column names
    public static final String COLUMN_MAP_ID = "id";
    public static final String COLUMN_MAP_IMAGE = "mapImage";
    public static final String COLUMN_MAP_NAME = "mapName";
    public static final String COLUMN_MAP_COORDINATES = "mapCoordinates";
    public static final String COLUMN_MAP_DESCRIPTION = "mapDescription";
    //The query to build the Map table
    public static final String CREATE_MAP_TABLE = "CREATE TABLE " +
            TABLE_MAP + "(" + COLUMN_MAP_ID + " INTEGER PRIMARY KEY, "
            + COLUMN_MAP_IMAGE + " TEXT, "
            + COLUMN_MAP_NAME + " TEXT, "
            +COLUMN_MAP_COORDINATES + " TEXT, "
            + COLUMN_MAP_DESCRIPTION + " TEXT)";

    /* Agents Table */

    //table name
    public static final String TABLE_AGENT = "agent";
    //column names
    public static final String COLUMN_AGENT_ID = "id";
    public static final String COLUMN_AGENT_NAME = "agentName";
    public static final String COLUMN_AGENT_ROLE = "agentRole";
    public static final String COLUMN_AGENT_IMAGE = "agentImage";
    public static final String COLUMN_AGENT_ROLE_IMAGE = "roleImage";
    public static final String COLUMN_AGENT_DESCRIPTION = "agentDescription";
    public static final String COLUMN_AGENT_ICON = "agentIcon";
    public static final String COLUMN_AGENT_FIRST_ABILITY_ICON = "firstAbilityIcon";
    public static final String COLUMN_AGENT_FIRST_ABILITY_DESCRIPTION = "firstAbilityDescription";
    public static final String COLUMN_AGENT_SECOND_ABILITY_ICON = "secondAbilityIcon";
    public static final String COLUMN_AGENT_SECOND_ABILITY_DESCRIPTION = "secondAbilityDescription";
    public static final String COLUMN_AGENT_THIRD_ABILITY_ICON = "thirdAbilityIcon";
    public static final String COLUMN_AGENT_THIRD_ABILITY_DESCRIPTION = "thirdAbilityDescription";
    public static final String COLUMN_AGENT_FOURTH_ABILITY_ICON = "fourthAbilityIcon";
    public static final String COLUMN_AGENT_FOURTH_ABILITY_DESCRIPTION = "fourthAbilityDescription";
    //The query to build the Agent table
    public static final String CREATE_AGENT_TABLE = "CREATE TABLE " +
            TABLE_AGENT + "(" + COLUMN_AGENT_ID + " INTEGER PRIMARY KEY, "
            + COLUMN_AGENT_NAME + " TEXT, "
            + COLUMN_AGENT_ROLE + " TEXT, "
            + COLUMN_AGENT_IMAGE + " TEXT, "
            + COLUMN_AGENT_ROLE_IMAGE + " TEXT, "
            + COLUMN_AGENT_DESCRIPTION + " TEXT, "
            + COLUMN_AGENT_ICON + " TEXT, "
            + COLUMN_AGENT_FIRST_ABILITY_ICON + " TEXT, "
            + COLUMN_AGENT_FIRST_ABILITY_DESCRIPTION + " TEXT, "
            + COLUMN_AGENT_SECOND_ABILITY_ICON + " TEXT, "
            + COLUMN_AGENT_SECOND_ABILITY_DESCRIPTION + " TEXT, "
            + COLUMN_AGENT_THIRD_ABILITY_ICON + " TEXT, "
            + COLUMN_AGENT_THIRD_ABILITY_DESCRIPTION + " TEXT, "
            + COLUMN_AGENT_FOURTH_ABILITY_ICON + " TEXT, "
            + COLUMN_AGENT_FOURTH_ABILITY_DESCRIPTION + " TEXT)";

    public ValorantDatabase(@Nullable Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_WEAPONS_TABLE);
        db.execSQL(CREATE_SKINS_TABLE);
        db.execSQL(CREATE_MAP_TABLE);
        db.execSQL(CREATE_AGENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public void addWeapon(Weapon weapon){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_WEAPON_NAME, weapon.getName());
        values.put(COLUMN_WEAPON_CATEGORY, weapon.getDBCategory());
        values.put(COLUMN_WEAPON_DISPLAYICON, weapon.getDisplayIcon());
        values.put(COLUMN_WEAPON_COST, weapon.getDBWeaponCost());
        values.put(COLUMN_WEAPON_FIRERATE, weapon.getDBFireRate());
        values.put(COLUMN_WEAPON_MAGAZINESIZE, weapon.getDBMagazineSize());
        values.put(COLUMN_WEAPON_RELOADTIME, weapon.getDBReloadTime());
        values.put(COLUMN_WEAPON_ZOOMMULTIPLIER, weapon.getDBZoomMultipier());
        db.insert(TABLE_WEAPON, null, values);
        db.close();
        Log.d("SQL", "Weapon Added");
    }

    public void addSkin(Skin skin){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SKIN_IMAGE, skin.getSkinImage());
        values.put(COLUMN_SKIN_NAME, skin.getSkinName());
        values.put(COLUMN_SKIN_TIER, skin.getSkinTier());
        values.put(COLUMN_SKIN_SKINPRICE, skin.getDBSkinPrice());
        db.insert(TABLE_SKIN, null, values);
        db.close();
        Log.d("SQL", "Skin Added");
    }

    /**
     * @author wissam al saub
     * @date 4/16/2023
     * @param map
     * @description adds a new map to the map table
     */
    public void addMAp(Map map){
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_MAP_IMAGE, map.getMapImage());
        values.put(COLUMN_MAP_NAME, map.getMapName());
        values.put(COLUMN_MAP_COORDINATES, map.getMapCoordinates());
        values.put(COLUMN_MAP_DESCRIPTION, map.getMapDescription());
        db.insert(TABLE_MAP, null, values);
        db.close();
    }

    /**
     * @author wissam al saub
     * @date 4/17/2023
     * @param agent
     * @description adds a new agent to the agent table
     */
    public void addAgent(Agent agent){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_AGENT_NAME, agent.getAgentName());
        values.put(COLUMN_AGENT_ROLE, agent.getAgentRole());
        values.put(COLUMN_AGENT_IMAGE, agent.getAgentImage());
        values.put(COLUMN_AGENT_ROLE_IMAGE, agent.getRoleImage());
        values.put(COLUMN_AGENT_DESCRIPTION, agent.getAgentDescription());
        values.put(COLUMN_AGENT_ICON, agent.getAgentIcon());
        values.put(COLUMN_AGENT_FIRST_ABILITY_ICON, agent.getFirstAbilityIcon());
        values.put(COLUMN_AGENT_FIRST_ABILITY_DESCRIPTION, agent.getFirstAbilityDescription());
        values.put(COLUMN_AGENT_SECOND_ABILITY_ICON, agent.getSecondAbilityIcon());
        values.put(COLUMN_AGENT_SECOND_ABILITY_DESCRIPTION, agent.getSecondAbilityDescription());
        values.put(COLUMN_AGENT_THIRD_ABILITY_ICON, agent.getThirdAbilityIcon());
        values.put(COLUMN_AGENT_THIRD_ABILITY_DESCRIPTION, agent.getThirdAbilityDescription());
        values.put(COLUMN_AGENT_FOURTH_ABILITY_ICON, agent.getFourthAbilityIcon());
        values.put(COLUMN_AGENT_FOURTH_ABILITY_DESCRIPTION, agent.getFourthAbilityDescription());
        db.insert(TABLE_AGENT, null, values);
        db.close();
    }

    public Weapon getWeapon(int id){
        SQLiteDatabase db  = this.getReadableDatabase();
        Weapon weapon = null;
        Cursor cursor = db.query(TABLE_WEAPON,
                new String[]{COLUMN_WEAPON_ID, COLUMN_WEAPON_NAME, COLUMN_WEAPON_CATEGORY, COLUMN_WEAPON_DISPLAYICON, COLUMN_WEAPON_COST, COLUMN_WEAPON_FIRERATE, COLUMN_WEAPON_MAGAZINESIZE, COLUMN_WEAPON_RELOADTIME, COLUMN_WEAPON_ZOOMMULTIPLIER},
                COLUMN_WEAPON_ID + "= ?"
                , new String[]{String.valueOf(id)},
                null, null, null);
        if(cursor.moveToFirst()){ //Checking that we have a value and select it to be read

            weapon = new Weapon(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getDouble(4),
                    cursor.getInt(5),
                    cursor.getDouble(6),
                    cursor.getDouble(7));
        }
        db.close();
        return weapon;
    }

    /**
     * @author wissam al saub
     * @date 4/16/2023
     * @param id
     * @return returns a Map object created from the map record that we got from the map table
     */
    public Map getMap(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Map map = null;
        Cursor cursor = db.query(TABLE_MAP,
                new String[]{COLUMN_MAP_ID, COLUMN_MAP_IMAGE, COLUMN_MAP_NAME, COLUMN_MAP_COORDINATES, COLUMN_MAP_DESCRIPTION},
                COLUMN_MAP_ID + "= ?",
                new String[]{String.valueOf(id)}, null, null, null);
        if (cursor.moveToFirst()){
            map = new Map(
                   cursor.getInt(0),
                   cursor.getString(1),
                   cursor.getString(2),
                   cursor.getString(3)
            );
        }
        db.close();
        return map;
    }
    /**
     * @author wissam al saub
     * @date 4/17/2023
     * @param id
     * @return returns an agent object created from the agent record that we got from the agent table
     */
    public Agent getAgent(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Agent agent = null;
        Cursor cursor = db.query(TABLE_AGENT,
                new String[]{COLUMN_AGENT_ID, COLUMN_AGENT_NAME, COLUMN_AGENT_ROLE, COLUMN_AGENT_IMAGE, COLUMN_AGENT_ROLE_IMAGE, COLUMN_AGENT_DESCRIPTION, COLUMN_AGENT_ICON, COLUMN_AGENT_FIRST_ABILITY_ICON, COLUMN_AGENT_FIRST_ABILITY_DESCRIPTION, COLUMN_AGENT_SECOND_ABILITY_ICON, COLUMN_AGENT_SECOND_ABILITY_DESCRIPTION, COLUMN_AGENT_THIRD_ABILITY_ICON, COLUMN_AGENT_THIRD_ABILITY_DESCRIPTION, COLUMN_AGENT_FOURTH_ABILITY_ICON, COLUMN_AGENT_FOURTH_ABILITY_DESCRIPTION},
                COLUMN_AGENT_ID + "= ?",
                new String[]{String.valueOf(id)}, null, null, null);
        if (cursor.moveToFirst()){
            agent = new Agent(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11),
                    cursor.getString(12),
                    cursor.getString(13),
                    cursor.getString(14)
            );
        }
        db.close();
        return agent;
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
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getDouble(5),
                    cursor.getInt(6),
                    cursor.getDouble(7),
                    cursor.getDouble(8)));
        }
        db.close();
        return weapons;
    }

    public ArrayList<Skin> getAllSkins(){
        SQLiteDatabase db = this.getReadableDatabase();

        ArrayList<Skin> skins = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_SKIN, null);
        Log.d("SQL", "Skin Table: " + cursor.getCount() + " records");
        while(cursor.moveToNext()){
            skins.add(new Skin(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)));
        }
        db.close();
        return skins;
    }

    /**
     * @author wissam al saub
     * @date 4/16/2023
     * @return returns an array list with all the map records returned from the database
     */
    public ArrayList<Map> getAllMaps(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Map> maps = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_MAP, null);
        while (cursor.moveToNext()){
            maps.add(new Map(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            ));
        }
        db.close();
        return maps;
    }

    public ArrayList<Agent> getAllAgents(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Agent> agents = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_AGENT, null);
        while (cursor.moveToNext()){
            agents.add(new Agent(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11),
                    cursor.getString(12),
                    cursor.getString(13),
                    cursor.getString(14)
            ));
        }
        db.close();
        return agents;
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
