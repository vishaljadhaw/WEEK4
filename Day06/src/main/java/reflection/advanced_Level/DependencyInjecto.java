package reflection.advanced_Level;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}



class Service {
    public void perform() {
        System.out.println("Service is performing...");
    }
}
class Client {
    @Inject
    private Service service;

    public void execute() {
        service.perform();
    }
}



class DependencyInjector {
    public static void injectDependencies(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);
                    field.set(obj, field.getType().getDeclaredConstructor().newInstance());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Dependency injection failed", e);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        injectDependencies(client);
        client.execute();
    }
}