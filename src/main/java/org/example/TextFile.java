package org.example;

import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.ArrayList;

public class TextFile {
    ArrayList<String> require;
    Integer Color;
    String path;
    public TextFile(){
        require = new ArrayList<>();
        Color = 0;
        path = "";
    }
    public void setSorted(Integer color) {
        Color = color;
    }

    public Integer getSorted() {
        return Color;
    }

    public String getPath() {
        return path;
    }

    public TextFile(String path){
        require = new ArrayList<>();
        Color = 0;
        this.path = path;
    }
    void  AddRequire(String path){
        require.add(path);
    }
}
