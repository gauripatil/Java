public class Main {
    public static void main(String[] args) {

        System.out.println("Digit Sum Challenge!");
        sumDigits(1212);
        sumDigits(1234);
        sumDigits(-1234);
    }

    public static void sumDigits(int number) {
        if(number < 0) {
            System.out.printf("\nInvalid number %d.. enter positive number", number);
            return;
        }
        int sum = 0;
        int updatedNumber = number;

        while (number > 0) {
            int lastDigit = number % 10;
            sum += lastDigit;
            number = number / 10;
        }
        System.out.printf("\nNumber given is : %d and Sum is %d", updatedNumber, sum);
    }
}