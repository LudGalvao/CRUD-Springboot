package com.arquivos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "arquivo")
public class Arquivo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "arquivo_id", nullable = false)
	private String id;
	
	@Column(name = "usuario_id", nullable = false)
	private Integer usuario;
	
	@Column(name = "arquivo_descricao", nullable = false)
	private String descricao;
	
	@Column(name = "arquivo_data", nullable = false)
	private LocalDateTime data;
	
	@Column(name = "arquivo_versao", nullable = false, precision = 18, scale = 9)
	private BigDecimal versao;
	
	@Column(name = "arquivo_link", nullable = false)
	private String link;
	
	@Column(name = "local_id", nullable = false)
	private Integer local;
	
	@Column(name = "projeto_id", nullable = false)
	private Integer projeto;
	
	@Column(name = "etapa_id", nullable = false)
	private Integer etapa;
	
	@Column(name = "arquivo_id_pai", nullable = false)
	private String pai;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public BigDecimal getVersao() {
		return versao;
	}

	public void setVersao(BigDecimal versao) {
		this.versao = versao;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getLocal() {
		return local;
	}

	public void setLocal(Integer local) {
		this.local = local;
	}

	public Integer getProjeto() {
		return projeto;
	}

	public void setProjeto(Integer projeto) {
		this.projeto = projeto;
	}

	public Integer getEtapa() {
		return etapa;
	}

	public void setEtapa(Integer etapa) {
		this.etapa = etapa;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}
	
	
}