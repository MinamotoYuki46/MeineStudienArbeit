package Modul5.soal1;

public class Cylinder extends Shape {
    private double radius;
    private double height;

    public Cylinder(double r, double h){
        super("Cylinder");
        setRadius(r);
        setHeight(h);
    }

    public double area(){
        return Math.PI * (getRadius() * getRadius()) * getHeight();
    }

    public String toString(){
        return super.toString() + " of radius " + getRadius() + " and height " + getHeight();
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
