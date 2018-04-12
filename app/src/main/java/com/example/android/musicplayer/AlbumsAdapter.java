package com.example.android.musicplayer;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wawr1 on 10.04.2018.
 */

public class AlbumsAdapter extends ArrayAdapter<Album> {

    public  AlbumsAdapter(Activity context, ArrayList<Album> album){
        super(context, 0, album);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_view, parent, false);
        }

        Album currentAlbum = getItem(position);

        TextView albumNameTextView = listItemView.findViewById(R.id.album_grouped_view);
        albumNameTextView.setText(currentAlbum.getAlbumTitle());

        TextView albumSizeTextView = listItemView.findViewById(R.id.numbers_grouped_view);
        albumSizeTextView.setText(Integer.toString(currentAlbum.getAlbumSize()));

        return listItemView;
    }
}
