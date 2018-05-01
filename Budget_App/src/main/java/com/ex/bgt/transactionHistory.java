package com.ex.bgt;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ex.bgt.domain.BgtTransaction;
import com.ex.bgt.domain.Category;
import com.ex.bgt.domain.Context;
import com.ex.bgt.domain.SubCategory;
import com.ex.bgt.domain.User;
import com.ex.dao.UserDao;
import com.ex.impl.UserDaoImpl;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
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
	@FXML
	private GridPane txGrid;

	  
    @FXML
    public void initialize() 
    {
    	System.out.println("initialize");
        txGrid = new GridPane();
        txGrid.setAlignment(Pos.CENTER);
        txGrid.setHgap(10);
        txGrid.setVgap(10);
        txGrid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Transaction History");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        txGrid.add(scenetitle, 0, 0, 2, 1);
        Scene scene = new Scene(txGrid, 1000, 1000);
        
        Stage stage = new Stage();
        stage.setTitle("View Transaction History");
        stage.setScene(scene);
        stage.show();
        
        
    	List<BgtTransaction> transList = Context.getInstance().currentUser().getTransactionList();
    	
    	int displayPadder = 2;
    	for(BgtTransaction transact: transList)
    	{
    		Label info = new Label("Date: " + transact.getTransactionDate() + " --- "
    				+ "Category: " + transact.getTransactionCategory().getName() + " --- "
    				+ "Amount: " + transact.getTransactionAmount() + " --- "
    				+ "Notes: " + transact.getTransactionNotes());
    		txGrid.add(info, 0, displayPadder);
    		displayPadder += 2;
    	}
    	Button backToHome = new Button();
    	backToHome.setText("Home");
    	backToHome.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent e) {
    			UserMethods usrMethods = new UserMethods();
    			Stage stage = (Stage) backToHome.getScene().getWindow();
    		    stage.close();
    		    
    		    Parent root;
    	    	Stage stageHome;
    	    	try {
    	    		System.out.println("here\n");
    	    		root = FXMLLoader.load(getClass().getResource("income.fxml"));
    	    		Scene scene = new Scene(root);
    	    		stageHome = (Stage) ((Node)e.getSource()).getScene().getWindow();
    	    		stageHome.setScene(scene);
    	    		stageHome.show();
    			} catch (IOException ex) {
    				Logger.getLogger(categoryList.class.getName()).log(Level.SEVERE, null, ex);
    			}
    		}
    	});
    	txGrid.add(backToHome, 2, displayPadder);
    }


	@Override
	public void start(Stage primaryStage) throws Exception {
		txGrid = new GridPane();
		txGrid.setAlignment(Pos.CENTER);
	        txGrid.setHgap(10);
	        txGrid.setVgap(10);
	        txGrid.setPadding(new Insets(25, 25, 25, 25));
	        System.out.println("start");

	        Text scenetitle = new Text("Transaction History");
	        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	        txGrid.add(scenetitle, 0, 0, 2, 1);
	        Scene scene = new Scene(txGrid, 1000, 1000);
	        
	    	List<BgtTransaction> transList = Context.getInstance().currentUser().getTransactionList();
	    	
	    	for(BgtTransaction transact: transList)
	    	{
	    		Label info = new Label("Date: " + transact.getTransactionDate() + " --- "
	    				+ "Category: " + transact.getTransactionCategory().getName() + " --- "
	    				+ "Amount: " + transact.getTransactionAmount() + " --- "
	    				+ "Notes: " + transact.getTransactionNotes());
	    		System.out.println(info.toString());
	    		txGrid.add(info, 0, 0);
	    	}
	}
    
    

}
