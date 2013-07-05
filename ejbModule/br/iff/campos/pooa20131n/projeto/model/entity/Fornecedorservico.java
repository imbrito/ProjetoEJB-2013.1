package br.iff.campos.pooa20131n.projeto.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fornecedorservico database table.
 * 
 */
@Entity
public class Fornecedorservico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	//bi-directional many-to-one association to Servico
	@ManyToOne
	@JoinColumn(name="uidservico")
	private Servico servico;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="uidusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Itemo
	@OneToMany(mappedBy="fornecedorservico")
	private List<Itemo> itemos;

	public Fornecedorservico() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Servico getServico() {
		return this.servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Itemo> getItemos() {
		return this.itemos;
	}

	public void setItemos(List<Itemo> itemos) {
		this.itemos = itemos;
	}

	public Itemo addItemo(Itemo itemo) {
		getItemos().add(itemo);
		itemo.setFornecedorservico(this);

		return itemo;
	}

	public Itemo removeItemo(Itemo itemo) {
		getItemos().remove(itemo);
		itemo.setFornecedorservico(null);

		return itemo;
	}

}