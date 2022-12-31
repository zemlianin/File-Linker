package org.example;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class Queue {
    ArrayList<TextFile> queue;
    ArrayList<TextFile> sortedQueue;
    HashMap<String, TextFile> addresses;

    public Queue() {
        queue = new ArrayList<>();
        sortedQueue = new ArrayList<>();
        addresses = new HashMap<>();
    }

    public ArrayList<TextFile> Sort() throws Exception {
        if (!queue.isEmpty()) {
            for (var it : queue) {
                DFS(it);
            }
            return sortedQueue;
        } else {
            return queue;
        }
    }

    public void DFS(TextFile file) throws Exception {
        if (file.getSorted() == 1) {
            throw new Exception();
        }
        if (file.getSorted() == 0) {
            file.setSorted(1);
            for (var it : file.require) {
                if (addresses.containsKey(it)) {
                    DFS(addresses.get(it));
                }
            }
            sortedQueue.add(file);
            file.setSorted(2);
        }
    }

    public void Add(TextFile file) {
        queue.add(file);
        addresses.put(file.getPath(), file);
    }
}
