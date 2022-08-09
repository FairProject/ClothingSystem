/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clothingsystem.entidadesdenegocio;

/**
 *
 * @author Abdias_Hernandez
 */
public class Ropa {

    private int id;
    private int idVendedor;
    private int idCategoria;
    private String nombre;
    private String descripcion;
    private double precio;
    private byte[] foto;

    private int top_aux;
//    private RopaMarca categorias;
    private Rol roles;

    public Ropa() {
    }

    public Ropa(int id, int idVendedor, int idCategoria, String nombre, String descripcion, float precio, byte[] foto) {
        this.id = id;
        this.idVendedor = idVendedor;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public int getTop_aux() {
        return top_aux;
    }

    public void setTop_aux(int top_aux) {
        this.top_aux = top_aux;
    }

//    public RopaMarca getCategorias() {
//        return categorias;
//    }
//
//    public void setCategorias(RopaMarca categorias) {
//        this.categorias = categorias;
//    }

    public Rol getVendedores() {
        return roles;
    }

    public void setVendedores(Rol roles) {
        this.roles = roles;
    }

    

}
