package ex1a;

public class LinearEquation {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;


    LinearEquation(double a, double b, double c, double d, double e, double f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }
    public double getD() {
        return d;
    }
    public double getE() {
        return e;
    }
    public double getF() {
        return f;
    }

    public boolean isSolvable(){
        if (getA()*getD() - getB()*getC() ==0){
            return false;
        }
        return true;
    }

    public String getX(){
        return String.valueOf((1/(getA()*getD() - getB()*getC()))*((getE()*getD()) + (getF()*(-getB()))));
    }

    public String getY(){
        return String.valueOf((1/(getA()*getD() - getB()*getC()))*((getE()*(-getC())) + (getF()*(getA()))));
    }
}

