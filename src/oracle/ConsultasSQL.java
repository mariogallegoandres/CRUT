package oracle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import usuarios.Usuario;

public class ConsultasSQL {

    OracleConection conexionBD;

    public ConsultasSQL() {
        conexionBD = new OracleConection();
    }

    public void cerrar() {
        try {
            conexionBD.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getContrasenia(String DNI) {
        try {
            ResultSet resultados = conexionBD.consultar("SELECT CONTRASENIA FROM USUARIOS WHERE DNI =" + DNI);
            if (resultados.next()) {
                return resultados.getString("CONTRASENIA");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Usuario getUsuario(String DNI) {

        try {
            ResultSet consulta = conexionBD.consultar("SELECT * FROM USUARIOS WHERE DNI =" + DNI);
            consulta.next();
            String nombre = consulta.getString("NOMBRE");
            String apellidos = consulta.getString("APELLIDOS");
            String correo = consulta.getString("CORREO");
            String cargo = consulta.getString("CARGO");
            String extras = consulta.getString("EXTRAS");
            String password = consulta.getString("CONTRASENIA");
            int horas = consulta.getInt("HORAS");
            byte[] imagen = this.getFoto(DNI);

            return new Usuario(nombre, apellidos, DNI, password, cargo, correo, horas, extras, imagen);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public byte[] getFoto(String DNI) {
        byte[] bytesleidos = null;
        try {
            ResultSet consulta = conexionBD.consultar("SELECT FOTO FROM USUARIOS WHERE FOTO IS NOT NULL AND DNI =" + DNI);
            if (consulta.next()) {
                Blob bytesImagen = consulta.getBlob("FOTO");
                bytesleidos = bytesImagen.getBytes(1, (int) bytesImagen.length());
            }
            return bytesleidos;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet getFichajes(String DNI) {

        try {
            return conexionBD.consultar("SELECT * FROM FICHAJES WHERE DNI =" + DNI + " ORDER BY ID_FICHAJE DESC");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ResultSet getUsuarios() {
        try {
            return conexionBD.consultar("SELECT * FROM USUARIOS");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public ResultSet getUsuariosDNI() {
        try {
            return conexionBD.consultar("SELECT DNI FROM USUARIOS");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet getFichajesUsrMensuales(String DNI, String fecha) {
        try {
            return conexionBD.consultar("select ID_FICHAJE,DNI, TO_CHAR(FECHA,'dd/MM/yyyy hh24:mi:ss') AS FECHA ,tipo FROM FICHAJES where to_char(fecha,'MM/YYYY')='" + fecha + "' and DNI= " + DNI + " order by FECHA DESC");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet getFichajeUsrDiario(String DNI, String fecha) {
        try {
            return conexionBD.consultar("SELECT ID_FICHAJE,DNI, TO_CHAR(FECHA,'dd/MM/yyyy hh24:mi:ss') AS FECHA,TIPO FROM FICHAJES WHERE DNI =" + DNI + " AND TRUNC (FECHA) = TO_DATE ('" + fecha + "', 'DD/MM/YYYY') ORDER BY FECHA DESC");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet getFichajes() {
        try {
            return conexionBD.consultar("SELECT ID_FICHAJE,DNI, TO_CHAR(FECHA,'dd/MM/yyyy hh24:mi:ss') AS FECHA,TIPO FROM FICHAJES  ORDER BY ID_FICHAJE DESC");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet getFestivosUsr(String DNI, String fecha) {
        try {
        	if(fecha.length() ==10){
        		return conexionBD.consultar("SELECT  TO_CHAR(FECHA,'dd/MM/yyyy') AS FECHA,MOTIVO FROM FESTIVOS WHERE DNI=" + DNI + " and to_char(fecha,'DD/MM/YYYY')='" + fecha + "'");
        	}else{
        		return conexionBD.consultar("SELECT  TO_CHAR(FECHA,'dd/MM/yyyy') AS FECHA,MOTIVO FROM FESTIVOS WHERE DNI=" + DNI + " and to_char(fecha,'MM/YYYY')='" + fecha + "'");
        	}
        	} catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet getFestivos() {
        try {
            return conexionBD.consultar("SELECT ID_FESTIVO,DNI, TO_CHAR(FECHA,'dd/MM/yyyy'), MOTIVO FROM FESTIVOS");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet getUsuariosPuestos(String fecha) {
        try {
            return conexionBD.consultar("SELECT DNI, TIPO, FECHA FROM FICHAJES WHERE TRUNC (FECHA) = TO_DATE ('" + fecha + "', 'DD/MM/YYYY') ORDER BY FECHA DESC");
       
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet getDNINombre(String DNI) {
        try {
            return conexionBD.consultar("SELECT DNI, NOMBRE  FROM USUARIOS WHERE DNI =" +DNI);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public boolean insertFichaje(String DNI, String fecha, String tipo) {
        try {
            return conexionBD.ejecutar("INSERT INTO FICHAJES (DNI,FECHA,TIPO) VALUES('" + DNI + "',TO_DATE('" + fecha + "','DD/MM/YYYY HH24:MI:SS'),'" + tipo + "')");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean insertFestivo(String DNI, String fecha, String motivo) {
        try {
            return conexionBD.ejecutar("INSERT INTO FESTIVOS (DNI,FECHA,MOTIVO) VALUES('" + DNI + "',TO_DATE('" + fecha + "','DD/MM/YYYY HH24:MI:SS'),'" + motivo + "')");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean insertUsuario(String DNI, String contrasenia, String nombre, String apellidos, String cargo, String correo, int horas, String extras) {
        try {
            return conexionBD.ejecutar("INSERT INTO  USUARIOS (DNI,CONTRASENIA,NOMBRE,APELLIDOS,CARGO,CORREO,HORAS,EXTRAS)  VALUES ('" + DNI + "','" + contrasenia + "','" + nombre + "','" + apellidos + "','" + cargo + "','" + correo + "'," + horas + ",'" + extras + "')");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateUsuario(String DNI, String nombre, String apellidos, String cargo, String correo, int horas, String extras) {
        try {
            return conexionBD.ejecutar("UPDATE USUARIOS SET NOMBRE ='" + nombre + "',APELLIDOS='" + apellidos + "',CARGO= '" + cargo + "',CORREO='" + correo + "', HORAS =" + horas + ", EXTRAS='" + extras + "' WHERE DNI= " + DNI);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updatePass(String DNI, String contrasenia) {
        try {
            return conexionBD.ejecutar("UPDATE USUARIOS SET CONTRASENIA= '" + contrasenia + "' WHERE DNI= " + DNI);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void updateFoto(String DNI, String urlFoto) {

        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement("update USUARIOS set FOTO=? where DNI=" + DNI);
            File fBlob = new File(urlFoto);
            FileInputStream is = new FileInputStream(fBlob);
            ps.setBinaryStream(1, is, (int) fBlob.length());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean deleteDatabase(String database) {
        try {
            return conexionBD.ejecutar("DELETE FROM " + database);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteUsuario(String DNI) {
        try {
            return conexionBD.ejecutar("DELETE FROM USUARIOS WHERE DNI=" + DNI);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
