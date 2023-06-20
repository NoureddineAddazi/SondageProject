import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SondageClient {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Connecté au serveur de sondage");

            // Afficher les choix possibles
            System.out.println("*****Rattrapage sera:*****");
            System.out.println("1. Demain");
            System.out.println("2. Lundi prochain");
            System.out.println("3. Mardi prochain");
            System.out.println("Choisir un choix :");

            // Lire la réponse choisie par le client
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            String answer;
            switch (choice) {
                case 1:
                    answer = "Demain";
                    break;
                case 2:
                    answer = "Lundi prochain";
                    break;
                case 3:
                    answer = "Mardi prochain";
                    break;
                default:
                    System.out.println("Choix invalide.");
                    socket.close();
                    return;
            }

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(answer.getBytes());

            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);

            if (bytesRead > 0) {
                String result = new String(buffer, 0, bytesRead);
                System.out.println("Résultat du sondage :\n" + result);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
