package clothingsystem.entidadesdenegocio;

import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 *
 * @author Cristopher
 */
public class Producto {

    private int id;
    private int idCategoria;
    private String codigo;
    private String descripcion;
    private double precioCompra;
    private double precioVenta;
    private int Existencia;
    private byte estatus;
    private LocalDate fechaVencimiento;
    private LocalDateTime fechaCreacion;
    private String comentario;
    private int top_aux;
    private Categoria categoria;
    //private Marca marca;

    public Producto() {
    }

    public Producto(int id, int idCategoria, String codigo, String descripcion, double precioCompra, double precioVenta, int Existencia, byte estatus, LocalDate fechaVencimiento, LocalDateTime fechaCreacion, String comentario) {
        this.id = id;
        this.idCategoria = idCategoria;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.Existencia = Existencia;
        this.estatus = estatus;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaCreacion = fechaCreacion;
        this.comentario = comentario;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idCategoria
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precioCompra
     */
    public double getPrecioCompra() {
        return precioCompra;
    }

    /**
     * @param precioCompra the precioCompra to set
     */
    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    /**
     * @return the precioVenta
     */
    public double getPrecioVenta() {
        return precioVenta;
    }

    /**
     * @param precioVenta the precioVenta to set
     */
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * @return the Existencia
     */
    public int getExistencia() {
        return Existencia;
    }

    /**
     * @param Existencia the Existencia to set
     */
    public void setExistencia(int Existencia) {
        this.Existencia = Existencia;
    }

    /**
     * @return the estatus
     */
    public byte getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(byte estatus) {
        this.estatus = estatus;
    }

    /**
     * @return the fechaVencimiento
     */
    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * @param fechaVencimiento the fechaVencimiento to set
     */
    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * @return the fechaCreacion
     */
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCReacion to set
     */
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the top_aux
     */
    public int getTop_aux() {
        return top_aux;
    }

    /**
     * @param top_aux the top_aux to set
     */
    public void setTop_aux(int top_aux) {
        this.top_aux = top_aux;
    }

    /**
     * @return the categoría
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoría to set
     */
    public void setCategoría(Categoria categoria) {
        this.categoria = categoria;
    }
    
     public class EstatusProducto {

        public static final byte ENEXISTENCIA = 1;
        public static final byte NOHAYEXISTENCIAS = 2;
    }

}
