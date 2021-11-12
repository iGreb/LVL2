package sample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) {
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен. Ожидаем подключения клиента...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            final DataInputStream in = new DataInputStream(socket.getInputStream());
            final DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            new Thread(new ClientHandler(socket)).start();
            while (true) {
                final String message = in.readUTF();
                System.out.println("Сообщение от клиента: " + message);
                if (message.startsWith("/end")) {
                    out.writeUTF("/end");
                    break;
                }
                out.writeUTF("Эхо: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ClientHandler implements Runnable {
        private Scanner in;
        private PrintWriter out;
        private Socket socket;
        private String name;

        public ClientHandler(Socket clientSocket) {
            try {
                this.socket = clientSocket;
                in = new Scanner(socket.getInputStream());
                out = new PrintWriter(socket.getOutputStream());
                name = "Client";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {
                if (in.hasNextInt()) {
                    String w = in.nextLine();
                    System.out.println(name + ": " + w);
                    out.println("Эхо: " + w);
                    out.flush();
                    if (w.equalsIgnoreCase("/end")) {
                        break;
                    }
                }
            }
            try {
                System.out.println("Клиент отключился");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
