/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clothingsystem.entidadesdenegocio;

/**
 *
 * @author HP
 */
public class RopaFoto {

    private int id;
    private int idRopa;
    private String url;
    private byte estatus;
    private int top_aux;
    private Ropa ropa;

    public RopaFoto() {
    }

    public RopaFoto(int id, int idRopa, String url, byte estatus, Ropa ropa) {
        this.id = id;
        this.idRopa = idRopa;
        this.url = url;
        this.estatus = estatus;
        this.ropa = ropa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRopa() {
        return idRopa;
    }

    public void setIdRopa(int idRopa) {
        this.idRopa = idRopa;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte getEstatus() {
        return estatus;
    }

    public void setEstatus(byte estatus) {
        this.estatus = estatus;
    }

    public int getTop_aux() {
        return top_aux;
    }

    public void setTop_aux(int top_aux) {
        this.top_aux = top_aux;
    }

    public Ropa getRopa() {
        return ropa;
    }

    public void setRopa(Ropa ropa) {
        this.ropa = ropa;
    }

    public class EstatusRopaFoto {

        public static final byte ACTIVO = 1;
        public static final byte INACTIVO = 2;
    }

}
