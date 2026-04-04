package co.edu.uptc.run;

import javax.swing.JOptionPane;
import co.edu.uptc.logic.CrudAccount;
import co.edu.uptc.logic.CrudBank;
import co.edu.uptc.logic.CrudCommercialBank;
import co.edu.uptc.logic.CrudCustomer;
import co.edu.uptc.logic.CrudEmployee;

public class Main {
    public static void main(String[] args) {

        CrudBank           crudBank           = new CrudBank();
        CrudCommercialBank crudCommercialBank = new CrudCommercialBank(crudBank);
        CrudCustomer       crudCustomer       = new CrudCustomer(crudBank);
        CrudEmployee       crudEmployee       = new CrudEmployee(crudBank);
        CrudAccount        crudAccount        = new CrudAccount(crudBank);

        boolean running = true;
        while (running) {
            int op = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "[1] Gestionar Customers\n" +
                "[2] Gestionar Employees\n" +
                "[3] Gestionar Accounts\n"  +
                "[4] Gestionar Banks\n"     +
                "[5] Gestionar Commercial Banks\n" +
                "[6] Salir",
                "═══ SISTEMA BANCARIO ═══",
                JOptionPane.INFORMATION_MESSAGE));

            switch (op) {
                case 1:
                    crudCustomer.menu();
                break;
                case 2:
                    crudEmployee.menu();
                break;
                case 3:
                    crudAccount.menu();
                break;
                case 4:
                    crudBank.menu();
                break;
                case 5:
                    crudCommercialBank.menu();
                break;
                case 6: {
                    running = false;
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!",
                        "Sistema Bancario", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
                default: JOptionPane.showMessageDialog(null, "Opción inválida",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
