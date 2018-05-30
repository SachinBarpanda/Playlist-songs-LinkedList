package com.Sachin;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    public String artist;
    private ArrayList <Song> songs = new ArrayList <Song>();

    public Album(String name, String artist) {
        this.artist = artist;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList <Song> getSongs() {
        return songs;
    }

    //Some methods to add some function to the songs
    public boolean addSong(String title, double duration) {
        //let us check if the song is present in the memory

        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    //Let's make if the findSong working
    private Song findSong(String title) {

        //a new kind of for we will bw using
        //it's called for each
        //Instead of declaring and initializing a loop counter variable,
        // you declare a variable that is the same type as the base type of the array,
        // followed by a colon, which is then followed by the array name.

        for (Song checkSongs : this.songs) {
            if (checkSongs.getTitle().equalsIgnoreCase(title)) {
                return checkSongs;
            }
        }
        return null;
    }

    //so we have to add all the songs we got from add songs to a playlist
    //let's make a playlist for that
    public boolean addSongToPlaylist(int tracknumber, LinkedList <Song> playlist) {
        //we're passing a song to the playlist
        //since we have to store array from position 0;
        int index = (tracknumber) - 1;
        //checking if there is any song
        if ((index > 0) && (index <= (this.songs.size()))) {
            //note:- this size refers to the position of song
            //which should not be getting zero
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track");
        return false;
    }

    //let's make another method to do this add song
    public boolean addSongToPlaylist(String title, LinkedList <Song> playlist) {
        Song checkedSongs = findSong(title);
        if (checkedSongs != null) {
            playlist.add(checkedSongs);
            return true;
        }

        System.out.println("The song " + title + " is not available");
        return false;


    }

    public Album addSong(final Song song) {
        if (song == null || exists(song)) return this;
        songs.add(song);
        return this;
    }

    private boolean exists(final Song song) {
        for (Song iteratingSong : songs) {
            if (iteratingSong.equals(song)) return true;
        }
        return false;
    }
}