package com.example.finalproject.UI.Maps;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomViewPagerAdapter extends FragmentStateAdapter {
    public CustomViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return MapFragment.newInstance("Haven", "It has 3 sites");
            case 1:
                return MapFragment.newInstance("Split", "It has 2 sites");
            default:
                return MapFragment.newInstance("OPPS", "Something is wrong");
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
