package com.jara.friendsr;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class FriendsAdapter extends ArrayAdapter<Friend> {
    /** FriendsAdapter class loading views with data of friends array **/

    // properties
    private ArrayList<Friend> friends;

    // constructor
    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);

        // set friends list
        friends = objects;
    }

    /* Gets view for Friend objects */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get grid item layout
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // get single friend of the array list
        Friend friend = friends.get(position);

        // get drawable of that friend and set to image view
        ImageView imageView = convertView.findViewById(R.id.imageView);
        Drawable image = getContext().getResources().getDrawable(friend.getDrawableId());
        imageView.setImageDrawable(image);

        // get name of friend and set to text view
        TextView textView = convertView.findViewById(R.id.textView);
        textView.setText(friend.getName());

        return convertView;
    }
}

