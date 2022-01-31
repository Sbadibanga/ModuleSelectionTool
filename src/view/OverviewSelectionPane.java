package view;

import java.io.File;

import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import controller.ModuleSelectionToolController.SaveOverview;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import model.Course;
import model.Module;
import model.StudentProfile;

public class OverviewSelectionPane extends GridPane {
	private TextArea profil,select,reserve;
	private Button btnSave;
	private FileChooser fil_chooser;
	private static String studentProfile;
	private static String selectedModule;
	private static String reservedModule;

	
	public OverviewSelectionPane() {
		    profil = new TextArea("Profile will appear here:");
	        select = new TextArea("Selected modules will appear here:");
	        reserve = new TextArea("Reserved mdoules will appear here:");
	        btnSave = new Button("Save Overview");
	        HBox bottom = new HBox(btnSave);
	        this.add(profil, 0, 0, 2, 1);
	        this.add(select, 0, 1);
	        this.add(reserve, 1, 1);
	        this.add(bottom, 0, 2, 2, 1);
	        this.setVgap(10);
	        this.setHgap(15);
	        this.setPadding(new Insets(20));
	        this.setAlignment(Pos.CENTER);
	        profil.prefWidthProperty().bind(this.widthProperty());
	        profil.prefHeightProperty().bind(this.heightProperty());
	        select.prefWidthProperty().bind(this.widthProperty());
	        select.prefHeightProperty().bind(this.heightProperty());
	        reserve.prefWidthProperty().bind(this.widthProperty());
	        reserve.prefHeightProperty().bind(this.heightProperty());
	        btnSave.setPrefWidth(90);
	        bottom.setAlignment(Pos.CENTER);
	}
	
	 public void setpa(String s) {
	        profil.setText(s);
	    }

	    public void addsm(Set<Module> set) {
	        set.forEach((next) -> {
	            select.appendText(next.getModuleName() + "\n");
	        });
	    }

	    public void addrm(Set<Module> set) {
	        set.forEach((next) -> {
	            reserve.appendText(next.getModuleName() + "\n");
	        });
	    }

	    public void addSaveOverviewHandler(EventHandler<ActionEvent> handler) {
	        btnSave.setOnAction(handler);
	    }
	    
	    public void getStudentOverView(StudentProfile profile, Course course) {

	        studentProfile
	                = "Name: " + profile.getStudentName().getFullName() + " "
	                + "\n" + "PNo: " + " " + profile.getStudentPnumber() + "\n"
	                + "\n" + "Email: " + " " + profile.getStudentEmail() + "\n"
	                + "\n"+ "Date: " + "" + profile.getStudentEmail() + "\n"
	                + "\n" + "Course: " + " " + course.getCourseName();

	        selectedModule = "Selected modules " + "\n"
	                + "==================================" + "\n";
	        for (Module m : profile.getAllSelectedModules()) {
	            selectedModule += "\n";
	            selectedModule += "ModuleCode:" + m.getModuleCode()
	                    + ", Module Name:" + m.getModuleName() + "\n"
	                    + "Credits:" + m.getModuleCredits() + ", Mendatory on your course " + m.isMandatory() + ", Term " + m.getDelivery() + "\n";

	        }

	        reservedModule = "Reserved modules " + "\n"
	                + "==================================" + "\n";
	        for (Module m : profile.getAllReservedModules()) {
	            reservedModule += "\n";
	            reservedModule += "ModuleCode:" + m.getModuleCode()
	                    + ", Module Name:" + m.getModuleName() + "\n"
	                    + "Credits:" + m.getModuleCredits() + ", Mendatory on your course " + m.isMandatory() + ", Term " + m.getDelivery() + "\n";

	        }
	        profil.setText(studentProfile);
	        select.setText(selectedModule);
	        reserve.setText(reservedModule);
	    }

	    public void saveStudentProfile(StudentProfile profile) {

	        fil_chooser = new FileChooser();
	        File file = fil_chooser.showSaveDialog(null);
	       
	        try {

	            PrintWriter printWriter = new PrintWriter(file);
	            printWriter.write(studentProfile + "\n" + selectedModule + "\n" + reservedModule);
	            printWriter.close();
	        } catch (Exception e) {

	        }

	    }

		public String getSelectionOverview() {
			// TODO Auto-generated method stub
			return null;
		}

		public void addBtnSaveOverview(SaveOverview saveOverview) {
			// TODO Auto-generated method stub
			
		}

	}


