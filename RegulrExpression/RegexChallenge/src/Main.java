import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // CHALLENGE 1 :
        String challenge1 = "I want a bike.";
        // String regexChallenge1 = "^I{1}[ ]{1}want[ ]{1}a[ ]{1}bike.$";
        System.out.println("Challenge1 : " + challenge1 + " : " + challenge1.matches("I want a bike."));

        // CHALLENGE 2 :
        String challenge2str1 = "I want a bike.";
        String challenge2str2 = "I want a ball.";
        System.out.println(challenge2str1.matches("I want a bike."));
        String regexChallenge2 = "I want a \\w+.";
        System.out.println(challenge2str1.matches(regexChallenge2));
        System.out.println(challenge2str2.matches(regexChallenge2));
        String regexChallenge21 = "I want a (bike|ball).";
        System.out.println("challenge2str1 : " + challenge2str1 + " : " +  challenge2str1.matches(regexChallenge21));
        System.out.println("challenge2str2 : " + challenge2str2 + " : " +  challenge2str2.matches(regexChallenge21));

        // CHALLENGE 3 :
        String regexChallenge22 = "I want a \\w+.";
        Pattern pattern = Pattern.compile(regexChallenge22);
        Matcher matcher = pattern.matcher(challenge2str1);
        System.out.println( "challenge2str1 : " + challenge2str1 + " : " + matcher.matches());

        matcher = pattern.matcher(challenge2str2);
        System.out.println("challenge2str2 : " + challenge2str2 + " : " + matcher.matches());

        // CHALLENGE 4 :
        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4 + " : Replace all spaces with _  : " + challenge4.replaceAll(" ", "_"));
        System.out.println(challenge4 + " : Replace all spaces with _  : " + challenge4.replaceAll("\\s", "_"));

        // CHALLENGE 5 :
        // MATCH FOLLOWING STRING IN ENTIRETY.
        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("[abcdefg]+"));
        // O/P - true - General regex for a to g one or more occurrence
        System.out.println(challenge5.matches("[a-g]+"));
        // O/P - true -  General regex for a to g one or more occurrence

        // CHALLENGE 6 : EXACT ENTIRETY OF STRING IN CHALLENGE 5
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));
        // O/P - true - Specific to "aaabccccccccdddefffg" string
        System.out.println(challenge5.replaceAll("^a{3}bc{8}d{3}ef{3}g$", "REPLACED"));
        // O/P REPLACED

        // CHALLENGE 7 :
        String challenge7 = "abcd.135";
        System.out.println(challenge7.matches("^[A-z][a-z]+\\.\\d+$"));

    }
}