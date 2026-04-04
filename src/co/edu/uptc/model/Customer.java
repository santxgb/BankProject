package co.edu.uptc.model;
import java.util.Date;

public class Customer extends BaseClass {
    private String name;
    private String idNumber;
    private String email;
    private String phone;
    private Date registrationDate;
    private static int autoId;

    public Customer(String name, String idNumber, String email, String phone, Date registrationDate) {
        this.name = name;
        this.idNumber = idNumber;
        this.email = email;
        this.phone = phone;
        this.registrationDate = registrationDate;
        this.id = ++autoId;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getIdNumber() { return idNumber; }
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Date getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(Date registrationDate) { this.registrationDate = registrationDate; }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", idNumber=" + idNumber
                + ", email=" + email + ", phone=" + phone + ", registrationDate=" + registrationDate + "]";
    }
}
