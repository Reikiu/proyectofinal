/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import static com.sun.faces.util.CollectionsUtils.ar;
import modelo.Proyectos;
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
    Proyectos p;
     int res = 0;
    @Override
    public ArrayList<Object> mostrar() throws ClassNotFoundException, SQLException {
           ArrayList<Object> ar= new ArrayList<>();
          ps=con().prepareStatement("select id,direccion,latitud,longitud,foto from direccion");  
        try {
             
            rs=ps.executeQuery();
            while(rs.next()){
                p = new Proyectos(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                ar.add(p);
            }
        } catch (Exception e) {
          //throw new UnsupportedOperationException(ex.getMessage());
        }finally{
            ps.close();
            con().close();
         
        }
        return ar;
    }
    @Override
    public int insertar(Object ob) throws ClassNotFoundException, SQLException {
       try {
            p = (Proyectos)ob;
            ps = con().prepareStatement("insert into direccion (direccion ,latitud,longitud,foto) values (?,?,?,?)");
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
            p=(Proyectos)ob;
            
            ps=super.con().prepareStatement("update direccion set estado=0 where id=?");
            ps.setInt(1, p.getId());
            res=ps.executeUpdate();
            ps=super.con().prepareStatement("delete from direccion where id=?");
            ps.setInt(1, p.getId());
            res=ps.executeUpdate();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return res;
    }
    
}
