package services;

import java.util.ArrayList;
import java.util.List;

import dtos.EmployeDto;
import entities.Employe;
import entities.Poste;
import repositories.IEmployeRepository;

public class EmployeServiceImpl implements IEmployeService {
	
	private IEmployeRepository repo;
	
	public EmployeServiceImpl(IEmployeRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public List<EmployeDto> getAll() throws Exception{
		
		List<EmployeDto> lst = new ArrayList<EmployeDto>();
		
		List<Employe> entities = repo.getAll();
		for(Employe e : entities) {
			EmployeDto dto = ConverterService.getDtofromEntity(e);
			lst.add(dto);
		}
		
		return lst;
	}
	
	@Override
	public EmployeDto getById(int id) throws Exception{
		Employe entity = repo.getById(id);
		return ConverterService.getDtofromEntity(entity);
	}
	
	@Override
	public void insert(EmployeDto dto) throws Exception {
		Employe e = new Employe(dto.getId(), dto.getNom(), dto.getPrenom(), Poste.DEVELOPPEUR, dto.getSalaire());
		repo.insert(e);
	}
	
	@Override
	public void update(EmployeDto dto) throws Exception {
		Employe entity = repo.getById(dto.getId()); //récupérer le poste depuis la BD
		entity.setNom(dto.getNom());
		entity.setPrenom(dto.getPrenom());
		entity.setSalaire(dto.getSalaire());
		repo.update(entity);
	}
	
	@Override
	public void delete(int id) throws Exception{
		repo.delete(id);
	}

}
