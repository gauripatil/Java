import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {

        // WAY 1
        // LinkedList<String> placesToVisit = new LinkedList<>();

        // WAY 2
        var placesToVisit = new LinkedList<String>();

        // Add elements
        placesToVisit.add("Pune");
        placesToVisit.add(0,"Mumbai");

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

//        removeMoreElements(placesToVisit);
        gettingElements(placesToVisit);
        System.out.println(placesToVisit);
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

    
}
