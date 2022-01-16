import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 65002;
        ServerSocket serverSocket = new ServerSocket(port);
        try (Socket socket = serverSocket.accept();
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {

            int n = Integer.parseInt(reader.readLine());
            writer.printf("Эй, фермер через год у вас будет: %d кроликов xD", calculateFib(n));
        }

    }

    private static long calculateFib(int n) {
        //F(n) = 0, 1, F(n - 1) + F(n - 2) ...
        long[] longs = new long[n + 1];

        longs[0] = 0;
        longs[1] = 1;

        for (int i = 2; i <= n; i++) {
            longs[i] = longs[i - 1] + longs[i - 2];
        }
        return longs[n];
    }
}
