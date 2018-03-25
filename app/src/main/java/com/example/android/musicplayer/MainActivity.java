package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<SongInfo> library = readLibrary();
        for(int i=0; i<library.size(); i++){
            Log.v("Library:", library.get(i).getSongName());
        }

        TextView tracks = findViewById(R.id.tracks_tab_header);
        tracks.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent tracksActivity = new Intent(MainActivity.this, TracksActivity.class);
                tracksActivity.putParcelableArrayListExtra("Tracks", library);
                startActivity(tracksActivity);
            }
        });

        TextView albums = findViewById(R.id.albums_tab_header);
        albums.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent albumsActivity = new Intent(MainActivity.this, AlbumsActivity.class);
                startActivity(albumsActivity);
            }
        });

        TextView artists = findViewById(R.id.artists_tab_header);
        artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistsActivity = new Intent(MainActivity.this, ArtistsActivity.class);
                startActivity(artistsActivity);
            }
        });

        TextView genres = findViewById(R.id.genres_tabs_header);
        genres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent genresActivity = new Intent(MainActivity.this, GenresActivity.class);
                startActivity(genresActivity);
            }
        });
    }


    private ArrayList<SongInfo> readLibrary(){
        ArrayList<SongInfo> library = new ArrayList<>();
        String album = "The Best of X";
        String artist = "X";
        String genre = "Rock";
        for(int i=0; i < 12; i++){
            library.add(new SongInfo(album+"-Track "+i, artist, album, genre));
        }

        album = "This is it";
        artist = "Y";
        genre = "Techno";
        for(int i=0; i < 13; i++){
            library.add(new SongInfo(album+"-Track "+i, artist, album, genre));
        }

        album = "Summer pop hits 2017";
        artist = "Various Artist";
        genre = "Pop";
        for(int i=0; i < 6; i++){
            library.add(new SongInfo(album+"-Track "+i, artist+i, album, genre));
        }

        album = "Dancing Mix Vol.1";
        library.add(new SongInfo(album+"-Track 1", "X", album, "Rock"));
        library.add(new SongInfo(album+"-Track 2", "Y", album, "Techno"));
        library.add(new SongInfo(album+"-Track 3", "R", album, "Rap"));
        library.add(new SongInfo(album+"-Track 4", "R", album, "Rap"));
        library.add(new SongInfo(album+"-Track 5", "D", album, "Dance"));

        return library;
    }

}
