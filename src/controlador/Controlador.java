package controlador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Libro;
import java.util.ArrayList;

public class Controlador {
    Connection conexion = null;
    Statement sentencia = null;
        
    private void conectar(){
        try{
            String controlador = "com.mysql.jdbc.Driver";
            Class.forName(controlador).newInstance();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al cargar el controlador.");
        }
        
        String url = "jdbc:mysql://localhost/libros";
        String usuario = "root";
        String password = "";
        
        try{
            conexion = (Connection) DriverManager.getConnection(url, usuario, password); 
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            sentencia = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void ingresarDatos(Libro l){
        conectar();
        
        try{
            String consulta = "Insert into libro(titulo, autor, editorial, Npaginas, precio, ISBN) values('" +
                    l.getTitulo() + "','" + l.getNombreAutor() + "','" + l.getEditorial() + "','" + l.getNumeroPaginas() + 
                    "','" + l.getPrecio() + "','" + l.getISBN() +  "')";
            sentencia.execute(consulta);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList devolverLibro(int isbn){
        conectar();
        ArrayList<String> libro = new ArrayList<>();
        try{
            String consulta = "Select * from libro where ISBN = " + isbn ;
            ResultSet r = sentencia.executeQuery(consulta);
            while(r.next()){
                libro.add(r.getString("titulo"));
                libro.add(r.getString("autor"));
                libro.add(r.getString("editorial"));
                libro.add(String.valueOf(r.getInt("Npaginas")));
                libro.add(String.valueOf(r.getFloat("precio")));
                libro.add(String.valueOf(r.getInt("ISBN")));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return libro;
    }
    
    public int eliminarLibro(int isbn){
        conectar();
        int x = 0;
        try{
            String consulta = "delete from libro where isbn = " + isbn;
            x = sentencia.executeUpdate(consulta);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return x;
    }
    
    public int editarDatos(Libro l, int isbn){
        conectar();
        int x = 0;
        try{
            String consulta = "UPDATE libro SET " 
                    + " titulo = '" + l.getTitulo() + "', "
                    + " autor = '" + l.getNombreAutor() + "', "
                    + " editorial = '" + l.getEditorial() + "', "
                    + " Npaginas = " + l.getNumeroPaginas() + ", "
                    + " precio = " + l.getPrecio() + " "
                    + " WHERE ISBN = " + isbn + ";";
            x = sentencia.executeUpdate(consulta);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return x;
    }
    
}
