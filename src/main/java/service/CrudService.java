package service;

import java.util.List;

public interface CrudService<T> {
    void create(T t);
    T read(Long id);
    void update(Long id, T t);
    void delete(Long id);
    List<T> getAll();
}