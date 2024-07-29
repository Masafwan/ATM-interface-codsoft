package com.ATM;

import java.util.Scanner;


    class BankAccount {
    private double balance;


    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }


    public double getBalance() {
        return balance;
    }


    public void deposit(double amount) {
        balance += amount;
    }


    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}


class ATM {
    private BankAccount account;
    private Scanner scanner;


    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }


    public void run() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        } while (choice != 4);
    }


    private void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }


    private void checkBalance() {
        double balance = account.getBalance();
        System.out.println("Your current balance: Rs." + balance);
    }


    private void deposit() {
        System.out.print("Enter deposit amount: Rs.");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Rs." + amount + " deposited successfully.");
            checkBalance();
        } else {
            System.out.println("Invalid amount. Deposit amount must be greater than zero.");
        }
    }


    private void withdraw() {
        System.out.print("Enter withdrawal amount: Rs.");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount > 0) {
            boolean success = account.withdraw(amount);
            if (success) {
                System.out.println("Rs." + amount + " withdrawn successfully.");
            } else {
                System.out.println("Insufficient funds. Withdrawal failed.");
            }
            checkBalance();
        } else {
            System.out.println("Invalid amount. Withdrawal amount must be greater than zero.");
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        ATM atm = new ATM(account);
        atm.run();
    }
}