
package JDBC1.persistencia;

import JDBC1.entidades.familia;

public final class familiaDAO extends DAO {

    public static void guardarFamilia(familia familia) throws Exception {
        try {
            if (familia == null) {
                throw new Exception("usuario vacio");
            }
            String sql = "INSERT TO familias(id, nombre, edad_minima, edad_maxima, num_hijos, email)"
                    + " VALUES('" + familia.getId() + "' , '" + familia.getNombre() + "' , '" + familia.getEdad_minima()
                    + "' , '" + familia.getEdad_maxima() + "' , '" + familia.getNum_hijos() + "' , '" + familia.getEmail();

            inserModElimBD(sql);

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public static void ListarFliamenos3hijos() throws Exception {
        try {
            String sql = "SELECT * FROM familias WHERE num_hijos < 3";
            consultarBD(sql);
            
            while (resultado.next()) {
                System.out.println(resultado.getInt("id_familia") + "|"
                        + resultado.getString("nombre") + "|"
                        + resultado.getInt("edad_maxima") + "|"
                        + resultado.getInt("edad_minima") + "|"
                        + resultado.getInt("num_hijos") + "|"
                        + resultado.getString("email")+"|");
            }
            
            desconectarBase();
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public static void buscarporHotmail() throws Exception {
        try {
            String sql = "SELECT * FROM familias WHERE email LIKE '&@hotmail&'";
            consultarBD(sql);
            
            while (resultado.next()) {
                System.out.println(resultado.getInt("id_familia") + "|"
                        + resultado.getString("nombre") + "|"
                        + resultado.getInt("edad_maxima") + "|"
                        + resultado.getInt("edad_minima") + "|"
                        + resultado.getInt("num_hijos") + "|"
                        + resultado.getString("email")+"|");
            }
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

}
