package com.reallabs.eams.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Loan")
public class Loan implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long loanId;
	@Column
	private Double loanAmt;
	@Column
	private Date lastUpdate;
	
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;


	public Long getLoanId() {
		return loanId;
	}


	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}


	public Double getLoanAmt() {
		return loanAmt;
	}


	public void setLoanAmt(Double loanAmt) {
		this.loanAmt = loanAmt;
	}


	public Date getLastUpdate() {
		return lastUpdate;
	}


	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((loanAmt == null) ? 0 : loanAmt.hashCode());
		result = prime * result + ((loanId == null) ? 0 : loanId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (loanAmt == null) {
			if (other.loanAmt != null)
				return false;
		} else if (!loanAmt.equals(other.loanAmt))
			return false;
		if (loanId == null) {
			if (other.loanId != null)
				return false;
		} else if (!loanId.equals(other.loanId))
			return false;
		return true;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanAmt=" + loanAmt + ", lastUpdate=" + lastUpdate + ", account=" + account
				+ "]";
	}
	
	
	
	
	

}
