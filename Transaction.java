import java.sql.Date;

public class Transaction 
{
	Category transactionCategory;
	double transactionAmount;
	Date transactionDate;
	String transactionNotes;
	
	public Transaction(Category category, double amount, Date date, String note) 
	{
		transactionCategory = category;
		transactionAmount = amount;
		transactionDate = date;
		transactionNotes = note;
	}
	
	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionNotes() {
		return transactionNotes;
	}

	public void setTransactionNotes(String transactionNotes) {
		this.transactionNotes = transactionNotes;
	}

	public void setTransactionCategory(Category transactionCategory) {
		this.transactionCategory = transactionCategory;
	}
}
