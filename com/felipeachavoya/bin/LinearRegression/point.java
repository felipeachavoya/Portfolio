public class point {
    private double x, y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "x: " + getX() + "y: " + getY();
    }
}