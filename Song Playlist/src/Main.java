public class Main {
    public static void main(String[] args) {
        Album Jux = new Album("Jux");
        Jux.addSongToAlbum("Sio mbaya",3);
        Jux.addSongToAlbum("Juu",2);
        Jux.addSongToAlbum("Zaidi",5);
        Jux.addSongToAlbum("Uzuri wako",3);

        Album alikiba = new Album("Alikiba");
        alikiba.addSongToAlbum("Mwana",4);
        alikiba.addSongToAlbum("Mshumaa",7);
        alikiba.addSongToAlbum("Mvumo wa Radi",2);
        alikiba.addSongToAlbum("Maumivu per day",1);
        alikiba.addSongToAlbum("Kidela",6);

        Playlist r = new Playlist("Relaxing Songs");
        r.addSongToPlayListFromAlbum(Jux);
        r.addSongToPlayListFromAlbum(alikiba);

        r.actions();
        r.displayPlaylistSongs();


    }
}
