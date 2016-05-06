package GUI;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import oracle.ConsultasSQL;
import usuarios.Usuario;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import pdf.GenerarInforme;

public class Principal extends javax.swing.JFrame {

	private GenerarInforme generar = new GenerarInforme();
    private ConsultasSQL consultas;
    private ResultSet resultCons = null;
    private static Usuario usuarioActual;
    public static String fecha, hora;
    private ImageIcon ImageIcon;

    public Principal() {
        initComponents();
    }

    public Principal(Usuario usr) {
        consultas = new ConsultasSQL();
        usuarioActual = usr;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

    	
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        campo_cargo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        campo_DNI = new javax.swing.JLabel();
        etiqueta_DNI = new javax.swing.JLabel();
        etiqueta_cargo = new javax.swing.JLabel();
        campo_apellidos = new javax.swing.JLabel();
        etiqueta_apellidos = new javax.swing.JLabel();
        campo_nombre = new javax.swing.JLabel();
        etiqueta_nombre = new javax.swing.JLabel();
        campo_correo = new javax.swing.JLabel();
        etiqueta_correo = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        campo_carg = new javax.swing.JLabel();
        etiqueta_horas = new javax.swing.JLabel();
        etiqueta_extras = new javax.swing.JLabel();
        campo_horas = new javax.swing.JLabel();
        campo_extras = new javax.swing.JLabel();
        campo_horasDiarias = new javax.swing.JLabel();
        campo_horasTotales = new javax.swing.JLabel();
        etiqueta_horasTotales = new javax.swing.JLabel();
        etiqueta_horasRea = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_fichajesDiario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_fichajesTotales = new javax.swing.JTable();
        boton_salida = new javax.swing.JButton();
        boton_ingreso = new javax.swing.JButton();
        combo_mes = new javax.swing.JComboBox();
        combo_anios = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_festivos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu_sistema = new javax.swing.JMenu();
        cerrar_sesion = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();
        boton_ayuda = new javax.swing.JMenuItem();
        menu_fichajes = new javax.swing.JMenu();
        iniciar_fichaje = new javax.swing.JMenuItem();
        finalizar_fichaje = new javax.swing.JMenuItem();
        menu_usuarios = new javax.swing.JMenu();
        administrar_usuarios = new javax.swing.JMenuItem();
        cambiar_contrasenia = new javax.swing.JMenuItem();
        mnAdministrador = new javax.swing.JMenu();
        menu_backup = new javax.swing.JMenu();
        crear_backup = new javax.swing.JMenuItem();
        restaurar = new javax.swing.JMenuItem();

        menu_informes = new javax.swing.JMenu();
        informe_mensual = new javax.swing.JMenuItem();
        informe_mensual_usuario = new javax.swing.JMenuItem();
        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("File");
        jMenuBar3.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("File");
        jMenuBar4.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("jMenu8");

        jMenu1.setText("jMenu1");

        jMenu9.setText("jMenu9");

        jMenu10.setText("jMenu10");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Principal"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        campo_DNI.setBackground(new java.awt.Color(255, 255, 255));
        campo_DNI.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        etiqueta_DNI.setBackground(new java.awt.Color(255, 255, 255));
        etiqueta_DNI.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        etiqueta_DNI.setText("DNI:");

        etiqueta_cargo.setBackground(new java.awt.Color(255, 255, 255));
        etiqueta_cargo.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        etiqueta_cargo.setText("Cargo:");

        campo_apellidos.setBackground(new java.awt.Color(255, 255, 255));
        campo_apellidos.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        etiqueta_apellidos.setBackground(new java.awt.Color(255, 255, 255));
        etiqueta_apellidos.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        etiqueta_apellidos.setText("Apellidos:");

        campo_nombre.setBackground(new java.awt.Color(255, 255, 255));
        campo_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        etiqueta_nombre.setBackground(new java.awt.Color(255, 255, 255));
        etiqueta_nombre.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        etiqueta_nombre.setText("Nombre:");

        campo_correo.setBackground(new java.awt.Color(255, 255, 255));
        campo_correo.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        etiqueta_correo.setBackground(new java.awt.Color(255, 255, 255));
        etiqueta_correo.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        etiqueta_correo.setText("Correo:");

        foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        campo_carg.setBackground(new java.awt.Color(255, 255, 255));
        campo_carg.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        etiqueta_horas.setBackground(new java.awt.Color(255, 255, 255));
        etiqueta_horas.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        etiqueta_horas.setText("Horas:");

        etiqueta_extras.setBackground(new java.awt.Color(255, 255, 255));
        etiqueta_extras.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        etiqueta_extras.setText("Horas extra:");

        campo_horas.setBackground(new java.awt.Color(255, 255, 255));
        campo_horas.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        campo_extras.setBackground(new java.awt.Color(255, 255, 255));
        campo_extras.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        campo_horasDiarias.setBackground(new java.awt.Color(255, 255, 255));
        campo_horasDiarias.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        campo_horasTotales.setBackground(new java.awt.Color(255, 255, 255));
        campo_horasTotales.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        etiqueta_horasTotales.setBackground(new java.awt.Color(255, 255, 255));
        etiqueta_horasTotales.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        etiqueta_horasTotales.setText("Horas mensuales");

        etiqueta_horasRea.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiqueta_horasRea.setText("Horas diarias");

        tabla_fichajesDiario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(tabla_fichajesDiario);
        if (tabla_fichajesDiario.getColumnModel().getColumnCount() > 0) {
            tabla_fichajesDiario.getColumnModel().getColumn(0).setResizable(false);
            tabla_fichajesDiario.getColumnModel().getColumn(1).setResizable(false);
            tabla_fichajesDiario.getColumnModel().getColumn(2).setResizable(false);
            tabla_fichajesDiario.getColumnModel().getColumn(3).setResizable(false);
            tabla_fichajesDiario.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiqueta_correo)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(etiqueta_DNI)
                        .addComponent(etiqueta_nombre)
                        .addComponent(etiqueta_cargo)
                        .addComponent(etiqueta_extras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etiqueta_horas, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(etiqueta_horasTotales)
                    .addComponent(etiqueta_apellidos)
                    .addComponent(etiqueta_horasRea, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(campo_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campo_carg, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campo_horas, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campo_extras, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campo_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campo_apellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                        .addComponent(campo_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campo_horasTotales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(campo_horasDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiqueta_DNI)
                            .addComponent(campo_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etiqueta_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campo_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(etiqueta_apellidos)
                                        .addGap(18, 18, 18)
                                        .addComponent(etiqueta_correo)
                                        .addGap(18, 18, 18)
                                        .addComponent(etiqueta_cargo))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(campo_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(campo_carg, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(etiqueta_horas)
                                    .addComponent(campo_horas, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(etiqueta_extras)
                                    .addComponent(campo_extras, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(etiqueta_horasTotales))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(campo_horasTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(campo_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etiqueta_horasRea)
                            .addComponent(campo_horasDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tabla_fichajesTotales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane3.setViewportView(tabla_fichajesTotales);
        if (tabla_fichajesTotales.getColumnModel().getColumnCount() > 0) {
            tabla_fichajesTotales.getColumnModel().getColumn(0).setResizable(false);
            tabla_fichajesTotales.getColumnModel().getColumn(1).setResizable(false);
            tabla_fichajesTotales.getColumnModel().getColumn(2).setResizable(false);
            tabla_fichajesTotales.getColumnModel().getColumn(3).setResizable(false);
            tabla_fichajesTotales.getColumnModel().getColumn(4).setResizable(false);
        }

        boton_salida.setText("Salida");
        boton_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_salidaActionPerformed(evt);
            }
        });

        boton_ingreso.setText("Ingreso");
        boton_ingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_ingresoActionPerformed(evt);
            }
        });

        combo_mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        combo_mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_mesActionPerformed(evt);
            }
        });

        combo_anios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015", "2016", "2017" }));
        combo_anios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_aniosActionPerformed(evt);
            }
        });

        tabla_festivos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(tabla_festivos);
        if (tabla_festivos.getColumnModel().getColumnCount() > 0) {
            tabla_festivos.getColumnModel().getColumn(0).setResizable(false);
            tabla_festivos.getColumnModel().getColumn(1).setResizable(false);
            tabla_festivos.getColumnModel().getColumn(2).setResizable(false);
            tabla_festivos.getColumnModel().getColumn(3).setResizable(false);
            tabla_festivos.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(combo_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(combo_anios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(boton_ingreso)
                        .addGap(65, 65, 65)
                        .addComponent(boton_salida)))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_ingreso)
                    .addComponent(boton_salida))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_anios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );

        jMenuBar1.setMaximumSize(new java.awt.Dimension(264, 1024));

        Menu_sistema.setText("Sistema");

        cerrar_sesion.setText("Cerrar sesion");
        cerrar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar_sesionActionPerformed(evt);
            }
        });
        Menu_sistema.add(cerrar_sesion);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        Menu_sistema.add(salir);

        boton_ayuda.setText("Ayuda");
        Menu_sistema.add(boton_ayuda);

        jMenuBar1.add(Menu_sistema);

        menu_fichajes.setText("Fichajes");

        iniciar_fichaje.setText("Iniciar fichaje");
        iniciar_fichaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciar_fichajeActionPerformed(evt);
            }
        });
        menu_fichajes.add(iniciar_fichaje);

        finalizar_fichaje.setText("Finalizar fichaje");
        finalizar_fichaje.setToolTipText("");
        finalizar_fichaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizar_fichajeActionPerformed(evt);
            }
        });
        menu_fichajes.add(finalizar_fichaje);

        jMenuBar1.add(menu_fichajes);

        menu_usuarios.setText("Usuarios");

        administrar_usuarios.setText("Administrar Usuarios");
        administrar_usuarios.setEnabled(false);
        administrar_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrar_usuariosActionPerformed(evt);
            }
        });
        menu_usuarios.add(administrar_usuarios);

        cambiar_contrasenia.setLabel("Cambiar Contrasenia");
        cambiar_contrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiar_contraseniaActionPerformed(evt);
            }
        });
        menu_usuarios.add(cambiar_contrasenia);

        jMenuBar1.add(menu_usuarios);

        mnAdministrador.setText("Administrador");
        mnAdministrador.setEnabled(false);

        jMenuBar1.add(mnAdministrador);
        gestion_permisos = new javax.swing.JMenuItem();
       
                gestion_permisos.setText("Festivos");
                gestion_permisos.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        gestion_permisosActionPerformed(evt);
                    }
                });
                mnAdministrador.add(gestion_permisos);
                
                trabajadores_fichaje = new JMenuItem();
                trabajadores_fichaje.setText("Diario personal");
                trabajadores_fichaje.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent evt) {
                		trabajadores_fichajeActionPerformed(evt);
                	}
                });
                mnAdministrador.add(trabajadores_fichaje);

        menu_backup.setText("Copia de seguridad");
        menu_backup.setEnabled(false);

        crear_backup.setText("Exportar copia");
        crear_backup.setToolTipText("");
        crear_backup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_backupActionPerformed(evt);
            }
        });
        menu_backup.add(crear_backup);

        restaurar.setText("Importar Copia");
        restaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurarActionPerformed(evt);
            }
        });
        menu_backup.add(restaurar);

        jMenuBar1.add(menu_backup);
        
        menu_informes.setText("Generar Informe"); 
        informe_mensual.setText("Informe Mensual");
        informe_mensual_usuario.setText("Informe Mensual Usuario");
        menu_informes.add(informe_mensual);
        menu_informes.add(informe_mensual_usuario);
        menu_informes.setEnabled(false);
        jMenuBar1.add(menu_informes);
        
        informe_mensual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					informeMensualActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        
        informe_mensual_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					informeMensualUsuarioActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        
       

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campo_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(693, 693, 693))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(campo_cargo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 611, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


	//Al abrir la ventana actualiza los datos
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarDatos();
        mostrarMenusAdmin();
        llenarDatosFichajes(tabla_fichajesTotales, "TOTAL", null);
        llenarDatosFichajes(tabla_fichajesDiario, "DIARIO", null);
        cargarVacaciones(tabla_festivos, "ENTRADA", null);

        if (tabla_fichajesDiario.getRowCount() > 0) {
            calcularHoras(tabla_fichajesDiario, campo_horasDiarias);
        }
        if (tabla_fichajesTotales.getRowCount() > 0) {
            calcularHoras(tabla_fichajesTotales, campo_horasTotales);
        }
    }//GEN-LAST:event_formWindowOpened
    
    private void informeMensualActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_cerrar_sesionActionPerformed
       generar.generarInformeMensual();
    }//GEN-LAST:event_cerrar_sesionActionPerformed
    
    private void informeMensualUsuarioActionPerformed(java.awt.event.ActionEvent evt) throws Exception{//GEN-FIRST:event_cerrar_sesionActionPerformed
       
    }//GEN-LAST:event_cerrar_sesionActionPerformed

    private void cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar_sesionActionPerformed
        this.dispose();
        Logueo log = new Logueo();
        log.setVisible(true);
    }//GEN-LAST:event_cerrar_sesionActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void cambiar_contraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiar_contraseniaActionPerformed
        Cambiar_contrasenia contra = new Cambiar_contrasenia(usuarioActual);
        contra.setVisible(true);
    }//GEN-LAST:event_cambiar_contraseniaActionPerformed

    private void crear_backupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_backupActionPerformed
        Exportar_backup backup = new Exportar_backup();
        backup.setVisible(true);
    }//GEN-LAST:event_crear_backupActionPerformed

    private void boton_ingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_ingresoActionPerformed
        try {
            fecha = obtenerFecha();
            hora = obtenerHora();
            fecha = fecha + " " + hora;

            resultCons = consultas.getFichajes(usuarioActual.getDni());

            if (resultCons.next() == false) {
                consultas.insertFichaje(usuarioActual.getDni(), fecha, "INGRESO");
                llenarDatosFichajes(tabla_fichajesTotales, "TOTAL", null);
                llenarDatosFichajes(tabla_fichajesDiario, "DIARIO", null);
            } else {
                if (resultCons.getString("TIPO").equals("INGRESO")) {
                    JOptionPane.showMessageDialog(null, "NO SE PUEDE INICIAR UNA ENTRADA, SIN PRODUCIRSE UNA SALIDA");
                } else {
                    if (usuarioActual.getHorasMensualesTraba() >= (usuarioActual.getNumeroHoras()*3600000)) {
                    	
                        JOptionPane.showMessageDialog(null, "SUPERADAS LAS HORAS MENSUALES, NO SE PERMITE REALIZAR HORAS EXTRA");
                    }else{
                    consultas.insertFichaje(usuarioActual.getDni(), fecha, "INGRESO");
                    llenarDatosFichajes(tabla_fichajesTotales, "TOTAL", null);
                    llenarDatosFichajes(tabla_fichajesDiario, "DIARIO", null);
                    }
                }
                consultas.cerrar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_boton_ingresoActionPerformed

    private void boton_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_salidaActionPerformed
        try {
            fecha = obtenerFecha();
            hora = obtenerHora();
            fecha = fecha + " " + hora;
            resultCons = consultas.getFichajes(usuarioActual.getDni());
            if (resultCons.next() == false) {
                JOptionPane.showMessageDialog(null, "NO SE HA PRODUCIDO NINGUNA ENTRADA");
            } else {
                if (resultCons.getString("TIPO").equals("SALIDA")) {
                    JOptionPane.showMessageDialog(null, "NO SE HA PRODUCIDO NINGUNA ENTRADA");
                } else {
                    System.out.println(fecha);
                    consultas.insertFichaje(usuarioActual.getDni(), fecha, "SALIDA");
                    llenarDatosFichajes(tabla_fichajesTotales, "TOTAL", null);
                    llenarDatosFichajes(tabla_fichajesDiario, "DIARIO", null);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_boton_salidaActionPerformed

    private void administrar_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrar_usuariosActionPerformed
        Gestion_Usuarios user = new Gestion_Usuarios();
        user.setVisible(true);
    }//GEN-LAST:event_administrar_usuariosActionPerformed

    private void iniciar_fichajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciar_fichajeActionPerformed
        boton_ingresoActionPerformed(evt);
    }//GEN-LAST:event_iniciar_fichajeActionPerformed

    private void finalizar_fichajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizar_fichajeActionPerformed
        boton_salidaActionPerformed(evt);
    }//GEN-LAST:event_finalizar_fichajeActionPerformed

    private void restaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurarActionPerformed
        Importar_backup backup = new Importar_backup();
        backup.setVisible(true);
    }//GEN-LAST:event_restaurarActionPerformed

    private void combo_mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_mesActionPerformed
        mostrasDatosBusqueda();
        calcularHoras(tabla_fichajesTotales, campo_horasTotales);
    }//GEN-LAST:event_combo_mesActionPerformed

    private void combo_aniosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_aniosActionPerformed
        mostrasDatosBusqueda();
        calcularHoras(tabla_fichajesTotales, campo_horasTotales);
    }//GEN-LAST:event_combo_aniosActionPerformed

    private void gestion_permisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestion_permisosActionPerformed
        Festivos fest = new Festivos();
        fest.setVisible(true);
    }//GEN-LAST:event_gestion_permisosActionPerformed

    private void trabajadores_fichajeActionPerformed(java.awt.event.ActionEvent evt) {
	    Diario_personal consulta_fichajes = new Diario_personal();
	   consulta_fichajes.setVisible(true);    	
	}
    
    public static void main(String args[]) throws SQLException {
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and displaytt the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Menu_sistema;
    private javax.swing.JMenuItem administrar_usuarios;
    private javax.swing.JMenuItem boton_ayuda;
    private javax.swing.JButton boton_ingreso;
    private javax.swing.JButton boton_salida;
    private javax.swing.JMenuItem cambiar_contrasenia;
    public static javax.swing.JLabel campo_DNI;
    private javax.swing.JLabel campo_apellidos;
    private javax.swing.JLabel campo_carg;
    private javax.swing.JLabel campo_cargo;
    private javax.swing.JLabel campo_correo;
    private javax.swing.JLabel campo_extras;
    private javax.swing.JLabel campo_horas;
    private javax.swing.JLabel campo_horasDiarias;
    private javax.swing.JLabel campo_horasTotales;
    private javax.swing.JLabel campo_nombre;
    private javax.swing.JMenuItem cerrar_sesion;
    private javax.swing.JComboBox combo_anios;
    private javax.swing.JComboBox combo_mes;
    private javax.swing.JMenuItem crear_backup;
    private javax.swing.JLabel etiqueta_DNI;
    private javax.swing.JLabel etiqueta_apellidos;
    private javax.swing.JLabel etiqueta_cargo;
    private javax.swing.JLabel etiqueta_correo;
    private javax.swing.JLabel etiqueta_extras;
    private javax.swing.JLabel etiqueta_horas;
    private javax.swing.JLabel etiqueta_horasRea;
    private javax.swing.JLabel etiqueta_horasTotales;
    private javax.swing.JLabel etiqueta_nombre;
    private javax.swing.JMenuItem finalizar_fichaje;
    private javax.swing.JLabel foto;
    private javax.swing.JMenuItem gestion_permisos;
    private javax.swing.JMenuItem iniciar_fichaje;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenu menu_backup;
    private javax.swing.JMenu menu_fichajes;
    private javax.swing.JMenu mnAdministrador;
    private javax.swing.JMenu menu_usuarios;
    private javax.swing.JMenu menu_informes;
    private javax.swing.JMenuItem informe_mensual;
    private javax.swing.JMenuItem informe_mensual_usuario;
    private javax.swing.JMenuItem restaurar;
    private javax.swing.JMenuItem salir;
    private javax.swing.JTable tabla_festivos;
    private javax.swing.JTable tabla_fichajesDiario;
    private javax.swing.JTable tabla_fichajesTotales;
    private JMenuItem trabajadores_fichaje;
    
   
    // End of variables declaration//GEN-END:variables

    private void mostrarMenusAdmin() {
        if (usuarioActual.getCargo().equals("Administrador")) {
            menu_backup.setEnabled(true);
            administrar_usuarios.setEnabled(true);
            mnAdministrador.setEnabled(true);
            menu_informes.setEnabled(true);
        }
    }

    private String obtenerFecha() {
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(date);
        return fecha;
    }

    private String obtenerHora() {
        Calendar calendario = Calendar.getInstance();
        int hora, minutos, segundos;
        String hour;

        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);

        hour = Integer.toString(hora) + ":" + Integer.toString(minutos) + ":" + Integer.toString(segundos);

        return hour;
    }

    private void cargarDatos() {
        byte[] bytesfoto;
        campo_DNI.setText(usuarioActual.getDni());
        campo_nombre.setText(usuarioActual.getNombre());
        campo_apellidos.setText(usuarioActual.getApellidos());
        campo_correo.setText(usuarioActual.getCorreo());
        campo_carg.setText(usuarioActual.getCargo());
        campo_horas.setText(String.valueOf(usuarioActual.getNumeroHoras()));
        campo_extras.setText(usuarioActual.getHorasExtra());

        bytesfoto = usuarioActual.getImagen();
        if (bytesfoto != null) {
            ImageIcon img = new ImageIcon(bytesfoto);
            Icon icon = new ImageIcon(img.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
            foto.setIcon(icon);
        }
    }

    private void calcularHoras(JTable tabla, JLabel campo) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String date;
        int numColumnasFic = tabla.getRowCount();
        long tiempo = 0;
        Date entrada, salida;

        if (numColumnasFic == 1) {
            try {
                entrada = formatter.parse(tabla.getValueAt(0, 2).toString());
                date = obtenerFecha() + " " + obtenerHora();
                salida = formatter.parse(date);
                tiempo = tiempo + (salida.getTime() - entrada.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (numColumnasFic % 2 == 0) {
            for (int i = 0; i < numColumnasFic; i = i + 2) {
                try {
                    entrada = formatter.parse(tabla.getValueAt(i, 2).toString());
                    salida = formatter.parse(tabla.getValueAt(i + 1, 2).toString());
                    tiempo = tiempo + (entrada.getTime() - salida.getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            for (int i = 0; i < numColumnasFic - 1; i = i + 2) {
                try {
                    entrada = formatter.parse(tabla.getValueAt(i, 2).toString());
                    salida = formatter.parse(tabla.getValueAt(i + 1, 2).toString());
                    tiempo = tiempo + (entrada.getTime() - salida.getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                entrada = formatter.parse(tabla.getValueAt(numColumnasFic - 1, 2).toString());
                date = obtenerFecha() + " " + obtenerHora();
                salida = formatter.parse(date);
                tiempo = tiempo + (salida.getTime() - entrada.getTime());
               

            } catch (ParseException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         usuarioActual.setHorasMensualesTraba(tiempo);
         DateFormat df = new SimpleDateFormat("HH 'hours', mm 'mins,' ss 'seconds'");
         df.setTimeZone(TimeZone.getTimeZone("GMT+0"));
         campo.setText(df.format(new Date(tiempo)));
    }

    private void llenarDatosFichajes(JTable tabla, String tipo, String fechaBus) {
        try {
            ResultSetMetaData metaDatos;
            DefaultTableModel modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            String fecha = obtenerFecha();

            if (tipo.equalsIgnoreCase("TOTAL")) {
                String dia, mesAnio;
                StringTokenizer st = new StringTokenizer(fecha, "/");
                dia = st.nextToken();
                mesAnio = st.nextToken();
                mesAnio = mesAnio + "/" + st.nextToken();
                resultCons = consultas.getFichajesUsrMensuales(usuarioActual.getDni(), mesAnio);
            } else if (tipo.equalsIgnoreCase("DIARIO")) {
                resultCons = consultas.getFichajeUsrDiario(usuarioActual.getDni(), fecha);
            } else if (tipo.equalsIgnoreCase("BUSQUEDA")) {
                resultCons = consultas.getFichajesUsrMensuales(usuarioActual.getDni(), fechaBus);
            } else {
                System.out.println("No han mostrado los datos");
            }

            if (resultCons != null) {
                metaDatos = resultCons.getMetaData();

                int columnas = metaDatos.getColumnCount();

                for (int i = 1; i < columnas + 1; i++) {
                    modelo.addColumn(metaDatos.getColumnName(i));
                }

                //Asignar tamanio de las columas
                TableColumn columnaFichae = tabla.getColumn("ID_FICHAJE");
                columnaFichae.setPreferredWidth(5);
                TableColumn columnaDNI = tabla.getColumn("DNI");
                columnaDNI.setPreferredWidth(6);
                TableColumn columnaTipo = tabla.getColumn("TIPO");
                columnaTipo.setPreferredWidth(3);

                while (resultCons.next()) {
                    Object[] fila = new Object[columnas];
                    for (int i = 0; i < columnas; i++) {
                        fila[i] = resultCons.getObject(i + 1);
                    }
                    modelo.addRow(fila);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrasDatosBusqueda() {
        int numMes = combo_mes.getSelectedIndex() + 1;
        
        if(numMes <10){
           String anio = combo_anios.getSelectedItem().toString();
           String mesStrin = "0" +numMes;
           String fecha = mesStrin + "/" + anio;
           llenarDatosFichajes(tabla_fichajesTotales, "BUSQUEDA", fecha);
            cargarVacaciones(tabla_festivos, "BUSQUEDA", fecha);       

        }else{
            String anio = combo_anios.getSelectedItem().toString();
            String fecha = numMes + "/" + anio;
            llenarDatosFichajes(tabla_fichajesTotales, "BUSQUEDA", fecha);
            cargarVacaciones(tabla_festivos, "BUSQUEDA", fecha);
        }  
    }

    private void cargarVacaciones(JTable tabla, String tipo, String fechaBus) {
        try {
            ResultSetMetaData metaDatos;
            DefaultTableModel modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            if (!tipo.equalsIgnoreCase("BUSQUEDA")) {
                String fecha = obtenerFecha();
                String dia, mesAnio;
                StringTokenizer st = new StringTokenizer(fecha, "/");
                dia = st.nextToken();
                mesAnio = st.nextToken();
                mesAnio = mesAnio + "/" + st.nextToken();
                resultCons = consultas.getFestivosUsr(usuarioActual.getDni(), mesAnio);
            } else {
                resultCons = consultas.getFestivosUsr(usuarioActual.getDni(), fechaBus);
            }
            if (resultCons != null) {
                metaDatos = resultCons.getMetaData();
                int columnas = metaDatos.getColumnCount();
                for (int i = 1; i < columnas + 1; i++) {
                    modelo.addColumn(metaDatos.getColumnName(i));
                }
                //Asignar tamanio de las columas

                TableColumn columnaTipo = tabla.getColumn("MOTIVO");
                columnaTipo.setPreferredWidth(6);

                while (resultCons.next()) {
                    Object[] fila = new Object[columnas];
                    for (int i = 0; i < columnas; i++) {
                        fila[i] = resultCons.getObject(i + 1);
                    }
                    modelo.addRow(fila);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
