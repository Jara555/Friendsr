package com.jara.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // initialize views
//        EditText editText = (EditText) findViewById(R.id.editText);
//
//        loadFromSharedPrefs();

        createFriends();

        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

    }

    public void createFriends() {

        int id_ross = getResources().getIdentifier("ross", "drawable", "com.jara.friendsr");
        Friend Ross = new Friend("Ross Geller", "I love dinosaurs", id_ross);
        friends.add(Ross);

        int id_joey = getResources().getIdentifier("joey", "drawable", "com.jara.friendsr");
        Friend Joey = new Friend("Joey Tribbiani", "I love pizza", id_joey);
        friends.add(Joey);

        int id_rachel = getResources().getIdentifier("rachel", "drawable", "com.jara.friendsr");
        Friend Rachel = new Friend("Rachel Green", "I love fashion", id_rachel);
        friends.add(Rachel);

        int id_monica = getResources().getIdentifier("monica", "drawable", "com.jara.friendsr");
        Friend Monica = new Friend("Monica Geller", "I love cleaning", id_monica);
        friends.add(Monica);

        int id_chandler= getResources().getIdentifier("chandler", "drawable", "com.jara.friendsr");
        Friend Chandler = new Friend("Chandler Bing", "I love jokes", id_chandler);
        friends.add(Chandler);

        int id_phoebe = getResources().getIdentifier("phoebe", "drawable", "com.jara.friendsr");
        Friend Phoebe = new Friend("Phoebe Buffay", "I love massages", id_phoebe);
        friends.add(Phoebe);
    }

//    /* This method is connected to a button in the main activity and will
//        direct to the the profile activity when clicked */
//    public void goToProfile(View view) {
//
//        String text = editText.getText().toString();
//
//        // intent: huidige + navigeer naar
//        Intent intent = new Intent(this, ProfileActivity.class);
//
//        intent.putExtra("Text", text);
//
//        startActivity(intent);
//
//        // close first activity (no copy will remain in this way)
//        finish();
//    }
//
//    /* Adds things to shared prefs */
//    public void saveToSharedPrefs(View view) {
//
//        String text = editText.getText().toString();
//
//        SharedPreferences prefs = this.getSharedPreferences("settings", this.MODE_PRIVATE);
//        SharedPreferences.Editor editor = prefs.edit();
//
//        editor.putString("text", text);
//        editor.commit();
//
//    }
//
//    public void loadFromSharedPrefs() {
//
//        SharedPreferences prefs = this.getSharedPreferences("settings", this.MODE_PRIVATE);
//
//        String textRestored = prefs.getString("text", null);
//        if (textRestored != null) {
//            editText.setText(textRestored);
//        }
//
//    }

}
