import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class write_to_file {
    public static void main(String[] args) throws IOException {
        String root = System.getProperty("user.dir");
        Character[] chars = {',','.','!','?'};
        HashSet<Character> puns = new HashSet<>(List.of(chars));

        String inputPath = root + "\\Streams_Files_And_Directories_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = root + "\\Streams_Files_And_Directories_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\writeToFile.txt";

        FileInputStream fileInputStream = new FileInputStream(inputPath);
        FileOutputStream fileOutputStream = new FileOutputStream(outputPath);

        int oneByte = fileInputStream.read();
        while (oneByte >= 0) {
            if(!puns.contains((char)oneByte))
            fileOutputStream.write(oneByte);

            oneByte = fileInputStream.read();
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
