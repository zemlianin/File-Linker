package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Builder {
    final String KEYWORD = "require ‘";
    String rootPath;
    public Builder(){
        // queue = new Queue();
        rootPath = "";
    }
    public Queue Build(String path){
        Queue queue = new Queue();
        rootPath = path;
        SearchFiles(rootPath, queue);
        return queue;
    }
    public void SearchFiles(String file, Queue queue) {
        File dir = new File(file);
        var files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if(files[i].isFile()){
                Read(files[i].getPath(),queue);
            } else {
                SearchFiles(files[i].getPath(),queue);
            }
        }
    }

    public void Read(String path,Queue queue) {
        TextFile file = new TextFile( path);
        String text = FileManager.ReadAllText(path);
        String otherFile = "";
        int index = text.indexOf(KEYWORD);
        while (index != -1) {
            index+=KEYWORD.length();
            char c = text.charAt(index);
            while (c != '’') {
                otherFile += c;
                index++;
                c = text.charAt(index);
            }
            file.AddRequire(rootPath +"\\"+ otherFile + ".txt");
            index = text.indexOf(KEYWORD, index);
            otherFile = "";
        }
        queue.Add(file);
    }
}
