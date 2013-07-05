package br.iff.campos.pooa20131n.projeto.model.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.iff.campos.pooa20131n.projeto.model.entity.Servico;
import br.iff.campos.pooa20131n.projeto.model.persistence.ServicoPersistence;

public class ServicoTest {

	private ServicoPersistence pserv = new ServicoPersistence();
	private String uid = "001";

	@Test
	public void testInserir() {
		Servico serv = pserv.inserir(uid, "descricao", 50, "tag");
		assertEquals(serv.getUid(), uid);
	}

	@Test
	public void testUpdate() {
		Servico serv = pserv.update(uid, "descricao", 50, "tagUP");
		assertEquals(serv.getTag(), "tagUP");
	}

	@Test
	public void testFind() {
		Servico serv = pserv.find(uid);
		assertEquals(serv.getDescricao(), "descricao");
	}

	@Test
	public void testFindAll() {
		List<Servico> lista_pserv = pserv.findAll();
		for (Servico servico : lista_pserv) {
			assertEquals(servico.getDescricao(), "descricao");
		}
	}

	@Test
	public void testDelete() {
		pserv.delete(uid);
	}

}