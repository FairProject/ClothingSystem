///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
// */
//package clothingsystem.accesoadatos;
//
//import clothingsystem.entidadesdenegocio.Ropa;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author moise
// */
//public class RopaDALIT {
//    
//    public RopaDALIT() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of obtenerCampos method, of class RopaDAL.
//     */
//    @Test
//    public void testObtenerCampos() {
//        System.out.println("obtenerCampos");
//        String expResult = "";
//        String result = RopaDAL.obtenerCampos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of crear method, of class RopaDAL.
//     */
//    @Test
//    public void testCrear() throws Exception {
//        System.out.println("crear");
//        Ropa pRopa = null;
//        int expResult = 0;
//        int result = RopaDAL.crear(pRopa);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of modificar method, of class RopaDAL.
//     */
//    @Test
//    public void testModificar() throws Exception {
//        System.out.println("modificar");
//        Ropa pRopa = null;
//        int expResult = 0;
//        int result = RopaDAL.modificar(pRopa);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of eliminar method, of class RopaDAL.
//     */
//    @Test
//    public void testEliminar() throws Exception {
//        System.out.println("eliminar");
//        Ropa pRopa = null;
//        int expResult = 0;
//        int result = RopaDAL.eliminar(pRopa);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of asignarDatosResultSet method, of class RopaDAL.
//     */
//    @Test
//    public void testAsignarDatosResultSet() throws Exception {
//        System.out.println("asignarDatosResultSet");
//        Ropa pRopa = null;
//        ResultSet pResultSet = null;
//        int pIndex = 0;
//        int expResult = 0;
//        int result = RopaDAL.asignarDatosResultSet(pRopa, pResultSet, pIndex);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of obtenerPorId method, of class RopaDAL.
//     */
//    @Test
//    public void testObtenerPorId() throws Exception {
//        System.out.println("obtenerPorId");
//        Ropa pRopa = null;
//        Ropa expResult = null;
//        Ropa result = RopaDAL.obtenerPorId(pRopa);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of obtenerTodos method, of class RopaDAL.
//     */
//    @Test
//    public void testObtenerTodos() throws Exception {
//        System.out.println("obtenerTodos");
//        ArrayList<Ropa> expResult = null;
//        ArrayList<Ropa> result = RopaDAL.obtenerTodos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of querySelect method, of class RopaDAL.
//     */
//    @Test
//    public void testQuerySelect() throws Exception {
//        System.out.println("querySelect");
//        Ropa pRopa = null;
//        ComunDB.UtilQuery pUtilQuery = null;
//        RopaDAL.querySelect(pRopa, pUtilQuery);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of buscar method, of class RopaDAL.
//     */
//    @Test
//    public void testBuscar() throws Exception {
//        System.out.println("buscar");
//        Ropa pRopa = null;
//        ArrayList<Ropa> expResult = null;
//        ArrayList<Ropa> result = RopaDAL.buscar(pRopa);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
