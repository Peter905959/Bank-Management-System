import java.util.ArrayList;
import java.util.Scanner;


public class PetersBank {
    public PetersBank() {
    }

    private static account findAcc(int accountId, ArrayList<account> accounts) {
        for(account acc : accounts) {
            if (acc.getAccountId() == accountId) {
                return acc;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<account> accounts = new ArrayList();

        for(int i = 0; i < 1; ++i) {
            System.out.println("Welcome to Peter's Bank");
            System.out.print("Enter Account ID for first account: ");
            int accountId = sc.nextInt();
            System.out.print("Enter Initial Balance for first account: ");
            int balance = sc.nextInt();
            System.out.print("Enter Name for first account: ");
            String name = sc.next();
            System.out.print("Enter Age for first account: ");
            int age = sc.nextInt();
            account acc = new account(accountId, balance, name, age);
            acc.setPin();
            accounts.add(acc);
        }

        while(true) {
            System.out.println("\n--- PetersBank Menu ---");
            System.out.println("1. Transfer Money");
            System.out.println("2. Check Balance");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Deposit Money");
            System.out.println("5. Create New Account");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Sender Account ID: ");
                    int senderID = sc.nextInt();
                    System.out.print("Enter Reciever Account ID: ");
                    int receiverID = sc.nextInt();
                    account sender = findAcc(senderID, accounts);
                    account receiver = findAcc(receiverID, accounts);
                    if (sender != null && receiver != null) {
                        transfer.makeTransfer(sender, receiver);
                        break;
                    }

                    System.out.println("Sender or Receiver not found");
                    break;
                case 2:
                    System.out.print("Enter Account number: ");
                    int accountNumber = sc.nextInt();
                    account tocheck = findAcc(accountNumber, accounts);
                    if (tocheck != null) {
                        tocheck.checkBalance();
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account number: ");
                    int accountNumber2 = sc.nextInt();
                    account towithdraw = findAcc(accountNumber2, accounts);
                    if (towithdraw != null) {
                        towithdraw.withdraw();
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account number: ");
                    int accountNumber3 = sc.nextInt();
                    account todeposit = findAcc(accountNumber3, accounts);
                    if (todeposit != null) {
                        todeposit.deposit();
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 5:
                    System.out.println("\nCreating a new account ");
                    System.out.print("Enter Account number: ");
                    int newAccountId = sc.nextInt();
                    if (findAcc(newAccountId, accounts) != null) {
                        System.out.println("Account already exists");
                    } else {
                        System.out.print("Enter Initial Balance: ");
                        int balance = sc.nextInt();
                        System.out.print("Enter Name: ");
                        String name = sc.next();
                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();
                        account newAcc = new account(newAccountId, balance, name, age);
                        newAcc.setPin();
                        accounts.add(newAcc);
                        System.out.println("New account created successfully!");
                    }
                    break;
                case 6:
                    System.out.println("Thank you for using Peter's Bank");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option please try again ");
            }
        }
    }
}