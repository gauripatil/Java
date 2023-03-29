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

        // CHALLENGE 8 :
        // Modify the regex in Challenge 7 to use a group. so that we can print all the digits that occur
        // in a string that contains multiple occurrences of the pattern.
        String challenge8 = "abcd.135uvqz.7tzik.999";
        Pattern challenge8pattern1 = Pattern.compile("([A-Za-z]+)\\.(\\d+)");
        // () - for grouping - first () used for grouping characters & second () used for grouping numbers
        Matcher challenge8matcher1 = challenge8pattern1.matcher(challenge8);

        while (challenge8matcher1.find()) {
            System.out.println("Occurrence : " + challenge8matcher1.group());
            System.out.println("Occurrence : " + challenge8matcher1.group(1));
            System.out.println("Occurrence : " + challenge8matcher1.group(2));

            // OUTPUT :
            // Occurrence : abcd.135
            //Occurrence : abcd
            //Occurrence : 135
            //Occurrence : uvqz.7
            //Occurrence : uvqz
            //Occurrence : 7
            //Occurrence : tzik.999
            //Occurrence : tzik
            //Occurrence : 999

        }


        // CHALLENGE 9 :
        // Match a pattern used in challenge 7 & 8 from a file.
        // Tabs are used to separate the matches with one exception.
        // The last match is followed by newline.
        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern challenge9pattern1 = Pattern.compile("([A-Za-z]+)\\.(\\d+)");
        // () - for grouping - first () used for grouping characters & second () used for grouping numbers
        Matcher challenge9matcher1 = challenge9pattern1.matcher(challenge8);

        while (challenge9matcher1.find()) {
            System.out.println("Occurrence : " + challenge9matcher1.group());
            System.out.println("Occurrence : " + challenge9matcher1.group(1));
            System.out.println("Occurrence : " + challenge9matcher1.group(2));

            // OUTPUT :
            // Occurrence : abcd.135
            //Occurrence : abcd
            //Occurrence : 135
            //Occurrence : uvqz.7
            //Occurrence : uvqz
            //Occurrence : 7
            //Occurrence : tzik.999
            //Occurrence : tzik
            //Occurrence : 999

        }


        // CHALLENGE 10 :
        // Instead of printing out the number, print their start & end indices.
        // Make indices inclusive
        String challenge10 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern challenge10pattern1 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        // () - for grouping - first () used for grouping characters & second () used for grouping numbers
        Matcher challenge10matcher1 = challenge10pattern1.matcher(challenge10);

        while (challenge10matcher1.find()) {

            System.out.println("Occurrence: start = " + challenge10matcher1.start(1) + " end = " + (challenge10matcher1.end(1) -1));
//            System.out.println("Occurrence : " + challenge10matcher1.group());
//            System.out.println("Occurrence : " + challenge10matcher1.group(1));
//            System.out.println("Occurrence : " + challenge10matcher1.group(2));

            // OUTPUT :
            // Occurrence: start = 5 end = 7
            //Occurrence: start = 14 end = 14
            //Occurrence: start = 21 end = 23

        }




    }
}