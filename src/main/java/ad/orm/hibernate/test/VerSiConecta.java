package ad.orm.hibernate.test;

import ad.orm.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class VerSiConecta {
    public static void main(String[] args) {
        //ver si conecta
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.close();
    }
}
