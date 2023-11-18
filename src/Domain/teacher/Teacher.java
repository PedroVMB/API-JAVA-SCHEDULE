package Domain.teacher;

public class Teacher {
    private int id;
    private String name;
    private String email;

    public Teacher( CreateTeacher createTeacher){
        this.id = createTeacher.id();
        this.name = createTeacher.name();
        this.email = createTeacher.email();
    }

    public Teacher(int id, String name, String email) {
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
