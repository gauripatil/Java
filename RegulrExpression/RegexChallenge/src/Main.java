import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // CHALLENGE 1 :
        String challenge1 = "I want a bike.";
//        String regexChallenge1 = "^I{1}[ ]{1}want[ ]{1}a[ ]{1}bike.$";
        System.out.println("Challenge1 : " + challenge1 + " : " + challenge1.matches("I want a bike."));

    }
}