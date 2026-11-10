package at.fhj.msd;

public class Circle {

    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double diameter() {
        return 2 * radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    public Circle scale(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Scale factor must be positive");
        }
        return new Circle(radius * factor);
    }

    /** Area of a sector with the given angle in degrees. */
    public double sectorArea(double degrees) {
        return area() * degrees / 360.0;
    }

    /** Length of an arc with the given angle in degrees. */
    public double arcLength(double degrees) {
        return circumference() * degrees / 360.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Circle)) {
            return false;
        }
        return Double.compare(radius, ((Circle) o).radius) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(radius);
    }

    @Override
    public String toString() {
        return "Circle[radius=" + radius + "]";
    }
}
