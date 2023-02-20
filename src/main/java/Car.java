import jakarta.persistence.*;


import java.io.Serializable;

@Entity
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @OneToOne(mappedBy = "car")
    private Person person;
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    private String make;
    private Long mileage;

    public Car(Long id, String model, String make, Long mileage) {
        this.id = id;
        this.model = model;
        this.make = make;
        this.mileage = mileage;

    }

    public Car( String model, String make, Long mileage) {

        this.model = model;
        this.make = make;
        this.mileage = mileage;

    }

    public Car() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
