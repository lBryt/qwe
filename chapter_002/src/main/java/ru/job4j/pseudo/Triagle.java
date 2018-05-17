package ru.job4j.pseudo;

public class Triagle implements Shape {
    @Override
    public String pic() {
        StringBuilder builder = new StringBuilder();
        builder.append("  *  \r\n");
        builder.append(" *** \r\n");
        builder.append("*****");
        return builder.toString();
    }
}
