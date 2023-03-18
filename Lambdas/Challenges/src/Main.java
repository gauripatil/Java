import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // CHALLENGE 1
        Runnable runnable = () -> {
           String myString = "Lets split this up into array";
           String arr[] = myString.split(" ");
           for(String str: arr) {
               System.out.println(str);
           }
        };
        runnable.run();

        // CHALLENGE 2
        Function<String, String > EverySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i=0; i<source.length(); i++) {
                if(i%2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        // CHALLENGE 3
        String resultOfEverySecondChar = EverySecondChar.apply("1234567890");
        System.out.println("=============== resultOfEverySecondChar - 1 - Direct use of Lambda =================");
        System.out.println(resultOfEverySecondChar);

        // CHALLENGE 4
        System.out.println("=============== resultOfEverySecondChar - 2 - Using of Lambda as parameter =================");
        String resultOfEverySecondChar2 = everySecondCharacter(EverySecondChar, "1234567890");
        // CHALLENGE 5
        System.out.println(resultOfEverySecondChar2);

2
        // CHALLENGE 6
        Supplier<String> iLoveJava = () -> "I Love Java ";
        // CHALLENGE 7
        String resultOfSupplier = iLoveJava.get();
        System.out.println(resultOfSupplier);

        // CHALLENGE 8.1
        // There are many interfaces in the Java SDK, and sometimes we can use lambda expressions instead of
        // creating an instance that implements the interface we want to use.
        // Given a specific interface, how can we tell whether we can map a lambda expression to it?
        // What`s the criteria that has to be met?
        // ANSWER:
        // The interface has to be a functional interface. It can have only a single method that must be implemented.
        // Functional interface can contain more than one method, but all the methods but one must have default
        // implementations.
        // Most of the time the documentation for an interface will state whether it`s a functional interface.


        // CHALLENGE 8.2
        // Can we use lambda expression o represent an instance f the java.util.concurrent.Callable interface?
        // ANSWER: The Callable interface has only one method that has to be implemented - the call() method
        // so we cna use lambda for it. The documentation also states hat it`s a functional interface.

        // CHALLENGE 8.3
        // Is the java.util.Comparator interface a functional interface?
        // ANSWER: Yes it is. Despite containing over 10 methods, only one method has to be implemented - compare().
        // Because of that it is functional interface.

        // CHALLENGE 9
        


    }

    public static String everySecondCharacter(Function<String, String> func, String source) {
        return func.apply(source);
    }



}