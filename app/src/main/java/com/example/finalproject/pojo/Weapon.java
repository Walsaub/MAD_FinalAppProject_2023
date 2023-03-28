package com.example.finalproject.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Weapon implements Parcelable {
    private int id;
    private String name;
    private String category;
    private String displayIcon;
    //weapon stats array of type String, Int
    public Weapon(String name, String category, String displayIcon){
        this.name = name;
        this.category = category;
        this.displayIcon = displayIcon;
    }

    //DB Weapon
    public Weapon(int id, String name, String category, String displayIcon){
        this.id = id;
        this.name = name;
        this.category = category;
        this.displayIcon = displayIcon;
    }


    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}
    public String getDisplayIcon() {return displayIcon;}
    public void setDisplayIcon(String displayIcon) {this.displayIcon = displayIcon;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.category);
        dest.writeString(this.displayIcon);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.category = source.readString();
        this.displayIcon = source.readString();
    }

    protected Weapon(Parcel in) {
        this.name = in.readString();
        this.category = in.readString();
        this.displayIcon = in.readString();
    }

    public static final Parcelable.Creator<Weapon> CREATOR = new Parcelable.Creator<Weapon>() {
        @Override
        public Weapon createFromParcel(Parcel source) {
            return new Weapon(source);
        }

        @Override
        public Weapon[] newArray(int size) {
            return new Weapon[size];
        }
    };
}
