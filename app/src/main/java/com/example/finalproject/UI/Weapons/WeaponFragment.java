package com.example.finalproject.UI.Weapons;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalproject.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeaponFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeaponFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";
    private static final String ARG_PARAM5 = "param5";
    private static final String ARG_PARAM6 = "param6";
    private static final String ARG_PARAM7 = "param7";
    private static final String ARG_PARAM8 = "param8";

    Context context;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private String mParam4;
    private String mParam5;
    private String mParam6;
    private String mParam7;
    private String mParam8;

    public WeaponFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeaponFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeaponFragment newInstance(String param1, String param2, String param3, String param4, String param5, String param6, String param7, String param8) {
        WeaponFragment fragment = new WeaponFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        args.putString(ARG_PARAM4, param4);
        args.putString(ARG_PARAM5, param5);
        args.putString(ARG_PARAM6, param6);
        args.putString(ARG_PARAM7, param7);
        args.putString(ARG_PARAM8, param8);
        fragment.setArguments(args);
        return fragment;
    }
    TextView data;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);
            mParam5 = getArguments().getString(ARG_PARAM5);
            mParam6 = getArguments().getString(ARG_PARAM6);
            mParam7 = getArguments().getString(ARG_PARAM7);
            mParam8 = getArguments().getString(ARG_PARAM8);
        }


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // separated the view from the return statement
        View view = inflater.inflate(R.layout.fragment_weapon, container, false);
        // linked the text views to properties

        ImageView weaponDisplay = view.findViewById(R.id.weaponDisplay);
        TextView weaponName = view.findViewById(R.id.weaponName);
        TextView weaponCategory = view.findViewById(R.id.weaponCategory);
        TextView weaponCost = view.findViewById(R.id.weaponCost);
        TextView weaponFireRate = view.findViewById(R.id.weaponFireRate);
        TextView weaponMagazineSize = view.findViewById(R.id.weaponMagazineSize);
        TextView weaponReloadTime = view.findViewById(R.id.weaponReloadTime);
        TextView weaponZoomMultiplier = view.findViewById(R.id.weaponZoomMultiplier);

        // assigned the text of the text views to the parameters that we got from the adapter

        Picasso.get().load(mParam3).into(weaponDisplay);
        weaponName.setText(mParam1);
        weaponCategory.setText(mParam2);
        weaponCost.setText(mParam4);
        weaponFireRate.setText(mParam5);
        weaponMagazineSize.setText(mParam6);
        weaponReloadTime.setText(mParam7);
        weaponZoomMultiplier.setText(mParam8);
        return view;
    }


}