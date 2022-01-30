package ad.orm.hibernate.service;

import ad.orm.hibernate.dao.TrabajoDao;
import ad.orm.hibernate.dao.TrabajoDaoImpl;
import ad.orm.hibernate.domain.Cliente;
import ad.orm.hibernate.domain.Trabajo;

import java.util.List;

public class TrabajoService {
    TrabajoDao trabajoDao;
    public TrabajoService(){
        trabajoDao = new TrabajoDaoImpl();
    }
    public void save(Trabajo trabajo){
        trabajoDao.insert(trabajo);
    }

    public void update(Trabajo trabajo){
        trabajoDao.update(trabajo);
    }

    public void delete(int id){
        trabajoDao.delete(id);
    }

    public Trabajo read(int id){
        return trabajoDao.read(id);
    }

    public List<Trabajo>readAll(){
        return trabajoDao.readAll();
    }

    public List<Trabajo>getTrabajosByCliente(Cliente cliente){
        return trabajoDao.readAllByCliente(cliente);
    }

}
