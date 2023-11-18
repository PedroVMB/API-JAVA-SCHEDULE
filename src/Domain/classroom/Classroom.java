package Domain.classroom;

import Domain.enums.Days;
import Domain.enums.Shift;

public class Classroom {
    private int id;
    private Days daysOfWeek;
    private Shift shift;
    private String schedule;
    private final int teacherId;
    private final int disciplineId;


    public Classroom(CreateClassroom create) {
        this.daysOfWeek = create.daysOfWeek();
        this.shift = create.shift();
        this.schedule = create.schedule();
        this.teacherId = create.teacher().getId();
        this.disciplineId = create.discipline().getId();
    }

    public int getId() {
        return id;
    }

    public Days getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(Days daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getTeacher() {
        return teacherId;
    }


    public int getDiscipline() {
        return disciplineId;
    }


}
