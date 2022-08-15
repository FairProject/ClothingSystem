/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clothingsystem.accesoadatos;

import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import clothingsystem.entidadesdenegocio.Rol;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author HP
 */
public class RolDALIT {

    private Rol rolActual;

    public RolDALIT() {
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
     * Testear el metodo de Crear de la clase RolDALb }
     *
     * public int testIndividualQuerySelect(Rol pRol) throws Exception { ComunDB
     * comundb = new ComunDB(); ComunDB.UtilQuery pUtilQuery = comundb.new
     * UtilQuery("", null, 0); RolDAL.querySelect(pRol, pUtilQuery); return
     * pUtilQuery.getNumWhere(); }
     *
     * /**
     * Testear el metodo de QuerySelect de la clase RolDAL
     */
    @Test
    public void test2QuerySelect() throws Exception {
        System.out.println("querySelect");
        Rol pRol = new Rol();
        pRol.setId(1);

    }

    /**
     * Testear el metodo de Buscar de la clase RolDAL
     */
    @Test
    public void test3Buscar() throws Exception {
        System.out.println("buscar");
        Rol pRol = new Rol(0, "TEST UNIT ROL");

    }

    /**
     * Testear el metodo de ObtenerPorId de la clase RolDAL
     */
    @Test
    public void test4obtenerPorId() throws Exception {
        System.out.println("obtenerPorId");

    }

    /**
     * Testear el metodo de Modificar de la clase RolDAL
     */
    @Test
    public void test5Modificar() throws Exception {
        System.out.println("modificar");
        Rol pRol = new Rol();
        Rol rolActual = null;
        pRol.setNombre("TEST UNIT ROL M");
        int expResult = 0;
    }

    /**
     * Testear el metodo de ObtenerTodos de la clase RolDAL
     */
    @Test
    public void test6ObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");

    }

    /**
     * Testear el metodo de Eliminar de la clase RolDAL
     */
    @Test
    public void test7Eliminar() throws Exception {
        System.out.println("eliminar");
        int expResult = 0;
        Rol rolActual = null;

    }

}
