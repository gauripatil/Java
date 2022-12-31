import java.util.Arrays;

public class ArraysTwoDimensions {
    public static void main(String[] args) {

        int[][] array2 = new int[4][4];
        System.out.println(Arrays.toString(array2));
        System.out.println("array2.length = " + array2.length);

        // Way 1
        System.out.println("=".repeat(5) + "WAY 1 - SINGLE FOR LOOP & ARRAYS.TOSTRING OVER EACH ROW" + "=".repeat(5));
        for (int[] outer : array2) {
            System.out.println(Arrays.toString(outer));
        }

        // Way 2
        System.out.println("=".repeat(5) + "WAY 2 - TRADITIONAL FOR LOOP" + "=".repeat(5));
        for (int i = 0; i < array2.length; i++) {
            var innerArray = array2[i];
            for (int j = 0; j < innerArray.length; j++) {
                System.out.print(array2[i][j] + " ");
//                array2[i][j] = (i * 10) + (j + 1);
            }
            System.out.println();
        }

        // Way 3
        System.out.println("=".repeat(10) + "WAY 3 - FOR(ITERATOR : ARRAY) NESTED FOR" + "=".repeat(10));
        for (var outer : array2) {
            for (var element : outer) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        // Way 4
        System.out.println("=".repeat(10) + "WAY 4 - ARRAYS.DEEPTOSTRING" + "=".repeat(10));
        System.out.println(Arrays.deepToString(array2));
    }
}
