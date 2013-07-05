package br.iff.campos.pooa20131n.projeto.model.persistence;

import java.util.List;

import br.iff.campos.pooa20131n.projeto.model.entity.Usuario;

public class UsuarioPersistence extends AbstractPersistence {

	public Usuario inserir(String uid, String cidade, String email,
			String nome, String telefone, String uf) {

		Usuario usuario = new Usuario();

		usuario.setUid(uid);
		usuario.setCidade(cidade);
		usuario.setEmail(email);
		usuario.setNome(nome);
		usuario.setTelefone(telefone);
		usuario.setUf(uf);
		super.insert(usuario);

		return usuario;

	}

	public Usuario update(String uid, String cidade, String email, String nome,
			String telefone, String uf) {

		Usuario usuario = super.find(Usuario.class, uid);

		usuario.setUid(uid);
		usuario.setCidade(cidade);
		usuario.setEmail(email);
		usuario.setNome(nome);
		usuario.setTelefone(telefone);
		usuario.setUf(uf);
		super.update(usuario);

		return usuario;

	}

	public Usuario find(String uid) {

		return super.find(Usuario.class, uid);
	}

	public void delete(String uid) {
		super.delete(Usuario.class, uid);
	}

	public List<Usuario> findAll() {
		return super.findAll(Usuario.class);

	}

}
