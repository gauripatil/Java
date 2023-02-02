import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, String> languages = new HashMap<>();
        if(languages.containsKey("Java")) {
            System.out.println("Java already exists");
        } else {
            languages.put("Java", "a compiled high level, object-oriented, platform independent language");
            System.out.println("Java added successfully");
        }
        languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");

        // These below statements will add BASIC & Lisp to map but will print null here.
        System.out.println(languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code"));
        System.out.println(languages.put("Lisp", "Therein lies madness"));

        if(languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "this course is about Java");
        }
        System.out.println("================================================");

        // this will remove Lisp from map
//        languages.remove("Lisp");
        // This code wont remove Algol
        if(languages.remove("Algol", "this will not work as description will not match")) {
            System.out.println("Algol is removed");
        } else {
            System.out.println("Algol not removed, key/value pair not found");
        }

        // This code will remove algol
        if(languages.remove("Algol", "an algorithmic language")) {
            System.out.println("Algol is removed because key/value pair is found");
        } else {
            System.out.println("Algol not removed, key/value pair not found");
        }

        // This wont replace the Lisp because old value will not match
        if(languages.replace("Lisp", "This wont replace the Lisp because old value will not match", "a functional programming language with imperative features")) {
            System.out.println("Lisp replaced");
        } else {
            System.out.println("Lisp was not replaced");
        }

        // This wont replace the Lisp because old value will not match
        if(languages.replace("Lisp", "Therein lies madness", "a functional programming language with imperative features")) {
            System.out.println("Lisp replaced becaucse key/value exact pair matched");
        } else {
            System.out.println("Lisp was not replaced");
        }

        System.out.println(languages.replace("Scala", "this will not be added"));
        
        for (String key:  languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
    }
}