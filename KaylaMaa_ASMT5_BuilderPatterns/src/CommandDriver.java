/*************************************************
 File: CommandDriver.java
 By: Kayla Maa
 Date: 04/20/2024
 Compile: Run
 Description: Testing the Command classes
 *************************************************/
public class CommandDriver {
    public static void main(String[] args) {
        // Create account objects
        BankAccount checkingAccount = new CheckingAccount(41103, 10.0);
        BankAccount savingsAccount = new SavingsAccount(112198, 100.0);
        System.out.println("Checking account number " + checkingAccount.getAcctNum() + " initial balance: " + checkingAccount.getBalance());
        System.out.println("Savings account number " + savingsAccount.getAcctNum() + " initial balance: " + savingsAccount.getBalance());
        // Create command objects
        BankAccountTransaction.TransactionInterface depositToChecking =
                new BankAccountTransaction.DepositCommand(checkingAccount, 200.0);

        BankAccountTransaction.TransactionInterface withdrawFromSavings =
                new BankAccountTransaction.WithdrawCommand(savingsAccount, 10.0);

        depositToChecking.execute();
        withdrawFromSavings.execute();

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Deposited to Checking account number " + checkingAccount.getAcctNum() + " balance: " + checkingAccount.getBalance());
        System.out.println("Withdrew from Savings account number " + savingsAccount.getAcctNum() + " balance: " + savingsAccount.getBalance());
        System.out.println("--------------------------------------------------------------------------");

        BankAccountTransaction.TransactionInterface checkingToSaving =
                new BankAccountTransaction.TransferCommand(checkingAccount, savingsAccount, 100.0);

        checkingToSaving.execute();
        System.out.println("Transfer $100 from checking to savings.. Checking now has: " + checkingAccount.getBalance());
        System.out.println("Transfer $100 from checking to savings.. Savings now has: " + savingsAccount.getBalance());
    }
}

