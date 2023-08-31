

public class Star {
    public int brightness;
    public String name;

    public Star(int b, String name){
        this.brightness = b;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Star{" +
                "brightness=" + brightness +
                ", name='" + name + '\'' +
                '}';
    }
}
