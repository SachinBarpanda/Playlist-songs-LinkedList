package com.Sachin;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    //Let's add some album in here
    //let's search the internet for some albums
    //You can suggest in the chat box

    private static final Album[] ALBUMS = new Album[] {//Albums in a array format for easy access
            new Album("New Album Reputation", "Taylor Swift")
                    .addSong(new Song("Reputation", 4.30))
                    .addSong(new Song("End Game", 4.30))
                    .addSong(new Song("I did something bad", 4.30))
                    .addSong(new Song("Get away car", 4.30))
                    .addSong(new Song("Dress", 4.30))
                    .addSong(new Song("Don't blame me", 4.30))
                    .addSong(new Song("Gorgeous", 4.30))
                    .addSong(new Song("New Year's Day", 4.30))
                    .addSong(new Song("King of My heart", 4.3)
            ),

            new Album("Divide", "Ed Sheeran")
                    .addSong(new Song("Shape of you", 4.58))
                    .addSong(new Song("Up the Castle", 5.58))
                    .addSong(new Song("Galaway Girl", 3.58))
                    .addSong(new Song("Market love", 6.20))
                    .addSong(new Song("Perfect", 4.18))
                    .addSong(new Song("How would you feel", 3.48))
                    .addSong(new Song("Happier", 2.28))
                    .addSong(new Song("Supermarket Flowers", 4.56))
                    .addSong(new Song("Eraser", 5.53))
    };

    public static void main(String[] args) {
        //Let's add these albums to the playlist

        LinkedList <Song> playlist = new LinkedList <>();

        //Now let's add our favorite to our playlist
        //First we created an empty space to add our songs
        //Then, we made a album class to store our songs
        //Once our songs are stored ,we stored the album in the empty space we created before(albumArrayList);
        //Then we created another empty space (playlist) in which we put our favorite songs from (albumArrayList);

        Album albumTSReputation = Main.getAlbum("Taylor Swift", "New Album Reputation");
        if (albumTSReputation == null) {
            throw new NullPointerException(String.format("Failed to get the album \"%s\" by \"%s\"", "New Album Reputation", "Taylor Swift"));
        }

        albumTSReputation.addSongToPlaylist("Reputation", playlist);
        albumTSReputation.addSongToPlaylist("End Game", playlist);
        albumTSReputation.addSongToPlaylist("King of My heart", playlist);
        albumTSReputation.addSongToPlaylist("We are Together", playlist);//Let's see if it shows errpr - Not available in the album

        //Let's add some of the songs of Ed Sheeran

        Album albumDivide = Main.getAlbum("Ed Sheeran", "Divide");
        if (albumDivide == null) {
            throw new NullPointerException(String.format("Failed to get the album \"%s\" by \"%s\"", "Divide", "Ed Sheeran"));
        }

        albumDivide.addSongToPlaylist("Shape of you", playlist);
        albumDivide.addSongToPlaylist(3, playlist);
        albumDivide.addSongToPlaylist(6, playlist);
        albumDivide.addSongToPlaylist(5, playlist);

        //Now we have to play the songs

        play(playlist);

        //Let's create a play method
    }

    private static void play(LinkedList<Song> playlist) {
        ListIterator<Song> iterator = playlist.listIterator();
        if (playlist.isEmpty()) {
            System.out.println("No songs in the playlist");
            return;
        }

        //Iterate over all songs in the list
        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        System.out.println();//Used as a spacer
        System.out.println("Done playing the current playlist");
    }

    private static Album getAlbum(final String artistsName, final String albumName) {
        for (Album album : Main.ALBUMS) {
            if (album.getArtist().equals(artistsName) && album.getName().equals(albumName)) return album;
        }
        return null;
    }

}