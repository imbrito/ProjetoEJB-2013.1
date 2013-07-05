package br.iff.campos.pooa20131n.projeto.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String cidade;

	private String email;

	private String nome;

	private String telefone;

	private String uf;

	//bi-directional many-to-one association to Fornecedorservico
	@OneToMany(mappedBy="usuario")
	private List<Fornecedorservico> fornecedorservicos;

	//bi-directional many-to-one association to Ordemservico
	@OneToMany(mappedBy="usuario")
	private List<Ordemservico> ordemservicos;

	public Usuario() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Fornecedorservico> getFornecedorservicos() {
		return this.fornecedorservicos;
	}

	public void setFornecedorservicos(List<Fornecedorservico> fornecedorservicos) {
		this.fornecedorservicos = fornecedorservicos;
	}

	public Fornecedorservico addFornecedorservico(Fornecedorservico fornecedorservico) {
		getFornecedorservicos().add(fornecedorservico);
		fornecedorservico.setUsuario(this);

		return fornecedorservico;
	}

	public Fornecedorservico removeFornecedorservico(Fornecedorservico fornecedorservico) {
		getFornecedorservicos().remove(fornecedorservico);
		fornecedorservico.setUsuario(null);

		return fornecedorservico;
	}

	public List<Ordemservico> getOrdemservicos() {
		return this.ordemservicos;
	}

	public void setOrdemservicos(List<Ordemservico> ordemservicos) {
		this.ordemservicos = ordemservicos;
	}

	public Ordemservico addOrdemservico(Ordemservico ordemservico) {
		getOrdemservicos().add(ordemservico);
		ordemservico.setUsuario(this);

		return ordemservico;
	}

	public Ordemservico removeOrdemservico(Ordemservico ordemservico) {
		getOrdemservicos().remove(ordemservico);
		ordemservico.setUsuario(null);

		return ordemservico;
	}

}