package BankProject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bank extends BaseClass {
    protected String name;
    protected String nit;
    protected String address;
    protected String phone;
    protected Date foundationDate;
    protected double totalAssets;
    protected List<Customer> customerList;
    protected List<Employee> employeeList;
    protected List<Account> accountList;
    private static int autoId;

    public Bank(String name, String nit, String address, String phone,
                Date foundationDate, double totalAssets) {
        this.name = name;
        this.nit = nit;
        this.address = address;
        this.phone = phone;
        this.foundationDate = foundationDate;
        this.totalAssets = totalAssets;
        this.customerList = new ArrayList<>();
        this.employeeList = new ArrayList<>();
        this.accountList = new ArrayList<>();
        this.id = ++autoId;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Date getFoundationDate() { return foundationDate; }
    public void setFoundationDate(Date foundationDate) { this.foundationDate = foundationDate; }

    public double getTotalAssets() { return totalAssets; }
    public void setTotalAssets(double totalAssets) { this.totalAssets = totalAssets; }

    public List<Customer> getCustomerList() { return customerList; }
    public void setCustomerList(List<Customer> customerList) { this.customerList = customerList; }

    public List<Employee> getEmployeeList() { return employeeList; }
    public void setEmployeeList(List<Employee> employeeList) { this.employeeList = employeeList; }

    public List<Account> getAccountList() { return accountList; }
    public void setAccountList(List<Account> accountList) { this.accountList = accountList; }

    @Override
    public String toString() {
        return "Bank [id=" + id + ", name=" + name + ", nit=" + nit +
               ", address=" + address + ", phone=" + phone +
               ", foundationDate=" + foundationDate + 
               ", totalAssets=" + totalAssets + "]";
    }
}