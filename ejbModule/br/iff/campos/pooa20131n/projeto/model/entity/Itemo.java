package br.iff.campos.pooa20131n.projeto.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the itemos database table.
 * 
 */
@Entity
@Table(name="itemos")
public class Itemo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private Integer quantidade;

	//bi-directional many-to-one association to Feedbackservico
	@OneToMany(mappedBy="itemo")
	private List<Feedbackservico> feedbackservicos;

	//bi-directional many-to-one association to Fornecedorservico
	@ManyToOne
	@JoinColumn(name="uidfornecedorservico")
	private Fornecedorservico fornecedorservico;

	//bi-directional many-to-one association to Ordemservico
	@ManyToOne
	@JoinColumn(name="uidordemservico")
	private Ordemservico ordemservico;

	public Itemo() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public List<Feedbackservico> getFeedbackservicos() {
		return this.feedbackservicos;
	}

	public void setFeedbackservicos(List<Feedbackservico> feedbackservicos) {
		this.feedbackservicos = feedbackservicos;
	}

	public Feedbackservico addFeedbackservico(Feedbackservico feedbackservico) {
		getFeedbackservicos().add(feedbackservico);
		feedbackservico.setItemo(this);

		return feedbackservico;
	}

	public Feedbackservico removeFeedbackservico(Feedbackservico feedbackservico) {
		getFeedbackservicos().remove(feedbackservico);
		feedbackservico.setItemo(null);

		return feedbackservico;
	}

	public Fornecedorservico getFornecedorservico() {
		return this.fornecedorservico;
	}

	public void setFornecedorservico(Fornecedorservico fornecedorservico) {
		this.fornecedorservico = fornecedorservico;
	}

	public Ordemservico getOrdemservico() {
		return this.ordemservico;
	}

	public void setOrdemservico(Ordemservico ordemservico) {
		this.ordemservico = ordemservico;
	}

}