/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package client.presentation.modules.dashboard;

import static client.presentation.utils.StringUtils.getBoldString;
import java.io.IOException;
import java.util.Date;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Oliver
 */
public class TaskEntry {

    private final String subject;
    private final String sender;
    private final String message;
    private final String sentDateString;

    public TaskEntry(String subject, String sender, String message, Date sentDate) {
        this.subject = subject;
        this.sender = sender;
        this.message = message;
        this.sentDateString = String.format("%1$" + 2 + "s", sentDate.getHours()).replace(' ', '0') + ":"
                + String.format("%1$" + 2 + "s", sentDate.getMinutes()).replace(' ', '0') + ":"
                + String.format("%1$" + 2 + "s", sentDate.getSeconds()).replace(' ', '0') + " "
                + String.format("%1$" + 2 + "s", sentDate.getDate()).replace(' ', '0') + "/"
                + String.format("%1$" + 2 + "s", sentDate.getMonth()).replace(' ', '0') + "/"
                + (sentDate.getYear() + 1900);
    }

    @Override
    public String toString() {
        return getBoldString(sender) + ": " + subject + "\n" + message + "\n" + sentDateString;
    }

    public void showPopup() {
        //TODO don't show popup, but jump to sprintboard focus on this Task
        Platform.runLater(()
                -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MessageEntryPopupFXML.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                MessageEntryPopupFXMLController controller = fxmlLoader.<MessageEntryPopupFXMLController>getController();
                controller.setData(sender + ": " + subject, message, sentDateString);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
            }
        });
    }
}
