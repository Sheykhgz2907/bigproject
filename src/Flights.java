import java.io.Serializable;

public class Flights implements Serializable {
    Long id;
    int aircraft_id;
    int departure_city_id;
    int arrival_city_id;
    String departure_time;
    int economy_place_price;
    int business_place_price;
    public Flights(Long id, int aircraft_id, int departure_city_id, int arrival_city_id, String departure_time, int economy_place_price, int business_place_price) {
        this.id = id;
        this.aircraft_id = aircraft_id;
        this.departure_city_id = departure_city_id;
        this.arrival_city_id = arrival_city_id;
        this.departure_time = departure_time;
        this.economy_place_price = economy_place_price;
        this.business_place_price = business_place_price;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "id=" + id +
                ", aircraft_id=" + aircraft_id +
                ", departure_city_id=" + departure_city_id +
                ", arrival_city_id=" + arrival_city_id +
                ", departure_time='" + departure_time + '\'' +
                ", econom_place_price=" + economy_place_price +
                ", business_place_price=" + business_place_price +
                '}';
    }
}
