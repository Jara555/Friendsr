package com.jara.friendsr;

import java.io.Serializable;

public class Friend implements Serializable {
    /** Friend class containing all properties and methods for Friend objects **/

    // properties
    private String name, bio;
    private int drawableId;
    private float rating;
    private boolean standardFriends;

    // constructor
    public Friend(String name, String bio, int drawableId, boolean standardFriends) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
        this.standardFriends = standardFriends;
    }

    /* Returns name of Friend object */
    public String getName() {
        return name;
    }

    /* Returns bio of Friend object */
    public String getBio() {
        return bio;
    }

    /* Returns image/drawable id of Friend object */
    public int getDrawableId() {
        return drawableId;
    }

    /* Returns true when Friend object is standard */
    public boolean getStandard() {
        return standardFriends;
    }

    /* Sets rating of Friend object */
    public void setRating(float rating) {
        this.rating = rating;
    }
}
