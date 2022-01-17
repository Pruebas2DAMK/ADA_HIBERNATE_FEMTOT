package ad.orm.hibernate.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column (name = "cod_cliente")
   private int cod_cliente;
    @Column (name = "nombre")
   private String nombre;
    @Column (name = "apellido")
   private String apellido;
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Trabajo> trabajos;

   //********CONSTRUCTOR********//

    public Cliente(){ }

    public Cliente(int cod_cliente, String nombre, String apellido) {
        this.cod_cliente = cod_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //********GETTER&SETTER********//

    public int getCod_cliente() {
        return cod_cliente;
    }
    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //********TOSTRING********//

    @Override
    public String toString() {
        return cod_cliente + " " + nombre + " " + apellido;
    }
}
