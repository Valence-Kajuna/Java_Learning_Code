import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static boolean addItem(String item, LinkedList<String> myList){
        ListIterator<String> i = myList.listIterator();
        while(i.hasNext()){
        int comparison = i.next().compareTo(item);
            if (comparison==0){
                System.out.println("Item is already available in the list");
                return false;
            }else if (comparison >0){
                //move backward
                i.previous();
                i.add(item);
                return true;
            }
        }
        myList.add(item);
        return true;
    }

    public static void print(LinkedList<String> myList){
        ListIterator<String> i= myList.listIterator();
        while(i.hasNext()){
            System.out.println("Now visiting " +i.next());
        }
    }

    //Code to show that the linked list in Java is implemented as the double linked list
    public static void visit(LinkedList<String> cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean movingForward = true;
        ListIterator<String> i = cities.listIterator();
        if (cities.isEmpty()){
            System.out.println("There are no cities in your Region");
        }else{
            System.out.println("Now visiting "+ i.next());
            printMenu();
        }
        while(!quit){
            int action = scanner.nextInt();
            switch(action){
                case 0:
                    System.out.println("Holiday is over 😁👋");
                    quit  = true;
                    break;

                case 1:
                    if(!movingForward){
                        if (i.hasNext()){
                            i.next();
                        }
                        movingForward=true;
                    }
                    if(i.hasNext()){
                        System.out.println("You are now visiting "+ i.next());
                    }else{
                        System.out.println("You have reached the end of the journey");
                    }
                    break;

                case 2:
                    if(movingForward){
                        if (i.hasPrevious()){
                            i.previous();
                        }
                        movingForward = false;
                    }
                    if(i.hasPrevious()){
                        System.out.println("You are now visiting "+ i.previous());
                        break;
                    }else{
                        System.out.println("You are at your starting position");

                    }
                case 3:
                    printMenu();
                    break;
            }
        }
    }
    public static void printMenu(){
        System.out.println("Available actions:\nPress:");
        System.out.println("0: to quit \n 1:To move forward \n 2: To move backward \n 3:To see the menu again");
    }
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<String>();
        addItem("Bukoba",names);
        addItem("Ngara",names);
        addItem("Karagwe",names);
        addItem("Biharamulo",names);
        addItem("Muleba",names);
        print(names);
        System.out.println("");
        System.out.println("=====================");
        visit(names);


    }
}
