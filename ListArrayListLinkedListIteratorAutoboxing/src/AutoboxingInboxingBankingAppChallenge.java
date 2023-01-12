import java.util.ArrayList;

record Customer(String name, ArrayList<Double> transactions) {
    Customer(String name, double initialDeposit) {

        this(name.toUpperCase(), new ArrayList<>(500));
        transactions.add(initialDeposit);
    }
}

class Bank {
    String name;
    ArrayList<Customer> customers = new ArrayList<>(5000);

    public Bank(String name) {
        this.name = name;
    }

    @Override
    public  String toString() {
        return  "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }

    private Customer getCustomer(String customerName) {
        for(var customer : customers) {
            if(customer.name().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }
        System.out.printf("Customer %s not found", customerName);
        return null;
    }

    public void addCustomer(String customerName, double initalDeposit) {
        if(getCustomer(customerName) == null) {
            Customer newCustomer = new Customer(customerName, initalDeposit);
            customers.add(newCustomer);
            System.out.println("New customer added: " + newCustomer);

        }
    }

    public void addTransaction(String name, double transactionAmount) {
        Customer customer = getCustomer(name);
        if(customer != null ) {
            customer.transactions().add(transactionAmount);
        }
    }

    public void printStatement(String customerName) {
        Customer customer = getCustomer(customerName);
        if(customer == null) {
            return;
        }

        System.out.println("-".repeat(30));
        System.out.println("Customer name: " + customer.name());
        System.out.println("Transactions: ");
        for (double d : customer.transactions()) {
            System.out.printf("$%10.2f (%s)%n", d, d < 0 ? "debit" : "credit");
        }
    }
}

public class AutoboxingInboxingBankingAppChallenge {
    public static void main(String[] args) {
        Customer bob = new Customer("Bob S", 1000.0);
        System.out.println(bob);

        Bank chaseBank = new Bank("Chase");
        chaseBank.addCustomer("Jane", 2000);
        System.out.println(chaseBank);

        chaseBank.addTransaction("Jane", -20);
        chaseBank.addTransaction("Jane", 50);
        chaseBank.printStatement("Jane");

        chaseBank.addCustomer("bob s", 25);
        chaseBank.addTransaction("Bob S", 100);
        chaseBank.printStatement("Bob S");
    }
}
