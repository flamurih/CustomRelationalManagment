package repository;

import model.Contract;

import java.util.List;

public interface TelecomRepository<T> {
    void create(T entity);
    T findById(int id);
    List<T> findAll();
    boolean deleteById(int id);
    void update(T entity);
}

