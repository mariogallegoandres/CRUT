package GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Renderer extends DefaultTableCellRenderer {
@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column) {
	// TODO Auto-generated method stub

	if(table.getName().equals("tabla_ausentes")){
		setBackground(new java.awt.Color(242,90,81));
		setForeground(Color.black);
		
		//System.out.println(table.getValueAt(row, 2).toString().equals("SIN MOTIVO"));
		
		//if(table.getValueAt(row, 3).toString())
		if(table.getValueAt(row, 2).toString().equals("SIN MOTIVO")){
			setBackground(new java.awt.Color(255,0,0));
			setSize(3, 3);
			setForeground(Color.black);
		
			
		}	
	
		
		
	}else if(table.getName().equals("tabla_trabajando")){
		setBackground(new java.awt.Color(133,255,81));
		setForeground(Color.black);
	}else if(table.getName().equals("tabla_finJornada")){
		setBackground(new java.awt.Color(255,255,45));
		setForeground(Color.black);
	}

	return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
}
}
