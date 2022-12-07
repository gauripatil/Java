public class Main {
    public static void main(String[] args) {

        System.out.println("Bank Account App");
        System.out.println("NAME\t\t\tEMAIL\t\t\t\t\t\tPHONE NUMBER\t\tACCOUNT NUMBER\t\tAMOUNT");
        BankAccount bankAccount1 = new BankAccount();

        bankAccount1.setAccountNumber("SBIN003432");
        bankAccount1.setAccountBalance(1212121.76);
        bankAccount1.setCustomerName("Deepak Ahuja");
        bankAccount1.setEmail("deepak.ahuja@tekniqi.com");
        bankAccount1.setPhoneNumber("9988776655");

        bankAccount1.displayDetails();
        System.out.println("\nWithdraw Some Amount");
        bankAccount1.withdrawAmount(132123);
        bankAccount1.displayDetails();

        System.out.println("\nDeposit Some Amount");
        bankAccount1.withdrawAmount(454545);
        bankAccount1.displayDetails();
    }
}