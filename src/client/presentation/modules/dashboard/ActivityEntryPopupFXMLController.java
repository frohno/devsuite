/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.presentation.modules.dashboard;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class ActivityEntryPopupFXMLController implements Initializable {

    @FXML
    private FontAwesomeIconView cross;
    @FXML
    private Label title;
    @FXML
    private Label description;
    @FXML
    private Label query;
    @FXML
    private Label date;
    @FXML
    private Label ip;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void close(MouseEvent event) {
        ((Stage) cross.getScene().getWindow()).close();
    }

    public void setData(String titleString, String descriptionString, String queryString, String dateString, String ipString) {
        title.setText(titleString);
        description.setText(descriptionString);
        query.setText(queryString);
        date.setText(dateString);
        ip.setText(ipString);
    }

}
