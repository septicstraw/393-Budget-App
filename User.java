import java.sql.Date;
import java.util.List;
import java.util.Calendar;

public class User 
{
	int id;
	String email;
	int password;
	String firstName;
	String lastName;
	List<Category> categoryList;
	double initialFunds;
	List<Transaction> transactionLog;
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getPass() {
		return password;
	}
	
	public void setPass(int pass) {
		password = pass;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public List getCategoryList() {
		return categoryList;
	}
	
	public void setCategoryList(List categoryList) {
		this.categoryList = categoryList;
	}
	
	public double getInitialFunds() {
		return initialFunds;
	}
	
	public void setInitialFunds(double initialFunds) {
		this.initialFunds = initialFunds;
	}
	
	public List getTransactionLog() {
		return transactionLog;
	}
	
	public void setTransactionLog(List transactionLog) {
		this.transactionLog = transactionLog;
	}
}
