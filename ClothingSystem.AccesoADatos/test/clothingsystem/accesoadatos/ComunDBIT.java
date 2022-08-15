/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clothingsystem.accesoadatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class ComunDBIT {

    public ComunDBIT() {
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
     * Testear el metodo de ObtenerConexion de la clase ComunDB
     */
    @Test
    public void testObtenerConexion() throws Exception {
        System.out.println("ObtenerConexion");
        boolean expResult = false;
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Testear el metodo de CreateStatement de la clase ComunDB
     */
    @Test
    public void testCreateStatement() throws Exception {
        System.out.println("createStatement");
        boolean expResult = false;
    }

    /**
     * Testear el metodo de CreatePreparedStatement de la clase ComunDB
     */
    @Test
    public void testCreatePreparedStatement() throws Exception {
        System.out.println("createPreparedStatement");
        String pSql = "";

    }

    /**
     * Testear el metodo de ObtenerResultSet de la clase ComunDB
     */
    @Test
    public void testObtenerResultSet_Statement_String() throws Exception {
        System.out.println("ObtenerResultSet");
        String pSql = "SELECT TOP 5 * FROM ROL";
        boolean expResult = false;

    }

    /**
     * Testear el metodo de ObtenerResultSet de la clase ComunDB
     */
    @Test
    public void testObtenerResultSet_PreparedStatement() throws Exception {
        System.out.println("ObtenerResultSet");
        String pSql = "SELECT TOP 5 * FROM ROL";
        boolean expResult = false;

    }

    /**
     * Testear el metodo de EjecutarSQL de la clase ComunDB
     */
    @Test
    public void testEjecutarSQL() throws Exception {
        System.out.println("EjecutarSQL");
        String pSql = "INSERT INTO Rol(Nombre) VALUES('TEST COMUNDB') ";
        int expResult = 0;
        String pSql2 = "DELETE FROM Rol WHERE Nombre='TEST COMUNDB'";
        int expResult2 = 0;

    }

}
