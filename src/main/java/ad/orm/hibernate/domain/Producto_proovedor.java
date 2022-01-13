package ad.orm.hibernate.domain;

public class Producto_proovedor {

    private int cod_producto;
    private int cod_proovedor;
    private float precio;
    private float descuento;

    //********CONSTRUCTOR********//

    public Producto_proovedor() { }

    public Producto_proovedor(int cod_producto, int cod_proovedor, float precio, float descuento) {
        this.cod_producto = cod_producto;
        this.cod_proovedor = cod_proovedor;
        this.precio = precio;
        this.descuento = descuento;
    }

    //********SETTER&GETTER********//

    public int getCod_producto() {
        return cod_producto;
    }
    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }
    public int getCod_proovedor() {
        return cod_proovedor;
    }
    public void setCod_proovedor(int cod_proovedor) {
        this.cod_proovedor = cod_proovedor;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public float getDescuento() {
        return descuento;
    }
    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    //********TOSTRING********//

    @Override
    public String toString() {
        return  cod_producto + " " + cod_proovedor +
                " " + precio + " " + descuento;
    }
}
