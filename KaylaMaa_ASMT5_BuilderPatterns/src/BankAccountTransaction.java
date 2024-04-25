/*************************************************
 File: BankAccountTransaction.java
 By: Kayla Maa
 Date: 04/20/2024
 Compile: Run
 Description: Creating the BankAccountTransaction Class
 *************************************************/
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class BankAccountTransaction {

    // Implemented all variables that will be needed in
    // the table
    private List<TransactionInterface> transactionTracker = new ArrayList<>();
    private int refID;
    private int acctId;
    private double amount;
    private String tranType;
    private String description;
    private String status;
    private Date dateAndTime;
    private BankAccount account;

    public BankAccountTransaction() {
        // Default constructor
    }

    public BankAccountTransaction(int refID, int acctId, double amount, String tranType, String description, String status, Date dateAndTime, BankAccount account) {
        this.refID = refID;
        this.acctId = acctId;
        this.amount = amount;
        this.tranType = tranType;
        this.description = description;
        this.status = status;
        this.dateAndTime = dateAndTime;
        this.account = account;
    }

    public void executeTransaction(TransactionInterface transaction) {
        transaction.execute();
        transactionTracker.add(transaction);
        updateStatus("Success");
    }

    private void updateStatus(String newStatus) {
        this.status = newStatus;
    }


    // Getter and Setter methods
    public int getRefID() {
        return refID;
    }

    public void setRefID(int refID) {
        this.refID = refID;
    }

    public int getAcctId() {
        return acctId;
    }

    public void setAcctId(int acctId) {
        this.acctId = acctId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "\n Ref ID=" + refID +
                "\n Account Id=" + acctId +
                "\n Amount=" + amount +
                "\n Transaction Type='" + tranType + '\'' +
                "\n Status='" + status + '\'' +
                "\n Date and Time=" + dateAndTime +
                '}';
    }

    // Interface for our BankAccountTransaction
    // in which we will use the method called execute()
    public interface TransactionInterface {
        void execute();
    }

    // Creating the Concrete Command that will deposit money into Account
    public static class DepositCommand implements TransactionInterface {
        private BankAccount account;
        private double amount;

        public DepositCommand(BankAccount account, double amount) {
            this.account = account;
            this.amount = amount;
        }

        // Using execute() to preform the deposit method
        @Override
        public void execute() {
            account.deposit(amount);
        }
    }

    // Creating the Concrete Command that will withdraw money from Account
    public static class WithdrawCommand implements TransactionInterface {
        private BankAccount account;
        private double amount;

        public WithdrawCommand(BankAccount account, double amount) {
            this.account = account;
            this.amount = amount;
        }

        // Using execute() to preform the withdraw method
        @Override
        public void execute() {
            account.withdraw(amount);
        }
    }

    public static class TransferCommand implements TransactionInterface {
        private BankAccount account;
        private BankAccount otherAccount;
        private double amount;

        public TransferCommand(BankAccount account, BankAccount otherAccount, double amount) {
            this.account = account;
            this.otherAccount = otherAccount;
            this.amount = amount;
        }

        // Using execute() to preform the withdraw method
        @Override
        public void execute() {
            account.transfer(otherAccount, amount);
        }
    }

}