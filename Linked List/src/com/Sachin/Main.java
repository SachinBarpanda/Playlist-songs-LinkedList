package com.Sachin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        ArrayList <Album> albumArrayList = new ArrayList <Album>();

        //Let's add some album in here
        //let's search the internet for some albums
        //You can suggest in the chat box

        Album albums = new Album("New Album Reputation", "Taylor Swift");
        albums.addSong("Reputation", 4.30);
        albums.addSong("End Game", 4.30);
        albums.addSong("I did something bad", 4.30);
        albums.addSong("Get away car", 4.30);
        albums.addSong("Dress", 4.30);
        albums.addSong("Don't blame me", 4.30);
        albums.addSong("Gorgeous", 4.30);
        albums.addSong("New Year's Day", 4.30);
        albums.addSong("King of My heart", 4.30);

        //let's add all the songs to the album


        albumArrayList.add(albums);

        albums = new Album("Divide", "Ed Sheeran");
        albums.addSong("Shape of you", 4.58);
        albums.addSong("Up the Castle", 5.58);
        albums.addSong("Galaway Girl", 3.58);
        albums.addSong("Market love", 6.20);
        albums.addSong("Perfect", 4.18);
        albums.addSong("How would you feel", 3.48);
        albums.addSong("Happier", 2.28);
        albums.addSong("Supermarket Flowers", 4.56);
        albums.addSong("Eraser", 5.53);

        //let's add Ed sheeran's song to the lsbum of divide

        albumArrayList.add(albums);

        //Let's add these albums to the playlist

        LinkedList <Song> playlist = new LinkedList <>();

        //Now let's add our favorite to our playlist
        //First we created an empty space to add our songs
        //Then, we made a album class to store our songs
        //Once our songs are stored ,we stored the album in the empty space we created before(albumArrayList);
        //Then we created another empty space (playlist) in which we put our favorite songs from (albumArrayList);

        albumArrayList.get(0).songAddToPlaylist("Reputation", playlist);
        albumArrayList.get(0).songAddToPlaylist("End Game", playlist);
        albumArrayList.get(0).songAddToPlaylist("King of My heart", playlist);
        albumArrayList.get(0).songAddToPlaylist("We are Together", playlist);//Let's see if it shows errpr

        //Let's add some of the songs of Ed Sheeran

        albumArrayList.get(1).songAddToPlaylist("Shape of you", playlist);
        albumArrayList.get(1).songAddToPlaylist(3, playlist);
        albumArrayList.get(1).songAddToPlaylist(6, playlist);
        albumArrayList.get(1).songAddToPlaylist(5, playlist);

        //Now we have to play the songs

        play(playlist);

        //Let's create a play method
    }
        private static void play (LinkedList<Song> playlist){
            ListIterator<Song> Iterator=playlist.listIterator();
            if(playlist.size()==0){
                System.out.println("No songs in the playlist");
                return;
            }
            else {
                System.out.println(Iterator.next().toString());
            }
        }
}
