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
    private String agentDescription;
    private String agentIcon;
    private String firstAbilityIcon;
    private String firstAbilityDescription;
    private String secondAbilityIcon;
    private String secondAbilityDescription;
    private String thirdAbilityIcon;
    private String thirdAbilityDescription;
    private String fourthAbilityIcon;
    private String fourthAbilityDescription;


    /**
     * @author wissam al saub
     * @param id
     * @param agentName
     * @param agentRole
     * @param agentImage
     * @param roleImage
     * @param agentDescription
     * @param agentIcon
     * @param firstAbilityIcon
     * @param firstAbilityDescription
     * @param secondAbilityIcon
     * @param secondAbilityDescription
     * @param thirdAbilityIcon
     * @param thirdAbilityDescription
     * @param fourthAbilityIcon
     * @param fourthAbilityDescription
     *
     * @date 4/13/2023
     * @description DB constructor for the agent class
     */
    public Agent(int id, String agentName, String agentRole, String agentImage, String roleImage, String agentDescription, String agentIcon, String firstAbilityIcon, String firstAbilityDescription, String secondAbilityIcon, String secondAbilityDescription, String thirdAbilityIcon, String thirdAbilityDescription, String fourthAbilityIcon, String fourthAbilityDescription) {
        this.id = id;
        this.agentName = agentName;
        this.agentRole = agentRole;
        this.agentImage = agentImage;
        this.roleImage = roleImage;
        this.agentDescription = agentDescription;
        this.agentIcon = agentIcon;
        this.firstAbilityIcon = firstAbilityIcon;
        this.firstAbilityDescription = firstAbilityDescription;
        this.secondAbilityIcon = secondAbilityIcon;
        this.secondAbilityDescription = secondAbilityDescription;
        this.thirdAbilityIcon = thirdAbilityIcon;
        this.thirdAbilityDescription = thirdAbilityDescription;
        this.fourthAbilityIcon = fourthAbilityIcon;
        this.fourthAbilityDescription = fourthAbilityDescription;
    }

    /**
     * @author wissam al saub
     * @param agentName
     * @param agentRole
     * @param agentImage
     * @param roleImage
     * @param agentDescription
     * @param agentIcon
     * @param firstAbilityIcon
     * @param firstAbilityDescription
     * @param secondAbilityIcon
     * @param secondAbilityDescription
     * @param thirdAbilityIcon
     * @param thirdAbilityDescription
     * @param fourthAbilityIcon
     * @param fourthAbilityDescription
     *
     * @date 4/13/2023
     * @description regular constructor for the agent class
     */
    public Agent(String agentName, String agentRole, String agentImage, String roleImage, String agentDescription, String agentIcon, String firstAbilityIcon, String firstAbilityDescription, String secondAbilityIcon, String secondAbilityDescription, String thirdAbilityIcon, String thirdAbilityDescription, String fourthAbilityIcon, String fourthAbilityDescription) {
        this.agentName = agentName;
        this.agentRole = agentRole;
        this.agentImage = agentImage;
        this.roleImage = roleImage;
        this.agentDescription = agentDescription;
        this.agentIcon = agentIcon;
        this.firstAbilityIcon = firstAbilityIcon;
        this.firstAbilityDescription = firstAbilityDescription;
        this.secondAbilityIcon = secondAbilityIcon;
        this.secondAbilityDescription = secondAbilityDescription;
        this.thirdAbilityIcon = thirdAbilityIcon;
        this.thirdAbilityDescription = thirdAbilityDescription;
        this.fourthAbilityIcon = fourthAbilityIcon;
        this.fourthAbilityDescription = fourthAbilityDescription;
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

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @return returns the agent's description
     */
    public String getAgentDescription() {
        return agentDescription;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @param agentDescription
     * @description updates the agent's description
     */
    public void setAgentDescription(String agentDescription) {
        this.agentDescription = agentDescription;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @return returns the url for the agent's small icon
     */
    public String getAgentIcon() {
        return agentIcon;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @param agentIcon
     * @description updates the url for the agent's small icon
     */
    public void setAgentIcon(String agentIcon) {
        this.agentIcon = agentIcon;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @return returns the url for the agent's first ability icon
     */
    public String getFirstAbilityIcon() {
        return firstAbilityIcon;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @param firstAbilityIcon
     * @description updates the url for the agent's first ability icon
     */
    public void setFirstAbilityIcon(String firstAbilityIcon) {
        this.firstAbilityIcon = firstAbilityIcon;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @return returns the agent's first ability description
     */
    public String getFirstAbilityDescription() {
        return firstAbilityDescription;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @param firstAbilityDescription
     * @description updates the agent's first ability description
     */
    public void setFirstAbilityDescription(String firstAbilityDescription) {
        this.firstAbilityDescription = firstAbilityDescription;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @return returns the url for the agent's second ability icon
     */
    public String getSecondAbilityIcon() {
        return secondAbilityIcon;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @param secondAbilityIcon
     * @description updates the url for the agent's second ability icon
     */
    public void setSecondAbilityIcon(String secondAbilityIcon) {
        this.secondAbilityIcon = secondAbilityIcon;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @return returns the agent's second ability description
     */
    public String getSecondAbilityDescription() {
        return secondAbilityDescription;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @param secondAbilityDescription
     * @description updates the agent's second ability description
     */
    public void setSecondAbilityDescription(String secondAbilityDescription) {
        this.secondAbilityDescription = secondAbilityDescription;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @return returns the url for the agent's third ability icon
     */
    public String getThirdAbilityIcon() {
        return thirdAbilityIcon;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @param thirdAbilityIcon
     * @description updates the url for the agent's third ability icon
     */
    public void setThirdAbilityIcon(String thirdAbilityIcon) {
        this.thirdAbilityIcon = thirdAbilityIcon;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @return returns the agent's third ability description
     */
    public String getThirdAbilityDescription() {
        return thirdAbilityDescription;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @param thirdAbilityDescription
     * @description updates the agent's third ability description
     */
    public void setThirdAbilityDescription(String thirdAbilityDescription) {
        this.thirdAbilityDescription = thirdAbilityDescription;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @return returns the url for the agent's fourth ability icon
     */
    public String getFourthAbilityIcon() {
        return fourthAbilityIcon;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @param fourthAbilityIcon
     * @description updates the url for the agent's fourth ability icon
     */
    public void setFourthAbilityIcon(String fourthAbilityIcon) {
        this.fourthAbilityIcon = fourthAbilityIcon;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @return returns the agent's fourth ability description
     */
    public String getFourthAbilityDescription() {
        return fourthAbilityDescription;
    }

    /**
     * @author wissam al saub
     * @date 4/13/2023
     * @param fourthAbilityDescription
     * @description updates the agent's fourth ability description
     */
    public void setFourthAbilityDescription(String fourthAbilityDescription) {
        this.fourthAbilityDescription = fourthAbilityDescription;
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
        parcel.writeString(this.agentDescription);
        parcel.writeString(this.agentIcon);
        parcel.writeString(this.firstAbilityIcon);
        parcel.writeString(this.firstAbilityDescription);
        parcel.writeString(this.secondAbilityIcon);
        parcel.writeString(this.secondAbilityDescription);
        parcel.writeString(this.thirdAbilityIcon);
        parcel.writeString(this.thirdAbilityDescription);
        parcel.writeString(this.fourthAbilityIcon);
        parcel.writeString(this.fourthAbilityDescription);
    }
    protected Agent(Parcel in) {
        this.id = in.readInt();
        this.agentName = in.readString();
        this.agentRole = in.readString();
        this.agentImage = in.readString();
        this.roleImage = in.readString();
        this.agentDescription = in.readString();
        this.agentIcon = in.readString();
        this.firstAbilityIcon = in.readString();
        this.firstAbilityDescription = in.readString();
        this.secondAbilityIcon = in.readString();
        this.secondAbilityDescription = in.readString();
        this.thirdAbilityIcon = in.readString();
        this.thirdAbilityDescription = in.readString();
        this.fourthAbilityIcon = in.readString();
        this.fourthAbilityDescription = in.readString();
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
