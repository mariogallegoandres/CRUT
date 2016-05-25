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
import javax.swing.DefaultComboBoxModel;

public class Fichajes extends JFrame {

	private JPanel contentPane;
	public static ResultSet consulta = null;
	public static ResultSetMetaData metaDatos;
	private final ConsultasSQL consultas  = new ConsultasSQL();;
	private ResultSet resultCons = null;
	public int[] rowSelect ;
	
	
	private JTable table;
	public int[] indicesfilasSeleccionadas;
	
	JComboBox comboBox;
	JComboBox comboTipo;
	private JLabel lblNombre;

    String DNI,fecha,motivo;
    int año;
    int columnas, numColumna;
    
    boolean todos, resAñadir=false,resEliminar=false;
    private JTextField textIDModi;
    private JTextField textHora;
    private JTextField textField;


	/**
	 * Create the frame.
	 */
	public Fichajes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JScrollPane panelScroll = new JScrollPane();
		panelScroll.setBounds(10, 53, 399, 230);
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
		lblNombre.setBounds(292, 25, 152, 14);
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
		
		btnConfirmar.setBounds(552, 260, 108, 23);
		contentPane.add(btnConfirmar);
		
		final JToggleButton tglbtnAadir = new JToggleButton("A\u00F1adir");
		tglbtnAadir.setBounds(474, 50, 71, 23);
		contentPane.add(tglbtnAadir);
		
		final JToggleButton tglbtnModificar = new JToggleButton("Modificar");
		
		tglbtnModificar.setBounds(623, 50, 84, 23);
		contentPane.add(tglbtnModificar);
		
		final JPanel panelAnia = new JPanel();
		panelAnia.setBounds(484, 78, 221, 171);
		contentPane.add(panelAnia);
		panelAnia.setLayout(null);
		
		final JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 84, 46, 14);
		panelAnia.add(lblTipo);
		Calendar fechaSelec = Calendar.getInstance();
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 30, 46, 14);
		panelAnia.add(lblFecha);	
		
		textField = new JTextField();
		textField.setText("DD/MM/YYYY HH24:MI:SS");
		textField.setColumns(10);
		textField.setBounds(67, 27, 119, 20);
		panelAnia.add(textField);
		
		comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Ingreso", "Salida"}));
		comboTipo.setBounds(66, 81, 120, 20);
		panelAnia.add(comboTipo);
		
		final JPanel panelModi = new JPanel();
		panelModi.setBounds(482, 78, 218, 171);
		contentPane.add(panelModi);
		panelModi.setLayout(null);
		
		JLabel lblDiasAEliminar = new JLabel("Modificar ID");
		lblDiasAEliminar.setBounds(10, 57, 73, 14);
		panelModi.add(lblDiasAEliminar);
		
		textIDModi = new JTextField();
		textIDModi.setBounds(89, 54, 36, 20);
		panelModi.add(textIDModi);
		textIDModi.setColumns(10);
		
		textHora = new JTextField();
		textHora.setText("DD/MM/YYYY HH24:MI:SS");
		textHora.setBounds(89, 85, 119, 20);
		panelModi.add(textHora);
		textHora.setColumns(10);
		
		JLabel lblHora = new JLabel("Fecha");
		lblHora.setBounds(10, 88, 46, 14);
		panelModi.add(lblHora);
		
		tglbtnAadir.setSelected(true);
		rowSelect = table.getSelectedRows();
		
		panelAnia.setVisible(true);
		tglbtnAadir.setSelected(true);
		
		panelModi.setVisible(false);
		tglbtnModificar.setSelected(false);
		
		tglbtnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tglbtnModificar.setSelected(true);
				tglbtnAadir.setSelected(false);
				panelAnia.setVisible(false);
				panelModi.setVisible(true);	
			}
		});
		
		
		
		tglbtnAadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tglbtnModificar.setSelected(false);
				panelAnia.setVisible(true);
				panelModi.setVisible(false);	
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
					modificarEnBBDD();
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
	private void modificarEnBBDD() {
		String ID= textIDModi.getText().toString();
		fecha = textHora.getText().toString();
		
		boolean eje;
		eje = consultas.updateFechaFich(ID, fecha);
	    if(!eje){
	       JOptionPane.showMessageDialog(null, "NO SE HA PODIDO REALIZAR LA MODIFICACION ");      
	    }
		try {
			llenarTabla();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	}
	private void añadirEnBBDD() throws SQLException {
	  String tipo ;
	  DNI =comboBox.getSelectedItem().toString();
	  fecha = textHora.getText().toString();
	  tipo = comboTipo.getSelectedItem().toString();
	  
	  consultas.insertFichaje(DNI, fecha, "INGRESO");
		
		
		llenarTabla();
	}

	private void llenarTabla() throws SQLException{
		   DefaultTableModel modeloTabla = new DefaultTableModel(){
			   @Override
			  public boolean isCellEditable (int fila, int columna) {
		        return false;
		    }
		   };
		   table.setModel(modeloTabla);
	        modeloTabla.addColumn("ID");
	        modeloTabla.addColumn("DNI");
	        modeloTabla.addColumn("FECHA");
	        modeloTabla.addColumn("TIPO");
	        TableColumn columnaDNI = table.getColumn("DNI");
			columnaDNI.setPreferredWidth(2);
			TableColumn columnaID = table.getColumn("ID");
			columnaID.setPreferredWidth(1);
			
	        DNI = comboBox.getSelectedItem().toString();
	        fecha = obtenerFecha();
	        
	        resultCons = consultas.getFichajesUsrMensuales(DNI, fecha.substring(3, 10));
	       
	       columnas = 4;
	       Object[] fila = new Object[columnas];
	      while(resultCons.next()){
	        numColumna=0;
	        fila[numColumna] = resultCons.getObject(1).toString();
	        fila[numColumna+1] = resultCons.getObject(2).toString();
	        fila[numColumna+2] = resultCons.getObject(3).toString();
	        fila[numColumna+3] = resultCons.getObject(4).toString();
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
	 private String obtenerFecha() {
	        java.util.Date date = new java.util.Date();
	        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
	        String fecha = sdf.format(date);
	        return fecha;
	    }
}

