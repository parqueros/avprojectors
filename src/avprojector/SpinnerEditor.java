/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package avprojector;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerListModel;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Long
 */
public class SpinnerEditor extends AbstractCellEditor
        implements TableCellEditor {
    final JSpinner spinner = new JSpinner();

    // Initializes the spinner.
    public SpinnerEditor(String[] items) {
        spinner.setModel(new SpinnerListModel(java.util.Arrays.asList(items)));
    }

    // Prepares the spinner component and returns it.
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        spinner.setValue(value);
        return spinner;
    }

    // Enables the editor only for double-clicks.
    public boolean isCellEditable(EventObject evt) {
        if (evt instanceof MouseEvent) {
            return ((MouseEvent)evt).getClickCount() >= 2;
        }
        return true;
    }

    // Returns the spinners current value.
    public Object getCellEditorValue() {
        return spinner.getValue();
    }
}
