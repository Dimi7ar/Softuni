import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class extract_integers {
    public static void main(String[] args) throws IOException {
        String root = System.getProperty("user.dir");

        String inputPath = root
                + "\\Streams_Files_And_Directories_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = root
                + "\\Streams_Files_And_Directories_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\extractIntegers.txt";
        try (FileReader fileReader = new FileReader(inputPath);
                FileWriter fileWriter = new FileWriter(outputPath)) {

            Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.println(scanner.nextInt());
                }
                scanner.next();
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
