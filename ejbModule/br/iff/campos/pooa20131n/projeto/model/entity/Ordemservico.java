package br.iff.campos.pooa20131n.projeto.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ordemservico database table.
 * 
 */
@Entity
public class Ordemservico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	@Temporal(TemporalType.DATE)
	private Date datainicio;

	@Temporal(TemporalType.DATE)
	private Date datatermino;

	private String status;

	//bi-directional many-to-one association to Itemo
	@OneToMany(mappedBy="ordemservico")
	private List<Itemo> itemos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="uidusuario")
	private Usuario usuario;

	public Ordemservico() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date getDatainicio() {
		return this.datainicio;
	}

	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}

	public Date getDatatermino() {
		return this.datatermino;
	}

	public void setDatatermino(Date datatermino) {
		this.datatermino = datatermino;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Itemo> getItemos() {
		return this.itemos;
	}

	public void setItemos(List<Itemo> itemos) {
		this.itemos = itemos;
	}

	public Itemo addItemo(Itemo itemo) {
		getItemos().add(itemo);
		itemo.setOrdemservico(this);

		return itemo;
	}

	public Itemo removeItemo(Itemo itemo) {
		getItemos().remove(itemo);
		itemo.setOrdemservico(null);

		return itemo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}