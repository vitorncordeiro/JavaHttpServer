import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main{
    static AtomicInteger totalRequisitions = new AtomicInteger(0);
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        ExecutorService pool = Executors.newFixedThreadPool(10);

        System.out.println("Http server listing at " + serverSocket.getLocalPort() + " port");

        while(true){
            Socket socket = serverSocket.accept();
            pool.submit(() -> serveClient(socket));
        }
    }
    static void serveClient(Socket socket){
        int req = totalRequisitions.incrementAndGet();
        System.out.println("Requistion #" + req + " - thread:"
            + Thread.currentThread().getName());
        try(socket){

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}