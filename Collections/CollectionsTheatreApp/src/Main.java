import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);
        theatre.getSeats();
        if(theatre.reserveSeat("B13")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        // --------------SHALLOW COPY --------------
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        printList(seatCopy);

        // Here we are calling reservce() method on shallow copy object ie seatCOpy,
        // but it will ultimately change the original array as references are different but pointing to same object
        // Hence "Seat already taken" will be printed.
        seatCopy.get(1).reserve();
        if(theatre.reserveSeat("A02")){
            System.out.println("Please pay for A02");
        } else {
            System.out.println("Seat already taken");
        }

        // Shuffle method will only shuffle entries in seatCopy
        // Hence shuffled output will be for only seatCopy
        // theatre.copy will print as it is
        // same is for reverse()
        // Collections.reverse(seatCopy);
        Collections.shuffle(seatCopy);
        System.out.println("Printing seatCopy post Collections.shuffle()");
        printList(seatCopy);
        System.out.println("Printing Theatre.seat");
        printList(theatre.seats);

        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);

        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());

        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);

        // THIS CODE WILL THROW EXCEPTION
        // Source does not fit in dest
        // at java.base/java.util.Collections.copy(Collections.java:561)
        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
        Collections.copy(newList, theatre.seats);
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat:
             list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("===================================================================================================================================================================================================================================");

    }

    // Variation of bubble sort with nested for loop
    // Usage of Collections.swap() method
    public static void sortList(List<? extends Theatre.Seat> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for(int j=i; j< list.size(); j++) {
                if(list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}