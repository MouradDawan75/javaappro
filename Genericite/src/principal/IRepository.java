package principal;

import java.util.List;

public interface IRepository<T> {

	List<T> getAll();
	void insert(T obj);
}
