package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField messageField;

    @FXML
    private TextArea messageArea;

    public void clickSendButton(ActionEvent actionEvent) {
        final String message = messageField.getText();
        if(message.isEmpty()) {
            return;
        }
        messageArea.appendText(message + "\n");
        messageField.setText("");
        messageField.requestFocus();
    }

    public void menuExitSelect(ActionEvent actionEvent) {
        System.exit(0);
    }
}
