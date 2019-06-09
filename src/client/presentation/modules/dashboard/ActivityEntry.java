/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class ActivityEntry {

    private final String typeOfEntry;
    private final String dateOfEntryString;
    private final String specificsOfEntry;

    public ActivityEntry(String typeOfEntry, Date dateOfEntry, String specificsOfEntry) {
        this.typeOfEntry = typeOfEntry;
        this.dateOfEntryString = String.format("%1$" + 2 + "s", dateOfEntry.getHours()).replace(' ', '0') + ":"
                + String.format("%1$" + 2 + "s", dateOfEntry.getMinutes()).replace(' ', '0') + ":"
                + String.format("%1$" + 2 + "s", dateOfEntry.getSeconds()).replace(' ', '0') + " "
                + String.format("%1$" + 2 + "s", dateOfEntry.getDate()).replace(' ', '0') + "/"
                + String.format("%1$" + 2 + "s", dateOfEntry.getMonth()).replace(' ', '0') + "/"
                + (dateOfEntry.getYear() + 1900);
        this.specificsOfEntry = specificsOfEntry;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(specificsOfEntry);
        int i = 0;
        while (i + 23 < sb.length() && (i = sb.lastIndexOf(" ", i + 23)) != -1) {
            sb.replace(i, i + 1, "\n");
        }
        return getBoldString(typeOfEntry) + "\n" + sb.toString() + "\n" + dateOfEntryString;
    }

    public void showPopup() {
        Platform.runLater(()
        -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ActivityEntryPopupFXML.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                ActivityEntryPopupFXMLController controller = fxmlLoader.<ActivityEntryPopupFXMLController>getController();
                controller.setData(typeOfEntry, specificsOfEntry, "Query: ladidada", dateOfEntryString, "IP: 10.201.271.28");
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {}
        });
    }
}
