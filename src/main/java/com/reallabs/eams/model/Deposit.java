package com.reallabs.eams.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="DEPOSIT")
public class Deposit implements Serializable{
	
	@Id
	private Long depositId;
	@Column
	private Double basic;
	@Column
	private Double loanTotal;
	@Column
	private Double interestTotal;
	@Column
	private Double total;
	@Column
	private Date lastUpdate;
	
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	
	public Long getDepositId() {
		return depositId;
	}
	public void setDepositId(Long depositId) {
		this.depositId = depositId;
	}
	public Double getBasic() {
		return basic;
	}
	public void setBasic(Double basic) {
		this.basic = basic;
	}
	public Double getLoanTotal() {
		return loanTotal;
	}
	public void setLoanTotal(Double loanTotal) {
		this.loanTotal = loanTotal;
	}
	public Double getInterestTotal() {
		return interestTotal;
	}
	public void setInterestTotal(Double interestTotal) {
		this.interestTotal = interestTotal;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Deposit [depositId=" + depositId + ", basic=" + basic + ", loanTotal=" + loanTotal + ", interestTotal="
				+ interestTotal + ", total=" + total + ", lastUpdate=" + lastUpdate + ", account=" + account + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((basic == null) ? 0 : basic.hashCode());
		result = prime * result + ((depositId == null) ? 0 : depositId.hashCode());
		result = prime * result + ((interestTotal == null) ? 0 : interestTotal.hashCode());
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((loanTotal == null) ? 0 : loanTotal.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		Deposit other = (Deposit) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (basic == null) {
			if (other.basic != null)
				return false;
		} else if (!basic.equals(other.basic))
			return false;
		if (depositId == null) {
			if (other.depositId != null)
				return false;
		} else if (!depositId.equals(other.depositId))
			return false;
		if (interestTotal == null) {
			if (other.interestTotal != null)
				return false;
		} else if (!interestTotal.equals(other.interestTotal))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (loanTotal == null) {
			if (other.loanTotal != null)
				return false;
		} else if (!loanTotal.equals(other.loanTotal))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}
	
	
	
	

}
