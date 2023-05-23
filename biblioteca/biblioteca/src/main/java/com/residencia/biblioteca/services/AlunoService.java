package com.residencia.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.dto.AlunoResumidoDTO;
import com.residencia.biblioteca.dto.EmprestimoResumidoDTO;
import com.residencia.biblioteca.dto.LivroResumidoDTO;
import com.residencia.biblioteca.dto.SaveAlunoDTO;
import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	EmailService emailService;

	public List<Aluno> getAllAlunos() {
		return alunoRepository.findAll();

	}

	public Aluno getAlunoById(Integer id) {
		return alunoRepository.findById(id).orElse(null);
	}

	public AlunoResumidoDTO getAlunoByDtoId(Integer id) {

		Aluno aluno = alunoRepository.findById(id).orElse(null);
		AlunoResumidoDTO alunoDTO = new AlunoResumidoDTO();

		if (null == aluno)
			return null;

		alunoDTO.setNome(aluno.getNome());
		alunoDTO.setCpf(aluno.getCpf());

		List<EmprestimoResumidoDTO> listaEmprestimoResDTO = new ArrayList<>();

		for (Emprestimo emprestimo : aluno.getEmprestimos()) {

			EmprestimoResumidoDTO emprestimoResDTO = new EmprestimoResumidoDTO();
			emprestimoResDTO.setDataEmprestimo(emprestimo.getDataEmprestimo());
			emprestimoResDTO.setDataEntrega(emprestimo.getDataEntrega());
			emprestimoResDTO.setValorEmprestimo(emprestimo.getValorEmprestimo());

			LivroResumidoDTO livroResDto = new LivroResumidoDTO();

			if (null == emprestimo.getLivro())
				livroResDto.setNomeLivro(null);
			else
				livroResDto.setNomeLivro(emprestimo.getLivro().getNomeLivro());

			emprestimoResDTO.setLivroResumidoDTO(livroResDto);
			listaEmprestimoResDTO.add(emprestimoResDTO);

		}

		alunoDTO.setListaEmprestimoResDTO(listaEmprestimoResDTO);

		return alunoDTO;
	}

	public Aluno saveAluno(Aluno aluno) {
		Aluno novoAluno = alunoRepository.save(aluno);
		emailService.enviarEmail("romuloandriolo@hotmail.com", "Novo Aluno Cadastrado", novoAluno.toString());
		return novoAluno;
	}

	public Aluno saveAlunoDTO(SaveAlunoDTO SaveAlunoDto) {

		return alunoRepository.save(SaveAlunoDto.toEntity());
	}

	// Cuidado quando for updar.
	public Aluno updateAluno(Aluno aluno, Integer id) {
		return alunoRepository.save(aluno);
	}

	public Boolean deleteAluno(Integer id) {
		alunoRepository.deleteById(id);
		Aluno alunoDeletado = alunoRepository.findById(id).orElse(null);
		if (null == alunoDeletado)
			return true;
		else
			return false;
	}

}
