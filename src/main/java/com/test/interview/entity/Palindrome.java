package com.test.interview.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Palindromes")

public class Palindrome {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "transaction_date")
	private Date transactionDate;

	@Column(name = "palindrome")
	private String palindrome;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getPalindrome() {
		return palindrome;
	}

	public void setPalindrome(String palindrome) {
		this.palindrome = palindrome;
	}

	
	

}