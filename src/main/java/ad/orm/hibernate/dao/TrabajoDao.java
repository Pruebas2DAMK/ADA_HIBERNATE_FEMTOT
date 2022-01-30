package ad.orm.hibernate.dao;

import ad.orm.hibernate.domain.Cliente;
import ad.orm.hibernate.domain.Trabajo;

import java.util.List;

public interface TrabajoDao {
    public void insert(Trabajo trabajo);
    public void update(Trabajo trabajo); //con el update puedo cambiar las fechas y hacerlo todo con los setter y getter
    public void delete(int id);
    public Trabajo read(int id);
    public List<Trabajo> readAll();
    public List<Trabajo> readAllByCliente(Cliente cliente);
}
