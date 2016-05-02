package GUI;


import javax.swing.JOptionPane;
import oracle.ConsultasSQL;
import org.apache.commons.codec.digest.DigestUtils;
import usuarios.Usuario;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;



public class Logueo extends javax.swing.JFrame {

    private ConsultasSQL consultas;
   
    
    public Logueo() {
        consultas = new ConsultasSQL();
        initComponents();
   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiqueta_usuario = new javax.swing.JLabel();
        etiqueta_contrasenia = new javax.swing.JLabel();
        campo_usuario = new javax.swing.JTextField();
        boton_aceder = new javax.swing.JButton();
        boton_cancelar = new javax.swing.JButton();
        campo_contrasenia = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setName("Logeo"); // NOI18N
        setResizable(false);

        etiqueta_usuario.setText("Usuario");

        etiqueta_contrasenia.setText("Contrasenia");

        boton_aceder.setText("Entrar");
        boton_aceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_acederActionPerformed(evt);
            }
        });

        boton_cancelar.setText("Cancelar");
        boton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(59)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(etiqueta_usuario, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
        				.addComponent(etiqueta_contrasenia))
        			.addGap(35)
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
        			.addComponent(jLabel2)
        			.addGap(24))
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addGap(96)
        			.addComponent(boton_aceder)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(campo_usuario, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        				.addComponent(campo_contrasenia)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(boton_cancelar)
        					.addGap(27)))
        			.addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(34, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(campo_usuario, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(etiqueta_usuario, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel1)
        							.addGap(13)
        							.addComponent(campo_contrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addComponent(etiqueta_contrasenia, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(9)
        					.addComponent(jLabel2)))
        			.addGap(39)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(boton_aceder)
        				.addComponent(boton_cancelar))
        			.addGap(20))
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void boton_acederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_acederActionPerformed
        String contrasenia, usuario, contrasenia_encrip, contrasenia_BBDD;
        contrasenia = new String(campo_contrasenia.getPassword());
        usuario = campo_usuario.getText();
        contrasenia_encrip = DigestUtils.md5Hex(contrasenia);
        contrasenia_BBDD = consultas.getContrasenia(usuario);
        if (contrasenia_BBDD == null) {
            System.out.println("EL USUARIO " + usuario + " NO ESTA DADO DE ALTA");
            JOptionPane.showMessageDialog(null, "EL USUARIO " + usuario + " NO ESTA DADO DE ALTA");
            campo_contrasenia.setText("");
            campo_usuario.setText("");
        } else {
            if (contrasenia_BBDD.equals(contrasenia_encrip)) {
                Usuario usr = consultas.getUsuario(usuario);
                Principal ventana_principal = new Principal(usr);
                ventana_principal.setVisible(true);
                ventana_principal.setExtendedState(MAXIMIZED_BOTH);
                this.dispose();
                consultas.cerrar();
            } else {
                System.out.println("ACCESO AL USUARIO " + usuario + " DENEGADO");
                JOptionPane.showMessageDialog(null, "CONTRASENIA INCORRECTA");
                campo_contrasenia.setText("");
            }
        }
    }//GEN-LAST:event_boton_acederActionPerformed

    private void boton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cancelarActionPerformed
        if (evt.getSource().equals(boton_cancelar)) {
            System.exit(0);
        }
    }//GEN-LAST:event_boton_cancelarActionPerformed

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logueo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_aceder;
    private javax.swing.JButton boton_cancelar;
    private javax.swing.JPasswordField campo_contrasenia;
    private javax.swing.JTextField campo_usuario;
    private javax.swing.JLabel etiqueta_contrasenia;
    private javax.swing.JLabel etiqueta_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

   
    }
    


