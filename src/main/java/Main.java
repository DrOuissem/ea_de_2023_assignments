import jakarta.persistence.*;
import jakarta.persistence.criteria.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Main {
 public static void main(String [] args){
     System.out.println("start");
     EntityManagerFactory emf= Persistence.createEntityManagerFactory("default");
     EntityManager em = emf.createEntityManager();

     EntityTransaction tx=em.getTransaction();
     Car car1 = new Car("toyota","yaris",100L);
     Car car2 = new Car("toyota","Camry",50L);
     Person person1 = new Person("ahmed",car1);
     Person person2 = new Person("Jhonny",car2);

     OnCampus c1 = new OnCampus(1L, "course1", new Date(2023,5,1),"Najeeb",31L,"VH220");
     OnCampus c2 = new OnCampus(2L, "course2", new Date(2023,3,1),"tony",35L,"VH320");
     OnCampus c3 = new OnCampus(3L, "course3", new Date(2023,1,1),"Momo",25L,"VH240");
     OnCampus c4 = new OnCampus(4L, "course4", new Date(2023,5,1),"Meriam",25L,"VH240");
     OnCampus c5 = new OnCampus(5L, "course5", new Date(2023,6,1),"Najeeb",25L,"VH240");
     OnCampus c6 = new OnCampus(6L, "course6", new Date(2023,7,1),"tony",25L,"VH240");
     OnCampus c7 = new OnCampus(7L, "course7", new Date(2023,12,1),"Jhon",25L,"VH240");

     DistanceEducation c8 = new DistanceEducation(8L, "course8", new Date(2023,5,1),"Jane","Jhon");
     DistanceEducation c9 = new DistanceEducation(9L, "course9", new Date(2023,5,1),"Khalid","Jhon");
     DistanceEducation c10 = new DistanceEducation(10L, "course10", new Date(2023,5,1),"Najeeb","Jhon");
     DistanceEducation c11 = new DistanceEducation(11L, "course11", new Date(2023,12,1),"Najeeb","Jhon");
     DistanceEducation c12 = new DistanceEducation(12L, "course12", new Date(2023,5,1),"Josh","Jhon");
     DistanceEducation c13 = new DistanceEducation(13L, "course13", new Date(2023,5,1),"Jimmy","Jhon");

     c10.addWebinarSessionDate(new Date(2023,5,1));
     c10.addWebinarSessionDate(new Date(2023,5,15));
     c11.addWebinarSessionDate(new Date(2023,6,1));

     c12.addWebinarSessionDate(new Date(2023,6,10));
     c12.addWebinarSessionDate(new Date(2023,6,25));
     c11.addWebinarSessionDate(new Date(2023,7,10));

    //System.out.println(c5);


     Student s1 = new Student (1L,"Jhon", 3.6f, c1);
     Student s2 = new Student (2L,"Jhonny", 3.7f, c2);
     Student s3 = new Student (3L,"Ahmad", 3.5f, c4);
     Student s4 = new Student (4L,"Jim", 3.4f, c3);
     Student s5 = new Student (5L,"Jim", 3.4f, null);
     Student s6 = new Student (6L,"Jim", 3.4f, null);
     Student s7 = new Student (7L,"Jim", 3.4f, c3);
     Student s8 = new Student (8L,"Jim", 3.4f, c3);
     s5.addCourseAttended(c1);
     s5.addCourseAttended(c2);
     s5.addCourseAttended(c3);
     s5.addCourseAttended(c4);
     s5.addCourseAttended(c5);
     s5.addCourseAttended(c6);
     s5.addCourseAttended(c7);  
     s5.addCourseAttended(c8);
     s5.addCourseAttended(c9);


     tx.begin();
     em.persist(c1);
     em.persist(c2);
     em.persist(c3);
     em.persist(c4);
     em.persist(c5);
     em.persist(c6);
     em.persist(c7);
     em.persist(c8);
     em.persist(c9);
     em.persist(c10);
     em.persist(c11);
     em.persist(c12);
     em.persist(c13);

     em.persist(s1);
     em.persist(s2);
     em.persist(s3);
     em.persist(s4);
     em.persist(s5);
     em.persist(s6);
     em.persist(s7);
     em.persist(s8);

     em.persist(person1);
     em.persist(person2);
     em.persist(car1);
     em.persist(car2);

     tx.commit();


     // find the students with GPA greater than 3.5 and attending a course with capacity > 30
     String queryStr = "SELECT s FROM Student s  JOIN TREAT (s.courseAttending as OnCampus) c where s.gpa>3.5 AND c.capacity>30";
     TypedQuery<Student> query1 = em.createQuery(queryStr, Student.class);
     List<Student> result1 = query1.getResultList();
     System.out.println(result1);

     //NamedQuery: create a query called CanGraduate: this query returns all students that have a GPA greater than or equal to 3.0 and have taken at least 9 courses and are not enrolled in a course right now.

     TypedQuery<Student> query2 =  em.createNamedQuery("Student.CanGraduate", Student.class);
     List<Student> result2 = query2.getResultList();
     System.out.println(result2);


     //CriteriaAPI: find all students with GPA less than 3.0 and attending a DE course with "Najeeb"


     CriteriaBuilder criBuilder =
             em.getCriteriaBuilder();
     CriteriaQuery<Student> criQuery = criBuilder.createQuery(Student.class);
     Root<Student> rootStudent = criQuery.from(Student.class);
     criQuery.select(rootStudent);

     Join<Student, DistanceEducation> joinDE_attending =  rootStudent.join("courseAttending");

     Predicate predicate_gpa = criBuilder.lessThan(rootStudent.get("gpa"),3);
     Predicate predicate_professor = criBuilder.equal(joinDE_attending.get("professorName"),"Najeeb");
     Predicate andPredicate = criBuilder.and(predicate_gpa,predicate_professor);
     criQuery.where(andPredicate);
     TypedQuery<Student> query3 = em.createQuery(criQuery);
     List<Student> result3 = query3.getResultList();
     System.out.println(result3);

     //update
     /*Car c = em.find(Car.class, 1l);
     c.setMileage(150l);
     EntityTransaction tx=em.getTransaction();
     tx.begin();
     em.persist(c);
     tx.commit();*/

     //delete
     /*Car c = em.find(Car.class, 1l);

     EntityTransaction tx=em.getTransaction();
     tx.begin();
     em.remove(c);
     tx.commit();*/

     em.close();
     emf.close();
     System.out.println("end");
 }
}
