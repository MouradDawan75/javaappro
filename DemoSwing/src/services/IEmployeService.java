package services;

import java.util.List;

import dtos.EmployeDto;

public interface IEmployeService {

	List<EmployeDto> getAll() throws Exception;

	EmployeDto getById(int id) throws Exception;

	void insert(EmployeDto dto) throws Exception;

	void update(EmployeDto dto) throws Exception;

	void delete(int id) throws Exception;

}