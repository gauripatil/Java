import java.util.ArrayList;
import java.util.List;

public class ArrayListAllOperations {
    public static void main(String[] args) {
        // CREATE ARRAY OF STRINGS - GROCERIES ITEMS
        String[] items = {"apples", "bananas", "milk", "eggs"};
        List<String> list = List.of(items);

        // Below line will print - java.util.ImmutableCollections$ListN
        // List is of immutable type means we cannot change list later else exception will occur
        System.out.println(list.getClass().getName());
        // Below line will cause UnsupportedOperationException
        // list.add("bread");

        // ArrayList is mutable, we can change data in list at any point of time.
        // WAY 1 OF CREATE ARRAYLIST USING existing immutable list & ADD ITEMS TO ARRAYLIST
        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println("groceries : " + groceries);

        // WAY 2 OF CREATE ARRAYLIST
        ArrayList<String> nextList = new ArrayList<>(
                List.of("pickles",  "mustard", "cheese")
        );
        System.out.println("nextList : " + nextList);


        // addAll
        groceries.addAll(nextList);
        System.out.println("groceries : " + groceries);

        // get
        System.out.println("groceries[1] : " + groceries.get(1));








    }
}
