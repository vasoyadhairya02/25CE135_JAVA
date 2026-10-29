package Practical_5;

public class Practical_5A {
    static abstract class Shape {
    abstract double area();
}

static class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

static class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }
}

static class Triangle extends Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }
}

static class ShapeDemo {
    public static void main(String[] args) {

        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(8, 5),
            new Circle(3)
        };

        double total = 0;
        double largest = 0;

        for (Shape s : shapes) {
            double a = s.area();

            System.out.println("Area = " + a);

            total += a;

            if (a > largest) {
                largest = a;
            }
        }   

        System.out.println("Total Area = " + total);
        System.out.println("Largest Area = " + largest);
    }
}
}
