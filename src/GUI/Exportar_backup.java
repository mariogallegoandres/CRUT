package GUI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JFileChooser;
import oracle.ConsultasSQL;

public class Exportar_backup extends javax.swing.JFrame {

    public static ResultSet consulta = null;
    public static ResultSetMetaData metaDatos;
    private final ConsultasSQL consultas;
    JFileChooser chooser = new JFileChooser();

    public Exportar_backup() {
        consultas = new ConsultasSQL();
        initComponents();
        initHelp();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aceptar = new javax.swing.JButton();
        etiqueta_nombre = new javax.swing.JLabel();
        combo_bbdd = new javax.swing.JComboBox();
        boton_ayuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        etiqueta_nombre.setText("Nombre de la base de datos");

        combo_bbdd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FICHAJES", "USUARIOS", "FESTIVOS" }));

        boton_ayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ayuda.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(217, Short.MAX_VALUE)
                .addComponent(aceptar)
                .addGap(68, 68, 68)
                .addComponent(boton_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(etiqueta_nombre)
                .addGap(18, 18, 18)
                .addComponent(combo_bbdd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_nombre)
                    .addComponent(combo_bbdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aceptar)
                        .addGap(25, 25, 25))
                    .addComponent(boton_ayuda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearBackup(String dataBase) throws IOException, SQLException {

        int resp, numColum;
        Calendar calen = Calendar.getInstance();
        String fecha = String.valueOf(calen.get(Calendar.DATE));
        fecha = fecha + "-" + String.valueOf(calen.get(Calendar.MONTH));
        fecha = fecha + "-" + String.valueOf(calen.get(Calendar.YEAR));

        resp = chooser.showSaveDialog(this);

        if (resp == JFileChooser.APPROVE_OPTION) { //si el usario presiona el boton aceptar

            File backupFile = new File(String.valueOf(chooser.getSelectedFile().toString()) + "_" + dataBase + "_" + fecha + ".sql");
            FileWriter fw = new FileWriter(backupFile);
            fw.write(dataBase);
            fw.write("\n");

            if (dataBase.equals("FICHAJES")) {
                consulta = consultas.getFichajes();
                metaDatos = consulta.getMetaData();
                numColum = metaDatos.getColumnCount();
                while (consulta.next()) {
                    for (int i = 1; i <= numColum; i++) {
                        if (i == numColum) {
                            fw.write(consulta.getObject(i).toString() + "\n");
                        } else {
                            fw.write(consulta.getObject(i).toString() + ",");
                        }
                    }
                }
            } else if (dataBase.equals("USUARIOS")) {
                consulta = consultas.getUsuarios();
                metaDatos = consulta.getMetaData();
                numColum = metaDatos.getColumnCount();

                while (consulta.next()) {
                    for (int i = 1; i < numColum; i++) {
                        if (i == numColum - 1) {
                            fw.write(consulta.getObject(i).toString() + "\n");
                        } else {
                            fw.write(consulta.getObject(i).toString() + ",");
                        }
                    }
                }
            } else {
                consulta = consultas.getFestivos();
                metaDatos = consulta.getMetaData();
                numColum = metaDatos.getColumnCount();
                while (consulta.next()) {
                    for (int i = 1; i <= numColum; i++) {
                        if (i == numColum) {
                            fw.write(consulta.getObject(i).toString() + "\n");
                        } else {
                            fw.write(consulta.getObject(i).toString() + ",");
                        }
                    }
                }
            }
            fw.close();
        }
    }

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        try {
            crearBackup(combo_bbdd.getSelectedItem().toString());

            this.dispose();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Exportar_backup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aceptarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exportar_backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exportar_backup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton boton_ayuda;
    private javax.swing.JComboBox combo_bbdd;
    private javax.swing.JLabel etiqueta_nombre;
    // End of variables declaration//GEN-END:variables

private void initHelp() {
          HelpBroker hb;
          HelpSet helpset ;
         try {
            File fichero = new File("help/help_set.hs");
            URL hsURL = fichero.toURI().toURL();
            helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            hb = helpset.createHelpBroker();
            hb.enableHelpKey(this.getContentPane(), "general", helpset);
            hb.enableHelpOnButton(boton_ayuda, "ventana_exportar", helpset);
        } catch (Exception e) {
            //Logger.getLogger(Logeo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cargar la ayuda" + e);
        }
    }
}
