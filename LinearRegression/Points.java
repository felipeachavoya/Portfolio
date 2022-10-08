
public class Points extends linearRegression {
    private double x, y;

    public Points(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        String s = "X: " + getX() + ", Y: " + getY();
        return s;
    }
}
