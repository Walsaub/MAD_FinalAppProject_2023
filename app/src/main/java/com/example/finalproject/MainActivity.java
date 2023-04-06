package com.example.finalproject;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalproject.pojo.Skin;
import com.example.finalproject.pojo.Weapon;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.finalproject.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    //create an in-class function to retrieve all weapons
    static ArrayList<Weapon> allWeapons = new ArrayList<Weapon>();
    public static ArrayList<Weapon> getAllWeapons(){
        return allWeapons;
    }

    //skins
    static ArrayList<Skin> allSkins = new ArrayList<Skin>();
    public static ArrayList<Skin> getAllSkins(){
        return allSkins;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_agents, R.id.navigation_maps, R.id.navigation_weapons, R.id.navigation_skins)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        //1. Request JSON data
        String weaponsURL = "https://valorant-api.com/v1/weapons/";

        JsonObjectRequest gunRequest = new JsonObjectRequest(Request.Method.GET, weaponsURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    //2. allDATA is a collection of EVERY gun
                    JSONArray allDATA = response.getJSONArray("data");

                    //3. gunData is all data for each specific gun (18 total)
                    JSONObject[] gunData = new JSONObject[allDATA.length()];

                    //collect JSONObject data for each gun
                    for(int i = 0; i < allDATA.length(); i++){

                        gunData[i] = allDATA.getJSONObject(i);
                        System.out.println("gun data[i]: " + gunData[i]);

                        /** CHECK IF SHOPDATA EXISTS **/
                        int price;
                        String category;
                        JSONObject shopData;
                        if(gunData[i].isNull("shopData")){
                            price = 0;
                            category = "Melee";
                        }else{
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
                        if(gunData[i].isNull("weaponStats")){
                            //if it doesn't have a gun, it won't have gun-related stats.
                            fireRate = 0.0;
                            magazineSize = 0;
                            reloadTime = 0.0;
                            zooMultplier = 0.0;
                        }else{  //if gun data DOES exist
                            //if adsStats is NOT null, read the data and put inside weaponData
                            weaponData = gunData[i].getJSONObject("weaponStats");

                            fireRate = weaponData.getDouble("fireRate");
                            magazineSize = weaponData.getInt("magazineSize");
                            reloadTime = weaponData.getDouble("reloadTimeSeconds");

                            //now, we need to check if ads data exists inside of specific weapon.
                            if(weaponData.isNull("adsStats")){
                                zooMultplier = 0.0;
                            }else{
                                //if adsStats is NOT null, read the data and put inside adsData
                                adsData = weaponData.getJSONObject("adsStats");
                                zooMultplier =  adsData.getDouble("zoomMultiplier");
                            }
                        }



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
                        allWeapons.add(w);

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
        Volley.newRequestQueue(this).add(gunRequest);

        //JSON object request #2 ~ Skins
        String skinsURL = "https://valorant-api.com/v1/weapons/skins";
        String contenttiersURL = "https://valorant-api.com/v1/contenttiers";
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

                        System.out.println(skinData[i].getString("displayName"));

                        Skin s = new Skin(
                                skinData[i].getString("displayIcon"),
                                skinData[i].getString("displayName"),
                                "",
                                0
                        );
                        allSkins.add(s);
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

}