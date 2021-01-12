import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    private String albumName;
    private LinkedList<Song> albumSongs;

    public Album(String albumName) {
        this.albumName = albumName;
        this.albumSongs = new LinkedList<Song>();
    }

    public String getAlbumName() {
        return albumName;
    }

    public LinkedList<Song> getAlbumSongs() {
        return albumSongs;
    }
    private boolean songExists(String songName,LinkedList<Song> listOfSongsInAlbum){
        ListIterator<Song> i = listOfSongsInAlbum.listIterator();
        while(i.hasNext()){
            if(i.next().getSongName().equals(songName)){
                return true;
            }
        }
        return false;
    }

    public boolean addSongToAlbum(String songName,int duration){
        if (songExists(songName,this.albumSongs)){
            System.out.println("The song already exist in the playlist");
            return false;
        }else{
            this.albumSongs.add(new Song(songName,duration));
        }
        return true;
    }

}
