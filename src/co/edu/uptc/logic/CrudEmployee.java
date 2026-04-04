package co.edu.uptc.logic;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import co.edu.uptc.model.Employee;

public class CrudEmployee extends AbstractCrud<Employee> {

    private ArrayList<Employee> list = new ArrayList<>();

    public CrudEmployee() { super("Employee"); }

    @Override
    protected Employee createInstance() {
        String name       = JOptionPane.showInputDialog(null, "Nombre:", "Crear Employee", JOptionPane.QUESTION_MESSAGE);
        String position   = JOptionPane.showInputDialog(null, "Cargo:", "Crear Employee", JOptionPane.QUESTION_MESSAGE);
        String salaryStr  = JOptionPane.showInputDialog(null, "Salario:", "Crear Employee", JOptionPane.QUESTION_MESSAGE);
        String speciality = JOptionPane.showInputDialog(null, "Especialidad:", "Crear Employee", JOptionPane.QUESTION_MESSAGE);
        if (name == null || position == null || salaryStr == null || speciality == null) return null;
        return new Employee(name, position, Double.parseDouble(salaryStr), new Date(), speciality);
    }

    @Override
    protected boolean newRecord(Employee record) {
        if (findRecordById(record.getId()) != null) return false;
        return list.add(record);
    }

    @Override
    protected Employee findRecordById(int id) {
        for (Employee e : list) { if (e.getId() == id) return e; }
        return null;
    }

    @Override
    protected boolean updateRecord(Employee updated) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == updated.getId()) { list.set(i, updated); return true; }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return list.removeIf(e -> e.getId() == id);
    }
}
