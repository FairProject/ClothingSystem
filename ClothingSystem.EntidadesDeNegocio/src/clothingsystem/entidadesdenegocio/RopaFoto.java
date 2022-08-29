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

    private int Id;
    private int IdRopa;
    private String Url;
    private byte Estatus;
    private int top_aux;

    public RopaFoto() {
    }

    public RopaFoto(int Id, int IdRopa, String url, byte Estatus) {
        this.Id = Id;
        this.IdRopa = IdRopa;
        this.Url = url;
        this.Estatus = Estatus;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdRopa() {
        return IdRopa;
    }

    public void setIdRopa(int IdRopa) {
        this.IdRopa = IdRopa;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        this.Url = url;
    }

    public byte getEstatus() {
        return Estatus;
    }

    public void setEstatus(byte Estatus) {
        this.Estatus = Estatus;
    }

    public int getTop_aux() {
        return top_aux;
    }

    public void setTop_aux(int top_aux) {
        this.top_aux = top_aux;
    }

    public class EstatusRopaFoto {

        public static final byte ACTIVO = 1;
        public static final byte INACTIVO = 2;
    }

}
