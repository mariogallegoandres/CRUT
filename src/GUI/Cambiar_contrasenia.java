package GUI;

import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;
import oracle.ConsultasSQL;
import org.apache.commons.codec.digest.DigestUtils;
import usuarios.Usuario;

public class Cambiar_contrasenia extends javax.swing.JFrame {

    private String contrasenia, contrasenia_BBDD;
    ResultSet consulta = null;
    private static Usuario usuarioActual;
    private ConsultasSQL consultas;

    public Cambiar_contrasenia() {
        initComponents();
    }

    Cambiar_contrasenia(Usuario usr) {
        consultas = new ConsultasSQL();
        usuarioActual = usr;
        initComponents();
        initHelp();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campo_nombre = new javax.swing.JLabel();
        etiqueta_contrasenia = new javax.swing.JLabel();
        campo_contraseniaNueva = new javax.swing.JPasswordField();
        etiqueta_contraseniaNueva1 = new javax.swing.JLabel();
        campo_contraseniaAntigua = new javax.swing.JPasswordField();
        campo_contraseniaNueva2 = new javax.swing.JPasswordField();
        etiqueta_contraseniaNueva2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        boton_Autenticar = new javax.swing.JButton();
        campo_DNI = new javax.swing.JLabel();
        icono_ok = new javax.swing.JLabel();
        icono_false = new javax.swing.JLabel();
        boton_guardar = new javax.swing.JButton();
        boton_cancelar = new javax.swing.JButton();
        boton_ayuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("cambio_contrasenia"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        campo_nombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        etiqueta_contrasenia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiqueta_contrasenia.setText("Contrasenia actual:");

        campo_contraseniaNueva.setEnabled(false);
        campo_contraseniaNueva.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campo_contraseniaNuevaFocusLost(evt);
            }
        });

        etiqueta_contraseniaNueva1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiqueta_contraseniaNueva1.setText("Introduzca nueva contrasenia:");
        etiqueta_contraseniaNueva1.setEnabled(false);

        campo_contraseniaAntigua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_contraseniaAntiguaActionPerformed(evt);
            }
        });

        campo_contraseniaNueva2.setEnabled(false);
        campo_contraseniaNueva2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campo_contraseniaNueva2MouseClicked(evt);
            }
        });
        campo_contraseniaNueva2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                campo_contraseniaNueva2MouseMoved(evt);
            }
        });
        campo_contraseniaNueva2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campo_contraseniaNueva2FocusLost(evt);
            }
        });

        etiqueta_contraseniaNueva2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiqueta_contraseniaNueva2.setText("Confirme nueva contrasenia:");
        etiqueta_contraseniaNueva2.setEnabled(false);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Candado.jpg"))); // NOI18N

        boton_Autenticar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ticks2.jpg"))); // NOI18N
        boton_Autenticar.setText("Autenticar");
        boton_Autenticar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_AutenticarActionPerformed(evt);
            }
        });

        campo_DNI.setText("jLabel2");

        icono_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Ticks.jpg"))); // NOI18N

        icono_false.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_False.png"))); // NOI18N

        boton_guardar.setText("Guardar cambios");
        boton_guardar.setEnabled(false);
        boton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardarActionPerformed(evt);
            }
        });

        boton_cancelar.setText("Cancelar");
        boton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cancelarActionPerformed(evt);
            }
        });

        boton_ayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ayuda.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiqueta_contraseniaNueva2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(campo_contraseniaNueva2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(etiqueta_contrasenia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(campo_contraseniaAntigua, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(etiqueta_contraseniaNueva1)
                                        .addGap(18, 18, 18)
                                        .addComponent(campo_contraseniaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(39, 39, 39)
                        .addComponent(campo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_DNI)
                    .addComponent(boton_Autenticar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(icono_ok)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(icono_false)))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(boton_cancelar)
                .addGap(81, 81, 81)
                .addComponent(boton_guardar)
                .addGap(164, 164, 164)
                .addComponent(boton_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo_DNI)
                            .addComponent(campo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_contrasenia)
                    .addComponent(campo_contraseniaAntigua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_Autenticar))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_contraseniaNueva1)
                    .addComponent(campo_contraseniaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campo_contraseniaNueva2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(etiqueta_contraseniaNueva2))
                    .addComponent(icono_ok)
                    .addComponent(icono_false, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_guardar)
                    .addComponent(boton_cancelar))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(boton_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campo_contraseniaAntiguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_contraseniaAntiguaActionPerformed

    }//GEN-LAST:event_campo_contraseniaAntiguaActionPerformed

    private void boton_AutenticarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_AutenticarActionPerformed
        contrasenia_BBDD = consultas.getContrasenia(usuarioActual.getDni());
        contrasenia = new String(campo_contraseniaAntigua.getPassword());
        String contrasenia_encrip = DigestUtils.md5Hex(contrasenia);

        if (contrasenia_BBDD.equals(contrasenia_encrip)) {
            etiqueta_contraseniaNueva1.setEnabled(true);
            etiqueta_contraseniaNueva2.setEnabled(true);
            campo_contraseniaNueva.setEnabled(true);
            campo_contraseniaNueva2.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "CONTRASENIA INCORRECTA");
            campo_contraseniaAntigua.setText("");
        }
    }//GEN-LAST:event_boton_AutenticarActionPerformed

    private void campo_contraseniaNuevaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campo_contraseniaNuevaFocusLost
        int longitud = campo_contraseniaNueva.getText().length();
        if (longitud < 5) {
            JOptionPane.showMessageDialog(null, "Minimo 5 caracteres");
            campo_contraseniaNueva.setText("");
        }
    }//GEN-LAST:event_campo_contraseniaNuevaFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        campo_DNI.setVisible(false);
        icono_ok.setVisible(false);
        icono_false.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void boton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_boton_cancelarActionPerformed

    private void campo_contraseniaNueva2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_contraseniaNueva2MouseMoved
        habilitar_boton();
    }//GEN-LAST:event_campo_contraseniaNueva2MouseMoved

    private void campo_contraseniaNueva2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_contraseniaNueva2MouseClicked
        habilitar_boton();
     }//GEN-LAST:event_campo_contraseniaNueva2MouseClicked

    private void campo_contraseniaNueva2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campo_contraseniaNueva2FocusLost
        habilitar_boton();
    }//GEN-LAST:event_campo_contraseniaNueva2FocusLost

    private void boton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardarActionPerformed
        boolean ejec = false;
        String contrasenia = new String(campo_contraseniaNueva.getPassword());

        String contrasenia_encrip = DigestUtils.md5Hex(contrasenia);
        ejec = consultas.updatePass(usuarioActual.getDni(),contrasenia_encrip);
        if (ejec) {
            JOptionPane.showMessageDialog(null, "Contrasenia modificada");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Contrasenia no modificada correctamente");
        }
    }//GEN-LAST:event_boton_guardarActionPerformed

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
            java.util.logging.Logger.getLogger(Cambiar_contrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cambiar_contrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cambiar_contrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cambiar_contrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cambiar_contrasenia().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_Autenticar;
    private javax.swing.JButton boton_ayuda;
    private javax.swing.JButton boton_cancelar;
    private javax.swing.JButton boton_guardar;
    public static javax.swing.JLabel campo_DNI;
    private javax.swing.JPasswordField campo_contraseniaAntigua;
    private javax.swing.JPasswordField campo_contraseniaNueva;
    private javax.swing.JPasswordField campo_contraseniaNueva2;
    public static javax.swing.JLabel campo_nombre;
    private javax.swing.JLabel etiqueta_contrasenia;
    private javax.swing.JLabel etiqueta_contraseniaNueva1;
    private javax.swing.JLabel etiqueta_contraseniaNueva2;
    private javax.swing.JLabel icono_false;
    private javax.swing.JLabel icono_ok;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

    private void habilitar_boton() {
        String contraseniaNueva, contraseniaNueva2;
        contraseniaNueva = new String(campo_contraseniaNueva.getPassword());
        contraseniaNueva2 = new String(campo_contraseniaNueva2.getPassword());
        if (contraseniaNueva.length() > 0) {
            if (contraseniaNueva.equals(contraseniaNueva2)) {
                icono_ok.setVisible(true);
                icono_false.setVisible(false);
                boton_guardar.setEnabled(true);
            } else {
                icono_false.setVisible(true);
                icono_ok.setVisible(false);
                boton_guardar.setEnabled(false);

            }
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
            hb.enableHelpOnButton(boton_ayuda, "ventana_mod_contra", helpset);
        } catch (Exception e) {
            //Logger.getLogger(Logeo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cargar la ayuda" + e);
        }
    }
}
