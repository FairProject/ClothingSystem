package clothingsystem.accesoadatos;

import java.util.*; // Utilizar la utileria de java https://docs.oracle.com/javase/8/docs/api/java/util/package-summary.html
import java.sql.*;
import clothingsystem.entidadesdenegocio.*; // Agregar la referencia al proyecto de entidades de negocio y poder utilizar las entidades de Rol y Usuario

public class RopaFotoDAL {
    // Metodo para obtener los campos a utilizar en la consulta SELECT de la tabla de Rol

    static String obtenerCampos() {
        return "r.Id,r.Url";
    }

    // Metodo para obtener el SELECT a la tabla RopaFoto y el TOP en el caso que se utilice una base de datos SQL SERVER
    private static String obtenerSelect(RopaFoto pRopaFoto) {
        String sql;
        sql = "SELECT ";
        if (pRopaFoto.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.TipoDB.SQLSERVER) {
            // Agregar el TOP a la consulta SELECT si el gestor de base de datos es SQL SERVER y "getTop_aux" es mayor a cero
            sql += "TOP " + pRopaFoto.getTop_aux() + " ";
        }
        sql += (obtenerCampos() + " FROM RopaFoto r"); // Agregar los campos de la tabla de RopaFoto mas el FROM a la tabla RopaFoto con su alias "r"
        return sql;
    }

    // Metodo para obtener Order by a la consulta SELECT de la tabla RopaFoto y ordene los registros de mayor a menor 
    private static String agregarOrderBy(RopaFoto pRopaFoto) {
        String sql = " ORDER BY r.Id DESC";
        if (pRopaFoto.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.TipoDB.MYSQL) {
            // Agregar el LIMIT a la consulta SELECT de la tabla de RopaFoto en el caso que getTop_aux() sea mayor a cero y el gestor de base de datos
            // sea MYSQL
            sql += " LIMIT " + pRopaFoto.getTop_aux() + " ";
        }
        return sql;
    }

    // Metodo para poder insertar un nuevo registro en la tabla de RopaFoto
    public static int crear(RopaFoto pRopaFoto) throws Exception {
        int result;
        String sql;
        try ( Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            sql = "INSERT INTO RopaFoto(Url) VALUES(?)"; // Definir la consulta INSERT a la tabla de RopaFotoRopaFoto utilizando el simbolo ? para enviar parametros
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                ps.setString(1, pRopaFoto.getUrl()); // Agregar el parametro a la consulta donde estan el simbolo ? #1  
                result = ps.executeUpdate(); // Ejecutar la consulta INSERT en la base de datos
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex; // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda 
            }
            conn.close(); // Cerrar la conexion a la base de datos
        } catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion en el caso que suceda 
        }
        return result; // Retornar el numero de fila afectadas en el INSERT en la base de datos 
    }

    // Metodo para poder actualizar un registro en la tabla de Rol
    public static int modificar(RopaFoto pRopaFoto) throws Exception {
        int result;
        String sql;
        try ( Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            sql = "UPDATE RopaFoto SET Url=? WHERE Id=?"; // Definir la consulta UPDATE a la tabla de RopaFoto utilizando el simbolo ? para enviar parametros
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                ps.setString(1, pRopaFoto.getUrl()); // Agregar el parametro a la consulta donde estan el simbolo ? #1  
                ps.setInt(2, pRopaFoto.getId()); // Agregar el parametro a la consulta donde estan el simbolo ? #2  
                result = ps.executeUpdate(); // Ejecutar la consulta UPDATE en la base de datos
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex;  // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda 
            }
            conn.close(); // Cerrar la conexion a la base de datos
        } catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion en el caso que suceda 
        }
        return result; // Retornar el numero de fila afectadas en el UPDATE en la base de datos 
    }

    // Metodo para poder eliminar un registro en la tabla de RopaFoto
    public static int eliminar(RopaFoto pRopaFoto) throws Exception {
        int result;
        String sql;
        try ( Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            sql = "DELETE FROM RopaFoto WHERE Id=?";  // Definir la consulta DELETE a la tabla de Rol utilizando el simbolo ? para enviar parametros
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                ps.setInt(1, pRopaFoto.getId()); // Agregar el parametro a la consulta donde estan el simbolo ? #1 
                result = ps.executeUpdate();  // Ejecutar la consulta DELETE en la base de datos
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex; // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close();  // Cerrar la conexion a la base de datos
        } catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda 
        }
        return result; // Retornar el numero de fila afectadas en el DELETE en la base de datos 
    }

    // Metodo para llenar las propiedades de la entidad de RopaFoto con los datos que viene en el ResultSet,
    // el metodo nos ayudara a no preocuparlos por los indices al momento de obtener los valores del ResultSet
    static int asignarDatosResultSet(RopaFoto pRopaFoto, ResultSet pResultSet, int pIndex) throws Exception {
        //  SELECT r.Id(indice 1),r.Url(indice 2) * FROM RopaFoto
        pIndex++;
        pRopaFoto.setId(pResultSet.getInt(pIndex)); // index 1
        pIndex++;
        pRopaFoto.setUrl(pResultSet.getString(pIndex)); // index 2
        return pIndex;
    }

    // Metodo para  ejecutar el ResultSet de la consulta SELECT a la tabla de RopaFoto 
    private static void obtenerDatos(PreparedStatement pPS, ArrayList<RopaFoto> pRoles) throws Exception {
        try ( ResultSet resultSet = ComunDB.obtenerResultSet(pPS);) { // obtener el ResultSet desde la clase ComunDB
            while (resultSet.next()) { // Recorrer cada una de la fila que regresa la consulta  SELECT de la tabla RopaFoto
                RopaFoto ropafoto = new RopaFoto();
                asignarDatosResultSet(ropafoto, resultSet, 0); // Llenar las propiedaddes de la Entidad RopaFoto con los datos obtenidos de la fila en el ResultSet
                pRoles.add(ropafoto); // Agregar la entidad Rol al ArrayList de Rol
            }
            resultSet.close(); // Cerrar el ResultSet
        } catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener ResultSet de la clase ComunDB   en el caso que suceda 
        }
    }

    // Metodo para obtener por Id un registro de la tabla de RopaFoto 
    public static RopaFoto obtenerPorId(RopaFoto pRopaFoto) throws Exception {
        RopaFoto ropafoto = new RopaFoto();
        ArrayList<RopaFoto> RopaFoto = new ArrayList();
        try ( Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(pRopaFoto); // Obtener la consulta SELECT de la tabla Rol
            sql += " WHERE r.Id=?"; // Concatenar a la consulta SELECT de la tabla Rol el WHERE 
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                ps.setInt(1, pRopaFoto.getId()); // Agregar el parametro a la consulta donde estan el simbolo ? #1 
                obtenerDatos(ps, RopaFoto); // Llenar el ArrayList de Rol con las fila que devolvera la consulta SELECT a la tabla de Rol
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex;  // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close();  // Cerrar la conexion a la base de datos
        } catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        return ropafoto; // Devolver el ropafoto encontrado por Id 
    }

    // Metodo para obtener todos los registro de la tabla de RopaFoto
    public static ArrayList<RopaFoto> obtenerTodos() throws Exception {
        ArrayList<RopaFoto> RopaFoto;
        RopaFoto = new ArrayList<>();
        try ( Connection conn = ComunDB.obtenerConexion();) {// Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(new RopaFoto());  // Obtener la consulta SELECT de la tabla RopaFoto
            sql += agregarOrderBy(new RopaFoto());  // Concatenar a la consulta SELECT de la tabla RopaFoto el ORDER BY por Id 
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                obtenerDatos(ps, RopaFoto); // Llenar el ArrayList de Rol con las fila que devolvera la consulta SELECT a la tabla de Rol
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex; // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // Cerrar la conexion a la base de datos
        } catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        return RopaFoto; // Devolver el ArrayList de RopaFoto
    }

    // Metodo para asignar los filtros de la consulta SELECT de la tabla de RopaFoto de forma dinamica
    static void querySelect(RopaFoto pRopaFoto, ComunDB.UtilQuery pUtilQuery) throws SQLException {
        PreparedStatement statement = pUtilQuery.getStatement(); // Obtener el PreparedStatement al cual aplicar los parametros
        if (pRopaFoto.getId() > 0) { // Verificar si se va incluir el campo Id en el filtro de la consulta SELECT de la tabla de Rol
            pUtilQuery.AgregarWhereAnd(" r.Id=? "); // Agregar el campo Id al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Id a la consulta SELECT de la tabla de RopaFoto
                statement.setInt(pUtilQuery.getNumWhere(), pRopaFoto.getId());
            }
        }
        // Verificar si se va incluir el campo url en el filtro de la consulta SELECT de la tabla de RopaFoto
        if (pRopaFoto.getUrl() != null && pRopaFoto.getUrl().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" r.Nombre LIKE ? "); // Agregar el campo Nombre al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo url a la consulta SELECT de la tabla de RopaFoto
                statement.setString(pUtilQuery.getNumWhere(), "%" + pRopaFoto.getUrl() + "%");
            }
        }
    }

    // Metodo para obtener todos los registro de la tabla de RopaFoto que cumplan con los filtros agregados 
    // a la consulta SELECT de la tabla de RopaFoto 
    public static ArrayList<RopaFoto> buscar(RopaFoto pRopaFoto) throws Exception {
        ArrayList<RopaFoto> ropafoto = new ArrayList();
        try ( Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(pRopaFoto); // Obtener la consulta SELECT de la tabla RopaFoto
            ComunDB comundb = new ComunDB();
            ComunDB.UtilQuery utilQuery = comundb.new UtilQuery(sql, null, 0);
            querySelect(pRopaFoto, utilQuery); // Asignar el filtro a la consulta SELECT de la tabla de RopaFoto 
            sql = utilQuery.getSQL();
            sql += agregarOrderBy(pRopaFoto); // Concatenar a la consulta SELECT de la tabla RopaFoto el ORDER BY por Id
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                utilQuery.setStatement(ps);
                utilQuery.setSQL(null);
                utilQuery.setNumWhere(0);
                obtenerDatos(ps, ropafoto); // Llenar el ArrayList de Rol con las fila que devolvera la consulta SELECT a la tabla de Rol
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex;  // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // Cerrar la conexion a la base de datos
        } catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        return ropafoto; // Devolver el ArrayList de RopaFoto
    }

}
