package co.edu.uptc.model;

import java.util.Date;

public class CommercialBank extends Bank {
    private double loanInterestRate;
    private double creditLimit;
    private int atmCount;
    private boolean offersMortgage;
    private String bankCategory;

    public CommercialBank(String name, String nit, String address, String phone,
                          Date foundationDate, double totalAssets,
                          double loanInterestRate, double creditLimit,
                          int atmCount, boolean offersMortgage, String bankCategory) {
        super(name, nit, address, phone, foundationDate, totalAssets);
        this.loanInterestRate = loanInterestRate;
        this.creditLimit = creditLimit;
        this.atmCount = atmCount;
        this.offersMortgage = offersMortgage;
        this.bankCategory = bankCategory;
    }

    public double getLoanInterestRate() { return loanInterestRate; }
    public void setLoanInterestRate(double r) { this.loanInterestRate = r; }
    public double getCreditLimit() { return creditLimit; }
    public void setCreditLimit(double c) { this.creditLimit = c; }
    public int getAtmCount() { return atmCount; }
    public void setAtmCount(int a) { this.atmCount = a; }
    public boolean isOffersMortgage() { return offersMortgage; }
    public void setOffersMortgage(boolean o) { this.offersMortgage = o; }
    public String getBankCategory() { return bankCategory; }
    public void setBankCategory(String b) { this.bankCategory = b; }

    @Override
    public String toString() {
        return "CommercialBank [id=" + id + ", name=" + name + ", nit=" + nit
                + ", address=" + address + ", phone=" + phone
                + ", foundationDate=" + foundationDate + ", totalAssets=" + totalAssets
                + ", loanInterestRate=" + loanInterestRate + ", creditLimit=" + creditLimit
                + ", atmCount=" + atmCount + ", offersMortgage=" + offersMortgage
                + ", bankCategory=" + bankCategory + "]";
    }
}
