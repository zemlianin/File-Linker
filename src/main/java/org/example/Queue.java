package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;

/**
 * Очередь файлов.
 */
public class Queue {
    private ArrayList<TextFile> queue;
    private ArrayList<TextFile> sortedQueue;
    private HashMap<String, TextFile> addresses;

    /**
     * Конструктор очереди по умолчанию.
     */
    public Queue() {
        queue = new ArrayList<>();
        sortedQueue = new ArrayList<>();
        addresses = new HashMap<>();
    }

    /**
     * Сортировка очереди
     *
     * @return Массив файл в нужном порядке.
     * @throws InputMismatchException Ошибочный порядок файлов
     */
    public ArrayList<TextFile> sort() throws InputMismatchException {
        if (!queue.isEmpty()) {
            for (var it : queue) {
                DFS(it);
            }
            return sortedQueue;
        } else {
            return queue;
        }
    }

    /**
     * Обход графа.
     *
     * @param file Файл над которым проходит обход.
     * @throws InputMismatchException Обнаружение цикла.
     */
    private void DFS(TextFile file) throws InputMismatchException {
        if (file.getColor() == 1) {
            throw new InputMismatchException();
        }
        if (file.getColor() == 0) {
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

    /**
     * Добавление файла в очередь.
     *
     * @param file Файл.
     */
    public void add(TextFile file) {
        queue.add(file);
        addresses.put(file.getPath(), file);
    }
}
