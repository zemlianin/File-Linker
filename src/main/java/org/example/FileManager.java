package org.example;

import java.io.FileReader;
import java.io.IOException;

/**
 * Менеджер работы с файловоми потоками.
 */
public class FileManager {
    /**
     * Чтение файла целиком.
     * @param path Ссылка на файл.
     * @return Содержимое.
     */
    public static String readAllText(String path) {
        String output = "";
        try (FileReader reader = new FileReader(path)) {
            int symbolCode;
            while ((symbolCode = reader.read()) != -1) {
                char symbol = (char) symbolCode;
                output += symbol;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return output;
    }
}
