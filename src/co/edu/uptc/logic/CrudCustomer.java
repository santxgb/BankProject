package co.edu.uptc.logic;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import co.edu.uptc.model.Customer;
import co.edu.uptc.model.Bank;

public class CrudCustomer extends AbstractCrud<Customer> {

    private ArrayList<Customer> list = new ArrayList<>();

    private CrudBank crudBank;

    public CrudCustomer(CrudBank crudBank) {
    super("Customer");
    this.crudBank = crudBank;
    }

    @Override
    protected Customer createInstance() {
        String name     = JOptionPane.showInputDialog(null, "Nombre:", "Crear Customer", JOptionPane.QUESTION_MESSAGE);
        String idNumber = JOptionPane.showInputDialog(null, "Número de documento:", "Crear Customer", JOptionPane.QUESTION_MESSAGE);
        String email    = JOptionPane.showInputDialog(null, "Email:", "Crear Customer", JOptionPane.QUESTION_MESSAGE);
        String phone    = JOptionPane.showInputDialog(null, "Teléfono:", "Crear Customer", JOptionPane.QUESTION_MESSAGE);
        if (name == null || idNumber == null || email == null || phone == null) return null;
        return new Customer(name, idNumber, email, phone, new Date());
    }

    @Override
    protected boolean newRecord(Customer record) {
        if (findRecordById(record.getId()) != null) return false;
        list.add(record);
        String idStr = JOptionPane.showInputDialog(null,
        "¿A qué banco asociar este cliente? (ingrese el ID del banco):",
        "Asociar banco", JOptionPane.QUESTION_MESSAGE);
        if (idStr != null) {
        Bank banco = crudBank.findRecordById(Integer.parseInt(idStr));
        if (banco != null) {
            banco.getCustomerList().add(record);
        } else {
            JOptionPane.showMessageDialog(null, "Banco no encontrado, cliente guardado sin asociar.",
                "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
        return true;
    }

    @Override
    protected Customer findRecordById(int id) {
        for (Customer c : list) { if (c.getId() == id) return c; }
        return null;
    }

    @Override
    protected boolean updateRecord(Customer updated) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == updated.getId()) { list.set(i, updated); return true; }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return list.removeIf(c -> c.getId() == id);
    }
}
