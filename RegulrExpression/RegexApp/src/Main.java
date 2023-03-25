import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".","Y"));

        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));

        String secondString = "abcDeeeF12GhhabcDeeeiiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));

        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abcDeee"));
        System.out.println(alphanumeric.matches("abcDeeeF12Ghhiiiijkl99z"));

        System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));

        String hasWhitespace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhitespace);

        // Input: I have blanks and	a tab, and also a newline
        // Output: Ihaveblanksandatab,andalsoanewline
        System.out.println(hasWhitespace.replaceAll("\\s", ""));

        // Output: I have blanks andXa tab, and also a newline
        System.out.println(hasWhitespace.replaceAll("\t", "X"));

        // Output: (Empty line)
        System.out.println(hasWhitespace.replaceAll("\\S", ""));

        // Output: XXXXXXXXXXXXXXXXXXXXXXX
        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));

        // Output: XIX XhaveX XblanksX XandX	XaX XtabX, XandX XalsoX XaX XnewlineX
        System.out.println(hasWhitespace.replaceAll("\\w", "X"));

        // Output: XIX XhaveX XblanksX XandX	XaX XtabX, XandX XalsoX XaX XnewlineX
        System.out.println(hasWhitespace.replaceAll("\\b", "X"));


        String thirdAlphanumericString = "abcDeeeeeeF12Ghhiiiijkl99z";

        // OUTPUT: YYYeeeF12Ghhiiiijkl99z
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{3}", "YYY"));

        // OUTPUT: YYYF12Ghhiiiijkl99z
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe+", "YYY"));

        // OUTPUT: YYYF12Ghhiiiijkl99z
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe*", "YYY"));

        // OUTPUT: YYYeF12Ghhiiiijkl99z
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{2,5}", "YYY"));

        // OUTPUT: abcDeeeeeeF12GYkl99z
        System.out.println(thirdAlphanumericString.replaceAll("h+i*j", "Y"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = ".*<h2>.*";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        // OUTPUT: true
        System.out.println(matcher.matches());


        matcher.reset();
        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());

        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while(groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPatten = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPatten.matcher(htmlText);

        while(h2TextMatcher.find()) {
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }

        // AND
        // "abc" "a" and "b" and "c"
        // [[Hh]arry

        // OR
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));

        // NOT
        // [^abc]
        String tvTest = "tstvtkt";
//        String tNotVRegExp = "t[^v]";

        // Negative look ahead
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }


    }
}