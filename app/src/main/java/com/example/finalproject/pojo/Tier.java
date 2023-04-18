package com.example.finalproject.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Tier implements Parcelable {
    // tier properties
    private int id;
    private String uuid;
    private String tier;

    /**
     * @author wissam al saub
     * @param id
     * @param uuid
     * @param tier
     * @date 4/17/2023
     * @description DB constructor for the tier class
     */
    public Tier(int id, String uuid, String tier) {
        this.id = id;
        this.uuid = uuid;
        this.tier = tier;
    }
    /**
     * @author wissam al saub
     * @param uuid
     * @param tier
     * @date 4/17/2023
     * @description regular constructor for the tier class
     */
    public Tier(String uuid, String tier) {
        this.uuid = uuid;
        this.tier = tier;
    }

    /**
     * @author wissam al saub
     * @date 4/17/2023
     * @return returns the tier id
     */
    public int getId() {
        return id;
    }
    /**
     * @author wissam al saub
     * @date 4/17/2023
     * @param id
     * @description updates the tier id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @author wissam al saub
     * @date 4/17/2023
     * @return returns the tier uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @author wissam al saub
     * @date 4/17/2023
     * @param uuid
     * @description updates the tier uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @author wissam al saub
     * @date 4/17/2023
     * @return returns the tier name
     */
    public String getTier() {
        return tier;
    }

    /**
     * @author wissam al saub
     * @date 4/17/2023
     * @param tier
     * @description updates the tier name
     */
    public void setTier(String tier) {
        this.tier = tier;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(uuid);
        parcel.writeString(tier);
    }

    protected Tier(Parcel in) {
        id = in.readInt();
        uuid = in.readString();
        tier = in.readString();
    }

    public static final Creator<Tier> CREATOR = new Creator<Tier>() {
        @Override
        public Tier createFromParcel(Parcel in) {
            return new Tier(in);
        }

        @Override
        public Tier[] newArray(int size) {
            return new Tier[size];
        }
    };
}
