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

import clothingsystem.entidadesdenegocio.RopaFoto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import clothingsystem.entidadesdenegocio.Ropa;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author HP
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
     * Testear el metodo de Crear de la clase UsuarioDAL
     *
     * @throws java.lang.Exception
     */
    @Test
    public void test1Crear() throws Exception {

        System.out.println("crear");
        RopaFoto ropafoto = new RopaFoto();
        ropafoto.setUrl("Url");
        ropafoto.setEstatus(RopaFoto.EstatusRopaFoto.INACTIVO);
        Ropa ropaB = new Ropa();
        ropaB.setTop_aux(1);
        ropafoto.setIdRopa(RopaDAL.buscar(ropaB).get(0).getId());
        int expResult = 0;
        int result = RopaFotoDAL.crear(ropafoto);
        assertNotEquals(expResult, result);
    }

    public int testIndividualQuerySelect(RopaFoto pRopaFoto) throws Exception {
        ComunDB comundb = new ComunDB();
        ComunDB.UtilQuery pUtilQuery = comundb.new UtilQuery("", null, 0);
        RopaFotoDAL.querySelect(pRopaFoto, pUtilQuery);
        return pUtilQuery.getNumWhere();
    }

    /**
     * Testear el metodo de QuerySelect de la clase UsuarioDAL
     *
     * @throws java.lang.Exception
     */
    @Test
    public void test2QuerySelect() throws Exception {
        System.out.println("querySelect");
        int index = 0;
        RopaFoto ropafoto = new RopaFoto();
        ropafoto.setId(1);
        index++;
        assertTrue(testIndividualQuerySelect(ropafoto) == index);
        ropafoto.setUrl("TEST");
        index++;
        assertTrue(testIndividualQuerySelect(ropafoto) == index);
        ropafoto.setIdRopa(1);
        index++;
        assertTrue(testIndividualQuerySelect(ropafoto) == index);
        ropafoto.setEstatus((byte) 1);
        index++;
        assertTrue(testIndividualQuerySelect(ropafoto) == index);
    }

    /**
     * Testear el metodo de Buscar de la clase UsuarioDAL
     *
     * @throws java.lang.Exception
     */
    @Test
    public void test3Buscar() throws Exception {
        System.out.println("buscar");
        RopaFoto pRopaFoto = new RopaFoto();
        pRopaFoto.getUrl();
        pRopaFoto.getEstatus();
        pRopaFoto.getTop_aux();
        ArrayList<RopaFoto> result = RopaFotoDAL.buscar(pRopaFoto);
    }

    /**
     * Testear el metodo de ObtenerPorId de la clase UsuarioDAL
     *
     * @throws java.lang.Exception
     */
    @Test
    public void test4ObtenerPorId() throws Exception {
        System.out.println("obtenerPorId");
        RopaFoto ropafoto = new RopaFoto();
        ArrayList<RopaFoto> ropafotos = new ArrayList();
        ropafoto.getId();
        RopaFoto result = RopaFotoDAL.obtenerPorId(ropafoto);
    }

    /**
     * Testear el metodo de Modificar de la clase UsuarioDAL
     *
     * @throws java.lang.Exception
     */
    @Test
    public void test5Modificar() throws Exception {
        System.out.println("modificar");
        RopaFoto ropafoto = new RopaFoto();
        ropafoto.getId();
        ropafoto.setUrl("Url");
        ropafoto.setEstatus(RopaFoto.EstatusRopaFoto.ACTIVO);
        Ropa ropaB = new Ropa();
        ropaB.setTop_aux(2);
        ropafoto.setIdRopa(RopaDAL.buscar(ropaB).get(0).getId());
        int expResult = 1;
        int result = RopaFotoDAL.modificar(ropafoto);
        assertNotEquals(expResult, result);

    }

    /**
     * Testear el metodo de ObtenerTodos de la clase UsuarioDAL
     *
     * @throws java.lang.Exception
     */
    @Test
    public void test60ObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        ArrayList<Ropa> result = RopaDAL.obtenerTodos();
        assertTrue(result.size() > 0);
    }

    /**
     * Testear el metodo de BuscarIncluirRol de la clase UsuarioDAL
     *
     * @throws java.lang.Exception
     */
    @Test
    public void test7BuscarIncluirRopa() throws Exception {
        System.out.println("buscarIncluirRopa");
        RopaFoto ropafoto = new RopaFoto();
        ArrayList<RopaFoto> ropafotos = new ArrayList();
        ropafoto.setTop_aux(10);
        ArrayList<RopaFoto> result = RopaFotoDAL.buscarIncluirRopa(ropafoto);
        RopaFoto ropafotoConRopa = result.get(0);
        assertTrue(ropafotoConRopa.getIdRopa() == ropafotoConRopa.getRopa().getId());
    }

    /**
     * Testear el metodo de ObtenerPorId de la clase UsuarioDAL
     *
     */
    @Test
    public void test80ObtenerCampos() {
        System.out.println("obtenerCampos");
        String expResult = "";
        String result = RopaFotoDAL.obtenerCampos();
        assertNotEquals(expResult, result);
    }
    /**
     * Testear el metodo de ObtenerPorId de la clase UsuarioDAL
     *
     * @throws java.lang.Exception
     */
    @Test
    public void test93Eliminar() throws Exception {
        System.out.println("eliminar");
        RopaFoto ropafoto = new RopaFoto();
        ropafoto.getId();
        int expResult = 0;
        
    }

}
