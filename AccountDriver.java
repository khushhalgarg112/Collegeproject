package BankAccount;

import java.util.Scanner;

public class AccountDriver {

    // Entry point of program

    public static void main(String[] args)

    {

        Scanner keyboard = new Scanner(System.in);

        // Create array of Accounts

        Account accounts[] = new Account[10];

        int numAccounts = 0;

        int choice;

        do

        {

            choice = menu(keyboard);

            System.out.println();

            if (choice == 1) {

                accounts[numAccounts++] = createAccount(keyboard);

            } else if (choice == 2) {

                doDeposit(accounts, numAccounts, keyboard);

            } else if (choice == 3) {

                doWithdraw(accounts, numAccounts, keyboard);

            } else if (choice == 4) {

                applyInterest(accounts, numAccounts, keyboard);

            } else if (choice == 5) {

                checkBalance(accounts, numAccounts, keyboard);

            } else {

                System.out.println("Thanks for using Shivaji Bank!");

            }

            System.out.println();

        } while (choice != 6);

    }

    // ---------------------------------------------------------------For Account
    // choice--------------------------------------------------------------------------

    public static int accountMenu(Scanner keyboard)

    {

        System.out.println(
                " _____________________________________________________________________________________________________________________________________");

        System.out.println(
                "|                                                           Select Account Type                                                       |");

        System.out.println(
                "|                                       Options                                             Type                                      |");

        System.out.println(
                "|_____________________________________________________________________________________________________________________________________|");

        System.out.println(
                "|                              Checking Account                                              1                                        |");

        System.out.println(
                "|                              Savings Account                                               2                                        |");

        System.out.println(
                "|_____________________________________________________________________________________________________________________________________|");
        System.out.println("\n");
        int choice;

        do {

            System.out.print("Enter your choice: ");

            choice = keyboard.nextInt();

        } while (choice < 1 || choice > 2);

        return choice;

    }

    public static int searchAccount(Account accounts[], int count, int accountNumber)

    {

        for (int i = 0; i < count; i++)

        {

            if (accounts[i].getAccountNumber() == accountNumber)

            {

                return i;

            }

        }

        return -1;

    }

    // ----------------------------------------------Function to perform Deposit on
    // a selected
    // account------------------------------------------------------------

    public static void doDeposit(Account accounts[], int count, Scanner keyboard)

    {

        // Get the account number

        System.out.print("\nPlease enter account number: ");

        int accountNumber = keyboard.nextInt();

        // search for account

        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0)

        {

            // Amount

            System.out.print("Please enter Deposit Amount: ");

            double amount = keyboard.nextDouble();

            accounts[index].deposit(amount);

        }

        else

        {

            System.out.println("No account exist with AccountNumber: " + accountNumber);

        }

    }

    public static void doWithdraw(Account accounts[], int count, Scanner keyboard)

    {

        // Get the account number

        System.out.print("\nPlease enter account number: ");

        int accountNumber = keyboard.nextInt();

        // search for account

        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0)

        {

            // Amount

            System.out.print("Please enter Withdraw Amount: ");

            double amount = keyboard.nextDouble();

            accounts[index].withdraw(amount);

        }

        else

        {

            System.out.println("No account exist with AccountNumber: " + accountNumber);

        }

    }

    public static void checkBalance(Account accounts[], int count, Scanner keyboard) {

        // Get the account number

        System.out.print("\nPlease enter account number: ");

        int accountNumber = keyboard.nextInt();

        // search for account

        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {

            double num = accounts[index].getBalance();

            System.out.println("Current Balance of your Account is " + num);

        } else {

            System.out.println("No account exist with AccountNumber: " + accountNumber);

        }

    }

    public static void applyInterest(Account accounts[], int count, Scanner keyboard)

    {

        // Get the account number

        System.out.print("\nPlease Enter account number: ");

        int accountNumber = keyboard.nextInt();

        // search for account

        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0)

        {

            // must be instance of savings account

            if (accounts[index] instanceof SavingsAccount)

            {

                ((SavingsAccount) accounts[index]).applyInterest();

            }

        }

        else

        {

            System.out.println("No account exist with AccountNumber: " + accountNumber);

        }

    }

    // -------------------------------------------------------------Function to
    // create a new
    // Account--------------------------------------------------------------

    public static Account createAccount(Scanner keyboard)

    {

        Account account = null;

        int choice = accountMenu(keyboard);

        int accountNumber;

        System.out.print("Enter Account Number: ");

        accountNumber = keyboard.nextInt();

        if (choice == 1)

        {

            // checking account

            System.out.print("Enter Transaction Fee: ");

            double fee = keyboard.nextDouble();

            account = new CheckingAccount(accountNumber, fee);

        }

        else

        {

            // Savings account

            System.out.print("Please enter Interest Rate: ");

            double ir = keyboard.nextDouble();

            account = new SavingsAccount(accountNumber, ir);

        }

        return account;

    }

    // ------------------------------------------------------Menu to display options
    // and get the user's selection-------------------------------------------------

    public static int menu(Scanner keyboard)

    {

        System.out.println("\n");

        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("                                                          WELCOME TO SHIVAJI BANK");

        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println();

        System.out.println();

        System.out.println(
                " _____________________________________________________________________________________________________________________________________");

        System.out.println(
                "|                                                           Bank Account Menu                                                         |");

        System.out.println(
                "|                                       Options                                             Type                                      |");

        System.out.println(
                "|_____________________________________________________________________________________________________________________________________|");

        System.out.println(
                "|                              Create New Account                                            1                                        |");

        System.out.println(
                "|                              To Deposit Amount                                             2                                        |");

        System.out.println(
                "|                              To Withdraw Amount                                            3                                        |");

        System.out.println(
                "|                              Apply Interest(Applicable For Saving Account only)            4                                        |");

        System.out.println(
                "|                              To Check Balance                                              5                                        |");

        System.out.println(
                "|                              Quit                                                          6                                        |");

        System.out.println(
                "|_____________________________________________________________________________________________________________________________________|");

        System.out.println("\n\n");

        int choice;

        do

        {

            System.out.print("Enter your choice: ");

            choice = keyboard.nextInt();

        } while (choice < 1 || choice > 6);

        return choice;

    }

}