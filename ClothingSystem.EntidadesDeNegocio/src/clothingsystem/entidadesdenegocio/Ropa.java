/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clothingsystem.entidadesdenegocio;

/**
 *
 * @author moise
 */
public class Ropa {

    private int id;
    private int idMarca;
    private String codigoBarra;
    private String nombre;
    private double precioCompra;
    private double precioVenta;
    private int existencia;
    private byte estatus;
    private String talla;
    private String color;
    private String estilo;
    private String descripcion;
    private String tipoTela;
    private Marca marca;
    
    private int top_aux;

    public Ropa() {
    }

    public Ropa(int id, int idMarca, String codigoBarra, String nombre, double precioCompra, double precioVenta, int existencia, byte estatus, String talla, String color, String estilo, String descripcion, String tipoTela, Marca marca) {
        this.id = id;
        this.idMarca = idMarca;
        this.codigoBarra = codigoBarra;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.existencia = existencia;
        this.estatus = estatus;
        this.talla = talla;
        this.color = color;
        this.estilo = estilo;
        this.descripcion = descripcion;
        this.tipoTela = tipoTela;
        this.marca = marca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public byte getEstatus() {
        return estatus;
    }

    public void setEstatus(byte estatus) {
        this.estatus = estatus;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoTela() {
        return tipoTela;
    }

    public void setTipoTela(String tipoTela) {
        this.tipoTela = tipoTela;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public int getTop_aux() {
        return top_aux;
    }

    public void setTop_aux(int top_aux) {
        this.top_aux = top_aux;
    }


    public class EstatusRopa {

        public static final byte ACTIVO = 1;
        public static final byte INACTIVO = 2;
    }

}
