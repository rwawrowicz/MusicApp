package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.albums_list);

        final ArrayList<Album> library = getIntent().getParcelableArrayListExtra("Albums");

        AlbumsAdapter albumsAdapter = new AlbumsAdapter(this, library);
        ListView listView = findViewById(R.id.albums_list);
        listView.setAdapter(albumsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<Album> singleAlbum = new ArrayList<>();
                singleAlbum.add(library.get(i));
                Intent tracksActivity = new Intent(AlbumsActivity.this, TracksActivity.class);
                tracksActivity.putParcelableArrayListExtra("Albums", singleAlbum);
                startActivity(tracksActivity);

            }


        });
    }
}
