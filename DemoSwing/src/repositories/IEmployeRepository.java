package repositories;

import java.util.List;

import entities.Employe;

public interface IEmployeRepository {

	void insert(Employe e) throws Exception;

	void update(Employe e) throws Exception;

	void delete(int id) throws Exception;

	List<Employe> getAll() throws Exception;

	Employe getById(int id) throws Exception;

}