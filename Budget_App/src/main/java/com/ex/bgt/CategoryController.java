package com.ex.bgt;

import java.util.LinkedList;
import java.util.List;

import com.ex.bgt.domain.Category;
import com.ex.bgt.domain.Context;
import com.ex.bgt.domain.User;
import com.ex.dao.CategoryDao;
import com.ex.dao.UserDao;
import com.ex.impl.CategoryDaoImpl;
import com.ex.impl.UserDaoImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CategoryController {

    @FXML
    private TextField name;

    @FXML
    private TextField initialFunds;

    @FXML
    private TextField currentFunds;

    @FXML
    private TextField priority;

    @FXML
    void saveCategory(ActionEvent event) {
    	List<TextField> fieldList = new LinkedList<TextField>();
    	fieldList.add(name);
    	fieldList.add(initialFunds);
    	fieldList.add(currentFunds);
    	fieldList.add(priority);
    	Alert fail = new Alert(AlertType.INFORMATION);
    	for (TextField e : fieldList) {
    		if (e.getText().equals("")) {
    			fail.setHeaderText("failure");
    			fail.setContentText("fields may not be empty");
    			fail.showAndWait();
    			break;
    		}
    	}
    	Category cat = new Category(Context.getInstance().currentUser(), name.getText(), Double.parseDouble(initialFunds.getText()), Integer.parseInt(priority.getText()));
    	CategoryDao catDao = new CategoryDaoImpl();
    	catDao.saveCategory(cat);
    	UserDao usrDao = new UserDaoImpl();
    	User usr = usrDao.getUserById(Context.getInstance().currentUser().getID());
    	Context.getInstance().setCurrentUser(usr);    	
    }

}