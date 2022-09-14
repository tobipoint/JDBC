/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import tienda.entidades.Fabricante;

/**
 *
 * @author Julian
 */
public final class FabricanteDAO extends DAO{
    
      public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante");
            }

            String sql = "INSERT INTO Fabricante (codigo,nombre)"
                    + "VALUES ( '" + fabricante.getCodigo()+ "' , '" + fabricante.getNombre()+"' );";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
     public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {
        try {

            String sql = "SELECT * FROM Fabricante "
                    + " WHERE nombre = '" + nombre + "'";

            consultarBase(sql);

            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
}
