package co.edu.uptc.model;
import co.edu.uptc.enums.AccountStatus;
import co.edu.uptc.enums.AccountType;
import java.util.Date;

public class Account extends BaseClass {
    private String accountNumber;
    private AccountType accountType;
    private double balance;
    private Date openingDate;
    private AccountStatus status;
    public Account(String accountNumber, AccountType accountType, double balance,
                   Date openingDate, AccountStatus status) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.openingDate = openingDate;
        this.status = status;
    }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public AccountType getAccountType() { return accountType; }
    public void setAccountType(AccountType accountType) { this.accountType = accountType; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public Date getOpeningDate() { return openingDate; }
    public void setOpeningDate(Date openingDate) { this.openingDate = openingDate; }
    public AccountStatus getStatus() { return status; }
    public void setStatus(AccountStatus status) { this.status = status; }

    @Override
    public String toString() {
        return "Account [id=" + id + ", accountNumber=" + accountNumber + ", accountType=" + accountType
                + ", balance=" + balance + ", openingDate=" + openingDate + ", status=" + status + "]";
    }
}
