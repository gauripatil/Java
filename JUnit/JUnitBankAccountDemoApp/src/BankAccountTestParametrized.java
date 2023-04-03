import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountTestParametrized {
    private BankAccount account;
    private double amount;

    public BankAccountTestParametrized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    private boolean branch;
    private double expected;

    @org.junit.Before
    public void setup() {
        account = new BankAccount("Gauri", "Patil", 1000.00, BankAccount.SAVINGS);
        System.out.println("Running test...");
    }

    @Parameterized.Parameters
    public static Collection <Object []> testConditions() {
        return Arrays.asList(new Object[][] {
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.25, true, 1325.25},
                {489.33, true, 1489.33},
                {1000.00, true, 2000.00}
        });
    }


    @org.junit.Test
    public void getBalance_deposit() {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), 0);
    }

}
