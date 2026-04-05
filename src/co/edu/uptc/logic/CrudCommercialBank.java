package co.edu.uptc.logic;

import co.edu.uptc.model.Bank;
import co.edu.uptc.model.CommercialBank;
import java.util.Date;
import javax.swing.JOptionPane;

public class CrudCommercialBank extends AbstractCrud<CommercialBank> {

    private CrudBank crudBank;

    public CrudCommercialBank(CrudBank crudBank) { super("CommercialBank"); 
        this.crudBank = crudBank;
    }

    @Override
    protected CommercialBank createInstance() {
        String name        = JOptionPane.showInputDialog(null, "Nombre:", "Crear CommercialBank", JOptionPane.QUESTION_MESSAGE);
        String nit         = JOptionPane.showInputDialog(null, "NIT:", "Crear CommercialBank", JOptionPane.QUESTION_MESSAGE);
        String address     = JOptionPane.showInputDialog(null, "Dirección:", "Crear CommercialBank", JOptionPane.QUESTION_MESSAGE);
        String phone       = JOptionPane.showInputDialog(null, "Teléfono:", "Crear CommercialBank", JOptionPane.QUESTION_MESSAGE);
        String assetsStr   = JOptionPane.showInputDialog(null, "Activos totales:", "Crear CommercialBank", JOptionPane.QUESTION_MESSAGE);
        String rateStr     = JOptionPane.showInputDialog(null, "Tasa de interés préstamos:", "Crear CommercialBank", JOptionPane.QUESTION_MESSAGE);
        String limitStr    = JOptionPane.showInputDialog(null, "Límite de crédito:", "Crear CommercialBank", JOptionPane.QUESTION_MESSAGE);
        String atmStr      = JOptionPane.showInputDialog(null, "Cantidad de cajeros:", "Crear CommercialBank", JOptionPane.QUESTION_MESSAGE);
        String mortgageStr = JOptionPane.showInputDialog(null, "¿Ofrece hipoteca? (true/false):", "Crear CommercialBank", JOptionPane.QUESTION_MESSAGE);
        String category    = JOptionPane.showInputDialog(null, "Categoría del banco:", "Crear CommercialBank", JOptionPane.QUESTION_MESSAGE);
        if (name==null||nit==null||address==null||phone==null||assetsStr==null||
            rateStr==null||limitStr==null||atmStr==null||mortgageStr==null||category==null) return null;
        return new CommercialBank(name, nit, address, phone, new Date(),
                Double.parseDouble(assetsStr), Double.parseDouble(rateStr),
                Double.parseDouble(limitStr), Integer.parseInt(atmStr),
                Boolean.parseBoolean(mortgageStr), category);
    }

    @Override
    protected boolean newRecord(CommercialBank record) {
        if (crudBank.findRecordById(record.getId()) != null) return false;
        return crudBank.newRecord(record);
    }

    @Override
    protected CommercialBank findRecordById(int id) {
        Bank found = crudBank.findRecordById(id);
        if (found instanceof CommercialBank) return (CommercialBank) found;
        return null;
    }

    @Override
    protected boolean updateRecord(CommercialBank updated) {
        return crudBank.updateRecord(updated);
    }

    @Override
    protected boolean deleteRecord(int id) {
        return crudBank.deleteRecord(id);
    }

    @Override
    protected void preservarCampos(CommercialBank vieja, CommercialBank nueva) {
        nueva.setCustomerList(vieja.getCustomerList());
        nueva.setEmployeeList(vieja.getEmployeeList());
        nueva.setAccountList(vieja.getAccountList());
    }
}
