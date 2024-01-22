package Streams_Files_And_Directories_Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class count_character_types {
    public static void main(String[] args) throws IOException {
        String root = System.getProperty("user.dir");
        Character[] vowels = new Character[] {'a', 'e', 'i', 'o', 'u'};
        Character[] puns = new Character[] {'!', ',', '.', '?'};

        int[] sum = new int[3];


        String inputPath = root + "\\Streams_Files_And_Directories_Exercise\\Resources\\input.txt";
        String outputPath = root + "\\Streams_Files_And_Directories_Exercise\\Resources\\output.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
                PrintWriter printWriter = new PrintWriter(outputPath)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char character = line.charAt(i);
                    if(Arrays.asList(vowels).contains(character))
                    {
                        sum[0] += 1;
                    }
                    else if (Arrays.asList(puns).contains(character))
                    {
                        sum[2] += 1;
                    }
                    else if (!(character == 10 || character == 32))
                    {
                        sum[1] += 1;
                    }
                }
                line = bufferedReader.readLine();
            }
            printWriter.write("Vowels: " + sum[0] + "\n");
            printWriter.write("Other symbols: " + sum[1] + "\n");
            printWriter.write("Punctuation: " + sum[2]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
