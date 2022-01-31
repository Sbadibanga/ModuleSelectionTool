package view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;


public class ModuleSelectionToolRootPane extends BorderPane {
	
	private ReserveModulesPane rmp;
	private SelectModulesPane smp;
	private OverviewSelectionPane osp;
	private CreateStudentProfilePane cspp;
	private ModuleSelectionToolMenuBar mstmb;
	private TabPane tp;
	private TitledPane t1, t2;
	
	public ModuleSelectionToolRootPane() {
		//create tab pane and disable tabs from being closed
		tp = new TabPane();
		tp.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		//create panes
		cspp = new CreateStudentProfilePane();
		rmp = new ReserveModulesPane();
		smp = new SelectModulesPane();
		osp = new OverviewSelectionPane();
		
		//create tabs with panes added
		Tab t1 = new Tab("Create Profile", cspp);
		Tab t2 = new Tab("Select Modules", smp);
		Tab t3 = new Tab("Reserve Modules", rmp);
		Tab t4 = new Tab("Overview Selection", osp);
		
		//add tabs to tab pane
		tp.getTabs().addAll(t1);
		tp.getTabs().addAll(t2);
		tp.getTabs().addAll(t3);
		tp.getTabs().addAll(t4);
		
		//create menu bar
		mstmb = new ModuleSelectionToolMenuBar();
		
		//add menu bar and tab pane to this root pane
		this.setTop(mstmb);
		this.setCenter(tp);
		
	}

	//methods allowing sub-containers to be accessed by the controller.
	public CreateStudentProfilePane getCreateStudentProfilePane() {
		return cspp;
	}
	public SelectModulesPane getSelecteModulesPane() {
		return smp;
	}
	public ReserveModulesPane getReserveModulesPane() {
		return rmp;
	}
	public OverviewSelectionPane getOverviewSelectionPane(){
		return osp;
	}
	
	public ModuleSelectionToolMenuBar getModuleSelectionToolMenuBar() {
		return mstmb;
	}
	
	//method to allow the controller to change tabs
	public void changeTab(int index) {
		tp.getSelectionModel().select(index);
	}
}
