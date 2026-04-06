package co.edu.uptc.model;
import co.edu.uptc.enums.AccountStatusEnum;
import co.edu.uptc.enums.AccountTypeEnum;
import java.util.Date;

public class Account extends BaseClass {
    private String accountNumber;
    private AccountTypeEnum accountType;
    private double balance;
    private Date openingDate;
    private AccountStatusEnum status;
    public Account(String accountNumber, AccountTypeEnum accountType, double balance,
                   Date openingDate, AccountStatusEnum status) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.openingDate = openingDate;
        this.status = status;
    }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public AccountTypeEnum getAccountType() { return accountType; }
    public void setAccountType(AccountTypeEnum accountType) { this.accountType = accountType; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public Date getOpeningDate() { return openingDate; }
    public void setOpeningDate(Date openingDate) { this.openingDate = openingDate; }
    public AccountStatusEnum getStatus() { return status; }
    public void setStatus(AccountStatusEnum status) { this.status = status; }

    @Override
    public String toString() {
        return "Account [id=" + id + ", accountNumber=" + accountNumber + ", accountType=" + accountType
                + ", balance=" + balance + ", openingDate=" + openingDate + ", status=" + status + "]";
    }
}
