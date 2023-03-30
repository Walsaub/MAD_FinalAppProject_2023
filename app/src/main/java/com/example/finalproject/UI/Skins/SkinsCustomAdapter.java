package com.example.finalproject.UI.Skins;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.UI.Agents.AgentsCustomAdapter;
import com.example.finalproject.pojo.Weapon;

import java.util.ArrayList;

public class SkinsCustomAdapter extends RecyclerView.Adapter<SkinsCustomAdapter.CustomViewHolder>{

    //arraylist to hold all the skins data
    private ArrayList<Weapon> weapons;

    //custom adapter constructor
    public SkinsCustomAdapter(ArrayList<Weapon> weapons){
        this.weapons = weapons;
    }

    //method to create a new custom view holder for the skin view
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skin_view, parent, false);

        return new CustomViewHolder(view);
    }

    //method to manipulate the content's of the view holder component
    @Override
    public void onBindViewHolder(@NonNull SkinsCustomAdapter.CustomViewHolder holder, int position) {
        Weapon weapon = weapons.get(position);
        holder.skinName.setText(weapon.getName());
        holder.skinCategory.setText(weapon.getCategory());
    }

    //determine how many agents we have
    @Override
    public int getItemCount() {
        if (weapons != null){
            return weapons.size();
        }
        return 0;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView skinName;
        protected TextView skinCategory;

        //method to bind the view holder component with the agent view component
        public CustomViewHolder(View view) {
            super(view);
            this.skinName = view.findViewById(R.id.skinName);
            this.skinCategory = view.findViewById(R.id.skinCategory);
        }
    }
}
