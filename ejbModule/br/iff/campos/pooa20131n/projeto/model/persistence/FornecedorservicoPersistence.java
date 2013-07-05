package br.iff.campos.pooa20131n.projeto.model.persistence;

import java.util.List;

import br.iff.campos.pooa20131n.projeto.model.entity.Fornecedorservico;
import br.iff.campos.pooa20131n.projeto.model.entity.Servico;
import br.iff.campos.pooa20131n.projeto.model.entity.Usuario;

public class FornecedorservicoPersistence extends AbstractPersistence {

	public Fornecedorservico inserir(String uid, Usuario usuario,
			Servico servico) {

		Fornecedorservico fornecedor = new Fornecedorservico();

		fornecedor.setUid(uid);
		fornecedor.setUsuario(usuario);
		fornecedor.setServico(servico);
		super.insert(fornecedor);

		return fornecedor;

	}

	public Fornecedorservico update(String uid, Usuario usuario, Servico servico) {

		Fornecedorservico fornecedor = super.find(Fornecedorservico.class, uid);

		fornecedor.setUid(uid);
		fornecedor.setUsuario(usuario);
		fornecedor.setServico(servico);
		super.update(fornecedor);

		return fornecedor;

	}

	public Fornecedorservico find(String uid) {

		return super.find(Fornecedorservico.class, uid);
	}

	public void delete(String uid) {
		super.delete(Fornecedorservico.class, uid);
	}

	public List<Fornecedorservico> findAll() {
		return super.findAll(Fornecedorservico.class);

	}
}
