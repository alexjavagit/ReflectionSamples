package task1;

public class Task1 {
    @MyAnnotation(parameter1 = 2, parameter2 = 3)
    public int test(int parameter1, int parameter2) {
        return (parameter1 + parameter2);
    }
}
