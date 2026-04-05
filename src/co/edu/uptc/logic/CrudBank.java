package co.edu.uptc.logic;

import co.edu.uptc.model.Bank;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class CrudBank extends AbstractCrud<Bank> {

    private ArrayList<Bank> list = new ArrayList<>();

    public CrudBank() { super("Bank"); }

    @Override
    protected Bank createInstance() {
        String name      = JOptionPane.showInputDialog(null, "Nombre del banco:", "Crear Bank", JOptionPane.QUESTION_MESSAGE);
        String nit       = JOptionPane.showInputDialog(null, "NIT:", "Crear Bank", JOptionPane.QUESTION_MESSAGE);
        String address   = JOptionPane.showInputDialog(null, "Dirección:", "Crear Bank", JOptionPane.QUESTION_MESSAGE);
        String phone     = JOptionPane.showInputDialog(null, "Teléfono:", "Crear Bank", JOptionPane.QUESTION_MESSAGE);
        String assetsStr = JOptionPane.showInputDialog(null, "Activos totales:", "Crear Bank", JOptionPane.QUESTION_MESSAGE);
        if (name == null || nit == null || address == null || phone == null || assetsStr == null) return null;
        return new Bank(name, nit, address, phone, new Date(), Double.parseDouble(assetsStr));
    }

    @Override
    protected boolean newRecord(Bank record) {
        if (findRecordById(record.getId()) != null) return false;
        return list.add(record);
    }

    @Override
    protected Bank findRecordById(int id) {
        for (Bank b : list) { if (b.getId() == id) return b; }
        return null;
    }

    @Override
    protected void preservarCampos(Bank viejo, Bank nuevo) {
        nuevo.setCustomerList(viejo.getCustomerList());
        nuevo.setEmployeeList(viejo.getEmployeeList());
        nuevo.setAccountList(viejo.getAccountList());
    }

    @Override
    protected boolean updateRecord(Bank updated) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == updated.getId()) { list.set(i, updated); return true; }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return list.removeIf(b -> b.getId() == id);
    }
}
