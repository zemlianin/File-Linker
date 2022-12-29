package org.example;

import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.ArrayList;

public class TextFile {
    ArrayList<String> require;
    Boolean Sorted;
    String path;

    public void setSorted(Boolean sorted) {
        Sorted = sorted;
    }

    public Boolean getSorted() {
        return Sorted;
    }

    public String getPath() {
        return path;
    }

    public TextFile(String path){
        this.path = path;
    }
    void  AddRequire(String path){
        require.add(path);
    }
}
