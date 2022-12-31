import java.util.Arrays;

public class ArrayBinarySearchAndEqualityOperations {
    public static void main(String[] args) {
        String[] sArray = {"Able", "Mark", "Gauri", "Pranav", "Abhigya"};
        Arrays.sort(sArray);
        if(Arrays.binarySearch(sArray, "Gauri") >= 0) {
            System.out.println("Entry found..");
        }

        int[] array1 = {1,2,3,4,5};
        int[] array2 = {1,2,3,4,5};
        if(Arrays.equals(array1, array2)) {
            System.out.println("Arrays are equal..");
        }
    }
}
