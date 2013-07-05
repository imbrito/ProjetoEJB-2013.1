package br.iff.campos.pooa20131n.projeto.model.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.iff.campos.pooa20131n.projeto.model.entity.Ordemservico;
import br.iff.campos.pooa20131n.projeto.model.persistence.OrdemservicoPersistence;
import br.iff.campos.pooa20131n.projeto.model.persistence.UsuarioPersistence;

public class OrdemservicoTest {

	private UsuarioPersistence puser = new UsuarioPersistence();
	private OrdemservicoPersistence pord = new OrdemservicoPersistence();
	private Date datainicio = new Date();
	private Date datatermino = new Date();
	private String uid = "001";

	@Test
	public void testInserir() {
		puser.inserir(uid, "cidade", "email", "nome", "telefone", "uf");
		Ordemservico ord = pord.inserir(uid, "status", datainicio, datatermino,
				puser.find(uid));
		assertEquals(ord.getUid(), uid);
	}

	@Test
	public void testUpdate() {
		Ordemservico ord = pord.update(uid, "statusUP", datainicio,
				datatermino, puser.find(uid));
		assertEquals(ord.getStatus(), "statusUP");
	}

	@Test
	public void testFind() {
		Ordemservico ord = pord.find(uid);
		assertEquals(ord.getUid(), uid);
	}

	@Test
	public void testFindAll() {
		List<Ordemservico> lista_pord = pord.findAll();
		for (Ordemservico ordemservico : lista_pord) {
			assertEquals(ordemservico.getUid(), uid);
		}
	}

	@Test
	public void testDelete() {
		pord.delete(uid);
		puser.delete(uid);
	}

}
