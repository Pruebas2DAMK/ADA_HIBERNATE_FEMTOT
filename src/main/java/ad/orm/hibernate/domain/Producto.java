package ad.orm.hibernate.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_producto")
    private int cod_producto;
    @Column(name = "nombre")
    private String nombre;
    //Bidirecional M:N
    @OneToMany(mappedBy = "proovedor")
    private Set<Producto_proovedor> producto_proovedor = new HashSet<>();
    @OneToMany(mappedBy = "trabajo")
    private Set<Trabajo_producto> producto_trabajo = new HashSet<>();

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
