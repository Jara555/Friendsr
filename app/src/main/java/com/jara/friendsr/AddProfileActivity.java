package com.jara.friendsr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class AddProfileActivity extends AppCompatActivity {
    /** AddProfileActivity class for adding a profile to the app **/

    // set class variable
    ArrayList<Friend> friends = new ArrayList<>();

    /* Gets the add profile layout and retrieves friends */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);

        // retrieve friends list from intent
        Intent intent = getIntent();
        friends = (ArrayList<Friend>) intent.getSerializableExtra("friends");
    }

    /* Adds a new profile to the friends list */
    public void addProfile(View view) {

        // get edit text inputs and store as string
        EditText addName = (EditText) findViewById(R.id.addName);
        String newName = addName.getText().toString();
        EditText addBio = (EditText) findViewById(R.id.addBio);
        String newBio = addBio.getText().toString();

        // create new Friend object based on input text (standard friend = false)
        int id_new = getResources().getIdentifier("anonymous", "drawable", "com.jara.friendsr");
        Friend newFriend = new Friend(newName, newBio, id_new, false);
        friends.add(newFriend);

        // set intent and pass updated friends list through as result to main activity
        Intent resultIntent = new Intent(AddProfileActivity.this, MainActivity.class);
        resultIntent.putExtra("friends", friends);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}
