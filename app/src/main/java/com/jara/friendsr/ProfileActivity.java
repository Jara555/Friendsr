package com.jara.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity {
    /** ProfileActivity class for setting up individual profiles of Friend objects **/

    /* Loads profile layout */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set activity profile layout
        setContentView(R.layout.activity_profile);

        // retrieve friend from intent
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // set drawable image of friend
        ImageView imageProfile = (ImageView) findViewById(R.id.imageProfile);
        imageProfile.setImageResource(retrievedFriend.getDrawableId());

        // set and store name of friend
        TextView textName = (TextView) findViewById(R.id.textName);
        String name = retrievedFriend.getName();
        textName.setText(name);

        // set bio of friend
        TextView textBio = (TextView) findViewById(R.id.textBio);
        textBio.setText(retrievedFriend.getBio());

        // call listener method when rating bar clicked
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        OnRatingBarChangeListener clickRating = new OnRatingBarChangeListener(name);
        ratingBar.setOnRatingBarChangeListener(clickRating);

        // restore rating bar preferences
        loadFromSharedPrefs(ratingBar, retrievedFriend);
    }

    private class OnRatingBarChangeListener implements RatingBar.OnRatingBarChangeListener {
        /** Saves the preferences of the rating bar **/

        // properties
        private String name;

        // constructor
        public OnRatingBarChangeListener(String name) {
            this.name = name;
        }

        /* Gets called when rating is changed by user */
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            // initialize editor and save rating under corresponding name
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat(name, rating);
            editor.apply();
        }
    }

    /* Loads the saved preferences for the rating bar */
    public void loadFromSharedPrefs(RatingBar ratingBar, Friend retrievedFriend) {
        // retrieve rating of input name from shared preferences
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        Float rating = prefs.getFloat(retrievedFriend.getName(), 0);

        // set rating to Friend object
        retrievedFriend.setRating(rating);

        // if rating is not 0 restore rating in bar
        if (rating != 0) {
            ratingBar.setRating(rating);
        }
    }
}
