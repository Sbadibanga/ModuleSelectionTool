package view;

import java.util.Set; 

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import model.Course;
import model.Module;
import model.Schedule;
import model.StudentProfile;


public class Term1 extends GridPane {
	
	private StudentProfile model;
	private ListView<Module> Unselected, Reserved;
	private Button btnAdd, btnRemove, btnConfirm;
	public Term1() {
		//styling
		//this.setPadding(new Insets(80, 80, 80, 80));
		this.setVgap(15);
		this.setHgap(20);
		
		Unselected = new ListView<Module>();
		Unselected.setMinSize(450, 400);
		Unselected.setMaxSize(600, 150);
		
		Reserved = new ListView<Module>();
		Reserved.setMinSize(450, 400);
		Reserved.setMaxSize(600, 150);
		//create labels
		Label lblUnselected2 = new Label("Unselceted Term 2 modules");
		Label lblReserved2 = new Label("Reserved Term 2 modules ");
		Label lblReserve30cred = new Label("Reserve 30 credits worth of term 2 modules");

		
		//initialise play button
		btnAdd = new Button("Add");
		btnRemove = new Button("Remove");
		btnConfirm = new Button("Confirm");

		//add controls and labels to container
		this.add(lblUnselected2, 1,2);
		this.add(Unselected, 1,3); 

		this.add(lblReserved2, 2, 2);
		this.add(Reserved, 2, 3);

		this.add(lblReserve30cred, 1, 4);
		this.add(btnAdd, 1,5);
		this.add(btnRemove, 2,5);
		this.add(btnConfirm, 3,5);
		
	
	}
	public Button getAddbtn() {
		return btnAdd;
	}
	public Button getRemovebtn() {
		return btnRemove;
	}
	public Button getConfirmbtn() {
		return btnConfirm;
	}
	public ListView<Module> getListview() {
		return Unselected;
	}
	public ListView<Module> getListview1() {
		return Reserved;
	}
	
}

	

