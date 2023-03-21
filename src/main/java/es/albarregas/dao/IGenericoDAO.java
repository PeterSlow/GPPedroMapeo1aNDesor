package es.albarregas.dao;
import java.util.List;

public interface IGenericoDAO {

    public void add(Object object);
    public List<Object> get(String entidad);
    public Object getOne(Class clase, int pk);
    public void update(Object object);
    public void delete(Object object);
}