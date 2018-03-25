package com.example.android.musicplayer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.SortedMap;

/**
 * Created by wawr1 on 20.03.2018.
 */

public class SongInfo implements Parcelable {
    private String mSongName;
    private String mArtistName;
    private String mAlbumName;
    private String mGenreName;

    public SongInfo(String songName, String artistName, String albumName, String genreName){
        mSongName = songName;
        mArtistName = artistName;
        mAlbumName = albumName;
        mGenreName = genreName;
    }

    public String getSongName() {
        return mSongName;
    }
    public String getAutorName() {
        return mArtistName;
    }
    public String getArtistName() {
        return mAlbumName;
    }
    public String getGenreName() {
        return mGenreName;
    }

    public void writeToParcel(Parcel parcelOut, int flags){
        parcelOut.writeString(mSongName);
        parcelOut.writeString(mArtistName);
        parcelOut.writeString(mAlbumName);
        parcelOut.writeString(mGenreName);
    }

    public SongInfo(Parcel parcel){
        mSongName = parcel.readString();
        mArtistName = parcel.readString();
        mAlbumName = parcel.readString();
        mGenreName = parcel.readString();
    }

    public static final Parcelable.Creator<SongInfo> CREATOR = new Parcelable.Creator<SongInfo>() {
        public SongInfo createFromParcel(Parcel parcel) {
            return new SongInfo(parcel);
        }

        public SongInfo[] newArray(int size) {
            return new SongInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


}
