package com.example.finalproject.UI.Weapons;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalproject.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

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

    Context context;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;

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
    public static WeaponFragment newInstance(String param1, String param2, String param3) {
        WeaponFragment fragment = new WeaponFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
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
        }


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // separated the view from the return statement
        View view = inflater.inflate(R.layout.fragment_weapon, container, false);
        // linked the text views to properties
        TextView weaponName = view.findViewById(R.id.weaponName);
        TextView weaponDesc = view.findViewById(R.id.weaponDescription);
        ImageView weaponDisplay = view.findViewById(R.id.weaponDisplay);
        // assigned the text of the text views to the parameters that we got from the adapter\

        weaponName.setText(mParam1);
        weaponDesc.setText(mParam2);
        Picasso.get().load(mParam3).into(weaponDisplay);
        return view;
    }


}