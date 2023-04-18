package com.example.finalproject.UI.Maps;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.finalproject.MainActivity;
import com.example.finalproject.UI.Weapons.WeaponFragment;
import com.example.finalproject.ValorantDatabase;
import com.example.finalproject.pojo.Map;
import com.example.finalproject.pojo.Weapon;

import java.util.ArrayList;


public class CustomViewPagerAdapter extends FragmentStateAdapter {
    ValorantDatabase db;
    ArrayList<Map> allMaps;
    public CustomViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, Context context) {
        super(fragmentActivity);
        // initialize valorant Database
        db = new ValorantDatabase(context);
        //initialize the maps array lis
        allMaps = db.getAllMaps();
        //close the connection to the Valorant database
        db.close();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        for(int i = 0; i < allMaps.size(); i++){
            if(position == i){
                return MapFragment.newInstance(
                        allMaps.get(position).getMapName(),
                        allMaps.get(position).getMapDescription(),
                        allMaps.get(position).getMapCoordinates(),
                        allMaps.get(position).getMapImage());

            }
        }
        return MapFragment.newInstance("Oops", "Something is wrong", "","");
    }

    @Override
    public int getItemCount() {
        return allMaps.size();
    }
}
