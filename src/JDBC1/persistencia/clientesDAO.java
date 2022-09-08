
package JDBC1.persistencia;


public class clientesDAO extends DAO {

    public static void clientesyComentarios() throws Exception {

        try {
            String sql = "SELECT distinct  cli.id_cliente, co.comentario, ca.id_casa \n"
                    + "FROM comentarios co, casas ca, estancias e, clientes cli\n"
                    + "WHERE cli.id_cliente = e.id_cliente\n"
                    + "and e.id_casa = ca.id_casa\n"
                    + "and ca.id_casa = co.id_casa ;";
            consultarBD(sql);
            while (resultado.next()) {
                System.out.println(resultado.getInt(1) + "|"
                        + resultado.getString("comentario") + "|"
                        + resultado.getInt(3) + "|");
            }
            desconectarBase();
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }

    }

    public static void ClientesReservas() throws Exception {
        try {
            String sql = "SELECT * FROM clientes, estancias WHERE clientes.id_cliente = estancias.id_cliente";
            consultarBD(sql);

            while (resultado.next()) {
                System.out.println(resultado.getInt("id_cliente") + "|"
                        + resultado.getString("nombre") + " | "
                        + resultado.getString("calle") + " | "
                        + resultado.getInt("numero") + " | "
                        + resultado.getInt("codigo_postal") + " | "
                        + resultado.getString("ciudad") + " | "
                        + resultado.getString("pais") + " | "
                        + resultado.getString("email"));
            }

            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }

    }

}
