import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    private final int port;
    private final ExecutorService pool;
    public HttpServer(int port, int threads){
        this.port = port;
        this.pool = Executors.newFixedThreadPool(threads);
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Http server starting at " + port + " port");

        while(true){
            Socket socket = server.accept();
            pool.submit(()->serveClient(socket));
        }
    }
    public void serveClient(Socket socket){
        try (socket){

        }catch (IOException e){
            System.out.println("error: "+ e.getMessage());
        }
    }

}
