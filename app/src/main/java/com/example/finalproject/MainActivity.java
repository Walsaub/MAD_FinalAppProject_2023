package com.example.finalproject;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
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
        String url = "https://valorant-api.com/v1/weapons/";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
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
                        Weapon w = new Weapon(
                                gunData[i].getString("displayName"),
                                gunData[i].getString("category"),
                                gunData[i].getString("displayIcon")
                        );

                        allWeapons.add(w);



                        //System.out.println("gunData[" + i + "] displayName: " + gunData[i].getString("displayName"));
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
        Volley.newRequestQueue(this).add(request);

    }

}