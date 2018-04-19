package com.ex.bgt;

import com.ex.bgt.domain.Category;
import com.ex.bgt.domain.Context;

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

public class CategoryDisplayScene extends Application {
	
	private Category selectedCategory;
	
	private boolean purchaseMode = true;//false is deposit mode

	public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	
    	Category test = new Category("pant", 100, 1);
    	Context.getInstance().setCurrentCategory(test);
    	
    	selectedCategory = Context.getInstance().getCurrentCategory();
    	
        primaryStage.setTitle("Category Display");
       
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 1000, 1000);
        primaryStage.setScene(scene);

        Text scenetitle = new Text("View Category");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label name = new Label("Name:");
        grid.add(name, 0, 1);

        Text nameVal = new Text();
        nameVal.setText(selectedCategory.getName());
        grid.add(nameVal, 1, 1);

        Label amt = new Label("Amount:");
        grid.add(amt, 0, 2);

        Text amtVal = new Text();
        amtVal.setText(selectedCategory.getCurrentFunds() + "");
        grid.add(amtVal, 1, 2);
        
        Button purBtn = new Button("Purchase");
        HBox purHbBtn = new HBox(10);
        purHbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        purHbBtn.getChildren().add(purBtn);
        grid.add(purHbBtn, 1, 4);
        
        Button depBtn = new Button("Deposit");
        HBox depHbBtn = new HBox(10);
        depHbBtn.setAlignment(Pos.BOTTOM_LEFT);
        depHbBtn.getChildren().add(depBtn);
        grid.add(depHbBtn, 0, 4);

        final TextField actiontarget = new TextField();
        actiontarget.setAlignment(Pos.BOTTOM_CENTER);
        grid.add(actiontarget, 0, 5);
        
        final Button confirmBtn = new Button("Confirm");
        HBox confirmHb = new HBox(10);
        confirmHb.setAlignment(Pos.BOTTOM_LEFT);
        confirmHb.getChildren().add(confirmBtn);
        grid.add(confirmHb, 1, 5);
        
        actiontarget.setVisible(false);
        confirmBtn.setVisible(false);
        
        purBtn.setOnAction(new EventHandler<ActionEvent>() {
       	 
            public void handle(ActionEvent e) {
                actiontarget.setPromptText("Enter purchase amount...");
                purchaseMode = true;
                actiontarget.setVisible(true);
                confirmBtn.setVisible(true);
            }
        });
        depBtn.setOnAction(new EventHandler<ActionEvent>() {
       	 
            public void handle(ActionEvent e) {
                actiontarget.setPromptText("Enter deposit amount...");
                purchaseMode = false;
                actiontarget.setVisible(true);
                confirmBtn.setVisible(true);
            }
        });
        confirmBtn.setOnAction(new EventHandler<ActionEvent>() {
          	 
            public void handle(ActionEvent e) {
                if (purchaseMode) {
                	actiontarget.setPromptText("making purchase...");
                	if (actiontarget.getText().matches("[0-9]+")) {
                		double purchaseAmount = Integer.parseInt(actiontarget.getText());
                		//BgtTransaction trans = new BgtTransaction(purchaseAmount, 
                		selectedCategory.setCurrentFunds(selectedCategory.getCurrentFunds() - purchaseAmount);
                	}
                } else {
                	actiontarget.setPromptText("making deposit...");
                	int depositAmount = Integer.parseInt(actiontarget.getText());
            		//BgtTransaction trans = new BgtTransaction()
            		selectedCategory.setCurrentFunds(selectedCategory.getCurrentFunds() + depositAmount);
                }
                confirmBtn.setVisible(false);
                actiontarget.setVisible(false);
            }
        });
        
        primaryStage.show();
    }
    
    

}
