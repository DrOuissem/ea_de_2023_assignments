import jakarta.persistence.*;

import java.io.Serializable;
@Entity
public class Person  implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    @OneToOne
    private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Person(Long id, String name, Car car) {
        this.id = id;
        this.name = name;
        this.car = car;
        this.car.setPerson(this);
    }

    public Person() {
    }

    public Person(String name, Car car) {
        this.name = name;
        this.car = car;
    }
}
