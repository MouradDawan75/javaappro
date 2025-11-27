package repositories;

import java.util.List;

import entities.Produit;

public interface IProduitRepository {

	void insert(Produit p) throws Exception;

	void update(Produit p) throws Exception;

	void delete(int id) throws Exception;

	List<Produit> getAll() throws Exception;

	Produit getById(int id) throws Exception;

}