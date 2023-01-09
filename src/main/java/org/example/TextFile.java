package org.example;

import java.util.ArrayList;

public class TextFile {
    ArrayList<String> require;
    private Integer Color;
    private String path;

    /**
     * Конструктор по умолчанию.
     */
    public TextFile() {
        require = new ArrayList<>();
        Color = 0;
        path = "";
    }

    /**
     * Присвоение цвета.
     *
     * @param color цвет.
     */
    public void setSorted(Integer color) {
        Color = color;
    }

    /**
     * Получение цвета.
     *
     * @return цвет.
     */
    public Integer getColor() {
        return Color;
    }

    /**
     * Получение ссылки.
     *
     * @return ссылка.
     */
    public String getPath() {
        return path;
    }

    /**
     * Конструкктор текстого файла.
     *
     * @param path ссылка на файл.
     */
    public TextFile(String path) {
        require = new ArrayList<>();
        Color = 0;
        this.path = path;
    }

    /**
     * Вывод файла.
     *
     * @return Text of file.
     */
    public String outputText() {
        String text = "";
        text = FileManager.readAllText(path);
        return text;
    }

    /**
     * @param path Ссылка на запрашиваемый файл
     */
    void addRequire(String path) {
        require.add(path);
    }
}
