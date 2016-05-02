package GUI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import oracle.ConsultasSQL;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

public class Exportar_backup extends javax.swing.JFrame {

    public static ResultSet consulta = null;
    public static ResultSetMetaData metaDatos;
    private final ConsultasSQL consultas;
    JFileChooser chooser = new JFileChooser();

    public Exportar_backup() {
        consultas = new ConsultasSQL();
        initComponents();
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aceptar = new javax.swing.JButton();
        etiqueta_nombre = new javax.swing.JLabel();
        combo_bbdd = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        etiqueta_nombre.setText("Nombre de la base de datos");

        combo_bbdd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FICHAJES", "USUARIOS", "FESTIVOS" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(217, Short.MAX_VALUE)
        			.addComponent(aceptar)
        			.addGap(106))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(etiqueta_nombre)
        			.addGap(18)
        			.addComponent(combo_bbdd, 0, 212, Short.MAX_VALUE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(30, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(etiqueta_nombre)
        				.addComponent(combo_bbdd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(aceptar)
        			.addGap(25))
        );
        getContentPane().setLayout(layout);

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
    private javax.swing.JComboBox combo_bbdd;
    private javax.swing.JLabel etiqueta_nombre;
    // End of variables declaration//GEN-END:variables


}
