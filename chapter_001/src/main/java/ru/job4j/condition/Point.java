package ru.job4j.condition;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point that) {
        // Точка А - это текущая точка. К ней мы обращаемся через оператор this.
        Point a = this;
        // Точка В - это входящая точка. К ней мы можем обратиться напрямую через имя переменной that.
        // или для удоства мы создали новую переменню b и к ней присвоили переменную this.
        Point b = that;
        // сделаем вывод на консоль.
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);
        return  Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }
}