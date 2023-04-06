package com.example.finalproject.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Agent implements Parcelable {
    // agent properties
    private int id;
    private String agentName;
    private String agentRole;
    private String agentImage;
    private String roleImage;

    /**
     * @author wissam al saub
     *
     * @param id
     * @param agentName
     * @param agentRole
     * @param agentImage
     * @param roleImage
     *
     * @date 4/6/2023
     *
     * @description DB constructor for the agent class
     */
    public Agent(int id, String agentName, String agentRole, String agentImage, String roleImage) {
        this.id = id;
        this.agentName = agentName;
        this.agentRole = agentRole;
        this.agentImage = agentImage;
        this.roleImage = roleImage;
    }

    /**
     * @author wissam al saub
     *
     * @param agentName
     * @param agentRole
     * @param agentImage
     * @param roleImage
     *
     * @date 4/6/2023
     *
     * @description regular constructor for the agent class
     */
    public Agent(String agentName, String agentRole, String agentImage, String roleImage) {
        this.agentName = agentName;
        this.agentRole = agentRole;
        this.agentImage = agentImage;
        this.roleImage = roleImage;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @return returns the agent id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @author wissam al saub
     * @param id
     * @date 4/6/2023
     * @description updates the agent id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @return returns the agent name
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @param agentName
     * @description updates the agent name
     */
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @return returns the agent role
     */
    public String getAgentRole() {
        return agentRole;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @param agentRole
     * @description updates the agent role
     */
    public void setAgentRole(String agentRole) {
        this.agentRole = agentRole;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @return returns the url for the agent's image
     */
    public String getAgentImage() {
        return agentImage;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @param agentImage
     * @description updates the url for the agent's image
     */
    public void setAgentImage(String agentImage) {
        this.agentImage = agentImage;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @return returns the url for the agent's role image
     */
    public String getRoleImage() {
        return roleImage;
    }

    /**
     * @author wissam al saub
     * @date 4/6/2023
     * @param roleImage
     * @description updates the url for the agent's role image
     */
    public void setRoleImage(String roleImage) {
        this.roleImage = roleImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.agentName);
        parcel.writeString(this.agentRole);
        parcel.writeString(this.agentImage);
        parcel.writeString(this.roleImage);
    }
    protected Agent(Parcel in) {
        this.id = in.readInt();
        this.agentName = in.readString();
        this.agentRole = in.readString();
        this.agentImage = in.readString();
        this.roleImage = in.readString();
    }

    public static final Creator<Agent> CREATOR = new Creator<Agent>() {
        @Override
        public Agent createFromParcel(Parcel in) {
            return new Agent(in);
        }

        @Override
        public Agent[] newArray(int size) {
            return new Agent[size];
        }
    };
}
