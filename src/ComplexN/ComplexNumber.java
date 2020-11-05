package ComplexN;

public class ComplexNumber {
    private final double real;
    private final double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public double getReal() { return real; }
    public double getImaginary() { return imaginary; }

    @Override
    public String toString() {
        if (imaginary == 0) return real + "";
        if (real == 0) return imaginary + "i";
        if (imaginary <  0) return real + " - " + (-imaginary) + "i";
        return real + " + " + imaginary + "i";
    }

    public static ComplexNumber Add(ComplexNumber a, ComplexNumber b) {
        double real = a.real + b.real;
        double imag = a.imaginary + b.imaginary;
        return new ComplexNumber(real, imag);
    }

    public static ComplexNumber Subtract(ComplexNumber a, ComplexNumber b) {
        double real = a.real - b.real;
        double imag = a.imaginary - b.imaginary;
        return new ComplexNumber(real, imag);
    }

    public ComplexNumber Scale(double alpha, ComplexNumber n) {
        return new ComplexNumber(alpha * n.real, alpha * n.imaginary);
    }

    public static ComplexNumber Multiply(ComplexNumber a, ComplexNumber b) {
        if(a.imaginary == 0 && b.imaginary == 0) {
            return new ComplexNumber(a.getReal() * b.getReal(), 0);
        }
       return new ComplexNumber((a.real * b.real) - (a.imaginary * b.imaginary),
               (a.real * b.imaginary) + (a.imaginary * b.real));
    }

    public static ComplexNumber Divide(ComplexNumber a, ComplexNumber b)
    {
        double aR = a.getReal();
        double aI = a.getImaginary();
        double bR = b.getReal();
        double bI = b.getImaginary();

        double bReal2 = 0.0;
        if (bR != 0.0)
        {bReal2 = Math.pow(bR, 2.);}
        double bImg2 = 0.0;
        if (bI != 0.0)
        {bImg2 = Math.pow(bI, 2.);}
        //a - real, b - img
        double abR  = aR*bR;
        double abI  = aI*bI;
        double aIbR = aI*bR;
        double aRbI = aR*bI;
        return new ComplexNumber((abR+abI)/(bReal2+bImg2),(aIbR-aRbI)/(bReal2+bImg2));
    }

}
