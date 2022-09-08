
package JDBC1.persistencia;

import JDBC1.entidades.casas;

public class casasDAO extends DAO {

    public casas casasDisponibles() throws Exception {

        try {
            String sql = "SELECT * FROM casas";

            consultarBD(sql);
            casas casas = null;
            while (resultado.next()) {
                casas.setId_casa(resultado.getInt(1));
                casas.setNumero(resultado.getInt(2));
                casas.setCiudad(resultado.getString(3));
                casas.setPais(resultado.getString(4));
            }
            desconectarBase();
            return casas;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public static void casaPorPaises() throws Exception {

        try {
            String sql = "Select id_casa, codigo_postal, calle, precio_habitacion, tipo_vivienda, count(*) FROM casas group by pais";
            consultarBD(sql);

            while (resultado.next()) {
                System.out.println(resultado.getInt("id_casa") + "|"
                        + resultado.getInt("codigo_postal") + "|"
                        + resultado.getString("calle") + "|"
                        + resultado.getInt("precio_habitacion") + "|"
                        + resultado.getString("tipo_vivienda") + "|"
                        + resultado.getInt("count(*)"));
            }

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }

    }

    public static void precioActualizado() throws Exception {

        try {

            String sql1 = "Select precio_habitacion FROM casas WHERE pais = 'Reino Unido";
            consultarBD(sql1);
            casas casa = null;

            while (resultado.next()) {
                casa = new casas();
                casa.setPrecio_habitacion(resultado.getInt(1));
            }
            desconectarBase();
            String sql = "UPDATE casa SET "
                    + "precio_habitacion = '" + ((5 * casa.getPrecio_habitacion()) / 100) + "' WHERE pais = 'Reino Unido'";

            inserModElimBD(sql);
        } catch (Exception e) {
            throw e;
        }

    }

    public static void casaLimpiasRU() throws Exception {
        try {

            String sql = "SELECT  ca.id_casa, ca.calle, ca.ciudad,pais, ca.tipo_vivienda, co.comentario \n"
                    + "FROM casas ca, comentarios co\n"
                    + "WHERE ca.id_casa = co.id_casa\n"
                    + "and co.comentario LIKE '%limpia%'";
            consultarBD(sql);

            while (resultado.next()) {
                System.out.println(resultado.getInt("id_casa") + " | "
                        + resultado.getString("calle") + " |"
                        + resultado.getString("ciudad") + " |"
                        + resultado.getString("pais") + " |"
                        + resultado.getString("tipo_vivienda") + " | "
                        + resultado.getString("tipo_vivienda") + " | "
                        + resultado.getString("comentario") + " | ");
            }
            desconectarBase();
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

}
