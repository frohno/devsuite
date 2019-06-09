/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.presentation.modules.dashboard;

import client.presentation.CommunicationHandler;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class DashboardFXMLController implements Initializable {

    @FXML
    private Text name;
    @FXML
    private JFXListView<NotificaitonEntry> notificationView;
    @FXML
    private JFXListView<TaskEntry> taskView;
    @FXML
    private AnchorPane calendarAnchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setText(CommunicationHandler.getInstance().getName());
        name.setFill(Color.BLACK);

        NotificaitonEntry[] notificationEntries = new NotificaitonEntry[]{
            new NotificaitonEntry(("Commit"), "John Lennon", "Fixed css error causing pink text", new Date()),
            new NotificaitonEntry(("Login"), "john", "Common login", new Date()),
            new NotificaitonEntry(("Login"), "john", "Common login", new Date()),
            new NotificaitonEntry(("Login"), "john", "Common login", new Date()),
            new NotificaitonEntry(("Login"), "john", "Common login", new Date()),
            new NotificaitonEntry(("Login"), "john", "Common login", new Date()),
            new NotificaitonEntry(("Login"), "john", "Common login", new Date())};

        notificationView.getItems().addAll(notificationEntries);

        TaskEntry[] taskEntries = new TaskEntry[]{
            new TaskEntry(("Graphics"), "Sprint 1", "Fix css error causing pink text", new Date()),
            new TaskEntry(("Persistance"), "Sprint 1", "Update passwords to fit new hashing algorithm", new Date()),
            new TaskEntry(("Graphics"), "Sprint 2", "Fix css error causing pink text", new Date()),
            new TaskEntry(("Graphics"), "Sprint 2", "Fix css error causing pink text", new Date()),
            new TaskEntry(("Graphics"), "Sprint 2", "Fix css error causing pink text", new Date()),
            new TaskEntry(("Graphics"), "Sprint 4", "Fix css error causing pink text", new Date()),};

        taskView.getItems().addAll(taskEntries);

        notificationView.setOnMouseClicked((MouseEvent event) -> {
            try {
                notificationView.getSelectionModel().getSelectedItem().showPopup();
            } catch (NullPointerException e) {
            }
        });
    }

}
