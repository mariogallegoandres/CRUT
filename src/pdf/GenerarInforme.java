package pdf;
import java.awt.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import oracle.ConsultasSQL;
import usuarios.Usuario;

public class GenerarInforme {

	 private Usuario user;
	 private ConsultasSQL consultas;
	 private ResultSet resultCons = null;
	 private JFileChooser chooser = new JFileChooser();
	 private FileNameExtensionFilter filter;
	 PdfPTable table;
	 TableColumn columna;
	 
	public void generarInformeMensual() throws Exception{
		
		user = new Usuario();
		consultas = new ConsultasSQL();
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
		
		
	}
	
	
	
}
