package Modul5.soal1;

public abstract class Shape {
    protected String shapeName;

    public Shape(String name){
        this.shapeName = name;
    }

    protected abstract double area(); 

    public String toString(){
        return this.shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public String getShapeName(){
        return this.shapeName;
    }
}