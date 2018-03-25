import java.util.ArrayList;

public class Category 
{
	private String name;
	private double initialFunds;
	private double currentFunds;
	private int priority;
	private ArrayList<Category> subcategories;
	
	public Category(String name, double initialFunds, int priority) {
		this.name = name;
		this.initialFunds = initialFunds;
		this.currentFunds = initialFunds;
		this.priority = priority;
	};
	
	private void decreaseMoney(double amount) {
		currentFunds -= amount;
	}
	
	private void addMoney(double amount) {
		currentFunds += amount;
	}
	
	private void resetMoney() {
		currentFunds = initialFunds;
	}
	
	private void addSubcategory(Category c) {
		subcategories.add(c);
	}
	
	//private void removeSubcategory
	
	//Getter-setters
	
	private String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	private double getInitialFunds() {
		return initialFunds;
	}
	
	private void setInitialFunds(double initialFunds) {
		this.initialFunds = initialFunds;
	}
	
	private double getCurrentFunds() {
		return currentFunds;
	}
	
	private void setCurrentFunds(double currentFunds) {
		this.currentFunds = currentFunds;
	}
	
	private int getPriority() {
		return priority;
	}
	
	private void setPriority(int priority) {
		this.priority = priority;
	}
	
	private ArrayList<Category> getSubcategories() {
		return subcategories;
	}
	
	private void setSubcategories(ArrayList<Category> subcategories) {
		this.subcategories = subcategories;
	}
	
}
