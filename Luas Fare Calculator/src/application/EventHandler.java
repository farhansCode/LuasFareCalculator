package application;

import application.LuasFareCalculator.typeOfPassenger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EventHandler {
	
	@FXML
	private Label output;
	@FXML
	private TextField textfield1;
	@FXML
	private TextField textfield2;
	@FXML
	private Button myFinalButton;
	
	private LuasFareCalculator.typeOfPassenger passenger = typeOfPassenger.ADULT;
	
	@FXML
	public void clickAdult(ActionEvent e) {
		
		passenger = typeOfPassenger.ADULT;
		
	}
	

	public void clickStudent(ActionEvent e) {
		
		passenger = typeOfPassenger.STUDENT;
		
	}


	public void clickChild(ActionEvent e) {
	
		passenger = typeOfPassenger.CHILD;
	
	}


	

	public void submit(ActionEvent e) {
		
		try {
		
		int numberOfDays = Integer.parseInt(textfield1.getText().trim());
		int numberOfZones = Integer.parseInt(textfield2.getText().trim());
		
		if(numberOfDays < 1 || numberOfZones < 1) {
			throw new IllegalStateException("Please enter a positive integer.");
		}
		
		LuasFareCalculator luasFareCalculator = new LuasFareCalculator(numberOfDays, passenger,numberOfZones);
	

		luasFareCalculator.fareCalculator();
	
		output.setText(luasFareCalculator.getOutput());
		
		
	} catch (Exception e1) {
		output.setText("Error! Make sure you have typed positive integers in the text boxes.");
	}
			
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
