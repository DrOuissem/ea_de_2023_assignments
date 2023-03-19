import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name="Student.CanGraduate",
        query="SELECT s FROM Student s WHERE s.gpa > 3.0 and SIZE(s.coursesAttended)>8 and s.courseAttending=null")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private float gpa;
    @ManyToOne(cascade = CascadeType.ALL)
    private Course courseAttending;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> coursesAttended=new ArrayList<Course>();

    public void addCourseAttended(Course c){
        this.coursesAttended.add(c);
    }
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

    public Course getCourseAttending() {
        return courseAttending;
    }

    public void setCourseAttending(Course course) {
        this.courseAttending = course;
        this.courseAttending.addStudent(this);
    }

    public Student(Long id, String name, float gpa, Course course) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.courseAttending = course;
        if(this.courseAttending!=null)
        this.courseAttending.addStudent(this);
    }

    public Student() {
    }

    public Student(String name, float gpa, Course course) {
        this.name = name;
        this.gpa = gpa;
        this.courseAttending = course;
        if(this.courseAttending!=null)
        this.courseAttending.addStudent(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                ", courseAttending=" + courseAttending +
                ", coursesAttended=" + coursesAttended +
                '}';
    }
}
