package ex1a;

public class Triangle {
    private double side1, side2, side3;


    Triangle() {
        setSide1(1.0);
        setSide2(1.0);
        setSide3(1.0);

    }

    Triangle(double side1, double side2, double side3) {
        setSide1(side1);
        setSide2(side2);
        setSide3(side3);

    }

    public double getArea() {
        double s = (getSide1() + getSide2() + getSide3()) / 2;
        return Math.sqrt((s * (s - getSide1()) * (s - getSide2()) * (s - getSide3())));
    }

    public double getPerimeter() {
        return (getSide1() + getSide2() + getSide3());
    }

    public String toString() {
        return "Triangle: side1 = " + getSide1() + " side2 = " + getSide2() + " side3 = " + getSide3();
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }


    public static void main(String[] args) {
        Triangle myTri = new Triangle(2.0,4.0,5.5);
        System.out.println(myTri);
        System.out.println("area "+ myTri.getArea() + " peri "  + myTri.getPerimeter());

    }

}
