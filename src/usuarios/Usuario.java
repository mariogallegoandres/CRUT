/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import java.util.Arrays;

public class Usuario {

    private static final int TAMMD5 = 32;

    private String nombre;
    private String apellidos;
    private String dni;
    private String password;
    private String cargo;
    private String correo;
    private int numeroHoras;
    private String horasExtra;
    private byte[] imagen;
    private long horasMensualesTraba;

    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String dni, String password, String cargo, String correo, int numeroHoras, String horasExtra, byte[] imagen) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.password = password;
        this.cargo = cargo;
        this.correo = correo;
        this.numeroHoras = numeroHoras;
        this.horasExtra = horasExtra;
        if (imagen != null) {
            this.imagen = Arrays.copyOf(imagen, imagen.length);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public String getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(String horasExtra) {
        this.horasExtra = horasExtra;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = Arrays.copyOf(imagen, imagen.length);
    }

     public long getHorasMensualesTraba() {
        return horasMensualesTraba;
    }
    public void setHorasMensualesTraba(long horas){
     this.horasMensualesTraba=horas;
    }
}
