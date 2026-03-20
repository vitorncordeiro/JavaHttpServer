import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        Socket socket = serverSocket.accept();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        String requestLine = reader.readLine();
        String[] parts = requestLine.split(" ");
        String method = parts[0];
        String path = parts[1];
        String version = parts[2];

        Map<String, String> headers = new HashMap<>();
        String headerLine;
        while(!(headerLine = requestLine).isEmpty()){
            String[] kv = headerLine.split(": ", 2);
            headers.put(kv[0], kv[1]);
        }

        if(method.equals("POST")){
            int length = Integer.parseInt(headers.get("Content-Type"));
            InputStream inputStream = socket.getInputStream();

            byte[] body = new byte[length];

            int totalRead = 0;

            while(totalRead < length){
                int readed = inputStream.read(body, totalRead, length - totalRead);
                if(readed == -1) break;
                totalRead += readed;
            }

            String bodyStr = new String(body, StandardCharsets.UTF_8);
        }


        socket.close();
        serverSocket.close();
    }
}