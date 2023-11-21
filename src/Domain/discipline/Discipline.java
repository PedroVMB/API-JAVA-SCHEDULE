package Domain.discipline;

public class Discipline {
    private int id;

    private String name;

    public Discipline(CreateDiscipline createDiscipline){
        this.id = createDiscipline.id();
        this.name = createDiscipline.name();
    }

    public Discipline(int id, String name){

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
}
