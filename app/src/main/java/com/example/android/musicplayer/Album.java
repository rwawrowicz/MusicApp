package com.example.android.musicplayer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by wawr1 on 27.03.2018.
 */

public class Album implements Parcelable {
    private ArrayList<SongInfo> mAlbum = new ArrayList<>();
    private String mAlbumName = "Album title";

    public Album(String albumName) {
        mAlbumName = albumName;
    }

    public ArrayList<SongInfo> getAlbum() {
        return mAlbum;
    }

    public String getAlbumTitle() {
        return mAlbumName;
    }

    public void addSong(SongInfo song) {
        mAlbum.add(song);
    }

    public int getAlbumSize() {
        return mAlbum.size();
    }

    public SongInfo getSong(int trackNo) {
        return mAlbum.get(trackNo);
    }

    public void writeToParcel(Parcel parcelOut, int flags) {
        parcelOut.writeTypedList(mAlbum);
        parcelOut.writeString(mAlbumName);
    }

    public Album(Parcel parcelIn) {
        parcelIn.readTypedList(mAlbum, SongInfo.CREATOR);
        mAlbumName = parcelIn.readString();
    }

    public static final Parcelable.Creator<Album> CREATOR = new Parcelable.Creator<Album>() {

        public Album createFromParcel(Parcel parcel) {
            return new Album(parcel);
        }

        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
}
