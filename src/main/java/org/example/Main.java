package org.example;

public class Main {
    public static void main(String[] args) {
        Builder b = new Builder();
        var q = b.Build("C:\\Users\\813544\\Desktop\\1");
        try {
            q.Sort();
        } catch (Exception e){
            System.out.print("Cycle!");
        }
        var t = q.sortedQueue;
    }
}