package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatClient {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private final Controller controller;

    public ChatClient(Controller controller) {
        this.controller = controller;
        openConnection();
    }

    public void openConnection() {
        try {
            socket = new Socket("localHost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        final String msgAuth = in.readUTF();
                        if (msgAuth.startsWith("/authok")) {
                            final String[] split = msgAuth.split(" ");
                            final String nick = split[1];
                            controller.addMessage("Успешная авторизация под ником " + nick);
                            controller.setAuth(true);
                            break;
                        }
                    }
                    while (true) {
                        final String messageFromServer = in.readUTF();
                        System.out.println("Получено сообщение: " + messageFromServer);
                        if ("/end".equalsIgnoreCase(messageFromServer)) {
                            controller.setAuth(false);
                            break;
                        }
                        controller.addMessage(messageFromServer);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    public void sendMessage(String message) {
        try {
            System.out.println("Отправлено сообщение: " + message);
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}