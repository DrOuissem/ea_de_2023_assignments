
import jakarta.persistence.Entity;

import java.util.Date;


@Entity
public class OnCampus extends Course{
    private Long capacity;
    private String room;



    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public OnCampus(Long id, String title, Date startDate,
                    String professorName,Long capacity,String room){

        super(id,title,startDate,professorName);
        this.capacity=capacity;
        this.room=room;

    }
    public OnCampus() {
        super();
    }

    @Override
    public String toString() {

        return "OnCampus{" +
                "capacity=" + capacity +
                ", room='" + room + '\'' +
                super.toString()+'}';
    }
}
