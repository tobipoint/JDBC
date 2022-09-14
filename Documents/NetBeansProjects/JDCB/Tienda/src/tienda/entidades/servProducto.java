/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.entidades;

import java.util.Collection;
import java.util.Scanner;
import tienda.persistencia.ProductoDAO;

/**
 *
 * @author Julian
 */
public class servProducto {
    private ProductoDAO dao;

    public servProducto() {
        this.dao = new ProductoDAO();
    }
    ServFabricante sf = new ServFabricante();
    
    public Producto crearProducto(int codigo,String nombre,Double precio,int codigo_fabricante) throws Exception {
        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (precio == null || 0==precio) {
                throw new Exception("Debe indicar el precio");
            }
            if (dao.buscarProductoPorNombre(nombre) != null) {
                throw new Exception("Ya existe un producto con el nombre indicado " + nombre);
            }
            if (dao.buscarProductoCodigo(codigo) != null) {
                throw new Exception ("Ya existe un producto con el codigo indicado " + codigo);
            }

            //Creamos el usuario
            Producto producto = new Producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigo_fabricante);
            dao.guardarProducto(producto);
            return producto;
        } catch (Exception e) {
            throw e;
        }
    }
    public void buscarProductoporNombre(String nombre) throws Exception{
        try {
            Producto p = dao.buscarProductoPorNombre(nombre);
            System.out.println("Producto: "+p.getNombre()+" Precio: "+p.getPrecio()+" Codigo: "+p.getCodigo()+" Codigo Fabricante:"+p.getCodigoFabricante());
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarProductos(String nombre) throws Exception{
        try {
            dao.eliminarProducto(nombre);
        } catch (Exception e) {
            throw e;
        }
    }
    public void imprimirListaProductosNombre() throws Exception {
        try {

            //Listamos los productos
            Collection<Producto> productos = dao.listaNombrePrecioProducto();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen usuarios para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println(u.getNombre());
                }
            }
        } catch (Exception e) {
            throw e;
        }
        
    }
    public void imprimirProductoRangoPrecio() throws Exception {
        try {
            if (dao.ejercicioC().isEmpty()) {
                throw new Exception("No hay productos en ese rango de Precio");
            }
            Collection <Producto> rangoPrecio = dao.ejercicioC();
            for (Producto producto : rangoPrecio) {
            System.out.println("Producto: "+producto.getNombre() + "- Precio: "+producto.getPrecio());
        }
            
        } catch (Exception e) {
            throw e;
        }
    }
      public void imprimirProductoPortatiles() throws Exception {
        try {
            if (dao.ejercicioD().isEmpty()) {
                throw new Exception("No hay productos Portatiles");
            }
            Collection <Producto> rangoPrecio = dao.ejercicioD();
            for (Producto producto : rangoPrecio) {
            System.out.println("Producto: "+producto.getNombre());
        }
            
        } catch (Exception e) {
            throw e;
        }
    }
    public void productoMenorPrecio() throws Exception {
        try {
            System.out.println("Producto con menor Precio: ");
            Producto p = dao.ejercicioE();
            System.out.println("Producto: "+p.getNombre()+" Precio: ]"
                    + "" + p.getPrecio());
            
        } catch (Exception e) {
            throw e;
        }
        
    }
      
    public void modificarProducto() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        try {
             Collection<Producto> productos = dao.listaNombrePrecioProducto();
             if (dao.listaNombrePrecioProducto() == null) {
                throw new Exception("La lista de productos esta vacia");
            }
             int codigo = 0,opcion=0;
             for (Producto producto : productos) {
                 System.out.println(producto);
            }
             System.out.println("Dada la siguiente lista, ingrese el codigo del producto que desea modificar");
             codigo=leer.nextInt();
             Producto producto = dao.buscarProductoCodigo(codigo);
             System.out.println("Ingrese 1 para modificar el nombre");
             System.out.println("Ingrese 2 para modificar el precio");
             switch(opcion){
                 case 1:dao.modificarNombre(producto);
                 break;
                 case 2:dao.modificarPrecio(producto);
                 break;
             }
                       
        } catch (Exception e) {
            throw e;
        }
    }
    public void imprimirListaProductos() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = dao.listaNombrePrecioProducto();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen usuarios para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println("Producto: "+u.getNombre() +" - Precio: " + u.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
        public void crearMenu() throws Exception{
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opcion;
        
         do{
            System.out.println("Ingrese la opcion que desea realizar: \n");
            System.out.println("1 Lista el nombre de todos los productos que hay en la tabla producto");
            System.out.println("2 Lista los nombres y los precios de todos los productos de la tabla producto");
            System.out.println("3 Listar aquellos productos que su precio esté entre 120 y 202");
            System.out.println("4 Buscar y listar todos los Portátiles de la tabla producto");
            System.out.println("5 Listar el nombre y el precio del producto más barato");
            System.out.println("6 Ingresar un producto a la base de datos");
            System.out.println("7 Ingresar un fabricante a la base de datos");
            System.out.println("8 Editar un producto con datos a elección.");
            System.out.println("9 para salir");
            opcion = leer.nextInt();
            
            switch(opcion){
                case 1: try {
                    imprimirListaProductosNombre();
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 2: try {
                        imprimirListaProductos();
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 3: try {
                        imprimirProductoRangoPrecio();
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 4: try {
                        imprimirProductoPortatiles();
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 5: try {
                        productoMenorPrecio();
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 6: try {
                    int codigo=0,codigoFab=0; String nombre="",nombreABuscar="";
                    double precio=0;
                    System.out.println("Ingrese el codigo del producto"); codigo=leer.nextInt();
                    System.out.println("Ingrese el nombre del producto"); nombre=leer.next();
                    System.out.println("Ingrese el codigo del fabricante del producto"); codigoFab=leer.nextInt();
                    System.out.println("Ingrese el precio del producto"); precio = leer.nextDouble();
                    crearProducto(codigo, nombre, precio, codigoFab);
                    System.out.println("Ingrese el nombre del producto a buscar en la tabla");nombreABuscar = leer.next();
                    buscarProductoporNombre(nombreABuscar);
                        
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 7: try {
                    int codigoFabricante=0; String name="";
                    System.out.println("Ingrese el nombre del fabricante"); name=leer.next();
                    System.out.println("Ingrese el codigo del fabricante"); codigoFabricante=leer.nextInt();
                        sf.crearFabricante(codigoFabricante, name);
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 8: try {
                    int codigoProducto=0;
                    int opc=0;
                    System.out.println("Ingrese el codigo del producto a modificar");codigoProducto = leer.nextInt();
                    Producto p = dao.buscarProductoCodigo(codigoProducto);
                    System.out.println("Ingrese 1 para modificar el nombre");
                    System.out.println("Ingrese 2 para modificar el precio");
                    opc = leer.nextInt();
                    switch(opc){
                        case 1: System.out.println("Ingrese el nuevo nombre para el producto");
                        p.setNombre(leer.next());
                            dao.modificarNombre(p);
                        break;
                        case 2: System.out.println("Ingrese el nuevo precio para el producto");
                            p.setPrecio(leer.nextDouble());
                            dao.modificarPrecio(p);
                        break; 
                    }
                    } catch (Exception e) { 
                        throw e;
                    }
                    break;
                case 9: System.out.println("Usted decidio salir");
            }
            }while(opcion !=9 && opcion <9);
         
    }
    

    
}
