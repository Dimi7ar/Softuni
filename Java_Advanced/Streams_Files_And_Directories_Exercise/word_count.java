package Streams_Files_And_Directories_Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class word_count {
    public static void main(String[] args) throws IOException {
        String root = System.getProperty("user.dir");
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        String wordsPath = root + "\\Streams_Files_And_Directories_Exercise\\Resources\\words.txt";
        String textPath = root + "\\Streams_Files_And_Directories_Exercise\\Resources\\text.txt";
        String outputPath = root + "\\Streams_Files_And_Directories_Exercise\\Resources\\results.txt";
        try (BufferedReader wordsBufferedReader = new BufferedReader(new FileReader(wordsPath));
             BufferedReader textBufferedReader = new BufferedReader(new FileReader(textPath));
             PrintWriter printWriter = new PrintWriter(outputPath)) {
                Scanner textScanner = new Scanner(textBufferedReader);

            String line = wordsBufferedReader.readLine();
            while (textScanner.hasNext()) {
                String[] words = line.split("\\s+");
                String word = textScanner.next();
                if(Arrays.asList(words).contains(word))
                {
                    map.putIfAbsent(word, 0);
                    map.put(word, map.get(word) + 1);
                }
            }
            map.keySet().forEach(key -> {
                printWriter.write(String.format("%s - %d%n", key, map.get(key)));
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
