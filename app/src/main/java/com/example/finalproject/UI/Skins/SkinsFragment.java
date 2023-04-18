package com.example.finalproject.UI.Skins;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.finalproject.MainActivity;
import com.example.finalproject.R;
import com.example.finalproject.UI.Agents.AgentsCustomAdapter;
import com.example.finalproject.ValorantDatabase;
import com.example.finalproject.pojo.Skin;
import com.example.finalproject.pojo.Weapon;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkinsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkinsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SkinsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SkinsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SkinsFragment newInstance(String param1, String param2) {
        SkinsFragment fragment = new SkinsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // separated the view from the return statement
        View view = inflater.inflate(R.layout.fragment_skins, container, false);

        //get the shared preference from the settings menu
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(view.getContext());

        //get the valorant database
        ValorantDatabase db = new ValorantDatabase(getContext());

        //create an array list of skin objects
        ArrayList<Skin> skinsList = db.getAllSkins();

        //close the connection to the Valorant database
        db.close();
        //assign the skins list Recycler View to a variable
        RecyclerView recyclerView = view.findViewById(R.id.skinsList);

        //toggle the animation on/off depending on the value returned from the settings menu
        if (sharedPreferences.getBoolean("animation_toggle", true)){
            // Load the animation resource file
            Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.enter_top_left_with_scale);

            // Create a LayoutAnimationController object and set its animation properties
            LayoutAnimationController layoutAnimationController = new LayoutAnimationController(anim);
            layoutAnimationController.setDelay(0.2f);

            // Set the LayoutAnimationController on the RecyclerView
            recyclerView.setLayoutAnimation(layoutAnimationController);
        }else {
            recyclerView.setLayoutAnimation(null);
        }

        //create a new custom list view adapter and assign it to SkinsListView
        SkinsCustomAdapter adapter = new SkinsCustomAdapter(skinsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        return view;
    }
}