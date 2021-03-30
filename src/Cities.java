import java.io.Serializable;

public class Cities implements Serializable {
   Long id ;

    String name ;

    String country ;

    String short_name ;

    public Cities(Long id, String name, String country, String short_name) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.short_name = short_name;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", short_name='" + short_name + '\'' +
                '}';
    }
}
