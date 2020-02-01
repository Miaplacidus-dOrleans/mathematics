/*
 * The MIT License
 *
 * Copyright 2020 Miaplacidus.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.miaplacidus.mathematics.number.complex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.miaplacidus.mathematics.number.Arithmetic;

/**
 * Representation of a complex number, id est a number with both a real part and an imaginary part.
 * @author Miaplacidus d'Orléans <miaplacidus.d.orleans@gmail.com>
 */
public class Complex extends Object implements Serializable, Arithmetic<Complex> {
    /**
     * The serial version UID of complex numbers.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Zero, the identity element of complex addition.
     */
    public static final Complex ZERO=new Complex(0.,0.);
    /**
     * One, the identity element of complex multiplication and exponentiation as the exponent.
     */
    public static final Complex ONE=new Complex(1.,0.);
    /**
     * I, the imaginary unit.
     */
    public static final Complex I=new Complex(0.,1.);
    /**
     * Two, the imaginary unit raised to the second power is negative one.
     */
    public static final Complex TWO=new Complex(2.,0.);
    /**
     * A complex expression of the base of the natural logarithm.
     */
    public static final Complex E=new Complex(Math.E,0.);
    /**
     * A complex expression of the ratio of the circumference of a circle to its diameter.
     */
    public static final Complex PI=new Complex(Math.PI,0.);
    /**
     *
     */
    public static final Complex INFINITY=new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    /**
     *
     */
    private static final Logger LOG = Logger.getLogger(Complex.class.getName());
    /**
     * Construct a complex number from the provided polar representation.
     * @param rho the absolute value of the expected complex number.
     * @param theta the argument of the expected complex number.
     * @return a complex number of the polar representation.
     * @throws IllegalArgumentException if the radius is smaller than zero.
     */
    public static Complex polarComplex(final double rho, final double theta) throws IllegalArgumentException {
        if (rho < 0) {
            throw new IllegalArgumentException();
        } else {
            return new Complex(rho * Math.cos(theta), rho * Math.sin(theta));
        }
    }
    /**
     * The real part of this complex number.
     */
    private final double real;
    
    /**
     * The imaginary part of this complex number.
     */
    private final double imaginary;
    
    /**
     * Construct a complex number only with its provided real part.
     * @param real the real part of the complex number.
     */
    public Complex(final double real) {
        this.real = real;
        this.imaginary = 0.;
    }
    
    /**
     * Construct a complex number with provided real part and imaginary part.
     * @param real the real part of the complex number.
     * @param imaginary the imaginary part of the complex number.
     */
    public Complex(final double real, final double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    
    /**
     * Test for equality with another object.
     * @param object Object that is tested to.
     * @return true if the objects are equal; 
     * false if object is null, not an instance of Complex or not equal to this.
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        } else if (object == null) {
            return false;
        } else if (this.getClass() != object.getClass()) {
            return false;
        } else {
            final Complex other = (Complex) object;
            
            return Double.doubleToLongBits(this.real) == Double.doubleToLongBits(other.real())
                    && Double.doubleToLongBits(this.imaginary) == Double.doubleToLongBits(other.imaginary());
        }
    }
    
    /**
     * Receive the hash code for the complex number.
     * @return a hash code for this.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.real) ^ (Double.doubleToLongBits(this.real) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.imaginary) ^ (Double.doubleToLongBits(this.imaginary) >>> 32));
        return hash;
    }

    /**
     * Serialise this complex number.
     * @return a string that represents the complex number.
     */
    @Override
    public String toString() {
        if (this.notANumber()) {
            return "not a number";
        } else if (this.infinite()) {
            return "infinity";
        } else {
            if (this.imaginary == 0) {
                return this.real + "";
            } else if (this.real == 0) {
                return this.imaginary + "i";
            } else if (this.imaginary >= 0) {
                return this.real + "+" + this.imaginary + "i";
            } else {
                return this.real + this.imaginary + "i";
            }
        }
    }  
    
    

    

    /**
     * Verify if the complex number is zero.
     * @return true if this complex number equals to zero, false otherwise.
     */
    public boolean zero() {
        return this.real == 0 && this.imaginary == 0;
    }
    
    /**
     * Verify if the complex number is infinite.
     * @return true if this complex number is infinite, false otherwise.
     */
    public boolean infinite() {
        return this.real == Double.POSITIVE_INFINITY || this.real == Double.NEGATIVE_INFINITY
                || this.imaginary == Double.POSITIVE_INFINITY || this.imaginary == Double.NEGATIVE_INFINITY;
    }
    
    /**
     * Verify if the complex number is not on the complex plane.
     * @return true if this instance is not a complex number, false otherwise.
     */
    public boolean notANumber() {
        return this.real == Double.NaN || this.imaginary == Double.NaN;
    }
    
    /**
     * Verify if the complex number is finite.
     * @return true if the complex number is a number and not infinite, false otherwise.
     */
    public boolean finite() {
        return !(this.infinite() || this.notANumber());
    }
    
    
    
    
    
    
    
    
    
    /**
     * The real function.
     * @return the real part of this complex number.
     */
    public double real() {
        return this.real;
    }
    
    /**
     * The imaginary function.
     * @return the imaginary part of this complex number.
     */
    public double imaginary() {
        return this.imaginary;
    }
    
    /**
     * The absolute value function.
     * @return the absolute value of this complex number.
     */
    public double absolute() {
        return Math.hypot(this.real, this.imaginary);
    }
    
    /**
     * The principle value argument function.
     * @return the principle value of the argument of this complex number, 
     * that must lies within the interval (-pi, +pi].
     */
    public double argument() {
        return Math.atan2(this.imaginary, this.real);
    }
    
    /**
     * The field norm of the complex number.
     * @return the field norm of the complex number.
     */
    public double norm() {
        return Math.pow(this.real, 2) * Math.pow (this.imaginary, 2);
    } 
    
    /**
     * The conjugate function.
     * @return the complex conjugate of this complex number
     * that is a complex number that has a negative imaginary part.
     */
    public Complex conjugate() {
        return new Complex(this.real, -this.imaginary);
    }
    
    /**
     * The projection of a complex number to the Riemann Sphere.
     * @return an infinity with a zero imaginary part if this is infinite,
     * only return this complex number otherwise. 
     */
    public Complex projection() {
        return this.infinite() ? new Complex(Double.POSITIVE_INFINITY, 0) : this;
    }
    
    /**
     * The additive inverse function.that is homogeneous to the unary operator '-'.
     * @return the negation of this complex number.
     */
    public Complex negate() {
        return new Complex(-this.real, -this.imaginary);
    }
    /**
     * The reciprocal function.
     * @return the reciprocal of this complex number.
     */
    public Complex reciprocal() {
        return new Complex(this.real / (Math.pow(this.real,2)+Math.pow(this.imaginary,2)),
                -this.imaginary / (Math.pow(this.real,2)+Math.pow(this.imaginary,2)));
    }

    
    
    
    
    
    
    /**
     * The sign function.
     * @return the sign of this complex number, a point on the unit circle of the complex plane
     * that is nearest to this, except for zero for reasons of symmetry.
     */
    public Complex signum() {
        return this.zero() ? Complex.ZERO : new Complex(this.real / Math.hypot(this.real,this.imaginary),
                this.imaginary/Math.hypot(this.real, this.imaginary));
    }
    /*
    
    
    
    
    
    
    
    
    
    
    Equals!
    */
    
    /**
     * The addition of complex numbers.
     * @param addend the complex number that is added to this augend.
     * @return a complex number that is the sum of the augend and the addend.
     */
    public Complex add(final Complex addend) {
        return new Complex(this.real + addend.real(), this.imaginary + addend.imaginary());        
    }
    
    /**
     * The addition of a complex number and a real number.
     * @param addend the real number that is added to this augend.
     * @return a complex number that is the sum of the augend and the addend.
     */
    public Complex add(final double addend) {
        return new Complex(this.real + addend, this.imaginary);        
    }
    
    /**
     * The subtraction of complex numbers.
     * @param subtrahend the complex number that is subtracted from this minuend.
     * @return a complex number that is the difference of the minuend and the subtrahend.
     */
    public Complex subtract(final Complex subtrahend) {
        return new Complex(this.real - subtrahend.real(), this.imaginary - subtrahend.imaginary());
    }
    
    /**
     * The subtraction of a complex minuend and a real subtrahend.
     * @param subtrahend the real number that is subtracted from this minuend.
     * @return a complex number that is the difference of the minuend and the subtrahend.
     */
    public Complex subtract(final double subtrahend) {
        return new Complex(this.real - subtrahend, this.imaginary);
    }
    
    /**
     * The multiplication of complex numbers.
     * @param multiplicand the complex number that is multiplied to this multiplier.
     * @return a complex number that is the product of the multiplier and the multiplicand.
     */
    public Complex multiply(final Complex multiplicand) {
        return new Complex(this.real * multiplicand.real() - this.imaginary * multiplicand.imaginary(),
                this.real * multiplicand.imaginary() + multiplicand.real() * this.imaginary);        
    }
    
    /**
     * The multiplication of a complex number and a real number.
     * @param multiplicand the real number that is multiplied to this multiplier.
     * @return a complex number that is the product of the multiplier and the multiplicand.
     */
    public Complex multiply(final double multiplicand) {
        return new Complex(this.real * multiplicand, this.imaginary * multiplicand);  
    }
    
    /**
     * The division of complex numbers.
     * @param divisor the complex number that is divided from the dividend.
     * @return a complex number that is the quotient of the divisor and the dividend.
     */
    public Complex divide(final Complex divisor) {
        final double denominator = (Math.pow(divisor.real(), 2) + Math.pow(divisor.imaginary(), 2));
        return new Complex((this.real * divisor.real() + this.imaginary * divisor.imaginary()),
                (this.imaginary * divisor.real() - this.real * divisor.imaginary())).divide(denominator); 
    }
    
    /**
     * The division of a complex dividend and a real divisor.
     * @param divisor the real number that is divided from the dividend.
     * @return a complex number that is the quotient of the divisor and the dividend.
     */
    public Complex divide(final double divisor) {
        return new Complex(this.real / divisor, this.imaginary / divisor);        
    }
    
    /**
     * The exponentiation of complex numbers.
     * @param exponent the complex number that determines the power the base is to.
     * @return a complex number that is the power of the base and the exponent.
     */
    public Complex exponentiate(final Complex exponent){
        return this.logarithm().multiply(exponent).exponentiate();
    }
    
    /**
     * The exponentiation of a complex base to a real exponent.
     * @param exponent the real number that determines the power the base is to.
     * @return a complex number that is the power of the base and the exponent.
     */
    public Complex exponentiate(final double exponent){
        return this.logarithm().multiply(exponent).exponentiate();
    }
    
    /**
     * The exponential function.
     * @return the exponential of this complex number.
     */
    public Complex exponentiate(){
        return new Complex(Math.exp(this.real) * Math.cos(this.imaginary), Math.exp(this.real) * Math.sin(this.imaginary));
    }
    
    /**
     * The nth root extraction of a complex number from a positive integer.
     * @param degree the positive integer that is extracted from this radicand.
     * @return an array list of complex numbers with a size of the degree 
     * that are the roots of the radicand and the degree.
     * @throws IllegalArgumentException if the degree is not a positive integer.
     */   
    public List<Complex> nthRoot(final int degree) throws IllegalArgumentException {
        if(degree < 1) {
            throw new IllegalArgumentException();
        } else {
            final List<Complex> roots = new ArrayList<>(degree);           
            final double rho = Math.pow(Math.hypot(this.real, this.imaginary), 1. / degree); 
            double theta = Math.atan2(this.imaginary, this.real) / degree;
            for (int k = 0; k < degree; k++) {
                final Complex kthRoot = new Complex(rho * Math.cos(theta), rho * Math.sin(theta));
                roots.add(kthRoot);
                theta += 2. * Math.PI / degree;               
            }
            return roots;
        }
    }
    
    /**
     * The principle value square root extraction.
     * @return a complex number that is the principle value square root of this radicand.
     */
    public Complex squareRoot() {
        final double multiplier = Math.sqrt(2) / 2;
        final double realPart = Math.sqrt(Math.hypot(this.real, this.imaginary) + this.real);
        final double imaginaryPart = Math.signum(this.imaginary) * Math.sqrt(Math.hypot(this.real, this.imaginary) - this.real);
        return new Complex(multiplier * realPart, multiplier * imaginaryPart);
    }    
    
    /**
     * The principle value cube root extraction. 
     * @return a complex number that is the principle value cube root of this radicand.
     */
    public Complex cubeRoot() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * The principle value logarithm of complex numbers.
     * @param base the complex number that is the parameter of the logarithm;
     * that is applied to this antilogarithm.
     * @return The principle value of the logarithm of the complex number.
     */
    public Complex logarithm(final Complex base) {    
        return this.logarithm().divide(base.logarithm());   
    }
    
    /**
     * The principle value logarithm of a complex antilogarithm and a real base.
     * @param base the real number that is the parameter of the logarithm;
     * that is applied to this antilogarithm.
     * @return The principle value of the natural logarithm of the complex number.
     */
    public Complex logarithm(final double base) {    
        return this.logarithm().divide(Math.log(base));   
    }
    
    /**
     * The principle value natural logarithm of the complex number.
     * The natural logarithmic function is a multivalued function 
     * and hence requires a branch cut on the complex plane, 
     * which the convention places at (-infinity, 0].
     * @return the natural logarithm of this complex number.
     */
    public Complex logarithm() {
        return new Complex(Math.log(Math.hypot(this.real, this.imaginary)), Math.atan2(this.imaginary, this.real));   
    } 
    
    
    
    
    
    
  
    
    public Complex sin() {
        return this.multiply(Complex.I).exponentiate().subtract(this.multiply(Complex.I).negate().exponentiate()).divide(2.).divide(Complex.I);
    }
    
    public Complex cos() {
        return this.multiply(Complex.I).exponentiate().add(this.multiply(Complex.I).negate().exponentiate()).divide(2.);
    }
    
    public Complex tan() {
        return this.multiply(Complex.I).exponentiate().subtract(this.multiply(Complex.I).negate().exponentiate())
                .divide(Complex.I).divide(this.multiply(Complex.I).exponentiate().add(this.multiply(Complex.I).negate().exponentiate()));
    }
    
    public Complex cot() {
        return Complex.I.multiply(this.multiply(Complex.I).exponentiate().add(this.multiply(Complex.I).negate().exponentiate()))
                .divide(this.multiply(Complex.I).exponentiate().subtract(this.multiply(Complex.I).negate().exponentiate()));
    }
    
    public Complex sec() {
        return Complex.TWO.divide(this.multiply(Complex.I).exponentiate().add(this.multiply(Complex.I).negate().exponentiate()));
    }
    
    public Complex csc() {
        return Complex.TWO.multiply(Complex.I).divide(this.multiply(Complex.I).exponentiate().subtract(this.multiply(Complex.I).negate().exponentiate()));
    }
    
    public Complex arcsin() {
        return Complex.I.negate().multiply(Complex.I.multiply(this).add(Complex.ONE.subtract(this.exponentiate(2)).squareRoot()).logarithm());
    }
    
    
    
    public Complex sinh() {
        return this.exponentiate().subtract(this.negate().exponentiate()).divide(2.);
    }

    public Complex cosh() {
        return this.exponentiate().add(this.negate().exponentiate()).divide(2.);
    }

    public Complex tanh() {
        return this.exponentiate().subtract(this.negate().exponentiate()).divide(this.exponentiate().add(this.negate().exponentiate()));
    }

    public Complex coth() {
        return this.exponentiate().add(this.negate().exponentiate()).divide(this.exponentiate().subtract(this.negate().exponentiate()));
    }

    public Complex sech() {
        return Complex.TWO.divide(this.exponentiate().add(this.negate().exponentiate()));
    }

    public Complex csch() {
        return Complex.TWO.divide(this.exponentiate().subtract(this.negate().exponentiate()));
    }


    
    
    
    
}