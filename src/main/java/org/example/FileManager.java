package org.example;

import java.io.FileReader;
import java.io.IOException;

public class FileManager {
    public static String ReadAllText(String path){
        String output = "";
        try(FileReader reader = new FileReader(path))
        {
            // читаем посимвольно
            int symbolCode;
            while((symbolCode=reader.read())!=-1){
                char symbol = (char)symbolCode;
                output+=symbol;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return output;
    }
}
