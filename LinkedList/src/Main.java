import java.util.LinkedList;
import java.util.ListIterator;

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
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<String>();
        addItem("Bukoba",names);
        addItem("Ngara",names);
        addItem("Karagwe",names);
        addItem("Biharamulo",names);
        addItem("Muleba",names);

        print(names);

    }
}
