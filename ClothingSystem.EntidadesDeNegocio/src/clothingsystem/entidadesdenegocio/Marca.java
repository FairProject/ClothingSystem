/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clothingsystem.entidadesdenegocio;

import java.util.ArrayList;

/**
 *
 * @author edwin
 */
public class Marca {
    private int id;
    private String nombre;
    private byte estatus;
    private String descripcion;
    private String paisOrigen;
    private int top_aux;
    private ArrayList<Marca> marcas;

    public Marca() {
        
    }

    public Marca(int id, String nombre, byte estatus, String descripcion, String paisOrigen) {
        this.id = id;
        this.nombre = nombre;
        this.estatus = estatus;
        this.descripcion = descripcion;
        this.paisOrigen = paisOrigen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEstatus() {
        return estatus;
    }

    public void setEstatus(byte estatus) {
        this.estatus = estatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public int getTop_aux() {
        return top_aux;
    }

    public void setTop_aux(int top_aux) {
        this.top_aux = top_aux;
    }

    public ArrayList<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(ArrayList<Marca> marcas) {
        this.marcas = marcas;
    }

   
    
    public class EstatusMarca {

        public static final byte ACTIVO = 1;
        public static final byte INACTIVO = 2;
    }
    
    
}
