package com.ex.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BANK_USERS")
public class BankUser {
	
	@Id
	@Column(name="BU_ID")
	@GeneratedValue(generator="user_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="user_seq", sequenceName="user_seq", allocationSize=1)
	private Integer id;
	
	@Column(name="BU_USERNAME")
	private String username;
	
	@Column(name="BU_PASSWORD")
	private String password;
	
	@OneToMany(mappedBy="bankUser", fetch=FetchType.EAGER)
	private List<BankAccount> accounts;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public BankUser(){}
	
	public BankUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public BankUser(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		String val = this.id + " " + this.username + " " + this.password;
		
		if(accounts != null){
			for(final BankAccount ba : accounts){
				val += "\n\t" + ba;
			}
		}
		
		return val;
	}
	
}
