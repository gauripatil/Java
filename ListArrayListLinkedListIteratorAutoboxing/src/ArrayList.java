
import java.util.Arrays;

record GroceryItem(String name, String type, int count) {

public GroceryItem(String name) {
        this(name, "DAIRY", 1);
        }
        }

public class ArrayList {

    public static void main(String[] args) {

        GroceryItem[] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apples", "PRODUCE", 6);
        groceryArray[2] = new GroceryItem("oranges", "PRODUCE", 5);
        System.out.println(Arrays.toString(groceryArray));

        java.util.ArrayList objectList = new java.util.ArrayList();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yogurt");

        java.util.ArrayList<GroceryItem> groceryList = new java.util.ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
    }
}
