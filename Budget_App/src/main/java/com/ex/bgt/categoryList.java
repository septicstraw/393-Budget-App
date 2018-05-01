package com.ex.bgt;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

public class categoryList {
	@FXML
	private GridPane catGrid;
	private User usr;

	public static void main(String[] args) 
	{
    }
	
    
    @FXML
    public void initialize() 
    {
    	System.out.println("initialize");
    	usr = Context.getInstance().currentUser();
        catGrid = new GridPane();
        catGrid.setAlignment(Pos.CENTER);
        catGrid.setHgap(10);
        catGrid.setVgap(10);
        catGrid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("View Categories");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        catGrid.add(scenetitle, 0, 0, 2, 1);
        Scene scene = new Scene(catGrid, 1000, 1000);
        
        Stage stage = new Stage();
        stage.setTitle("View Categories");
        stage.setScene(scene);
        stage.show();
        
        
    	List<Category> catList = Context.getInstance().currentUser().getCategoryList();
 
    	int displayPadder = 1;
    	for(Category cat: catList)
    	{
    		List<SubCategory> subcatList = cat.getSubcategories();
    		StringBuilder subcatListString = new StringBuilder();
    		for (int i = 0; i < subcatList.size(); i++) {
    			if (i == subcatList.size()-1) subcatListString.append(subcatList.get(i).getName());
    			else subcatListString.append(subcatList.get(i).getName() + ", ");
    		}
    		Label info = new Label("Name: " + cat.getName() + " --- "
    				+ "Initial Funds: " + cat.getInitialFunds() + " --- "
    				+ "Current Funds: " + cat.getCurrentFunds() + " --- "
    				+ "Priority: " + cat.getPriority() + " --- "
    				+ "Subcategories" + subcatListString.toString());
    		System.out.println(info.toString());
    		catGrid.add(info, 0, displayPadder);
    		displayPadder += 2;
    	}
    	Button rolloverButton = new Button();
    	rolloverButton.setText("Rollover");
    	rolloverButton.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent e) {
    			UserMethods usrMethods = new UserMethods();
    			usrMethods.rollover(usr);
    			
    			Node  source = (Node)  e.getSource(); 
    			Stage stage  = (Stage) source.getScene().getWindow();
    		    stage.close();
    		    
    		    UserDao usrDao = new UserDaoImpl();
    		    System.out.println(usr.getID());
    		    Context.getInstance().setCurrentUser(usrDao.getUserById(usr.getID()));
    			initialize();
    		}
    	});
    	catGrid.add(rolloverButton, 0, displayPadder);
    }
}
