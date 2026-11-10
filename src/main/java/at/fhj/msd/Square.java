package at.fhj.msd;

public class Square {

    private final double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive");
        }
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public double area() {
        return side * side;
    }

    public double perimeter() {
        return 4 * side;
    }

    public double diagonal() {
        return side * Math.sqrt(2);
    }

    /** Radius of the circle inscribed in the square. */
    public double inscribedCircleRadius() {
        return side / 2;
    }

    /** Radius of the circle that passes through all four corners. */
    public double circumscribedCircleRadius() {
        return diagonal() / 2;
    }

    public Square scale(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Scale factor must be positive");
        }
        return new Square(side * factor);
    }

    public Rectangle toRectangle() {
        return new Rectangle(side, side);
    }

    /** Creates a square with the given area. */
    public static Square fromArea(double area) {
        if (area <= 0) {
            throw new IllegalArgumentException("Area must be positive");
        }
        return new Square(Math.sqrt(area));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Square)) {
            return false;
        }
        return Double.compare(side, ((Square) o).side) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(side);
    }

    @Override
    public String toString() {
        return "Square[side=" + side + "]";
    }
}
