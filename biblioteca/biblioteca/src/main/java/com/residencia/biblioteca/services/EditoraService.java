package com.residencia.biblioteca.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.residencia.biblioteca.dto.EditoraResumidaDTO;
import com.residencia.biblioteca.dto.LivroResumidoDTO;
import com.residencia.biblioteca.dto.ReceitaWsDTO;
import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.entities.Livro;
import com.residencia.biblioteca.repositories.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	EditoraRepository editoraRepository;

	@Autowired
	ModelMapper modelMapper;

	public List<Editora> getAllEditoras() {
		return editoraRepository.findAll();

	}

	public Editora getEditoraById(Integer id) {
		return editoraRepository.findById(id).orElse(null);
	}

	public EditoraResumidaDTO getEditoraByDtoId(Integer id) {

		Editora editora = editoraRepository.findById(id).orElse(null);
		EditoraResumidaDTO editoraDTO = new EditoraResumidaDTO();

		if (null == editora)
			return null;
		editoraDTO.setCodigoEditora(editora.getCodigoEditora());
		editoraDTO.setNome(editora.getNome());

		List<LivroResumidoDTO> listaLivroResDTO = new ArrayList<>();
		for (Livro livro : editora.getLivros()) {

			LivroResumidoDTO livroResDTO = new LivroResumidoDTO();
			livroResDTO.setNomeLivro(livro.getNomeLivro());
			livroResDTO.setNomeAutor(livro.getNomeAutor());
			livroResDTO.setDataLancamento(livro.getDataLancamento());
			listaLivroResDTO.add(livroResDTO);
		}

		editoraDTO.setListaLivrosResDTO(listaLivroResDTO);

		return editoraDTO;

//		Editora editora = editoraRepository.findById(id).orElse(null);
//		if (null == editora)
//			return null;
//
//		EditoraResumidaDTO editoraDTO = new EditoraResumidaDTO(editora.getCodigoEditora(), editora.getNome());
//
//		return editoraDTO;

	}

	public Editora saveEditora(Editora editora) {

		return editoraRepository.save(editora);
	}

	public EditoraResumidaDTO saveEditoraDTO(EditoraResumidaDTO editoraResumidaDto) {
		
		ReceitaWsDTO recDto = consultaApiReceitaWs(editoraResumidaDto.getCnpj());
		System.out.println("ReceitaWsDTO:" + recDto);
		
		Editora editora = modelMapper.map(editoraResumidaDto, Editora.class);
		return modelMapper.map(editoraRepository.save(editora), EditoraResumidaDTO.class);
	}

	// Cuidado quando for updar.
	public Editora updateEditora(Editora editora, Integer id) {
		return editoraRepository.save(editora);
	}

	public Boolean deleteEditora(Integer id) {
		editoraRepository.deleteById(id);
		Editora editoraDeletado = editoraRepository.findById(id).orElse(null);
		if (null == editoraDeletado)
			return true;
		else
			return false;
	}

	private ReceitaWsDTO consultaApiReceitaWs(String cnpj) {

		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://receitaws.com.br/v1/cnpj/{cnpj}";

		Map<String, String> params = new HashMap<String, String>();
		params.put("cnpj", cnpj);

		ReceitaWsDTO recDto = restTemplate.getForObject(uri, ReceitaWsDTO.class, params);

		return recDto;
	}

}
