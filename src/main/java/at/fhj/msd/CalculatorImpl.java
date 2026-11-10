package at.fhj.msd;

import java.util.Arrays;

public class CalculatorImpl implements Calculator {

    // ---------------------------------------------------------------
    // Basic arithmetic
    // ---------------------------------------------------------------

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return a / b;
    }

    // ---------------------------------------------------------------
    // Double variants
    // ---------------------------------------------------------------

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return a / b;
    }

    // ---------------------------------------------------------------
    // Division related
    // ---------------------------------------------------------------

    public int modulo(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return a % b;
    }

    /** Modulo whose result always has the sign of the divisor (mathematical modulo). */
    public int floorMod(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return Math.floorMod(a, b);
    }

    /** Integer division rounding towards negative infinity. */
    public int floorDivide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return Math.floorDiv(a, b);
    }

    public boolean isDivisibleBy(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return a % b == 0;
    }

    // ---------------------------------------------------------------
    // Powers and roots
    // ---------------------------------------------------------------

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    /** Integer power by repeated squaring; exponent must not be negative. */
    public long power(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent cannot be negative");
        }
        long result = 1;
        long b = base;
        int e = exponent;
        while (e > 0) {
            if ((e & 1) == 1) {
                result *= b;
            }
            b *= b;
            e >>= 1;
        }
        return result;
    }

    public double square(double a) {
        return a * a;
    }

    public double cube(double a) {
        return a * a * a;
    }

    public double squareRoot(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(a);
    }

    public double cubeRoot(double a) {
        return Math.cbrt(a);
    }

    /** n-th root of a; even roots of negative numbers are rejected. */
    public double nthRoot(double a, int n) {
        if (n == 0) {
            throw new IllegalArgumentException("Root degree cannot be zero");
        }
        if (a < 0 && n % 2 == 0) {
            throw new IllegalArgumentException("Cannot calculate even root of a negative number");
        }
        if (a < 0) {
            return -Math.pow(-a, 1.0 / n);
        }
        return Math.pow(a, 1.0 / n);
    }

    public double reciprocal(double a) {
        if (a == 0) {
            throw new IllegalArgumentException("Cannot calculate reciprocal of zero");
        }
        return 1.0 / a;
    }

    // ---------------------------------------------------------------
    // Sign / comparison helpers
    // ---------------------------------------------------------------

    public int abs(int a) {
        return a < 0 ? -a : a;
    }

    public double abs(double a) {
        return Math.abs(a);
    }

    public int negate(int a) {
        return -a;
    }

    public int signum(int a) {
        return Integer.signum(a);
    }

    public int max(int a, int b) {
        return Math.max(a, b);
    }

    public int min(int a, int b) {
        return Math.min(a, b);
    }

    public int clamp(int value, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min cannot be greater than max");
        }
        return Math.max(min, Math.min(max, value));
    }

    public boolean isEven(int a) {
        return a % 2 == 0;
    }

    public boolean isOdd(int a) {
        return a % 2 != 0;
    }

    // ---------------------------------------------------------------
    // Rounding
    // ---------------------------------------------------------------

    public long round(double a) {
        return Math.round(a);
    }

    public double round(double a, int decimals) {
        if (decimals < 0) {
            throw new IllegalArgumentException("Decimals cannot be negative");
        }
        double factor = Math.pow(10, decimals);
        return Math.round(a * factor) / factor;
    }

    public double floor(double a) {
        return Math.floor(a);
    }

    public double ceil(double a) {
        return Math.ceil(a);
    }

    // ---------------------------------------------------------------
    // Number theory
    // ---------------------------------------------------------------

    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n > 20) {
            throw new ArithmeticException("Factorial overflows long for n > 20");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public int gcd(int a, int b) {
        int x = abs(a);
        int y = abs(b);
        while (y != 0) {
            int t = x % y;
            x = y;
            y = t;
        }
        return x;
    }

    public int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return abs(a / gcd(a, b) * b);
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n < 4) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; (long) i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /** n-th Fibonacci number (fib(0) = 0, fib(1) = 1). */
    public long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci is not defined for negative numbers");
        }
        if (n > 92) {
            throw new ArithmeticException("Fibonacci overflows long for n > 92");
        }
        long a = 0;
        long b = 1;
        for (int i = 0; i < n; i++) {
            long t = a + b;
            a = b;
            b = t;
        }
        return a;
    }

    /** Binomial coefficient "n choose k". */
    public long binomial(int n, int k) {
        if (n < 0 || k < 0 || k > n) {
            throw new IllegalArgumentException("Invalid arguments for binomial coefficient");
        }
        int kk = Math.min(k, n - k);
        long result = 1;
        for (int i = 1; i <= kk; i++) {
            result = result * (n - kk + i) / i;
        }
        return result;
    }

    public int sumOfDigits(int n) {
        int x = abs(n);
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    // ---------------------------------------------------------------
    // Logarithms
    // ---------------------------------------------------------------

    public double log(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Logarithm is only defined for positive numbers");
        }
        return Math.log(a);
    }

    public double log10(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Logarithm is only defined for positive numbers");
        }
        return Math.log10(a);
    }

    public double log(double a, double base) {
        if (a <= 0 || base <= 0 || base == 1) {
            throw new IllegalArgumentException("Invalid argument or base for logarithm");
        }
        return Math.log(a) / Math.log(base);
    }

    // ---------------------------------------------------------------
    // Trigonometry (angles in radians unless stated otherwise)
    // ---------------------------------------------------------------

    public double sin(double radians) {
        return Math.sin(radians);
    }

    public double cos(double radians) {
        return Math.cos(radians);
    }

    public double tan(double radians) {
        return Math.tan(radians);
    }

    public double toRadians(double degrees) {
        return Math.toRadians(degrees);
    }

    public double toDegrees(double radians) {
        return Math.toDegrees(radians);
    }

    // ---------------------------------------------------------------
    // Percentages
    // ---------------------------------------------------------------

    /** percent% of value, e.g. percentOf(200, 15) = 30. */
    public double percentOf(double value, double percent) {
        return value * percent / 100.0;
    }

    /** How many percent part is of whole. */
    public double percentage(double part, double whole) {
        if (whole == 0) {
            throw new IllegalArgumentException("Whole cannot be zero");
        }
        return part / whole * 100.0;
    }

    /** value increased by percent%. */
    public double addPercent(double value, double percent) {
        return value + percentOf(value, percent);
    }

    /** value decreased by percent%. */
    public double subtractPercent(double value, double percent) {
        return value - percentOf(value, percent);
    }

    // ---------------------------------------------------------------
    // Statistics over several values
    // ---------------------------------------------------------------

    public int sum(int... values) {
        int sum = 0;
        for (int v : values) {
            sum += v;
        }
        return sum;
    }

    public long product(int... values) {
        long product = 1;
        for (int v : values) {
            product *= v;
        }
        return product;
    }

    public double average(double... values) {
        requireNotEmpty(values);
        double sum = 0;
        for (double v : values) {
            sum += v;
        }
        return sum / values.length;
    }

    public double median(double... values) {
        requireNotEmpty(values);
        double[] sorted = values.clone();
        Arrays.sort(sorted);
        int mid = sorted.length / 2;
        if (sorted.length % 2 == 0) {
            return (sorted[mid - 1] + sorted[mid]) / 2.0;
        }
        return sorted[mid];
    }

    public double maxOf(double... values) {
        requireNotEmpty(values);
        double max = values[0];
        for (double v : values) {
            max = Math.max(max, v);
        }
        return max;
    }

    public double minOf(double... values) {
        requireNotEmpty(values);
        double min = values[0];
        for (double v : values) {
            min = Math.min(min, v);
        }
        return min;
    }

    /** Population variance. */
    public double variance(double... values) {
        double mean = average(values);
        double sum = 0;
        for (double v : values) {
            sum += (v - mean) * (v - mean);
        }
        return sum / values.length;
    }

    /** Population standard deviation. */
    public double standardDeviation(double... values) {
        return Math.sqrt(variance(values));
    }

    private static void requireNotEmpty(double[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("At least one value is required");
        }
    }
}
