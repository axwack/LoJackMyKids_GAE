package com.principalmvl.lojackmykids.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;


@Model
public class Contact implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String email;
	private String regId;
	
	@Attribute(primaryKey = true)
    private Key key;
	
	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Contact(){}

	public Contact (String email, String regId){
		this.email = email;
		this.regId = regId;
	}
	

	public static Contact find(String email, EntityManager em){
		javax.persistence.Query q = em.createQuery("Select c from Contact c where c.email = :email");
		q.setParameter("email", email);
		List<Contact> result = q.getResultList();
		
		if (!result.isEmpty()){
			return result.get(0);
		}
		return null;
	}
	

	public static Contact get(Key key){
		return Datastore.get(Contact.class, key);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}
}
