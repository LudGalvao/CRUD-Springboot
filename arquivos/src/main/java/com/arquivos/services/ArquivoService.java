package com.arquivos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arquivos.entity.Arquivo;
import com.arquivos.repository.ArquivoRepository;

import jakarta.transaction.Transactional;

@Service
public class ArquivoService {
	private final ArquivoRepository arquivoRepository;
	
	
	public ArquivoService(ArquivoRepository arquivoRepository) {
		this.arquivoRepository = arquivoRepository;
	}
	
	// Vai buscar todos os dados da Tabela Arquivos
	public List<Arquivo> getAllData(){
		return arquivoRepository.findAll();
	}
	
	// Vai deletar pelo id.
	public void deleteArquivosById(String id) {
		arquivoRepository.deleteById(id);
	}
	
	// Vai salvar um dado na Tabela Arquivos
	@Transactional // Todas as operações dentro desse método serão tratada como uma unica unidade transacional
	public Arquivo saveArquivo(Arquivo arquivo) {
		return arquivoRepository.save(arquivo);
	}
	
	// Vai buscar o dados pelo id
	public Arquivo getArquivoById(String id) {
		Optional<Arquivo> arquivo = arquivoRepository.findById(id);  // O Optional serve para lidar com a possibilidade de um valor estar ausente
		// Se o arquivo existir no Optional, retorna ele; senão, retorna null
		return arquivo.orElse(null);
	}
	
	// vai atualizar o banco...
	@Transactional
	public Arquivo updateArquivo(String id, Arquivo novoArquivo) {
		Arquivo arquivoExistente = arquivoRepository.findById(id).orElse(null);
		if(arquivoExistente != null) {
			arquivoExistente.setUsuario(novoArquivo.getUsuario());
			arquivoExistente.setDescricao(novoArquivo.getDescricao());
			arquivoExistente.setData(novoArquivo.getData());
			arquivoExistente.setVersao(novoArquivo.getVersao());
			arquivoExistente.setLink(novoArquivo.getLink());
			arquivoExistente.setLocal(novoArquivo.getLocal());
			arquivoExistente.setProjeto(novoArquivo.getProjeto());
			arquivoExistente.setEtapa(novoArquivo.getEtapa());
			arquivoExistente.setPai(novoArquivo.getPai());
			
			return arquivoRepository.save(arquivoExistente);
		}
		
		else {
			return null;
		}
	}
}
