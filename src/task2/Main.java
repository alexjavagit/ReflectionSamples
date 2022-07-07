package task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class<?> cls = TextContainer.class;
        String path = cls.getAnnotation(SaveTo.class).path();
        Method[] methods = cls.getMethods();
        for (Method method: methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                TextContainer textContainer = new TextContainer();
                try {
                    method.invoke(textContainer,path);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
