
import java.util.Arrays;
import java.util.ArrayList;
record GroceryItem(String name, String type, int count) {

public GroceryItem(String name) {
    this(name, "DAIRY", 1);
    }

    @Override
    public String toString(){
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }
}


public class ArrayListDemo {

    public static void main(String[] args) {

        // ARRAY
        GroceryItem[] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apples", "PRODUCE", 6);
        groceryArray[2] = new GroceryItem("oranges", "PRODUCE", 5);
        System.out.println(Arrays.toString(groceryArray));

        // PLAIN ARRAY LIST
        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yogurt");

        // GROCERY TYPE ARRAY LIST
        // THIS MAKES SURE THAT EVERY ITEM IS OF TYPE GROCERY
        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
        groceryList.add(new GroceryItem("Milk"));
        groceryList.add(new GroceryItem("Bread", "PRODUCE", 4));
        groceryList.set(1, new GroceryItem("cheese", "produce", 3));
        System.out.println(groceryList.toString());

        // REMOVE ITEM FROM GROCERY ARRAY LIST
        groceryList.remove(0);
        System.out.println(groceryList.toString());
    }
}
