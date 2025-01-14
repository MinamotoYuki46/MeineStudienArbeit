package Modul5.soal1;

public class Sphere extends Shape{
    private double radius;

    public Sphere(double r){
        super("Sphere");
        setRadius(r);
    }

    @Override
    public double area(){
        return 4 * Math.PI * (radius * radius);
    }
    
    public String toString(){
        return super.toString() + " of radius " + this.radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}
