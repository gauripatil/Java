import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class ArraysChallenge {
    public static void main(String[] args) {
        int[] myArray = getRamdomIntegerArray(10);
        System.out.println(Arrays.toString(myArray));
        for (int i = 0; i < 10; i++) {
            myArray[i] = myArray[i] * -1;
        }
        System.out.println(Arrays.toString(myArray));
        Arrays.sort(myArray);
        for (int i = 0; i < 10; i++) {
            myArray[i] = myArray[i] * -1;
        }
        System.out.println(Arrays.toString(myArray));

    }

    public static int[] getRamdomIntegerArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}
