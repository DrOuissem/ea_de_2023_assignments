import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

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

     Course c1 = new Course(1L, "course1", 25L);
     Course c2 = new Course(2L, "course2", 25L);
     Course c3 = new Course(3L, "course3", 25L);
     Student s1 = new Student ("Jhon", 3.5f, c1);
     Student s2 = new Student ("Jhonny", 3.5f, c1);
     Student s3 = new Student ("Ahmad", 3.5f, c2);
     Student s4 = new Student ("Jim", 3.5f, c3);



     tx.begin();
     em.persist(c1);
     em.persist(c2);
     em.persist(c3);
     em.persist(s1);
     em.persist(s2);
     em.persist(s3);
     em.persist(s4);
     em.persist(person1);
     em.persist(person2);
     em.persist(car1);
     em.persist(car2);

     tx.commit();

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
