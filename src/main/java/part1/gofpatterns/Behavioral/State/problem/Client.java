package part1.gofpatterns.Behavioral.State.problem;

/**
 * for removing if-else statements we can apply State pattern
 * we have to capture relative behavior into specific state objects
 */
public class Client {
    public static void main(String[] args) throws Exception{
        TCPConnection connection = new TCPConnection();

        connection.open();

        connection.acknowledge();
        connection.close();
        connection.acknowledge();
    }
}
