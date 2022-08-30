/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clothingsystem.accesoadatos;

import clothingsystem.entidadesdenegocio.Ropa;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import clothingsystem.entidadesdenegocio.Marca;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author moise
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RopaDALIT {

    private static Ropa ropaActual;

    public RopaDALIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of crear method, of class RopaDAL.
     */
    @Test
    public void testObtenerCampos() {
        System.out.println("obtenerCampos");
        String expResult = "";
        String result = RopaFotoDAL.obtenerCampos();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of crear method, of class RopaFotoDAL.
     */
    @Test
    public void test1Crear() throws Exception {
        System.out.println("crear");
        Ropa ropa = new Ropa();
        ropa.getCodigoBarra();
        ropa.getNombre();
        ropa.getIdMarca();
        Ropa EstiloB = new Ropa();
        EstiloB.setTop_aux(1);
//        ropafoto.setIdRopa(RopaDAL.buscar(EstiloB).get(0).getId());
        int expResult = 0;
//        int result = RopaFotoDAL.crear(ropafoto);
        //       assertNotEquals(expResult, result);
    }

    /**
     * Test of modificar method, of class RopaFotoDAL.
     */
    @Test
    public void testModificar() throws Exception {
        System.out.println("modificar");
        Ropa pRopa = new Ropa();
//        pRopaFoto.setId(ropafotoActual.getId());
//         pRopaFoto.setIdRopa(ropafotoActual.getIdRopa());
        pRopa.getCodigoBarra();
        pRopa.getNombre();
        int expResult = 0;
        Object result = null;
//        int result = RopaFotoDAL.modificar(pRopaFoto);
        assertNotEquals(expResult, result);
//        RopaFoto ropafotoUpdate = RopaFotoDAL.obtenerPorId(ropafotoActual);
        //       assertTrue(ropafotoUpdate.getUrl().equals(pRopaFoto.getUrl()));

    }

    /**
     * Test of eliminar method, of class RopaFotoDAL.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        int expResult = 0;
        Object result = null;
//        int result = RopaFotoDAL.eliminar(ropafotoActual);
        assertNotEquals(expResult, result);
//        RopaFoto ropafotoDelete = RopaFotoDAL.obtenerPorId(ropafotoActual);
        //    assertTrue(ropafotoDelete.getId() == 0);
    }

    public void test9asignarDatosResultSet() throws Exception {
        System.out.println("asignarDatosResultSet");
        Ropa ropa = new Ropa();
        try ( Connection conn = ComunDB.obtenerConexion();) {
            String sql = "SELECT " + RopaFotoDAL.obtenerCampos() + " FROM Ropa ";
            sql += " WHERE r.Id=?";
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) {
                ps.setInt(1, ropaActual.getId());
                try ( ResultSet resultSet = ComunDB.obtenerResultSet(ps);) {
                    while (resultSet.next()) {

                    }
                    resultSet.close();
                } catch (SQLException ex) {
                    throw ex;
                }
                ps.close();
            } catch (SQLException ex) {
                throw ex;
            }
            conn.close();
        } // Handle any errors that may have occurred.
        catch (SQLException ex) {
            throw ex;
        }
        assertTrue(ropa.getId() == ropaActual.getId());
    }

    /**
     * Test of obtenerPorId method, of class RopaFotoDAL.
     */
    @Test
    public void testObtenerPorId() throws Exception {
        System.out.println("obtenerPorId");
        Ropa pRopa = new Ropa();
//         ArrayList<Ropa Ropa= new ArrayList();
//        RopaFoto result = RopaFotoDAL.obtenerPorId(ropafotoActual);
        // assertEquals(ropafotoActual.getId(), result.getId());
    }

    /**
     * Test of obtenerTodos method, of class RopaFotoDAL.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
//        ArrayList<Ropa> result = RopaDAL.obtenerTodos();
//        assertTrue(result.size() > 0);
        

    }

    /**
     * Testear el metodo de BuscarIncluirRol de la clase UsuarioDAL
     */
    @Test
    public void test7BuscarIncluirRopa() throws Exception {
        System.out.println("buscarIncluirRopa");
        Ropa ropa = new Ropa();
        ropa.setTop_aux(10);
        ArrayList<Ropa> result;
//        result = RopaDAL.asignarDatosResultSet(ropa);
//        assertTrue(result.size() > 0);
    }

    public int testIndividualQuerySelect(Ropa pRopa) throws Exception {
        ComunDB comundb = new ComunDB();
        ComunDB.UtilQuery pUtilQuery = comundb.new UtilQuery("", null, 0);
        RopaDAL.querySelect(pRopa, pUtilQuery);
        return pUtilQuery.getNumWhere();
    }

    /**
     * Testear el metodo de QuerySelect de la clase RolDAL
     */
    @Test
    public void test2QuerySelect() throws Exception {
        System.out.println("querySelect");
        Ropa pRopa = new Ropa();
        pRopa.setId(1);
        assertTrue(testIndividualQuerySelect(pRopa) == 1);
        pRopa.setIdMarca(2);
        assertTrue(testIndividualQuerySelect(pRopa) == 2);

    }

    /**
     * Test of buscar method, of class RopaFotoDAL.
     */
    @Test
    public void test1Buscar() throws Exception {
        System.out.println("buscar");
        Ropa pMarca = new Ropa();
       
    }

}
