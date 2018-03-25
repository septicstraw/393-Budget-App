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
}
