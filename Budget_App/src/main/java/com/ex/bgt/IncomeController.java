package com.ex.bgt;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class IncomeController {

	@FXML
    private Button redirectBtn;
	
    @FXML
    void redirectCreateCat(ActionEvent event) {
    	Parent root;
    	Stage stage;
    	try {
    		System.out.println("here\n");
    		root = FXMLLoader.load(getClass().getResource("saveCategory.fxml"));
    		Scene scene = new Scene(root);
    		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		stage.setScene(scene);
    		stage.show();
		} catch (IOException ex) {
			Logger.getLogger(IncomeController.class.getName()).log(Level.SEVERE, null, ex);
		}
    }

    @FXML
    void redirectSaveTx(ActionEvent event) {
    	Parent root;
    	Stage stage;
    	try {
    		System.out.println("here\n");
    		root = FXMLLoader.load(getClass().getResource("transactions.fxml"));
    		Scene scene = new Scene(root);
    		//Node node;
    		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		stage.setScene(scene);
    		stage.show();
		} catch (IOException ex) {
			Logger.getLogger(IncomeController.class.getName()).log(Level.SEVERE, null, ex);
		}
    }

    @FXML
    void redirectTx(ActionEvent event) {
    	Parent root;
    	Stage stage;
    	try {
    		System.out.println("here\n");
    		root = FXMLLoader.load(getClass().getResource("transactionHistory.fxml"));
    		Scene scene = new Scene(root);
    		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		stage.setScene(scene);
    		stage.show();
		} catch (IOException ex) {
			Logger.getLogger(IncomeController.class.getName()).log(Level.SEVERE, null, ex);
		}
    }

    @FXML
    void redirectViewCats(ActionEvent event) {
    	Parent root;
    	Stage stage;
    	try {
    		System.out.println("here\n");
    		root = FXMLLoader.load(getClass().getResource("categoryList.fxml"));
    		Scene scene = new Scene(root);
    		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		stage.setScene(scene);
    		stage.show();
		} catch (IOException ex) {
			Logger.getLogger(IncomeController.class.getName()).log(Level.SEVERE, null, ex);
		}
    }

}
