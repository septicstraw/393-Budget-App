package com.ex.bgt;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ex.bgt.domain.Context;
import com.ex.bgt.domain.Income;
import com.ex.bgt.domain.User;
import com.ex.dao.UserDao;
import com.ex.impl.UserDaoImpl;

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
	private double amount;
	
	private User usr = Context.getInstance().currentUser();
	
	private Income income;
	
	@FXML
	void initialize() {
		amount = income.getAmount();
	}
	
	@FXML
	void saveIncome(ActionEvent event) {
		income.setAmount(amount);
		usr.setIncome(income);
		UserDao usrDao = new UserDaoImpl();
		usrDao.updateUser(usr);
		Context.getInstance().setCurrentUser(usr);
	}
	
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
