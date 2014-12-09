package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Meta {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String descricao;
	private String prioridade;
	private boolean metaAtingida;
	private int semana;

	public Meta(String nome, String descricao, String prioridade, int semana) {
		this.nome = nome;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.semana = semana;
		this.metaAtingida = false;
	}

	public Meta() {
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public boolean getStatus() {
		return metaAtingida;
	}

	public void setStatus(boolean atingida) {
		this.metaAtingida = atingida;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getSemana() {
		return semana;
	}

	public String getPrioridade() {
		return prioridade;
	}
}

