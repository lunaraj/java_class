/**
 * Main class to run code
 */
public class Main {
    public static void main(String[] args) throws Exception {
        SpotifyPlaylist playlist = new SpotifyPlaylist();
        Song fairtrade = new Song("Fair Trade", "Drake", "Certified Lover Boy", 1.33, "rap", 99);
        Song sticky = new Song("Sticky", "Drake", "Honestly, Nevermind", 1.33, "rap", 20);
        Song moneytrees = new Song("Money Trees", "Kendrick Lamar", "good kid m.a.a.d city", 1.33, "rap", 120);
        Song rockstarmade = new Song("Rockstar Made", "Playboi Carti", "Whole Lotta Red", 1.33, "rap", 10);
        Song bane = new Song("Bane", "Destroy Lonely", "Bane", 1.22, "rap", 1000);
        Song wokeuplikethis = new Song("wokeuplikethis*", "Playboi Carti", "Playboi Carti", 1.22, "rap", 200000);
        Song selfcontrol = new Song("Self Control", "Frank Ocean", "Blonde", 2.66, "R&B", 1000);
        Song neverever = new Song("NEVEREVER", "Destroy Lonely", "NOSTYLIST", 2.24, "rap", 5);
        Song power = new Song("POWER", "Kanye West", "My Beautiful Dark Twisted Fantasy", 4.52, "rap", 999);
        Song foreign = new Song("Foreign", "Playboi Carti", "Die Lit", 2.22, "rap", 259091092);
        Song ripfredo = new Song("RIP Fredo", "Playboi Carti", "Die Lit", 2.41, "rap", 2424);
        Song flawless = new Song("Flawless", "Yeat", "Lyfe", 2.56, "rap", 92);
        Song lifegoeson = new Song("Life Goes On", "Lil Baby", "Harder Than Ever", 4.07, "rap", 65);
        playlist.addSong(rockstarmade);
        playlist.addSong(moneytrees);
        playlist.addSong(fairtrade);
        playlist.addSong(bane);
        playlist.addSong(wokeuplikethis);
        playlist.addSong(sticky);
        playlist.addSong(selfcontrol);
        playlist.addSong(neverever);
        playlist.addSong(power);
        playlist.addSong(foreign);
        playlist.addSong(ripfredo);
        playlist.addSong(flawless);
        playlist.addSong(lifegoeson);
        

        SpotifyPlaylist rapsongs = playlist.songsInGenre("rap");
        System.out.println(rapsongs);

        Song[] topSongs = playlist.topTenSongs();

        for (int i = 0; i < 10; i++) {
            System.out.println(topSongs[i] + "\n");
        }
        
    }
}
