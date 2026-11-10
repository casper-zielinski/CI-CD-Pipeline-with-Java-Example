package at.fhj.msd;

public class Rectangle {

    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be positive");
        }
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public double diagonal() {
        return Math.hypot(width, height);
    }

    public boolean isSquare() {
        return Double.compare(width, height) == 0;
    }

    public Rectangle scale(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Scale factor must be positive");
        }
        return new Rectangle(width * factor, height * factor);
    }

    /** Returns a copy with width and height swapped. */
    public Rectangle rotate() {
        return new Rectangle(height, width);
    }

    public boolean fitsInside(Rectangle other) {
        return width <= other.width && height <= other.height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rectangle)) {
            return false;
        }
        Rectangle r = (Rectangle) o;
        return Double.compare(width, r.width) == 0 && Double.compare(height, r.height) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(width) + Double.hashCode(height);
    }

    @Override
    public String toString() {
        return "Rectangle[width=" + width + ", height=" + height + "]";
    }
}
