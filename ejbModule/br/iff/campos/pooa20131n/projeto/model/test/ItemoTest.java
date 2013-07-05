package br.iff.campos.pooa20131n.projeto.model.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.iff.campos.pooa20131n.projeto.model.entity.Itemo;
import br.iff.campos.pooa20131n.projeto.model.persistence.FornecedorservicoPersistence;
import br.iff.campos.pooa20131n.projeto.model.persistence.ItemoPersistence;
import br.iff.campos.pooa20131n.projeto.model.persistence.OrdemservicoPersistence;
import br.iff.campos.pooa20131n.projeto.model.persistence.ServicoPersistence;
import br.iff.campos.pooa20131n.projeto.model.persistence.UsuarioPersistence;

public class ItemoTest {

	private UsuarioPersistence puser = new UsuarioPersistence();
	private ServicoPersistence pserv = new ServicoPersistence();
	private FornecedorservicoPersistence pforn = new FornecedorservicoPersistence();
	private OrdemservicoPersistence pord = new OrdemservicoPersistence();
	private ItemoPersistence pitem = new ItemoPersistence();
	private Date datainicio = new Date();
	private Date datatermino = new Date();
	private String uid = "001";

	@Test
	public void testInserir() {
		puser.inserir(uid, "cidade", "email", "nome", "telefone", "uf");
		pserv.inserir(uid, "descricao", 50, "tag");
		pforn.inserir(uid, puser.find(uid), pserv.find(uid));
		pord.inserir(uid, "status", datainicio, datatermino, puser.find(uid));
		Itemo item = pitem.inserir(uid, 1, pforn.find(uid), pord.find(uid));
		assertEquals(item.getUid(), uid);
	}

	@Test
	public void testUpdate() {
		Itemo item = pitem.update(uid, 1, pforn.find(uid), pord.find(uid));
		assertEquals(item.getUid(), uid);
	}

	@Test
	public void testFind() {
		Itemo item = pitem.find(uid);
		assertEquals(item.getUid(), uid);
	}

	@Test
	public void testFindAll() {
		List<Itemo> lista_pitem = pitem.findAll();
		for (Itemo itens : lista_pitem) {
			assertEquals(itens.getUid(), uid);
		}
	}

	@Test
	public void testDelete() {
		pitem.delete(uid);
		pord.delete(uid);
		pforn.delete(uid);
		pserv.delete(uid);
		puser.delete(uid);
	}

}
