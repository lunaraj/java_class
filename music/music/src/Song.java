/**
 * class that represents a song
 */
public class Song {
    
    private String title;
    private String artist;
    private String album;
    private double length; // minutes
    private String genre;
    private int timesPlayed;

    /**
     * no args constructor
     */
    public Song() {
        title = "";
        artist = "";
        album = "";
        length = 0.0;
        genre = "";
        timesPlayed = 0;
    }

    public Song(int timesPlayed) {
        title = "";
        artist = "";
        album = "";
        length = 0.0;
        genre = "";
        this.timesPlayed = timesPlayed;
    }

    /**
     * overloaded constructor
     * @param title
     * @param artist
     * @param album
     * @param length
     * @param genre
     * @param timesPlayed
     */
    public Song(String title, String artist, String album, double length, String genre, int timesPlayed) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.length = length;
        this.genre = genre;
        this.timesPlayed = timesPlayed;
    }

    /**
     * getter for title of song
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * getter for artist of song
     * @return artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * getter for album of song
     * @return album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * getter for length of song
     * @return length in minuteds
     */
    public double getLength() {
        return length;
    }

    /**
     * getter for genre
     * @return genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * getter for times played
     * @return times played
     */
    public int getTimesPlayed() {
        return timesPlayed;
    }

    /**
     * sets the title of the song
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * sets the artist of the song
     * @param artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * sets the album of the song
     * @param album
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * sets the lenght of the song
     * @param length
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * sets the genre of the song
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * set the amound of times playeed
     * @param timesPlayed
     */
    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

    /**
     * increment the times the song was played by one
     */
    public void incrementTimesPlayed() {
        timesPlayed += 1;
    }

    /**
     * to string converts all fields into string
     * @return the string
     */
    @Override
    public String toString() {
        return title + " by " + artist + "\nAlbum: " + album + "\nGenre: " + genre + "\n" + length + " minutes long\n" + timesPlayed + " times played";
    }

}
