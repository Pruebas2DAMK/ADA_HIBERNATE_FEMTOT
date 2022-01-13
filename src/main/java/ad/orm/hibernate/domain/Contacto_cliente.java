package ad.orm.hibernate.domain;

public class Contacto_cliente {

    private int dni_cliente;
    private int telefono;
    private String email;
    private String poblacion;
    private String direccion;

    //********CONSTRUCTOR********//

    public Contacto_cliente(){ }
    //TODO : Solucionar duda de quien recibe el PK de que tabla automaticamente
    /*
    En principio vamos a suponer que si puede existir un cliente sin contacto pero un contacto depende totalmente de la existencia del cliente
    por lo que el contacto recibe su identificador de la existencia del cliente.
     */
    public Contacto_cliente(int telefono, String email, String poblacion, String direccion) {
        this.telefono = telefono;
        this.email = email;
        this.poblacion = poblacion;
        this.direccion = direccion;
    }

    //********SETTER&GETTER********//

    public int getDni_cliente() {
        return dni_cliente;
    }
    public void setDni_cliente(int dni_cliente) {
        this.dni_cliente = dni_cliente;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPoblacion() {
        return poblacion;
    }
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //********TOSTRING********//


    @Override
    public String toString() {
        return dni_cliente + " " + telefono + " " +
                email + " " + poblacion + " " + direccion;
    }
}
