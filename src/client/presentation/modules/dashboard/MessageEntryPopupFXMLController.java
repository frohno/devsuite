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
public class MessageEntryPopupFXMLController implements Initializable {

    @FXML
    private FontAwesomeIconView cross;
    @FXML
    private Label title;
    @FXML
    private Label message;
    @FXML
    private Label date;

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

    public void setData(String titleString, String messageString, String dateString) {
        title.setText(titleString);
        message.setText(messageString);
        date.setText(dateString);
    }
    
}
