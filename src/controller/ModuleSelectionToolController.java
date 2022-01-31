package controller;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import model.Course;
import model.Schedule;
import model.Module;
import model.StudentProfile;
import view.ModuleSelectionToolRootPane;
import view.OverviewSelectionPane;
import view.ReserveModulesPane;
import view.SelectModulesPane;
import view.CreateStudentProfilePane;
import view.ModuleSelectionToolMenuBar;
//Author P2557088

public class ModuleSelectionToolController {

	//fields to be used throughout class
	private ModuleSelectionToolRootPane view;
	private StudentProfile model;
	private OverviewSelectionPane osp;
	private ReserveModulesPane rmp;
	private SelectModulesPane smp;
	private CreateStudentProfilePane cspp;
	private ModuleSelectionToolMenuBar mstmb;

	public ModuleSelectionToolController(ModuleSelectionToolRootPane view, StudentProfile model) {
		this.model = model;
		this.view = view;
		mstmb = view.getModuleSelectionToolMenuBar();
		cspp = view.getCreateStudentProfilePane();
		smp = view.getSelecteModulesPane();
		rmp = view.getReserveModulesPane();
		osp = view.getOverviewSelectionPane();
		cspp.addCoursesToComboBox(generateAndReturnCourses());
		this.attachEventHandlers();

	}

	private void attachEventHandlers() {
		mstmb.addLoadHandler(new LoadMenuHandler());
		mstmb.addSaveHandler(new SaveMenuHandler());
		mstmb.addExitHandler(e -> System.exit(0));
		mstmb.addAboutHandler(e -> this.alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", null, "FinalYearModuleChooser app v1.0"));
		cspp.addCreateStudentProfileHandler(new CreateBtnHandler());
		smp.addAddOneButtonListener(new addToSelectedModules());
		smp.addAddTwoButtonListener(new addToSelectedModulesTwo());
		smp.addRemoveOneButtonListener(new RemoveSelectedModules());
		smp.addRemoveTwoButtonListener(new RemoveSelectedModulesTwo());
		smp.addSubmitButtonListener(new SubmitbtnHandler());
		osp.addBtnSaveOverview(new SaveOverview());
		smp.addResetButtonListener(new ResetSetupModuleChooser());
		rmp.addbtnConfirmHandler(new Confirmbtn1Handler());
		rmp.addbtn2ConfirmHandler(new ConfirmReservedHandler());
	}

	                
	private Course[] generateAndReturnCourses() {
		Module imat3423 = new Module("IMAT3423", "Systems Building: Methods", 15, true, Schedule.TERM_1);
		Module imat3451 = new Module("IMAT3451", "Development Project", 30, true, Schedule.YEAR_LONG);
		Module ctec3902_SoftEng = new Module("CTEC3902", "Rigorous Systems", 15, true, Schedule.TERM_2);	
		Module ctec3902_CompSci = new Module("CTEC3902", "Rigorous Systems", 15, false, Schedule.TERM_2);
		Module ctec3110 = new Module("CTEC3110", "Secure Web Application Development", 15, false, Schedule.TERM_1);
		Module ctec3605 = new Module("CTEC3605", "Multi-service Networks 1", 15, false, Schedule.TERM_1);	
		Module ctec3606 = new Module("CTEC3606", "Multi-service Networks 2", 15, false, Schedule.TERM_2);	
		Module ctec3410 = new Module("CTEC3410", "Web Application Penetration Testing", 15, false, Schedule.TERM_2);
		Module ctec3904 = new Module("CTEC3904", "Functional Software Development", 15, false, Schedule.TERM_2);
		Module ctec3905 = new Module("CTEC3905", "Front-End Web Development", 15, false, Schedule.TERM_2);
		Module ctec3906 = new Module("CTEC3906", "Interaction Design", 15, false, Schedule.TERM_1);
		Module imat3410 = new Module("IMAT3104", "Database Management and Programming", 15, false, Schedule.TERM_2);
		Module imat3406 = new Module("IMAT3406", "Fuzzy Logic and Knowledge Based Systems", 15, false, Schedule.TERM_1);
		Module imat3611 = new Module("IMAT3611", "Popular Technology Ethics", 15, false, Schedule.TERM_1);
		Module imat3613 = new Module("IMAT3613", "Data Mining", 15, false, Schedule.TERM_1);
		Module imat3614 = new Module("IMAT3614", "Big Data and Business Models", 15, false, Schedule.TERM_2);
		Module imat3428_CompSci = new Module("IMAT3428", "Information Technology Services Practice", 15, false, Schedule.TERM_2);

		Course compSci = new Course("Computer Science");
		compSci.addModuleToCourse(imat3423);
		compSci.addModuleToCourse(imat3451);
		compSci.addModuleToCourse(ctec3902_CompSci);
		compSci.addModuleToCourse(ctec3110);
		compSci.addModuleToCourse(ctec3605);
		compSci.addModuleToCourse(ctec3606);
		compSci.addModuleToCourse(ctec3410);
		compSci.addModuleToCourse(ctec3904);
		compSci.addModuleToCourse(ctec3905);
		compSci.addModuleToCourse(ctec3906);
		compSci.addModuleToCourse(imat3410);
		compSci.addModuleToCourse(imat3406);
		compSci.addModuleToCourse(imat3611);
		compSci.addModuleToCourse(imat3613);
		compSci.addModuleToCourse(imat3614);
		compSci.addModuleToCourse(imat3428_CompSci);

		Course softEng = new Course("Software Engineering");
		softEng.addModuleToCourse(imat3423);
		softEng.addModuleToCourse(imat3451);
		softEng.addModuleToCourse(ctec3902_SoftEng);
		softEng.addModuleToCourse(ctec3110);
		softEng.addModuleToCourse(ctec3605);
		softEng.addModuleToCourse(ctec3606);
		softEng.addModuleToCourse(ctec3410);
		softEng.addModuleToCourse(ctec3904);
		softEng.addModuleToCourse(ctec3905);
		softEng.addModuleToCourse(ctec3906);
		softEng.addModuleToCourse(imat3410);
		softEng.addModuleToCourse(imat3406);
		softEng.addModuleToCourse(imat3611);
		softEng.addModuleToCourse(imat3613);
		softEng.addModuleToCourse(imat3614);

		Course[] courses = new Course[2];
		courses[0] = compSci;
		courses[1] = softEng;

		return courses;
	}
	
	private void alertDialogBuilder(AlertType type, String title, String header, String content) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

	public class CreateBtnHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			if (cspp.getStudentName() == null) {
				alertDialogBuilder(AlertType.ERROR, "error dialog", "error failed", "incorrect first name");
				return;	
			} if (cspp.getStudentPnumber().isEmpty()) {
				alertDialogBuilder(AlertType.ERROR, "error dialog", "error failed", "incorrect P Number");
				return;	
			} if (cspp.getStudentEmail().isEmpty()) {
				alertDialogBuilder(AlertType.ERROR, "error dialog", "error failed", "incorrect email");
				return;	
			} if (cspp.getStudentDate().toString().isEmpty()) {
				alertDialogBuilder(AlertType.ERROR, "error dialog", "error failed", "incorrect date");
				return;	
			}
			
			model.setStudentCourse(view.getCreateStudentProfilePane().getSelectedCourse());
			smp.populateListViewWithModules(model);
			smp.updateCurrentCredits(model.getStudentCourse());
			smp.updateCurrentCreditsTwo(model.getStudentCourse());
			
			model.setStudentName(view.getCreateStudentProfilePane().getStudentName());
			
			model.setStudentEmail(view.getCreateStudentProfilePane().getStudentEmail());
			
			model.setStudentPnumber(view.getCreateStudentProfilePane().getStudentPnumber());
			
			model.setSubmissionDate(view.getCreateStudentProfilePane().getStudentDate());
			
			view.changeTab(1);
		}
	}
	public class SubmitbtnHandler implements EventHandler<ActionEvent>{
			  @Override
		        public void handle(ActionEvent e) {
		            model.clearSelectedModules();
		            List<Module> selectedT1Modules = smp.getSelectedTerm1();
		            selectedT1Modules.forEach((m) -> {
		                model.addSelectedModule(m);
		            });
		            List<Module> selectedT2Modules = smp.getSelectedTerm2();
		            selectedT2Modules.forEach((m) -> {
		                model.addSelectedModule(m);
		            });
		            List<Module> unSelectedT1Modules = smp.getSelectedTerm1Modules();
		            List<Module> unSelectedT2Modules = smp.getSelectedTerm2Modules();
		            rmp.addT1UMods(unSelectedT1Modules);
		            rmp.addT2UMods(unSelectedT2Modules);
		            view.changeTab(2);
		}
	}
	public class Confirmbtn1Handler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			rmp.changePane();
		}
	}
	public class addToSelectedModules implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			model.getAllSelectedModules().add(smp.getSelectedTermOneModules());
			smp.updateSelectedModulesListViews(model.getAllSelectedModules());
			
		}
		
	}
	
	public class RemoveSelectedModules implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			model.getAllSelectedModules().remove(smp.getSelectedSelectedTermOneModules());
			smp.updateSelectedModulesListViews(model.getAllSelectedModules());
			}
		
	}
	
	public class addToSelectedModulesTwo implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			model.getAllSelectedModules().add(smp.getSelectedTermTwoModules());
			smp.updateSelectedModulesListViews(model.getAllSelectedModules());
			}
		
	}
	
	public class RemoveSelectedModulesTwo implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			model.getAllSelectedModules().remove(smp.getSelectedSelectedTermTwoModules());
			smp.updateSelectedModulesListViews(model.getAllSelectedModules());
			}
	}
	public class ConfirmReservedHandler implements EventHandler<ActionEvent> {
		 @Override
	        public void handle(ActionEvent e) {
	            model.clearReservedModules();
	            List<Module> reservedTerm1Modules = rmp.getReservedTerm1();
	            reservedTerm1Modules.forEach((m) -> {
	                model.addReservedModule(m);
	            });
	            List<Module> reservedTerm2Modules = rmp.getReservedTerm2();
	            reservedTerm2Modules.forEach((m) -> {
	                model.addReservedModule(m);
	            });
	            osp.setpa(model.toString());
	            osp.addsm(model.getAllSelectedModules());
	            osp.addrm(model.getAllReservedModules());
	            view.changeTab(3);
		}
		
	}
	
	public class SaveOverview implements EventHandler<ActionEvent> {
		   @Override
	        public void handle(ActionEvent e) {

	            try {
	                try (PrintWriter pw = new PrintWriter("overview.txt")) {
	                    pw.write(model.getPersonelDetails());
	                    pw.write("\nSelected Modules:\n");
	                    model.getAllSelectedModules().forEach((next) -> {
	                        pw.write(next.getModuleName() + "\n");
	                    });
	                    pw.write("\nReserved Modules:\n");
	                    model.getAllReservedModules().forEach((next) -> {
	                        pw.write(next.getModuleName() + "\n");
	                    });
	                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
	                    alert.setHeaderText("Save");
	                    alert.setContentText("Successfull");
	                    alert.showAndWait();
	                }
	            } catch (FileNotFoundException ex) {
	                Logger.getLogger(ModuleSelectionToolController.class.getName()).log(Level.SEVERE, null, ex);
	            }

	        }
	}
	
	public class LoadMenuHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream("saveOptionsChooserObj.dat"));
				model = (StudentProfile) ois.readObject();
				alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Load success", "Student profile loaded from saveOptionsChooserObj.dat.");
			} catch (IOException | ClassNotFoundException e1) {
				e1.printStackTrace();
			} finally {
				if (ois != null) {
					try {
						ois.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}	
	}
	
	public class SaveMenuHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(new FileOutputStream("saveOptionsChooserObj.dat"));
				oos.writeObject(model);
				oos.flush();
				alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Save success", "Options Chooser saved to saveOptionsChooserObj.dat.");
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					oos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public class ResetSetupModuleChooser implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			Set<Module> mySet = model.getAllSelectedModules();
			for (Module c : mySet) {
				if (view.getCreateStudentProfilePane().getSelectedCourse().getCourseName().equals("Computer Science") && !c.isMandatory()) {
					model.getAllSelectedModules().remove(c);
					smp.updateSelectedModulesListViews(model.getAllSelectedModules());
				} else if (view.getCreateStudentProfilePane().getSelectedCourse().getCourseName().equals("Software Engineering") && !c.isMandatory()) {
					model.getAllSelectedModules().remove(c);
					smp.updateSelectedModulesListViews(model.getAllSelectedModules());
				}
			}
		}
		
	}
}
