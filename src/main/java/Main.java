import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
 public static void main(String argsp[]){
     System.out.println("start");
     EntityManagerFactory emf= Persistence.createEntityManagerFactory("default");
     EntityManager em = emf.createEntityManager();
     /*Car c = new Car(1l,"toyota","yaris",100l);
     EntityTransaction tx=em.getTransaction();
     tx.begin();
     em.persist(c);
     tx.commit();*/

     //update
     /*Car c = em.find(Car.class, 1l);
     c.setMileage(150l);
     EntityTransaction tx=em.getTransaction();
     tx.begin();
     em.persist(c);
     tx.commit();*/

     //delete
     Car c = em.find(Car.class, 1l);

     EntityTransaction tx=em.getTransaction();
     tx.begin();
     em.remove(c);
     tx.commit();

     em.close();
     emf.close();
     System.out.println("end");
 }
}
