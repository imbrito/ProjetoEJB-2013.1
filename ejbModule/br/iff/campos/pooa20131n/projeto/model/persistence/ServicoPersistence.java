package br.iff.campos.pooa20131n.projeto.model.persistence;

import java.util.List;

import br.iff.campos.pooa20131n.projeto.model.entity.Servico;

public class ServicoPersistence extends AbstractPersistence {

	public Servico inserir(String uid, String descricao, float preco, String tag) {

		Servico servico = new Servico();

		servico.setUid(uid);
		servico.setDescricao(descricao);
		servico.setPreco(preco);
		servico.setTag(tag);
		super.insert(servico);

		return servico;

	}

	public Servico update(String uid, String descricao, float preco, String tag) {

		Servico servico = super.find(Servico.class, uid);

		servico.setUid(uid);
		servico.setDescricao(descricao);
		servico.setPreco(preco);
		servico.setTag(tag);
		super.update(servico);

		return servico;

	}

	public Servico find(String uid) {

		return super.find(Servico.class, uid);
	}

	public void delete(String uid) {
		super.delete(Servico.class, uid);
	}

	public List<Servico> findAll() {
		return super.findAll(Servico.class);

	}

}
