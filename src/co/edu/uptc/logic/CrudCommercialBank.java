package co.edu.uptc.logic;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import co.edu.uptc.model.CommercialBank;

public class CrudCommercialBank extends AbstractCrud<CommercialBank> {

    private ArrayList<CommercialBank> list = new ArrayList<>();

    public CrudCommercialBank() { super("CommercialBank"); }

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
        if (findRecordById(record.getId()) != null) return false;
        return list.add(record);
    }

    @Override
    protected CommercialBank findRecordById(int id) {
        for (CommercialBank cb : list) { if (cb.getId() == id) return cb; }
        return null;
    }

    @Override
    protected boolean updateRecord(CommercialBank updated) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == updated.getId()) { list.set(i, updated); return true; }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return list.removeIf(cb -> cb.getId() == id);
    }
}
