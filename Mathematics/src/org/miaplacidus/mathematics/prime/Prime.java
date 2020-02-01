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
package org.miaplacidus.mathematics.prime;

import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Miaplacidus d'Orléans <miaplacidus.d.orleans@gmail.com>
 */
public class Prime extends Object {
    private static final Logger LOG = Logger.getLogger(Prime.class.getName());
    
    public static boolean prime(long number) {
        if (number < 2) {
            return false;
        } else {
            throw new UnsupportedOperationException();
        }
    }
    
    public static long nextPrime(long number) {
        throw new UnsupportedOperationException();
    }
    
    public static List<Long> primeFactorise(long number) throws IllegalArgumentException {
        if (number < 2) {
            throw new IllegalArgumentException();
        } else {
            throw new UnsupportedOperationException();
        }
    }
    
    private Prime() {
        throw new AssertionError();
    }
    
    
}
