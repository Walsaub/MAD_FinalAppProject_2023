package com.example.finalproject.UI.Agents;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalproject.R;
import com.example.finalproject.pojo.Agent;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailedAgentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailedAgentFragment extends Fragment {
    Agent agent;
    //label used for the bundle name/value pairs
    public static final String AGENT = "agent";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailedAgentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailedAgentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailedAgentFragment newInstance(String param1, String param2) {
        DetailedAgentFragment fragment = new DetailedAgentFragment();
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
        View view = inflater.inflate(R.layout.fragment_detailed_agent, container, false);
        // get all the views in the layout file

        ImageView agentImage = view.findViewById(R.id.agentFullImage);
        TextView agentName = view.findViewById(R.id.detailedName);
        ImageView agentRole = view.findViewById(R.id.detailedRoleIcon);
        TextView agentDescription = view.findViewById(R.id.agentDescription);
        TextView abilityDescription = view.findViewById(R.id.abilityDescription);
        ImageView firstAbility = view.findViewById(R.id.firstAbility);
        ImageView secondAbility = view.findViewById(R.id.secondAbility);
        ImageView thirdAbility = view.findViewById(R.id.thirdAbility);
        ImageView fourthAbility = view.findViewById(R.id.fourthAbility);
        //add the ability to scroll through the description text view
        abilityDescription.setMovementMethod(new ScrollingMovementMethod());

        if (getArguments() != null){
            agent = getArguments().getParcelable(AGENT);
            Picasso.get().load(agent.getAgentImage()).into(agentImage);
            agentName.setText(agent.getAgentName());
            Picasso.get().load(agent.getRoleImage()).into(agentRole);
            agentDescription.setText(agent.getAgentDescription());
            Picasso.get().load(agent.getFirstAbilityIcon()).into(firstAbility);
            Picasso.get().load(agent.getSecondAbilityIcon()).into(secondAbility);
            Picasso.get().load(agent.getThirdAbilityIcon()).into(thirdAbility);
            Picasso.get().load(agent.getFourthAbilityIcon()).into(fourthAbility);
            // handle the ability icons click
            firstAbility.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    firstAbility.setBackgroundColor(getResources().getColor(R.color.highlight));
                    secondAbility.setBackgroundColor(0);
                    thirdAbility.setBackgroundColor(0);
                    fourthAbility.setBackgroundColor(0);
                    firstAbility.setRotationX(-30);
                    secondAbility.setRotationX(0);
                    thirdAbility.setRotationX(0);
                    fourthAbility.setRotationX(0);
                    abilityDescription.setText(agent.getFirstAbilityDescription());
                }
            });
            secondAbility.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    firstAbility.setBackgroundColor(0);
                    secondAbility.setBackgroundColor(getResources().getColor(R.color.highlight));
                    thirdAbility.setBackgroundColor(0);
                    fourthAbility.setBackgroundColor(0);
                    firstAbility.setRotationX(0);
                    secondAbility.setRotationX(-30);
                    thirdAbility.setRotationX(0);
                    fourthAbility.setRotationX(0);
                    abilityDescription.setText(agent.getSecondAbilityDescription());
                }
            });
            thirdAbility.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    firstAbility.setBackgroundColor(0);
                    secondAbility.setBackgroundColor(0);
                    thirdAbility.setBackgroundColor(getResources().getColor(R.color.highlight));
                    fourthAbility.setBackgroundColor(0);
                    firstAbility.setRotationX(0);
                    secondAbility.setRotationX(0);
                    thirdAbility.setRotationX(-30);
                    fourthAbility.setRotationX(0);
                    abilityDescription.setText(agent.getThirdAbilityDescription());
                }
            });
            fourthAbility.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    firstAbility.setBackgroundColor(0);
                    secondAbility.setBackgroundColor(0);
                    thirdAbility.setBackgroundColor(0);
                    firstAbility.setRotationX(0);
                    secondAbility.setRotationX(0);
                    thirdAbility.setRotationX(0);
                    fourthAbility.setRotationX(-30);
                    fourthAbility.setBackgroundColor(getResources().getColor(R.color.highlight));
                    abilityDescription.setText(agent.getFourthAbilityDescription());
                }
            });
        }
        return view;
    }
}