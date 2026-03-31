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
    public void setLoanInterestRate(double loanInterestRate) { this.loanInterestRate = loanInterestRate; }

    public double getCreditLimit() { return creditLimit; }
    public void setCreditLimit(double creditLimit) { this.creditLimit = creditLimit; }

    public int getAtmCount() { return atmCount; }
    public void setAtmCount(int atmCount) { this.atmCount = atmCount; }

    public boolean isOffersMortgage() { return offersMortgage; }
    public void setOffersMortgage(boolean offersMortgage) { this.offersMortgage = offersMortgage; }

    public String getBankCategory() { return bankCategory; }
    public void setBankCategory(String bankCategory) { this.bankCategory = bankCategory; }

    @Override
    public String toString() {
        return "CommercialBank [id=" + id + ", name=" + name + ", nit=" + nit +
               ", address=" + address + ", phone=" + phone +
               ", foundationDate=" + foundationDate + ", totalAssets=" + totalAssets +
               ", loanInterestRate=" + loanInterestRate + ", creditLimit=" + creditLimit +
               ", atmCount=" + atmCount + ", offersMortgage=" + offersMortgage +
               ", bankCategory=" + bankCategory + "]";
    }
}