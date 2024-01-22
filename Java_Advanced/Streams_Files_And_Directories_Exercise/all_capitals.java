package Streams_Files_And_Directories_Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class sum_bytes {
    public static void main(String[] args) throws IOException {
        String root = System.getProperty("user.dir");

        String inputPath = root + "\\Streams_Files_And_Directories_Exercise\\Resources\\input.txt";
        String outputPath = root + "\\Streams_Files_And_Directories_Exercise\\Resources\\output.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath)); PrintWriter printWriter = new PrintWriter(outputPath)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                printWriter.write(line.toUpperCase() + "\n");
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
