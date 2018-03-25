package com.example.android.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TracksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks);

        ArrayList<SongInfo> library = getIntent().getParcelableArrayListExtra("Tracks");
        LinearLayout tracksRootView = findViewById(R.id.tracks_view);
        for(int i=0; i<library.size(); i++){
            TextView trackView = new TextView(this);
            trackView.setText(library.get(i).getSongName());
            tracksRootView.addView(trackView);
        }
    }
}
