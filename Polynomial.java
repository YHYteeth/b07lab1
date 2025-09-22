public class Polynomial {
    private double[] coefficients; //It has one field representing the coefficients of the polynomial using an array of double.

    public Polynomial() {
        this.coefficients = new double[] {0};
    }

    public Polynomial(double[] other) {
        //It has a constructor that takes an array of doubles as an argument and initializes the coefficients field
        // (if null or empty, it initializes the coefficients field to [0.0])
        if (other == null || other.length == 0) {
            this.coefficients = new double[]{0.0};
        } else {
            this.coefficients = new double[other.length];
            for (int i = 0; i < other.length; i++) {
                this.coefficients[i] = other[i];
            }
        }
    }

    public Polynomial add(Polynomial other) {
        //It has a method named add that takes one argument of type Polynomial and
        //returns the polynomial resulting from adding the calling object and the argument.
        int maxLength;
        if (other.coefficients.length > this.coefficients.length) {
            maxLength = other.coefficients.length;
        } else {
            maxLength = this.coefficients.length;
        }

        double[] resultPolynomial = new double[maxLength];

        for (int i = 0; i < this.coefficients.length; i++) {
            resultPolynomial[i] += this.coefficients[i];
        }

        for (int i = 0; i < other.coefficients.length; i++) {
            resultPolynomial[i] += other.coefficients[i];
        }

        return new Polynomial(resultPolynomial);
    }

    public double evaluate(double x) {
    //It has a method named evaluate that takes one argument of type double
    //representing a value of x and evaluates the polynomial accordingly. 
        double result = 0.0; 
        for (int i = 0; i < this.coefficients.length; i++) {
            double variableX = 1.0;
            for (int j = 0; j < i; j++) {
                variableX *= x;
            }
            result += this.coefficients[i] * variableX;
        }
        return result;
    }

    public boolean hasRoot(double x) {
        //t has a method named hasRoot that takes one argument of type double and
        //determines whether this value is a root of the polynomial or not.
        if (this.evaluate(x) == 0) {
            return true;
        } else {
            return false;
        }
    }
}