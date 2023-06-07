/**
 * class that represents a spotify playlist
 */
public class SpotifyPlaylist  {
    private Song[] playlist;
    
    /**
     * spotify plalist no-args construcgtor
     */
    public SpotifyPlaylist() {
        playlist = new Song[1000];
    }

    /**
     * gets a song from the playlist based on index
     * @param i
     * @return a song
     */
    public Song getSong(int i) {
        return playlist[i];
    }

    /**
     * gets a song from the playlist based on title
     * @param title
     * @return a song
     */
    public Song getSong(String title) {
        for (int i = 0; i < 1000; i++) {
            if (playlist[i] != null) {
                if (playlist[i].getTitle().equals(title)) {
                    return playlist[i];
                }
            }
        }
        return null;
    }

    /**
     * adds a song to the playlist
     * @param song
     */
    public void addSong(Song song) {
        for (int i = 0; i < 1000; i++) {
            if (playlist[i] == null) {
                playlist[i] = song;
                break;
            }
        }
    }

    /**
     * toString method for Playlist. returns a string with all the songs in a string
     */
    
    @Override
    public String toString() {
        int num = 0;
        String allsongs = new String();
        while (num < 999 && playlist[num] != null) {
            allsongs += playlist[num].getTitle() + "\n";
            num++;
        }
        return allsongs;
    }

    /**
     * returns all songs in genre
     * @return
     */
    public SpotifyPlaylist songsInGenre(String genre) {
        SpotifyPlaylist songs = new SpotifyPlaylist();
        for (int i = 0; i < 1000; i++){
            if (playlist[i] != null && playlist[i].getGenre().equals(genre)) {
                songs.addSong(playlist[i]);
            }
        }
        return songs;
    }

    /**
     * removes a song from the playlist based on title
     * @param title
     */
    public void removeSong(String title) {
        for(int i = 0; i < 1000; i++) {
            if (playlist[i] != null) {
                if (playlist[i].getTitle().equals(title)) {
                    playlist[i] = null;
                    }
            }
        }
    }

    /**
     * makes an idnetical copy of the playlist
     * @return identical copy of playlist
     */
    public SpotifyPlaylist copy() {
        SpotifyPlaylist playlist = new SpotifyPlaylist();
        for (int i = 0; i < 1000; i++) {
            playlist.addSong(this.playlist[i]);
        }
        return playlist;
    }

    /**
     * finds the top ten played songs of the playliust
     * @return the top ten songs in a list of songs
     */
    public Song[] topTenSongs() {
        Song[] topTen = new Song[10];
        SpotifyPlaylist newPlaylist = copy();
        Song topsong;
        for (int i = 0; i < 10; i++) {
            topsong = topSong(newPlaylist);
            topTen[i] = topsong;
            newPlaylist.removeSong(topsong.getTitle());
        }
        return topTen;
        
        
    }

    /**
     * finds the most listened to song in a playlist
     * @param playlist
     * @return the most listed to song
     */
    private Song topSong(SpotifyPlaylist playlist) {
        Song greatest = new Song(0);
        for (int i = 0; i < 1000; i++) {
            if (playlist.getSong(i) != null) {
                if (playlist.getSong(i).getTimesPlayed() > greatest.getTimesPlayed()) {
                    greatest = playlist.getSong(i);
                }
            }
        }
        
        return greatest;
    }

    /**
     * plays a song and increments the number of plays by one
     * @param title
     */
    public void playSong(String title) {
        Song song = getSong(title);
        if (song != null) {
            song.incrementTimesPlayed();
        }
    }

    /**
     * plays all songs and increments them all by one
     */
    public void playAllSongs() {
        for (Song song : playlist) {
            if (song != null) {
                song.incrementTimesPlayed();
            }
        }
    }
    
    
}
