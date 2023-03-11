import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "o71"
        );


        ////// *************** WAY 1 ******************
        // STEP 1 - CREATE NEW ARRAY FOR SORTING
        List<String> gNumbers = new ArrayList();
        // STEP 2 - ADD ELEMENTS STARTING WITH G IN ARRAY
        someBingoNumbers.forEach(number -> {
            if(number.toUpperCase().startsWith("G")){
                gNumbers.add(number);
            }
        });
        // STEP 3 - SORT ARRAY
        gNumbers.sort((String s1, String s2) ->  s1.compareTo(s2));
        // STEP 4 - PRINT SORTED ARRAY
        gNumbers.forEach(s -> System.out.println(s));

        ///// O/P
        //  G49
        //  G50
        //  G53
        //  G60
        //  g64


        ////// *************** WAY 2 - STREAMS ******************
        System.out.println("**************** USING STREAMS **************");
        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(s -> System.out.println(s));

        /// O/P
        // G49
        // G50
        // G53
        // G60
        // G64
    }
}