package task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class<?> cls = Task1.class;
        Method[] methods = cls.getMethods();
        for (Method method: methods) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                try {
                    Task1 task1 = new Task1();
                    System.out.println(method.invoke(task1, method.getDeclaredAnnotation(MyAnnotation.class).parameter1(), method.getDeclaredAnnotation(MyAnnotation.class).parameter2()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
