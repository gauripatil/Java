import java.util.function.Function;

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
                if(i%2 == 0) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };
    }


}