package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
                joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name="course_id")
    )
    private List<Course> courses;

    public Student(){}

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course c){
        this.getCourses().add(c);
        c.getStudents().add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
