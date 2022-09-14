/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;

/**
 *
 * @author Julian
 */
public final class ProductoDAO extends DAO{
    public void asd() throws Exception{
        try {
            String sql = "SELECT nombre FROM PRODUCTO";
            consultarBase(sql);
            while (resultado.next()) {                
                System.out.println(resultado.getString("nombre"));
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
    
     public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto");
            }

            String sql = "INSERT INTO Producto (codigo,nombre,precio,codigo_fabricante)"
                    + "VALUES ( '" + producto.getCodigo()+ "' , '" + producto.getNombre() + "','" + producto.getPrecio()+ "' , '" + producto.getCodigoFabricante()+"' );";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
     }
    public void eliminarProducto(String nombre) throws Exception {
        try {

            String sql = "DELETE FROM Producto WHERE nombre = '" + nombre + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarPrecio(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el codigo del producto que desea modificar");
            }

            String sql = "UPDATE Producto SET "
                    + "precio = '" + producto.getPrecio()+ "' WHERE codigo = '" + producto.getCodigo()+ "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    public void modificarNombre(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el codigo del producto que desea modificar");
            }

            String sql = "UPDATE Producto SET "
                    + "nombre = '" + producto.getNombre() + "' WHERE codigo = '" + producto.getCodigo()+ "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
     public void modificarCodigoFabricante(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el nombre del producto que desea modificar");
            }

            String sql = "UPDATE Producto SET "
                    + "codigo = '" + producto.getCodigo() + "' WHERE nombre = '" + producto.getNombre()+ "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
     public Producto buscarProductoCodigo(Integer codigo) throws Exception {
        try {

            String sql = "SELECT * FROM Producto "
                    + " WHERE codigo = '" + codigo + "'";

            consultarBase(sql);

            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    
    

    public Producto buscarProductoPorNombre(String nombre) throws Exception {
        try {

            String sql = "SELECT * FROM Producto "
                    + " WHERE nombre = '" + nombre + "'";

            consultarBase(sql);

            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Producto buscarProductoPorPrecio(Integer precio) throws Exception {
        try {

            String sql = "SELECT * FROM Producto "
                    + " WHERE precio = '" + precio + "'";

            consultarBase(sql);

            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listaNombrePrecioProducto() throws Exception {
        try {
            String sql = "SELECT * FROM Producto ";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                 producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    public Collection<Producto> ejercicioC() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM Producto "
                    + " WHERE precio BETWEEN 120 and 202;";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
         public Collection<Producto> ejercicioD() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM Producto "
                    + " WHERE nombre LIKE '%Portatil%'";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> portatiles = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                portatiles.add(producto);
            }
            desconectarBase();
            return portatiles;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    
    
    }
        public Producto ejercicioE() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM Producto "
                    + " WHERE precio = (SELECT min(precio) FROM Producto)";

            consultarBase(sql);

            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    
    
    }
        
    
 }

