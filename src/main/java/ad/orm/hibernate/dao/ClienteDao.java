package ad.orm.hibernate.dao;

import ad.orm.hibernate.domain.Cliente;
import ad.orm.hibernate.domain.Contacto_cliente;

import java.util.List;

public interface ClienteDao {
    public void insert(Cliente cliente);
    public void insertContacto(Contacto_cliente contacto_cliente);
    public void update(Cliente cliente);
    public void updateContacto(Contacto_cliente contacto_cliente);
    public void delete(int id); //Delete on cascade one to one
    public Cliente read(int id);
    public Contacto_cliente readContacto(int id); //Devuelve cadena con el cliente y el contacto
    public List<Cliente> readAll();
}
