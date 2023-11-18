package Domain.discipline;

public class Discipline {
    private int id;

    private String name;

    public Discipline(CreateDiscipline createDiscipline){
        this.name = createDiscipline.name();
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
