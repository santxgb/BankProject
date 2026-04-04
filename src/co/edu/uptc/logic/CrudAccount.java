package co.edu.uptc.logic;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import co.edu.uptc.enums.AccountStatus;
import co.edu.uptc.enums.AccountType;
import co.edu.uptc.model.Account;

public class CrudAccount extends AbstractCrud<Account> {

    private ArrayList<Account> list = new ArrayList<>();

    public CrudAccount() { super("Account"); }

    @Override
    protected Account createInstance() {
        String accountNumber = JOptionPane.showInputDialog(null, "Número de cuenta:", "Crear Account", JOptionPane.QUESTION_MESSAGE);
        String[] types       = { "SAVINGS", "CHECKING", "CREDIT" };
        int typeIdx          = JOptionPane.showOptionDialog(null, "Tipo de cuenta:", "Crear Account",
                               JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, types, types[0]);
        String balanceStr    = JOptionPane.showInputDialog(null, "Saldo inicial:", "Crear Account", JOptionPane.QUESTION_MESSAGE);
        String[] statuses    = { "ACTIVE", "INACTIVE", "BLOCKED" };
        int statusIdx        = JOptionPane.showOptionDialog(null, "Estado:", "Crear Account",
                               JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);
        if (accountNumber == null || balanceStr == null || typeIdx < 0 || statusIdx < 0) return null;
        return new Account(accountNumber, AccountType.values()[typeIdx],
                Double.parseDouble(balanceStr), new Date(), AccountStatus.values()[statusIdx]);
    }

    @Override
    protected boolean newRecord(Account record) {
        if (findRecordById(record.getId()) != null) return false;
        return list.add(record);
    }

    @Override
    protected Account findRecordById(int id) {
        for (Account a : list) { if (a.getId() == id) return a; }
        return null;
    }

    @Override
    protected boolean updateRecord(Account updated) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == updated.getId()) { list.set(i, updated); return true; }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return list.removeIf(a -> a.getId() == id);
    }
}
