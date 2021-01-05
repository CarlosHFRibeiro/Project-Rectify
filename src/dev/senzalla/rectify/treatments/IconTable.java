package dev.senzalla.rectify.treatments;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class IconTable extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Icon icon = new ImageIcon(getClass().getResource("/static/img/visibility.png"));
        setIcon(icon);
        return this;
    }
}
