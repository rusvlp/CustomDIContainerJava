import annotations.Bean;
import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Container {
    private Map<String, Object> objects = new HashMap<>();
    private static Container instance;
    private Container(Class cl) throws Throwable{
        this.cl = cl;
        load();
    };
    private Class cl;



    public static void initializeContainer(Class cl) throws Throwable{
        instance = new Container(cl);
    }

    public static Container getInstance(){

        return Container.instance;
    }

    @SneakyThrows
    public void load() throws Throwable{
        Method[] methods = cl.getDeclaredMethods();


        for(Method m : methods){
            if (m.isAnnotationPresent(Bean.class)){

                String name = m.getAnnotation(Bean.class).value();

                if (name.isEmpty()){
                    name = m.getName();
                }

                if (objects.containsKey(name)){
                    throw new IllegalArgumentException("Bean duplication is not allowed: " + name);
                }

                objects.put(name, m.invoke(null));
            }
        }

    }

    public Object getBean(String name){
        return ((Supplier)objects.get(name)).get();
    }

    public <T> T getDeclaredBean(String name, Class<T> clazz){
        return ((Supplier<T>) objects.get(name)).get();
    }

    public HashMap<String, Object> listObjects(){
        return new HashMap<>(objects);
    }


}
