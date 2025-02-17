package reflection.intermediate_Level;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "JK Rowling")
 class newClass {

}
public class AnnotationsRuntimeRetrieval {


    public static void main(String[] args) {

        Class<newClass> myClass = newClass.class;
        if(myClass.isAnnotationPresent(Author.class)){
            //Retrieve @Author annotation
            Author authorAnnotation = myClass.getAnnotation(Author.class);

            //get value of @Author annotation
            String authorName = authorAnnotation.name();
            System.out.println("Author of newClass : " + authorName);
        } else{
            System.out.println("No @Author annotation found on newClass.");
        }
    }
}
