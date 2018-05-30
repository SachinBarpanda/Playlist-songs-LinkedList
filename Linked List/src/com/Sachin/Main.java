package com.Sachin;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

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
        ListIterator<Song>listIterator=playlist.listIterator();
        Scanner input=new Scanner(System.in);
        //ListIterator Interface is used to traverse the element in backward and forward direction.
        //By using hasNext and hasPrevious
        if(playlist.size()==0){
            System.out.println("Nothing in the playlist");
        }
        else{
            System.out.println("Now playing "+listIterator.next().toString());
            //This probably plays the first song in the list
            actionButtons();
        }
        boolean quit=false;

        //to track the direction of list iterator
        boolean Forward = true;
        while(!quit){

            System.out.println("Enter your choice");
            int action =input.nextInt();
            input.nextLine();


            switch (action){
                case 0:
                    System.out.println("Playlist completed,No more Songs to play");
                    quit=true;

                case 1:
                    if(!Forward){
                        //we can test if the user has selected to go backward then make it right
                        //it will prevent the iterator to print songs in a loop
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        Forward=true;//make it return true so that we start  where we left off!
                    }

                    if(listIterator.hasNext()){
                        System.out.println("Now Playing" + listIterator.next().toString());
                    }
                    else {
                        System.out.println("Playlist has ended");
                        Forward=false;
                    }

                    break;

                case 2://we've to move backward when the variable is true
                    if(Forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        Forward=false;//make it return false
                    }

                    if(listIterator.hasPrevious()){
                        System.out.println("Now Playing" + listIterator.previous().toString());
                    }
                    else {
                        System.out.println("Playlist has ended");
                        Forward = true;
                    }//make it return true at last
                    break;

                case 3:
                    if(Forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Replaying the same song " + listIterator.previous().toString());

                            Forward=false;//now going backward to replay the song again
                        }
                    }
                    else if(!Forward){
                        if(listIterator.hasNext()){
                            System.out.println("Replaying the same song" + listIterator.next().toString());

                            Forward=true;
                        }
                    }
                    break;

                    case 4:
                        playlistList(playlist);
                        break;


                    case 5:
                        actionButtons();
                        break;

                    case 6:
                            //delete song from playlist
                        if(playlist.size()>0){
                            listIterator.remove();
                            if(listIterator.hasNext()){
                                System.out.println("Now playing "+listIterator.next());
                            }
                            else if(listIterator.hasPrevious()){
                                System.out.println("Now playing "+listIterator.previous());
                            }
                        }
                        break;

            }
        }
    }

    private static Album getAlbum(final String artistsName, final String albumName) {
        for (Album album : Main.ALBUMS) {
            if (album.getArtist().equals(artistsName) && album.getName().equals(albumName)) return album;
        }
        return null;
    }

    //let's make a mechanism to add additional features to playlist

    private static void actionButtons(){
        System.out.println("Enter the choice as follows\n" + "0 : To quit \n"
                            +"1 : Enter to move to next song on playlist\n"
                            +"2 : Enter to move to previous song on playlist\n "
                            +"3 : To replay the current song\n"
                            +"4 : To print all the songs in the playlist\n"
                            +"5 : To print the action buttons that can be performed\n"
                            +"6 : For deleting the current song");
    }

    private static void playlistList(LinkedList<Song> playList){
        Iterator<Song>iterator=playList.iterator();
        System.out.println("--------------------------");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("**********THE END**************");
    }

}