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


        // CHALLENGE 6
        Supplier<String> iLoveJava = () -> "I Love Java ";
        // CHALLENGE 7
        String resultOfSupplier = iLoveJava.get();
        System.out.println(resultOfSupplier);
    }

    public static String everySecondCharacter(Function<String, String> func, String source) {
        return func.apply(source);
    }



}