package com.example.finalproject.UI.Weapons;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.finalproject.UI.Maps.MapFragment;

public class CustomWeaponsViewPagerAdapter extends FragmentStateAdapter {
    public CustomWeaponsViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return WeaponFragment.newInstance("Pistol", "It has 12 bullets");
            case 1:
                return WeaponFragment.newInstance("Rifle", "It has 30 bullets");
            default:
                return WeaponFragment.newInstance("OPPS", "Something is wrong");
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
