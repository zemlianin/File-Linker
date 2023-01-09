package org.example;

import java.io.File;

/**
 * Билдер очеереди.
 */
public class Builder {
    private final String KEYWORD = "require ‘";
    private String rootPath;

    public Builder() {
        // queue = new Queue();
        rootPath = "";
    }

    /**
     * Билд очереди.
     *
     * @param path ссылка на дирректорию.
     * @return Очередь.
     */
    public Queue build(String path) {
        Queue queue = new Queue();
        rootPath = path;
        searchFiles(rootPath, queue);
        return queue;
    }

    /**
     * Поиск файлов.
     *
     * @param file  Файл.
     * @param queue Очередь.
     */
    private void searchFiles(String file, Queue queue) {
        File dir = new File(file);
        var files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                read(files[i].getPath(), queue);
            } else {
                searchFiles(files[i].getPath(), queue);
            }
        }
    }

    /**
     * Чтение файла и получение зависмостей исходя из содержимого.
     *
     * @param path  Путь к файлу.
     * @param queue Очередь.
     */
    private void read(String path, Queue queue) {
        TextFile file = new TextFile(path);
        String text = FileManager.readAllText(path);
        String otherFile = "";
        int index = text.indexOf(KEYWORD);
        while (index != -1) {
            index += KEYWORD.length();
            char c = text.charAt(index);
            while (c != '’') {
                otherFile += c;
                index++;
                c = text.charAt(index);
            }
            file.addRequire(rootPath + "\\" + otherFile + ".txt");
            index = text.indexOf(KEYWORD, index);
            otherFile = "";
        }
        queue.add(file);
    }
}
