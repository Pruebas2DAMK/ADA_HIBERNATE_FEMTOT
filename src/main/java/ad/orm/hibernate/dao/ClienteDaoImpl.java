package ad.orm.hibernate.dao;

import ad.orm.hibernate.domain.Cliente;
import ad.orm.hibernate.domain.Cliente_;
import ad.orm.hibernate.domain.Contacto_cliente;
import ad.orm.hibernate.domain.Contacto_cliente_;
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
    public void insertContacto(Contacto_cliente contacto_cliente) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(contacto_cliente); //guarda nuevo cliente
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
    public void updateContacto(Contacto_cliente contacto_cliente) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(contacto_cliente); //actualiza contacto
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
           session.delete(this.read(idCliente)); //Elimina el cliente a traves de la id y su contacto
            transaction.commit();
        }catch (HibernateException e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
    @Override
    public Cliente read(int id) { //solo lee el cliente evitando otros datos
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

    @Override
    public Contacto_cliente readContacto(int id) {
        Contacto_cliente contacto_cliente = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            contacto_cliente = session.load(Contacto_cliente.class,id);
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return contacto_cliente;
    }

    @Override
    public List<Cliente> readAll() {
        List<Cliente> clienteList = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
            Root<Cliente>root = criteria.from(Cliente.class);

            criteria.select(root);
            clienteList = session.createQuery(criteria).getResultList(); //todos los clientes

        }catch (HibernateException e){
            clienteList = null;
            e.printStackTrace();
        }
        return clienteList;
    }
}
