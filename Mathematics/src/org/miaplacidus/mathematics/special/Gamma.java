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
package org.miaplacidus.mathematics.special;


import java.util.logging.Logger;
import org.miaplacidus.mathematics.number.complex.Complex;

/**
 *
 * @author Miaplacidus d'Orléans <miaplacidus.d.orleans@gmail.com>
 */
public class Gamma extends Object{
    
    private static final double LANCZOS_APPROXIMATION_G=4.7421875;
    private static final double LANCZOS_APPROXIMATION_N=15;
    private static final double[] LANCZOS_APPROXIMATION_P={
        .99999999999999709182,
        57.156235665862923517,
        -59.597960355475491248,
        14.136097974741747174,
        -.49191381609762019978,
        .33994649984811888699E-4,
        .46523628927048575665E-4,
        -.98374475304879564677E-4,
        .15808870322491248884E-3,
        -.21026444172410488319E-3,
        .21743961811521264320E-3,
        -.16431810653676389022E-3,
        .84418223983852743293E-4,
        -.26190838401581408670E-4,
        .36899182659531622704E-5
    };
    /**
     * The Euler–Mascheroni constant.
     */
    public static final double GAMMA = 0.577215664901532860606512090082;
    private static final Logger LOG = Logger.getLogger(Gamma.class.getName());
   
    /**
     * The method utilises the Lanczos Approximation to compute the gamma function of a real number.
     * @param x a real number.
     * @return the result of the gamma function with parameter x.
     */
    public static double gamma(final double x) {
	if (x < .5) {
            return Math.PI / Math.sin(Math.PI * x) / Gamma.gamma(1 - x);
        } else {
            double a = LANCZOS_APPROXIMATION_P[0];
            final double t = x + LANCZOS_APPROXIMATION_G - .5;
            
            for (int k = 1; k < LANCZOS_APPROXIMATION_N; k++) {
		a += LANCZOS_APPROXIMATION_P[k] / (x + k - 1.);
            }
            return Math.pow(t, x - .5) * Math.sqrt(Math.PI * 2.) * Math.exp(-t) * a;
	}
    }
    
    
    /**
     * The method utilises the Lanczos Approximation to compute the gamma function of a complex number.
     * @param z a complex number.
     * @return the result of the gamma function with parameter z.
     */
    public static Complex gamma(final Complex z) {
	if (z.real() < .5) {
            return Complex.PI.divide(z.multiply(Math.PI).sin()).divide(gamma(Complex.ONE.subtract(z)));
        } else {
            Complex a = new Complex(LANCZOS_APPROXIMATION_P[0]);
            final Complex t = z.add(LANCZOS_APPROXIMATION_G).subtract(.5);
            
            for (int k = 1; k < LANCZOS_APPROXIMATION_N; k++) {
		a = a.add(new Complex(LANCZOS_APPROXIMATION_P[k]).divide(z.add(k - 1)));
            }
            return t.exponentiate(z.subtract(.5)).multiply(Math.sqrt(Math.PI * 2)).multiply(t.negate().exponentiate()).multiply(a);
	}
    }
    
    private Gamma() {
        throw new AssertionError();
    }
}
