package GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import oracle.ConsultasSQL;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Importar_backup extends javax.swing.JFrame {

    public String ruta;
    private ConsultasSQL consultas;

    public Importar_backup() {
        consultas = new ConsultasSQL();
        initComponents();
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton_examinar = new javax.swing.JButton();
        nombre_fichero = new javax.swing.JLabel();
        boton_aceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        boton_examinar.setText("Examinar");
        boton_examinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_examinarActionPerformed(evt);
            }
        });

        nombre_fichero.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N

        boton_aceptar.setText("Aceptar");
        boton_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_aceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addGap(72)
        			.addComponent(boton_examinar)
        			.addGap(78)
        			.addComponent(boton_aceptar)
        			.addContainerGap(102, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(54, Short.MAX_VALUE)
        			.addComponent(nombre_fichero, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
        			.addGap(40))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(33)
        			.addComponent(nombre_fichero, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(boton_examinar)
        				.addComponent(boton_aceptar))
        			.addGap(22))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_examinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_examinarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtroSQL = new FileNameExtensionFilter("SQL", "sql");
        fileChooser.setFileFilter(filtroSQL);
        int opcion = fileChooser.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            ruta = fileChooser.getSelectedFile().getPath();
            nombre_fichero.setText(fileChooser.getSelectedFile().getName());
        }
    }//GEN-LAST:event_boton_examinarActionPerformed

    private void boton_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_aceptarActionPerformed
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String nombreBase = br.readLine();

            consultas.deleteDatabase(nombreBase);

            if (nombreBase.equalsIgnoreCase("USUARIOS")) {
                importarUsuarios(br);
            } else if (nombreBase.equalsIgnoreCase("FICHAJES")) {
                importarFichajes(br);
            } else if (nombreBase.equalsIgnoreCase("FESTIVOS")) {
                importarFestivos(br);
            } else {
                JOptionPane.showMessageDialog(null, "Archivo no valido");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Importar_backup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Importar_backup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_boton_aceptarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Importar_backup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_aceptar;
    private javax.swing.JButton boton_examinar;
    private javax.swing.JLabel nombre_fichero;
    // End of variables declaration//GEN-END:variables

    private void importarUsuarios(BufferedReader br) throws IOException {
        String texto;
        String apellidos;
        int horas;

        String DNI, contrasenia, nombre, apellido1, apellido2, cargo, correo, extras;
        while ((texto = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(texto, ",");
            DNI = st.nextToken();
            contrasenia = st.nextToken();
            nombre = st.nextToken();
            apellidos = st.nextToken();
            cargo = st.nextToken();
            correo = st.nextToken();
            horas = Integer.parseInt(st.nextToken());
            extras = st.nextToken();

            consultas.insertUsuario(DNI, contrasenia, nombre, apellidos, cargo, correo, horas, extras);
        }
    }

    private void importarFichajes(BufferedReader br) throws IOException {
        String texto;
        String ID, DNI, fecha, tipo;
        while ((texto = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(texto, ",");
            ID = st.nextToken();
            DNI = st.nextToken();
            fecha = st.nextToken();
            tipo = st.nextToken();
            consultas.insertFichaje(DNI, fecha, tipo);
        }
    }

    private void importarFestivos(BufferedReader br) throws IOException {
        String texto;
        String ID, fecha, DNI, motivo;
        while ((texto = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(texto, ",");
            ID = st.nextToken();
            DNI = ID = st.nextToken();
            fecha = st.nextToken();
            motivo = st.nextToken();
            consultas.insertFestivo(DNI, fecha, motivo);
        }
    }
   
}
