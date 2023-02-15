import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SymmetricAsymmetricSet {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i=1; i<=100; i++) {
            squares.add(i*i);
            cubes.add(i*i*i);
        }

        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes.");

        //  UNION
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + "  elements.");

        //  INTERSECTION
        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size() + " elements.");

        for(int i : intersection) {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
        }


        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        // Arrays.asList acts as a bridge between two collection while initializing
        // Here arrayWords is array of string and using Arrays.asList(), we are passing list of string to set
        // it will not retain the sequence & duplicate
        words.addAll(Arrays.asList(arrayWords));

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));
        printSet(nature);

        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));
        printSet(divine);

        // asymmetric difference nature - divine
        System.out.println("nature - divine:");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        // asymmetric difference divine - nature
        System.out.println("divine - nature:");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        // symmetric difference divine - nature
        System.out.println("Symmetric difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        if(nature.containsAll(divine)) {
            System.out.println("divine is subset of nature");
        }

        if(divine.containsAll(nature)) {
            System.out.println("nature is subset of divine");
        }

        if (nature.containsAll(intersectionTest)){
            System.out.println("intersectionTest is subset of nature");
        }

        if (divine.containsAll(intersectionTest)){
            System.out.println("intersectionTest is subset of divine");
        }

    }

    public static void printSet(Set<String> set) {
        for (String s : set) {
            System.out.print(s + " ");
        }
        System.out.println("\n");

    }
}
