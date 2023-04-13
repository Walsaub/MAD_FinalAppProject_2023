package com.example.finalproject.UI.Agents;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.pojo.Agent;
import com.example.finalproject.pojo.Weapon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AgentsCustomAdapter extends RecyclerView.Adapter<AgentsCustomAdapter.CustomViewHolder>{

    //arraylist to hold all the agents data
    private ArrayList<Agent> agents;

    //custom adapter constructor
    public AgentsCustomAdapter(ArrayList<Agent> agents){
        this.agents = agents;
    }

    //method to create a new custom view holder for the agent view
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.agent_view, parent, false);

        return new CustomViewHolder(view);
    }

    //method to manipulate the content's of the view holder component
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Agent agent = agents.get(position);
        holder.agentName.setText(agent.getAgentName());
        holder.agentRole.setText(agent.getAgentRole());
        Picasso.get().load(agent.getAgentIcon()).into(holder.agentImage);
        Picasso.get().load(agent.getRoleImage()).into(holder.agentRoleImage);
    }

    //determine how many agents we have
    @Override
    public int getItemCount() {
        if (agents != null){
            return agents.size();
        }
        return 0;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView agentName;
        protected TextView agentRole;

        protected ImageView agentImage;
        protected ImageView agentRoleImage;

        //method to bind the view holder component with the agent view component
        public CustomViewHolder(View view) {
            super(view);
            this.agentName = view.findViewById(R.id.agentName);
            this.agentRole = view.findViewById(R.id.agentRole);
            this.agentImage = view.findViewById(R.id.agentImage);
            this.agentRoleImage = view.findViewById(R.id.roleImage);
        }
    }
}
