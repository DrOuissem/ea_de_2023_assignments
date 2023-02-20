import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private float gpa;
    @ManyToOne()
    private Course course;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
        this.course.addStudent(this);
    }

    public Student(Long id, String name, float gpa, Course course) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.course = course;
        this.course.addStudent(this);
    }

    public Student() {
    }

    public Student(String name, float gpa, Course course) {
        this.name = name;
        this.gpa = gpa;
        this.course = course;
        this.course.addStudent(this);
    }
}
