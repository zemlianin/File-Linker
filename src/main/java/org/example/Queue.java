package org.example;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class Queue {
    ArrayList<TextFile> queue;
    HashMap<String, TextFile> addresses;

    public ArrayList<TextFile> Sort(){
        if(!queue.isEmpty()){
            return DFS(queue.get(0));
        } else {
            return queue;
        }

    }
    public ArrayList<TextFile> DFS(TextFile file){

        return queue;
    }
    public void Add(TextFile file){
        queue.add(file);
        addresses.put(file.getPath(),file);
    }
}
