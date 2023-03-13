import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
                .forEach(System.out::println);

        /// O/P
        // G49
        // G50
        // G53
        // G60
        // G64


        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("-----------------------");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());


        ///// ******************* FLAT MAP **************************

        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);


        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        // departments is a list of hr & accounting department
        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        // FlatMap is used when list is not  source but it`s content is a source.
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        System.out.println("---------------");

        //////////////// ****************  COLLECT ********************
        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for(String s : sortedGNumbers) {
            System.out.println(s);
        }
    }
}