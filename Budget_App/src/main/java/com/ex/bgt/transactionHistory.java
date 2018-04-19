package com.ex.bgt;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ex.bgt.domain.BgtTransaction;
import com.ex.bgt.domain.Category;
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

        Scene scene = new Scene(grid, 800, 800);
        primaryStage.setScene(scene);

        Text scenetitle = new Text("Transaction History");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        User usr = new User();
        Category cat = new Category(usr, "Pants", 1000, 4);
        Timestamp testStamp = new Timestamp(100);
    	List<BgtTransaction> tempList = new ArrayList<BgtTransaction>();
    	
    	
    	UserMethods userDo = new UserMethods();
    	CategoryMethods catDo = new CategoryMethods();
    	
    	//userDo.changeMoney(cat, -150, "For Pants", usr);
    	
    	tempList.add(new BgtTransaction(100, testStamp, "For more pants", cat, usr));
    	tempList.add(new BgtTransaction(-150, testStamp, "Less Pants", cat, usr));
    	tempList.add(new BgtTransaction(200, testStamp, "Some Pants", cat, usr));
    	tempList.add(new BgtTransaction(300, testStamp, "Test Pants", cat, usr));
    	tempList.add(new BgtTransaction(-100, testStamp, "Pants Pants", cat, usr));
    	tempList.add(new BgtTransaction(-356, testStamp, "Panty Pants", cat, usr));
    	tempList.add(new BgtTransaction(100, testStamp, "Plants", cat, usr));
    	int i = 1;
    	for(BgtTransaction transact: tempList)
    	{
    		Label userName = new Label("Date: " + transact.getTransactionDate() + " --- "
    				+ "Category: " + transact.getTransactionCategory().getName() + " --- "
    				+ "Amount: " + transact.getTransactionAmount() + " --- "
    				+ "Notes: " + transact.getTransactionNotes());
            grid.add(userName, 0, i);
            i++;
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