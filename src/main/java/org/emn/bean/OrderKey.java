/*
 * Created on 7 oct. 2013 ( Time 10:49:51 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package org.emn.bean;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Composite primary key for entity "Order" ( stored in table "COMMANDE" )
 * 
 * @author Telosys Tools Generator
 * 
 */
@Embeddable
public class OrderKey implements Serializable {
	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY KEY ATTRIBUTES
	// ----------------------------------------------------------------------
	@Column(name = "USER_ID", nullable = false)
	private int userId;

	@Column(name = "ARTICLE_ID", nullable = false)
	private int articleId;

	// ----------------------------------------------------------------------
	// CONSTRUCTORS
	// ----------------------------------------------------------------------
	public OrderKey() {
		super();
	}

	public OrderKey(int userId, int articleId) {
		super();
		this.userId = userId;
		this.articleId = articleId;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR KEY FIELDS
	// ----------------------------------------------------------------------
	public void setUserId(int value) {
		this.userId = value;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setArticleId(int value) {
		this.articleId = value;
	}

	public int getArticleId() {
		return this.articleId;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(userId);
		sb.append("|");
		sb.append(articleId);
		return sb.toString();
	}

}
