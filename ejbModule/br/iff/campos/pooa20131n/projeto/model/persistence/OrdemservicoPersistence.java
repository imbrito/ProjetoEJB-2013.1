package br.iff.campos.pooa20131n.projeto.model.persistence;

import java.util.Date;
import java.util.List;

import br.iff.campos.pooa20131n.projeto.model.entity.Ordemservico;
import br.iff.campos.pooa20131n.projeto.model.entity.Usuario;

public class OrdemservicoPersistence extends AbstractPersistence {

	public Ordemservico inserir(String uid, String status, Date datainicio,
			Date datatermino, Usuario usuario) {

		Ordemservico ordemservico = new Ordemservico();

		ordemservico.setUid(uid);
		ordemservico.setDatainicio(datainicio);
		ordemservico.setDatatermino(datatermino);
		ordemservico.setStatus(status);
		ordemservico.setUsuario(usuario);
		super.insert(ordemservico);

		return ordemservico;

	}

	public Ordemservico update(String uid, String status, Date datainicio,
			Date datatermino, Usuario usuario) {

		Ordemservico ordemservico = super.find(Ordemservico.class, uid);

		ordemservico.setUid(uid);
		ordemservico.setDatainicio(datainicio);
		ordemservico.setDatatermino(datatermino);
		ordemservico.setStatus(status);
		ordemservico.setUsuario(usuario);
		super.update(ordemservico);

		return ordemservico;

	}

	public Ordemservico find(String uid) {

		return super.find(Ordemservico.class, uid);
	}

	public void delete(String uid) {
		super.delete(Ordemservico.class, uid);
	}

	public List<Ordemservico> findAll() {
		return super.findAll(Ordemservico.class);

	}
}
