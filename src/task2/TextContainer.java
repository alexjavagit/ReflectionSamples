package task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "file.txt")
public class TextContainer {
    String str = "This is my string.";

    @Saver
    public void save(String path) {
        try {
            File newTextFile = new File(path);
            FileWriter fw = null;
            fw = new FileWriter(newTextFile);
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
