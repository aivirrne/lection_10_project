package school.lesson12;

public class Triangle {

    public int a;
    public int b;
    public int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calculateArea() {
        double p = (a + b + c) * 0.5;
        System.out.println("p = " + p);
        double result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println("result = " + result);
        return result;
    }
}


