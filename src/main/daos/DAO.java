package main.daos;

import java.util.List;
import java.util.Map;

public interface DAO<T> {

	T save(T entity);
	T update(T entity);
	T searchById(Long id);
	T searchForQuery(String query);
	T searchForQuery(String query, Map<String, Object> params);
	List<T> list();
	void delete(Long id);
}
