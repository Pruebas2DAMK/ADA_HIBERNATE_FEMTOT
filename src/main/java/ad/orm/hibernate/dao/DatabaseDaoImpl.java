package ad.orm.hibernate.dao;

import ad.orm.hibernate.domain.Cliente;
import ad.orm.hibernate.domain.Cliente_;
import ad.orm.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

public class DatabaseDaoImpl implements DatabaseDao {
    @Override
    public void insert(Object o) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(o); //guarda nuevo cliente
            transaction.commit();
        }catch (HibernateException e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public void update(Object o) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(o); //actualiza lo que sea
            transaction.commit();
        }catch (HibernateException e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    //generator = clasequesea_.id //jpamodelgen
    @Override
    public void delete(int id,SingularAttribute<Object, Integer> generator) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(this.read(id,generator)); //Elimina el cliente a traves de la id
            transaction.commit();
        }catch (HibernateException e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public Object read(int id,SingularAttribute<Object, Integer> generator) {
        Object o = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
            Root<Cliente> root = criteria.from(Cliente.class);


            criteria.where(
                    builder.equal(root.get(generator),id) //cuando coincide con id
            );
            o = session.createQuery(criteria).getSingleResult(); //cliente = a coincidencia
        }catch (HibernateException e){
            e.printStackTrace();
        }

        return o;
    }
}
