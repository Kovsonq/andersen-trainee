package chatimplementation;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class Server {

    static final int PORT = 5000;
    private final ChatBot chatBot;
    private ServerSocket serverSocket = null;
    private Socket clientSocket = null;

    public Server(ChatBot chatBot){
        this.chatBot = chatBot;
    }

    public static void main(String[] args) {
        Server server = new Server(new ChatBot());
        server.go();
    }

    public void go(){
        try {
            // отслеживаем клиентские запросы на порту PORT
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server Up");

            while (true) {
                clientSocket = serverSocket.accept();

                new Thread(new ClientHandler(clientSocket)).start();
                System.out.println("Got a connection");

            }

        } catch (Exception exception){
            log.error("Server go method exception.");
        } finally {
            try {
                serverSocket.close();
                clientSocket.close();
            } catch (IOException ex) {
                log.error("Server threads closing exception.");
            }
        }
    }

    class ClientHandler implements Runnable{
        private BufferedReader reader;
        private PrintWriter writer;
        private Socket sock;

        public ClientHandler(Socket clientSocket){
            try {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
                writer = new PrintWriter(clientSocket.getOutputStream());
            } catch (Exception exception) {log.error("Client handler constructor exception.");}
        }

        public void run(){
            String message;
            try {
                while ((message = reader.readLine()) != null){
                    System.out.println("Client message: " + message);
                    String answer = chatBot.sayInReturn(message);
                    writer.println(answer);
                    writer.flush();
                }
            } catch (IOException e) {
                log.error("ClientHandler lost client connection.");
            } finally {
                try {
                    reader.close();
                    writer.close();
                    sock.close();
                } catch (IOException e) {
                    log.error("Client handler closing exception.");
                }
            }
        }

    }
}
