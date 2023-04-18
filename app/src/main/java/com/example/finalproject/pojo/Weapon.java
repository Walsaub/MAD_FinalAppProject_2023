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

    /**
     * @author wissam al saub
     * @date 4/16/2023
     * @return returns the value of the weapon's category retrieved from the api so we can store it in the database
     */
    public String getDBCategory() {return category;}
    public void setCategory(String category) {this.category = category;}
    public String getDisplayIcon() {return displayIcon;}
    public void setDisplayIcon(String displayIcon) {this.displayIcon = displayIcon;}
    public String getWeaponCost() {return "Cost: " + weaponCost;}
    /**
     * @author wissam al saub
     * @date 4/16/2023
     * @return returns an integer value of the weapon's cost retrieved from the api so we can store it in the database
     */
    public int getDBWeaponCost() {return weaponCost;}
    public void setWeaponCost(int weaponCost) {this.weaponCost = weaponCost;}
    public String getFireRate() {return this.fireRate == 0 ? "Fire Rate: N/A" : "Fire Rate: "+fireRate;}
    /**
     * @author wissam al saub
     * @date 4/16/2023
     * @return returns a double value of the weapon's fire rate retrieved from the api so we can store it in the database
     */
    public double getDBFireRate() {return fireRate;}
    public void setFireRate(double fireRate) {this.fireRate = fireRate;}
    public String getMagazineSize() {return this.magazineSize == 0 ? "Magazine Size: N/A" : "Magazine Size: "+magazineSize;}
    /**
     * @author wissam al saub
     * @date 4/16/2023
     * @return returns an integer value of the weapon's magazine size retrieved from the api so we can store it in the database
     */
    public int getDBMagazineSize() {return magazineSize;}
    public void setMagazineSize(int magazineSize) {this.magazineSize = magazineSize;}
    public String getReloadTime() {return this.reloadTime == 0 ? "Reload Time: N/A" : "Reload Time: "+reloadTime + " seconds";}
    /**
     * @author wissam al saub
     * @date 4/16/2023
     * @return returns a double value of the weapon's reload time retrieved from the api so we can store it in the database
     */
    public double getDBReloadTime() {return reloadTime;}
    public void setReloadTime(double reloadTime) {this.reloadTime = reloadTime;}
    public String getZoomMultipier() {return this.zoomMultipier == 0 ? "You can't ADS with this weapon." : "Zoom Multiplier: "+zoomMultipier;}
    /**
     * @author wissam al saub
     * @date 4/16/2023
     * @return returns a double value of the weapon's zoom multiplier retrieved from the api so we can store it in the database
     */
    public double getDBZoomMultipier() {return zoomMultipier;}
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
        dest.writeInt(this.weaponCost);
        dest.writeDouble(this.fireRate);
        dest.writeInt(this.magazineSize);
        dest.writeDouble(this.reloadTime);
        dest.writeDouble(this.zoomMultipier);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.category = source.readString();
        this.displayIcon = source.readString();
        this.weaponCost = source.readInt();
        this.fireRate = source.readDouble();
        this.magazineSize = source.readInt();
        this.reloadTime = source.readDouble();
        this.zoomMultipier = source.readDouble();
    }

    protected Weapon(Parcel in) {
        this.name = in.readString();
        this.category = in.readString();
        this.displayIcon = in.readString();
        this.weaponCost = in.readInt();
        this.fireRate = in.readDouble();
        this.magazineSize = in.readInt();
        this.reloadTime = in.readDouble();
        this.zoomMultipier = in.readDouble();
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
