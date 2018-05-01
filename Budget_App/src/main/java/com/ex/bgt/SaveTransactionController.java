package com.ex.bgt;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ex.bgt.domain.BgtTransaction;
import com.ex.bgt.domain.Category;
import com.ex.bgt.domain.Context;
import com.ex.bgt.domain.User;
import com.ex.dao.CategoryDao;
import com.ex.dao.TransactionDao;
import com.ex.impl.CategoryDaoImpl;
import com.ex.impl.TransactionDaoImpl;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SaveTransactionController {

	@FXML
	private MenuButton categories;

	@FXML
	private DatePicker datePicker;

	@FXML
	private TextField amount;

	@FXML
	private TextArea notes;

	private int catID;
	
	private LocalDate localDate;

	private User usr = Context.getInstance().currentUser();

	@FXML
	public void initialize() {
		System.out.println("transactions\n");
		// MenuItem item = new MenuItem();
		List<MenuItem> items = new LinkedList<MenuItem>();
		for (Category c : usr.getCategoryList()) {
			MenuItem item = new MenuItem();
			item.setId(c.getId() + "");
			item.setText(c.getName());
			item.setOnAction(a -> {
				catID = c.getId();
			});
			items.add(item);
		}
		categories.getItems().removeAll();
		categories.getItems().addAll(items);
		datePicker.setOnAction(e -> {
			localDate = datePicker.getValue();
			System.err.println("Selected date: " + localDate);
		});
	}

	@FXML
	void saveTransaction(ActionEvent event) {
		CategoryDao catDao = new CategoryDaoImpl();
		TransactionDao txDao = new TransactionDaoImpl(); 
		User usr = Context.getInstance().currentUser();
		Category cat = catDao.getCategoryByID(catID);
		BgtTransaction tx = new BgtTransaction();
		tx.setTransactionUser(usr);
		tx.setTransactionAmount(Double.parseDouble(amount.getText()));
		cat.setCurrentFunds(cat.getCurrentFunds() - Double.parseDouble(amount.getText()));
		catDao.updateCategory(cat);
		java.sql.Date date = java.sql.Date.valueOf(localDate);
		java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		tx.setTransactionCategory(catDao.getCategoryById(catID));
		tx.setTransactionDate(timestamp);
		tx.setTransactionNotes(notes.getText());
		
		txDao.saveTransaction(tx);
		System.out.println("saved\n");
	}

	@FXML
	void redirectCreateCat(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			System.out.println("here\n");
			root = FXMLLoader.load(getClass().getResource("saveCategory.fxml"));
			Scene scene = new Scene(root);
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException ex) {
			Logger.getLogger(SaveTransactionController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@FXML
	void redirectHome(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			System.out.println("here\n");
			root = FXMLLoader.load(getClass().getResource("income.fxml"));
			Scene scene = new Scene(root);
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException ex) {
			Logger.getLogger(SaveTransactionController.class.getName()).log(Level.SEVERE, null, ex);
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
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException ex) {
			Logger.getLogger(SaveTransactionController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@FXML
	void redirectViewCat(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			System.out.println("here\n");
			root = FXMLLoader.load(getClass().getResource("viewCategory.fxml"));
			Scene scene = new Scene(root);
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException ex) {
			Logger.getLogger(SaveTransactionController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
