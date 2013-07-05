package br.iff.campos.pooa20131n.projeto.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the servico database table.
 * 
 */
@Entity
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String descricao;

	private float preco;

	private String tag;

	//bi-directional many-to-one association to Fornecedorservico
	@OneToMany(mappedBy="servico")
	private List<Fornecedorservico> fornecedorservicos;

	public Servico() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return this.preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<Fornecedorservico> getFornecedorservicos() {
		return this.fornecedorservicos;
	}

	public void setFornecedorservicos(List<Fornecedorservico> fornecedorservicos) {
		this.fornecedorservicos = fornecedorservicos;
	}

	public Fornecedorservico addFornecedorservico(Fornecedorservico fornecedorservico) {
		getFornecedorservicos().add(fornecedorservico);
		fornecedorservico.setServico(this);

		return fornecedorservico;
	}

	public Fornecedorservico removeFornecedorservico(Fornecedorservico fornecedorservico) {
		getFornecedorservicos().remove(fornecedorservico);
		fornecedorservico.setServico(null);

		return fornecedorservico;
	}

}