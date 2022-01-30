package ad.orm.hibernate.dao;

import ad.orm.hibernate.domain.Cliente;
import ad.orm.hibernate.domain.Cliente_;
import ad.orm.hibernate.domain.Trabajo;
import ad.orm.hibernate.domain.Trabajo_;
import ad.orm.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TrabajoDaoImpl implements  TrabajoDao{
    @Override
    public void insert(Trabajo trabajo) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(trabajo); //guarda nuevo
            transaction.commit();
        }catch (HibernateException e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(Trabajo trabajo) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(trabajo); //actualiza
            transaction.commit();
        }catch (HibernateException e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(this.read(id)); //Elimina
            transaction.commit();
        }catch (HibernateException e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Trabajo read(int id) {
        Trabajo trabajo = null;
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Trabajo> criteria = builder.createQuery(Trabajo.class);
            Root<Trabajo> root = criteria.from(Trabajo.class);

            criteria.where(
                    builder.equal(root.get(Trabajo_.cod_trabajo),id) //cuando coincide con id
            );
            trabajo = session.createQuery(criteria).getSingleResult(); //cliente = a coincidencia
            transaction.commit();
        }catch (HibernateException e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return trabajo;
    }

    @Override
    public List<Trabajo> readAll() {
        List<Trabajo>trabajoList =  new ArrayList<>();
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Trabajo> criteria = builder.createQuery(Trabajo.class);
            Root<Trabajo> root = criteria.from(Trabajo.class);

            criteria.select(root);
            trabajoList = session.createQuery(criteria).getResultList(); //todos

            transaction.commit();
        }catch (HibernateException e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return trabajoList;
    }

    @Override
    public List<Trabajo> readAllByCliente(Cliente cliente) {
        List<Trabajo>trabajoList = new ArrayList<>();
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Trabajo> criteria = builder.createQuery(Trabajo.class);
            Root<Trabajo>root = criteria.from(Trabajo.class);

            Join<Trabajo, Cliente> join = root.join(Trabajo_.cod_clienteFK);

            criteria.where(
                    builder.equal(join.get(Cliente_.cod_cliente),cliente.getCod_cliente())
            );

            trabajoList = session.createQuery(criteria).getResultList();
            transaction.commit();
        }catch (HibernateException e){
            trabajoList = null;
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return trabajoList;
    }
}
