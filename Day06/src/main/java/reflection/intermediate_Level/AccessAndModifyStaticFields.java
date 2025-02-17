package reflection.intermediate_Level;
import java.lang.reflect.Field;



class Configuration {
    private static String API_KEY = "$123-456-ABC-###";
}


public class AccessAndModifyStaticFields {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();

        try{
            Class<?> cls = cfg.getClass();
            Field API_KEY_field = cls.getDeclaredField("API_KEY");

            API_KEY_field.setAccessible(true);
            System.out.println("Original key: " + API_KEY_field.get(cfg));

            //Modify its value
            API_KEY_field.set(cfg, "#123-@456-$ABC");
            System.out.println("Modified key: " + API_KEY_field.get(cfg));

        } catch (NoSuchFieldException e) {
            System.out.println("Error : " + e.getMessage());;
        } catch(Exception e){
            System.out.println("General Exception: " + e.getMessage());
        }
    }
}
