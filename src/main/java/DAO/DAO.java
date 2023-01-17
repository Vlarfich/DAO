package DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<K extends Number, T> {

    public abstract List<T> findAll();

    public abstract T findEntityById(K id);

    public abstract boolean delete(K id) throws SQLException;

    public abstract boolean delete(T entity);

    public abstract boolean create(T entity);

    public abstract T update(T entity);
}