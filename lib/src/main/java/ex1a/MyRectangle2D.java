package ex1a;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyRectangle2D {
    private double x = 0;
    private double y = 0;
    private double width = 1;
    private double height = 1;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    MyRectangle2D(){
        this(0,0,1,1);
    }
    MyRectangle2D(double x,double y ,double width,double height){
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public double getArea(){
        return getWidth()*getHeight();
    }
    public double getPerimeter(){
        return (2*width)+(2*height);
    }

    //contains point
    public boolean contains(double x , double y){
        if (x<=this.x + getWidth()/2 && x>=this.x - getWidth()/2){
            if (y<=this.y + getHeight()/2 && y>=this.y - getHeight()/2){
                return true;
            }
        }
        return false;
    }

    public boolean contains(MyRectangle2D r){
        double rx =r.getX();
        double ry = r.getY();
        double rheight = r.getHeight();
        double rwidth = r.getWidth();
        // checking if x value is in the rectangle
        if (rx+ rwidth/2 <= x + getWidth()/2 && rx- rwidth/2 >= this.x - this.width/2){
            if (ry+ rheight/2 <= this.y + this.height/2 && ry- rheight/2 >= this.y - this.height/2){
                return true;
            }
        }
        return false;
    }

    public boolean overlaps(MyRectangle2D r){
        double rx =r.getX();
        double ry = r.getY();
        double rheight = r.getHeight();
        double rwidth = r.getWidth();


        double halfWidth = rwidth/2;
        double halfHeight = rheight/2;
        double pointax = rx -halfWidth;
        double pointay = ry + halfHeight;
        double pointbx = rx +halfWidth;
        double pointby = ry + halfHeight;
        double pointcx = rx +halfWidth;
        double pointcy = ry - halfHeight;
        double pointdx = rx -halfWidth;
        double pointdy = ry - halfHeight;

        List<Double> xlist = Arrays.asList(pointax,pointbx,pointcx,pointdx);
        List<Double> ylist = Arrays.asList(pointay,pointby,pointcy,pointdy);

        for (int i = 0; i < xlist.size();i++){
            if(contains(xlist.get(i),ylist.get(i) )){
                return true;
            }
        }

        return false;
    }
}
