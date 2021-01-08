/**
 * @author Sandra Paulina Argote Romo
 */

package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    private String usuario, contraseña;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usurio) {
        this.usuario = usurio;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    public int iniciarSesion(String usuario, String contrasena) throws SQLException {
        ResultSet rs;
        int tipo = 0;

        String sql = "select TIPO from USUARIOS where USUARIO='" + usuario + "' and CONTRASENA='" + contrasena + "'";
        Connection con = JavaDB.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            tipo = rs.getInt(1);
        }
        
        JavaDB.getConnection().close();
        return tipo;
    }
}