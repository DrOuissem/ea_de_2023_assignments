import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class DistanceEducation extends Course{
    private String examProfessor ;

    private List<Date> webinarSessionDates = new ArrayList<>();

    public DistanceEducation() {
        super();
    }

    public DistanceEducation(Long id, String title, Date startDate, String professorName, String examProfessor) {
        super(id, title, startDate, professorName);
        this.examProfessor = examProfessor;
    }

    public void addWebinarSessionDate(Date date){
        this.webinarSessionDates.add(date);
    }

    public String getExamProfessor() {
        return examProfessor;
    }

    public void setExamProfessor(String examProfessor) {
        this.examProfessor = examProfessor;
    }

    @Override
    public String toString() {
        return "DistanceEducation{" +
                "examProfessor='" + examProfessor + '\'' +
                ", webinarSessionDates=" + webinarSessionDates +
                super.toString()+'}';
    }
}
