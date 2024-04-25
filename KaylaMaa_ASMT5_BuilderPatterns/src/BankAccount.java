/*************************************************
 File: BankAccount.java
 By: Kayla Maa
 Date: 04/20/2024
 Compile: Run
 Description: Creating the BankAccount Class
 *************************************************/
import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class BankAccount {
    private int acctNum;
    private int custNum;
    protected double balance;
    private Date createDate;
    private Date lastUpdateDate;
    private String type;
    protected double odLimit;
    private double intRate;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");


    public int getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(int acctNum) {
        this.acctNum = acctNum;
    }

    public int getCustNum() {
        return custNum;
    }

    public void setCustNum(int custNum) {
        this.custNum = custNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getOdLimit() {
        return odLimit;
    }

    public void setOdLimit(double odLimit) {
        this.odLimit = odLimit;
    }

    public double getIntRate() {
        return intRate;
    }

    public void setIntRate(double intRate) {
        this.intRate = intRate;
    }

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public BankAccount(int acctNum, double initialBalance){
        this.acctNum = acctNum;
        this.balance = initialBalance;
    }

    // Method to deposit money into the bank account
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Unable to deposit.");
        }
    }

    // Method to withdraw money from the bank account
    public void withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Unable to withdraw.");
        }
    }

    public void transfer(BankAccount otherAccount, double amount) {
        if (balance - amount >= -odLimit) {
            withdraw(amount);
            otherAccount.deposit(amount);
        } else {
            System.out.println("Unable to make a transfer.");
        }
    }
    

    // Getter method to check the current balance

    @Override
    public String toString() {
        String accountString = "BankAccount{ " +
                "\nAccount Number= " + getAcctNum() + "\n" +
                "Customer Number= " + getCustNum() + "\n" +
                "Balance= " + getBalance() + "\n" +
                "Create Date= " + dateFormat.format(getCreateDate()) + "\n" +
                "Last Update Date= " + dateFormat.format(getLastUpdateDate()) + "\n" +
                "Type= " + getType() + "\n" +
                "Overdraft Limit= " + getOdLimit() + "\n" +
                "Interest Rate= " + getIntRate() + " }";
        return accountString;
    }
}

class CheckingAccount extends BankAccount {
    public CheckingAccount(int accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Unable to make a deposit");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Unable to make a withdraw.");
        }
    }
    @Override
    public void transfer(BankAccount otherAccount, double amount) {
        if (balance - amount >= -odLimit) {
            withdraw(amount);
            otherAccount.deposit(amount);
        } else {
            System.out.println("Unable to make a transfer.");
        }
    }

}

class SavingsAccount extends BankAccount {
    public SavingsAccount(int accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Unable to make a deposit.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Unable to make a withdraw.");
        }
    }

    @Override
    public void transfer(BankAccount otherAccount, double amount) {
        if (balance - amount >= -odLimit) {
            withdraw(amount);
            otherAccount.deposit(amount);
        } else {
            System.out.println("Unable to make a transfer.");
        }
    }
}
