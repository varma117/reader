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
	private Integer pId;
	
	private Date purchagedTime= new Date();
	
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public Date getPurchagedTime() {
		return purchagedTime;
	}
	
	public PurchagedBook(Long bookId, Integer pId) {
		super();
		this.bookId = bookId;
		this.pId = pId;
		
	}
	public PurchagedBook() {
		super();
	}
	
	

}
