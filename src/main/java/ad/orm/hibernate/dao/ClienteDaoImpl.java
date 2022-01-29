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

public class ClienteDaoImpl implements ClienteDao{

    @Override
    public void insert(Cliente cliente) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(cliente); //guarda nuevo cliente
            transaction.commit();
        }catch (HibernateException e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public void update(Cliente cliente) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(cliente); //actualiza cliente
            transaction.commit();
        }catch (HibernateException e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public void delete(int idCliente) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
           session.delete(this.read(idCliente)); //Elimina el cliente a traves de la id
            transaction.commit();
        }catch (HibernateException e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
    @Override
    public Cliente read(int id) {
        Cliente cliente = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
            Root<Cliente> root = criteria.from(Cliente.class);

            criteria.where(
                    builder.equal(root.get(Cliente_.cod_cliente),id) //cuando coincide con id
            );
            cliente = session.createQuery(criteria).getSingleResult(); //cliente = a coincidencia
        }catch (HibernateException e){
            e.printStackTrace();
        }

        return cliente;
    }
}
