package com.reader.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="purchagedbook")
public class PurchagedBook {
	
	private Long bookId;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pId;
	
	private Date purchagedTime= new Date();
	
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public Date getPurchagedTime() {
		return purchagedTime;
	}
	
	public PurchagedBook(Long bookId) {
		super();
		this.bookId = bookId;
		this.purchagedTime = new Date();
	}
	
}
