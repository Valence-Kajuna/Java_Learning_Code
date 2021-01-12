import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();
    public static void main(String[] args) {

        Album album = new Album("A boy from Tandale","Diamond");
        album.addSong("Niache",4.6);
        album.addSong("The one",4.2);
        album.addSong("Baba lao",3.2);
        album.addSong("Shusha",4.5);
        album.addSong("Kamwambie",5.0);

        albums.add(album);
        album = new Album("Father","Harmonize");
        album.addSong("Ushamba",4.3);
        album.addSong("Wapo",5.2);
        album.addSong("Hainishtui",3.2);
        album.addSong("Kushoto Kulia",3.8);
        album.addSong("My boo",4.1);

        albums.add(album);

        LinkedList<Song> playlist  = new LinkedList<Song>();
        albums.get(0).addToPlaylist("Shusha",playlist);
        albums.get(0).addToPlaylist("Kushoto Kulia",playlist);
        albums.get(0).addToPlaylist("My boo",playlist);
        albums.get(0).addToPlaylist("Wapo",playlist);
        albums.get(0).addToPlaylist("Kikulacho",playlist);// this does not exist
        albums.get(1).addToPlaylist(1,playlist);
        albums.get(1).addToPlaylist(2,playlist);
        albums.get(1).addToPlaylist(3,playlist);
        albums.get(1).addToPlaylist(4,playlist);

        play(playlist);
    }

    private static void play(LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean foward = true;
        ListIterator<Song> i = playlist.listIterator();
        if (playlist.size() ==0){
            System.out.println("No songs in the playlist");
            return;
        }else{
            System.out.println("Now playing "+ i.next().toString());
        }

        while(!quit){
            int decision = scanner.nextInt();
            switch (decision){
                case 0:
                    System.out.println("Playlist completed");
                    quit=  true;
                    break;

                case 1:
                    if(!foward){
                        if (i.hasNext()) {
                            i.next();
                        }
                    }
                    if (i.hasNext()){
                        System.out.println("Now playing " +i.next().toString());
                        foward= true;
                        break;
                    }else{
                        System.out.println("You are at the end of the playlist");

                    }
                    break;
                case 2:
                    if (foward){
                        if(i.hasPrevious()){
                            i.previous();
                        }
                    }
                    if(i.hasPrevious()){
                        System.out.println("Now playing " + i.previous().toString());
                        foward = false;
                    }else{
                        System.out.println("You are at the beginning of the playlist");
                    }
                    break;
                case 3:
                    printList(playlist);
                    break;
                case 4:
                    printMenu();
                    break;

            }
        }
    }
}