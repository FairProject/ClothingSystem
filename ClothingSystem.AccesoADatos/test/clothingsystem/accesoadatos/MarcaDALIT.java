/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clothingsystem.accesoadatos;

import clothingsystem.entidadesdenegocio.Marca;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author HP
 */
public class MarcaDALIT {

    public MarcaDALIT() {
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
     * Test of obtenerCampos method, of class MarcaDAL.
     */
    @Test
    public void testObtenerCampos() {
        System.out.println("obtenerCampos");
        String expResult = "";
        String result = MarcaDAL.obtenerCampos();
    }

    /**
     * Test of crear method, of class MarcaDAL.
     */
    @Test
    public void testCrear() throws Exception {
        System.out.println("crear");
        Marca pMarca = null;
        int expResult = 0;

    }

    /**
     * Test of modificar method, of class MarcaDAL.
     */
    @Test
    public void testModificar() throws Exception {
        System.out.println("modificar");
        Marca pMarca = null;
        int expResult = 0;

    }

    /**
     * Test of eliminar method, of class MarcaDAL.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        Marca pMarca = null;
        int expResult = 0;

    }

    /**
     * Test of asignarDatosResultSet method, of class MarcaDAL.
     */
    @Test
    public void testAsignarDatosResultSet() throws Exception {
        System.out.println("asignarDatosResultSet");
        Marca pMarca = null;
        ResultSet pResultSet = null;
        int pIndex = 0;
        int expResult = 0;

    }

    /**
     * Test of obtenerPorId method, of class MarcaDAL.
     */
    @Test
    public void testObtenerPorId() throws Exception {
        System.out.println("obtenerPorId");
        Marca pMarca = null;
        Marca expResult = null;
    }

    /**
     * Test of obtenerTodos method, of class MarcaDAL.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        ArrayList<Marca> expResult = null;

    }

    /**
     * Test of querySelect method, of class MarcaDAL.
     */
    @Test
    public void testQuerySelect() throws Exception {
        System.out.println("querySelect");
        Marca pMarca = null;
        ComunDB.UtilQuery pUtilQuery = null;
    }

    /**
     * Test of buscar method, of class MarcaDAL.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        Marca pMarca = null;
        ArrayList<Marca> expResult = null;

    }

}
