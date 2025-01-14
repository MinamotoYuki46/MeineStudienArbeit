package Modul5.soal1;

public class Rectangle extends Shape{
    private double length;
    private double width;

    public Rectangle(double l, double w){
        super("Rectangle");
        setLength(l);
        setWidth(w);
    }

    public double area(){
        return getWidth() * getLength();
    }

    public String toString(){
        return super.toString() + " of length " + getLength() + " and width " + getWidth();
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
