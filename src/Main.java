import Controller.tests.MyHandler;
import Controller.tests.SecondHandler;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.io.IOException;
import Controller.TeacherController;
import Service.TeacherService;

public class Main {
    public static void main(String[] args) throws IOException {
        TeacherService teacherService = new TeacherService();
        TeacherController teacherController = new TeacherController(teacherService);

        HttpServer server = HttpServer.create(new InetSocketAddress(3000), 0);
        server.createContext("/api", new MyHandler());
        server.createContext("/api/teste", new SecondHandler());

        server.createContext("/api/teachers", teacherController);
        server.setExecutor(null);
        server.start();
        System.out.println("Servidor HTTP iniciado na porta 3000");
    }
}
