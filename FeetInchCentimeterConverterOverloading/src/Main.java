public class Main {
    public static void main(String[] args) {
        System.out.println("\nExample 1");
        convertFeetInchesToCentimeters(5, 2);

        System.out.println("\nExample 2");
        convertFeetInchesToCentimeters(0, 2);

        System.out.println("\nExample 3");
        convertFeetInchesToCentimeters(0, 0);

        System.out.println("\nExample 4");
        convertFeetInchesToCentimeters(-1, 0);

        System.out.println("\nExample 5");
        convertFeetInchesToCentimeters(0, -1);

        System.out.println("\nExample 6");
        convertFeetInchesToCentimeters(100);

        System.out.println("\nExample 7");
        convertFeetInchesToCentimeters(1);

        System.out.println("\nExample 8");
        convertFeetInchesToCentimeters(0);
        
        System.out.println("\nExample 9");
        convertFeetInchesToCentimeters(-1);
    }

    public static double convertFeetInchesToCentimeters(double feet, double inches) {

        if(feet < 0 || inches < 0 || inches > 12) {
            System.out.println("Invalid feet or inches");
            return -1;
        }

        double centimeters = (feet * 12) * 2.54;
        centimeters += inches * 2.54;
        System.out.printf("feet %s, inches %s = %s centimeters", feet, inches, centimeters);
        return centimeters;
    }

    public static double convertFeetInchesToCentimeters(double inches) {

        if(inches < 0) {
            System.out.println("Invalid inches");
            return -1;
        }

        double feet = (inches / 12);
        double remainingInches = (inches % 12);
        double centimeters = convertFeetInchesToCentimeters(feet, remainingInches);
        System.out.printf("\ninches %s = %s centimeters", inches, centimeters);
        return centimeters;
    }
}