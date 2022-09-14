/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.entidades;

import tienda.persistencia.FabricanteDAO;

/**
 *
 * @author Julian
 */
public class ServFabricante {
    private FabricanteDAO dao;

    public ServFabricante() {
        this.dao = new FabricanteDAO();
    }
    
    
     public void crearFabricante(Integer codigo,String nombre) throws Exception {
        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (codigo == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el codigo");
            }
            if (dao.buscarFabricantePorNombre(nombre) != null) {
                throw new Exception("Ya existe un fabricante con el nombre indicado " + nombre);
            }

            //Creamos el usuario
            Fabricante fabricante = new Fabricante();
            fabricante.setNombre(nombre);
            fabricante.setCodigo(codigo);
            dao.guardarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }
     
    
}
