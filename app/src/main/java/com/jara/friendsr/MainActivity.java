package com.jara.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get grid view
        GridView gridView = (GridView) findViewById(R.id.gridView);

        // initialize list with friends
        createFriends();

        // initialize and set adapter to grid view
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        gridView.setAdapter(adapter);

        // create grid click listener item
        GridItemClickListener gridClick = new GridItemClickListener();
        gridView.setOnItemClickListener(gridClick);

    }

    /* Directs to the the profile activity of clicked item */
    private class GridItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            // get friend of clicked position
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);
            System.out.println(clickedFriend.getName());

            // create intent and pass clicked friend through
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }

    public void createFriends() {

        int id_ross = getResources().getIdentifier("ross", "drawable", "com.jara.friendsr");
        Friend Ross = new Friend("Ross", "I love dinosaurs", id_ross);
        friends.add(Ross);

        int id_joey = getResources().getIdentifier("joey", "drawable", "com.jara.friendsr");
        Friend Joey = new Friend("Joey", "I love pizza", id_joey);
        friends.add(Joey);

        int id_rachel = getResources().getIdentifier("rachel", "drawable", "com.jara.friendsr");
        Friend Rachel = new Friend("Rachel", "I love fashion", id_rachel);
        friends.add(Rachel);

        int id_monica = getResources().getIdentifier("monica", "drawable", "com.jara.friendsr");
        Friend Monica = new Friend("Monica", "I love cleaning", id_monica);
        friends.add(Monica);

        int id_chandler= getResources().getIdentifier("chandler", "drawable", "com.jara.friendsr");
        Friend Chandler = new Friend("Chandler", "I love jokes", id_chandler);
        friends.add(Chandler);

        int id_phoebe = getResources().getIdentifier("phoebe", "drawable", "com.jara.friendsr");
        Friend Phoebe = new Friend("Phoebe", "I love massages", id_phoebe);
        friends.add(Phoebe);
    }
}
