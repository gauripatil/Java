import java.util.LinkedList;

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
}
