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

    private final EchoClient client;

    public Controller() {
        client = new EchoClient(this);
    }

    public void clickSendButton(ActionEvent event) {
        final String message = messageField.getText().trim();
        if (message.isEmpty()) {
            return;
        }
        client.sendMessage(message);
        messageField.clear();
        messageField.requestFocus();
    }

    public void menuExitSelect(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void addMessage(String messageFromServer) {
        messageArea.appendText(messageFromServer + "\n");
    }
}