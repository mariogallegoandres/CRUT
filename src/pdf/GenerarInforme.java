package pdf;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import GUI.Principal;
import oracle.ConsultasSQL;
import usuarios.Usuario;

public class GenerarInforme extends JFrame {

	private Usuario usuarioActual;
	private Usuario usuarioBuscar;
	private JPanel contentPane;
	public static ResultSetMetaData metaDatos;
	private ResultSet resultCons = null;
	private ResultSet resultConsDiario = null;
	private final ConsultasSQL consultas  = new ConsultasSQL();
	public int[] rowSelect ;
	private JTable table;
	private JTable tableDiario;
	public int[] indicesfilasSeleccionadas;
    String DNI;
    int año;
    int columnas, numColumna;
    boolean todos, resAñadir=false,resEliminar=false;
    private javax.swing.JLabel campo_DNI;
    private javax.swing.JLabel campo_apellidos;
    private javax.swing.JLabel campo_cargo;
    private javax.swing.JLabel campo_correo;
    private javax.swing.JLabel campo_extras;
    private javax.swing.JLabel campo_horas;
    
    private javax.swing.JLabel campo_horasTotales;
    private javax.swing.JLabel etiqueta_nombre;
    private javax.swing.JLabel campo_nombre;
    private javax.swing.JLabel etiqueta_DNI;
    private javax.swing.JLabel etiqueta_apellidos;
    private javax.swing.JLabel etiqueta_cargo;
    private javax.swing.JLabel etiqueta_correo;
    private javax.swing.JLabel etiqueta_extras;
    private javax.swing.JLabel etiqueta_horas;
    
    private javax.swing.JLabel etiqueta_horasDiarias;
    private javax.swing.JLabel etiqueta_horasTotales;
    
    private javax.swing.JLabel etiqueta_horasRestantes;
    private javax.swing.JLabel campo_horasRestantes;
    
    private javax.swing.JLabel etiqueta_ingreso;

    
    private javax.swing.JLabel etiqueta_horario;

    
    private javax.swing.JLabel etiqueta_sueldo;
    private javax.swing.JLabel campo_sueldo;
    
    private javax.swing.JLabel foto;
    private javax.swing.JComboBox combo_anios;
    private javax.swing.JComboBox combo_mes;
    
    String fechaRep="";
   
    private javax.swing.JTextField intDni;
    private javax.swing.JLabel dni;
    
    private javax.swing.JLabel nombreTablaFichajes;

    String horasDiario = "";
    String dateMes = "";
    String fecha = "";
    String primerIngreso="";
    String ultimaSalida="";
    String incidencia="";
   
    DefaultTableModel modelo;
   
   
    private JFileChooser chooser;
    private FileNameExtensionFilter filter;
    PdfPTable tablePdf;
    TableColumn columna;
    
	/**
	 * Create the frame.
	 */
   
	public GenerarInforme(Usuario user) {
	/*	
		consultas.deleteFichajes("2");
		consultas.deleteFichajes("3");
		consultas.deleteFichajes("4");
		consultas.deleteFichajes("5");
		consultas.deleteFichajes("6");
		consultas.deleteFichajes("7");
		consultas.deleteFichajes("8");
		consultas.deleteFichajes("9");
		consultas.deleteFichajes("10");
		
		String dni = "";
		for(int i = 0; i<9;i++){
			if(i==0)
				dni="2";
			if(i==1)
				dni="3";
			if(i==2)
				dni="4";
			if(i==3)
				dni="5";
			if(i==4)
				dni="6";
			if(i==5)
				dni="7";
			if(i==6)
				dni="8";
			if(i==7)
				dni="9";
			if(i==8)
				dni="10";
			
			
			
			consultas.insertFichaje(dni, "01/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "01/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "02/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "02/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "03/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "03/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "04/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "04/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "05/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "05/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "06/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "06/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "07/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "07/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "08/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "08/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "09/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "09/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "10/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "10/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "11/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "11/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "12/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "12/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "13/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "13/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "14/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "14/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "15/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "15/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "16/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "16/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "17/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "17/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "18/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "18/05/2016 13:00:00", "SALIDA");
			
			
			consultas.insertFichaje(dni, "19/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "19/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "20/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "20/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "21/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "21/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "22/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "22/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "23/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "23/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "24/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "24/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "25/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "25/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "26/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "26/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "27/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "27/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "28/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "28/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "29/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "29/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "30/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "30/05/2016 13:00:00", "SALIDA");
			
			consultas.insertFichaje(dni, "31/05/2016 09:00:00", "INGRESO");
			consultas.insertFichaje(dni, "31/05/2016 13:00:00", "SALIDA");
			
			
		}
		
		
		*/
		chooser = new JFileChooser();
		
		usuarioActual = user;	
		usuarioBuscar = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 875, 650);
	
		
		
		this.setTitle("Informe Usuario");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		//nombre tabla fichajes
		nombreTablaFichajes = new JLabel();
		nombreTablaFichajes.setBackground(new java.awt.Color(255, 255, 255));
		nombreTablaFichajes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		nombreTablaFichajes.setBounds(30, 277, 90, 14);
		nombreTablaFichajes.setText(" Tabla Jornada");
		contentPane.add(nombreTablaFichajes);
		//primera tabla fecha/horas-diarias
		JScrollPane panelScroll = new JScrollPane();
		panelScroll.setBounds(30, 290, 800, 250);
		contentPane.add(panelScroll);  
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		contentPane.setLayout(null);
		table = new JTable();
		panelScroll.setViewportView(table);
		nombrarTabla(table);
		table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		
		//tabla para guardar horas dia a dia, no se visualiza, solo es para guardar datos
		tableDiario = new JTable();
		
		
		JButton btnExportar = new JButton("Exportar");
		btnExportar.setBounds(720, 580, 108, 23);
		contentPane.add(btnExportar);
		
		btnExportar.setVisible(false);
		if(usuarioActual.getCargo().equals("Administrador")){
			btnExportar.setVisible(true);
		}
		JButton aceptar = new JButton("Aceptar");
		aceptar.setBounds(30, 580, 108, 23);
		contentPane.add(aceptar);
		
		
		
		iniciarEtiquetas();
		combos();
		
		
	
		btnExportar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String mes = combo_mes.getSelectedItem().toString();
				String anios = combo_anios.getSelectedItem().toString();
				if((!mes.equals("")) && (!anios.equals("")) ){
					try {
						exportar();
					} catch (FileNotFoundException | DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(null, "COMPLETE LOS CAMPOS");
				}
				
			}
		});
		
	/*	
		intDni.addKeyListener(new KeyAdapter() 
	    {
	        public void keyPressed(KeyEvent evt){
	            if(evt.getKeyCode() == KeyEvent.VK_ENTER) {	}
	            }
	      
	    });
			*/
		
		aceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String dni = "";
				String mes = "";
				String anios = "";
				if(usuarioActual.getCargo().equals("Administrador")){
					dni = intDni.getText().trim();
					mes = combo_mes.getSelectedItem().toString();
					anios = combo_anios.getSelectedItem().toString();
					if((!dni.equals("")) && (!mes.equals("")) && (!anios.equals("")) ){
						String comprobar = consultas.getContrasenia(dni);
						if(comprobar!=null){
							try {
								usuarioBuscar = consultas.getUsuario(dni);
								mostrasDatosBusqueda();
								cambiarEtiquetas();

								} catch (SQLException e) {
									e.printStackTrace();
									
								}
						}else{
							JOptionPane.showMessageDialog(null, "EL USUARIO NO ESTA DADO DE ALTA");
						}

					}else{
						 JOptionPane.showMessageDialog(null, "COMPLETE LOS CAMPOS");
						
					}
				}else{
					mes = combo_mes.getSelectedItem().toString();
					anios = combo_anios.getSelectedItem().toString();
					if((!mes.equals("")) && (!anios.equals("")) ){
						try {
							usuarioBuscar = usuarioActual;
							mostrasDatosBusqueda();
							cambiarEtiquetas();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
				        
					}else{
						 JOptionPane.showMessageDialog(null, "COMPLETE LOS CAMPOS");
						
					}
					
				}
				
			}
		});
	
	}
	
	
	private void exportar() throws DocumentException, IOException, SQLException{
		String ruta= ""; 
		filter = new FileNameExtensionFilter("pdf","pdf");
		chooser.setFileFilter(filter);
		Component parent = null;
		int returnVal = chooser.showSaveDialog(parent);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			ruta= chooser.getSelectedFile().getAbsolutePath()+".pdf";
			Document document = new Document();
			FileOutputStream FILE = new FileOutputStream(new File(ruta));
			PdfWriter.getInstance(document, FILE);
			PdfPCell cell ;
			Font fuenteHeader = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
			Font fuente = new Font(Font.FontFamily.TIMES_ROMAN, 8);
			document.open();
			
			String titulo = "INFORME USUARIOS " +combo_mes.getSelectedItem().toString()+" "+combo_anios.getSelectedItem().toString();
			document.add(new Paragraph(titulo,FontFactory.getFont("arial", 20,Font.UNDERLINE, BaseColor.BLACK)));
			document.add(new Paragraph(" "));
			ResultSet export = consultas.getUsuariosDNI();
			String dni = "";
			
			while(export.next()){
			
			dni = export.getString("DNI");
			usuarioBuscar = consultas.getUsuario(dni);
			mostrasDatosBusquedaExportar();
			cambiarEtiquetas();
			
			document.add(new Paragraph("DNI: "+usuarioBuscar.getDni(),FontFactory.getFont("arial", 10, BaseColor.BLACK)));             
			document.add(new Paragraph("Nombre: "+usuarioBuscar.getNombre(),FontFactory.getFont("arial", 10, BaseColor.BLACK))); 
			document.add(new Paragraph("Apellidos: "+usuarioBuscar.getApellidos(),FontFactory.getFont("arial", 10, BaseColor.BLACK))); 
			document.add(new Paragraph("Cargo: "+usuarioBuscar.getCargo(),FontFactory.getFont("arial", 10, BaseColor.BLACK))); 
			document.add(new Paragraph("Correo: "+usuarioBuscar.getCorreo(),FontFactory.getFont("arial", 10, BaseColor.BLACK))); 
			document.add(new Paragraph("Horas/Mes: "+usuarioBuscar.getNumeroHoras(),FontFactory.getFont("arial", 10, BaseColor.BLACK))); 
			document.add(new Paragraph("Horas/Dia: 8 horas",FontFactory.getFont("arial", 10, BaseColor.BLACK))); 
			document.add(new Paragraph("Horas Extra: "+usuarioBuscar.getHorasExtra(),FontFactory.getFont("arial", 10, BaseColor.BLACK))); 
			document.add(new Paragraph("Sueldo: 10$/hora",FontFactory.getFont("arial", 10, BaseColor.BLACK))); 
			document.add(new Paragraph("Horario Oficina: 09:00-19:00",FontFactory.getFont("arial", 10, BaseColor.BLACK)));
			
			
			PdfPTable pdfTable = new PdfPTable(modelo.getColumnCount());
			float[] medidaCeldas = {20f, 20f, 20f, 20f, 20f};
			pdfTable.setWidths(medidaCeldas);
			//adding table headers
            for (int i = 0; i < modelo.getColumnCount(); i++) {
            	cell = new PdfPCell(new Phrase(modelo.getColumnName(i),fuenteHeader));
                pdfTable.addCell(cell);
            }
            
          //extracting data from the JTable and inserting it to PdfPTable
            for (int rows = 0; rows < modelo.getRowCount(); rows++) {
                for (int cols = 0; cols < modelo.getColumnCount(); cols++) {
                	cell = new PdfPCell(new Phrase(table.getValueAt(rows, cols).toString(),fuente));
                    pdfTable.addCell(cell);
                }
            }
			
			document.add(new Paragraph("Horas Mensuales Realizadas: "+campo_horasTotales.getText(),FontFactory.getFont("arial", 10, BaseColor.BLACK)));
			document.add(new Paragraph("Sueldo Actual: "+campo_sueldo.getText(),FontFactory.getFont("arial", 10, BaseColor.BLACK)));
			document.add(new Paragraph(" "));
			
			
			pdfTable.setHorizontalAlignment(Element.ALIGN_LEFT);
			document.add(pdfTable);
			document.newPage();
			}
			document.close();
			FILE.close();
		}
		
	}
	private void cambiarEtiquetas(){
		
		 //renombrar
		 campo_DNI.setText(usuarioBuscar.getDni());
		 campo_nombre.setText(usuarioBuscar.getNombre());
		 campo_apellidos.setText(usuarioBuscar.getApellidos());
		 campo_cargo.setText(usuarioBuscar.getCargo());
		 campo_correo.setText(usuarioBuscar.getCorreo());
		 campo_extras.setText(usuarioBuscar.getHorasExtra());
		 campo_horas.setText(Integer.toString(usuarioBuscar.getNumeroHoras())+" horas");

		 
	
	     //RENOMBRAR LOS QUE FALTAN EXCEPTO AQUELLOS QUE NO HAGAN FALTA COMO SALDO, HORAS/DIA, HORAS/MES
	     byte[] bytesfoto;
	     foto.setIcon(null);
		 bytesfoto = usuarioBuscar.getImagen();
	        if (bytesfoto != null) {
	            ImageIcon img = new ImageIcon(bytesfoto);
	            Icon icon = new ImageIcon(img.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
	            foto.setIcon(icon);
	        }
	        
	       
		    horasDiario = "";
		   
	}
	
	private void nombrarTabla(JTable table){
		    modelo = new DefaultTableModel(){
			   @Override
			  public boolean isCellEditable (int fila, int columna) {
		        return false;
		    }
		   };
		   table.setModel(modelo);
		   modelo.addColumn("Fecha");
	       modelo.addColumn("Baja/Incidencia");
	       modelo.addColumn("Horas Realizadas");
	       modelo.addColumn("Primer Ingreso");
	       modelo.addColumn("Ultima Salida");
	     
	       
			
	}
	
	
	private void calcularHoras(DefaultTableModel tabla) {

	    	String horaMax = "";
	    	String minMax = "";
	    	String secMax = "";
	    	
	    	String horaMin = "";
	 
	    	
	    	 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	    	 DateFormat df = new SimpleDateFormat("HHH 'hrs', mm 'min,' ss 'secs'");
	    	
	         int numColumnasFic = tabla.getRowCount();
	         long tiempo = 0;
	         Date entrada, salida;
	      
	         try{
	        	 
	        	 if (numColumnasFic % 2 == 0) {
		        	 
		        	 if(numColumnasFic>0){
		        		 
			        	 ultimaSalida = tabla.getValueAt(0, 0).toString().substring(11);
			        	 primerIngreso = tabla.getValueAt(numColumnasFic-1, 0).toString().substring(11);
			        	 incidencia = "NO";
		        	 }else{
		        		 ultimaSalida = "";
		        		 primerIngreso = "";
		        		 incidencia = "";
		        	 }
		        	 
		             for (int i = 0; i < numColumnasFic; i = i + 2) {
		                
		            	 	 String fichajeSalida = tabla.getValueAt(i, 0).toString();
		                     horaMax = tabla.getValueAt(i, 0).toString().substring(11,13);
		                     int horaMaxima = Integer.parseInt(horaMax);
		                     minMax = tabla.getValueAt(i, 0).toString().substring(14,16);
		                     int minMaxima = Integer.parseInt(minMax);
		                     secMax = tabla.getValueAt(i, 0).toString().substring(17);
		                     int secMaxima = Integer.parseInt(secMax);
		                     String fichajeEntrada = tabla.getValueAt(i + 1, 0).toString();           
		                     horaMin = tabla.getValueAt(i+1, 0).toString().substring(11,13);
		                     int horaMinima = Integer.parseInt(horaMin);
		                     
		                     if(((horaMaxima < 9) && (horaMinima<9)) || ((horaMaxima >= 19) && (horaMinima>=19))){
		                    	 fichajeSalida = fichajeSalida.substring(0,10)+" "+"00:00:00";
		                    	 fichajeEntrada = fichajeEntrada.substring(0,10)+" "+"00:00:00"; 
		                    	 
		                     }else  if((horaMaxima >= 19) && (horaMinima<19)){
		                    	 fichajeSalida = fichajeSalida.substring(0,10)+" "+"19:00:00";
		                    	 
		                    	 if((horaMinima<9)){
		                    		 fichajeEntrada = fichajeEntrada.substring(0,10)+" "+"09:00:00"; 
		                    	 }
		                    	 
		                     } else if((horaMinima < 9) && (horaMaxima>=9)){
		                    	 fichajeEntrada = fichajeEntrada.substring(0,10)+" "+"09:00:00"; 
		                     }
		                    	 
		                     salida = formatter.parse(fichajeSalida);
		                     entrada = formatter.parse(fichajeEntrada);
		                     String diaSemana = "";
		                    
		                     diaSemana = entrada.toString().substring(0, 3);
		                    
		                     
		                     if(diaSemana.equals("Sun")){
		                    	incidencia = "Domingo";
		                     }else if(diaSemana.equals("Sat")){
		                    	 incidencia = "Sabado";
		                     }else{
		                    	 tiempo = tiempo + (salida.getTime() - entrada.getTime());
		                     }
		                    
		               
		             }
		         } else {
		        	 
		        	 ultimaSalida = "";
		        	 primerIngreso = "";
		             incidencia="FALLO";
		          
		             
		         }
	         }catch(ParseException ex){
	        	 Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
	         }
	         
	         
	         df = new SimpleDateFormat("HH 'hrs', mm 'min,' ss 'secs'");
	         df.setTimeZone(TimeZone.getTimeZone("GMT+0"));
	         horasDiario = df.format(new Date(tiempo));
	         
	         
    }
	

	 private void combos() {
		combo_mes = new javax.swing.JComboBox();
		combo_mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"","Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
		combo_mes.setBounds(30, 550, 100, 20);
		contentPane.add(combo_mes);
		
        combo_anios = new javax.swing.JComboBox();
        combo_anios.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"","2015", "2016", "2017" }));
        combo_anios.setBounds(150, 550, 60, 20);
        contentPane.add(combo_anios);
       
      //colocar botones etiquetas solo para el admin, para que busque informes de otros users
        
        	dni = new javax.swing.JLabel();
        	dni.setBounds(230, 550, 50, 23);
        	dni.setText("DNI:");
        	contentPane.add(dni);
        	dni.setVisible(false);
        	intDni = new javax.swing.JTextField();
        	intDni.setBounds(255, 550, 100, 23);
        	intDni.setText("");
        	contentPane.add(intDni);
        	intDni.setVisible(false);
        	
      		
      		if(usuarioActual.getCargo().equals("Administrador")){
      			dni.setVisible(true);
      			intDni.setVisible(true);
      		}
      		
      		
        
		
	}
	 
	 
	 private void mostrasDatosBusquedaExportar() throws SQLException {
		 int numMes = combo_mes.getSelectedIndex();
	        if(numMes <10){
	           String anio = combo_anios.getSelectedItem().toString();
	           String mesStrin = "0" +numMes;
	           String fecha = mesStrin + "/" + anio;
	           llenarDatosJornada(fecha);
	             

	        }else{
	            String anio = combo_anios.getSelectedItem().toString();
	            String fecha = numMes + "/" + anio;
	            llenarDatosJornada(fecha);
	           
	        }  
	    }

	 private void mostrasDatosBusqueda() throws SQLException {
	        int numMes = combo_mes.getSelectedIndex();
	        if(numMes <10){
	           String anio = combo_anios.getSelectedItem().toString();
	           String mesStrin = "0" +numMes;
	           fecha = mesStrin + "/" + anio;
	           
	           if((fecha.equals(fechaRep)) && (usuarioBuscar.getDni().equals(campo_DNI.getText()))){
	        	   JOptionPane.showMessageDialog(null, "DATOS MOSTRADOS EN PANTALLA");
	           }else{
	        	   
	        	   fechaRep = fecha;
	        	   resultCons = consultas.getFichajesUsrMensuales(usuarioBuscar.getDni(), fecha);
		           if(resultCons.next()){
		        	   llenarDatosJornada(fecha);
		           }else{
		        	   nombrarTabla(table);
		        	   campo_horasTotales.setText("00 hrs, 00 min, 00 secs");
		        	   campo_sueldo.setText("");
		        	   
		           }
	           }
	          
	          
	        }else{
	            String anio = combo_anios.getSelectedItem().toString();
	            fecha = numMes + "/" + anio;
	            
	            if((fecha.equals(fechaRep)) && (usuarioBuscar.getDni().equals(campo_DNI.getText()))){
		        	   JOptionPane.showMessageDialog(null, "DATOS MOSTRADOS EN PANTALLA");
		           }else{
		        	   fechaRep = fecha;
		        	   resultCons = consultas.getFichajesUsrMensuales(usuarioBuscar.getDni(), fecha);
			           if(resultCons.next()){
			        	   llenarDatosJornada(fecha);
			           }else{
			        	   nombrarTabla(table);
			        	   campo_horasTotales.setText("00 hrs, 00 min, 00 secs");
			        	   campo_sueldo.setText("");
			        	   
			           }
		           }
	        }  
	    }

	 private void llenarDatosJornada(String fechaBus) {

		 try {
	
		  modelo = new DefaultTableModel(){
 			   @Override
 			  public boolean isCellEditable (int fila, int columna) {
 		        return false;
 		    }
 		   };
 		  DefaultTableModel modeloDiario = new DefaultTableModel(){
			   @Override
			  public boolean isCellEditable (int fila, int columna) {
		        return false;
		    }
		   };
		   
		
		 String numeroHoras="";
		 String numeroMin="";
		 String numeroSec="";
		   
		 String dateDiario="";
		 int numeroHorasTotales=0;
		 int numeroMinTotales=0;
		 int numeroSecTotales=0;
		 
		 tableDiario.setModel(modeloDiario);
 		 table.setModel(modelo);
 		 modelo.addColumn("Fecha");
         modelo.addColumn("Baja/Incidencia");
         modelo.addColumn("Horas Realizadas");
         modelo.addColumn("Primer Ingreso");
         modelo.addColumn("Ultima Salida");
         
       
         Object[] fila = new Object[5];
         
       
		 Calendar cal;
		 GregorianCalendar gcal;
		 String mes = fechaBus.substring(0, 2);
		 String year = fechaBus.substring(3);
		 
		 int numMes = Integer.parseInt(mes);
		 int numYear = Integer.parseInt(year);
		
		 
		  cal = new GregorianCalendar(numYear,numMes-1,1);//0 es enero ...
		  int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH)+1;	
		  String numDays = Integer.toString(days);
		  
		  gcal = new GregorianCalendar();
		  DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		  sdf.setTimeZone(TimeZone.getTimeZone("GMT+0"));
		  Date start=sdf.parse("01/"+mes+"/"+year);
		  Date end = sdf.parse(numDays+"/"+numMes+"/"+numYear);
		  gcal.setTime(start);
		
		    while (gcal.getTime().before(end)) {
		    
		    	horasDiario = "00 hrs, 00 min, 00 secs";
		    	primerIngreso = "";
		    	ultimaSalida = "";
		    	incidencia = "";
		    	dateDiario = sdf.format(gcal.getTime());
		    	fila[0] = dateDiario;
		        gcal.add(Calendar.DAY_OF_YEAR, 1);
		    
		      //calcular horas dia dentro de horario oficina
			        resultConsDiario = consultas.getFichajeUsrDiario(usuarioBuscar.getDni(), dateDiario);
			        modeloDiario.addColumn("Horas/Dia");
		            while (resultConsDiario.next()) {
		                Object[] filaDiario = new Object[1];
		                filaDiario[0] = resultConsDiario.getObject(3);
		                modeloDiario.addRow(filaDiario);
		                }
		            	resultConsDiario.close();
		                calcularHoras(modeloDiario);
		          
		           
	
			        resultCons = consultas.getFestivosUsr(usuarioBuscar.getDni(), dateDiario);	
		             while (resultCons.next()) {
		                	incidencia = resultCons.getObject(2).toString();
		                    horasDiario = "08 hrs, 00 min, 00 secs";
		                   
		                }
		             resultCons.close();
			        
			        fila[1] = incidencia;
			        fila[3] = primerIngreso;
			        fila[4] = ultimaSalida;
			        fila[2] = horasDiario;
			        modelo.addRow(fila);
			        numeroHoras = horasDiario.substring(0,2);
			        numeroHorasTotales = numeroHorasTotales + Integer.parseInt(numeroHoras);
			        
			        numeroMin = horasDiario.substring(8,10);
			        numeroMinTotales = numeroMinTotales + Integer.parseInt(numeroMin);
			        
			        numeroSec = horasDiario.substring(16,18);
			        numeroSecTotales = numeroSecTotales + Integer.parseInt(numeroSec);
			        
			        modeloDiario = new DefaultTableModel();
	                tableDiario.setModel(modeloDiario);
	          
		    } 
		    
		  
		    //Calculo horas totales mensuales
		    if(numeroSecTotales > 60){
		    	numeroMinTotales = numeroMinTotales + (numeroSecTotales/60);
		    	numeroSecTotales = numeroSecTotales%60;
		    }
		    
		    if(numeroMinTotales > 60){
		    	numeroHorasTotales = numeroHorasTotales + (numeroMinTotales/60);
		    	numeroMinTotales = numeroMinTotales%60;
		    }
		    
		  String horasTotalesMensuales = numeroHorasTotales+" hrs, "+numeroMinTotales+" min, "+numeroSecTotales+" secs";
		  campo_horasTotales.setText(horasTotalesMensuales);
		  
		  if(numeroHorasTotales>=usuarioBuscar.getNumeroHoras()){
			  campo_sueldo.setText(Integer.toString(usuarioBuscar.getNumeroHoras()*10)+"$");
		  }else{
			  String nomina = Integer.toString(numeroHorasTotales*10)+"$";
			  campo_sueldo.setText(nomina);
		  }
		    
		    
	 } catch (ParseException e ) {
		 e.printStackTrace();
		
	} catch (SQLException ex){
			 Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
		}
		  
		  
	    }
	 
	 
	 private void iniciarEtiquetas() {
		
		etiqueta_DNI = new javax.swing.JLabel();
		etiqueta_DNI.setBackground(new java.awt.Color(255, 255, 255));
        etiqueta_DNI.setBounds(30, 10, 152, 14);
        etiqueta_DNI.setText("DNI: ");
        contentPane.add(etiqueta_DNI);
        campo_DNI = new javax.swing.JLabel();
		campo_DNI.setBounds(90, 10, 152, 14);
		campo_DNI.setText(usuarioBuscar.getDni());
		contentPane.add(campo_DNI);
       
        etiqueta_nombre= new javax.swing.JLabel();
        etiqueta_nombre.setBackground(new java.awt.Color(255, 255, 255));
        etiqueta_nombre.setBounds(30, 30, 152, 14);
        etiqueta_nombre.setText("Nombre: ");
        contentPane.add(etiqueta_nombre);
        campo_nombre = new javax.swing.JLabel();
        campo_nombre.setBounds(90, 30, 152, 14);
        campo_nombre.setText(usuarioBuscar.getNombre());
		contentPane.add(campo_nombre);
        
        
		etiqueta_apellidos= new javax.swing.JLabel();
		etiqueta_apellidos.setBackground(new java.awt.Color(255, 255, 255));
		etiqueta_apellidos.setBounds(30, 50, 152, 14);
		etiqueta_apellidos.setText("Apellidos: ");
		contentPane.add(etiqueta_apellidos);
		campo_apellidos = new javax.swing.JLabel();
		campo_apellidos.setBounds(90, 50, 152, 14);
		campo_apellidos.setText(usuarioBuscar.getApellidos());
		contentPane.add(campo_apellidos);
		
		etiqueta_correo= new javax.swing.JLabel();
		etiqueta_correo.setBackground(new java.awt.Color(255, 255, 255));
		etiqueta_correo.setBounds(30, 70, 152, 14);
		etiqueta_correo.setText("Correo: ");
		contentPane.add(etiqueta_correo);
		campo_correo = new javax.swing.JLabel();
		campo_correo.setBounds(90, 70, 300, 14);
		campo_correo.setText(usuarioBuscar.getCorreo());
		contentPane.add(campo_correo);
		
		etiqueta_cargo= new javax.swing.JLabel();
		etiqueta_cargo.setBackground(new java.awt.Color(255, 255, 255));
		etiqueta_cargo.setBounds(30, 90, 152, 14);
		etiqueta_cargo.setText("Cargo: ");
		contentPane.add(etiqueta_cargo);
		campo_cargo = new javax.swing.JLabel();
		campo_cargo.setBounds(90, 90, 152, 14);
		campo_cargo.setText(usuarioBuscar.getCargo());
		contentPane.add(campo_cargo);
		
		etiqueta_horas= new javax.swing.JLabel();
		etiqueta_horas.setBackground(new java.awt.Color(255, 255, 255));
		etiqueta_horas.setBounds(30, 110, 152, 14);
		etiqueta_horas.setText("Horas/Mes: ");
		contentPane.add(etiqueta_horas);
		campo_horas = new javax.swing.JLabel();
		campo_horas.setBounds(110, 110, 180, 14);
		campo_horas.setText(Integer.toString(usuarioBuscar.getNumeroHoras())+" horas");
		contentPane.add(campo_horas);
		
		
		etiqueta_horasDiarias= new javax.swing.JLabel();
		etiqueta_horasDiarias.setBackground(new java.awt.Color(255, 255, 255));
		etiqueta_horasDiarias.setBounds(30, 130, 180, 14);
		etiqueta_horasDiarias.setText("Horas/Dia: 8 horas");
		contentPane.add(etiqueta_horasDiarias);
		
		
		etiqueta_extras= new javax.swing.JLabel();
		etiqueta_extras.setBackground(new java.awt.Color(255, 255, 255));
		etiqueta_extras.setBounds(30, 150, 152, 14);
		etiqueta_extras.setText("Horas Extra: ");
		contentPane.add(etiqueta_extras);
		campo_extras = new javax.swing.JLabel();
		campo_extras.setBounds(110, 150, 152, 14);
		campo_extras.setText(usuarioBuscar.getHorasExtra());
		contentPane.add(campo_extras);
		
		
		etiqueta_ingreso= new javax.swing.JLabel();
		etiqueta_ingreso.setBackground(new java.awt.Color(255, 255, 255));
		etiqueta_ingreso.setBounds(30, 170, 180, 14);
		etiqueta_ingreso.setText("Sueldo: 10$/hora");
		contentPane.add(etiqueta_ingreso);
	
		
		etiqueta_horario= new javax.swing.JLabel();
		etiqueta_horario.setBackground(new java.awt.Color(255, 255, 255));
		etiqueta_horario.setBounds(30, 190, 180, 14);
		etiqueta_horario.setText("Horario Oficina: 09:00-19:00");
		contentPane.add(etiqueta_horario);
		
		
		etiqueta_horasTotales= new javax.swing.JLabel();
		etiqueta_horasTotales.setBackground(new java.awt.Color(255, 255, 255));
		etiqueta_horasTotales.setBounds(30, 210, 180, 14);
		etiqueta_horasTotales.setText("Horas Mensuales Realizadas: ");
		contentPane.add(etiqueta_horasTotales);
		campo_horasTotales = new javax.swing.JLabel();
		campo_horasTotales.setBounds(200, 210, 152, 14);
		contentPane.add(campo_horasTotales);
	
		
		
		
		etiqueta_sueldo= new javax.swing.JLabel();
		etiqueta_sueldo.setBackground(new java.awt.Color(255, 255, 255));
		etiqueta_sueldo.setBounds(30, 230, 180, 14);
		etiqueta_sueldo.setText("Sueldo Actual: ");
		contentPane.add(etiqueta_sueldo);
		campo_sueldo = new javax.swing.JLabel();
		campo_sueldo.setBounds(120, 230, 152, 14);
		contentPane.add(campo_sueldo);
		
		
		foto = new javax.swing.JLabel();
		foto.setBounds(670, 10, 150, 150);
		foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		byte[] bytesfoto;
		 bytesfoto = usuarioBuscar.getImagen();
	        if (bytesfoto != null) {
	            ImageIcon img = new ImageIcon(bytesfoto);
	            Icon icon = new ImageIcon(img.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
	            foto.setIcon(icon);
	        }
	        
	     contentPane.add(foto); 
	        
	    }
		
}

/*

String ruta= ""; 
filter = new FileNameExtensionFilter("pdf","pdf");
chooser.setFileFilter(filter);
Component parent = null;
int returnVal = chooser.showSaveDialog(parent);
if(returnVal == JFileChooser.APPROVE_OPTION) {
	ruta= chooser.getSelectedFile().getAbsolutePath()+".pdf";
	Document document = new Document();
	FileOutputStream FILE = new FileOutputStream(new File(ruta));
	PdfWriter.getInstance(document, FILE);

	document.open();
	
	Font fuente = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.BOLD);
		
	Font fuente1 = new Font();
	fuente1.setSize(7);
	
	table = new PdfPTable(7);
	
	float[] medidaCeldas = {12f, 12f, 12f, 12f, 12f, 12f, 12f};
	table.setWidths(medidaCeldas);
	PdfPCell c1 = new PdfPCell(new Phrase("DNI",fuente));
	c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	table.addCell(c1);
	
	
	PdfPCell c2 = new PdfPCell(new Phrase("HORAS/MES",fuente));
	c2.setHorizontalAlignment(Element.ALIGN_LEFT);
	table.addCell(c2);
	
	PdfPCell c3 = new PdfPCell(new Phrase("BAJAS",fuente));
	c3.setHorizontalAlignment(Element.ALIGN_LEFT);
	table.addCell(c3);
	
	PdfPCell c4 = new PdfPCell(new Phrase("HORAS A REALIZAR",fuente));
	c4.setHorizontalAlignment(Element.ALIGN_LEFT);	
	table.addCell(c4);
	
	PdfPCell c5 = new PdfPCell(new Phrase("HORAS HECHAS",fuente));
	c5.setHorizontalAlignment(Element.ALIGN_LEFT);	
	table.addCell(c5);
	
	PdfPCell c6 = new PdfPCell(new Phrase("HORAS DEBIDAS",fuente));
	c6.setHorizontalAlignment(Element.ALIGN_LEFT);	
	table.addCell(c6);
	
	PdfPCell c7 = new PdfPCell(new Phrase("HORAS EXTRA",fuente));
	c7.setHorizontalAlignment(Element.ALIGN_LEFT);	
	table.addCell(c7);
	PdfPCell c ;
	resultCons = consultas.getUsuariosDNI();
	String dni = "";
	
	while(resultCons.next()){
		
		dni = resultCons.getString("DNI");
		
		//CELDA DNI
		c = new PdfPCell(new Phrase(dni,fuente1));
		c.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(c);
		
		//CELDA HORAS/MES
		user = consultas.getUsuario(dni);
		c = new PdfPCell(new Phrase(Integer.toString(user.getNumeroHoras()),fuente1));
		c.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(c);
		
		//CELDA BAJAS
		c = new PdfPCell(new Phrase("NO",fuente1));
		table.addCell(c);
		
		//CELDA HORAS A REALIZAR
		//HorasMes - HorasDiasFestivos
		
		table.addCell(c);
		
		//CELDA HORAS HECHAS
		//Numero de Horas
		table.addCell(c);
		
		//CELDA HORAS DEBIDAS
		//HorasMes - HorasDiasFestivos - HorasHechas -->
		table.addCell(c);
		
		//CELDA HORAS EXTRA
		c = new PdfPCell(new Phrase(user.getHorasExtra(),fuente1));
		c.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(c);
		
	}
	
	
	
	table.setHorizontalAlignment(Element.ALIGN_LEFT);
	
	document.add(table);

	document.close();
	FILE.close();
   
   
   
}

**/