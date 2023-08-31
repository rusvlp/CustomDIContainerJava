
public class Main {
    public static void main(String[] args) throws Throwable{

        SolarSystem solarSystem = new SolarSystem();

        Container.initializeContainer(Config.class);

        Container container = Container.getInstance();

        solarSystem.star = container.getDeclaredBean("sun", Star.class);
        System.out.println(solarSystem);
        solarSystem.star = container.getDeclaredBean("sun", Star.class);
        System.out.println(solarSystem);
        solarSystem.planetList.add(container.getDeclaredBean("earth", Planet.class));

    }
}