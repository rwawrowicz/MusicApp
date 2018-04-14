package com.example.android.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TracksActivity extends AppCompatActivity {

    private TextView nowPlayingSongText;
    private TextView nowPlayingArtist;
    private Button playButton;
    private Button playNextButton;
    private Button playPrevButton;
    private Boolean playing;
    private int currentSongIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracks_list);
        nowPlayingSongText = findViewById(R.id.now_playing_song);
        nowPlayingArtist = findViewById(R.id.now_playing_artist);
        playButton = findViewById(R.id.button_play);
        playNextButton= findViewById(R.id.button_next);
        playPrevButton = findViewById(R.id.button_prev);
        playing = Boolean.FALSE;
        currentSongIndex = 0;



        ArrayList<Album> library = getIntent().getParcelableArrayListExtra("Albums");
        boolean allTracks = getIntent().getBooleanExtra("AllTracks", Boolean.FALSE);
        if (!allTracks && library.size() == 1) {
            setTitle(library.get(0).getAlbumTitle());

        }
        final ArrayList<SongInfo> tracks = new ArrayList<>();
        for(int i=0; i<library.size(); i++){
            for(int j=0; j<library.get(i).getAlbumSize(); j++){
                tracks.add(library.get(i).getSong(j));
            }
        }
        TracksAdapter itemsAdapter = new TracksAdapter(this, tracks);
        ListView listView = findViewById(R.id.tracks_list);
        listView.setAdapter(itemsAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String currentSongTitle = tracks.get(i).getSongName();
                String currentArtist = tracks.get(i).getArtistName();
                nowPlayingSongText.setText("Now playing: " + currentSongTitle);
                nowPlayingArtist.setText(currentArtist);
                currentSongIndex = i;
                playButton.setText("STOP");
                playing = Boolean.TRUE;

            }

        });
        playButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (playing) {
                    playButton.setText("PLAY");
                    nowPlayingSongText.setText(tracks.get(currentSongIndex).getSongName());
                    playing = Boolean.FALSE;
                } else {
                    playButton.setText("STOP");
                    nowPlayingSongText.setText("Now playing: " + tracks.get(currentSongIndex).getSongName());
                    playing = Boolean.TRUE;
                }

            }
        });

        playNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (currentSongIndex < tracks.size() - 1) {
                    currentSongIndex++;
                } else {
                    currentSongIndex = 0;
                }
                String currentSongTitle = tracks.get(currentSongIndex).getSongName();
                String currentArtist = tracks.get(currentSongIndex).getArtistName();
                if (playing) {
                    nowPlayingSongText.setText("Now playing: " + currentSongTitle);
                } else {
                    nowPlayingSongText.setText(currentSongTitle);
                }
                nowPlayingArtist.setText(currentArtist);
            }
        });

        playPrevButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (currentSongIndex > 0) {
                    currentSongIndex--;
                } else {
                    currentSongIndex = tracks.size() - 1;
                }
                String currentSongTitle = tracks.get(currentSongIndex).getSongName();
                String currentArtist = tracks.get(currentSongIndex).getArtistName();
                if (playing) {
                    nowPlayingSongText.setText("Now playing: " + currentSongTitle);
                } else {
                    nowPlayingSongText.setText(currentSongTitle);
                }
                nowPlayingArtist.setText(currentArtist);
            }
        });

    }
}
