package GUI;


import java.awt.EventQueue;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import oracle.ConsultasSQL;
import usuarios.Usuario;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JScrollPane;
import java.awt.Label;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;

public class Festivos extends JFrame {

	private JPanel contentPane;
	public static ResultSet consulta = null;
	public static ResultSetMetaData metaDatos;
	private final ConsultasSQL consultas  = new ConsultasSQL();;
	private ResultSet resultCons = null;
	public int[] rowSelect ;
	
	
	private JTable table;

	public JDateChooser dateChooser;
	public JRadioButton rdbtnAadirATodos;
	public int[] indicesfilasSeleccionadas;
	
	JComboBox comboBox;
	private JLabel lblNombre;

    String DNI,fecha,motivo;
    int año;
    int columnas, numColumna;
    
    boolean todos, resAñadir=false,resEliminar=false;
    private JTextField textMotivo;


	/**
	 * Create the frame.
	 */
	public Festivos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JScrollPane panelScroll = new JScrollPane();
		panelScroll.setBounds(10, 53, 304, 230);
		contentPane.add(panelScroll);
		  
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		contentPane.setLayout(null);
		  
		
		table = new JTable();
		
		panelScroll.setViewportView(table);
		table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		
		Label label = new Label("DNI");
		label.setBounds(40, 25, 30, 22);
		contentPane.add(label);
		
		comboBox = new JComboBox();
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(257, 28, 152, 14);
		contentPane.add(lblNombre);	
		
		comboBox.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	resultCons = consultas.getDNINombre(comboBox.getSelectedItem().toString());
	            	try {
						resultCons.next();
						DNI =  resultCons.getObject(1).toString();
						lblNombre.setText(resultCons.getObject(2).toString());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	
	            	
	                try {
						llenarTabla();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        });
		comboBox.setBounds(87, 25, 152, 20);
		contentPane.add(comboBox);
		
		JButton btnConfirmar = new JButton("Confirmar");
		
		btnConfirmar.setBounds(402, 260, 108, 23);
		contentPane.add(btnConfirmar);
		
		final JToggleButton tglbtnAadir = new JToggleButton("A\u00F1adir");
		tglbtnAadir.setBounds(353, 50, 71, 23);
		contentPane.add(tglbtnAadir);
		
		final JToggleButton tglbtnEliminar = new JToggleButton("Eliminar");
		
		tglbtnEliminar.setBounds(490, 50, 84, 23);
		contentPane.add(tglbtnEliminar);
		
		final JPanel panelAnia = new JPanel();
		panelAnia.setBounds(363, 78, 221, 171);
		contentPane.add(panelAnia);
		panelAnia.setLayout(null);
		
		textMotivo = new JTextField();
		textMotivo.setBounds(66, 81, 145, 20);
		panelAnia.add(textMotivo);
		textMotivo.setColumns(10);
		
		final JLabel lblMotivo = new JLabel("Motivo");
		lblMotivo.setBounds(10, 84, 46, 14);
		panelAnia.add(lblMotivo);
		
		rdbtnAadirATodos = new JRadioButton("A\u00F1adir a todos");
		rdbtnAadirATodos.setBounds(94, 142, 124, 23);
		panelAnia.add(rdbtnAadirATodos);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(69, 30, 95, 20);
		Calendar fechaSelec = Calendar.getInstance();
		dateChooser.setMinSelectableDate(fechaSelec.getTime());
		
		panelAnia.add(dateChooser);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 30, 46, 14);
		panelAnia.add(lblFecha);	
		
		final JPanel panelElimin = new JPanel();
		panelElimin.setBounds(363, 78, 218, 171);
		contentPane.add(panelElimin);
		panelElimin.setLayout(null);
		
		JLabel lblDiasAEliminar = new JLabel("Dias a eliminar");
		lblDiasAEliminar.setBounds(10, 11, 123, 14);
		panelElimin.add(lblDiasAEliminar);
		
		final JTextPane diasEliminar = new JTextPane();
		diasEliminar.setBackground(SystemColor.menu);
		diasEliminar.setBounds(20, 38, 188, 110);
		panelElimin.add(diasEliminar);
		
		tglbtnAadir.setSelected(true);
		panelElimin.setVisible(false);
		rowSelect = table.getSelectedRows();
		
		tglbtnAadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				tglbtnEliminar.setSelected(false);
				panelAnia.setVisible(true);
				panelElimin.setVisible(false);
				diasEliminar.setText(" ");
				
			}
		});
		
		tglbtnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tglbtnAadir.setSelected(false);
				panelAnia.setVisible(false);
				textMotivo.setText(" ");
				dateChooser.setDate(null);
				rdbtnAadirATodos.setSelected(false);
				panelElimin.setVisible(true);
			}
		});
		
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(panelAnia.isVisible()){
					try {
						añadirEnBBDD();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					try {
						eliminarEnBBDD();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String selection = "";

				rowSelect = table.getSelectedRows();
				for(int j= 0; j<rowSelect.length;j++){
					for (int i = 0; i < table.getColumnCount(); i++) {
						selection+=" " +table.getValueAt(rowSelect[j], i).toString();
					}
					selection += '\n';
				}
				diasEliminar.setText(selection);
			}
		});
		
	  llenarCombo();
	  try {
		llenarTabla();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	private void añadirEnBBDD() throws SQLException {
		DNI = comboBox.getSelectedItem().toString();
		fecha = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		if(fecha.equals("")){
			fecha = "";
		}else{
			
			fecha =new SimpleDateFormat("dd/MM/yyyy").format(dateChooser.getDate());
		}
		motivo = textMotivo.getText().toString();
		todos = rdbtnAadirATodos.isSelected();
		if(DNI.isEmpty()||fecha.isEmpty()||motivo.isEmpty()){
			JOptionPane.showMessageDialog(null, "Falta un dato obligatorio");		
		}else{
			if (!todos){
				resultCons = consultas.getFestivosUsr(DNI, fecha);
				if(resultCons.next()){
					 JOptionPane.showMessageDialog(null, "Ya ha tiene dia de permiso asignado");
				}else{
					resAñadir = consultas.insertFestivo(DNI, fecha, motivo);
					if (resAñadir == false) {
						JOptionPane.showMessageDialog(null, "No se ha podido realizar el ingreso");
					}
				}
	        } else {
	            for (int i = 0; i < comboBox.getItemCount(); i++) {
	                DNI = comboBox.getItemAt(i).toString();
	                
	                resultCons = consultas.getFestivosUsr(DNI, fecha);
	    			if(resultCons.next()){
	    				 JOptionPane.showMessageDialog(null, "Ya ha tiene dia de permiso asignado");
	    			}else{
	                      resAñadir = consultas.insertFestivo(DNI, fecha, motivo);
	                      if (resAñadir == false) {
	                    	  JOptionPane.showMessageDialog(null, "No se ha podido realizar el ingreso");
	                      }     
	                 }
	            }
        }
				}
		llenarTabla();
	}
	
	private void eliminarEnBBDD() throws SQLException {
		if(rowSelect.length>0){
			
			for(int i = 0; i<rowSelect.length;i++){
			DNI = comboBox.getSelectedItem().toString();
			fecha = table.getValueAt(rowSelect[i], 0).toString();
				resEliminar = consultas.deleteFestivo(DNI, fecha);
				if (resEliminar == false) {
					JOptionPane.showMessageDialog(null, "No se ha podido eliminar el dia");
				}
			}
			llenarTabla();
		}else{
			System.out.println("Error nada para borrar");
		}
		rowSelect =null;
	
	}
	
	private void llenarTabla() throws SQLException{
		   DefaultTableModel modeloTabla = new DefaultTableModel(){
			   @Override
			  public boolean isCellEditable (int fila, int columna) {
		        return false;
		    }
		   };
		   table.setModel(modeloTabla);
	        modeloTabla.addColumn("Fecha");
	        modeloTabla.addColumn("Motivo");
	        TableColumn columnaFecha = table.getColumn("Fecha");
			columnaFecha.setPreferredWidth(1);
			
	        DNI = comboBox.getSelectedItem().toString();
	        año = Integer.parseInt(obtenerAño());
	       resultCons = consultas.getFestivosUsrAño(DNI, año);
	       columnas = 2;
	       Object[] fila = new Object[columnas];
	      while(resultCons.next()){
	        numColumna=0;
	        fecha = resultCons.getObject(2).toString();
	        fila[numColumna] = fecha.substring(0, 10);
	        fila[numColumna+1] = resultCons.getObject(3).toString();
	        modeloTabla.addRow(fila);
	      }
	      //Consultar festivos año siguiente.
	      año++;
	      resultCons = consultas.getFestivosUsrAño(DNI, año);
	      while(resultCons.next()){
		        numColumna=0;
		        fecha = resultCons.getObject(2).toString();
		        fila[numColumna] = fecha.substring(0, 10);
		        fila[numColumna+1] = resultCons.getObject(3).toString();
		        modeloTabla.addRow(fila);
		      }
	}
	
	private void llenarCombo() {
		 if (comboBox.getItemCount() > 0) {
			 comboBox.removeAllItems();
         }

         consulta = consultas.getUsuarios();
         try {
			while (consulta.next()) {
				 comboBox.addItem(consulta.getString("DNI"));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	private String obtenerAño() {
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy");
        String fecha = sdf.format(date);
        return fecha;
    }
}

