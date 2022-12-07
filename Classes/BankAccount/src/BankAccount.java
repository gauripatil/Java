public class BankAccount {
    String accountNumber;
    double accountBalance;
    String customerName;
    String email;
    String phoneNumber;



    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void withdrawAmount(double amount) {
        if(amount > this.accountBalance) {
            System.out.println("Insufficient balance....");
            return;
        }
        this.accountBalance = this.accountBalance - amount;
    }

    public void depositAmount(double amount) {
        this.accountBalance = this.accountBalance + amount;
    }

    public void displayDetails() {
        System.out.printf("%s\t%s\t%s\t\t\t%s\t\t\t%s",
                this.getCustomerName(), this.getEmail(),
                this.getPhoneNumber(), this.getAccountNumber(),
                this.getAccountBalance()
        );
    }
}
