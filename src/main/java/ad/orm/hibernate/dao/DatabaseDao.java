package ad.orm.hibernate.dao;

import ad.orm.hibernate.domain.Cliente;

import javax.persistence.metamodel.SingularAttribute;

public interface DatabaseDao {
    public void insert(Object o);
    public void update(Object o);
    public void delete(int id,SingularAttribute<Object, Integer> generator);
    public Object read(int id, SingularAttribute<Object, Integer> generator);
}
