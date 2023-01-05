import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ArrayListChallengeGroceryApp {
    public static void main(String[] args) {

        ArrayList<String> groceryList = new ArrayList<>();
        var answer = new Scanner(System.in);
        boolean flag = true;

        // Print header
        printHeader();

        // Run till valid input
        while (flag) {

            // Print options
            printActions();
            switch (Integer.parseInt(answer.nextLine())) {
                case 1 -> addItem(groceryList);
                case 2 -> removeItem(groceryList);
                default -> flag = false;
            }
        }
    }

    public static void printHeader() {
        int hyphen = 50;
        String msg = "-".repeat(hyphen) + " GROCERY APP " + "-".repeat(hyphen);
        System.out.println("-".repeat(msg.length()));
        System.out.println(msg);
        System.out.println("-".repeat(msg.length()));
    }

    public static void printActions() {
        String textblock = """
                    Available actions:
                    0 - to shutdown
                    1 - to add item(s) to list (comma delimited list)
                    2 - to remove any items (comma delimited list)
                    
                    Enter a number for which action you want to do:""";
        System.out.print(textblock + " ");
    }

    public static void addItem(ArrayList<String> groceryList) {
        System.out.print("Enter items to be added separated by comma: ");
        Scanner input = new Scanner(System.in);
        String[] item = input.nextLine().split(",");

        // this code was not handling space properly
        // groceryList.addAll(List.of(item));

        // Code block to add trimmed data in the grocery list &
        // to avoid duplicates in the list
        for (String i: item
             ) {
            String trimmed = i.trim();
            if(groceryList.indexOf(trimmed) < 0) {
                groceryList.add(trimmed);
            }
        }
        // After operation print grocery list
        printList(groceryList);
    }

    public static void removeItem(ArrayList<String> groceryList) {
        System.out.print("Enter items to be removed separated by comma: ");
        Scanner input = new Scanner(System.in);
        String[] item = input.nextLine().split(",");
        for (String i: item
        ) {
            String trimmed = i.trim();
            groceryList.remove(trimmed);
        }

        // After operation print grocery list
        printList(groceryList);
    }

    public static void printList(ArrayList<String> groceryList) {
        groceryList.sort(Comparator.naturalOrder());
        System.out.println("=".repeat(groceryList.size() * 10));
        System.out.println("Grocery List : " + groceryList);
        System.out.println("=".repeat(groceryList.size() * 10));
    }
}

