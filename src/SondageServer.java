import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SondageServer {
    private static final int PORT = 8080;
    private static Map<String, Integer> answerCounts = new HashMap<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Serveur de sondage démarré sur le port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nouvelle connexion : " + clientSocket);

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);

                if (bytesRead > 0) {
                    String answer = new String(buffer, 0, bytesRead).trim();
                    synchronized (answerCounts) {
                        int count = answerCounts.getOrDefault(answer, 0);
                        answerCounts.put(answer, count + 1);
                    }
                }

                // Envoyer le nombre de clients pour chaque choix
                StringBuilder resultBuilder = new StringBuilder();
                synchronized (answerCounts) {
                    for (Map.Entry<String, Integer> entry : answerCounts.entrySet()) {
                        String answer = entry.getKey();
                        int count = entry.getValue();
                        resultBuilder.append(answer).append(": ").append(count).append("\n");
                    }
                }
                String result = resultBuilder.toString();
                outputStream.write(result.getBytes());

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

