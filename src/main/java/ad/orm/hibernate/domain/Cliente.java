package ad.orm.hibernate.domain;

public class Cliente {

   private int cod_cliente;
   private String nombre;
   private String apellido;

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
