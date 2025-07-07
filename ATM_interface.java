// Task 3

import java.util.Scanner;
// This is ATM programe for doing withdrawing , deposits ,check balance
class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {

        this.balance = initialBalance; //  Storing the initial balance in your account for further operations
    }

    // Withdrawn operation
    public boolean withdraw(double amount) {

        if (amount > 0 && amount <= balance) {

            balance -= amount;

            return true;
        }

        return false;
    }

    // Deposit operation
    public void deposit(double amount) {

        if (amount > 0) {

            balance += amount;

        }
    }

    public double getBalance() {

        return balance;

    }
}

class ATM {
    private BankAccount account;

    private Scanner scanner;

    public ATM(BankAccount account) {

        this.account = account;
        this.scanner = new Scanner(System.in);

    }

    public void start() {
        while (true) {

            System.out.println("\nWelcome to the ATM "); //Asking the user what do you want to do in your account

            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Choose an option (1-4) : ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    handleWithdraw();
                    break;
                case 2:

                    handleDeposit();
                    break;
                case 3:

                    handleCheckBalance();
                    break;
                case 4:

                    System.out.println("Thank you");
                    return;
                default:

                    System.out.println("Invalid option. Please choose (1-4)");

            }
        }
    }

    private void handleWithdraw() { // Handling the withdrawen

        System.out.print("Enter amount to withdraw: ");

        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {

            System.out.println("Withdrawal successful. Remaining balance: Rs. " + account.getBalance());

        } else {

            System.out.println("Withdrawal failed");

        }
    }

    private void handleDeposit() { // Handling the Deposits

        System.out.print("Enter amount to deposit: ");

        double amount = scanner.nextDouble();

        account.deposit(amount);

        System.out.println("Deposit successful. New balance: Rs. " + account.getBalance());

    }

    private void handleCheckBalance() { // Handling the Balance Checker

        System.out.println("Current balance: Rs." + account.getBalance());

    }
}

public class ATM_interface {
    public static void main(String[] args) {

        BankAccount userAccount = new BankAccount(5000); // initial balance
        ATM atm = new ATM(userAccount);
        atm.start();

    }
}