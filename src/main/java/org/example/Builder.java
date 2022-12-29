package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Builder {
    Queue queue;
    final String KEYWORD = "require ‘";

    public void SearchFiles(String file) {
        File dir = new File(file);
        var files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if(files[i].isFile()){
                Read(files[i].getPath());
            } else {
                SearchFiles(files[i].getPath());
            }
        }
    }

    public void Read(String path) {
        TextFile file = new TextFile(path);
        String text = FileManager.ReadAllText(path);
        String otherFile = "";
        int index = text.indexOf(KEYWORD);
        while (index != -1) {
            char c = text.charAt(index + 1);
            while (c != '’') {
                otherFile += c;
            }
            file.AddRequire(otherFile);
            index = text.indexOf(KEYWORD, index);
        }
        queue.Add(file);
    }
}
