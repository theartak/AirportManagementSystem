package repository;

import java.util.List;

public interface CrudRepo<T> {
    void create(T t);
    T read(Long id);
    void update(Long id, T t);
    void delete(Long id);
    List<T> getAll();
}