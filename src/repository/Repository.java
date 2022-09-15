package repository;

import java.util.List;

public interface Repository<T> {

    boolean create(T t);

    boolean update(T t, T tr);

    T read(String username, String password);

    boolean delete(T t);

    List<T> readAll();

}
