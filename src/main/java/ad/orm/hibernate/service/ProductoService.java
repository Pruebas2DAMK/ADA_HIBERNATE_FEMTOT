package ad.orm.hibernate.service;

import ad.orm.hibernate.dao.ProductoDao;
import ad.orm.hibernate.dao.ProductoDaoImpl;
import ad.orm.hibernate.domain.Producto;
import ad.orm.hibernate.domain.Trabajo;

import java.util.List;

public class ProductoService {
    ProductoDao productoDao;
    public ProductoService(){
        productoDao = new ProductoDaoImpl();
    }
    public void save(Producto producto){
        productoDao.insert(producto);
    }
    public void update(Producto producto){
        productoDao.update(producto);
    }
    public void delete(int id){
        productoDao.delete(id);
    }
    public Producto read (int id){
        return productoDao.read(id);
    }

    public List<Producto> readAll(){
        return productoDao.readAll();
    }

    public List<Producto>getProductosByTrabajo(Trabajo trabajo){ //TODO pendiente para más adelante
        return productoDao.readAllByTrabajo(trabajo);
    }
}
