package br.iff.campos.pooa20131n.projeto.model.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.iff.campos.pooa20131n.projeto.model.entity.Usuario;
import br.iff.campos.pooa20131n.projeto.model.persistence.UsuarioPersistence;

public class UsuarioTest {

	private UsuarioPersistence puser = new UsuarioPersistence();
	private String uid = "001";

	@Test
	public void testInserir() {
		Usuario user = puser.inserir(uid, "cidade", "email", "nome",
				"telefone", "uf");
		assertEquals(user.getUid(), uid);
	}

	@Test
	public void testUpdate() {
		Usuario user = puser.update(uid, "cidade", "email", "nomeUP",
				"telefone", "uf");
		assertEquals(user.getNome(), "nomeUP");
	}

	@Test
	public void testFind() {
		Usuario user = puser.find(uid);
		assertEquals(user.getCidade(), "cidade");
	}

	@Test
	public void testFindAll() {
		List<Usuario> lista_puser = puser.findAll();
		for (Usuario usuario : lista_puser) {
			assertEquals(usuario.getTelefone(), "telefone");
		}
	}

	@Test
	public void testDelete() {
		puser.delete(uid);
	}

}