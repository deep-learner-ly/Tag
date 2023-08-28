package basics.socket;

/**
 * @author LongyunBian
 * @version 2023/8/24 17:26
 */
import java.io.*;
import java.net.*;

public class ClientDemo {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int port = 12345;

        try (Socket socket = new Socket(serverAddress, port)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String messageToSend = "Hello, server!";
            writer.println(messageToSend);

            String serverResponse = reader.readLine();
            System.out.println("Received from server: " + serverResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
