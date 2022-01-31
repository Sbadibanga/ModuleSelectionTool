package view;

import java.util.ArrayList;   
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Course;
import model.Module;
import model.Schedule;
import model.StudentProfile;
 
public class SelectModulesPane extends VBox {
	
	private StudentProfile model;
	private TextField term1Credits, term2Credits;
	private Button btnSubmit, btnReset, btnAdd, btnRemove, btnAdd1, btnRemove1;
	private Label unSelectedLabel1, unSelectedLabel2, selectedLabel1, selectedLabel2, unSelectedTerm1Label, unSelectedTerm2Label2, term1CreditsLabel, yearLongLabel, term2CreditsLabel;
	private ListView<Module> unSelectedListView1, unSelectedListView2, selectedListView1, selectedListView2, yearLongListView;
	private VBox unSelectedVBox1, unSelectedVBox2, selectedVBox1, selectedVBox2, unSelectedTerm1VBox1, unSelectedTerm2VBox2, buttonResetVBox, term1CreditsVBox, VBox1, VBox2, yearLongVBox, term2CreditsVBox, buttonSubmitVBox;
	private HBox unSelectedTerm1HBox1, unSelectedTerm2HBox2, term1CreditsHBox, buttonResetHBox, term2CreditsHBox, buttonSubmitHBox, containerHBox;

	public SelectModulesPane() {
		
		//listviews etc
		unSelectedVBox1 = new VBox();
		unSelectedListView1 = new ListView<Module>();
		unSelectedListView1.setPrefSize(500, 150);
		unSelectedLabel1 = new Label("Unselected Term 1 modules");
		unSelectedVBox1.getChildren().addAll(unSelectedLabel1, unSelectedListView1);
		
		unSelectedTerm1HBox1 = new HBox();
		btnAdd = new Button("Add");
		btnAdd.setPrefSize(70, 30);
		btnRemove = new Button("Remove");
		btnRemove.setPrefSize(70, 30);
		unSelectedTerm1Label = new Label("Term 1");
		unSelectedTerm1HBox1.getChildren().addAll(unSelectedTerm1Label, btnAdd, btnRemove);
		unSelectedTerm1HBox1.setSpacing(15);
		unSelectedTerm1HBox1.setAlignment(Pos.CENTER);
		unSelectedTerm1VBox1 = new VBox(unSelectedTerm1HBox1);
		unSelectedTerm1VBox1.setPadding(new Insets(25, 0, 30, 0));
		
		unSelectedVBox2 = new VBox();
		unSelectedListView2 = new ListView<Module>();
		unSelectedListView2.setPrefSize(500, 150);
		unSelectedLabel2 = new Label("Unselected Term 2 modules");
		unSelectedVBox2.getChildren().addAll(unSelectedLabel2, unSelectedListView2);
		unSelectedVBox2.setPadding(new Insets(0, 0, 30, 0));
		
		
		unSelectedTerm2HBox2 = new HBox();
		btnAdd1 = new Button("Add");
		btnRemove1 = new Button("Remove");
		btnRemove1.setPrefSize(70, 30);
		unSelectedTerm2Label2 = new Label("Term 2");
		unSelectedTerm2HBox2.getChildren().addAll(unSelectedTerm2Label2, btnAdd1, btnRemove1);
		unSelectedTerm2HBox2.setSpacing(15);
		unSelectedTerm2HBox2.setAlignment(Pos.CENTER);
		unSelectedTerm2VBox2 = new VBox(unSelectedTerm2HBox2);
		unSelectedTerm2VBox2.setPadding(new Insets(25, 0, 30, 0));
		
		term1CreditsHBox = new HBox();
		term1Credits = new TextField("0");
		term1Credits.setPrefSize(70, 32);
		term1Credits.setEditable(false);
		term1CreditsLabel = new Label("Current term 1 credits");
		term1CreditsHBox.getChildren().addAll(term1CreditsLabel, term1Credits);
		term1CreditsHBox.setSpacing(15);
		term1CreditsHBox.setAlignment(Pos.CENTER);
		term1CreditsVBox = new VBox(term1CreditsHBox);
		term1CreditsVBox.setPadding(new Insets(35, 0, 20, 80));
		
		buttonResetHBox = new HBox();
		btnReset = new Button("Reset");
		btnReset.setPrefSize(70, 30);
		buttonResetHBox.getChildren().addAll(btnReset);
		buttonResetHBox.setSpacing(15);
		buttonResetHBox.setAlignment(Pos.BASELINE_RIGHT);
		buttonResetVBox = new VBox(buttonResetHBox);
		buttonResetVBox.setPadding(new Insets(0, 0, 30, 0));
		VBox1 = new VBox();
		VBox1.getChildren().addAll(unSelectedVBox1, unSelectedTerm1VBox1, unSelectedVBox2, unSelectedTerm2HBox2, term1CreditsVBox, buttonResetVBox);
		VBox.setVgrow(VBox1, Priority.ALWAYS);
		
		yearLongVBox = new VBox();
		yearLongListView = new ListView<Module>();
		yearLongListView.setPrefSize(400, 100);
		yearLongLabel = new Label("Selected Year Long modules");
		yearLongVBox.getChildren().addAll(yearLongLabel, yearLongListView);
		yearLongVBox.setPadding(new Insets(0, 0, 2, 0));
		
		selectedVBox1 = new VBox();
		selectedListView1 = new ListView<Module>();
		selectedListView1.setPrefSize(400, 150);
		selectedLabel1 = new Label("Selected Term 1 modules");
		selectedVBox1.getChildren().addAll(selectedLabel1, selectedListView1);
		selectedVBox1.setPadding(new Insets(20, 0, 30, 0));
		
		selectedVBox2 = new VBox();
		selectedListView2 = new ListView<Module>();
		selectedListView2.setPrefSize(400, 150);
		selectedLabel2 = new Label("Selected Term 2 modules");
		selectedVBox2.getChildren().addAll(selectedLabel2, selectedListView2);
		selectedVBox2.setPadding(new Insets(0, 0, 30, 0));
		
		term2CreditsHBox = new HBox();
		term2Credits = new TextField("0");
		term2Credits.setPrefSize(70, 32);
		term2Credits.setEditable(false);
		term2CreditsLabel = new Label("Current term 2 credits");
		term2CreditsHBox.getChildren().addAll(term2CreditsLabel, term2Credits);
		term2CreditsHBox.setSpacing(15);
		term2CreditsHBox.setAlignment(Pos.CENTER);
		term2CreditsVBox = new VBox(term2CreditsHBox);
		term2CreditsVBox.setPadding(new Insets(5, 0, 20, 80));
		
		buttonSubmitHBox = new HBox();
		btnSubmit = new Button("Submit");
		btnSubmit.setPrefSize(70, 30);
		buttonSubmitHBox.getChildren().addAll(btnSubmit);
		buttonSubmitHBox.setSpacing(15);
		buttonSubmitHBox.setAlignment(Pos.BASELINE_LEFT);
		buttonSubmitVBox = new VBox(buttonSubmitHBox);
		buttonSubmitVBox.setPadding(new Insets(27, 0, 0, 0));
		VBox2 = new VBox();
		VBox2.getChildren().addAll(yearLongVBox, selectedVBox1, selectedVBox2, term2CreditsVBox, buttonSubmitVBox);
		VBox.setVgrow(VBox2, Priority.ALWAYS);
		
		containerHBox = new HBox(VBox1, VBox2);
		containerHBox.setAlignment(Pos.CENTER);
		containerHBox.setSpacing(20);
		
		this.getChildren().add(containerHBox);
		this.setPadding(new Insets(20, 20, 20, 20));
		HBox.setHgrow(VBox1, Priority.ALWAYS);
		HBox.setHgrow(VBox2, Priority.ALWAYS);
		
		
	}
	public void populateListViewWithModules(StudentProfile model) {
		Collection<Module> viewModules = new ArrayList<Module>();
		Collection<Module> viewModules2 = new ArrayList<Module>();
		Collection<Module> viewModules3 = new ArrayList<Module>();
		Collection<Module> viewModules4 = new ArrayList<Module>();
		Collection<Module> viewModules5 = new ArrayList<Module>();
		this.model = model;
		
		Course module = model.getStudentCourse();
		for(Module m : module.getAllModulesOnCourse()) {
			if (module.getCourseName().equals("Computer Science") && "IMAT3451".contains(m.getModuleCode())) {
				model.getAllSelectedModules().add(m);
			} else if (module.getCourseName().equals("Software Engineering") && "IMAT3451".contains(m.getModuleCode())) {
				model.getAllSelectedModules().add(m);
			} else if (module.getCourseName().equals("Computer Science") && "IMAT3423".contains(m.getModuleCode())) {
				model.getAllSelectedModules().add(m);
			} else if (module.getCourseName().equals("Software Engineering") && "IMAT3423".contains(m.getModuleCode())) {
				model.getAllSelectedModules().add(m);
			} else if (module.getCourseName().equals("Software Engineering") && "CTEC3902".contains(m.getModuleCode())) {
				model.getAllSelectedModules().add(m);
			} else if (module.getCourseName().equals("Computer Science") && "CTEC3110CTEC3426CTEC3605CTEC3906IMAT3406IMAT3611IMAT3613".contains(m.getModuleCode())) {
				viewModules4.add(m);
			} else if (module.getCourseName().equals("Software Engineering") && "CTEC3110CTEC3426CTEC3605CTEC3906IMAT3406IMAT3611IMAT3613".contains(m.getModuleCode())) {
				viewModules4.add(m);
			} else if (module.getCourseName().equals("Software Engineering") && "CTEC3410CTEC3606CTEC3904CTEC3905IMAT3104IMAT3614 ".contains(m.getModuleCode())) {
				viewModules5.add(m);
			} else {
				viewModules5.add(m);
			}
			yearLongListView.getItems().setAll(viewModules);
			selectedListView1.getItems().setAll(viewModules2);
			selectedListView2.getItems().setAll(viewModules3);
			unSelectedListView1.getItems().setAll(viewModules4);
			unSelectedListView2.getItems().setAll(viewModules5);
			updateSelectedModulesListViews(model.getAllSelectedModules());
	}
	
}
	public void updateSelectedModulesListViews(Set<Module> allSelectedModules) {
		selectedListView1.getItems().clear();
		selectedListView2.getItems().clear();
		yearLongListView.getItems().clear();
		for(Module module : allSelectedModules){
			if (module.getDelivery() == Schedule.TERM_1) {
				selectedListView1.getItems().add(module);
			} else if (module.getDelivery() == Schedule.TERM_2) {
				selectedListView2.getItems().add(module);
			} else if (module.getDelivery() == Schedule.YEAR_LONG) {
				yearLongListView.getItems().add(module);
			} else {
				selectedListView2.getItems().add(module);
			}
			
		}
		updateCurrentCredits(model.getStudentCourse());
		updateCurrentCreditsTwo(model.getStudentCourse());
	}
	
	public void updateCurrentCredits(Course courseOfStudy) { 
		Set<Module> collections = model.getAllSelectedModules();
		int totalCredits = 60;
		for (Module currentCredits : collections) {
			if(currentCredits.getDelivery() == Schedule.TERM_1) {
				totalCredits -= currentCredits.getModuleCredits();	
			} else if (totalCredits == -15) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("You have reached the maximum capacity of modules. ");
				alert.showAndWait();
				return;
			}
		}
		term1Credits.setText(totalCredits+"");
		}
	public void updateCurrentCreditsTwo(Course courseOfStudy) {
		Set<Module> collections = model.getAllSelectedModules();
		int totalCredits = 60;
		for (Module currentCredits : collections) {
			if(currentCredits.getDelivery() == Schedule.TERM_2) {
				totalCredits += currentCredits.getModuleCredits();	
			} else if (totalCredits == +15) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("You have reached the maximum capacity of modules. ");
				alert.showAndWait();
				return;
			}
			term2Credits.setText(totalCredits+"");
		}
	}
	public void addAddOneButtonListener(EventHandler<ActionEvent> handler) {
		btnAdd.setOnAction(handler);
	}
	
	public void addRemoveOneButtonListener(EventHandler<ActionEvent> handler) {
		btnRemove.setOnAction(handler);
	}
	
	public void addAddTwoButtonListener(EventHandler<ActionEvent> handler) {
		btnAdd1.setOnAction(handler);
	}
	
	public void addRemoveTwoButtonListener(EventHandler<ActionEvent> handler) {
		btnRemove1.setOnAction(handler);
	}
	
	
	public void addResetButtonListener(EventHandler<ActionEvent> handler) {
		btnReset.setOnAction(handler);
	}
	
	public void addSubmitButtonListener(EventHandler<ActionEvent> handler) {
		btnSubmit.setOnAction(handler);
	}
	
	public Module getSelectedTermOneModules() {
		return unSelectedListView1.getSelectionModel().getSelectedItem();		
	}
	public Module getSelectedTermTwoModules() {
		return unSelectedListView2.getSelectionModel().getSelectedItem();
	}
	public Module getSelectedSelectedTermOneModules() {
		return selectedListView1.getSelectionModel().getSelectedItem();
	}
	public Module getSelectedSelectedTermTwoModules() {
		return selectedListView2.getSelectionModel().getSelectedItem();
	}
	
	public List<Module>getSelectedTerm1Modules() {
		return unSelectedListView1.getItems();
		}
	   public List<Module> getSelectedTerm2Modules() {
		return unSelectedListView2.getItems();
		}
	   public List<Module> getSelectedTerm1() {
		   return selectedListView1.getItems();
		   }
	   public List<Module> getSelectedTerm2() {
		   return selectedListView2.getItems();
	   }

}



