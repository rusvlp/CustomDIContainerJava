import annotations.Bean;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.function.Supplier;

public class Config {




    @Bean("earth")
    public static Supplier<Planet> getPlanet1(){

        return () -> new Planet("earth");
    }

    @Bean
    public static Supplier<Planet> getPlanet2(){
        return () -> new Planet("na marse klassno");
    }

    @Bean
    public static Supplier<Planet> getPlanet3(){
        return () -> new Planet("di");
    }

    @Bean("sun")
    public static Supplier<Star> getSun(){


        return () -> {
          Random r = new Random();
          return  new Star(r.nextInt(2929), "Sun");
        };

    }

}
