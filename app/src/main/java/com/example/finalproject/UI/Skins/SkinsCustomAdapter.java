package com.example.finalproject.UI.Skins;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.pojo.Skin;
import com.example.finalproject.pojo.Weapon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SkinsCustomAdapter extends RecyclerView.Adapter<SkinsCustomAdapter.CustomViewHolder>{

    //arraylist to hold all the skins data
    private ArrayList<Skin> skins;

    //custom adapter constructor
    public SkinsCustomAdapter(ArrayList<Skin> skins){
        this.skins = skins;
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
        Skin skin = skins.get(position);
        holder.skinName.setText(skin.getSkinName());
        holder.skinCategory.setText(skin.getSkinTier());
        holder.skinPrice.setText(skin.getSkinPrice());
        Picasso.get().load(skin.getSkinImage()).into(holder.skinImage);

    }

    //determine how many agents we have
    @Override
    public int getItemCount() {
        if (skins != null){
            return skins.size();
        }
        return 0;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView skinImage;
        protected TextView skinName;
        protected TextView skinCategory;
        protected TextView skinPrice;

        //method to bind the view holder component with the agent view component
        public CustomViewHolder(View view) {
            super(view);
            this.skinImage = view.findViewById(R.id.skinImage);
            this.skinName = view.findViewById(R.id.skinName);
            this.skinCategory = view.findViewById(R.id.skinTier);
            this.skinPrice = view.findViewById(R.id.skinPrice);
        }
    }
}
