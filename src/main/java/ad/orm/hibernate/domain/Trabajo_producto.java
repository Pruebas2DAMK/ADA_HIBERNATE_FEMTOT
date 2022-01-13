package ad.orm.hibernate.domain;

public class Trabajo_producto {

    private int cod_trabajo;
    private int cod_producto;
    private int cantidad;

    //********CONSTRUCTOR********//

    public Trabajo_producto() { }

    public Trabajo_producto(int cod_trabajo, int cod_producto, int cantidad) {
        this.cod_trabajo = cod_trabajo;
        this.cod_producto = cod_producto;
        this.cantidad = cantidad;
    }

    //********SETTER&GETTER********//

    public int getCod_trabajo() {
        return cod_trabajo;
    }
    public void setCod_trabajo(int cod_trabajo) {
        this.cod_trabajo = cod_trabajo;
    }
    public int getCod_producto() {
        return cod_producto;
    }
    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //********TOSTRING********//

    @Override
    public String toString() {
        return cod_trabajo + " " + cod_producto + " " + cantidad;
    }
}
