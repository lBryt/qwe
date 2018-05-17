package ru.job4j.pseudo;

public class Square implements Shape {
    @Override
    public String pic() {
        StringBuilder builder = new StringBuilder();
        builder.append("***");
        builder.append("***");
        builder.append("***");
        return builder.toString();
    }
}
