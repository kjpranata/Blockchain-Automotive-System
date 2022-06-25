package automotive.function;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Helper {

    /**
     * Check if value is empty,
     * if empty, show JOptionPane
     * 
     * @param value
     * @param comp
     * @return true if the value is empty
     */
    public static Boolean isEmpty(String value, Component comp) {
        if (value.isEmpty()) {
            JOptionPane.showMessageDialog(comp,
                    "Fill all the fields!",
                    "Empty fields",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }
        return false;
    }

    /**
     * Change string to integer,
     * if the string can't convert to integer,
     * then show JOptionPane
     * 
     * @param strNum
     * @param comp
     * @return
     */
    public static int toInt(String strNum, Component comp) {
        int d;
        try {
            d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(comp,
                    "Fill the number fields with number!",
                    "Validation",
                    JOptionPane.ERROR_MESSAGE
            );
            return -1;
        }
        return d;
    }

}
