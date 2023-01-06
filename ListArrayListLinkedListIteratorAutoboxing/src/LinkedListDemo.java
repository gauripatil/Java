import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {

        // WAY 1
//        LinkedList<String> placesToVisit = new LinkedList<>();

        // WAY 2
        var placesToVisit = new LinkedList<String>();

        // Add elements
        placesToVisit.add("Pune");
        placesToVisit.add(0,"Mumbai");
        System.out.println(placesToVisit);
    }
}
