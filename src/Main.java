import Controller.ClassroomController;
import Controller.DisciplineController;
import Controller.tests.MyHandler;
import Controller.tests.SecondHandler;
import Service.ClassroomService;
import Service.DisciplineService;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.io.IOException;
import Controller.TeacherController;
import Service.TeacherService;

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


        server.setExecutor(null);
        server.start();
        System.out.println("Servidor HTTP iniciado na porta 3000");
    }
}
