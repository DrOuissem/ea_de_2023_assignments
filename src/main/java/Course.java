import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="courseType")
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String title;
    private Date startDate;
    private String professorName;

    @OneToMany()
    private List<Student> students = new ArrayList<Student>();
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void addStudent(Student s){
        this.students.add(s);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public List<Student> getStudents() {
        return new ArrayList<>(this.students);
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }



    public Course() {

    }

    public Course(Long id, String title, Date startDate, String professorName){
        this.id=id;
        this.title=title;
        this.professorName=professorName;
        this.startDate=startDate;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", professor=" + this.professorName +
                '}';
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }
}
