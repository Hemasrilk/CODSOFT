import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
    }

    public void performOperation() {
        while (true) {
            displayMenu();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void checkBalance() {
        double balance = bankAccount.getBalance();
        System.out.println("Current Balance: $" + balance);
    }

    private void withdraw() {
        System.out.print("Enter the withdrawal amount: $");
        double amount = scanner.nextDouble();

        if (bankAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Current Balance: $" + bankAccount.getBalance());
        } else {
            System.out.println("Insufficient funds or invalid amount. Withdrawal failed.");
        }
    }

    private void deposit() {
        System.out.print("Enter the deposit amount: $");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            bankAccount.deposit(amount);
            System.out.println("Deposit successful. Current Balance: $" + bankAccount.getBalance());
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }
}

public class ATM_Interface {
    public static void main(String[] args) {
        // Initialize bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0);

        // Create an ATM instance and connect it with the user's bank account
        ATM atmMachine = new ATM(userAccount);

        // Perform operations using the ATM
        atmMachine.performOperation();
    }
}
