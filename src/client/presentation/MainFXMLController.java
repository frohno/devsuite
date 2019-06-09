/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.presentation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class MainFXMLController implements Initializable {

    @FXML
    private SubScene subScene;
    @FXML
    private VBox solutionMenu;
    @FXML
    private VBox planningMenu;
    @FXML
    private VBox menu;
    @FXML
    private Button buttonDashboardLabel;
    @FXML
    private Button buttonPlanningLabel;
    @FXML
    private Button buttonSolutionLabel;
    @FXML
    private Button buttonDashboard;
    @FXML
    private Button buttonPlanning;
    @FXML
    private Button buttonSolution;
    @FXML
    private Button buttonRepositoryLabel;
    @FXML
    private Button buttonUMLLabel;
    @FXML
    private Button buttonRepository;
    @FXML
    private Button buttonUML;
    @FXML
    private Button buttonRoadmapLabel;
    @FXML
    private Button buttonBoardLabel;
    @FXML
    private Button buttonBacklogLabel;
    @FXML
    private Button buttonCalendarLabel;
    @FXML
    private Button buttonTimetrackingLabel;
    @FXML
    private Button buttonRoadmap;
    @FXML
    private Button buttonBoard;
    @FXML
    private Button buttonBacklog;
    @FXML
    private Button buttonCalendar;
    @FXML
    private Button buttonTimetracking;

    private TranslateTransition menuTranslation;
    private TranslateTransition planningMenuTranslation;
    private TranslateTransition solutionMenuTranslation;

    private VBox currentlyOpenSubmenu;

    private Initializable lastModuleController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Side-menu
        menu.prefHeightProperty().bind(((AnchorPane) menu.getParent()).heightProperty());
        subScene.heightProperty().bind(menu.heightProperty());
        ((AnchorPane) subScene.getParent()).widthProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                subScene.setWidth((double) newValue - 60);
            }
        });
        menuTranslation = new TranslateTransition(Duration.millis(500), menu);
        planningMenuTranslation = new TranslateTransition(Duration.millis(500), planningMenu);
        solutionMenuTranslation = new TranslateTransition(Duration.millis(500), solutionMenu);

        menuTranslation.setFromX(-140);
        menuTranslation.setToX(0);
        menu.setOnMouseEntered(evt -> {
            menuTranslation.setRate(1);
            menuTranslation.play();
        });
        menu.setOnMouseExited(evt -> {
            menuTranslation.setRate(-1);
            menuTranslation.play();
        });

        planningMenuTranslation.setFromX(-140);
        planningMenuTranslation.setToX(60);
        planningMenu.setOnMouseExited(evt -> {
            planningMenuTranslation.setRate(-1);
            planningMenuTranslation.play();
            currentlyOpenSubmenu = null;

        });

        solutionMenuTranslation.setFromX(-140);
        solutionMenuTranslation.setToX(60);
        solutionMenu.setOnMouseExited(evt -> {
            solutionMenuTranslation.setRate(-1);
            solutionMenuTranslation.play();
            currentlyOpenSubmenu = null;
        });

        buttonDashboard.setOnAction((e) -> loadSubScene("modules/dashboard/DashboardFXML.fxml"));
        buttonPlanning.setOnMouseEntered((e) -> openPlanningSubmenu());
        buttonSolution.setOnMouseEntered((e) -> openSolutionSubmenu());
        buttonRepository.setOnAction((e) -> loadSubScene("modules/solution/repository/RepositoryFXML.fxml"));
        buttonDashboardLabel.setOnAction((e) -> loadSubScene("modules/dashboard/DashboardFXML.fxml"));
        buttonPlanningLabel.setOnMouseEntered((e) -> openPlanningSubmenu());
        buttonSolutionLabel.setOnMouseEntered((e) -> openSolutionSubmenu());
        buttonRepositoryLabel.setOnAction((e) -> loadSubScene("modules/solution/repository/RepositoryFXML.fxml"));

        buttonDashboard.setOnMouseEntered((e) -> {
            if (currentlyOpenSubmenu == planningMenu) {
                planningMenuTranslation.setRate(-1);
                planningMenuTranslation.play();
            } else if (currentlyOpenSubmenu == solutionMenu) {
                solutionMenuTranslation.setRate(-1);
                solutionMenuTranslation.play();
            }
            currentlyOpenSubmenu = null;
        });
        buttonDashboardLabel.setOnMouseEntered((e) -> {
            if (currentlyOpenSubmenu == planningMenu) {
                planningMenuTranslation.setRate(-1);
                planningMenuTranslation.play();
            } else if (currentlyOpenSubmenu == solutionMenu) {
                solutionMenuTranslation.setRate(-1);
                solutionMenuTranslation.play();
            }
            currentlyOpenSubmenu = null;
        });
        loadSubScene("modules/dashboard/DashboardFXML.fxml");
    }

    public void loadSubScene(String path) {
        if (currentlyOpenSubmenu == planningMenu) {
            planningMenuTranslation.setRate(-1);
            planningMenuTranslation.play();
        } else if (currentlyOpenSubmenu == solutionMenu) {
            solutionMenuTranslation.setRate(-1);
            solutionMenuTranslation.play();
        }
        currentlyOpenSubmenu = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent root = loader.load();
            Initializable i = loader.getController();
            if (i.getClass().isInstance(lastModuleController)) {
                return;
            }
            lastModuleController = i;
            subScene.setRoot(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void openPlanningSubmenu() {
        planningMenu.setVisible(true);
        if (currentlyOpenSubmenu == planningMenu) {
            return;
        }
        if (currentlyOpenSubmenu == solutionMenu) {
            solutionMenuTranslation.setRate(-1);
            solutionMenuTranslation.play();
        }
        currentlyOpenSubmenu = planningMenu;
        planningMenuTranslation.setRate(1);
        planningMenuTranslation.play();
    }

    private void openSolutionSubmenu() {
        solutionMenu.setVisible(true);
        if (currentlyOpenSubmenu == solutionMenu) {
            return;
        }
        if (currentlyOpenSubmenu == planningMenu) {
            planningMenuTranslation.setRate(-1);
            planningMenuTranslation.play();
        }
        currentlyOpenSubmenu = solutionMenu;
        solutionMenuTranslation.setRate(1);
        solutionMenuTranslation.play();
    }
}
