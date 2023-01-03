import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayVsArrayList {
    public static void main(String[] args) {

        // Create Array
        String[] originalArray = new String[] {"First", "Second", "Third"};

        // Create Array list
        var originalList = Arrays.asList(originalArray);

        // Changes in list will affect original array contents
        originalList.set(0, "one");
        System.out.println("list: " + originalList);
        System.out.println("array: " + Arrays.toString(originalArray));

        // Sort on list will affect the original array as well
        originalList.sort(Comparator.naturalOrder());
        System.out.println("original array after sort operation on list : " + Arrays.toString(originalArray));

        // This will throw runtime exception as addition to list made of array using asList is not possible
//        originalList.add("fourth");

        List<String> newList = Arrays.asList("Sunday", "Monday", "Tuesday");
        System.out.println(newList);
    }
}
