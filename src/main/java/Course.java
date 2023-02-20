import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String title;
    private Long capacity;
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

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(this.students);
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Course(Long id, String title, Long capacity) {
        this.id = id;
        this.title = title;
        this.capacity = capacity;
    }

    public Course() {

    }

    public Course( String title, Long capacity) {
        this.title = title;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
