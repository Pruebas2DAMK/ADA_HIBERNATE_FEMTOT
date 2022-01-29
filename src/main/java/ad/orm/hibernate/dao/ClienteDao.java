package ad.orm.hibernate.dao;

import ad.orm.hibernate.domain.Cliente;

public interface ClienteDao {
    public void insert(Cliente cliente);
    public void update(Cliente cliente);
    public void delete(int id);
    public Cliente read(int id);
}
