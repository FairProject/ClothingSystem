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
        RopaFoto pRopaFoto = null;
        int expResult = 0;
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class RopaFotoDAL.
     */
    @Test
    public void testModificar() throws Exception {
        System.out.println("modificar");
        RopaFoto pRopaFoto = null;
        int expResult = 0;
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class RopaFotoDAL.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        RopaFoto pRopaFoto = null;
        int expResult = 0;
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
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

    /**
     * Test of querySelect method, of class RopaFotoDAL.
     */
    @Test
    public void testQuerySelect() throws Exception {
        System.out.println("querySelect");
        RopaFoto pRopaFoto = null;
        ComunDB.UtilQuery pUtilQuery = null;
       
    }
    /**
     * Test of buscar method, of class RopaFotoDAL.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        RopaFoto pRopaFoto = null;
        ArrayList<RopaFoto> expResult = null;
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
