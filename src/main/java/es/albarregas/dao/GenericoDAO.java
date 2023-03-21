package es.albarregas.dao;
import es.albarregas.persistencia.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class GenericoDAO implements IGenericoDAO {

    @Override
    public void add(Object object) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(object);
            sesion.getTransaction().commit();
        } catch (org.hibernate.JDBCException jdbce) {
            if (sesion != null) {
                sesion.getTransaction().rollback();
            }
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }

    @Override
    public List<Object> get(String entidad) {
        List<Object> listado = null;
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            listado = sesion.createQuery(" from " + entidad).list();
            sesion.getTransaction().commit();
        } catch (org.hibernate.JDBCException jdbce) {
            if (sesion != null) {
                sesion.getTransaction().rollback();
            }
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
        return listado;
    }

    @Override
    public void delete(Object object) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(object);
            sesion.getTransaction().commit();
        } catch (org.hibernate.JDBCException jdbce) {
            if (sesion != null) {
                sesion.getTransaction().rollback();
            }
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }

    @Override
    public Object getOne(Class clase, int pk) {
        Object object = new Object();
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            object = (Object) sesion.get(clase, pk);
            sesion.getTransaction().commit();
        } catch (org.hibernate.JDBCException jdbce) {
            if (sesion != null) {
                sesion.getTransaction().rollback();
            }
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
        return object;
    }

    @Override
    public void update(Object object) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.update(object);
            sesion.getTransaction().commit();
        } catch (org.hibernate.JDBCException jdbce) {
            if (sesion != null) {
                sesion.getTransaction().rollback();
            }
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }

}