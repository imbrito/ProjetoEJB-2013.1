package br.iff.campos.pooa20131n.projeto.model.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.iff.campos.pooa20131n.projeto.model.entity.Fornecedorservico;
import br.iff.campos.pooa20131n.projeto.model.persistence.FornecedorservicoPersistence;
import br.iff.campos.pooa20131n.projeto.model.persistence.ServicoPersistence;
import br.iff.campos.pooa20131n.projeto.model.persistence.UsuarioPersistence;

public class FornecedorservicoTest {

	private UsuarioPersistence puser = new UsuarioPersistence();
	private ServicoPersistence pserv = new ServicoPersistence();
	private FornecedorservicoPersistence pforn = new FornecedorservicoPersistence();
	private String uid = "001";

	@Test
	public void testInserir() {
		puser.inserir(uid, "cidade", "email", "nome", "telefone", "uf");
		pserv.inserir(uid, "descricao", 50, "tag");
		Fornecedorservico forn = pforn.inserir(uid, puser.find(uid),
				pserv.find(uid));
		assertEquals(forn.getUid(), uid);
	}

	@Test
	public void testUpdate() {
		Fornecedorservico forn = pforn.update(uid, puser.find(uid),
				pserv.find(uid));
		assertEquals(forn.getUid(), uid);
	}

	@Test
	public void testFind() {
		Fornecedorservico forn = pforn.find(uid);
		assertEquals(forn.getUid(), uid);
	}

	@Test
	public void testFindAll() {
		List<Fornecedorservico> lista_pforn = pforn.findAll();
		for (Fornecedorservico fornecedor : lista_pforn) {
			assertEquals(fornecedor.getUid(), uid);
		}
	}

	@Test
	public void testDelete() {
		pforn.delete(uid);
		pserv.delete(uid);
		puser.delete(uid);
	}

}
