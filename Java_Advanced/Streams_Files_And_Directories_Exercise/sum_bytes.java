package Streams_Files_And_Directories_Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class sum_bytes {
    public static void main(String[] args) throws IOException {
        String root = System.getProperty("user.dir");

        String inputPath = root + "\\Streams_Files_And_Directories_Exercise\\Resources\\input.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath))) {
            String line = bufferedReader.readLine();
            int sum = 0;
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char character = line.charAt(i);
                    sum += character;
                }
                line = bufferedReader.readLine();
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
