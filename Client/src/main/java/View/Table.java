package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable{
    
    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(25);
        setBackground(Color.WHITE);
        getTableHeader().setReorderingAllowed(false);
    }
    
    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
}
