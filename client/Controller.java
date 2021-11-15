package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Controller {
    @FXML
    private HBox messageBox;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField loginField;
    @FXML
    private HBox loginBox;
    @FXML
    private TextField messageField;
    @FXML
    private TextArea messageArea;

    private final ChatClient client;

    public Controller() {
        client = new ChatClient(this);
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

    public void addMessage(String message) {
        messageArea.appendText(message + "\n");
    }

    public void clickAuthButton(ActionEvent event) {
        client.sendMessage("/auth " + loginField.getText() + " " + passwordField.getText());
    }

    public void setAuth(boolean success) {
        loginBox.setVisible(!success);
        messageBox.setVisible(success);
        messageArea.setVisible(success);
    }
}