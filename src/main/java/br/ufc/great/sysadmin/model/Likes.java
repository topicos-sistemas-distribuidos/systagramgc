package br.ufc.great.sysadmin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

@Entity
public class Likes extends AbstractModel<Long>{
	private static final long serialVersionUID = 1L;
	private String description;
	@OneToOne
	private Person person;
	@OneToOne
	private Post post;
	
	private Date date;
	
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean mylike;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public boolean isMylike() {
		return mylike;
	}
	public void setMylike(boolean mylike) {
		this.mylike = mylike;
	}

}
