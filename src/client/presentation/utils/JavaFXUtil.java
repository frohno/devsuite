/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.presentation.utils;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Oliver
 */
public class JavaFXUtil {

    /**
     * @param gridPane
     * @param col
     * @param row
     * @return Node at col and row value in gridPane
     */
    public static Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
}
