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
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import oracle.ConsultasSQL;

public class Importar_backup extends javax.swing.JFrame {

    public String ruta;
    private ConsultasSQL consultas;

    public Importar_backup() {
        consultas = new ConsultasSQL();
        initComponents();
        initHelp();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton_examinar = new javax.swing.JButton();
        nombre_fichero = new javax.swing.JLabel();
        boton_aceptar = new javax.swing.JButton();
        boton_ayuda = new javax.swing.JButton();

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

        boton_ayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ayuda.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(boton_examinar)
                .addGap(78, 78, 78)
                .addComponent(boton_aceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(nombre_fichero, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(nombre_fichero, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_examinar)
                    .addComponent(boton_aceptar))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(boton_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
    private javax.swing.JButton boton_ayuda;
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
    private void initHelp() {
          HelpBroker hb;
          HelpSet helpset ;
         try {
            File fichero = new File("help/help_set.hs");
            URL hsURL = fichero.toURI().toURL();
            helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            hb = helpset.createHelpBroker();
            hb.enableHelpKey(this.getContentPane(), "general", helpset);
            hb.enableHelpOnButton(boton_ayuda, "ventana_importar", helpset);
        } catch (Exception e) {
            //Logger.getLogger(Logeo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cargar la ayuda" + e);
        }
    }
}
