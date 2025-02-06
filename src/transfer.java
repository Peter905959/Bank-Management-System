import java.io.PrintStream;
import java.util.Scanner;

public class transfer {
    public transfer() {
    }

    public static void makeTransfer(account fromAcc, account toAcc) {
        if (fromAcc.accPin()) {
            Scanner sc = new Scanner(System.in);
            PrintStream var10000 = System.out;
            int var10001 = fromAcc.getAccountId();
            var10000.print("Enter amount to be transfer from account " + var10001 + " to account " + toAcc.getAccountId() + ": ");
            int amount = sc.nextInt();
            if (amount <= fromAcc.getBalance()) {
                fromAcc.setBalance(fromAcc.getBalance() - amount);
                toAcc.setBalance(toAcc.getBalance() + amount);
                System.out.println("Transfered " + amount + "/- successfully from account " + fromAcc.getAccountId() + " to account " + toAcc.getAccountId());
            } else {
                System.out.println("Transfer failed! Insufficient balance");
            }
        } else {
            System.out.println("Incorrect PIN. Transfer Failed.");
        }

    }
}