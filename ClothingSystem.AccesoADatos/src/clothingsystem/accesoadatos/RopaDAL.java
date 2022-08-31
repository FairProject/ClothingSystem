package clothingsystem.accesoadatos;

import java.util.*; // Utilizar la utileria de java https://docs.oracle.com/javase/8/docs/api/java/util/package-summary.html
import java.sql.*;
import clothingsystem.entidadesdenegocio.*; // Agregar la referencia al proyecto de entidades de negocio y poder utilizar las entidades de Rol y Usuario

public class RopaDAL { // Clase para poder realizar consulta de Insertar, modificar, eliminar, obtener datos de la tabla Rol

    // Metodo para obtener los campos a utilizar en la consulta SELECT de la tabla de Rol
    static String obtenerCampos() {
        return "r.Id, r.IdMarca, r.CodigoBarra, r.Nombre, r.PrecioCompra, r.PrecioVenta, r.Existencia, r.Estatus, r.Talla, r.Color, r.Estilo, r.Descripcion, r.TipoTela";
    }

    // Metodo para obtener el SELECT a la tabla Rol y el TOP en el caso que se utilice una base de datos SQL SERVER
    private static String obtenerSelect(Ropa pRopa) {
        String sql;
        sql = "SELECT ";
        if (pRopa.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.TipoDB.SQLSERVER) {
            // Agregar el TOP a la consulta SELECT si el gestor de base de datos es SQL SERVER y "getTop_aux" es mayor a cero
            sql += "TOP " + pRopa.getTop_aux() + " ";
        }
        sql += (obtenerCampos() + " FROM Ropa r"); // Agregar los campos de la tabla de Rol mas el FROM a la tabla Rol con su alias "r"
        return sql;
    }

    // Metodo para obtener Order by a la consulta SELECT de la tabla Rol y ordene los registros de mayor a menor 
    private static String agregarOrderBy(Ropa pRopa) {
        String sql = " ORDER BY r.Id DESC";
        if (pRopa.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.TipoDB.MYSQL) {
            // Agregar el LIMIT a la consulta SELECT de la tabla de Rol en el caso que getTop_aux() sea mayor a cero y el gestor de base de datos
            // sea MYSQL
            sql += " LIMIT " + pRopa.getTop_aux() + " ";
        }
        return sql;
    }

    // Metodo para poder insertar un nuevo registro en la tabla de Rol
    public static int crear(Ropa pRopa) throws Exception {
        int result;
        String sql;
        try ( Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            sql = "INSERT INTO Ropa(IdMarca,CodigoBarra,Nombre,PrecioCompra,PrecioVenta,Existencia,Estatus,Talla,Color,Estilo,Descripcion,TipoTela) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)"; // Definir la consulta INSERT a la tabla de Rol utilizando el simbolo ? para enviar parametros
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                ps.setInt(1, pRopa.getIdMarca());
                ps.setString(2, pRopa.getCodigoBarra());
                ps.setString(3, pRopa.getNombre());
                ps.setDouble(4, pRopa.getPrecioCompra());
                ps.setDouble(5, pRopa.getPrecioVenta());
                ps.setInt(6, pRopa.getExistencia());
                ps.setByte(7, pRopa.getEstatus());
                ps.setString(8, pRopa.getTalla());
                ps.setString(9, pRopa.getColor());
                ps.setString(10, pRopa.getEstilo());
                ps.setString(11, pRopa.getDescripcion());
                ps.setString(12, pRopa.getTipoTela());
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
    public static int modificar(Ropa pRopa) throws Exception {
        int result;
        String sql;
        try ( Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            sql = "UPDATE Ropa SET IdMarca=?, CodigoBarra=?, Nombre=?, PrecioCompra=?, PrecioVenta=?, Existencia=?, Estatus=?, Talla=?, Color=?, Estilo=?, Descripcion=?, TipoTela=? WHERE Id=?"; // Definir la consulta UPDATE a la tabla de Rol utilizando el simbolo ? para enviar parametros
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                ps.setInt(1, pRopa.getIdMarca());
                ps.setString(2, pRopa.getCodigoBarra());
                ps.setString(3, pRopa.getNombre());
                ps.setDouble(4, pRopa.getPrecioCompra());
                ps.setDouble(5, pRopa.getPrecioVenta());
                ps.setInt(6, pRopa.getExistencia());
                ps.setByte(7, pRopa.getEstatus());
                ps.setString(8, pRopa.getTalla());
                ps.setString(9, pRopa.getColor());
                ps.setString(10, pRopa.getEstilo());
                ps.setString(11, pRopa.getDescripcion());
                ps.setString(12, pRopa.getTipoTela());
                ps.setInt(13, pRopa.getId());
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

    // Metodo para poder eliminar un registro en la tabla de Rol
    public static int eliminar(Ropa pRopa) throws Exception {
        int result;
        String sql;
        try ( Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            sql = "DELETE FROM Ropa WHERE Id=?";  // Definir la consulta DELETE a la tabla de Rol utilizando el simbolo ? para enviar parametros
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                ps.setInt(1, pRopa.getId());
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

    // Metodo para llenar las propiedades de la entidad de Rol con los datos que viene en el ResultSet,
    // el metodo nos ayudara a no preocuparlos por los indices al momento de obtener los valores del ResultSet
    static int asignarDatosResultSet(Ropa pRopa, ResultSet pResultSet, int pIndex) throws Exception {
        //  SELECT r.Id(indice 1),r.Nombre(indice 2) * FROM Rol
        pIndex++;
        pRopa.setId(pResultSet.getInt(pIndex)); // index 1
        pIndex++;
        pRopa.setIdMarca(pResultSet.getInt(pIndex)); // index 2
        pIndex++;
        pRopa.setNombre(pResultSet.getString(pIndex)); // index 3
        pIndex++;
        pRopa.setCodigoBarra(pResultSet.getString(pIndex)); // index 4
        pIndex++;
        pRopa.setPrecioCompra(pResultSet.getDouble(pIndex)); // index 5
        pIndex++;
        pRopa.setPrecioVenta(pResultSet.getDouble(pIndex)); // index 6
        pIndex++;
        pRopa.setExistencia(pResultSet.getInt(pIndex)); // index 7
        pIndex++;
        pRopa.setEstatus(pResultSet.getByte(pIndex)); // index 8
        pIndex++;
        pRopa.setTalla(pResultSet.getString(pIndex)); // index 9
        pIndex++;
        pRopa.setColor(pResultSet.getString(pIndex)); // index 10       
        pIndex++;
        pRopa.setEstilo(pResultSet.getString(pIndex)); // index 11     
        pIndex++;
        pRopa.setDescripcion(pResultSet.getString(pIndex)); // index 12    
        pIndex++;
        pRopa.setTipoTela(pResultSet.getString(pIndex)); // index 13     
        return pIndex;
    }

    // Metodo para  ejecutar el ResultSet de la consulta SELECT a la tabla de Rol 
    private static void obtenerDatos(PreparedStatement pPS, ArrayList<Ropa> pRopas) throws Exception {
        try ( ResultSet resultSet = ComunDB.obtenerResultSet(pPS);) { // obtener el ResultSet desde la clase ComunDB
            while (resultSet.next()) { // Recorrer cada una de la fila que regresa la consulta  SELECT de la tabla Rol
                Ropa ropa = new Ropa();
                asignarDatosResultSet(ropa, resultSet, 0); // Llenar las propiedaddes de la Entidad Rol con los datos obtenidos de la fila en el ResultSet
                pRopas.add(ropa); // Agregar la entidad Rol al ArrayList de Rol
            }
            resultSet.close(); // Cerrar el ResultSet
        } catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener ResultSet de la clase ComunDB   en el caso que suceda 
        }
    }
    
    // Metodo para  ejecutar el ResultSet de la consulta SELECT a la tabla de Usuario y JOIN a la tabla de Rol
    private static void obtenerDatosIncluirMarca(PreparedStatement pPS, ArrayList<Ropa> pRopas) throws Exception {
        try (ResultSet resultSet = ComunDB.obtenerResultSet(pPS);) { // obtener el ResultSet desde la clase ComunDB
            HashMap<Integer, Marca> marcaMap = new HashMap(); //crear un HashMap para automatizar la creacion de instancias de la clase Rol
            while (resultSet.next()) { // Recorrer cada una de la fila que regresa la consulta  SELECT de la tabla Usuario JOIN a la tabla de Rol
                Ropa ropa = new Ropa();
                 // Llenar las propiedaddes de la Entidad Usuario con los datos obtenidos de la fila en el ResultSet
                int index = asignarDatosResultSet(ropa, resultSet, 0);
                if (marcaMap.containsKey(ropa.getIdMarca()) == false) { // verificar que el HashMap aun no contenga el Rol actual
                    Marca marca = new Marca();
                    // en el caso que el Rol no este en el HashMap se asignara
                    MarcaDAL.asignarDatosResultSet(marca, resultSet, index);
                    marcaMap.put(marca.getId(), marca); // agregar el Rol al  HashMap
                    ropa.setMarca(marca); // agregar el Rol al Usuario
                } else {
                    // En el caso que el Rol existe en el HashMap se agregara automaticamente al Usuario
                   ropa.setMarca(marcaMap.get(ropa.getIdMarca())); 
                }
                pRopas.add(ropa); // Agregar el Usuario de la fila actual al ArrayList de Usuario
            }
            resultSet.close(); // cerrar el ResultSet
        } catch (SQLException ex) {
            throw ex; // enviar al siguiente metodo el error al obtener ResultSet de la clase ComunDB   en el caso que suceda 
        }
    }

    // Metodo para obtener por Id un registro de la tabla de Rol 
    public static Ropa obtenerPorId(Ropa pRopa) throws Exception {
        Ropa ropa = new Ropa();
        ArrayList<Ropa> ropas = new ArrayList();
        try ( Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(pRopa); // Obtener la consulta SELECT de la tabla Rol
            sql += " WHERE r.Id=?"; // Concatenar a la consulta SELECT de la tabla Rol el WHERE 
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                ps.setInt(1, pRopa.getId()); // Agregar el parametro a la consulta donde estan el simbolo ? #1 
                obtenerDatos(ps, ropas); // Llenar el ArrayList de Rol con las fila que devolvera la consulta SELECT a la tabla de Rol
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex;  // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close();  // Cerrar la conexion a la base de datos
        } catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        if (ropas.size() > 0) { // Verificar si el ArrayList de Rol trae mas de un registro en tal caso solo debe de traer uno
            ropa = ropas.get(0); // Si el ArrayList de Rol trae un registro o mas obtenemos solo el primero 
        }
        return ropa; // Devolver el rol encontrado por Id 
    }

    // Metodo para obtener todos los registro de la tabla de Rol
    public static ArrayList<Ropa> obtenerTodos() throws Exception {
        ArrayList<Ropa> ropas;
        ropas = new ArrayList<>();
        try ( Connection conn = ComunDB.obtenerConexion();) {// Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(new Ropa());  // Obtener la consulta SELECT de la tabla Rol
            sql += agregarOrderBy(new Ropa());  // Concatenar a la consulta SELECT de la tabla Rol el ORDER BY por Id 
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                obtenerDatos(ps, ropas); // Llenar el ArrayList de Rol con las fila que devolvera la consulta SELECT a la tabla de Rol
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex; // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // Cerrar la conexion a la base de datos
        } catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        return ropas; // Devolver el ArrayList de Rol
    }

    // Metodo para asignar los filtros de la consulta SELECT de la tabla de Rol de forma dinamica
    static void querySelect(Ropa pRopa, ComunDB.UtilQuery pUtilQuery) throws SQLException {
        PreparedStatement statement = pUtilQuery.getStatement(); // Obtener el PreparedStatement al cual aplicar los parametros
        if (pRopa.getId() > 0) { // Verificar si se va incluir el campo Id en el filtro de la consulta SELECT de la tabla de Rol
            pUtilQuery.AgregarWhereAnd(" r.Id=? "); // Agregar el campo Id al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Id a la consulta SELECT de la tabla de Rol
                statement.setInt(pUtilQuery.getNumWhere(), pRopa.getId());
            }
        }

        if (pRopa.getIdMarca() > 0) { // Verificar si se va incluir el campo Id en el filtro de la consulta SELECT de la tabla de Rol
            pUtilQuery.AgregarWhereAnd(" r.IdMarca=? "); // Agregar el campo Id al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Id a la consulta SELECT de la tabla de Rol
                statement.setInt(pUtilQuery.getNumWhere(), pRopa.getIdMarca());
            }
        }
        // Verificar si se va incluir el campo Nombre en el filtro de la consulta SELECT de la tabla de Rol
        if (pRopa.getCodigoBarra() != null && pRopa.getCodigoBarra().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" r.CodigoBarra LIKE ? "); // Agregar el campo Nombre al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Nombre a la consulta SELECT de la tabla de Rol
                statement.setString(pUtilQuery.getNumWhere(), "%" + pRopa.getCodigoBarra() + "%");
            }
        }

        if (pRopa.getNombre() != null && pRopa.getNombre().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" r.Nombre LIKE ? "); // Agregar el campo Nombre al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Nombre a la consulta SELECT de la tabla de Rol
                statement.setString(pUtilQuery.getNumWhere(), "%" + pRopa.getNombre() + "%");
            }
        }

        if (pRopa.getPrecioCompra() > 0) { // Verificar si se va incluir el campo Id en el filtro de la consulta SELECT de la tabla de Rol
            pUtilQuery.AgregarWhereAnd(" r.PrecioCompra=? "); // Agregar el campo Id al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Id a la consulta SELECT de la tabla de Rol
                statement.setDouble(pUtilQuery.getNumWhere(), pRopa.getPrecioCompra());
            }
        }

        if (pRopa.getPrecioVenta() > 0) { // Verificar si se va incluir el campo Id en el filtro de la consulta SELECT de la tabla de Rol
            pUtilQuery.AgregarWhereAnd(" r.PrecioVenta=? "); // Agregar el campo Id al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Id a la consulta SELECT de la tabla de Rol
                statement.setDouble(pUtilQuery.getNumWhere(), pRopa.getPrecioVenta());
            }
        }

        if (pRopa.getExistencia() > 0) { // Verificar si se va incluir el campo Id en el filtro de la consulta SELECT de la tabla de Rol
            pUtilQuery.AgregarWhereAnd(" r.Existencia=? "); // Agregar el campo Id al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Id a la consulta SELECT de la tabla de Rol
                statement.setInt(pUtilQuery.getNumWhere(), pRopa.getExistencia());
            }
        }

        if (pRopa.getEstatus() > 0) { // Verificar si se va incluir el campo Id en el filtro de la consulta SELECT de la tabla de Rol
            pUtilQuery.AgregarWhereAnd(" r.Estatus=? "); // Agregar el campo Id al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Id a la consulta SELECT de la tabla de Rol
                statement.setByte(pUtilQuery.getNumWhere(), pRopa.getEstatus());
            }
        }

        if (pRopa.getTalla() != null && pRopa.getTalla().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" r.Talla LIKE ? "); // Agregar el campo Nombre al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Nombre a la consulta SELECT de la tabla de Rol
                statement.setString(pUtilQuery.getNumWhere(), "%" + pRopa.getTalla() + "%");
            }
        }

        if (pRopa.getColor() != null && pRopa.getColor().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" r.Color LIKE ? "); // Agregar el campo Nombre al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Nombre a la consulta SELECT de la tabla de Rol
                statement.setString(pUtilQuery.getNumWhere(), "%" + pRopa.getColor() + "%");
            }
        }

        if (pRopa.getEstilo() != null && pRopa.getEstilo().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" r.Estilo LIKE ? "); // Agregar el campo Nombre al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
//                // Agregar el parametro del campo Nombre a la consulta SELECT de la tabla de Rol
                statement.setString(pUtilQuery.getNumWhere(), "%" + pRopa.getEstilo() + "%");
            }
        }

        if (pRopa.getDescripcion() != null && pRopa.getDescripcion().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" r.Descripcion LIKE ? "); // Agregar el campo Nombre al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Nombre a la consulta SELECT de la tabla de Rol
                statement.setString(pUtilQuery.getNumWhere(), "%" + pRopa.getDescripcion() + "%");
            }
        }

        if (pRopa.getTipoTela() != null && pRopa.getTipoTela().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" r.TipoTela LIKE ? "); // Agregar el campo Nombre al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                // Agregar el parametro del campo Nombre a la consulta SELECT de la tabla de Rol
                statement.setString(pUtilQuery.getNumWhere(), "%" + pRopa.getTipoTela() + "%");
            }
        }

    }
    
     // Metodo para obtener todos los registro de la tabla de Usuario que cumplan con los filtros agregados 
     // a la consulta SELECT de la tabla de Usuario 
    public static ArrayList<Ropa> buscar(Ropa pRopa) throws Exception {
        ArrayList<Ropa> ropas = new ArrayList();
        try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(pRopa); // obtener la consulta SELECT de la tabla Usuario
            ComunDB comundb = new ComunDB();
            ComunDB.UtilQuery utilQuery = comundb.new UtilQuery(sql, null, 0);
            querySelect(pRopa, utilQuery); // Asignar el filtro a la consulta SELECT de la tabla de Usuario 
            sql = utilQuery.getSQL();
            sql += agregarOrderBy(pRopa); // Concatenar a la consulta SELECT de la tabla Usuario el ORDER BY por Id
            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // obtener el PreparedStatement desde la clase ComunDB
                utilQuery.setStatement(ps);
                utilQuery.setSQL(null);
                utilQuery.setNumWhere(0);
                querySelect(pRopa, utilQuery); // Asignar los parametros al PreparedStatement de la consulta SELECT de la tabla de Usuario
                obtenerDatos(ps, ropas); // Llenar el ArrayList de Usuario con las fila que devolvera la consulta SELECT a la tabla de Usuario
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex; // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // Cerrar la conexion a la base de datos
        } 
        catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        return ropas; // Devolver el ArrayList de Usuario
    }

    // Metodo para obtener todos los registro de la tabla de Rol que cumplan con los filtros agregados 
    // a la consulta SELECT de la tabla de Rol 
   public static ArrayList<Ropa> buscarIncluirMarca(Ropa pRopa) throws Exception {
        ArrayList<Ropa> ropas = new ArrayList();
        try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = "SELECT "; // Iniciar la variables para el String de la consulta SELECT
            if (pRopa.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.TipoDB.SQLSERVER) {
                sql += "TOP " + pRopa.getTop_aux() + " "; // Agregar el TOP en el caso que se este utilizando SQL SERVER
            }
            sql += obtenerCampos(); // Obtener los campos de la tabla de Usuario que iran en el SELECT
            sql += ",";
            sql += RolDAL.obtenerCampos(); // Obtener los campos de la tabla de Rol que iran en el SELECT
            sql += " FROM Ropa r";
            sql += " JOIN Marca m on (r.IdMarca=r.Id)"; // agregar el join para unir la tabla de Usuario con Rol
            ComunDB comundb = new ComunDB();
            ComunDB.UtilQuery utilQuery = comundb.new UtilQuery(sql, null, 0);
            querySelect(pRopa, utilQuery); // Asignar el filtro a la consulta SELECT de la tabla de Usuario 
            sql = utilQuery.getSQL();
            sql += agregarOrderBy(pRopa); // Concatenar a la consulta SELECT de la tabla Usuario el ORDER BY por Id
            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                utilQuery.setStatement(ps);
                utilQuery.setSQL(null);
                utilQuery.setNumWhere(0);
                querySelect(pRopa, utilQuery); // Asignar los parametros al PreparedStatement de la consulta SELECT de la tabla de Usuario
                obtenerDatosIncluirMarca(ps, ropas);// Llenar el ArrayList de Usuario con las fila que devolvera la consulta SELECT a la tabla de Usuario
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex;// Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // Cerrar la conexion a la base de datos
        } catch (SQLException ex) {
            throw ex;// Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        return ropas; // Devolver el ArrayList de Usuario
    }
}
