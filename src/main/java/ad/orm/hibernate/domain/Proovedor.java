package ad.orm.hibernate.domain;

public class Proovedor {

    private int cod_proovedor;
    private String nombre;
    private String poblacion;
    private int telefono;

    //********CONSTRUCTOR********//

    public Proovedor() { }

    public Proovedor(String nombre, String poblacion, int telefono) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.telefono = telefono;
    }

    //********GETTER&SETTER********//

    public int getCod_proovedor() {
        return cod_proovedor;
    }
    public void setCod_proovedor(int cod_proovedor) {
        this.cod_proovedor = cod_proovedor;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPoblacion() {
        return poblacion;
    }
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    //********TOSTRING********//

    @Override
    public String toString() {
        return cod_proovedor + " " + nombre + " " + poblacion +
                " " + telefono;
    }
}
