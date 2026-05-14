import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static final int PORT = 8100;
    private boolean running = true;

    public GameServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (running) {
                System.out.println("astept un client...");
                Socket socket = serverSocket.accept();

                new ClientThread(socket, this).start();
            }
        } catch (IOException e) {
            System.err.println("eroare la server: " + e.getMessage());
        }
    }

    public void stopServer() {
        this.running = false;
    }

    public static void main(String[] args) {
        GameServer server = new GameServer();
    }
}