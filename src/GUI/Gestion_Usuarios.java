package GUI;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import oracle.ConsultasSQL;
import org.apache.commons.codec.digest.DigestUtils;
import usuarios.Usuario;

public class Gestion_Usuarios extends javax.swing.JFrame {

    private static String DNI, contrasenia, nombre, apellidos, cargo, correo, extras, contrasenia_encriptada;
    private static int horas;
    ResultSet consulta;
    Usuario usuarioCon;

    private ConsultasSQL consultas;
    private ImageIcon ImageIcon;
    private byte[] bytesfoto;

    /**
     * Creates new form Usuarios
     */
    public Gestion_Usuarios() {
        consultas = new ConsultasSQL();
        initComponents();
        initHelp();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etiqueta_Cargo = new javax.swing.JLabel();
        etiqueta_correo = new javax.swing.JLabel();
        campo_horas = new javax.swing.JTextField();
        campo_cargo = new javax.swing.JComboBox();
        campo_correo = new javax.swing.JTextField();
        etiqueta_DNI = new javax.swing.JLabel();
        campo_apellidos = new javax.swing.JTextField();
        etiqueta_Apellidos = new javax.swing.JLabel();
        campo_nombre = new javax.swing.JTextField();
        etiqueta_nombre = new javax.swing.JLabel();
        etiqueta_extra = new javax.swing.JLabel();
        campo_DNI = new javax.swing.JTextField();
        etiqueta_foto = new javax.swing.JLabel();
        campo_foto = new javax.swing.JTextField();
        etiqueta_horas = new javax.swing.JLabel();
        campo_extras = new javax.swing.JComboBox();
        etiqueta_ontrasenia = new javax.swing.JLabel();
        campo_contrasenia = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        boton_examinar = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        combo_DNIMod = new javax.swing.JComboBox();
        boton_guardar = new javax.swing.JButton();
        boton_nuevo = new javax.swing.JButton();
        boton_retroceso = new javax.swing.JButton();
        boton_salir = new javax.swing.JButton();
        boton_modificar = new javax.swing.JButton();
        campo_tipo = new javax.swing.JLabel();
        boton_eliminar = new javax.swing.JButton();
        boton_ayuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setEnabled(false);

        etiqueta_Cargo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiqueta_Cargo.setText("Cargo");

        etiqueta_correo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiqueta_correo.setText("Correo");

        campo_horas.setText("0");
        campo_horas.setEnabled(false);

        campo_cargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Programador", "Becario", "Diseniador" }));
        campo_cargo.setEnabled(false);

        campo_correo.setEnabled(false);

        etiqueta_DNI.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiqueta_DNI.setText("DNI");

        campo_apellidos.setEnabled(false);

        etiqueta_Apellidos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiqueta_Apellidos.setText("Apellidos");

        campo_nombre.setEnabled(false);

        etiqueta_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiqueta_nombre.setText("Nombre");

        etiqueta_extra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiqueta_extra.setText("Horas extra");

        campo_DNI.setEnabled(false);

        etiqueta_foto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiqueta_foto.setText("URL foto");

        campo_foto.setEnabled(false);

        etiqueta_horas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiqueta_horas.setText("Numero de horas");

        campo_extras.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Si" }));
        campo_extras.setEnabled(false);

        etiqueta_ontrasenia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiqueta_ontrasenia.setText("Contrasenia");

        campo_contrasenia.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiqueta_DNI)
                    .addComponent(etiqueta_nombre)
                    .addComponent(etiqueta_Apellidos)
                    .addComponent(etiqueta_correo)
                    .addComponent(etiqueta_Cargo)
                    .addComponent(etiqueta_horas)
                    .addComponent(etiqueta_extra)
                    .addComponent(etiqueta_foto)
                    .addComponent(etiqueta_ontrasenia))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campo_DNI)
                    .addComponent(campo_nombre)
                    .addComponent(campo_apellidos)
                    .addComponent(campo_correo)
                    .addComponent(campo_cargo, 0, 136, Short.MAX_VALUE)
                    .addComponent(campo_horas)
                    .addComponent(campo_foto)
                    .addComponent(campo_extras, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campo_contrasenia))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_DNI)
                    .addComponent(campo_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_ontrasenia)
                    .addComponent(campo_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_nombre)
                    .addComponent(campo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_Apellidos)
                    .addComponent(campo_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_correo)
                    .addComponent(campo_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_Cargo)
                    .addComponent(campo_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_horas)
                    .addComponent(campo_horas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_extra)
                    .addComponent(campo_extras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_foto)
                    .addComponent(campo_foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        boton_examinar.setText("Examinar");
        boton_examinar.setEnabled(false);
        boton_examinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_examinarActionPerformed(evt);
            }
        });

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        combo_DNIMod.setEnabled(false);
        combo_DNIMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_DNIModActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_examinar)
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(combo_DNIMod, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton_examinar)
                .addGap(70, 70, 70)
                .addComponent(combo_DNIMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        boton_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardado.jpg"))); // NOI18N
        boton_guardar.setToolTipText("Guardar");
        boton_guardar.setEnabled(false);
        boton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardarActionPerformed(evt);
            }
        });

        boton_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevoUsuario.jpg"))); // NOI18N
        boton_nuevo.setToolTipText("Aniadir usuario");
        boton_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_nuevoActionPerformed(evt);
            }
        });

        boton_retroceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/retroceso.jpg"))); // NOI18N
        boton_retroceso.setToolTipText("Deshacer");
        boton_retroceso.setEnabled(false);
        boton_retroceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_retrocesoActionPerformed(evt);
            }
        });

        boton_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        boton_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_salirActionPerformed(evt);
            }
        });

        boton_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar.gif"))); // NOI18N
        boton_modificar.setToolTipText("Modificar Datos");
        boton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_modificarActionPerformed(evt);
            }
        });

        campo_tipo.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        boton_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.jpg"))); // NOI18N
        boton_eliminar.setToolTipText("Eliminar usuario");
        boton_eliminar.setEnabled(false);
        boton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminarActionPerformed(evt);
            }
        });

        boton_ayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ayuda.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(boton_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton_retroceso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(campo_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(boton_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campo_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_salir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(boton_eliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(boton_retroceso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(boton_nuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(boton_guardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(boton_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_examinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_examinarActionPerformed
        File archivo;
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Archivo de imagen", "jpg", "jpeg", "png"));
        int resp = fc.showOpenDialog(this);
        if (resp == JFileChooser.APPROVE_OPTION) {
            archivo = fc.getSelectedFile();
            campo_foto.setText(archivo.getAbsolutePath());
            Image foto = getToolkit().getImage(campo_foto.getText());
            foto = foto.getScaledInstance(198, 198, 1);
            lblFoto.setIcon(new ImageIcon(foto));
        }
    }//GEN-LAST:event_boton_examinarActionPerformed

    private void boton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardarActionPerformed

        DNI = campo_DNI.getText();
        nombre = campo_nombre.getText();
        apellidos = campo_apellidos.getText();
        cargo = campo_cargo.getSelectedItem().toString();
        correo = campo_correo.getText();
        horas = Integer.parseInt(campo_horas.getText());
        extras = campo_extras.getSelectedItem().toString();
        contrasenia = new String(campo_contrasenia.getPassword());
        contrasenia_encriptada = DigestUtils.md5Hex(contrasenia);

        if (comprobarCampos()) {
            if (campo_tipo.getText().equals("NUEVO")) {
                consultas.insertUsuario(DNI, contrasenia_encriptada, nombre, apellidos, cargo, correo, horas, extras);
            } else {
                if (contrasenia.equalsIgnoreCase("--")) {
                    consultas.updateUsuario(DNI, nombre, apellidos, cargo, correo, horas, extras);
                } else {
                    consultas.updateUsuario(DNI, nombre, apellidos, cargo, correo, horas, extras);
                    consultas.updatePass(DNI, contrasenia_encriptada);
                }
            }
            if (campo_foto.getText().length() > 0) {
                actualizarFoto();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Datos incorrectos. Compruebalos");
            boton_retrocesoActionPerformed(evt);
        }
        try {
            llenarCombo();
        } catch (SQLException ex) {
            Logger.getLogger(Gestion_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        boton_retrocesoActionPerformed(evt);
    }//GEN-LAST:event_boton_guardarActionPerformed

    private void boton_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_nuevoActionPerformed
        boton_guardar.setEnabled(true);
        boton_modificar.setEnabled(false);
        boton_retroceso.setEnabled(true);
        boton_nuevo.setEnabled(false);
        campo_DNI.setEnabled(true);
        campo_apellidos.setEnabled(true);
        campo_cargo.setEnabled(true);
        campo_contrasenia.setEnabled(true);
        campo_correo.setEnabled(true);
        campo_extras.setEnabled(true);
        campo_nombre.setEnabled(true);
        boton_examinar.setEnabled(true);
        campo_horas.setEnabled(true);
        campo_foto.setEnabled(true);
        campo_tipo.setText("NUEVO");
    }//GEN-LAST:event_boton_nuevoActionPerformed

    private void boton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_boton_salirActionPerformed

    private void boton_retrocesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_retrocesoActionPerformed
        campo_DNI.setText("");
        campo_apellidos.setText("");
        campo_contrasenia.setText("");
        campo_correo.setText("");
        campo_horas.setText("");
        campo_nombre.setText("");
        campo_foto.setText("");
        campo_contrasenia.setText("");
        campo_tipo.setText(" ");
        lblFoto.setIcon(null);

        campo_DNI.setEnabled(false);
        campo_apellidos.setEnabled(false);
        campo_cargo.setEnabled(false);
        campo_contrasenia.setEnabled(false);
        campo_correo.setEnabled(false);
        campo_extras.setEnabled(false);
        campo_foto.setEnabled(false);
        campo_nombre.setEnabled(false);
        combo_DNIMod.setEnabled(false);
        campo_horas.setEnabled(false);
        campo_foto.setEnabled(true);

        boton_nuevo.setEnabled(true);
        boton_modificar.setEnabled(true);
        boton_retroceso.setEnabled(false);
        boton_guardar.setEnabled(false);
        boton_eliminar.setEnabled(false);

    }//GEN-LAST:event_boton_retrocesoActionPerformed

    private void boton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_modificarActionPerformed

        try {
            llenarCombo();
        } catch (SQLException ex) {
            Logger.getLogger(Gestion_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        combo_DNIMod.setEnabled(true);
        boton_nuevo.setEnabled(false);
        boton_modificar.setEnabled(false);
        boton_guardar.setEnabled(true);
        boton_retroceso.setEnabled(true);
        boton_examinar.setEnabled(true);
        boton_eliminar.setEnabled(true);
        campo_apellidos.setEnabled(true);
        campo_cargo.setEnabled(true);
        campo_correo.setEnabled(true);
        campo_extras.setEnabled(true);
        campo_horas.setEnabled(true);
        campo_nombre.setEnabled(true);
        campo_contrasenia.setEnabled(true);
        campo_foto.setEnabled(true);

        campo_tipo.setText("MODIFICAR");
    }//GEN-LAST:event_boton_modificarActionPerformed

    private void combo_DNIModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_DNIModActionPerformed

        if (combo_DNIMod.getItemCount() > 0) {
           // char[] contrasenia = consultas.getContrasenia(combo_DNIMod.getSelectedItem().toString()).toCharArray();
            usuarioCon = consultas.getUsuario(combo_DNIMod.getSelectedItem().toString());
            campo_DNI.setText(usuarioCon.getDni());
            campo_apellidos.setText(usuarioCon.getApellidos());
            campo_cargo.setSelectedItem(usuarioCon.getCargo());
            campo_correo.setText(usuarioCon.getCorreo());
            campo_extras.setSelectedItem(usuarioCon.getHorasExtra());
            campo_horas.setText(Integer.toString(usuarioCon.getNumeroHoras()));
            campo_nombre.setText(usuarioCon.getNombre());
            campo_contrasenia.setText("--");
            lblFoto.setIcon(null);

            bytesfoto = usuarioCon.getImagen();
            if (bytesfoto != null) {
                ImageIcon img = new ImageIcon(bytesfoto);
                Icon icon = new ImageIcon(img.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                lblFoto.setIcon(icon);
            }

        }

    }//GEN-LAST:event_combo_DNIModActionPerformed

    private void boton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminarActionPerformed

        int resp = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar el usuario con DNI= " + campo_DNI.getText() + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (resp == 0) {
            consultas.deleteUsuario(usuarioCon.getDni());
            boton_retrocesoActionPerformed(evt);
        }
    }//GEN-LAST:event_boton_eliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Gestion_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_ayuda;
    private javax.swing.JButton boton_eliminar;
    private javax.swing.JButton boton_examinar;
    private javax.swing.JButton boton_guardar;
    private javax.swing.JButton boton_modificar;
    private javax.swing.JButton boton_nuevo;
    private javax.swing.JButton boton_retroceso;
    private javax.swing.JButton boton_salir;
    private javax.swing.JTextField campo_DNI;
    private javax.swing.JTextField campo_apellidos;
    private javax.swing.JComboBox campo_cargo;
    private javax.swing.JPasswordField campo_contrasenia;
    private javax.swing.JTextField campo_correo;
    private javax.swing.JComboBox campo_extras;
    private javax.swing.JTextField campo_foto;
    private javax.swing.JTextField campo_horas;
    private javax.swing.JTextField campo_nombre;
    private javax.swing.JLabel campo_tipo;
    private javax.swing.JComboBox combo_DNIMod;
    private javax.swing.JLabel etiqueta_Apellidos;
    private javax.swing.JLabel etiqueta_Cargo;
    private javax.swing.JLabel etiqueta_DNI;
    private javax.swing.JLabel etiqueta_correo;
    private javax.swing.JLabel etiqueta_extra;
    private javax.swing.JLabel etiqueta_foto;
    private javax.swing.JLabel etiqueta_horas;
    private javax.swing.JLabel etiqueta_nombre;
    private javax.swing.JLabel etiqueta_ontrasenia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblFoto;
    // End of variables declaration//GEN-END:variables

    private void actualizarFoto() {
        consultas.updateFoto(usuarioCon.getDni(), campo_foto.getText());
    }

    private boolean comprobarCampos() {
        if (DNI.length() == 0 || nombre.length() == 0 || apellidos.length() == 0 || contrasenia.length() == 0 || correo.length() == 0 || horas == 0) {
            return false;
        }
        return true;
    }

    private void llenarCombo() throws SQLException {
        if (combo_DNIMod.getItemCount() > 0) {
            combo_DNIMod.removeAllItems();
        }

        consulta = consultas.getUsuarios();
        while (consulta.next()) {
            combo_DNIMod.addItem(consulta.getString("DNI"));
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
            hb.enableHelpOnButton(boton_ayuda, "ventana_administrar_usr", helpset);
        } catch (Exception e) {
            //Logger.getLogger(Logeo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cargar la ayuda" + e);
        }
    }
}