package ad.orm.hibernate.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    @Id
    @Column (name = "cod_cliente")
   private int cod_cliente;
    @Column (name = "nombre")
   private String nombre;
    @Column (name = "apellido")
   private String apellido;
    @OneToMany(mappedBy = "cod_clienteFK",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Trabajo> trabajos = new ArrayList<>();
    //One to One Bidireccional
    @OneToOne(mappedBy = "dni_cliente", cascade = CascadeType.ALL)
    private Contacto_cliente contacto_cliente;

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

    public Contacto_cliente getContacto_cliente() {
        return contacto_cliente;
    }
    public void setContacto_cliente(Contacto_cliente contacto_cliente) {
        this.contacto_cliente = contacto_cliente;
    }
    //********TOSTRING********//

    @Override
    public String toString() {
        return cod_cliente + " " + nombre + " " + apellido;
    }
}
