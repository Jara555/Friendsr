package com.jara.friendsr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // declare class variable
    ArrayList<Friend> friends = new ArrayList<>();

    /* Sets toolbar */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tool_bar, menu);
        return true;
    }

    /* Initializes main activity */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create friends
        if (friends.size() == 0) {
            createFriends();
        }

        // initialize adapter
        initialzeAdapter();

        // create grid click listener item on gridview
        GridView gridView = (GridView) findViewById(R.id.gridView);
        GridItemClickListener gridClick = new GridItemClickListener();
        gridView.setOnItemClickListener(gridClick);
    }

    /* Directs to the the profile activity of the clicked item */
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

    /* Responds when action button in toolbar is clicked */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // create intent and pass friends list through
        Intent addFriendIntent = new Intent(MainActivity.this, AddProfileActivity.class);
        addFriendIntent.putExtra("friends", friends);

        // redirect to AddProfile activity
        startActivityForResult(addFriendIntent,1);

        return super.onOptionsItemSelected(item);
    }

    /* Returns to this method coming back from AddProfile activity with new friend */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // update friends
        friends = (ArrayList<Friend>) data.getSerializableExtra("friends");

        // adapter to initialize grid view
        initialzeAdapter();
    }

    /* Saves information in bundle */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // set variables
        Friend friend;
        ArrayList<String> new_names = new ArrayList<>();
        int n = friends.size();

        // iterate over friends and store if friend is not standard
        for (int i = 0; i < n; i++) {
            friend = friends.get(i);
            if (!friend.getStandard()) {
                outState.putSerializable(friend.getName(), friend);
                new_names.add(friend.getName());
            }
        }

        // store names in bundle
        outState.putStringArrayList("new_names", new_names);
    }

    /* Restores information out of bundle */
    @Override
    protected void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);

        // get variables
        ArrayList<String> new_names = inState.getStringArrayList("new_names");
        int n = new_names.size();
        Friend friend;

        // iterate over new names and restore new friends
        for (int i = 0; i < n; i++) {
            friend = (Friend) inState.getSerializable(new_names.get(i));
            friends.add(friend);
        }
    }

    /* Sets adapter to grid view */
    public void initialzeAdapter() {
        // find grid view
        GridView gridView = (GridView) findViewById(R.id.gridView);

        // initialize and set adapter to grid view
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        gridView.setAdapter(adapter);
    }

    /* Create standard friends */
    public void createFriends() {

        int id_ross = getResources().getIdentifier("ross", "drawable", "com.jara.friendsr");
        Friend Ross = new Friend("Ross", "\"We were on a break!\"", id_ross, true);
        friends.add(Ross);

        int id_joey = getResources().getIdentifier("joey", "drawable", "com.jara.friendsr");
        Friend Joey = new Friend("Joey", "\"How YOU doin\'?!\"", id_joey, true);
        friends.add(Joey);

        int id_monica = getResources().getIdentifier("monica", "drawable", "com.jara.friendsr");
        Friend Monica = new Friend("Monica", "\"And remember, if I'm harsh with you it's only because your're doing it wrong.", id_monica, true);
        friends.add(Monica);

        int id_rachel = getResources().getIdentifier("rachel", "drawable", "com.jara.friendsr");
        Friend Rachel = new Friend("Rachel", "\"Oh, are you setting Ross up with someone? Does she have a wedding dress?\"", id_rachel, true);
        friends.add(Rachel);

        int id_chandler= getResources().getIdentifier("chandler", "drawable", "com.jara.friendsr");
        Friend Chandler = new Friend("Chandler", "\"I'm not so good with the advice. Can I interest you in a sarcastic comment?\"", id_chandler, true);
        friends.add(Chandler);

        int id_phoebe = getResources().getIdentifier("phoebe", "drawable", "com.jara.friendsr");
        Friend Phoebe = new Friend("Phoebe", "\"Smelly cat, smel-ly cat, what are they feeding you? Smelly cat, smel-ly cat, it's not your fault.\"", id_phoebe, true);
        friends.add(Phoebe);

        int id_janice = getResources().getIdentifier("janice", "drawable", "com.jara.friendsr");
        Friend Janice = new Friend("Janice", "\"Oh. My. Gawd.\"", id_janice, true);
        friends.add(Janice);

        int id_mike = getResources().getIdentifier("mike", "drawable", "com.jara.friendsr");
        Friend Mike = new Friend("Mike", "\"First name: Crap. Last name: Bag.\"", id_mike, true);
        friends.add(Mike);

        int id_gunther = getResources().getIdentifier("gunther", "drawable", "com.jara.friendsr");
        Friend Gunther = new Friend("Gunther", "\"What's my last name?\"", id_gunther, true);
        friends.add(Gunther);

        int id_jack = getResources().getIdentifier("jack", "drawable", "com.jara.friendsr");
        Friend Jack = new Friend("Jack", "\"Son, I had to shave my ears for tonight!\"", id_jack, true);
        friends.add(Jack);
    }
}
