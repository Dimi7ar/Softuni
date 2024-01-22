package Streams_Files_And_Directories_Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class sum {
    public static void main(String[] args) throws IOException {
        String root = System.getProperty("user.dir");

        String inputPath = root + "\\Streams_Files_And_Directories_Exercise\\Resources\\input.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    char character = line.charAt(i);
                    sum += character;
                }
                System.out.println(sum);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
