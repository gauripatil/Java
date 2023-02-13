public class DogMain {
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");


        // WHEN BASE & SUB CLASS BITH PROVIDES THE IMPLEMENTATION OF EQUALS
        // SYMMETRY IS NOT ACHIEVED
        System.out.println(rover2.equals(rover)); // true
        System.out.println(rover.equals(rover2)); // false

        // TO FIX THIS, COMMENT OUT THE EQUALS OVERRIDE IN SUB CLASS
        // MAKE BASE CLASS EQUALS IMPLEMENTATION - FINAL
        System.out.println(rover2.equals(rover)); // true
        System.out.println(rover.equals(rover2)); // true

    }
}
