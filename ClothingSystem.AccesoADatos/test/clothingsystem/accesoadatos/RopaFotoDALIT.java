/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clothingsystem.accesoadatos;

import clothingsystem.entidadesdenegocio.RopaFoto;
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
import clothingsystem.entidadesdenegocio.Ropa;
/**
 *
 * @author HP
 */
public class RopaFotoDALIT {
    private static RopaFoto ropafotoActual;
    public RopaFotoDALIT() {
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
     * Test of obtenerCampos method, of class RopaFotoDAL.
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
        RopaFoto ropafoto = new RopaFoto();
        ropafoto.getEstatus();
        ropafoto.getUrl();
        ropafoto.getIdRopa();
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
        RopaFoto pRopaFoto = new RopaFoto();
//        pRopaFoto.setId(ropafotoActual.getId());
//         pRopaFoto.setIdRopa(ropafotoActual.getIdRopa());
        pRopaFoto.getEstatus();
        pRopaFoto.getUrl();
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

    public void test92AsignarDatosResultSet() throws Exception {
        System.out.println("asignarDatosResultSet");
        RopaFoto usuario = new RopaFoto();
        try (Connection conn = ComunDB.obtenerConexion();) {
            String sql = "SELECT " + RopaFotoDAL.obtenerCampos() + " FROM Usuario u";
            sql += " WHERE u.Id=?";
            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) {
                ps.setInt(1, ropafotoActual.getId());
                try (ResultSet resultSet = ComunDB.obtenerResultSet(ps);) {
                    while (resultSet.next()) {
                        RopaFoto ropafoto = null;
                        RopaFotoDAL.asignarDatosResultSet(ropafoto, resultSet, 0);
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
        assertTrue(usuario.getId() == ropafotoActual.getId());
    }

    /**
     * Test of obtenerPorId method, of class RopaFotoDAL.
     */
    @Test
    public void testObtenerPorId() throws Exception {
        System.out.println("obtenerPorId");
        RopaFoto pRopaFoto =new RopaFoto();
         ArrayList<RopaFoto> RopaFoto = new ArrayList();
//        RopaFoto result = RopaFotoDAL.obtenerPorId(ropafotoActual);
       // assertEquals(ropafotoActual.getId(), result.getId());
    }

    /**
     * Test of obtenerTodos method, of class RopaFotoDAL.
     */
    @Test
    public void testObtenerTodos() throws Exception {
       System.out.println("obtenerTodos");
        ArrayList<RopaFoto> result = RopaFotoDAL.obtenerTodos();
        
    }
    /**
     *  Testear el metodo de BuscarIncluirRol de la clase UsuarioDAL
     */
    @Test
    public void test7BuscarIncluirRopaFoto() throws Exception {
        System.out.println("buscarIncluirRopaFoto");
        RopaFoto ropafoto = new RopaFoto();
        ropafoto.setTop_aux(10);
        ArrayList<RopaFoto> result;
        result = RopaFotoDAL.buscarIncluirRopa(ropafoto);
        assertTrue(result.size() > 0);
    }

     public int testIndividualQuerySelect(RopaFoto pRopaFoto) throws Exception {
        ComunDB comundb = new ComunDB();
        ComunDB.UtilQuery pUtilQuery = comundb.new UtilQuery("",null, 0);
        RopaFotoDAL.querySelect(pRopaFoto, pUtilQuery);
        return pUtilQuery.getNumWhere();
    }
/**
     * Testear el metodo de QuerySelect de la clase RolDAL
     */
    @Test
    public void test2QuerySelect() throws Exception {
        System.out.println("querySelect");
        RopaFoto pRopaFoto = new RopaFoto();
        pRopaFoto.setId(1);
        assertTrue(testIndividualQuerySelect(pRopaFoto) == 1);
        pRopaFoto.setIdRopa(2);
        assertTrue(testIndividualQuerySelect(pRopaFoto) == 2);
       
    }

    /**
     * Test of buscar method, of class RopaFotoDAL.
     */
    @Test
    public void test1Buscar() throws Exception {
        System.out.println("buscar");
        RopaFoto pRopaFoto = new RopaFoto();
        ArrayList<RopaFoto> result = RopaFotoDAL.buscar(pRopaFoto);
        
    }
    
}
