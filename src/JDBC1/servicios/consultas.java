
package JDBC1.servicios;

import JDBC1.persistencia.clientesDAO;
import JDBC1.persistencia.familiaDAO;
import JDBC1.persistencia.casasDAO;
import java.util.Scanner;


public class consultas {

    public void consultas() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("ELIJA UNA OPCION A BUSCAR");

        System.out.println("familias con 3 o mas hijos (1)" + "\n"
                + "disponible entre el 1 de agosto de 31 de agosto de 2020 en Reino Unido (2)" + "\n"
                + "@hotmail (3)" + "\n"
                + "fecha desde... (4)" + "\n"
                + "clientes que han reservado antes y descipcion de la casa (5)" + "\n"
                + "datos de clientes que ya han reservado(6)" + "\n"
                + "precios de las casas de reino unido actualizado (7)" + "\n"
                + "cantidad de casas por pais (8) " + "\n"
                + "casas limpias de reino unido (9)" + "\n"
                + "insertar datos de estancias con disponibilidad en x fecha (10)" + "\n"
                + "salir (11)");
        
        int op = leer.nextInt();

        do {
            switch (op) {
                case 1:
                    try {
                        familiaDAO.ListarFliamenos3hijos();
                    } catch (Exception e) {
                        throw new Exception("no se pudo ejecutar");
                    }
                    break;
                case 2:
                    try {

                    } catch (Exception e) {
                        throw new Exception("no se pudo ejecutar");
                    }
                    break;
                case 3:
                    try {
                        familiaDAO.buscarporHotmail();
                    } catch (Exception e) {
                        throw new Exception("no se pudo ejecutar");
                    }
                    break;

                case 4:
                    try {

                    } catch (Exception e) {
                        throw new Exception("no se pudo ejecutar");
                    }
                    break;
                case 5:
                    try {
                        clientesDAO.clientesyComentarios();
                    } catch (Exception e) {
                        throw new Exception("no se pudo ejecutar");
                    }
                    break;

                case 6:
                    try {
                        clientesDAO.ClientesReservas();
                    } catch (Exception e) {
                        throw new Exception("no se pudo ejecutar");
                    }
                    break;
                case 7:
                    try {
                      casasDAO.precioActualizado();
                    } catch (Exception e) {
                        throw new Exception("no se pudo ejecutar");
                    }
                    break;
                case 8:
                    try {
                        casasDAO.casaPorPaises();
                    } catch (Exception e) {
                        throw new Exception("no se pudo ejecutar");
                    }
                    break;
                case 9:
                    try {
                     casasDAO.casaLimpiasRU();
                    } catch (Exception e) {
                        throw new Exception("no se pudo ejecutar");
                    }
                    break;
                case 10:
                    try {
                        System.out.println("ingrese que fecha quiere buscar disponibilidad");
                        
                    } catch (Exception e) {
                        throw new Exception("no se pudo ejecutar");
                    }
                    break;
            }

        } while (op != 11);

    }
    
    
}


