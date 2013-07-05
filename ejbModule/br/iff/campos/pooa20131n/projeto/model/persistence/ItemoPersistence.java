package br.iff.campos.pooa20131n.projeto.model.persistence;

import java.util.List;

import br.iff.campos.pooa20131n.projeto.model.entity.Fornecedorservico;
import br.iff.campos.pooa20131n.projeto.model.entity.Itemo;
import br.iff.campos.pooa20131n.projeto.model.entity.Ordemservico;

public class ItemoPersistence extends AbstractPersistence {

	public Itemo inserir(String uid, Integer quantidade,
			Fornecedorservico fornecedorservico, Ordemservico ordemservico) {

		Itemo item = new Itemo();

		item.setUid(uid);
		item.setQuantidade(quantidade);
		item.setFornecedorservico(fornecedorservico);
		item.setOrdemservico(ordemservico);
		super.insert(item);

		return item;

	}

	public Itemo update(String uid, Integer quantidade,
			Fornecedorservico fornecedorservico, Ordemservico ordemservico) {

		Itemo item = super.find(Itemo.class, uid);

		item.setUid(uid);
		item.setQuantidade(quantidade);
		item.setFornecedorservico(fornecedorservico);
		item.setOrdemservico(ordemservico);
		super.update(item);

		return item;

	}

	public Itemo find(String uid) {

		return super.find(Itemo.class, uid);
	}

	public void delete(String uid) {
		super.delete(Itemo.class, uid);
	}

	public List<Itemo> findAll() {
		return super.findAll(Itemo.class);

	}
}
