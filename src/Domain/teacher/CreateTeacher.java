package Domain.teacher;

public record CreateTeacher(int id, String name, String email) {
    public void setId(int generatedId) {
    }
}
