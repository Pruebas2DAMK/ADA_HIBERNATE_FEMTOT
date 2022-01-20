package ad.orm.hibernate.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Proovedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_proovedor;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "poblacion")
    private String poblacion;
    @Column(name = "telefono")
    private int telefono;
    // TO DO : Many to Many
    //ManyToMany producto_proovedor
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(
            name = "producto_proovedor",
            joinColumns = @JoinColumn(name = "cod_proovedor"),
            inverseJoinColumns =@JoinColumn(name = "cod_producto")
    )
    private List<Producto>proovedorToProductos = new ArrayList<>();

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
