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
 * Created by wawr1 on 26.03.2018.
 */

public class TracksAdapter extends ArrayAdapter<SongInfo> {

    public TracksAdapter(Activity context, ArrayList<SongInfo> songInfo){
        super(context, 0, songInfo);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.track_view, parent, false);
        }

        SongInfo currentSongInfo = getItem(position);

        TextView titleTextView = listItemView.findViewById(R.id.title_list_view);
        titleTextView.setText(currentSongInfo.getSongName());

        TextView artistTextView = listItemView.findViewById(R.id.artist_list_view);
        artistTextView.setText(currentSongInfo.getArtistName());

        TextView albumTextView = listItemView.findViewById(R.id.albumd_list_view);
        albumTextView.setText(currentSongInfo.getAlbumName());

        return listItemView;
    }
}
