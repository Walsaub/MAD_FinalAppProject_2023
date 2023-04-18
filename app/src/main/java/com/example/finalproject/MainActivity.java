package com.example.finalproject;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalproject.pojo.Agent;
import com.example.finalproject.pojo.Map;
import com.example.finalproject.pojo.Skin;
import com.example.finalproject.pojo.Tier;
import com.example.finalproject.pojo.Weapon;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.finalproject.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    ValorantDatabase db;

    //content tier
    ArrayList<Tier> allTiers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initialize valorant Database
        db = new ValorantDatabase(this);

        /** AGENTS **/
        /**
         * @author wissam al saub
         * @date 4/13/2023
         *
         * requesting the agent's data from Valorant API
         */
        String agentURL = "https://valorant-api.com/v1/agents";
        if (db.getAllAgents().isEmpty()){
            JsonObjectRequest agentsRequest = new JsonObjectRequest(Request.Method.GET, agentURL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        //get all the agents and store them in a json array
                        JSONArray agents = response.getJSONArray("data");

                        //loop through the json array to create a new agent object from the fetched data
                        for (int i = 0; i < agents.length(); i++){
                            //check if the agent is in the game yet
                            if (agents.getJSONObject(i).getBoolean("isPlayableCharacter")){
                                //get the agent's role json object that is inside the agent's json object
                                JSONObject agentRole = agents.getJSONObject(i).getJSONObject("role");
                                //get the agent's abilities json array that is inside the agent's json object
                                JSONArray agentAbilities = agents.getJSONObject(i).getJSONArray("abilities");
                                Agent agent = new Agent(
                                        agents.getJSONObject(i).getString("displayName"),
                                        agentRole.getString("displayName"),
                                        agents.getJSONObject(i).getString("fullPortrait"),
                                        agentRole.getString("displayIcon"),
                                        agents.getJSONObject(i).getString("description"),
                                        agents.getJSONObject(i).getString("displayIconSmall"),
                                        agentAbilities.getJSONObject(0).getString("displayIcon"),
                                        agentAbilities.getJSONObject(0).getString("description"),
                                        agentAbilities.getJSONObject(1).getString("displayIcon"),
                                        agentAbilities.getJSONObject(1).getString("description"),
                                        agentAbilities.getJSONObject(2).getString("displayIcon"),
                                        agentAbilities.getJSONObject(2).getString("description"),
                                        agentAbilities.getJSONObject(3).getString("displayIcon"),
                                        agentAbilities.getJSONObject(3).getString("description")
                                );
                                db.addAgent(agent);
                            }

                        }

                    } catch (Exception e) {
                        System.out.println("Failed to collect the agent's JSON data");
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            Volley.newRequestQueue(this).add(agentsRequest);
        }


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_agents, R.id.navigation_maps, R.id.navigation_weapons, R.id.navigation_skins, R.id.detailedAgentFragment, R.id.contact_us, R.id.settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        /** WEAPONS **/
        //1. Request JSON data
        String weaponsURL = "https://valorant-api.com/v1/weapons/";
        //if database is empty
        if(db.getAllWeapons().isEmpty()) {
            JsonObjectRequest gunRequest = new JsonObjectRequest(Request.Method.GET, weaponsURL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        //2. allDATA is a collection of EVERY gun
                        JSONArray allDATA = response.getJSONArray("data");

                        //3. gunData is all data for each specific gun (18 total)
                        JSONObject[] gunData = new JSONObject[allDATA.length()];

                        //collect JSONObject data for each gun
                        for (int i = 0; i < allDATA.length(); i++) {

                            gunData[i] = allDATA.getJSONObject(i);

                            /** CHECK IF SHOPDATA EXISTS **/
                            int price;
                            String category;
                            JSONObject shopData;
                            if (gunData[i].isNull("shopData")) {
                                price = 0;
                                category = "Melee";
                            } else {
                                shopData = gunData[i].getJSONObject("shopData");
                                price = shopData.getInt("cost");
                                category = shopData.getString("category");
                            }


                            /** CHECK IF WEAPONDATA EXISTS **/
                            Double fireRate;
                            int magazineSize;
                            Double reloadTime;
                            Double zooMultplier;

                            JSONObject weaponData;
                            JSONObject adsData;


                            //check weaponData first
                            if (gunData[i].isNull("weaponStats")) {
                                //if it doesn't have a gun, it won't have gun-related stats.
                                fireRate = 0.0;
                                magazineSize = 0;
                                reloadTime = 0.0;
                                zooMultplier = 0.0;
                            } else {  //if gun data DOES exist
                                //if adsStats is NOT null, read the data and put inside weaponData
                                weaponData = gunData[i].getJSONObject("weaponStats");

                                fireRate = weaponData.getDouble("fireRate");
                                magazineSize = weaponData.getInt("magazineSize");
                                reloadTime = weaponData.getDouble("reloadTimeSeconds");

                                //now, we need to check if ads data exists inside of specific weapon.
                                if (weaponData.isNull("adsStats")) {
                                    zooMultplier = 0.0;
                                } else {
                                    //if adsStats is NOT null, read the data and put inside adsData
                                    adsData = weaponData.getJSONObject("adsStats");
                                    zooMultplier = adsData.getDouble("zoomMultiplier");
                                }
                            }


                            //when this weapon is initialized, we generate a variable for the time it was generated.
                            Weapon w = new Weapon(
                                    gunData[i].getString("displayName"),
                                    category,
                                    gunData[i].getString("displayIcon"),
                                    price,
                                    fireRate,
                                    magazineSize,
                                    reloadTime,
                                    zooMultplier
                            );
                            db.addWeapon(w);

                        }

                    } catch (Exception e) {
                        System.out.println("Failed to collect JSON data.");
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            Volley.newRequestQueue(this).add(gunRequest);
        }

        /** SKINS **/
        //JSON object request #2 ~ Skins
        String skinsURL = "https://valorant-api.com/v1/weapons/skins";
        String contenttiersURL = "https://valorant-api.com/v1/contenttiers";

        if (db.getAllTiers().isEmpty()){
            JsonObjectRequest tierRequest = new JsonObjectRequest(Request.Method.GET, contenttiersURL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        //2. allDATA is a collection of EVERY gun
                        JSONArray allDATA = response.getJSONArray("data");
                        //3. gunData is all data for each specific gun (18 total)
                        JSONObject[] tierData = new JSONObject[allDATA.length()];

                        //collect JSONObject data for each gun
                        for (int i = 0; i < allDATA.length(); i++) {
                            tierData[i] = allDATA.getJSONObject(i); //retrieve individual skin data
                            Tier tier = new Tier(
                                    tierData[i].getString("uuid"),
                                    tierData[i].getString("devName")
                            );
                            db.addTier(tier);
                        }
                    } catch (Exception e) {
                        System.out.println("Failed to collect JSON data.");
                    }
                }}, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });
            Volley.newRequestQueue(this).add(tierRequest);
        }

        if(db.getAllSkins().isEmpty()) {
            allTiers = db.getAllTiers();
            JsonObjectRequest skinRequest = new JsonObjectRequest(Request.Method.GET, skinsURL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try{
                        //2. allDATA is a collection of EVERY gun
                        JSONArray allDATA = response.getJSONArray("data");

                        //3. gunData is all data for each specific gun (18 total)
                        JSONObject[] skinData = new JSONObject[allDATA.length()];

                        //collect JSONObject data for each gun
                        for(int i = 0; i < allDATA.length(); i++){
                            skinData[i] = allDATA.getJSONObject(i); //retrieve individual skin data
                            JSONArray chromasData = skinData[i].getJSONArray("chromas");
                            JSONObject x = chromasData.getJSONObject(0);

                            if(!skinData[i].isNull("contentTierUuid")){
                                Skin s = new Skin(
                                        x.getString("fullRender"),
                                        skinData[i].getString("displayName"),
                                        db.getTierByUUID(skinData[i].getString("contentTierUuid"))
                                );
                                db.addSkin(s);
                            }


                        }

                    }catch(Exception e) {
                        System.out.println("Failed to collect JSON data.");
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            Volley.newRequestQueue(this).add(skinRequest);
        }


        /** MAPS **/
        /**
         * @author wissam al saub
         * @date 4/13/2023
         *
         * requesting the map data from Valorant API
         */
        String mapURL = "https://valorant-api.com/v1/maps";

        if (db.getAllMaps().isEmpty()){
            JsonObjectRequest mapsRequest = new JsonObjectRequest(Request.Method.GET, mapURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //get all the maps and store them in a json array
                    JSONArray maps = response.getJSONArray("data");

                    //loop through the json array to create a new map object from the fetched data
                    for (int i = 0; i < maps.length(); i++){
                        Map map = new Map(
                                maps.getJSONObject(i).getString("splash"),
                                maps.getJSONObject(i).getString("displayName"),
                                maps.getJSONObject(i).getString("coordinates")
                        );
                        db.addMap(map);
                    }

                } catch (Exception e) {
                    System.out.println("Failed to collect the map's JSON data");
                }
            }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            Volley.newRequestQueue(this).add(mapsRequest);
        }

        //close the database
        db.close();
    }

    /**
     * @author wissam al saub
     * @date 4/18/2023
     * @param menu
     * @description add the menu to the top right
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * @author wissam al saub
     * @date 4/18/2023
     * @param item
     * @description handle the navigation when the top menu items clicked
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        switch (item.getItemId()){
            case R.id.contact_us:
                navController.navigate(R.id.contact_us);
                return super.onOptionsItemSelected(item);
            case R.id.settings:
                navController.navigate(R.id.settings);
                return super.onOptionsItemSelected(item);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}