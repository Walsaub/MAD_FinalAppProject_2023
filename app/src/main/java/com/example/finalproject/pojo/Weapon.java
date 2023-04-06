package com.example.finalproject.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Weapon implements Parcelable {
    private int id;
    private String name;
    private String category;
    private String displayIcon;
    private int weaponCost;
    private double fireRate;
    private int magazineSize;
    private double reloadTime;
    private double zoomMultipier;

    //weapon stats array of type String, Int


    public Weapon(String name, String category, String displayIcon, int weaponCost, double fireRate, int magazineSize, double reloadTime, double zoomMultipier) {
        this.name = name;
        this.category = category;
        this.displayIcon = displayIcon;
        this.weaponCost = weaponCost;
        this.fireRate = fireRate;
        this.magazineSize = magazineSize;
        this.reloadTime = reloadTime;
        this.zoomMultipier = zoomMultipier;
    }

    //DB Weapon


    public Weapon(int id, String name, String category, String displayIcon, int weaponCost, double fireRate, int magazineSize, double reloadTime, double zoomMultipier) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.displayIcon = displayIcon;
        this.weaponCost = weaponCost;
        this.fireRate = fireRate;
        this.magazineSize = magazineSize;
        this.reloadTime = reloadTime;
        this.zoomMultipier = zoomMultipier;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getCategory() {return "Category: " + category;}
    public void setCategory(String category) {this.category = category;}
    public String getDisplayIcon() {return displayIcon;}
    public void setDisplayIcon(String displayIcon) {this.displayIcon = displayIcon;}
    public String getWeaponCost() {return "Cost: " + weaponCost;}
    public void setWeaponCost(int weaponCost) {this.weaponCost = weaponCost;}
    public String getFireRate() {return this.fireRate == 0 ? "Fire Rate: N/A" : "Fire Rate: "+fireRate;}
    public void setFireRate(double fireRate) {this.fireRate = fireRate;}
    public String getMagazineSize() {return this.magazineSize == 0 ? "Magazine Size: N/A" : "Magazine Size: "+magazineSize;}
    public void setMagazineSize(int magazineSize) {this.magazineSize = magazineSize;}
    public String getReloadTime() {return this.reloadTime == 0 ? "Reload Time: N/A" : "Reload Time: "+reloadTime + " seconds";}
    public void setReloadTime(double reloadTime) {this.reloadTime = reloadTime;}
    public String getZoomMultipier() {return this.zoomMultipier == 0 ? "You can't ADS with this weapon." : "Zoom Multiplier: "+zoomMultipier;}
    public void setZoomMultipier(double zoomMultipier) {this.zoomMultipier = zoomMultipier;}


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
