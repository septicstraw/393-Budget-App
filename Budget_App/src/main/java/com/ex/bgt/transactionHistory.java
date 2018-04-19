package com.ex.bgt;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ex.bgt.domain.BgtTransaction;
import com.ex.bgt.domain.Category;
import com.ex.bgt.domain.SubCategory;
import com.ex.bgt.domain.User;
import com.ex.dao.UserDao;
import com.ex.impl.UserDaoImpl;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class transactionHistory extends Application 
{

	public static void main(String[] args) 
	{
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Budget App");
       
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 1000, 1000);
        primaryStage.setScene(scene);

        Text scenetitle = new Text("Transaction History");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        User usr = new User("email@email.com", 111, "Paul", "Palumbo");
        Category cat = new Category(usr, "Pants", 1000, 4);
        Category cat1 = new Category(usr, "Food", 500, 3);
        Category cat2 = new Category(usr, "Fun", 500, 2);
        SubCategory subCat1 = new SubCategory("Movies", 100, 10, cat2);
        SubCategory subCat2 = new SubCategory("Bowling", 100, 11, cat2);
        List<Category> catList = new ArrayList<Category>();
        List<SubCategory> subCatList = new ArrayList<SubCategory>();
        subCatList.add(subCat1);
        subCatList.add(subCat2);
        catList.add(cat);
        catList.add(cat2);
        usr.setCategoryList(catList);
        
        
    	List<BgtTransaction> tempList = new ArrayList<BgtTransaction>();
    	
    	
    	UserMethods userDo = new UserMethods();
    	CategoryMethods catDo = new CategoryMethods();
    	
    	
    	Timestamp testStamp = new Timestamp(System.currentTimeMillis());
    	
    	tempList.add(new BgtTransaction(100d, testStamp, "For more pants", cat, usr, 1000));
    	tempList.add(new BgtTransaction(-150.0, testStamp, "Less Pants", cat, usr, 100));
    	tempList.add(new BgtTransaction(200.0, testStamp, "Some Pants", cat, usr, 100));
    	tempList.add(new BgtTransaction(300.0, testStamp, "Test Pants", cat, usr, 100));
    	tempList.add(new BgtTransaction(-100.0, testStamp, "Pants Pants", cat, usr, 100));
    	tempList.add(new BgtTransaction(-356.0, testStamp, "Panty Pants", cat, usr, 100));
    	tempList.add(new BgtTransaction(100.0, testStamp, "Plants", cat, usr, 100));
    	
    	usr.setTransactionList(tempList);
    	
    	int i = 1;
    	String currentSay = new String();
    	
    	for(Category cats: usr.getCategoryList())
    	{
    		if(cats.getSubcategories().size() <= 0)
    		{
    			currentSay = currentSay + ("Category: " + cats.getName() + " --- " + 
    								   "Remaining Funds: " + cats.getCurrentFunds());
    			i++;
    		}
    		else
    		{
    			currentSay = currentSay + ("Category: " + cats.getName() + " --- " + "Remaining Funds: " + cats.getCurrentFunds() + "\n");
    			for(SubCategory subcats: cats.getSubcategories())
    			{
    				currentSay = currentSay + ("SubCategory: " + subcats.getName() + " --- " + "Remaining Funds: " + subcats.getCurrentFunds() + "\n");
    			}
    			i += cats.getSubcategories().size() + 1;
    		}
    		Label userName = new Label(currentSay);
    		
            grid.add(userName, 0, i);
            
            currentSay = "";
    	}
    	
    	i+= 2;
    	
    	userDo.changeMoney(cat, -150, "For Pants", usr);
    	userDo.changeMoney(cat, -250, "More Pants", usr);
    	userDo.changeMoney(cat, 100, "Sold Pants", usr);
    	userDo.changeMoney(cat2, -102, "Bought Food", usr);
    	userDo.changeMoney(cat2, -203, "Too Much Food", usr);
    	userDo.changeMoney(cat2, 100, "Sold Couch", usr);
    	userDo.changeMoneySubCategory(cat2, subCat1, -20, "Infinity War", usr);
    	userDo.changeMoneySubCategory(cat2, subCat1, -20, "Infinity War Again", usr);
    	userDo.changeMoneySubCategory(cat2, subCat2, -20, "I love Bowling", usr);
    	
    	for(BgtTransaction transact: tempList)
    	{
    		Label userName = new Label("Date: " + transact.getTransactionDate() + " --- "
    				+ "Category: " + transact.getTransactionCategory().getName() + " --- "
    				+ "Amount: " + transact.getTransactionAmount() + " --- "
    				+ "Notes: " + transact.getTransactionNotes());
            grid.add(userName, 0, i);
            i++;
    	}
    	
    	i += 2;
    	
    	for(Category cats: usr.getCategoryList())
    	{
    		if(cats.getSubcategories().size() <= 0)
    		{
    			currentSay = currentSay + ("Category: " + cats.getName() + " --- " + 
    								   "Remaining Funds: " + cats.getCurrentFunds());
    			i++;
    		}
    		else
    		{
    			currentSay = currentSay + ("Category: " + cats.getName() + " --- " + "Remaining Funds: " + cats.getCurrentFunds() + "\n");
    			for(SubCategory subcats: cats.getSubcategories())
    			{
    				currentSay = currentSay + ("SubCategory: " + subcats.getName() + " --- " + "Remaining Funds: " + subcats.getCurrentFunds() + "\n");
    			}
    			i += cats.getSubcategories().size() + 1;
    		}
    		Label userName = new Label(currentSay);
    		
            grid.add(userName, 0, i);
            
            currentSay = "";
    	}
    	
    	i+= 2;
    	
    	double rollover = userDo.rollover(usr);
    	
    	Label rolloverPrint = new Label("Rollover: " + rollover);
    	 grid.add(rolloverPrint, 0, i);
    	
    	i+= 2;
    	
    	for(Category cats: usr.getCategoryList())
    	{
    		if(cats.getSubcategories().size() <= 0)
    		{
    			currentSay = currentSay + ("Category: " + cats.getName() + " --- " + 
    								   "Remaining Funds: " + cats.getCurrentFunds());
    			i++;
    		}
    		else
    		{
    			currentSay = currentSay + ("Category: " + cats.getName() + " --- " + "Remaining Funds: " + cats.getCurrentFunds() + "\n");
    			for(SubCategory subcats: cats.getSubcategories())
    			{
    				currentSay = currentSay + ("SubCategory: " + subcats.getName() + " --- " + "Remaining Funds: " + subcats.getCurrentFunds() + "\n");
    			}
    			i += cats.getSubcategories().size() + 1;
    		}
    		Label userName = new Label(currentSay);
    		
            grid.add(userName, 0, i);
            
            currentSay = "";
    	}
        

        /*final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);      
        btn.setOnAction(new EventHandler<ActionEvent>() 
        {
        	 
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");
            }
        });*/
        
        primaryStage.show();
    }
    
    

}
