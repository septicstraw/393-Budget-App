package com.ex.bgt;

import java.util.LinkedList;
import java.util.List;

import com.ex.bgt.domain.BgtTransaction;
import com.ex.bgt.domain.Category;
import com.ex.bgt.domain.Context;
import com.ex.bgt.domain.User;
import com.ex.dao.TransactionDao;
import com.ex.impl.TransactionDaoImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TransactionController {

    @FXML
    private MenuButton categories;

    @FXML
    private DatePicker date;

    @FXML
    private TextField amount;

    @FXML
    private TextArea notes;
    
    private User usr = Context.getInstance().currentUser();
    
    @FXML
    public void initialize () {
    	System.out.println("transactions\n");
    	//MenuItem item = new MenuItem();
    	List<MenuItem> items = new LinkedList<MenuItem>();
    	for (Category c : usr.getCategoryList())  {
    		MenuItem item = new MenuItem();
    		item.setId(c.getId() + "");
    		item.setText(c.getName());
    		items.add(item);
    	}
    	categories.getItems().removeAll();
    	categories.getItems().addAll(items);
    }

    @FXML
    void saveTransaction(ActionEvent event) { 	  		
    	TransactionDao tDao = new TransactionDaoImpl();
    	BgtTransaction tx = new BgtTransaction();
    	tx.setTransactionUser(usr);
    	tx.setTransactionAmount(Double.parseDouble(amount.getText()));
    	//tx.setTransactionDate(date.getD);
    	//tx.setTransactionCategory(categories.);
    	
    }

}
