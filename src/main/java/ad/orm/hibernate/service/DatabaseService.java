package ad.orm.hibernate.service;

import ad.orm.hibernate.dao.DatabaseDao;
import ad.orm.hibernate.dao.DatabaseDaoImpl;
import ad.orm.hibernate.domain.Cliente;

import javax.persistence.metamodel.SingularAttribute;
//***No usar en el trabajo pero tenerla para testear despues***//
public class DatabaseService {
    DatabaseDao databaseDao;
    public DatabaseService(){
        databaseDao = new DatabaseDaoImpl();
    }
    public void save(Object o){
        databaseDao.insert(o);
    }
    public void delete(int id, SingularAttribute<Object, Integer> generator){
        databaseDao.delete(id,generator);
    }
    public Object getObjectById(int id,SingularAttribute<Object, Integer> generator){
        return databaseDao.read(id,generator);
    }

    public void update(Object o){
        databaseDao.update(o);
    }

}
