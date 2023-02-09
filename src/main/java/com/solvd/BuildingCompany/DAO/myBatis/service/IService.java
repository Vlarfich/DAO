package com.solvd.BuildingCompany.DAO.myBatis.service;

import java.util.List;

public interface IService<K, T> {
    void create(T entity);
    void update(T entity);
    void delete(K id);
    T read(K id);
    List<T> read();
}
