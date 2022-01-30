package ad.orm.hibernate.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    //ManyToMany Trabajo_Producto

    @OneToMany(mappedBy = "productoToTrabajo")
    List<Trabajo_producto> trabajosToProductos = new ArrayList<>();

   /*
    @OneToMany(mappedBy = "productoToProovedor") //TODO El fallo esta en la relacion producto_proveedor
    List<Producto_proovedor> proovedoresToProductos = new ArrayList<>();
    */

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

    public List<Trabajo_producto> getTrabajosToProductos() {
        return trabajosToProductos;
    }

    public void setTrabajosToProductos(List<Trabajo_producto> trabajosToProductos) {
        this.trabajosToProductos = trabajosToProductos;
    }
    //*******TOSTRING********//

    @Override
    public String toString() {
        return  cod_producto + " " + nombre;
    }
}
