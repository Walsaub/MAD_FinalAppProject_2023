package com.example.finalproject.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Skin implements Parcelable {
    // skin properties
    private int id;
    private String skinImage;
    private String skinName;
    private String skinTier;
    private int skinPrice;
    private int skinPriceInDollars;

    /**
     * @author wissam al saub
     * @param id
     * @param skinImage
     * @param skinName
     * @param skinTier
     *
     * @date 4/6/2023
     * @description DB constructor for the skin class
     */
    public Skin(int id, String skinImage, String skinName, String skinTier) {
        this.id = id;
        this.skinImage = skinImage;
        this.skinName = skinName;
        this.skinTier = skinTier;
        switch (this.skinTier){
            case "Select":
                this.skinPrice = 875;
                break;
            case "Deluxe":
                this.skinPrice = 1275;
                break;
            case "Premium":
                this.skinPrice = 1775;
                break;
            case "Ultra":
                this.skinPrice = 2475;
                break;
            case "Exclusive":
                this.skinPrice = 2500;
                break;
            default:
                this.skinPrice = 0;
                break;
        }
        this.skinPriceInDollars = (int) (skinPrice * 0.014);
    }


    /**
     * @author wissam al saub
     *
     * @param skinImage
     * @param skinName
     * @param skinTier
     *
     * @date 4/6/2023
     * @description regular constructor for the skin class
     */
    public Skin(String skinImage, String skinName, String skinTier) {
        this.skinImage = skinImage;
        this.skinName = skinName;
        this.skinTier = skinTier;
        switch (this.skinTier){
            case "Select":
                this.skinPrice = 875;
                break;
            case "Deluxe":
                this.skinPrice = 1275;
                break;
            case "Premium":
                this.skinPrice = 1775;
                break;
            case "Ultra":
                this.skinPrice = 2475;
                break;
            case "Exclusive":
                this.skinPrice = 2500;
                break;
            default:
                this.skinPrice = 0;
                break;
        }
        this.skinPriceInDollars = (int) (skinPrice * 0.014);
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @return returns the skin id
     */
    public int getId() {
        return id;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @param id
     * @description updates the skin id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @return returns the url for the skin's image
     */
    public String getSkinImage() {
        return skinImage;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @param skinImage
     * @description updates the url for the skin's image
     */
    public void setSkinImage(String skinImage) {
        this.skinImage = skinImage;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @return returns the skin name
     */
    public String getSkinName() {
        return skinName;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @param skinName
     * @description updates the skin name
     */
    public void setSkinName(String skinName) {
        this.skinName = skinName;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @return returns the skin tier
     */
    public String getSkinTier() {
        return skinTier;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @param skinTier
     * @description updates the skin tier
     */
    public void setSkinTier(String skinTier) {
        this.skinTier = skinTier;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @return returns the skin price
     */
    public String getSkinPrice() {
        return skinPrice + " VP";
    }
    /**
     * @author wissam al saub
     * @date 4/16/2023
     * @return returns an integer value of the skin's price retrieved from the api so we can store it in the database
     */
    public int getDBSkinPrice() {
        return skinPrice;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @param skinPrice
     * @description updates the skin price
     */
    public void setSkinPrice(int skinPrice) {
        this.skinPrice = skinPrice;
    }
    /**
     * @author wissam al saub
     * @date 4/18/2023
     * @return returns the skin price in dollars
     */
    public String getSkinPriceInDollars() {
        return "$" + skinPriceInDollars;
    }
    /**
     * @author wissam al saub
     * @date 4/18/2023
     * @param skinPriceInDollars
     * @description updates the skin price in dollars
     */
    public void setSkinPriceInDollars(int skinPriceInDollars) {
        this.skinPriceInDollars = skinPriceInDollars;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.skinImage);
        parcel.writeString(this.skinName);
        parcel.writeString(this.skinTier);
        parcel.writeInt(this.skinPrice);
    }

    protected Skin(Parcel in) {
        this.id = in.readInt();
        this.skinImage = in.readString();
        this.skinName = in.readString();
        this.skinTier = in.readString();
        this.skinPrice = in.readInt();
    }

    public static final Creator<Skin> CREATOR = new Creator<Skin>() {
        @Override
        public Skin createFromParcel(Parcel in) {
            return new Skin(in);
        }

        @Override
        public Skin[] newArray(int size) {
            return new Skin[size];
        }
    };

}
