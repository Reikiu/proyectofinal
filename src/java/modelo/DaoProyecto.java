/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import static com.sun.faces.util.CollectionsUtils.ar;
import modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class DaoProyecto extends  Conexion implements crud{
   PreparedStatement ps;
    ResultSet rs;
    Proyecto p;
     int res = 0;

    @Override
    public ArrayList<Object> mostrar() throws ClassNotFoundException, SQLException {
          ArrayList<Object> ar= new ArrayList<Object>();
        try {
       ps=super.con().prepareStatement("select idProyecto, direccion, latitud, foto longitud from proyecto");  
            rs=ps.executeQuery();
            while(rs.next()){
                //p=new Proyecto(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
                ar.add(p);
            }
        } catch (Exception ex) {
        
        }
        return ar;
    }

    @Override
    public int insertar(Object ob) throws ClassNotFoundException, SQLException {
       try {
            p = (Proyecto)ob;
            ps = con().prepareStatement("insert into proyecto (direccion ,idCliente, latitud, longitud, foto, estadoActual) values (?,17,?,?,?, 'No Iniciado')");
            ps.setString(1, p.getDireccion());
            ps.setString(2, p.getLatitud());
            ps.setString(3, p.getLongitud());
            ps.setString(4, p.getFoto());
            
            res = ps.executeUpdate();                    
           
        } catch (Exception ex) {         
           
        }        
        
        return res;
    }
        @Override
    public int modificar(Object ob) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Object ob) throws ClassNotFoundException, SQLException {
         try {
            p=(Proyecto)ob;
            
            ps=super.con().prepareStatement("update proyecto set estado=0 where idProyecto=?");
            ps.setInt(1, p.getIdProyecto());
            res=ps.executeUpdate();
            ps=super.con().prepareStatement("delete from proyecto where idProyecto=?");
            ps.setInt(1, p.getIdProyecto());
            res=ps.executeUpdate();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return res;
    }
    
}
