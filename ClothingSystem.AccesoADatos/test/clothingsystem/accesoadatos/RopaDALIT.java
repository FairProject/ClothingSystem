/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clothingsystem.accesoadatos;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import clothingsystem.entidadesdenegocio.Ropa;

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
     * Testear el metodo de Crear de la clase UsuarioDAL
     *
     * @throws java.lang.Exception
     */
    @Test
    public void test1Crear() throws Exception {

        System.out.println("crear");
        Ropa ropa = new Ropa();
        ropa.setCodigoBarra("12345");
        ropa.setNombre("Nombre UNIT TEST");
        ropa.setPrecioCompra(12.5);
        ropa.setPrecioVenta(12.5);
        ropa.setEstatus(Ropa.EstatusRopa.INACTIVO);
        ropa.setTalla("12345");
        ropa.setEstilo("Estilo UNIT TEST");
        ropa.setColor("12345");
        ropa.setDescripcion("Estilo UNIT TEST");
        ropa.setTipoTela("Estilo UNIT TEST");

        Marca marcaB = new Marca();
        marcaB.setTop_aux(0);
        ropa.setIdMarca(MarcaDAL.buscar(marcaB).get(0).getId());
        int expResult = 0;
        int result = RopaDAL.crear(ropa);
        assertNotEquals(expResult, result);
    }

    public int testIndividualQuerySelect(Ropa pRopa) throws Exception {
        ComunDB comundb = new ComunDB();
        ComunDB.UtilQuery pUtilQuery = comundb.new UtilQuery("", null, 0);
        RopaDAL.querySelect(pRopa, pUtilQuery);
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
        Ropa ropa = new Ropa();
        ropa.setId(1);
        index++;
        assertTrue(testIndividualQuerySelect(ropa) == index);
        ropa.setCodigoBarra("TEST");
        index++;
        assertTrue(testIndividualQuerySelect(ropa) == index);
        ropa.setNombre("TEST");
        index++;
        assertTrue(testIndividualQuerySelect(ropa) == index);
        ropa.setPrecioCompra(12.5);
        index++;
        assertTrue(testIndividualQuerySelect(ropa) == index);
        ropa.setPrecioCompra(12.5);
        index++;
        
        ropa.setEstatus((byte) 1);
        index++;
        
        ropa.setTalla("TEST");
        index++;
        
        ropa.setColor("TEST");
        index++;
        
        ropa.setEstilo("TEST");
        index++;
        
        ropa.setDescripcion("TEST");
        index++;
        
        ropa.setTipoTela("TEST");
        index++;
        
//        assertTrue(testIndividualQuerySelect(ropa) == index);
        ropa.setIdMarca(1);

        index++;
//        assertTrue(testIndividualQuerySelect(ropa) == index);
    }

    /**
     * Testear el metodo de Buscar de la clase UsuarioDAL
     *
     * @throws java.lang.Exception
     */
    @Test
    public void test3Buscar() throws Exception {
        System.out.println("buscar");
        Ropa ropa = new Ropa();
        ropa.setCodigoBarra("12345");
        ropa.setNombre("Nombre UNIT TEST");
        ropa.setPrecioCompra(12.5);
        ropa.setPrecioVenta(12.5);
        ropa.setEstatus(Ropa.EstatusRopa.INACTIVO);
        ropa.setTalla("12345");
        ropa.setEstilo("Estilo UNIT TEST");
        ropa.setColor("12345");
        ropa.setDescripcion("Estilo UNIT TEST");
        ropa.setTipoTela("Estilo UNIT TEST");
        ropa.setTop_aux(10);
        ArrayList<Ropa> result = RopaDAL.buscar(ropa);
        assertTrue(result.size() > 0);
        ropaActual = result.get(0);
    }

    /**
     * Testear el metodo de ObtenerPorId de la clase UsuarioDAL
     *
     * @throws java.lang.Exception
     */
    @Test
    public void test4ObtenerPorId() throws Exception {
        System.out.println("obtenerPorId");
        Ropa result = RopaDAL.obtenerPorId(ropaActual);
        assertEquals(ropaActual.getId(), result.getId());
    }

    /**
     * Testear el metodo de Modificar de la clase UsuarioDAL
     *
     * @throws java.lang.Exception
     */
    @Test
    public void test5Modificar() throws Exception {
        System.out.println("modificar");
        Ropa ropa = new Ropa();
        ropa.setId(ropaActual.getId());
        
        ropa.setCodigoBarra("12345");
        ropa.setNombre("Nombre UNIT TEST");
        ropa.setPrecioCompra(12.5);
        ropa.setPrecioVenta(12.5);
        ropa.setEstatus(Ropa.EstatusRopa.INACTIVO);
        ropa.setTalla("12345");
        ropa.setEstilo("Estilo UNIT TEST");
        ropa.setColor("12345");
        ropa.setDescripcion("Estilo UNIT TEST");
        ropa.setTipoTela("Estilo UNIT TEST");
        

        ropa.setEstatus(Ropa.EstatusRopa.ACTIVO);
        Marca marcaB = new Marca();
        marcaB.setTop_aux(2);
        ropa.setIdMarca(MarcaDAL.buscar(marcaB).get(0).getId());
        int expResult = 0;
        int result = RopaDAL.modificar(ropa);
        assertNotEquals(expResult, result);

    }

    /**
     * Testear el metodo de ObtenerTodos de la clase UsuarioDAL
     *
     * @throws java.lang.Exception
     */
    @Test
    public void test6ObtenerTodos() throws Exception {
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
         public void test7BuscarIncluirMarca() throws Exception {
        System.out.println("buscarIncluirMarca");
        Ropa ropa = new Ropa();
        ropa.setTop_aux(10);
       
    }
/**
     * Testear el metodo de ObtenerPorId de la clase UsuarioDAL
     *
     * @throws java.lang.Exception
     */
    @Test
    public void test8ObtenerCampos() {
        System.out.println("obtenerCampos");
        String expResult = "";
        String result = RopaDAL.obtenerCampos();
        assertNotEquals(expResult, result);
    }

    /**
     * Testear el metodo de ObtenerPorId de la clase UsuarioDAL
     *
     * @throws java.lang.Exception
     */
    @Test
   public void test9Eliminar() throws Exception {
        System.out.println("eliminar");
        int expResult = 0;
        int result = RopaDAL.eliminar(ropaActual);
        assertNotEquals(expResult, result);
        Ropa ropaDelete = RopaDAL.obtenerPorId(ropaActual);
        assertTrue(ropaDelete.getId() == 0);
    }

}
