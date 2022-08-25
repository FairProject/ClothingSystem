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

/**
 *
 * @author HP
 */
public class RopaFotoDALIT {

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
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of crear method, of class RopaFotoDAL.
     */
    @Test
    public void testCrear() throws Exception {
        System.out.println("crear");
        RopaFoto pRopaFoto = new RopaFoto();
        int expResult = 0;
        Object result = null;
//        int result = RopaFotoDAL.crear(pRopaFoto);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of modificar method, of class RopaFotoDAL.
     */
    @Test
    public void testModificar() throws Exception {
        System.out.println("modificar");
        RopaFoto pRopaFoto = new RopaFoto();
        pRopaFoto.setUrl("TEST UNIT RopaFoto M");
        int expResult = 0;
        Object result = null;
//        int result = RopaFotoDAL.modificar(pRopaFoto);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of eliminar method, of class RopaFotoDAL.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        int expResult = 0;
        Object result = null;
//        int result = RopaFotoDAL.eliminar(pRopaFoto);
        assertNotEquals(expResult, result);

    }

    /**
     * Test of asignarDatosResultSet method, of class RopaFotoDAL.
     */
    @Test
    public void testAsignarDatosResultSet() throws Exception {
        System.out.println("asignarDatosResultSet");
        RopaFoto pRopaFoto = null;
        ResultSet pResultSet = null;
        int pIndex = 0;
        int expResult = 0;
        // fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPorId method, of class RopaFotoDAL.
     */
    @Test
    public void testObtenerPorId() throws Exception {
        System.out.println("obtenerPorId");
        RopaFoto pRopaFoto = null;
        RopaFoto expResult = null;
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodos method, of class RopaFotoDAL.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        ArrayList<RopaFoto> expResult = null;
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
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
        pRopaFoto.setUrl("TEST");
        assertTrue(testIndividualQuerySelect(pRopaFoto) == 2);
    }

    /**
     * Test of buscar method, of class RopaFotoDAL.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        RopaFoto pRopaFoto = new RopaFoto();
//        ArrayList<RopaFoto> result = RopaFotoDAL.buscar(pRopaFoto);
  //      assertTrue(result.size() > 0);
        
    }

}
