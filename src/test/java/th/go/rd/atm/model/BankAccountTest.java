package th.go.rd.atm.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {

    @Test
    void testDepositOnce() {
        BankAccount act1 = new BankAccount();
        act1.deposit(100);
        // assertEquals(expected-value, actual-value)
        assertEquals(100, act1.getBalance());
    }

    @Test
    void testDepositTwice() {
        BankAccount act1 = new BankAccount();
        act1.deposit(100);
        act1.deposit(20);
        assertEquals(120, act1.getBalance());
    }

    @Test
    void testWithdrawOnce() {
        BankAccount act1 = new BankAccount();
        act1.deposit(100);
        act1.withdraw(5);
        assertEquals(95, act1.getBalance());
    }
}
