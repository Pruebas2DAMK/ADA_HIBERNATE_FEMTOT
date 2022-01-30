package ad.orm.hibernate.dao;


import ad.orm.hibernate.domain.Producto;
import ad.orm.hibernate.domain.Trabajo;

import java.util.List;

public interface ProductoDao {
    public void insert(Producto producto);
    public void update(Producto producto);
    public void delete(int id);
    public Producto read(int id);
    public List<Producto> readAll();
    public List<Producto> readAllByTrabajo(Trabajo trabajo);
}
