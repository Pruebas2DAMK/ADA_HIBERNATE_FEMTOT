package ad.orm.hibernate.domain;

public class Producto {
    //TODO : Las relaciones M:N mantienen datos, averiguar si en este sistema hay que generar el POJO en estos casos, de momento no existen, pero si que habra que hacerlas

    private int cod_producto;
    private String nombre;

    //********CONSTRUCTOR********//

    public Producto() { }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    //*******GETTER&SETTER********//

    public int getCod_producto() {
        return cod_producto;
    }
    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //*******TOSTRING********//

    @Override
    public String toString() {
        return  cod_producto + " " + nombre;
    }
}
