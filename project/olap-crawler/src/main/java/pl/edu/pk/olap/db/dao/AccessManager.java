package pl.edu.pk.olap.db.dao;

import java.util.List;

/**
 * User: suowik
 * Date: 21.04.13
 * Time: 18:07
 */
public interface AccessManager<T> {
    void insertAll(List<T> entities);
    void insert(T entity);
}
