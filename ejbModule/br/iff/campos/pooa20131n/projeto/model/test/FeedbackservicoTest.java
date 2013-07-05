package br.iff.campos.pooa20131n.projeto.model.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.iff.campos.pooa20131n.projeto.model.entity.Feedbackservico;
import br.iff.campos.pooa20131n.projeto.model.persistence.FeedbackservicoPersistence;
import br.iff.campos.pooa20131n.projeto.model.persistence.FornecedorservicoPersistence;
import br.iff.campos.pooa20131n.projeto.model.persistence.ItemoPersistence;
import br.iff.campos.pooa20131n.projeto.model.persistence.OrdemservicoPersistence;
import br.iff.campos.pooa20131n.projeto.model.persistence.ServicoPersistence;
import br.iff.campos.pooa20131n.projeto.model.persistence.UsuarioPersistence;

public class FeedbackservicoTest {

	private UsuarioPersistence puser = new UsuarioPersistence();
	private ServicoPersistence pserv = new ServicoPersistence();
	private FornecedorservicoPersistence pforn = new FornecedorservicoPersistence();
	private OrdemservicoPersistence pord = new OrdemservicoPersistence();
	private ItemoPersistence pitem = new ItemoPersistence();
	private FeedbackservicoPersistence pfeed = new FeedbackservicoPersistence();
	private Date datainicio = new Date();
	private Date datatermino = new Date();
	private String uid = "001";

	@Test
	public void testInserir() {
		puser.inserir(uid, "cidade", "email", "nome", "telefone", "uf");
		pserv.inserir(uid, "descricao", 50, "tag");
		pforn.inserir(uid, puser.find(uid), pserv.find(uid));
		pord.inserir(uid, "status", datainicio, datatermino, puser.find(uid));
		pitem.inserir(uid, 1, pforn.find(uid), pord.find(uid));
		Feedbackservico feed = pfeed.inserir(uid, pitem.find(uid), "feedback");
		assertEquals(feed.getUid(), uid);
	}

	@Test
	public void testUpdate() {
		Feedbackservico feed = pfeed.update(uid, pitem.find(uid), "feedbackUP");
		assertEquals(feed.getFeedback(), "feedbackUP");
	}

	@Test
	public void testFind() {
		Feedbackservico feed = pfeed.find(uid);
		assertEquals(feed.getUid(), uid);
	}

	@Test
	public void testFindAll() {
		List<Feedbackservico> lista_pfeed = pfeed.findAll();
		for (Feedbackservico objeto : lista_pfeed) {
			assertEquals(objeto.getUid(), uid);
		}
	}

	@Test
	public void testDelete() {
		pfeed.delete(uid);
		pitem.delete(uid);
		pord.delete(uid);
		pforn.delete(uid);
		pserv.delete(uid);
		puser.delete(uid);
	}
}
