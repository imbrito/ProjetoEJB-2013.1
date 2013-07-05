package br.iff.campos.pooa20131n.projeto.model.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SuppressWarnings("unused")
public class AbstractPersistence {
	protected static EntityManagerFactory entityManagerFactory;
	protected static EntityManager entityManager;

	protected static EntityTransaction transaction;

	static {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("ProjetoEJB");
		entityManager = entityManagerFactory.createEntityManager();

		transaction = entityManager.getTransaction();
	}

	// @TransactionAttribute(TransactionAttributeType.REQUIRED)

	public Object insert(Object object) {

		transaction.begin();

		entityManager.persist(object);
		transaction.commit();
		return object;
	}

	public Object update(Object object) {
		transaction.begin();

		entityManager.merge(object);

		transaction.commit();
		return object;
	}

	public void delete(Class<?> classe, String codigo) {
		Object object = find(classe, codigo);
		transaction.begin();

		entityManager.remove(object);
		transaction.commit();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> classe) {
		return entityManager.createQuery(
				"select e from " + classe.getName() + " e").getResultList();
	}

	public <T> T find(Class<T> classe, String codigo) {
		return entityManager.find(classe, codigo);
	}

}
