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
        final ArrayList<Album> library = readLibrary();


        final TextView tracks = findViewById(R.id.tracks_tab_header);
        tracks.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                boolean allTracks = Boolean.TRUE;
                Intent tracksActivity = new Intent(MainActivity.this, TracksActivity.class);
                tracksActivity.putParcelableArrayListExtra("Albums", library);
                tracksActivity.putExtra("AllTracks", allTracks);
                startActivity(tracksActivity);
            }
        });

        TextView albums = findViewById(R.id.albums_tab_header);
        albums.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent albumsActivity = new Intent(MainActivity.this, AlbumsActivity.class);
                albumsActivity.putParcelableArrayListExtra("Albums", library);
                startActivity(albumsActivity);
            }
        });

    }

    private ArrayList<Album> readLibrary(){
        ArrayList<Album> library = new ArrayList<>();
        library.add(createAlbum("The Best of X", "X", "Rock", 15));
        library.add(createAlbum("This is it 2", "Y", "Techno", 9));
        library.add(createAlbum("The Best Album", "#1", "Techno", 12));
        library.add(createVariousArtistAlbum("Summer pop hits 2017", "Various Artist", "Pop", 8));
        library.add(createMixedAlbum("Dancing Mix Vol.1"));

        return library;
    }

    private Album createAlbum(String albumName, String artist, String genre, int len){
        Album album = new Album(albumName);
        for(int i=0; i < len; i++){
            album.addSong(new SongInfo("Track "+i, artist, albumName, genre));
        }
        return album;
    }

    private Album createVariousArtistAlbum(String albumName, String artist, String genre, int len){
        Album albumVarious = new Album(albumName);
        for(int i=0; i < len; i++){
            albumVarious.addSong(new SongInfo("Track "+i, artist+i, albumName, genre));
        }
        return albumVarious;
    }

    private Album createMixedAlbum(String albumName){
        Album album = new Album(albumName);
        album.addSong(new SongInfo("Track 1", "X", albumName, "Rock"));
        album.addSong(new SongInfo("Track 2", "Y", albumName, "Techno"));
        album.addSong(new SongInfo("Track 3", "R", albumName, "Rap"));
        album.addSong(new SongInfo("Track 4", "R", albumName, "Rap"));
        album.addSong(new SongInfo("Track 5", "D", albumName, "Dance"));
        return album;
    }

}
