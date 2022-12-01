package clothingsystem.accesoadatos;


import java.util.*;
import java.sql.*;
import clothingsystem.entidadesdenegocio.*; // Agregar la referencia al proyecto de entidades de negocio y poder utilizar las entidades de Rol y Usuario
import java.time.LocalDate; 

/**
 *
 * @author BNRA
 */
public class CategoriaDAL {

    // Metodo para obtener los campos a utilizar en la consulta SELECT de la tabla de Categoria
    static String obtenerCampos() {
        return "c.Id,c.Nombre,c.Descripcion, c.FechaCreacion, c.Estatus, c.Comentario";
    }

    // Metodo para obtener el SELECT a la tabla Categoria y el TOP en el caso que se utilice una base de datos SQL SERVER
    private static String obtenerSelect(Categoria pCategoria) {
            String sql;
        sql = "SELECT ";
        if (pCategoria.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.TipoDB.SQLSERVER) {
             // Agregar el TOP a la consulta SELECT si el gestor de base de datos es SQL SERVER y getTop_aux es mayor a cero
            sql += "TOP " + pCategoria.getTop_aux() + " ";
        }
        sql += (obtenerCampos() + " FROM Categoria c");
        return sql;
    }   
    // Metodo para obtener Order by a la consulta SELECT de la tabla Categoria y ordene los registros de mayor a menor 
    private static String agregarOrderBy(Categoria pCategoria) {
        String sql = " ORDER BY c.Id DESC";
        if (pCategoria.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.TipoDB.MYSQL) {
            // Agregar el LIMIT a la consulta SELECT de la tabla de Categoria en el caso que getTop_aux() sea mayor a cero y el gestor de base de datos
            // sea MYSQL
            sql += " LIMIT " + pCategoria.getTop_aux() + " ";
        }
        return sql;
    }
    // Metodo para poder insertar un nuevo registro en la tabla de Categoria
    public static int crear(Categoria pCategoria) throws Exception {
        int result;
        String sql;
        try ( Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            sql = "INSERT INTO Categoria(Nombre,Descripcion,FechaCreacion,Estatus,Comentario) VALUES(?,?,?,?,?)";
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                ps.setString(1, pCategoria.getNombre()); // Agregar el parametro a la consulta donde estan el simbolo ? #1  
                ps.setString(2, pCategoria.getDescripcion()); // agregar el parametro a la consulta donde estan el simbolo "?" #3 
                           ps.setDate(3, java.sql.Date.valueOf(LocalDate.now())); // agregar el parametro a la consulta donde estan el simbolo "?" #7 
     ps.setByte(4, pCategoria.getEstatus()); // agregar el parametro a la consulta donde estan el simbolo "?" #6 

                ps.setString(5, pCategoria.getComentario()); // agregar el parametro a la consulta donde estan el simbolo "?" #4 

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

    // Metodo para poder actualizar un registro en la tabla de Categoria
    public static int modificar(Categoria pCategoria) throws Exception {
        int result;
        String sql;
        try ( Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            sql = "UPDATE  Categoria SET Nombre=?, Descripcion=?, FechaCreacion=?, Estatus=?, Comentario=? WHERE Id=?";
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                ps.setString(1, pCategoria.getNombre()); // Agregar el parametro a la consulta donde estan el simbolo ? #2  
                ps.setString(2, pCategoria.getDescripcion()); // agregar el parametro a la consulta donde estan el simbolo "?" #3 
                ps.setDate(3, java.sql.Date.valueOf(LocalDate.now())); // agregar el parametro a la consulta donde estan el simbolo "?" #7 
                ps.setByte(4, pCategoria.getEstatus()); // agregar el parametro a la consulta donde estan el simbolo "?" #6 
                ps.setString(5, pCategoria.getComentario()); // agregar el parametro a la consulta donde estan el simbolo "?" #4 
                ps.setInt(6, pCategoria.getId()); // agregar el parametro a la consulta donde estan el simbolo ? #6  
   result = ps.executeUpdate();
                ps.close();
            } catch (SQLException ex){
                throw ex;
            }
            conn.close();
        }
        catch (SQLException ex){
            throw ex;
        }
        return result;
    }

    // Metodo para poder eliminar un registro en la tabla de Categoria
    public static int eliminar(Categoria pCategoria) throws Exception {
      int result;
        String sql;
        try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            sql = "DELETE FROM Categoria WHERE Id=?"; //definir la consulta DELETE a la tabla de Categoria utilizando el simbolo ? para enviar parametros
            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) {  // obtener el PreparedStatement desde la clase ComunDB
                ps.setInt(1, pCategoria.getId()); // agregar el parametro a la consulta donde estan el simbolo ? #1 
                result = ps.executeUpdate(); // ejecutar la consulta DELETE en la base de datos
                ps.close(); // cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex; // enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // cerrar la conexion a la base de datos
        }
        catch (SQLException ex) {
            throw ex;  // enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda 
        }
        return result; // Retornar el numero de fila afectadas en el DELETE en la base de datos 
    }


    // Metodo para llenar las propiedades de la entidad de Categoria con los datos que viene en el ResultSet,
    // el metodo nos ayudara a no preocuparlos por los indices al momento de obtener los valores del ResultSet
    static int asignarDatosResultSet(Categoria pCategoria, ResultSet pResultSet, int pIndex) throws Exception {
        //  SELECT c.Id(indice 1),c.Nombre(indice 2) * FROM Categoria
        // c.Id,c.Nombre,c.Descripcion, c.FechaCreacion, c.Estatus, c.Comentario
        pIndex++;
        pCategoria.setId(pResultSet.getInt(pIndex)); // index 1
        pIndex++;
        pCategoria.setNombre(pResultSet.getString(pIndex)); // index 2
           pIndex++;
        pCategoria.setDescripcion(pResultSet.getString(pIndex)); // index 3
        pIndex++;
        pCategoria.setFechaCreacion(pResultSet.getDate(pIndex).toLocalDate()); // index 4 
         pIndex++;
        pCategoria.setEstatus(pResultSet.getByte(pIndex)); // index 6
           pIndex++;
        pCategoria.setComentario(pResultSet.getString(pIndex)); // index 5
       

        return pIndex;
    }

    // Metodo para  ejecutar el ResultSet de la consulta SELECT a la tabla de Categoria 
    private static void obtenerDatos(PreparedStatement pPS, ArrayList<Categoria> pCategorias) throws Exception {
        try ( ResultSet resultSet = ComunDB.obtenerResultSet(pPS);) { // obtener el ResultSet desde la clase ComunDB
            while (resultSet.next()) { // Recorrer cada una de la fila que regresa la consulta  SELECT de la tabla Categoria
                Categoria categoria = new Categoria();
                asignarDatosResultSet(categoria, resultSet, 0); // Llenar las propiedaddes de la Entidad Categoria con los datos obtenidos de la fila en el ResultSet
                pCategorias.add(categoria); // Agregar la entidad Rol al ArrayList de Categoria
            }
            resultSet.close(); // Cerrar el ResultSet
        } catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener ResultSet de la clase ComunDB   en el caso que suceda 
        }
    }

    // Metodo para obtener por Id un registro de la tabla de Categoria 
    public static Categoria obtenerPorId(Categoria pCategoria) throws Exception {
       Categoria categoria = new Categoria();
        ArrayList<Categoria> categorias = new ArrayList();
        try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(pCategoria); // obtener la consulta SELECT de la tabla Categoria
             // Concatenar a la consulta SELECT de la tabla Categoria el WHERE  para comparar el campo Id
            sql += " WHERE c.Id=?";
            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // obtener el PreparedStatement desde la clase ComunDB
                ps.setInt(1, pCategoria.getId()); // agregar el parametro a la consulta donde estan el simbolo ? #1 
                obtenerDatos(ps, categorias); // Llenar el ArrayList de Categoria con las fila que devolvera la consulta SELECT a la tabla de Usuario
                ps.close(); // cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex; // enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // cerrar la conexion a la base de datos
        }
        catch (SQLException ex) {
            throw ex; // enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        if (categorias.size() > 0) { // verificar si el ArrayList de Categoria trae mas de un registro en tal caso solo debe de traer uno
            categoria = categorias.get(0); // Si el ArrayList de Categoria trae un registro o mas obtenemos solo el primero
        }
        return categoria; // devolver el Categoria encontrado por Id 
    }
    // Metodo para obtener todos los registro de la tabla de Categoria
    public static ArrayList<Categoria> obtenerTodos() throws Exception {
        ArrayList<Categoria> categorias;
        categorias = new ArrayList<>();
        try ( Connection conn = ComunDB.obtenerConexion();) {// Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(new Categoria());  // Obtener la consulta SELECT de la tabla Categoria
            sql += agregarOrderBy(new Categoria());  // Concatenar a la consulta SELECT de la tabla Categoria el ORDER BY por Id 
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                obtenerDatos(ps, categorias); // Llenar el ArrayList de Rol con las fila que devolvera la consulta SELECT a la tabla de Categoria
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex; // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // Cerrar la conexion a la base de datos
        } catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        return categorias; // Devolver el ArrayList de Categoria
    }

    // Metodo para asignar los filtros de la consulta SELECT de la tabla de Categoria de forma dinamica
    static void querySelect(Categoria pCategoria, ComunDB.UtilQuery pUtilQuery) throws SQLException {
        PreparedStatement statement = pUtilQuery.getStatement(); // Obtener el PreparedStatement al cual aplicar los parametros
        if (pCategoria.getId() > 0) { // Verificar si se va incluir el campo Id en el filtro de la consulta SELECT de la tabla de Categoria
            pUtilQuery.AgregarWhereAnd(" c.Id=? "); // Agregar el campo Id al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Id a la consulta SELECT de la tabla de Categoria
                statement.setInt(pUtilQuery.getNumWhere(), pCategoria.getId());
            }
        }
        // Verificar si se va incluir el campo Nombre en el filtro de la consulta SELECT de la tabla de Categoria
        if (pCategoria.getNombre() != null && pCategoria.getNombre().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" c.Nombre LIKE ? "); // Agregar el campo Nombre al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Nombre a la consulta SELECT de la tabla de Categoria
                statement.setString(pUtilQuery.getNumWhere(), "%" + pCategoria.getNombre() + "%");
            }
        }
        // Verificar si se va incluir el campo Descripcion en el filtro de la consulta SELECT de la tabla de Categoria
        if (pCategoria.getDescripcion() != null && pCategoria.getDescripcion().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" c.Descripcion LIKE ? "); // agregar el campo Descripcion al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // agregar el parametro del campo Descripcion a la consulta SELECT de la tabla de Descripcion
                statement.setString(pUtilQuery.getNumWhere(), "%" + pCategoria.getDescripcion() + "%");
            }
        }

        // Verificar si se va incluir el campo Estatus en el filtro de la consulta SELECT de la tabla de Categoria
        if (pCategoria.getEstatus() > 0) {
            pUtilQuery.AgregarWhereAnd(" c.Estatus=? "); // agregar el campo Estatus al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // agregar el parametro del campo Estatus a la consulta SELECT de la tabla de Usuario
                statement.setInt(pUtilQuery.getNumWhere(), pCategoria.getEstatus());
            }
        }
    }

    // Metodo para obtener todos los registro de la tabla de Categoria que cumplan con los filtros agregados 
    // a la consulta SELECT de la tabla de Categoria 
    public static ArrayList<Categoria> buscar(Categoria pCategoria) throws Exception {
        ArrayList<Categoria> categorias = new ArrayList();
        try ( Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(pCategoria); // Obtener la consulta SELECT de la tabla Categoria
            ComunDB comundb = new ComunDB();
            ComunDB.UtilQuery utilQuery = comundb.new UtilQuery(sql, null, 0);
            querySelect(pCategoria, utilQuery); // Asignar el filtro a la consulta SELECT de la tabla de Categoria 
            sql = utilQuery.getSQL();
            sql += agregarOrderBy(pCategoria); // Concatenar a la consulta SELECT de la tabla Categoria el ORDER BY por Id
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                utilQuery.setStatement(ps);
                utilQuery.setSQL(null);
                utilQuery.setNumWhere(0);
                querySelect(pCategoria, utilQuery);  // Asignar los parametros al PreparedStatement de la consulta SELECT de la tabla de Rol
                obtenerDatos(ps, categorias); // Llenar el ArrayList de Categoria con las fila que devolvera la consulta SELECT a la tabla de Rol
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex;  // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // Cerrar la conexion a la base de datos
        } catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        return categorias; // Devolver el ArrayList de Categoria
    }
}
