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
    private String foto;
    private int top_aux;
    private Categoria categoria;

    public Producto() {
    }

    public Producto(int id, int idCategoria, String codigo, String descripcion, double precioCompra, double precioVenta, int Existencia, byte estatus, LocalDate fechaVencimiento, LocalDateTime fechaCreacion, String comentario, String foto) {
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
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        return Existencia;
    }

    public void setExistencia(int Existencia) {
        this.Existencia = Existencia;
    }

    public byte getEstatus() {
        return estatus;
    }

    public void setEstatus(byte estatus) {
        this.estatus = estatus;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getTop_aux() {
        return top_aux;
    }

    public void setTop_aux(int top_aux) {
        this.top_aux = top_aux;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    

    public class EstatusProducto {

        public static final byte ENEXISTENCIA = 1;
        public static final byte NOHAYEXISTENCIAS = 2;
    }

}
