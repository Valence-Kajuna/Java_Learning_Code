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
                System.out.println((++index)+"."+i.next().getSongName());
            }
            System.out.println("\n Enter the number of the song you wish to add to the playlist or 0 to quit");
            songChoice = scanner.nextInt();
            while (songChoice!=0){
            Song choice = album.getAlbumSongs().get(songChoice-1);
            if (songExistInPlaylist(choice.getSongName(), this.playlistSongs)){
                System.out.println("The song already exist in the playlist");
            }else{
            this.playlistSongs.add(choice);
            System.out.println(choice.getSongName()+ " has been successfully added to "+ this.name);
            }
            songChoice = scanner.nextInt();
            }
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
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        while(run){
        int decision = scanner.nextInt();
        switch (decision){
            case 0:
                System.out.println("Quiting the program...");
                run= false;
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

    public void displayPlaylistSongs(){
        int counter =0;
        ListIterator<Song> i = this.playlistSongs.listIterator();
        while(i.hasNext()){
            System.out.println((counter++)+"."+ i.next().getSongName());
        }
    }
}
