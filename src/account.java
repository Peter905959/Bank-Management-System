import java.util.*;
abstract class details {
    details() {
    }

    abstract int setPin();

    abstract boolean accPin();

    abstract void deposit();

    abstract void withdraw();
}



public class account extends details {
    int accountId;
    int balance;
    String name;
    int age;
    int pin;

    public account(int accountId, int balance, String name, int age) {
        this.accountId = accountId;
        this.balance = balance;
        this.name = name;
        this.age = age;
    }

    public int setPin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Set the 4 dits Pin: ");
        this.pin = sc.nextInt();
        System.out.println("Successful:)");
        return this.pin;
    }

    public boolean accPin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the 4 digit pin: ");
        int pass = sc.nextInt();
        return pass == this.pin;
    }

    public int getBalance() {
        return this.balance;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public void setBalance(int newBalance) {
        this.balance = newBalance;
    }

    public void checkBalance() {
        if (this.pin == 0) {
            System.out.println("First set your pin to access your bank accout");
            this.setPin();
        }

        System.out.print("To check balance ");
        if (this.accPin()) {
            System.out.println("Your current balance is: " + this.balance + "/-");
        } else {
            System.out.println("Password is incorrect");
        }

    }

    public void deposit() {
        if (this.pin == 0) {
            System.out.println("First set your pin to access your bank accout");
            this.setPin();
        }

        System.out.print("To deposit into your account ");
        if (this.accPin()) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the amount to deposit: ");
            int amount = sc.nextInt();
            this.balance += amount;
            System.out.println("Successful:) Deposited " + amount + "/- to your account" + this.accountId);
        } else {
            System.out.println("You enterd wrong password Try again");
        }

    }

    public void withdraw() {
        if (this.pin == 0) {
            System.out.println("First set your pin to access your bank accout");
            this.setPin();
        }

        System.out.print("To withdraw from your account ");
        if (!this.accPin()) {
            System.out.println("You enterd wrong password Try again");
        } else {
            while(true) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the amount to withdraw: ");
                int amount = sc.nextInt();
                if (this.balance >= amount) {
                    this.balance -= amount;
                    System.out.println("Successful:) Withdrawed " + amount + "/- from your account " + this.accountId);
                    break;
                }

                System.out.println("Fail:( Insufficient balance");
            }
        }

    }
}