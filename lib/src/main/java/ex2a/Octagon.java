package ex2a;

public class Octagon implements Comparable<Octagon>{
    private double side;
    public Octagon(double side){
        this.side = side;
    }
    public double getSide() {
        return side;
    }
    public int compareTo(Octagon o){
        if( getSide()>o.getSide()){
            return 1;
        }
        else if (getSide()==o.getSide()){
            return 0;
        }
        return -1;
    }

}
