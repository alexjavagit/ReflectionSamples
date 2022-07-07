package task3;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


public class SerializeDeserialize {
    public static String serializationWork(Object obj) throws IllegalAccessException {
        Class<?> cls = ContentClass.class;
        StringBuilder strb = new StringBuilder();

        Field[] fields = cls.getDeclaredFields();

        for (Field fld: fields) {
            if (fld.isAnnotationPresent(Save.class)) {
                if (Modifier.isPrivate(fld.getModifiers()))
                    fld.setAccessible(true);
                strb.append(fld.getName() + "-");

                if (fld.getType() == int.class)
                    strb.append(fld.getInt(obj));
                if (fld.getType() == String.class)
                    strb.append((String) fld.get(obj));
                if (fld.getType() == Long.class)
                    strb.append(fld.getLong(obj));
                strb.append(";");
            }
        }
        return strb.toString();

    }

    public static <T> T deserializationWork(String s, Class<?> cls) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        T res = (T) cls.newInstance();
        String[] pairs = s.split(";");
        for (String p: pairs) {
            String[] nv = p.split("-");
            if (nv.length == 2) {
                String name = nv[0];
                String value = nv[1];

                Field f = cls.getDeclaredField(name);
                if (Modifier.isPrivate(f.getModifiers()))
                    f.setAccessible(true);

                if (f.isAnnotationPresent(Save.class)) {
                    if (f.getType() == int.class)
                        f.setInt(res, Integer.parseInt(value));
                    if (f.getType() == String.class)
                        f.set(res, value);
                    if (f.getType() == Long.class)
                        f.setLong(res, Long.parseLong(value));
                }
            }
        }
        return res;
    }

}
