package task3;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        ContentClass contentClass = new ContentClass();
        contentClass.setField1(5);
        contentClass.setField2("field 2");

        String str = SerializeDeserialize.serializationWork(contentClass);
        System.out.println("Serialized - " + str);

        contentClass = SerializeDeserialize.deserializationWork(str, ContentClass.class);
        System.out.println("Deserialized - " + contentClass.getField1() + ", " + contentClass.getField2() + ", " + contentClass.getField3());

    }
}
