package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import oracle.ConsultasSQL;
import usuarios.Usuario;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JScrollPane;

public class Diario_personal extends JFrame {

	private JPanel contentPane;
	public static ResultSet consulta = null;
	public static ResultSetMetaData metaDatos;
	private final ConsultasSQL consultas;
	public ArrayList<String> entradas = new ArrayList<String>();
	public  ArrayList<String> salidas = new ArrayList<String>();
	public  ArrayList<String> noFicha = new ArrayList<String>();
	private JTable tabla_trabajando;
	private JTable tabla_finJornada;
	private JTable tabla_ausentes;
	   private ResultSet resultCons = null;
	   private ResultSet resultConsFestivos = null;

    
	 /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Diario_personal frame = new Diario_personal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			private void initComponent() {
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Diario_personal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JScrollPane panelScroll = new JScrollPane();
		panelScroll.setBounds(20, 34, 315, 143);
		contentPane.add(panelScroll);
		  
		consultas = new ConsultasSQL();
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		contentPane.setLayout(null);
		  
		
		tabla_trabajando = new JTable();
		panelScroll.setViewportView(tabla_trabajando);
		tabla_trabajando.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		  
		  JLabel lblEnElPuesto = new JLabel("En el puesto de trabajo");
		  lblEnElPuesto.setBounds(10, 11, 159, 14);
		  contentPane.add(lblEnElPuesto);
		  
		  JScrollPane scrollPane = new JScrollPane();
		  scrollPane.setBounds(20, 218, 315, 143);
		  contentPane.add(scrollPane);
		 
		  tabla_finJornada = new JTable();
		  scrollPane.setViewportView(tabla_finJornada);
		  tabla_finJornada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		  
		  JLabel lblHanTerminadoSu = new JLabel("Han terminado su turno");
		  lblHanTerminadoSu.setBounds(10, 193, 138, 14);
		  contentPane.add(lblHanTerminadoSu);
		  
		  JScrollPane scrollPane_1 = new JScrollPane();
		  scrollPane_1.setBounds(20, 400, 315, 143);
		  contentPane.add(scrollPane_1);
		  
		  tabla_ausentes = new JTable();
		  scrollPane_1.setViewportView(tabla_ausentes);
		  tabla_ausentes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		  
		  JLabel lblNoHanAcudido = new JLabel("Trabajadores ausentes");
		  lblNoHanAcudido.setBounds(10, 375, 159, 14);
		  contentPane.add(lblNoHanAcudido);
	
	    try {
			calcularTrabajadoresEnEmpresa();
			llenarTablas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
	}
private void llenarTablas() throws SQLException {
				
		int columnas = 4;
		int numColumnas;
		String fecha,hora,DNI,nombre,motivo;   
        Object[] fila = new Object[columnas];
        Renderer r = new Renderer();  
        //añadir trabajadores que han fichado
        DefaultTableModel modelo_trabajando = new DefaultTableModel();
        tabla_trabajando.setModel(modelo_trabajando);
        tabla_trabajando.setName("tabla_trabajando");
        tabla_trabajando.setDefaultRenderer(Object.class, r);
        
		modelo_trabajando.addColumn("DNI");
		modelo_trabajando.addColumn("Nombre");
		modelo_trabajando.addColumn("Hora entrada");
	
        for(int j =0 ; j <entradas.size();j=j+2){
        	 numColumnas =0;
        	 DNI = entradas.get(j).toString();
        	 fila[numColumnas] = DNI;
     		 resultCons = consultas.getDNINombre(DNI);
     		 resultCons.next();
     		 nombre = resultCons.getObject(2).toString();
        	 fila[numColumnas+1] = nombre;
        	 fecha = entradas.get(j+1).toString();
        	 hora = fecha.substring(11, 19);
        	 fila[numColumnas+2] = hora;
        	modelo_trabajando.addRow(fila);
        }
      //añadir trabajadores fin de turno
      DefaultTableModel modelo_finJornada = new DefaultTableModel();
      tabla_finJornada.setModel(modelo_finJornada);
      tabla_finJornada.setName("tabla_finJornada");
      tabla_finJornada.setDefaultRenderer(Object.class, r);
      modelo_finJornada.addColumn("DNI");
      modelo_finJornada.addColumn("Nombre");
      modelo_finJornada.addColumn("Hora salida");
    
        
        for(int j =0 ; j <salidas.size();j=j+2){
       	 numColumnas =0;
       	 DNI = salidas.get(j).toString();
       	 fila[numColumnas] = DNI;
    		 resultCons = consultas.getDNINombre(DNI);
    		 resultCons.next();
    		 nombre = resultCons.getObject(2).toString();
       	 fila[numColumnas+1] = nombre;
       	 fecha = salidas.get(j+1).toString();
       	 hora = fecha.substring(11, 19);
       	 fila[numColumnas+2] = hora;
       	
       	modelo_finJornada.addRow(fila);
       }
        
        
       //añadir trabajadores que hoy no han ido a trabajar 
        
        DefaultTableModel modelo_ausentes = new DefaultTableModel();
        tabla_ausentes.setModel(modelo_ausentes);
        tabla_ausentes.setName("tabla_ausentes");
        tabla_ausentes.setDefaultRenderer(Object.class, r);
        modelo_ausentes.addColumn("DNI");
        modelo_ausentes.addColumn("Nombre");
        modelo_ausentes.addColumn("Motivo");
      resultCons = consultas.getUsuarios();
      while(resultCons.next()){
    	  DNI = resultCons.getObject(1).toString();
    	  if(!entradas.contains(DNI) && !salidas.contains(DNI)){
        	 numColumnas =0;
    		 fila[numColumnas] = DNI;    
    		 nombre = resultCons.getObject(3).toString();
        	 fila[numColumnas+1] = nombre;
        	 fecha = obtenerFecha();
             String dia, mesAnio;
             StringTokenizer st = new StringTokenizer(fecha, "/");
             dia = st.nextToken();
             mesAnio = st.nextToken();
             mesAnio = mesAnio + "/" + st.nextToken();
        	 resultConsFestivos = consultas.getFestivosUsr(DNI, mesAnio);
        	 if(resultConsFestivos.next()){
        		 motivo = resultConsFestivos.getObject(2).toString();
        	 }else{
        		 motivo = "SIN MOTIVO";
        	 }
        	 fila[numColumnas+2] = motivo;
             modelo_ausentes.addRow(fila);
    	  }
      }
      
        
	}

private void calcularTrabajadoresEnEmpresa() throws SQLException {
	 ResultSetMetaData metaDatos;
	
	 String DNI, tipo, fechaFich;
	 String fecha = obtenerFecha();
	 consulta = consultas.getUsuariosPuestos(fecha);	
	 
	 metaDatos = consulta.getMetaData();
     int i = 1;
	 if (consulta != null) {
	  while(consulta.next()){
		   DNI =consulta.getObject(i).toString();
		   tipo = consulta.getObject(i+1).toString();
		   fechaFich = consulta.getObject(i+2).toString();
		   
		   if(!entradas.contains(DNI) && !salidas.contains(DNI)){
			   if(tipo.equals("INGRESO")){
			      entradas.add(DNI);
			      entradas.add(fechaFich);
			   }else{
				 salidas.add(DNI);  
				 salidas.add(fechaFich);
			   }
		   }
		   }
		 }
	 }
	 


	  private String obtenerFecha() {
	        java.util.Date date = new java.util.Date();
	        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
	        String fecha = sdf.format(date);
	        return fecha;
	    }
}
