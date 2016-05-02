package GUI;

import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;
import oracle.ConsultasSQL;

public class Festivos extends javax.swing.JFrame {

    private ConsultasSQL consultas;
    ResultSet consulta;

    public Festivos() {
        consultas = new ConsultasSQL();
        initComponents();
        llenarComboUser();
        initHelp();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiqueta_DNI = new javax.swing.JLabel();
        etiqueta_fecha = new javax.swing.JLabel();
        etiqueta_motivo = new javax.swing.JLabel();
        campo_fecha = new javax.swing.JTextField();
        campo_motivo = new javax.swing.JTextField();
        check_todos = new javax.swing.JCheckBox();
        boton_Aceptar = new javax.swing.JButton();
        combo_DNI = new javax.swing.JComboBox();
        boton_salir = new javax.swing.JButton();
        boton_ayuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etiqueta_DNI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiqueta_DNI.setText("DNI");

        etiqueta_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiqueta_fecha.setText("Fecha");

        etiqueta_motivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiqueta_motivo.setText("Motivo");

        check_todos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        check_todos.setText("Asignar a todos");
        check_todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_todosActionPerformed(evt);
            }
        });

        boton_Aceptar.setText("Aceptar");
        boton_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_AceptarActionPerformed(evt);
            }
        });

        combo_DNI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        boton_salir.setText("Salir");
        boton_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_salirActionPerformed(evt);
            }
        });

        boton_ayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ayuda.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiqueta_DNI)
                    .addComponent(etiqueta_fecha)
                    .addComponent(etiqueta_motivo))
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_motivo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(combo_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(check_todos)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(boton_Aceptar)
                .addGap(34, 34, 34)
                .addComponent(boton_salir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_DNI)
                    .addComponent(combo_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_todos))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiqueta_fecha)
                            .addComponent(campo_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiqueta_motivo)
                            .addComponent(campo_motivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boton_Aceptar)
                            .addComponent(boton_salir))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(boton_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_AceptarActionPerformed
        String DNI, fecha, motivo;

        fecha = campo_fecha.getText();
        motivo = campo_motivo.getText();
        boolean res;

        if (!check_todos.isSelected()) {
            DNI = combo_DNI.getSelectedItem().toString();
            res = consultas.insertFestivo(DNI, fecha, motivo);
            if (res == false) {
                JOptionPane.showMessageDialog(null, "No se ha podido realizar el ingreso");
            }
        } else {
            for (int i = 0; i < combo_DNI.getItemCount(); i++) {
                DNI = combo_DNI.getItemAt(i).toString();
                res = consultas.insertFestivo(DNI, fecha, motivo);
                if (res == false) {
                    JOptionPane.showMessageDialog(null, "No se ha podido realizar el ingreso");

                }
            }
        }
    }//GEN-LAST:event_boton_AceptarActionPerformed

    private void check_todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_todosActionPerformed
        if (check_todos.isSelected()) {
            combo_DNI.setEnabled(false);

        } else {
            combo_DNI.setEnabled(true);
        }
    }//GEN-LAST:event_check_todosActionPerformed

    private void boton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_boton_salirActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Festivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Festivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Festivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Festivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Festivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_Aceptar;
    private javax.swing.JButton boton_ayuda;
    private javax.swing.JButton boton_salir;
    private javax.swing.JTextField campo_fecha;
    private javax.swing.JTextField campo_motivo;
    private javax.swing.JCheckBox check_todos;
    private javax.swing.JComboBox combo_DNI;
    private javax.swing.JLabel etiqueta_DNI;
    private javax.swing.JLabel etiqueta_fecha;
    private javax.swing.JLabel etiqueta_motivo;
    // End of variables declaration//GEN-END:variables

    private void llenarComboUser() {
        try {
            if (combo_DNI.getItemCount() > 0) {
                combo_DNI.removeAllItems();
            }

            consulta = consultas.getUsuarios();
            while (consulta.next()) {
                combo_DNI.addItem(consulta.getString("DNI"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Festivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initHelp() {
        HelpBroker hb;
        HelpSet helpset;
        try {
            File fichero = new File("help/help_set.hs");
            URL hsURL = fichero.toURI().toURL();
            helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            hb = helpset.createHelpBroker();
            hb.enableHelpKey(this.getContentPane(), "general", helpset);
            hb.enableHelpOnButton(boton_ayuda, "ventana_ges_festivo", helpset);
        } catch (Exception e) {
            //Logger.getLogger(Logeo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cargar la ayuda" + e);
        }
    }
}
