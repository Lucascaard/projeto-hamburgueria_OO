package main.daos;

import java.util.List;
import java.util.Map;

public interface DAO<T> {
	
	//NÃO É NECESSARIO FAZER ALTERAÇÃO AQUI, ESTE É UM MODELO QUE TODAS AS CLASSES DEVEM IMPLEMENTAR
	T save(T entity);
	T update(T entity);
	T searchById(Long id);
	T searchForQuery(String query);
	T searchForQuery(String query, Map<String, Object> params);
	List<T> list();
	void delete(Long id);
}
