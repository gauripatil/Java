public class Main {
    public static void main(String[] args) {

        System.out.println("Constructor Challenge..");
        System.out.println("----CUSTOMER 1 ----");
        Customer customer = new Customer("Gauri", 2000, "gauri.patil@gmail.com");
        System.out.println(customer.getName());
        System.out.println(customer.getCreditLimit());
        System.out.println(customer.getEmail());

        System.out.println("----CUSTOMER 2 ----");
        Customer customer1 =  new Customer("Pranav", "pranav.kumar@gmail.com");
        System.out.println(customer1.getName());
        System.out.println(customer1.getCreditLimit());
        System.out.println(customer1.getEmail());

        System.out.println("----CUSTOMER 3 ----");
        Customer customer2 =  new Customer();
        System.out.println(customer2.getName());
        System.out.println(customer2.getCreditLimit());
        System.out.println(customer2.getEmail());


    }
}