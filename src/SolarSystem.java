import java.util.ArrayList;
import java.util.List;

public class SolarSystem {

    public Star star;
    public List<Planet> planetList = new ArrayList<>();

    @Override
    public String toString() {
        return "SolarSystem{" +
                "star=" + star +
                ", planetList=" + planetList +
                '}';
    }
}
