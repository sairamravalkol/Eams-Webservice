package com.reallabs.eams.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","lastUpdate"})
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long accountId;
	@Column
	private String accountName;
	@Column
	private String fatherName;
	@Column
	private Double balance;
	@Column
	private String address;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private String imageUrl;
	@Column
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date createdAt;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
	private Set<Deposit> deposits;
	
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Set<Loan> getLoans() {
		return loans;
	}
	
	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
	private Set<Loan> loans = new HashSet<>();

	

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Set<Deposit> getDeposits() {
		return deposits;
	}

	public void setDeposits(Set<Deposit> deposits) {
		this.deposits = deposits;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", fatherName=" + fatherName
				+ ", balance=" + balance + ", address=" + address + ", email=" + email + ", phone=" + phone
				+ ", imageUrl=" + imageUrl + ", lastUpdate=" + lastUpdate + ", createdAt=" + createdAt + ", deposits="
				+ deposits + ", loans=" + loans + "]";
	}


}
