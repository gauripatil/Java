import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player jay = new Player("Jay", 10, 15);
        System.out.println(jay.toString());

        jay.setHitPoints(20);
        System.out.println(jay);

        jay.setWeapon("Stormbringer");
        System.out.println(jay);

        saveObject(jay);
        loadObject(jay);

        System.out.println(jay);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int index = 0;
        boolean quit = false;
        System.out.println("Choose\n" +
                "1 to enter string\n" +
                "0 to quit");
        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter string: ");
                    String inputStr = scanner.nextLine();
                    values.add(index, inputStr);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave) {
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device.");
        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }
}