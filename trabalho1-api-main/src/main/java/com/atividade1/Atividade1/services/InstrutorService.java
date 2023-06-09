package com.atividade1.Atividade1.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade1.Atividade1.dto.InstrutorDTO;
import com.atividade1.Atividade1.entities.Instrutor;
import com.atividade1.Atividade1.repositories.InstrutorRepository;

@Service
public class InstrutorService {

	@Autowired
	private InstrutorRepository instrutorRepository;

	public List<Instrutor> getAllInstrutors() { 
		return instrutorRepository.findAll();
	}
	
	public List<InstrutorDTO> getAllInstrutorsDTO() { 
		ModelMapper modelMapper = new ModelMapper();
		List<InstrutorDTO> instrutoresDTO = new ArrayList<>();
		for (Instrutor instrutor: instrutorRepository.findAll()) {
			instrutoresDTO.add(modelMapper.map(instrutor, InstrutorDTO.class));
		}
		return instrutoresDTO;
	}
	
	public Instrutor getInstrutorById(Integer id) {
		return instrutorRepository.findById(id).orElse(null);
	}
	
//	public Instrutor saveInstrutor(Instrutor instrutor) { 
//		Instrutor novoInstrutor = instrutorRepository.save(instrutor);
//		emailService.enviarEmail()
//		return instrutorRepository.save(instrutor); 
//	}
	
	public Instrutor saveInstrutor(Instrutor instrutor) { 
		return instrutorRepository.save(instrutor); 
	}
	
	public Instrutor updateInstrutor(Instrutor instrutor, Integer id) { 
		return instrutorRepository.save(instrutor);
	}

	public Boolean delInstrutor(Integer id) {
		Instrutor instrutor = instrutorRepository.findById(id).orElse(null);
		
		if (instrutor != null) {
			instrutorRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
