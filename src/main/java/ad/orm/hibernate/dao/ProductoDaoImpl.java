package ad.orm.hibernate.dao;

import ad.orm.hibernate.domain.*;
import ad.orm.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductoDaoImpl implements ProductoDao {
    @Override
    public void insert(Producto producto) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(producto); //guarda nuevo
            transaction.commit();
        }catch (HibernateException e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(Producto producto) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(producto); //actualiza
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
    public Producto read(int id) {
        Producto producto = null;
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Producto> criteria = builder.createQuery(Producto.class);
            Root<Producto> root = criteria.from(Producto.class);

            criteria.where(
                    builder.equal(root.get(Producto_.cod_producto),id) //cuando coincide con id
            );
            producto = session.createQuery(criteria).getSingleResult(); //cliente = a coincidencia
            transaction.commit();
        }catch (HibernateException e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public List<Producto> readAll() {
        List<Producto> productoList = null;
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Producto> criteria = builder.createQuery(Producto.class);
            Root<Producto> root = criteria.from(Producto.class);

            criteria.select(root);
            productoList = session.createQuery(criteria).getResultList(); //todos

            transaction.commit();
        }catch (HibernateException e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return productoList;
    }

    @Override
    public List<Producto> readAllByTrabajo(Trabajo trabajo) {
        List<Producto> productoList = null;
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Producto> criteria = builder.createQuery(Producto.class);
            Root<Producto>root = criteria.from(Producto.class);

            Join<Producto, Trabajo_producto> join = root.join(Producto_.trabajosToProductos); //revisar esto

            criteria.where(
                    builder.equal(join.get(String.valueOf(Trabajo_.cod_trabajo)),trabajo.getCod_trabajo())
            );

            productoList = session.createQuery(criteria).getResultList();
            transaction.commit();
        }catch (HibernateException e){
            productoList = null;
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return productoList;
    }
}
