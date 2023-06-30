import java.util.ArrayList;
import java.util.Scanner;

public class ATMInterface {
    private double balance;
    private ArrayList<String> transactionHistory;

    public ATMInterface() {
        balance = 0.0;
        transactionHistory = new ArrayList<>();
    }

    public void displayMenu() {
        System.out.println("\nATM INTERFACE:");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
    }

    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transaction history available.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawal: $" + amount);
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposit: $" + amount);
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void transfer(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Transfer: $" + amount);
            System.out.println("Transfer successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid transfer amount or insufficient balance.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ATMInterface atm = new ATMInterface();
        boolean quit = false;

        System.out.println("Welcome to the ATM Interface!");

        while (!quit) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    atm.showTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = input.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = input.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter transfer amount: $");
                    double transferAmount = input.nextDouble();
                    atm.transfer(transferAmount);
                    break;
                case 5:
                    quit = true;
                    System.out.println("Thank you for using the ATM Interface. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}