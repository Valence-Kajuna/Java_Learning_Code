import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {
    private String name;
    private LinkedList<Song> playlistSongs;

    public Playlist(String name) {
        this.name = name;
        this.playlistSongs = new LinkedList<Song>();
    }

    public boolean addSongToPlayListFromAlbum(Album album){
        Scanner scanner = new Scanner(System.in);
        int songChoice;
        if (!album.getAlbumSongs().isEmpty()){
            System.out.println("Printing Songs in the album "+ album.getAlbumName());
            ListIterator<Song> i = album.getAlbumSongs().listIterator();
            int index =0;
            while(i.hasNext()){
                System.out.println((index+1)+"."+i.next().getSongName());
            }
            System.out.println("\n Enter the number of the song you wish to add to the playlist");
            songChoice = scanner.nextInt();
            Song choice = album.getAlbumSongs().get(songChoice-1);
            if (songExistInPlaylist(choice.getSongName(), this.playlistSongs)){
                System.out.println("The song already exist in the playlist");
                return false;
            }
            this.playlistSongs.add(choice);
            System.out.println(choice.getSongName()+ " has been successfully added to "+ this.name);
            return true;
        }
        return false;
    }

    private boolean songExistInPlaylist(String songName,LinkedList<Song> playlist){
        ListIterator<Song> i = playlist.listIterator();
        while(i.hasNext()){
            if (i.next().getSongName().equals(songName)){
                return true;
            }
        }
        return false;
    }

    public void actions(){

        ListIterator<Song> i = this.playlistSongs.listIterator();
        menu();
        Scanner scanner = new Scanner(System.in);
        while(i.hasNext()){
        int decision = scanner.nextInt();
        switch (decision){
            case 0:
                System.out.println("Quiting the program...");
                break;

            case 1:
                if (i.hasNext()){
                    System.out.println(i.next().getSongName()+" now playing");
                }else{
                    System.out.println("End of the playlist");
                }
                break;

            case 2:
                if (i.hasPrevious()){
                    System.out.println(i.previous().getSongName()+ " now playing");
                }else{
                    System.out.println("You are at the beginning of the playlist");
                }

        }

        }


    }

    public void menu(){
        System.out.println("Press: \n 0: To quit \n 1: To next song \n 2: To previous song");
    }
}
