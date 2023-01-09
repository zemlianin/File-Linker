package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        // Создание объекта билдера очереди документов.
        Builder b = new Builder();
        // Генерация очереди.
        var q = b.build("C:\\Users\\813544\\Desktop\\1");
        ArrayList<TextFile> list = new ArrayList<TextFile>();
        try {
            // Попытка сортировки, в случае обнаружения цикла вывод сообщения.
            list = q.sort();
        } catch (InputMismatchException e) {
            System.out.print("Cycle!");
        }
        // Вывод результата.
        for(var i : list){
            System.out.print(i.outputText());
            System.out.print("\n");
        }
    }
}