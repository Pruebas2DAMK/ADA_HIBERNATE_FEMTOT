package ad.orm.hibernate.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_producto")
    private int cod_producto;
    @Column(name = "nombre")
    private String nombre;
    //TO DO: Many to Many x 2

    //ManyToMany producto_proovedor
    @ManyToMany(mappedBy = "proovedorToProductos",fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private List<Trabajo> trabajosToProovedor = new ArrayList<Trabajo>();

    //ManyToMany Trabajo_Producto
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(
            name = "trabajo_producto",
            joinColumns = @JoinColumn(name = "cod_producto"),
            inverseJoinColumns =@JoinColumn(name = "cod_trabajo")
    )
    private List<Trabajo> trabajos = new ArrayList<Trabajo>();



    //********CONSTRUCTOR********//

    public Producto() { }

    public Producto(int cod_producto,String nombre) {
        this.cod_producto = cod_producto;
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
