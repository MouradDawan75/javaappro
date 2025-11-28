package services;

import dtos.EmployeDto;
import entities.Employe;

public class ConverterService {

	public static EmployeDto getDtofromEntity(Employe e) {
		EmployeDto dto = new EmployeDto(e.getId(), e.getNom(), e.getPrenom(), e.getSalaire());
		return dto;
	}

}
