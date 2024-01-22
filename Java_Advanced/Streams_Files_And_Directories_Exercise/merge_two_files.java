package Streams_Files_And_Directories_Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class merge_two_files {
    public static void main(String[] args) throws IOException {
        String root = System.getProperty("user.dir");

        String firstPath = root + "\\Streams_Files_And_Directories_Exercise\\Resources\\inputOne.txt";
        String secondPath = root + "\\Streams_Files_And_Directories_Exercise\\Resources\\inputTwo.txt";
        String outputPath = root + "\\Streams_Files_And_Directories_Exercise\\Resources\\output.txt";
        try (BufferedReader firstBufferedReader = new BufferedReader(new FileReader(firstPath));
             BufferedReader secondBufferedReader = new BufferedReader(new FileReader(secondPath));
             PrintWriter printWriter = new PrintWriter(outputPath)) {

            String line = firstBufferedReader.readLine();
            while (line != null) {
                printWriter.write(line + "\n");
                line = firstBufferedReader.readLine();
            }
            line = secondBufferedReader.readLine();
            while (line != null) {
                printWriter.write(line + "\n");
                line = secondBufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
