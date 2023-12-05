import Controller.ClassroomController;
import Controller.DisciplineController;
import Service.ClassroomService;
import Service.DisciplineService;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.io.IOException;
import Controller.TeacherController;
import Service.TeacherService;

import com.sun.net.httpserver.*;

public class Main {
    public static void main(String[] args) throws IOException {
        TeacherService teacherService = new TeacherService();
        TeacherController teacherController = new TeacherController(teacherService);

        DisciplineService disciplineService = new DisciplineService();
        DisciplineController disciplineController = new DisciplineController(disciplineService);

        ClassroomService classroomService = new ClassroomService();
        ClassroomController classroomController = new ClassroomController(classroomService);

        HttpServer server = HttpServer.create(new InetSocketAddress(3000), 0);

        server.createContext("/api/teachers", teacherController);
        server.createContext("/api/disciplines", disciplineController);
        server.createContext("/api/classrooms", classroomController);


        server.createContext("/", exchange -> {
            Headers headers = exchange.getResponseHeaders();
            headers.set("Access-Control-Allow-Origin", "*");
            headers.set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            headers.set("Access-Control-Allow-Headers", "Content-Type");
            headers.set("Access-Control-Max-Age", "3600");


            if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }


            exchange.getHttpContext().getHandler().handle(exchange);
        });

        server.setExecutor(null);
        server.start();
        System.out.println("Servidor HTTP iniciado na porta 3000");
    }
}
