package clothingsystem.accesoadatos;
import java.util.*;
import java.sql.*;
import clothingsystem.entidadesdenegocio.*; // Agregar la referencia al proyecto de entidades de negocio y poder utilizar las entidades de c, m y p
import java.time.LocalDate; // Agregar referencia al paquete para manejar Fechas
import java.time.LocalDateTime;
/**
 *
 * @author Cristopher
 */
public class ProductoDAL {
    
    static String obtenerCampos() {
        return "p.Id, p.IdCategoria,p.Codigo,p.Descripcion,p.PrecioCompra,p.PrecioVenta,p.Existencia,p.Estatus,p.FechaVencimiento,p.FechaCreacion,p.Comentario";
    }
    
        // Metodo para obtener el SELECT a la tabla p y el top en el caso que se utilice una base de datos SQL SERVER
    private static String obtenerSelect(Producto pProducto) {
        String sql;
        sql = "SELECT ";
        if (pProducto.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.TipoDB.SQLSERVER) {
             // Agregar el TOP a la consulta SELECT si el gestor de base de datos es SQL SERVER y getTop_aux es mayor a cero
            sql += "TOP " + pProducto.getTop_aux() + " ";
        }
        sql += (obtenerCampos() + " FROM Producto p");
        return sql;
    } 
    
        private static String agregarOrderBy(Producto pProducto) {
        String sql = " ORDER BY p.Id DESC";
        if (pProducto.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.TipoDB.MYSQL) {
            // Agregar el LIMIT a la consulta SELECT de la tabla de p en el caso que getTop_aux() sea mayor a cero y el gestor de base de datos
            // sea MYSQL
            sql += " LIMIT " + pProducto.getTop_aux() + " ";
        }
        return sql;
    }
      private static boolean existeProducto(Producto pProducto) throws Exception {
        boolean existe = false;
        ArrayList<Producto> productos = new ArrayList();
        try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(pProducto);  // Obtener la consulta SELECT de la tabla Usuario
            // Concatenar a la consulta SELECT de la tabla Usuario el WHERE y el filtro para saber si existe el login
            sql += " WHERE p.Id<>? AND p.Codigo=?";
            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                ps.setInt(1, pProducto.getId());  // Agregar el parametros a la consulta donde estan el simbolo ? #1 
                ps.setString(2, pProducto.getCodigo());  // Agregar el parametros a la consulta donde estan el simbolo ? #2 
                obtenerDatos(ps, productos); // Llenar el ArrayList de USuario con las fila que devolvera la consulta SELECT a la tabla de Usuario
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex;  // Enviar al siguiente metodo el error al ejecutar PreparedStatement el en el caso que suceda
            }
            conn.close(); // Cerrar la conexion a la base de datos
        }
        catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        if (productos.size() > 0) { // Verificar si el ArrayList de Usuario trae mas de un registro en tal caso solo debe de traer uno
            Producto producto;
            // Se solucciono tenia valor de 1 cuando debe de ser cero
            producto = productos.get(0); // Si el ArrayList de Usuario trae un registro o mas obtenemos solo el primero 
            if (producto.getId() > 0 && producto.getCodigo().equals(pProducto.getCodigo())) {
                // Si el Id de Producto es mayor a cero y el Login que se busco en la tabla de Usuario es igual al que solicitamos
                // en los parametros significa que el login ya existe en la base de datos y devolvemos true en la variable "existe"
                existe = true;
            }
        }
        return existe; //Devolver la variable "existe" con el valor true o false si existe o no el Login en la tabla de Usuario de la base de datos

    }
          
      // Metodo para poder insertar un nuevo registro en la tabla de p
    public static int crear(Producto pProducto) throws Exception {
        int result;
        String sql;       
        boolean existe = existeProducto(pProducto); // verificar si el usuario que se va a crear ya existe en nuestra base de datos
        if (existe == false)
        {
            try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
                 //Definir la consulta INSERT a la tabla de P utilizando el simbolo "?" para enviar parametros
                sql = "INSERT INTO Producto(IdCategoria,Codigo,Descripcion,PrecioCompra,PrecioVenta,Existencia,Estatus,FechaVencimiento,FechaCreacion,Comentario) VALUES(?,?,?,?,?,?,?,?,?,?)";
                try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                    ps.setInt(1, pProducto.getIdCategoria()); // Agregar el parametro a la consulta donde estan el simbolo "?" #1  
                    ps.setString(2, pProducto.getCodigo()); // agregar el parametro a la consulta donde estan el simbolo "?" #3 
                    ps.setString(3, pProducto.getDescripcion()); // agregar el parametro a la consulta donde estan el simbolo "?" #4 
                    ps.setDouble(4, pProducto.getPrecioCompra()); // agregar el parametro a la consulta donde estan el simbolo "?" #5 
                    ps.setDouble(5, pProducto.getPrecioVenta());
                    ps.setInt(6, pProducto.getExistencia());
                    ps.setByte(7, pProducto.getEstatus());
                    ps.setDate(8, java.sql.Date.valueOf(LocalDate.now()));
                    ps.setObject(9, (LocalDateTime.now()));// agregar el parametro a la consulta donde estan el simbolo "?"  
                    ps.setString(10, pProducto.getComentario());
                    result = ps.executeUpdate(); // ejecutar la consulta INSERT en la base de datos
                    ps.close(); // cerrar el PreparedStatement
                } catch (SQLException ex) {
                    throw ex; // enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda 
                }
                conn.close();
            } 
            catch (SQLException ex) {
                throw ex; // enviar al siguiente metodo el error al obtener la conexion en el caso que suceda
            }
        } else {
            result = 0;
            throw new RuntimeException("Producto ya existe"); // enviar una exception para notificar que el p existe
       }
        return result; // Retornar el numero de fila afectadas en el INSERT en la base de datos 
    }
    
        public static int modificar(Producto pProducto) throws Exception {
        int result;
        String sql;       
        boolean existe = existeProducto(pProducto); // verificar si el p que se va a crear ya existe en nuestra base de datos
       if (existe == false)
       {
            try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
                 //Definir la consulta INSERT a la tabla de p utilizando el simbolo "?" para enviar parametros
                sql = "UPDATE Producto SET IdCategoria = ?,Codigo = ?,Descripcion = ?,PrecioCompra = ?,PrecioVenta = ?,Existencia = ?,Estatus = ?,Comentario = ? WHERE Id=?";
                try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                    ps.setInt(1, pProducto.getIdCategoria()); // Agregar el parametro a la consulta donde estan el simbolo "?" #1
                    ps.setString(2, pProducto.getCodigo()); // agregar el parametro a la consulta donde estan el simbolo "?" #3 
                    ps.setString(3, pProducto.getDescripcion()); // agregar el parametro a la consulta donde estan el simbolo "?" #4 
                    ps.setDouble(4, pProducto.getPrecioCompra()); // agregar el parametro a la consulta donde estan el simbolo "?" #5 
                    ps.setDouble(5, pProducto.getPrecioVenta());
                    ps.setInt(6, pProducto.getExistencia());
                    ps.setByte(7, pProducto.getEstatus()); 
                    ps.setString(8, pProducto.getComentario());
                    ps.setInt(9, pProducto.getId());
                    result = ps.executeUpdate(); // ejecutar la consulta INSERT en la base de datos
                    ps.close(); // cerrar el PreparedStatement
                     } catch (SQLException ex) {
                    throw ex; // enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda 
                }
                conn.close();
            } 
            catch (SQLException ex) {
                throw ex; // enviar al siguiente metodo el error al obtener la conexion en el caso que suceda
            }
        } else {
            result = 0;
           throw new RuntimeException("Producto ya existe"); // enviar una exception para notificar que el p existe
        }
        return result; // Retornar el numero de fila afectadas en el INSERT en la base de datos 
    }
        
         public static int eliminar(Producto pProducto) throws Exception {
        int result;
        String sql;
        try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            sql = "DELETE FROM Producto WHERE Id=?"; //definir la consulta DELETE a la tabla de p utilizando el simbolo ? para enviar parametros
            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) {  // obtener el PreparedStatement desde la clase ComunDB
                ps.setInt(1, pProducto.getId()); // agregar el parametro a la consulta donde estan el simbolo ? #1 
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
         
        static int asignarDatosResultSet(Producto pProducto, ResultSet pResultSet, int pIndex) throws Exception {
   
        pIndex++;
        pProducto.setId(pResultSet.getInt(pIndex)); // index 1
        pIndex++;
        pProducto.setIdCategoria(pResultSet.getInt(pIndex)); // index 2
        pIndex++;
        pProducto.setCodigo(pResultSet.getString(pIndex)); // index 3
        pIndex++;
        pProducto.setDescripcion(pResultSet.getString(pIndex)); // index 4
        pIndex++;
        pProducto.setPrecioCompra(pResultSet.getFloat(pIndex)); // index 5
        pIndex++;
        pProducto.setPrecioVenta(pResultSet.getFloat(pIndex)); // index 6
        pIndex++;
        pProducto.setExistencia(pResultSet.getInt(pIndex)); // index 7
        pIndex++;
        pProducto.setEstatus(pResultSet.getByte(pIndex)); // index 8
        pIndex++;
        pProducto.setFechaVencimiento(pResultSet.getDate(pIndex).toLocalDate()); // index 9
        pIndex++;
        pProducto.setFechaCreacion(pResultSet.getObject(pIndex, LocalDateTime.class)); // index 10
        pIndex++;
        pProducto.setComentario(pResultSet.getString(pIndex)); // index 11
        return pIndex;
        
    }
     
            private static void obtenerDatos(PreparedStatement pPS, ArrayList<Producto> pProducto) throws Exception {
        try (ResultSet resultSet = ComunDB.obtenerResultSet(pPS);) { // obtener el ResultSet desde la clase ComunDB
            while (resultSet.next()) { // Recorrer cada una de la fila que regresa la consulta  SELECT de la tabla p
                Producto producto = new Producto();
                // Llenar las propiedaddes de la Entidad Usuario con los datos obtenidos de la fila en el ResultSet
                asignarDatosResultSet(producto, resultSet, 0);
                pProducto.add(producto); // agregar la entidad Usuario al ArrayList de Usuario
            }
            resultSet.close(); // cerrar el ResultSet
        } catch (SQLException ex) {
            throw ex;// enviar al siguiente metodo el error al obtener ResultSet de la clase ComunDB   en el caso que suceda 
        }
    } 
            
             private static void obtenerDatosIncluirCategoria(PreparedStatement pPS, ArrayList<Producto> pProductos) throws Exception {
        try (ResultSet resultSet = ComunDB.obtenerResultSet(pPS);) { // obtener el ResultSet desde la clase ComunDB
            HashMap<Integer, Categoria> CategoriaMap = new HashMap(); //crear un HashMap para automatizar la creacion de instancias de la clase c
            while (resultSet.next()) { // Recorrer cada una de la fila que regresa la consulta  SELECT de la tabla p JOIN a la tabla de c
                Producto producto = new Producto();
                 // Llenar las propiedaddes de la Entidad p con los datos obtenidos de la fila en el ResultSet
                int index = asignarDatosResultSet(producto, resultSet, 0);
                if (CategoriaMap.containsKey(producto.getIdCategoria()) == false) { // verificar que el HashMap aun no contenga el C actual
                    Categoria categoria = new Categoria();
                    // en el caso que el C no este en el HashMap se asignara
                    CategoriaDAL.asignarDatosResultSet(categoria, resultSet, index);
                    CategoriaMap.put(categoria.getId(), categoria); // agregar el C al  HashMap
                    producto.setCategoría(categoria); // agregar el C al Usuario
                } else {
                    // En el caso que el C existe en el HashMap se agregara automaticamente al p
                    producto.setCategoría(CategoriaMap.get(producto.getIdCategoria())); 
                }
                pProductos.add(producto); // Agregar el Usuario de la fila actual al ArrayList de P
            }
            resultSet.close(); // cerrar el ResultSet
        } catch (SQLException ex) {
            throw ex; // enviar al siguiente metodo el error al obtener ResultSet de la clase ComunDB   en el caso que suceda 
        }
    }
             
                // Metodo para obtener por Id un registro de la tabla de P 
    public static Producto obtenerPorId(Producto pProducto) throws Exception {
        Producto producto = new Producto();
        ArrayList<Producto> productos = new ArrayList();
        try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(pProducto); // obtener la consulta SELECT de la tabla P
             // Concatenar a la consulta SELECT de la tabla P el WHERE  para comparar el campo Id
            sql += " WHERE p.Id=?";
            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // obtener el PreparedStatement desde la clase ComunDB
                ps.setInt(1, pProducto.getId()); // agregar el parametro a la consulta donde estan el simbolo ? #1 
                obtenerDatos(ps, productos); // Llenar el ArrayList de P con las fila que devolvera la consulta SELECT a la tabla de P
                ps.close(); // cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex; // enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // cerrar la conexion a la base de datos
        }
        catch (SQLException ex) {
            throw ex; // enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        if (productos.size() > 0) { // verificar si el ArrayList de Usuario trae mas de un registro en tal caso solo debe de traer uno
            producto = productos.get(0); // Si el ArrayList de Usuario trae un registro o mas obtenemos solo el primero
        }
        return producto; // devolver el P encontrado por Id 
    }

       public static ArrayList<Producto> obtenerTodos() throws Exception {
        ArrayList<Producto> productos;
        productos = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(new Producto()); // obtener la consulta SELECT de la tabla P
            sql += agregarOrderBy(new Producto()); // concatenar a la consulta SELECT de la tabla P el ORDER BY por Id 
            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // obtener el PreparedStatement desde la clase ComunDB
                obtenerDatos(ps, productos); // Llenar el ArrayList de P con las fila que devolvera la consulta SELECT a la tabla de P
                ps.close(); // cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex; // enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // cerrar la conexion a la base de datos
        }
        catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        return productos; // devolver el ArrayList de P
    }
       
           // Metodo para asignar los filtros de la consulta SELECT de la tabla de P de forma dinamica
    static void querySelect(Producto pProducto, ComunDB.UtilQuery pUtilQuery) throws SQLException {
        PreparedStatement statement = pUtilQuery.getStatement(); // obtener el PreparedStatement al cual aplicar los parametros
        if (pProducto.getId() > 0) { // verificar si se va incluir el campo Id en el filtro de la consulta SELECT de la tabla de P
            pUtilQuery.AgregarWhereAnd(" p.Id=? "); // agregar el campo Id al filtro de la consulta SELECT y agregar el WHERE o AND
            if (statement != null) {
                 // agregar el parametro del campo Id a la consulta SELECT de la tabla de P
                statement.setInt(pUtilQuery.getNumWhere(), pProducto.getId());
            }
        }
        // verificar si se va incluir el campo IdC en el filtro de la consulta SELECT de la tabla de p
        if (pProducto.getIdCategoria() > 0) {
            pUtilQuery.AgregarWhereAnd(" p.IdCategoria=? "); // agregar el campo IdC al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                 // agregar el parametro del campo IdC a la consulta SELECT de la tabla de P
                statement.setInt(pUtilQuery.getNumWhere(), pProducto.getIdCategoria());
            }
        }
        // verificar si se va incluir el campo Nombre en el filtro de la consulta SELECT de la tabla de P
        if (pProducto.getCodigo() != null && pProducto.getCodigo().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" p.Codigo LIKE ? "); // agregar el campo Nombre al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                 // agregar el parametro del campo Nombre a la consulta SELECT de la tabla de P
                statement.setString(pUtilQuery.getNumWhere(), "%" + pProducto.getCodigo() + "%");
            }
        }
        // Verificar si se va incluir el campo D en el filtro de la consulta SELECT de la tabla de P
        if (pProducto.getDescripcion() != null && pProducto.getDescripcion().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" p.Descripcion LIKE ? "); // agregar el campo D al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                 // agregar el parametro del campo Apellido a la consulta SELECT de la tabla de p
                statement.setString(pUtilQuery.getNumWhere(), "%" + pProducto.getDescripcion() + "%");
            }
        }
        // Verificar si se va incluir el campo PC en el filtro de la consulta SELECT de la tabla de p
        if (pProducto.getPrecioCompra() > 0) 
                {
            pUtilQuery.AgregarWhereAnd(" p.PrecioCompra=? "); // agregar el campo PC al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                 // agregar el parametro del campo PC a la consulta SELECT de la tabla de P
                statement.setDouble(pUtilQuery.getNumWhere(), pProducto.getPrecioCompra());
            }
        }
           // Verificar si se va incluir el campo PV en el filtro de la consulta SELECT de la tabla de p
        if (pProducto.getPrecioVenta() > 0)
       {
            pUtilQuery.AgregarWhereAnd(" p.PrecioVenta=? "); // agregar el campo PC al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                 // agregar el parametro del campo PC a la consulta SELECT de la tabla de P
                statement.setDouble(pUtilQuery.getNumWhere(), pProducto.getPrecioVenta());
            }
        }
         if (pProducto.getExistencia() > 0) {
            pUtilQuery.AgregarWhereAnd(" p.Existencia=? "); // agregar el campo PC al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                 // agregar el parametro del campo PC a la consulta SELECT de la tabla de P
                statement.setInt(pUtilQuery.getNumWhere(), pProducto.getExistencia());
            }
        }
        // Verificar si se va incluir el campo Estatus en el filtro de la consulta SELECT de la tabla de 
        if (pProducto.getEstatus() > 0) {
            pUtilQuery.AgregarWhereAnd(" p.Estatus=? "); // agregar el campo Estatus al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                 // agregar el parametro del campo Estatus a la consulta SELECT de la tabla de Usuario
                statement.setInt(pUtilQuery.getNumWhere(), pProducto.getEstatus());
            }
        }
    }
    
       public static ArrayList<Producto> buscar(Producto pProducto) throws Exception {
        ArrayList<Producto> productos = new ArrayList();
        try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(pProducto); // obtener la consulta SELECT de la tabla P
            ComunDB comundb = new ComunDB();
            ComunDB.UtilQuery utilQuery = comundb.new UtilQuery(sql, null, 0);
            querySelect(pProducto, utilQuery); // Asignar el filtro a la consulta SELECT de la tabla de P
            sql = utilQuery.getSQL();
            sql += agregarOrderBy(pProducto); // Concatenar a la consulta SELECT de la tabla P o el ORDER BY por Id
            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // obtener el PreparedStatement desde la clase ComunDB
                utilQuery.setStatement(ps);
                utilQuery.setSQL(null);
                utilQuery.setNumWhere(0);
                querySelect(pProducto, utilQuery); // Asignar los parametros al PreparedStatement de la consulta SELECT de la tabla de P
                obtenerDatos(ps, productos); // Llenar el ArrayList de Usuario con las fila que devolvera la consulta SELECT a la tabla de P
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex; // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // Cerrar la conexion a la base de datos
        } 
        catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        return productos; // Devolver el ArrayList de P
    }
       
       
           public static ArrayList<Producto> buscarIncluirCategoria(Producto pProducto) throws Exception {
        ArrayList<Producto> productos = new ArrayList();
        try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = "SELECT "; // Iniciar la variables para el String de la consulta SELECT
            if (pProducto.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.TipoDB.SQLSERVER) {
                sql += "TOP " + pProducto.getTop_aux() + " "; // Agregar el TOP en el caso que se este utilizando SQL SERVER
            }
            sql += obtenerCampos(); // Obtener los campos de la tabla de p que iran en el SELECT
            sql += ",";
            sql += CategoriaDAL.obtenerCampos(); // Obtener los campos de la tabla de C que iran en el SELECT
            sql += " FROM Producto p";
            sql += " JOIN Categoria c on (p.IdCategoria=c.Id)"; // agregar el join para unir la tabla de p con C
            ComunDB comundb = new ComunDB();
            ComunDB.UtilQuery utilQuery = comundb.new UtilQuery(sql, null, 0);
            querySelect(pProducto, utilQuery); // Asignar el filtro a la consulta SELECT de la tabla de p 
            sql = utilQuery.getSQL();
            sql += agregarOrderBy(pProducto); // Concatenar a la consulta SELECT de la tabla p el ORDER BY por Id
            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                utilQuery.setStatement(ps);
                utilQuery.setSQL(null);
                utilQuery.setNumWhere(0);
                querySelect(pProducto, utilQuery); // Asignar los parametros al PreparedStatement de la consulta SELECT de la tabla de p
                obtenerDatosIncluirCategoria(ps, productos);// Llenar el ArrayList de p con las fila que devolvera la consulta SELECT a la tabla de p
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex;// Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // Cerrar la conexion a la base de datos
        } catch (SQLException ex) {
            throw ex;// Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        return productos; // Devolver el ArrayList de p
    }  
}
