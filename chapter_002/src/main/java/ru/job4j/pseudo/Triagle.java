package ru.job4j.pseudo;

public class Triagle implements Shape {
    @Override
    public String pic() {
        StringBuilder builder = new StringBuilder();
        builder.append("  *  \n");
        builder.append(" *** \n");
        builder.append("*****");
        return builder.toString();
    }
}
