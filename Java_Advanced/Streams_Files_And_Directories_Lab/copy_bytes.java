import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class copy_bytes {
    public static void main(String[] args) throws IOException {
        String root = System.getProperty("user.dir");

        String inputPath = root
                + "\\Streams_Files_And_Directories_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = root
                + "\\Streams_Files_And_Directories_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\copyBytes.txt";

        FileInputStream fileInputStream = new FileInputStream(inputPath);
        FileOutputStream fileOutputStream = new FileOutputStream(outputPath);

        int oneByte = fileInputStream.read();
        while (oneByte >= 0) {
            String currAscii = String.valueOf(oneByte);
            if (!(oneByte == 10 || oneByte == 32))
                for (int i = 0; i < currAscii.length(); i++)
                    fileOutputStream.write(currAscii.charAt(i));
            else
                fileOutputStream.write(oneByte);

            oneByte = fileInputStream.read();
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
