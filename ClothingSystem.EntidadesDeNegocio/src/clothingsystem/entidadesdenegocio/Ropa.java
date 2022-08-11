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

   private int Id;
   private int IdMarca;
   private String CodigoBarra;
   private String Nombre;
   private double PrecioCompra;
   private double PrecioVenta;
   private int Existencia;
   private byte Estatus;
   private String Talla;
   private String Color;
   private String Estilo;
   private String Description;
   private String TipoTela;
   private int Top_aux;

    public Ropa() {
    }

    public Ropa(int Id, int IdMarca, String CodigoBarra, String Nombre, double PrecioCompra, double PrecioVenta, int Existencia, byte Estatus, String Talla, String Color, String Estilo, String Description, String TipoTela) {
        this.Id = Id;
        this.IdMarca = IdMarca;
        this.CodigoBarra = CodigoBarra;
        this.Nombre = Nombre;
        this.PrecioCompra = PrecioCompra;
        this.PrecioVenta = PrecioVenta;
        this.Existencia = Existencia;
        this.Estatus = Estatus;
        this.Talla = Talla;
        this.Color = Color;
        this.Estilo = Estilo;
        this.Description = Description;
        this.TipoTela = TipoTela;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdMarca() {
        return IdMarca;
    }

    public void setIdMarca(int IdMarca) {
        this.IdMarca = IdMarca;
    }

    public String getCodigoBarra() {
        return CodigoBarra;
    }

    public void setCodigoBarra(String CodigoBarra) {
        this.CodigoBarra = CodigoBarra;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(double PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public int getExistencia() {
        return Existencia;
    }

    public void setExistencia(int Existencia) {
        this.Existencia = Existencia;
    }

    public byte getEstatus() {
        return Estatus;
    }

    public void setEstatus(byte Estatus) {
        this.Estatus = Estatus;
    }

    public String getTalla() {
        return Talla;
    }

    public void setTalla(String Talla) {
        this.Talla = Talla;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getEstilo() {
        return Estilo;
    }

    public void setEstilo(String Estilo) {
        this.Estilo = Estilo;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getTipoTela() {
        return TipoTela;
    }

    public void setTipoTela(String TipoTela) {
        this.TipoTela = TipoTela;
    }

    public int getTop_aux() {
        return Top_aux;
    }

    public void setTop_aux(int Top_aux) {
        this.Top_aux = Top_aux;
    }

   
   
}
