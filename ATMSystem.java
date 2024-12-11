import java.util.Scanner;


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
        }
    }

   
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }


    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

 
    public double checkBalance() {
        return balance;
    }
}
class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.bankAccount = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu
    public void displayMenu() {
        while (true) {
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Please select an option (1-4): ");

            int option = scanner.nextInt();
            switch (option) {
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
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private void checkBalance() {
        System.out.println("Your current balance is: $" + bankAccount.checkBalance());
    }

   
    private void deposit() {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            bankAccount.deposit(amount);
            System.out.println("Deposited $" + amount + ". Your new balance is: $" + bankAccount.checkBalance());
        } else {
            System.out.println("Deposit amount must be greater than 0.");
        }
    }


    private void withdraw() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (bankAccount.withdraw(amount)) {
            System.out.println("Successfully withdrawn $" + amount + ". Your new balance is: $" + bankAccount.checkBalance());
        } else {
            System.out.println("Insufficient funds or invalid amount. Please try again.");
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
       
        BankAccount account = new BankAccount(500.00); 
        // Create an ATM with the user's bank account
        ATM atm = new ATM(account);


        atm.displayMenu();
    }
}
