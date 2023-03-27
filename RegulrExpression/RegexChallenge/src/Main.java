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
        String regexChallenge3 = "I want a \\w+.";
        Pattern pattern = Pattern.compile(regexChallenge3);
        Matcher matcher = pattern.matcher(challenge2str1);
        System.out.println( "challenge2str1 : " + challenge2str1 + " : " + matcher.matches());

        matcher = pattern.matcher(challenge2str2);
        System.out.println("challenge2str2 : " + challenge2str2 + " : " + matcher.matches());

    }
}