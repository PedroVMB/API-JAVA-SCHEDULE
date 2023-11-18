import Controller.tests.MyHandler;
import Controller.tests.SecondHandler;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(3001), 0);
        server.createContext("/api", new MyHandler());
        server.createContext("/api/teste", new SecondHandler());
        server.setExecutor(null); // Use o executor padrão
        server.start();
    }
}
