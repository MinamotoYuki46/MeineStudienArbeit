package Modul5.soal1;

public class Paint {
    private double coverage;

    public Paint(double c){
        setCoverage(c);
    }

    public double amount(Shape s){
        return s.area() / getCoverage();
    }


    public double getCoverage() {
        return this.coverage;
    }

    public void setCoverage(double coverage) {
		this.coverage = coverage;
	}
}