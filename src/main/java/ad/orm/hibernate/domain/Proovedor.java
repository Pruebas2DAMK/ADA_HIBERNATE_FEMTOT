package ad.orm.hibernate.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Proovedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_proovedor;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "poblacion")
    private String poblacion;
    @Column(name = "telefono")
    private int telefono;
    //Bidirecional M:N
    @OneToMany(mappedBy = "producto")
    private Set<Producto_proovedor> proovedor_producto = new HashSet<>();

    //********CONSTRUCTOR********//

    public Proovedor() { }

    public Proovedor(int cod_proovedor,String nombre, String poblacion, int telefono) {
        this.cod_proovedor = cod_proovedor;
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
