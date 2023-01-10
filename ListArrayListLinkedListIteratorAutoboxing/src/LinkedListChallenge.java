import java.util.LinkedList;
import java.util.Scanner;

record Place(String name, int distance) {
    @Override
    public String toString() {
        return String.format("%s (%d)", name, distance);
    }
}

public class LinkedListChallenge {
    public static void main(String[] args) {
        LinkedList<Place> placesToVisit = new LinkedList<>();

        addPlaces(placesToVisit, new Place("Satara", 120));
        addPlaces(placesToVisit, new Place("Nashik", 150));
        addPlaces(placesToVisit, new Place("Delhi", 1460));
        addPlaces(placesToVisit, new Place("Mumbai", 180));
        addPlaces(placesToVisit, new Place("Banglore", 840));
        addPlaces(placesToVisit, new Place("Pune", 0));
        System.out.println(placesToVisit);


        var iterator = placesToVisit.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quitLoop = false;
        boolean forward = false;

        printMenu();
        while (!quitLoop) {

            if(!iterator.hasPrevious()){
                System.out.println("Originating: "+ iterator.next());
                forward = true;
            }

            if(!iterator.hasNext()){
                System.out.println("Final: " + iterator.previous());
                forward = false;
            }

            System.out.print("Enter value:");
            String menuItem = scanner.nextLine().toUpperCase().substring(0, 1);


            switch (menuItem) {
                case "F" :
                    System.out.println("User wants to go forward:");
                    // Reversing Direction
                    if(!forward) {
                        forward = true;
                        // Adjusting position
                        if(iterator.hasNext()) {
                            iterator.next();
                        }
                    }

                    if(iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                    break;
                case "B" :
                    System.out.println("User wants to go backwards:");
                    // Reversing direction
                    if(forward) {
                        forward = false;
                        // Adjusting position
                        if(iterator.hasPrevious()) {
                            iterator.previous();
                        }
                    }
                    if(iterator.hasPrevious()){
                        System.out.println(iterator.previous());
                    }
                    break;
                case "M" :
                    printMenu();
                    break;
                case "L" :
                    System.out.println(placesToVisit);
                    break;
                default:
                    quitLoop = true;
                break;
            }
        }


    }

    private static void addPlaces(LinkedList<Place> placesToVisit, Place place) {

        // FIND DUPLICATE
        if(placesToVisit.contains(place.name())){
            System.out.println("Found Duplicate of: " + place.name());
            return;
        }

        for (Place p:
             placesToVisit) {
            if(p.name().equalsIgnoreCase(place.name())) {
                System.out.println("Found Duplicate of: " + place.name());
                return;
            }
        }

        // ADD ELEMENT TO LIST
        int matchedIndex = 0;
        for(var listPlace : placesToVisit){
            if(place.distance() < listPlace.distance()) {
                placesToVisit.add(matchedIndex, place);
                return;
            }
            matchedIndex++;
        }
        placesToVisit.add(place);
    }

    public static void printMenu() {
        System.out.println("""
                Available actions (select word or letter):
                (F)orward
                (B)ackwards
                (L)ist Places
                (M)enu
                (Q)uit
                """);
    }
}
