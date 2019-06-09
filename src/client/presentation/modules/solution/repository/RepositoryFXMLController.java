/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package client.presentation.modules.solution.repository;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class RepositoryFXMLController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    private WebView webView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        webView = new WebView();
        anchorPane.getChildren().add(webView);
        webView.getEngine().load("https://www.github.com");
    }

}
