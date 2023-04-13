package com.example.finalproject.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Map implements Parcelable {
    // map properties
    private int id;
    private String mapImage;
    private String mapName;
    private String mapDescription;
    private String mapCoordinates;

    /**
     * @author wissam al saub
     * @param id
     * @param mapImage
     * @param mapName
     * @param mapCoordinates
     *
     * @date 4/6/2023
     * @description DB constructor for the map class
     */
    public Map(int id, String mapImage, String mapName, String mapCoordinates) {
        this.id = id;
        this.mapImage = mapImage;
        this.mapName = mapName;
        this.mapCoordinates = mapCoordinates;

        if (this.mapName.trim().equals("Haven") || this.mapName.trim().equals("Lotus")){
            this.mapDescription = "This map has 3 sites";
        } else {
            this.mapDescription = "This map has 2 sites";
        }
    }

    /**
     * @author wissam al saub
     * @param mapImage
     * @param mapName
     * @param mapCoordinates
     * @date 4/6/2023
     * @description regular constructor for the map class
     */
    public Map(String mapImage, String mapName, String mapCoordinates) {
        this.mapImage = mapImage;
        this.mapName = mapName;
        this.mapCoordinates = mapCoordinates;

        if (this.mapName.trim().equals("Haven") || this.mapName.trim().equals("Lotus")){
            this.mapDescription = "This map has 3 sites";
        } else {
            this.mapDescription = "This map has 2 sites";
        }
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @return returns the map id
     */
    public int getId() {
        return id;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @param id
     * @description updates the map id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @return returns the url for the map's image
     */
    public String getMapImage() {
        return mapImage;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @param mapImage
     * @description updates the url for the map's image
     */
    public void setMapImage(String mapImage) {
        this.mapImage = mapImage;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @return returns the map name
     */
    public String getMapName() {
        return mapName;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @param mapName
     * @description updates the map name
     */
    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @return returns the map description
     */
    public String getMapDescription() {
        return mapDescription;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @param mapDescription
     * @description updates the map description
     */
    public void setMapDescription(String mapDescription) {
        this.mapDescription = mapDescription;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @return returns the map coordinates
     */
    public String getMapCoordinates() {
        return mapCoordinates;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @param mapCoordinates
     * @description updates the map coordinates
     */
    public void setMapCoordinates(String mapCoordinates) {
        this.mapCoordinates = mapCoordinates;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.mapImage);
        parcel.writeString(this.mapName);
        parcel.writeString(this.mapDescription);
        parcel.writeString(this.mapCoordinates);
    }

    protected Map(Parcel in) {
        this.id = in.readInt();
        this.mapImage = in.readString();
        this.mapName = in.readString();
        this.mapDescription = in.readString();
        this.mapCoordinates = in.readString();
    }

    public static final Creator<Map> CREATOR = new Creator<Map>() {
        @Override
        public Map createFromParcel(Parcel in) {
            return new Map(in);
        }

        @Override
        public Map[] newArray(int size) {
            return new Map[size];
        }
    };

}
