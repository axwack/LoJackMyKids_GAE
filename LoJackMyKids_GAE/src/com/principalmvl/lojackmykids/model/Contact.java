package com.principalmvl.lojackmykids.model;

import java.io.Serializable;
import java.util.Date;
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
	private String email;
	private String regId;
	private Date createDate;
	private Date lastUpdateDate;
	
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Attribute(primaryKey = true)
    private Key key;
	
	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Contact(){}

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
	
	public String toString(){
		return "Contact {Email: "+ getEmail() + " RegID: " + getRegId() + "Key: " +getKey() + "Last Update Date: " + getLastUpdateDate()+
				" Create Date: " + getCreateDate()+" }";
	}
}
