package com.Sachin;

public class Song {
    private String title;
    private double duration;

    //creating a basic Song compostion
    public Song(String title,double duration){
        this.title=title;
        this.duration=duration;
    }
    public String getTitle(){
        return title;
    }
    //this is a overrided method
    //in this you can see
    //You can create a function to be called in place of the default toString() method.
    // The toString() method takes no arguments and should return a string.
    // The toString() method you create can be any value you want,
    // but it will be most useful if it carries information about the object.

    public String toString(){
        return this.title +":"+this.duration;
    }
    public boolean equals(final Object obj) {
        if (!(obj instanceof Song)) return false;//Return false if the object we're checking against is not an instance of this class (Song)
        Song song = (Song)obj;
        return song.getTitle().equals(getTitle()) && song.duration == duration;
    }
}
