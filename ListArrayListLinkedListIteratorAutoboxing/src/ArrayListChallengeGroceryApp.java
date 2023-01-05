import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ArrayListChallengeGroceryApp {
    public static void main(String[] args) {

        System.out.println("-".repeat(30));
        System.out.println("------ GROCERY APP -------");
        System.out.println("-".repeat(30));

        ArrayList<String> groceryList = new ArrayList<>();
        var answer = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            printActions();
            switch (Integer.parseInt(answer.nextLine())) {
                case 1 -> addItem(groceryList);
                case 2 -> removeItem(groceryList);
                default -> flag = false;
            }
        }
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
        groceryList.addAll(List.of(item));
        printList(groceryList);
    }

    public static void removeItem(ArrayList<String> groceryList) {
        System.out.print("Remove Item : ");
        Scanner input = new Scanner(System.in);
        String[] item = input.nextLine().split(",");
        groceryList.removeAll(List.of(item));
        printList(groceryList);
    }

    public static void printList(ArrayList<String> groceryList) {
        groceryList.sort(Comparator.naturalOrder());
        System.out.println("=".repeat(60));
        System.out.println("Grocery List : " + groceryList);
        System.out.println("=".repeat(60));
    }
}

