package annotation.exercise.use_Deprecated;


class LegacyAPI {

    @Deprecated
     void oldFeature() {
        System.out.println("Warning: oldFeature() is deprecated. Use newFeature() instead.");
    }

    void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

public class Deprecated1 {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        api.oldFeature(); // Calling deprecated method
        api.newFeature(); // Calling the recommended method
    }
}
