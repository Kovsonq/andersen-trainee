package chatimplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    static final int PORT = 5000;
    private BufferedReader reader;
    private PrintWriter writer;
    private Socket sock;

    public static void main(String[] args) {
        new Client().go();
    }

    public void go(){
        try {
            // создаем соединение через сокет к прилаге на порту 4242
            // на том же компе, где выполняется данный код
            sock = new Socket("127.0.0.1", PORT);

            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("Connected.\nType 'exit' for closing this connection.");

            Thread readerThread = new Thread(new IncomingReader());
            readerThread.start();

            while (true){
                Scanner scanner = new Scanner(System.in);
                Thread.sleep(100);
                System.out.print("Your message: ");
                String message = scanner.nextLine();
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.println(message);
                writer.flush();
            }

            System.out.println("Your are disconnected.");
            System.exit(0);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
                sock.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class IncomingReader implements Runnable{
        public void run(){
            String message;
            try {
                while ((message = reader.readLine()) != null){
                    System.out.println("Server's answer: " + message);
                }
            } catch (Exception e) {e.printStackTrace();}
        }
    }


}
