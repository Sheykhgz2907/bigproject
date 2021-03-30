import javax.swing.*;
import java.io.Serializable;

public class Tickets implements Serializable {
   Long id;

   int  flight_id;

   String name ;

   String surname;

   String passport_number;

  String  ticket_type;

    public Tickets(Long id, int flight_id, String name, String surname, String passport_number, String ticket_type) {
        this.id = id;
        this.flight_id = flight_id;
        this.name = name;
        this.surname = surname;
        this.passport_number = passport_number;
        this.ticket_type = ticket_type;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", flight_id=" + flight_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passport_number='" + passport_number + '\'' +
                ", ticket_type='" + ticket_type + '\'' +
                '}';
    }
}
