import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo {
    public static void main(String[] args) {

        // WAY 1
        // LinkedList<String> placesToVisit = new LinkedList<>();

        // WAY 2
        var placesToVisit = new LinkedList<String>();

        // Add elements
        placesToVisit.add("Pune");
        placesToVisit.add(0,"Mumbai");

        // ADD ELEMENTS
        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

        // REMOVE ELEMENTS
        // removeMoreElements(placesToVisit);

        // GETTING ELEMENTS FROM THE LIST
        gettingElements(placesToVisit);

        // TRAVERSE LISTS - TRADITIONAL FOR
        printItinerary(placesToVisit);

        // TRAVERSE LISTS - FOREACH
        printItinerary2(placesToVisit);

        // TRAVERSE LISTS - ITERATOR
        printItinerary3(placesToVisit);
        System.out.println(placesToVisit);

        // ITERATOR DEMO
        iteratorVsListIterator(placesToVisit);
    }

    public static void addMoreElements(LinkedList<String> placesToVisit){
        //LIST METHODS
        placesToVisit.addFirst("Ahmednagar");
        placesToVisit.addLast("Dhule");


        // QUEUE METHODS
        // Adds element to tail (last) elements of the list
        placesToVisit.offer("Nashik");
        // Adds element at front of the list
        placesToVisit.offerFirst("Solapur");
        // Insert at the end of list
        placesToVisit.offerLast("Kolhapur");


        // STACK METHODS
        // Pushes the element onto stack represented by this list ie at the front of the list
        placesToVisit.push("Nanded");
    }

    public static void removeMoreElements(LinkedList<String> placesToVisit) {
        placesToVisit.remove(1);
        placesToVisit.remove("Nashik");
        System.out.println(placesToVisit);

        // LIST METHODS
        // removes the head of the list
        String s1 = placesToVisit.remove();
        System.out.println("remove() - " + s1 + " was removed");

        // removes the head of the list
        String s2 = placesToVisit.removeFirst();
        System.out.println("removeFirst() - " + s2 + " was removed");

        // removes the tail of the list
        String s3 = placesToVisit.removeLast();
        System.out.println("removeLast() - " + s3 + " was removed");

        //QUEUE/DEQUEUE POLL METHODS
        // removes the head of the list
        String p1 = placesToVisit.poll();
        System.out.println("poll() - " + p1 + " was removed");

        // removes the head of the list
        String p2 = placesToVisit.pollFirst();
        System.out.println("pollFirst() - " + p2 + " was removed");

        // removes the tail of the list
        String p3 = placesToVisit.pollLast();
        System.out.println("pollLast() - " + p3 + " was removed");


        // STACK PUSH & POP METHODS
        placesToVisit.push("Kalyan");
        placesToVisit.push("Bandra");
        placesToVisit.push("Ville Parle");
        System.out.println(placesToVisit);

        // removes & return the first element of ghe list
        String p4 = placesToVisit.pop();
        System.out.println(p4 + " was removed");
    }

    public static void gettingElements(LinkedList<String> placesToVisit) {
        System.out.println("Retrieved element - " + placesToVisit.get(4));

        System.out.println("First element - " + placesToVisit.getFirst());
        System.out.println("Last element - " + placesToVisit.getLast());
        System.out.println("Mumbai is at " + placesToVisit.indexOf("Mumbai"));
        System.out.println("Dhule is at position of " + placesToVisit.lastIndexOf("Dhule"));

        // QUEUE RETRIEVAL METHODS
        // as per fifo, gets head / first element from the list
        System.out.println("Element from element() - " + placesToVisit.element());

        // STACK RETRIEVAL METHODS
        //as per fifo, gets head / first element from the list
        System.out.println("Element from peek() - " + placesToVisit.peek());
        // as per fifo, gets head / first element from the list
        System.out.println("Element from peekFirst() - " + placesToVisit.peekFirst());
        // as per fifo, gets last element from the last
        System.out.println("Element from peekLast() - " + placesToVisit.peekLast());
    }

    public static void printItinerary(LinkedList<String> placesToVisit) {
        System.out.println("-".repeat(20) + "FOR VERSION" + "-".repeat(20) );
        String firstPlace = placesToVisit.getFirst();
        String lastPlace = placesToVisit.getLast();

        System.out.println("Trip starts at: " + firstPlace);
        for (int i = 1; i < placesToVisit.size(); i++) {
            System.out.println("---> From: " + placesToVisit.get(i-1) + " to " + placesToVisit.get(i));
        }
        System.out.println("Trip ends at: " + lastPlace);
    }

    public static void printItinerary2(LinkedList<String> placesToVisit) {
        System.out.println("-".repeat(20) + "FOREACH VERSION" + "-".repeat(20) );

        System.out.println("Trip starts at: " + placesToVisit.getFirst());
        String previousTown = placesToVisit.getFirst();
        for (String place:
             placesToVisit) {
            System.out.println("---> From: " + previousTown + " to " + place);
            previousTown = place;
        }
        System.out.println("Trip ends at: " + placesToVisit.getLast());
    }

    public static void printItinerary3(LinkedList<String> placesToVisit) {
        System.out.println("-".repeat(20) + "ITERATOR VERSION" + "-".repeat(20) );

        System.out.println("Trip starts at: " + placesToVisit.getFirst());
        String previousTown = placesToVisit.getFirst();

        // USE OF LIST ITERATOR
        // we can pass index to listIterator from where we want to traverse the list
        ListIterator<String> iterator = placesToVisit.listIterator(1);
        while (iterator.hasNext()){
            var town = iterator.next();
            System.out.println("---> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at: " + placesToVisit.getLast());
    }

    public static void iteratorVsListIterator(LinkedList<String> placesToVisit) {
        System.out.println("-".repeat(20) + "ITERATOR VS LIST ITERATOR" + "-".repeat(20) );
        var iterator = placesToVisit.iterator();

        System.out.println("LIST BEFORE DELETION OF ELEMENT USING ITERATOR.REMOVE(): " + placesToVisit);
        // WHILE TRAVERSING USING ITERATOR, WE CAN REMOVE THE ELEMENTS FROM LIST
        while (iterator.hasNext()){
            if(iterator.next().equals("Pune")){
                // THIS CODE WILL WORK FINE WITHOUT EXCEPTION IF ELEMENT IS REMOVED FROM LIST USING ITERATOR
                // ITERATOR PROVIDES SAFE WAY TO REMOVE ELEMENT
                // ITERATOR SUPPORTS ONLY REMOVE() AND MOVES ONLY IN FORWARD DIRECTION
                iterator.remove();

                // THIS CODE WILL THROW AN EXCEPTION OF CONCURRENTMODIFICATIONEXCEPTION
                // CANNOT USE REMOVE ELEMENT ON LIST
                // placesToVisit.remove("Pune")
            }
        }
        System.out.println("LIST POST DELETION OF ELEMENT USING ITERATOR.REMOVE(): " + placesToVisit);


        System.out.println("-".repeat(200));
        // LIST ITERATOR
        // SUPPORTS BOTH FORWARD & BACKWARD
        // SUPPORTS - REMOVE, ADD & SET
        var listIterator = placesToVisit.listIterator();
        System.out.println("LIST BEFORE ADDITION OF ELEMENT USING ITERATOR.REMOVE(): " + placesToVisit);
        while (listIterator.hasNext()){
            if(listIterator.next().equals("Mumbai")) {
                listIterator.add("Pune District");
            }
        }
        System.out.println("LIST AFTER ADDITION OF ELEMENT USING ITERATOR.REMOVE(): " + placesToVisit);

        // THIS CODE WNT PRINT ANYTHING AS WE HAVE ALREADY REACHED TO LAST ELEMENT IN ABOVE CODE.
        while(listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        System.out.println("LIST TRAVERSAL USING BACKWARD FUNCTIONALITY: ");
        // SO TO TRAVERSE AGAIN WE NEED TO TRAVERSE BACKWARDS
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}
