package view;

import java.util.List; 
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Module;
import model.Schedule;
import model.StudentProfile;

public class ReserveModulesPane extends VBox {

    private ListView<Module> Term1UM;
    private ListView<Module> Term2UM;
    private ListView<Module> Term1RM;
    private ListView<Module> Term2RM;
    private final Button addT1;
    private final Button addT2;
    private final Button removeT1;
    private final Button removeT2;
    private final Button T1Confirm;
    private final Button T2Confirm;

    Accordion acc;
    TitledPane t1;
    TitledPane t2;

    public ReserveModulesPane() {
        //styling
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);

        Label T1UM = new Label("Unselected Term 1 modules");
        Label T2UM = new Label("Unselected Term 2 modules");
        Label T1RM = new Label("Reserved Term 1 modules");
        Label T2RM = new Label("Reserved Term 2 modules");
        Label Term1Credits = new Label("Reserve 30 credits worth of term 1 modules");
        Label Term2Credits = new Label("Reserve 30 credits worth of term 2 modules");

        //initialise ListViews
       Term1UM = new ListView<>();
       Term2UM = new ListView<>();
       Term1RM= new ListView<>();
       Term2RM = new ListView<>();

        addT1 = new Button("Add");
        addT1.setPrefWidth(65);
        addT2 = new Button("Add");
        addT2.setPrefWidth(65);
        removeT1 = new Button("Remove");
        removeT1.setPrefWidth(65);
        removeT2 = new Button("Remove");
        removeT2.setPrefWidth(65);
        T1Confirm = new Button("Confirm");
        T1Confirm.setPrefWidth(65);
        T2Confirm = new Button("Confirm");
        T2Confirm.setPrefWidth(65);

        VBox t1UVB = new VBox();
        t1UVB.getChildren().addAll(T1UM, Term1UM);

        VBox t1RVB = new VBox();
        t1RVB.getChildren().addAll(T1RM,Term1RM);

        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(t1UVB, t1RVB);

        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(Term1Credits, addT1, removeT1, T1Confirm);

        VBox t1MainVB = new VBox(hbox1, hbox2);
        t1MainVB.setSpacing(10);
        t1MainVB.setPadding(new Insets(20));

        t1 = new TitledPane("Term 1 Modules", t1MainVB);

        VBox t2UVB = new VBox(T2UM, Term2UM);
        VBox t2RVB = new VBox(T2RM, Term2RM);

        HBox hbox3 = new HBox();
        hbox3.getChildren().addAll(t2UVB, t2RVB);

        HBox hbox4 = new HBox();
        hbox4.getChildren().addAll(Term2Credits, addT2, removeT2, T2Confirm);

        VBox t2MainVB = new VBox();
        t2MainVB.getChildren().addAll(hbox3, hbox4);

        t2 = new TitledPane("Term 2 Modules", t2MainVB);

        acc = new Accordion();
        acc.getPanes().addAll(t1, t2);
        acc.setExpandedPane(t1);
        this.getChildren().addAll(acc);

        addT1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Module selectedItem = Term1UM.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    Term1RM.getItems().add(selectedItem);
                    Term2UM.getItems().remove(selectedItem);
                }
            }
        });
        addT2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Module selectedItem = Term2UM.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                	Term2RM.getItems().add(selectedItem);
                    Term2UM.getItems().remove(selectedItem);
                }
            }
        });
        removeT1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Module selectedItem = Term1RM.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    Term1UM.getItems().add(selectedItem);
                    Term1RM.getItems().remove(selectedItem);
                }
            }
        });
        removeT2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Module selectedItem = Term2RM.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    Term1UM.getItems().add(selectedItem);
                    Term2RM.getItems().remove(selectedItem);
                }
            }
        });

        t1UVB.prefWidthProperty().bind(this.widthProperty());
        t1UVB.prefHeightProperty().bind(this.heightProperty());
        t1RVB.prefWidthProperty().bind(this.widthProperty());
        t1RVB.prefHeightProperty().bind(this.heightProperty());
        t2UVB.prefWidthProperty().bind(this.widthProperty());
        t2UVB.prefHeightProperty().bind(this.heightProperty());
        t2RVB.prefWidthProperty().bind(this.widthProperty());
        t2RVB.prefHeightProperty().bind(this.heightProperty());
        hbox1.setSpacing(5);
        hbox1.setAlignment(Pos.CENTER);
        hbox2.setSpacing(5);
        hbox2.setAlignment(Pos.CENTER);
        hbox3.setSpacing(5);
        hbox3.setAlignment(Pos.CENTER);
        hbox4.setSpacing(5);
        hbox4.setAlignment(Pos.CENTER);
        t2MainVB.setSpacing(10);
        t2MainVB.setPadding(new Insets(20));

    }

    public void addT1UMods(List<Module> unSelectedT1) {

        Term1UM.getItems().clear();
        Term1RM.getItems().clear();
        unSelectedT1.forEach((module) -> {
            Term1UM.getItems().add(module);
        });
    }

    public void addT2UMods(List<Module> unSelectedT2) {
    	Term2UM.getItems().clear();
    	Term2RM.getItems().clear();
        unSelectedT2.forEach((module) -> {
        	Term2UM.getItems().add(module);
        });
    }

    public void addbtnConfirmHandler(EventHandler<ActionEvent> handler) {
        T1Confirm.setOnAction(handler);
    }

    public void addbtn2ConfirmHandler(EventHandler<ActionEvent> handler) {
        T2Confirm.setOnAction(handler);
    }

    public List<Module> getReservedTerm1() {
        return Term1RM.getItems();
    }

    public List<Module> getReservedTerm2() {
        return Term2RM.getItems();
    }

    public void changePane() {
    	acc.setExpandedPane(t2);
    }
    public void loadReservedModules(StudentProfile profile) {

        Set<Module> reservedModules
                = profile.getAllReservedModules();

        for (Module r : reservedModules) {

            if (r.getDelivery() == Schedule.TERM_1) {

                Term1RM.getItems().add(r);
                Term1UM.getItems().remove(r);
            } else if (r.getDelivery() == Schedule.TERM_2) {

                Term2RM.getItems().add(r);
                Term2UM.getItems().remove(r);

            }

        }

    }

}


