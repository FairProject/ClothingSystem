/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clothingsystem.accesoadatos;

import static clothingsystem.accesoadatos.UsuarioDAL.login;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import clothingsystem.entidadesdenegocio.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import clothingsystem.entidadesdenegocio.Rol;
import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class UsuarioDALIT {

    private Usuario usuarioActual;
    private String login;

    public UsuarioDALIT() {
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
     */
    @Test
    public void test1Crear() throws Exception {
        int randomNum = (int) (Math.random() * 1000);
        String login = "UNITTEST" + randomNum;
        System.out.println("crear");
        Usuario usuario = new Usuario();
        usuario.setNombre("Nombre UNIT TEST");
        usuario.setApellido("Apellido UNIT TEST");
        usuario.setLogin(login);
        usuario.setPassword("12345");
        usuario.setEstatus(Usuario.EstatusUsuario.INACTIVO);
        usuario.setFechaRegistro(LocalDate.now());
        Rol rolB = new Rol();
        rolB.setTop_aux(1);

    }

    public int testIndividualQuerySelect(Usuario pUsuario) throws Exception {
        ComunDB comundb = new ComunDB();
        ComunDB.UtilQuery pUtilQuery = comundb.new UtilQuery("", null, 0);
        UsuarioDAL.querySelect(pUsuario, pUtilQuery);
        return pUtilQuery.getNumWhere();
    }

    /**
     * Testear el metodo de QuerySelect de la clase UsuarioDAL
     */
    @Test
    public void test2QuerySelect() throws Exception {
        System.out.println("querySelect");
        int index = 0;
        Usuario usuario = new Usuario();
        usuario.setId(1);
        index++;
        assertTrue(testIndividualQuerySelect(usuario) == index);
        usuario.setNombre("TEST");
        index++;
        assertTrue(testIndividualQuerySelect(usuario) == index);
        usuario.setApellido("TEST");
        index++;
        assertTrue(testIndividualQuerySelect(usuario) == index);
        usuario.setLogin("TEST");
        index++;
        assertTrue(testIndividualQuerySelect(usuario) == index);
        usuario.setIdRol(1);
        index++;
        assertTrue(testIndividualQuerySelect(usuario) == index);
        usuario.setEstatus((byte) 1);
        index++;
        assertTrue(testIndividualQuerySelect(usuario) == index);
    }

    /**
     * Testear el metodo de Buscar de la clase UsuarioDAL
     */
    @Test
    public void test3Buscar() throws Exception {
        System.out.println("buscar");
        Usuario usuario = new Usuario();
        usuario.setNombre("Nombre UNIT TEST");
        usuario.setApellido("Apellido UNIT TEST");
        usuario.setLogin(login);
        usuario.setEstatus(Usuario.EstatusUsuario.INACTIVO);
        usuario.setTop_aux(10);

    }

    /**
     * Testear el metodo de ObtenerPorId de la clase UsuarioDAL
     */
    @Test
    public void test4ObtenerPorId() throws Exception {
        System.out.println("obtenerPorId");

    }

    /**
     * Testear el metodo de Modificar de la clase UsuarioDAL
     */
    @Test
    public void test5Modificar() throws Exception {
        System.out.println("modificar");
        Usuario usuario = new Usuario();
        usuario.setNombre("Nombre UNIT TEST M");
        usuario.setApellido("Apellido UNIT TEST M");
        login += "_MOD";
        usuario.setLogin(login);
        usuario.setEstatus(Usuario.EstatusUsuario.ACTIVO);
        Rol rolB = new Rol();
        rolB.setTop_aux(2);
        int expResult = 0;

    }

    /**
     * Testear el metodo de ObtenerTodos de la clase UsuarioDAL
     */
    @Test
    public void test6ObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");

    }

    /**
     * Testear el metodo de BuscarIncluirRol de la clase UsuarioDAL
     */
    @Test
    public void test7BuscarIncluirRol() throws Exception {
        System.out.println("buscarIncluirRol");
        Usuario usuario = new Usuario();
        usuario.setTop_aux(10);

    }

    /**
     * Testear el metodo de ObtenerCampos de la clase UsuarioDAL
     */
    @Test
    public void test8ObtenerCampos() {
        System.out.println("obtenerCampos");
        String expResult = "";
        String result = UsuarioDAL.obtenerCampos();
        assertNotEquals(expResult, result);
    }

    /**
     * Testear el metodo de CambiarPassword de la clase UsuarioDAL
     */
    @Test
    public void test90CambiarPassword() throws Exception {
        System.out.println("cambiarPassword");
        Usuario usuario = new Usuario();
        usuario.setPassword("UNODOSTRES");
        String pPasswordAnt = "12345";

    }

    /**
     * Testear el metodo de Login de la clase UsuarioDAL
     */
    @Test
    public void test91Login() throws Exception {
        System.out.println("login");
        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setPassword("UNODOSTRES");

    }

    /**
     * Testear el metodo de Eliminar de la clase UsuarioDAL
     */
    @Test
    public void test93Eliminar() throws Exception {
        System.out.println("eliminar");
        int expResult = 0;

    }

}
