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

import java.util.logging.Logger;

/**
 * The utility class for the Complex.java class.
 * @author Miaplacidus d'Orléans <miaplacidus.d.orleans@gmail.com>
 */
public class ComplexUtility extends Object{
    private static final Logger LOG = Logger.getLogger(ComplexUtility.class.getName());
    
    /**
     * Convert a number to a complex number.
     * @param number a real number to be converted to its complex equivalent.
     * @return a complex number.
     */
    public static Complex toComplex(final Number number) {
        return new Complex((double)number);
    }
    
    /**
     * Convert a Boolean to a complex number.
     * @param bool a Boolean to be converted to its complex equivalent.
     * @return a complex number that is either one or zero.
     */
    public static Complex toComplex(final boolean bool) {
        return bool ? Complex.ONE : Complex.ZERO;
    }
    private ComplexUtility(){
        throw new AssertionError();
    }
}
