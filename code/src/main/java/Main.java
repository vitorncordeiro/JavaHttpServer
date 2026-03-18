import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Selecione uma porta para inicializar o servidor: ");
        int port = scanner.nextInt();
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server ouvindo na porta " + port);

        Socket socket = serverSocket.accept();

        BufferedReader entrada = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
        PrintWriter saida = new PrintWriter(
                socket.getOutputStream(), true);

        String linha;
        while((linha = entrada.readLine()) != null){
            System.out.println("in: " + linha);
            saida.println(scanner.nextLine());
        }

        socket.close();
        serverSocket.close();
    }
}