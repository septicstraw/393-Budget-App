import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class Main 
{
	int ID;
	String email;
	int password;
	String firstName;
	String lastName;
	ArrayList<Category> categoryList = new ArrayList<Category>();
	double initialFunds;
	ArrayList<Transaction> transactionLog = new ArrayList<Transaction>();
	
	public Main()
	{
		//Test
	}
	
	public Date checkDate()
	{
		return (Date)Calendar.getInstance().getTime();
	}
	
	public void decreaseMoney(Category category, double amount, String note)
	{
		category.DecreaseMoney(amount);
		transactionLog.add(new Transaction(category, amount, checkDate(), note));
	}
	
	public void addMoney(Category category, double amount, String note)
	{
		category.addMoney(amount);
		transactionLog.add(new Transaction(category, amount, checkDate(), note));
	}
	
	public double rollover()
	{
		int rolling = 0;
		for(Category c: categoryList)
		{
			rolling+= c.withdrawMoney();
			c.resetMoney();
		}
		
		return rolling;
	}
	
	public void viewCurrentFunds()
	{
		
	}
	
	public void displayLog()
	{
		for(Transaction t: transactionLog)
		{
			System.out.println("Category: " + t.transactionCategory.getName() + " --- Amount: " + t.transactionAmount + " --- Date: " + t.transactionDate + " --- Notes: " + t.transactionNotes);
		}
	}
}
