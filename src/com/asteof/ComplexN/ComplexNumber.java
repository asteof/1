package com.asteof.ComplexN;

public class ComplexNumber {
    private final double real;
    private final double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public double getReal() { return real; }
    public double getImaginary() { return imaginary; }

    public static ComplexNumber Add(ComplexNumber a, ComplexNumber b) {
        double real = a.getReal() + b.getReal();
        double imag = a.getImaginary() + b.getImaginary();
        return new ComplexNumber(real, imag);
    }

    public static ComplexNumber Subtract(ComplexNumber a, ComplexNumber b) {
        double real = a.getReal() - b.getReal();
        double imag = a.getImaginary() - b.getImaginary();
        return new ComplexNumber(real, imag);
    }

    public static ComplexNumber Scale(double alpha, ComplexNumber n) {
        return new ComplexNumber(alpha * n.getReal(), alpha * n.getImaginary());
    }

    public static ComplexNumber Multiply(ComplexNumber a, ComplexNumber b) {
        if(a.getImaginary() == 0 && b.getImaginary() == 0) {
            return new ComplexNumber(a.getReal() * b.getReal(), 0);
        }
       return new ComplexNumber((a.getReal() * b.getReal()) - (a.getImaginary() * b.getImaginary()),
               (a.getReal() * b.getImaginary()) + (a.getImaginary() * b.getReal()));
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

    @Override
    public String toString() {
        if (imaginary == 0) return real + "";
        if (real == 0) return imaginary + "i";
        if (imaginary <  0) return real + " - " + (-imaginary) + "i";
        return real + " + " + imaginary + "i";
    }

}
