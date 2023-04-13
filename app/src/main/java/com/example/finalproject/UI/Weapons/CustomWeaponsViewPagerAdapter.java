package com.example.finalproject.UI.Weapons;

import static java.security.AccessController.getContext;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalproject.MainActivity;
import com.example.finalproject.UI.Maps.MapFragment;
import com.example.finalproject.ValorantDatabase;
import com.example.finalproject.pojo.Weapon;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class CustomWeaponsViewPagerAdapter extends FragmentStateAdapter {
    ValorantDatabase valorantDatabase;
    //we need to collect the FragmentActivity because it is a FRAGMENT and
    //fragments have the getApplicationContext() property which allows us to get the context
    //which we use to use Volley.
    public CustomWeaponsViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, Context context) {
        super(fragmentActivity);

        //1. initialize valorant Database
        valorantDatabase = new ValorantDatabase(context);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        for(int i = 0; i < valorantDatabase.getAllWeapons().size(); i++){
            if(position == i){
                return WeaponFragment.newInstance(
                        valorantDatabase.getAllWeapons().get(i).getName(),
                        valorantDatabase.getAllWeapons().get(i).getCategory(),
                        valorantDatabase.getAllWeapons().get(i).getDisplayIcon(),
                        valorantDatabase.getAllWeapons().get(i).getWeaponCost(),
                        valorantDatabase.getAllWeapons().get(i).getFireRate(),
                        valorantDatabase.getAllWeapons().get(i).getMagazineSize(),
                        valorantDatabase.getAllWeapons().get(i).getReloadTime(),
                        valorantDatabase.getAllWeapons().get(i).getZoomMultipier());

            }
        }
        return WeaponFragment.newInstance("Oops", "Something is wrong", "","","","","","");
    }
    @Override
    public int getItemCount() {
        return valorantDatabase.getAllWeapons().size();
    }
}
