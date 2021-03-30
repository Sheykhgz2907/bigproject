import java.io.Serializable;

public class Aircrafts implements Serializable {
    Long id ;

 String name ;

   String model  ;

    int business_class_capacity ;

    int econom_class_capacity ;

    public Aircrafts(Long id, String name, String model, int business_class_capacity, int econom_class_capacity) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.business_class_capacity = business_class_capacity;
        this.econom_class_capacity = econom_class_capacity;
    }

    @Override
    public String toString() {
        return "Aircrafts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", business_class_capacity=" + business_class_capacity +
                ", econom_class_capacity=" + econom_class_capacity +
                '}';
    }
}