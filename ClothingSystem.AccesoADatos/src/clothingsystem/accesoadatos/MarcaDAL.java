package clothingsystem.accesoadatos;

import java.util.*; // Utilizar la utileria de java https://docs.oracle.com/javase/8/docs/api/java/util/package-summary.html
import java.sql.*;
import clothingsystem.entidadesdenegocio.*; // Agregar la referencia al proyecto de entidades de negocio y poder utilizar las entidades de Marca y Usuario

public class MarcaDAL { // Clase para poder realizar consulta de Insertar, modificar, eliminar, obtener datos de la tabla Marca

    // Metodo para obtener los campos a utilizar en la consulta SELECT de la tabla de Marca
    static String obtenerCampos() {
        return "m.Id, m.Nombre, m.Estatus, m.Descripcion, m.PaisOrigen";
    }

    // Metodo para obtener el SELECT a la tabla Marca y el TOP en el caso que se utilice una base de datos SQL SERVER
    private static String obtenerSelect(Marca pMarca) {
        String sql;
        sql = "SELECT ";
        if (pMarca.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.TipoDB.SQLSERVER) {
            // Agregar el TOP a la consulta SELECT si el gestor de base de datos es SQL SERVER y "getTop_aux" es mayor a cero
            sql += "TOP " + pMarca.getTop_aux() + " ";
        }
        sql += (obtenerCampos() + " FROM Marca m"); // Agregar los campos de la tabla de Rol mas el FROM a la tabla Marca con su alias "r"
        return sql;
    }

    // Metodo para obtener Order by a la consulta SELECT de la tabla Marca y ordene los registros de mayor a menor 
    private static String agregarOrderBy(Marca pMarca) {
        String sql = " ORDER BY m.Id DESC";
        if (pMarca.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.TipoDB.MYSQL) {
            // Agregar el LIMIT a la consulta SELECT de la tabla de Marca en el caso que getTop_aux() sea mayor a cero y el gestor de base de datos
            // sea MYSQL
            sql += " LIMIT " + pMarca.getTop_aux() + " ";
        }
        return sql;
    }

    // Metodo para poder insertar un nuevo registro en la tabla de Marca
    public static int crear(Marca pMarca) throws Exception {
        int result;
        String sql;
        try ( Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            sql = "INSERT INTO Marca(Nombre, Estatus, Descripcion, PaisOrigen) VALUES(?,?,?,?)"; // Definir la consulta INSERT a la tabla de Rol utilizando el simbolo ? para enviar parametros
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                ps.setString(1, pMarca.getNombre()); // Agregar el parametro a la consulta donde estan el simbolo ? #1  
                ps.setByte(2, pMarca.getEstatus());
                ps.setString(3, pMarca.getDescripcion());
                ps.setString(4, pMarca.getPaisOrigen());
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
    public static int modificar(Marca pMarca) throws Exception {
        int result;
        String sql;
        try ( Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            sql = "UPDATE Marca SET Nombre=?, Estatus=?, Descripcion=?, PaisOrigen=? WHERE Id=?"; // Definir la consulta UPDATE a la tabla de Marca utilizando el simbolo ? para enviar parametros
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                ps.setString(1, pMarca.getNombre()); // Agregar el parametro a la consulta donde estan el simbolo ? #1  
                ps.setByte(2, pMarca.getEstatus());
                ps.setString(3, pMarca.getDescripcion());
                ps.setString(4, pMarca.getPaisOrigen());
                ps.setInt(5, pMarca.getId()); // Agregar el parametro a la consulta donde estan el simbolo ? #2  
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

    // Metodo para poder eliminar un registro en la tabla de Marca
    public static int eliminar(Marca pMarca) throws Exception {
        int result;
        String sql;
        try ( Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            sql = "DELETE FROM Marca WHERE Id=?";  // Definir la consulta DELETE a la tabla de Marca utilizando el simbolo ? para enviar parametros
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                ps.setInt(1, pMarca.getId()); // Agregar el parametro a la consulta donde estan el simbolo ? #1 
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

    // Metodo para llenar las propiedades de la entidad de Marca con los datos que viene en el ResultSet,
    // el metodo nos ayudara a no preocuparlos por los indices al momento de obtener los valores del ResultSet
    static int asignarDatosResultSet(Marca pMarca, ResultSet pResultSet, int pIndex) throws Exception {
        //  SELECT r.Id(indice 1),r.Nombre(indice 2) * FROM Rol
        pIndex++;
        pMarca.setId(pResultSet.getInt(pIndex)); // index 1
        pIndex++;
        pMarca.setNombre(pResultSet.getString(pIndex)); // index 2
        pIndex++;
        pMarca.setEstatus(pResultSet.getByte(pIndex));
        pIndex++;
        pMarca.setDescripcion(pResultSet.getString(pIndex));
        pIndex++;
        pMarca.setPaisOrigen(pResultSet.getString(pIndex));
        return pIndex;
    }

    // Metodo para  ejecutar el ResultSet de la consulta SELECT a la tabla de Marca 
    private static void obtenerDatos(PreparedStatement pPS, ArrayList<Marca> pMarcas) throws Exception {
        try ( ResultSet resultSet = ComunDB.obtenerResultSet(pPS);) { // obtener el ResultSet desde la clase ComunDB
            while (resultSet.next()) { // Recorrer cada una de la fila que regresa la consulta  SELECT de la tabla Marca
                Marca marca = new Marca();
                asignarDatosResultSet(marca, resultSet, 0); // Llenar las propiedaddes de la Entidad Marca con los datos obtenidos de la fila en el ResultSet
                pMarcas.add(marca); // Agregar la entidad Rol al ArrayList de Marca
            }
            resultSet.close(); // Cerrar el ResultSet
        } catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener ResultSet de la clase ComunDB   en el caso que suceda 
        }
    }

    // Metodo para obtener por Id un registro de la tabla de Marca 
    public static Marca obtenerPorId(Marca pMarca) throws Exception {
        Marca marca = new Marca();
        ArrayList<Marca> marcas = new ArrayList();
        try ( Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(pMarca); // Obtener la consulta SELECT de la tabla Marca
            sql += " WHERE r.Id=?"; // Concatenar a la consulta SELECT de la tabla Rol el WHERE 
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                ps.setInt(1, pMarca.getId()); // Agregar el parametro a la consulta donde estan el simbolo ? #1 
                obtenerDatos(ps, marcas); // Llenar el ArrayList de Rol con las fila que devolvera la consulta SELECT a la tabla de Marca
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex;  // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close();  // Cerrar la conexion a la base de datos
        } catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        if (marcas.size() > 0) { // Verificar si el ArrayList de Rol trae mas de un registro en tal caso solo debe de traer uno
            marca = marcas.get(0); // Si el ArrayList de Rol trae un registro o mas obtenemos solo el primero 
        }
        return marca; // Devolver el marca encontrado por Id 
    }

    // Metodo para obtener todos los registro de la tabla de Marca
    public static ArrayList<Marca> obtenerTodos() throws Exception {
        ArrayList<Marca> marcas;
        marcas = new ArrayList<>();
        try ( Connection conn = ComunDB.obtenerConexion();) {// Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(new Marca());  // Obtener la consulta SELECT de la tabla Marca
            sql += agregarOrderBy(new Marca());  // Concatenar a la consulta SELECT de la tabla Marca el ORDER BY por Id 
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                obtenerDatos(ps, marcas); // Llenar el ArrayList de Marca con las fila que devolvera la consulta SELECT a la tabla de Marca
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex; // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // Cerrar la conexion a la base de datos
        } catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        return marcas; // Devolver el ArrayList de Marca
    }

    // Metodo para asignar los filtros de la consulta SELECT de la tabla de Marca de forma dinamica
    static void querySelect(Marca pMarca, ComunDB.UtilQuery pUtilQuery) throws SQLException {
        PreparedStatement statement = pUtilQuery.getStatement(); // Obtener el PreparedStatement al cual aplicar los parametros
        if (pMarca.getId() > 0) { // Verificar si se va incluir el campo Id en el filtro de la consulta SELECT de la tabla de Marca
            pUtilQuery.AgregarWhereAnd(" r.Id=? "); // Agregar el campo Id al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Id a la consulta SELECT de la tabla de Marca
                statement.setInt(pUtilQuery.getNumWhere(), pMarca.getId());
            }
        }
        // Verificar si se va incluir el campo Nombre en el filtro de la consulta SELECT de la tabla de Marca
        if (pMarca.getNombre() != null && pMarca.getNombre().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" r.Nombre LIKE ? "); // Agregar el campo Nombre al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Nombre a la consulta SELECT de la tabla de Marca
                statement.setString(pUtilQuery.getNumWhere(), "%" + pMarca.getNombre() + "%");
            }
        }
        
        // Verificar si se va incluir el campo Nombre en el filtro de la consulta SELECT de la tabla de Marca
        if (pMarca.getDescripcion() != null && pMarca.getDescripcion().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" r.Descripcion LIKE ? "); // Agregar el campo Nombre al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Nombre a la consulta SELECT de la tabla de Marca
                statement.setString(pUtilQuery.getNumWhere(), "%" + pMarca.getDescripcion() + "%");
            }
        }
        
        // Verificar si se va incluir el campo Nombre en el filtro de la consulta SELECT de la tabla de Marca
        if (pMarca.getPaisOrigen() != null && pMarca.getPaisOrigen().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" r.PaisOrigen LIKE ? "); // Agregar el campo Nombre al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Nombre a la consulta SELECT de la tabla de Marca
                statement.setString(pUtilQuery.getNumWhere(), "%" + pMarca.getPaisOrigen() + "%");
            }
        }
    }

    // Metodo para obtener todos los registro de la tabla de Marca que cumplan con los filtros agregados 
    // a la consulta SELECT de la tabla de Marca 
    public static ArrayList<Marca> buscar(Marca pMarca) throws Exception {
        ArrayList<Marca> marcas = new ArrayList();
        try ( Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(pMarca); // Obtener la consulta SELECT de la tabla Marca
            ComunDB comundb = new ComunDB();
            ComunDB.UtilQuery utilQuery = comundb.new UtilQuery(sql, null, 0);
            querySelect(pMarca, utilQuery); // Asignar el filtro a la consulta SELECT de la tabla de Marca 
            sql = utilQuery.getSQL();
            sql += agregarOrderBy(pMarca); // Concatenar a la consulta SELECT de la tabla Marca el ORDER BY por Id
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                utilQuery.setStatement(ps);
                utilQuery.setSQL(null);
                utilQuery.setNumWhere(0);
                querySelect(pMarca, utilQuery);  // Asignar los parametros al PreparedStatement de la consulta SELECT de la tabla de Marca
                obtenerDatos(ps, marcas); // Llenar el ArrayList de Rol con las fila que devolvera la consulta SELECT a la tabla de Marca
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex;  // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // Cerrar la conexion a la base de datos
        } catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        return marcas; // Devolver el ArrayList de Marca
    }
}
