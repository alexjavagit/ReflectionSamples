package task1;

import java.lang.annotation.*;

@Target(value= ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    int parameter1();
    int parameter2();
}
