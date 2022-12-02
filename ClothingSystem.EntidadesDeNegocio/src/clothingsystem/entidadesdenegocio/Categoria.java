package clothingsystem.entidadesdenegocio;

import java.time.LocalDate;

public class Categoria {

    private int id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaCreacion;
    private String comentario;
    private byte estatus;
    private int top_aux;

    public Categoria() {
    }

    public Categoria(int id, String nombre, String descripcion, LocalDate fechaCreacion, String comentario, byte estatus, int top_aux) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.comentario = comentario;
        this.estatus = estatus;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @return the fechaCreacion
     */
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(LocalDate fechaCreacion) {
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

    public class EstatusCategoria {

        public static final byte ENEXISTENCIA = 1;
        public static final byte NOHAYEXISTENCIAS = 2;
    }

}
