package com.example.finalproject.UI.Maps;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.finalproject.MainActivity;
import com.example.finalproject.UI.Weapons.WeaponFragment;
import com.example.finalproject.pojo.Map;
import com.example.finalproject.pojo.Weapon;

import java.util.ArrayList;

public class CustomViewPagerAdapter extends FragmentStateAdapter {
    public CustomViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        for(int i = 0; i < MainActivity.getAllMaps().size(); i++){
            if(position == i){
                return MapFragment.newInstance(
                        MainActivity.getAllMaps().get(position).getMapName(),
                        MainActivity.getAllMaps().get(position).getMapDescription(),
                        MainActivity.getAllMaps().get(position).getMapCoordinates(),
                        MainActivity.getAllMaps().get(position).getMapImage());

            }
        }
        return MapFragment.newInstance("Oops", "Something is wrong", "","");
    }

    @Override
    public int getItemCount() {
        return MainActivity.getAllMaps().size();
    }
}
