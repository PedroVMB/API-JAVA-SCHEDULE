import Controller.ClassroomController;
import Controller.DisciplineController;
import Controller.TeacherController;
import Service.ClassroomService;
import Service.DisciplineService;
import Service.TeacherService;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        TeacherService teacherService = new TeacherService();
        TeacherController teacherController = new TeacherController(teacherService);

        DisciplineService disciplineService = new DisciplineService();
        DisciplineController disciplineController = new DisciplineController(disciplineService);

        ClassroomService classroomService = new ClassroomService();
        ClassroomController classroomController = new ClassroomController(classroomService);

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(3000), 0);

            // Contexto padrão para cabeçalhos CORS
            server.createContext("/", exchange -> {
                System.out.println("Recebida requisição para o contexto padrão (/)");
                // Restante do código de configuração do CORS...
            });

            // Contexto para /api/teachers
            server.createContext("/api/teachers", teacherController);

            // Contexto para /api/disciplines
            server.createContext("/api/disciplines", disciplineController);

            // Contexto para /api/classrooms
            server.createContext("/api/classrooms", classroomController);

            server.setExecutor(Executors.newFixedThreadPool(10));
            server.start();

            System.out.println("Servidor HTTP iniciado na porta 3000");
        } catch (IOException e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
