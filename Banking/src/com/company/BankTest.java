package com.company;

import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    private Bank bank;
    private static int count;


    @org.junit.jupiter.api.BeforeAll
    public static void beforeClass(){
        System.out.println("This executes before class.\n count= "+ count++);
    }
    @org.junit.jupiter.api.BeforeEach
    void setUp(){
        bank = new Bank("Prajyot", "Bhatkar", 20000,bank.CHECKING);
        System.out.println("Running Test");
    }
    @org.junit.jupiter.api.Test
    void deposit() {

        double balance =bank.deposit(2000,true);
        assertEquals(22000,balance,0);
        assertEquals(22000,bank.getBalance(),0);
    }

    @org.junit.jupiter.api.Test
    void withDrawn_Branch() {

        double balance = bank.withdraw(600.00, true);
        assertEquals(19400.00, balance, 0);
    }


    @org.junit.Test(expected = IllegalArgumentException.class)
    void withDrawn_notBranch() throws Exception{
        double balance = bank.withdraw(600.00, false);
        assertEquals(19400.00, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_Deposit() {

        bank.deposit(2000,true);
        assertEquals(22000,bank.getBalance(),0);
    }

    @org.junit.Test
    public void isChecking_true() {
        assertTrue("The account is NOT a checking account", bank.isChecking());
    }

    @org.junit.jupiter.api.AfterEach
    public void afterClass()
    {
        System.out.println("This executes after classes \ncount= "+ count++);
    }
}