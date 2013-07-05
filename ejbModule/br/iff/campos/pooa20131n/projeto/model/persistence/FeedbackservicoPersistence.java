package br.iff.campos.pooa20131n.projeto.model.persistence;

import java.util.List;

import br.iff.campos.pooa20131n.projeto.model.entity.Feedbackservico;
import br.iff.campos.pooa20131n.projeto.model.entity.Itemo;

public class FeedbackservicoPersistence extends AbstractPersistence {

	public Feedbackservico inserir(String uid, Itemo itemo, String feedback) {

		Feedbackservico feedservico = new Feedbackservico();

		feedservico.setUid(uid);
		feedservico.setItemo(itemo);
		feedservico.setFeedback(feedback);
		super.insert(feedservico);

		return feedservico;

	}

	public Feedbackservico update(String uid, Itemo itemo, String feedback) {

		Feedbackservico feedservico = super.find(Feedbackservico.class, uid);

		feedservico.setUid(uid);
		feedservico.setItemo(itemo);
		feedservico.setFeedback(feedback);
		super.update(feedservico);

		return feedservico;

	}

	public Feedbackservico find(String uid) {

		return super.find(Feedbackservico.class, uid);
	}

	public void delete(String uid) {
		super.delete(Feedbackservico.class, uid);
	}

	public List<Feedbackservico> findAll() {
		return super.findAll(Feedbackservico.class);

	}
}
