package br.iff.campos.pooa20131n.projeto.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the feedbackservico database table.
 * 
 */
@Entity
public class Feedbackservico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String feedback;

	//bi-directional many-to-one association to Itemo
	@ManyToOne
	@JoinColumn(name="uiditemos")
	private Itemo itemo;

	public Feedbackservico() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFeedback() {
		return this.feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Itemo getItemo() {
		return this.itemo;
	}

	public void setItemo(Itemo itemo) {
		this.itemo = itemo;
	}

}