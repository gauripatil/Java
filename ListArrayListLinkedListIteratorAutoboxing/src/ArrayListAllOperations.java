import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

        // contains
        if(groceries.contains("mustard")) {
            System.out.println("Groceries list contains mustard");
        }

        groceries.add("yogurt");

        // indexOf
        System.out.println("Yogurt first index : " + groceries.indexOf("yogurt"));

        // lastIndexOf
        System.out.println("Yogurt last index : " + groceries.lastIndexOf("yogurt"));

        // remove - WAY 1 - by index
        groceries.remove(4);
        System.out.println("groceries remove : " + groceries);

        // remove - WAY 2 - by name
        groceries.remove("yogurt");
        System.out.println("groceries remove : " + groceries);

        // removeAll - remove all items from list which are passed as parameters
        groceries.removeAll(List.of("apples", "eggs"));
        System.out.println("groceries removeAll : " + groceries);

        // retainAll - opposite of removeAll - removes all element except which are passed as parameter to retainAll
        groceries.retainAll(List.of("apples", "milk", "mustard", "cheese"));
        System.out.println("groceries retainAll : " + groceries);

        // clear - delete all
        groceries.clear();
        System.out.println("groceries clear : " + groceries);

        // isEmpty
        System.out.println("isEmpty groceries : " + groceries.isEmpty());

        // addAll & List.of
        groceries.addAll(List.of("apples", "milk", "mustard", "cheese"));
        System.out.println("groceries addAll(List.of) : " + groceries);

        // addAll & Arrays.asList
        groceries.addAll(Arrays.asList("eggs", "bread", "jam", "pickle"));
        System.out.println("groceries addAll(Arrays.asList) : " + groceries);

        // naturalOrder
        groceries.sort(Comparator.naturalOrder());
        System.out.println("groceries naturalOrder : " + groceries);

        // reverseOrder
        groceries.sort(Comparator.reverseOrder());
        System.out.println("groceries reverseOrder : " + groceries);

        //
        var groceryArray  = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceryArray));









    }
}
