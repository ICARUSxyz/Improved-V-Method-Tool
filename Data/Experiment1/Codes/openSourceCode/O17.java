/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.math4.legacy.analysis.interpolation;

import org.apache.commons.math4.legacy.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math4.legacy.exception.*;
import org.apache.commons.math4.legacy.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math4.legacy.exception.DimensionMismatchException;
import org.apache.commons.math4.legacy.exception.NonMonotonicSequenceException;
import org.apache.commons.math4.legacy.exception.NumberIsTooSmallException;
import org.apache.commons.math4.legacy.exception.util.LocalizedFormats;
import org.apache.commons.math4.legacy.core.MathArrays;

/**
 * Implements a linear function for interpolation of real univariate functions.
 *
 */
public class LinearInterpolator implements UnivariateInterpolator {
    /**
     * Computes a linear interpolating function for the data set.
     *
     * @param x the arguments for the interpolation points
     * @param y the values for the interpolation points
     * @return a function which interpolates the data set
     * @throws DimensionMismatchException if {@code x} and {@code y}
     * have different sizes.
     * @throws NonMonotonicSequenceException if {@code x} is not sorted in
     * strict increasing order.
     * @throws NumberIsTooSmallException if the size of {@code x} is smaller
     * than 2.
     */
    @Override
    public PolynomialSplineFunction interpolate(double[] x, double[] y)
        throws DimensionMismatchException,
               NumberIsTooSmallException,
               NonMonotonicSequenceException {
        if (x.length != y.length) {
            throw new DimensionMismatchException(x.length, y.length);
        }

        if (x.length < 2) {
            throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_OF_POINTS,
                                                x.length, 2, true);
        }

        // Number of intervals.  The number of data points is n + 1.
        int n = x.length - 1;

        MathArrays.checkOrder(x);

        // Slope of the lines between the datapoints.
        final double[] m = new double[n];
        for (int i = 0; i < n; i++) {
            m[i] = (y[i + 1] - y[i]) / (x[i + 1] - x[i]);
        }

        final PolynomialFunction[] polynomials = new PolynomialFunction[n];
        final double[] coefficients = new double[2];
        for (int i = 0; i < n; i++) {
            coefficients[0] = y[i];
            coefficients[1] = m[i];
            polynomials[i] = new PolynomialFunction(coefficients);
        }

        return new PolynomialSplineFunction(x, polynomials);
    }
}


//vt
class LI_VT {

    private static void headline(String name){ System.out.println("\n==== " + name + " ===="); }

    @FunctionalInterface private interface Throwing { void run() throws Exception; }

    private static void expectThrow(String name, Throwing r, Class<?> expected){
        System.out.println("---- " + name + " ----");
        try {
            r.run();
            System.out.printf("[FAIL] %s should throw %s%n", name, expected.getSimpleName());
        } catch (Throwable t){
            System.out.println("threw: " + t.getClass().getName() + " - " + t.getMessage());
            System.out.printf("[%s] %s threw expected%n",
                    t.getClass().equals(expected) ? "PASS" : "FAIL", name);
        }
    }

    private static String fmt(double v){
        if (Double.isNaN(v)) return "NaN";
        if (v == Double.POSITIVE_INFINITY) return "+Inf";
        if (v == Double.NEGATIVE_INFINITY) return "-Inf";
        if (v == 0.0) return (Double.doubleToRawLongBits(v)>>>63)==1 ? "-0.0" : "0.0";
        return String.format(java.util.Locale.ROOT, "%.17g", v);
    }

    private static void checkEquals(String name, double expected, double actual, double tolRel){
        boolean ok;
        if (Double.isNaN(expected) || Double.isNaN(actual)) {
            ok = (Double.isNaN(expected) && Double.isNaN(actual));
        } else if (Double.isInfinite(expected) || Double.isInfinite(actual)) {
            ok = (Double.doubleToRawLongBits(expected) == Double.doubleToRawLongBits(actual));
        } else {
            double tolAbs = Math.max(1.0, Math.max(Math.abs(expected), Math.abs(actual))) * tolRel;
            ok = (expected == actual) || (Math.abs(expected - actual) <= tolAbs);
        }
        System.out.printf("[%s] %s  expected=%s  actual=%s  (relTol=%.1e)%n",
                ok ? "PASS" : "FAIL", name, fmt(expected), fmt(actual), tolRel);
    }

    private static double piecewiseLinear(double[] x, double[] y, double t){
        int n = x.length;
        if (t == x[n-1]) return y[n-1];
        int i = java.util.Arrays.binarySearch(x, t);
        if (i >= 0) return y[i];
        int ip = -i - 2; 
        double x0 = x[ip], x1 = x[ip+1];
        double y0 = y[ip], y1 = y[ip+1];
        double w = (t - x0) / (x1 - x0);
        return y0 + w * (y1 - y0);
    }

    public void Vtest() throws Exception {
        final LinearInterpolator LI = new LinearInterpolator();

        /* ===================== Constructor / input guards ===================== */

        // VT01: x=null
        expectThrow("VT01 x=null",
                () -> LI.interpolate(null, new double[]{0,1}),
                NullArgumentException.class);

        // VT02: y=null
        expectThrow("VT02 y=null",
                () -> LI.interpolate(new double[]{0,1}, null),
                NullArgumentException.class);

        // VT03: |x|=0 -> NoData
        expectThrow("VT03 |x|=0",
                () -> LI.interpolate(new double[]{}, new double[]{}),
                NoDataException.class);

        // VT04: |y|=0 -> NoData
        expectThrow("VT04 |y|=0",
                () -> LI.interpolate(new double[]{0}, new double[]{}),
                NoDataException.class);

        // VT05: |x|≠|y| -> DimensionMismatch
        expectThrow("VT05 length mismatch",
                () -> LI.interpolate(new double[]{0,1,2}, new double[]{10,20}),
                DimensionMismatchException.class);

        // VT06: |x|<2 -> NumberIsTooSmall (|x|=1)
        expectThrow("VT06 |x|<2",
                () -> LI.interpolate(new double[]{0}, new double[]{10}),
                NumberIsTooSmallException.class);

        // VT07:
        expectThrow("VT07 x non-strict (duplicate)",
                () -> LI.interpolate(new double[]{0, 1, 1, 2}, new double[]{0, 10, 20, 30}),
                NonMonotonicSequenceException.class);

        // VT08: 
        expectThrow("VT08 x non-strict (descending)",
                () -> LI.interpolate(new double[]{0, -1}, new double[]{0, 1}),
                NonMonotonicSequenceException.class);

        // VT09: 
        expectThrow("VT09 x has NaN",
                () -> LI.interpolate(new double[]{0, Double.NaN, 2}, new double[]{0, 1, 2}),
                NotFiniteNumberException.class);

        // VT10: 
        expectThrow("VT10 y has +Inf",
                () -> LI.interpolate(new double[]{0, 1, 2}, new double[]{0, Double.POSITIVE_INFINITY, 2}),
                NotFiniteNumberException.class);


//        final double[] X = {-2.0, 0.0, 1.5, 5.0};
//        final double[] Y = { 4.0, 1.0, 3.0, 7.0};
//        final PolynomialSplineFunction S = LI.interpolate(X, Y); 
//
//        // VT11: 
//        expectThrow("VT11 value(x<a) -> OutOfRange",
//                () -> S.value(-2.0000000001),
//                OutOfRangeException.class);
//
//        // VT12: 
//        expectThrow("VT12 value(x>b) -> OutOfRange",
//                () -> S.value(5.0000000001),
//                OutOfRangeException.class);
//
//        // VT13:
//        headline("VT13 value at left endpoint");
//        {
//            double got = S.value(X[0]);
//            checkEquals("VT13 y(x0)", Y[0], got, 1e-15);
//        }
//
//        // VT14: 
//        headline("VT14 value at right endpoint");
//        {
//            double got = S.value(X[X.length-1]);
//            checkEquals("VT14 y(xN-1)", Y[Y.length-1], got, 1e-15);
//        }

        System.out.println("\n[Done] LinearInterpolator VT01–VT20 executed.");
    }
}

//ft
class LI_FT {

    /* ---------------- helpers ---------------- */
    private static void headline(String name){ System.out.println("\n==== " + name + " ===="); }
    @FunctionalInterface private interface Throwing { void run() throws Exception; }

    private static void expectThrow(String name, Throwing r, Class<?> expected){
        System.out.println("---- " + name + " ----");
        try {
            r.run();
            System.out.printf("[FAIL] %s should throw %s%n", name, expected.getSimpleName());
        } catch (Throwable t){
            System.out.println("threw: " + t.getClass().getName() + " - " + t.getMessage());
            System.out.printf("[%s] %s threw expected%n",
                    t.getClass().equals(expected) ? "PASS" : "FAIL", name);
        }
    }

    private static String fmt(double v){
        if (Double.isNaN(v)) return "NaN";
        if (v == Double.POSITIVE_INFINITY) return "+Inf";
        if (v == Double.NEGATIVE_INFINITY) return "-Inf";
        if (v == 0.0) return (Double.doubleToRawLongBits(v)>>>63)==1 ? "-0.0" : "0.0";
        return String.format(java.util.Locale.ROOT, "%.17g", v);
    }

    private static void checkEquals(String name, double expected, double actual, double relTol){
        boolean ok;
        if (Double.isNaN(expected) || Double.isNaN(actual)) {
            ok = (Double.isNaN(expected) && Double.isNaN(actual));
        } else if (Double.isInfinite(expected) || Double.isInfinite(actual)) {
            ok = (Double.doubleToRawLongBits(expected) == Double.doubleToRawLongBits(actual));
        } else {
            double tol = Math.max(1.0, Math.max(Math.abs(expected), Math.abs(actual))) * relTol;
            ok = (expected == actual) || (Math.abs(expected - actual) <= tol);
        }
        System.out.printf("[%s] %s  expected=%s  actual=%s  (relTol=%.1e)%n",
                ok ? "PASS" : "FAIL", name, fmt(expected), fmt(actual), relTol);
    }

    private static double[] randMonotone(java.util.Random r, int n, double start, double stepMin, double stepMax){
        double[] a = new double[n];
        double cur = start;
        for (int i=0;i<n;i++){
            cur += stepMin + (stepMax - stepMin) * r.nextDouble();
            a[i] = cur;
        }
        return a;
    }

    private static double[] randArray(java.util.Random r, int n, double scale){
        double[] a = new double[n];
        for (int i=0;i<n;i++) a[i] = scale * r.nextGaussian();
        return a;
    }

    private static double piecewiseLinear(double[] x, double[] y, double t){
        int n = x.length;
        if (t <= x[0]) return y[0];
        if (t >= x[n-1]) return y[n-1];
        int i = java.util.Arrays.binarySearch(x, t);
        if (i >= 0) return y[i];
        int ip = -i - 2; // left index
        double x0 = x[ip], x1 = x[ip+1];
        double y0 = y[ip], y1 = y[ip+1];
        double w = (t - x0) / (x1 - x0);
        return y0 + w * (y1 - y0);
    }

    public void Ftest() throws Exception {
        final LinearInterpolator LI = new LinearInterpolator();
        final java.util.Random R = new java.util.Random(20251028L);

        // FT01
        headline("FT01 random monotone, interior value");
        {
            int n = 3 + R.nextInt(6); // 3..8
            double[] x = randMonotone(R, n, -10.0, 1e-3, 5.0);
            double[] y = randArray(R, n, 10.0);
            PolynomialSplineFunction s = LI.interpolate(x, y);
            double t = x[0] + (x[n-1] - x[0]) * R.nextDouble();
            double got = s.value(t);
            double exp = piecewiseLinear(x, y, t);
            checkEquals("FT01 y(t)", exp, got, 1e-12);
        }

        // FT02
        headline("FT02 tiny spacing & wide Y range");
        {
            int n = 5;
            double[] x = randMonotone(R, n, 0.0, 1e-14, 1e-12);
            double[] y = new double[]{1e150, 1e150+1e138, 1e150+5e138, 1e150+6e138, 1e150+9e138};
            PolynomialSplineFunction s = LI.interpolate(x, y);
            double t = 0.5*(x[2]+x[3]);
            double got = s.value(t);
            double exp = piecewiseLinear(x, y, t);
            checkEquals("FT02 y(t)", exp, got, 1e-10);
        }

        // FT03 
        headline("FT03 wide x range");
        {
            int n = 6;
            double[] x = randMonotone(R, n, -1e9, 1e6, 1e8);
            double[] y = randArray(R, n, 1e3);
            PolynomialSplineFunction s = LI.interpolate(x, y);
            double t = x[2] + 0.3*(x[3]-x[2]);
            double got = s.value(t);
            double exp = piecewiseLinear(x, y, t);
            checkEquals("FT03 y(t)", exp, got, 1e-12);
        }

        // FT04 
        headline("FT04 two-point random");
        {
            double[] x = new double[]{-2.608417489800224E307, -1, 0, 2};
            double[] y = new double[]{ 0,  0, 0, 0};
            PolynomialSplineFunction s = LI.interpolate(x, y);
            expectThrow("FT04 ", () -> s.value(-3.0000000001), OutOfRangeException.class);
        }

        // FT05
        headline("FT05 out-of-range left");
        {
            double[] x = new double[]{-2.608417489800224E307, -1, 0, 2};
            double[] y = new double[]{ 0,  0, 0, 0};
            PolynomialSplineFunction s = LI.interpolate(x, y);
            expectThrow("FT05 value(x<a)", () -> s.value(-3.0000000001), OutOfRangeException.class);
        }

        // FT06 
        headline("FT06 out-of-range right");
        {
            double[] x = new double[]{0, 1, 2.608417489800224E307, 7};
            double[] y = new double[]{2.608417489800224E307, 3, 0, 5};
            PolynomialSplineFunction s = LI.interpolate(x, y);
            expectThrow("FT06 value(x>b)", () -> s.value(7.0000000001), OutOfRangeException.class);
        }

        // FT07 
        headline("FT07 x contains NaN");
        {
            double[] x = new double[]{0, Double.NaN, 2};
            double[] y = new double[]{1, 2, 3};
            expectThrow("FT07", () -> LI.interpolate(x, y), NotFiniteNumberException.class);
        }

        // FT08 
        headline("FT08 y contains +Inf");
        {
            double[] x = new double[]{-2.608417489800224E307, 0, 2.608417489800224E307};
            double[] y = new double[]{  0, Double.POSITIVE_INFINITY, 2};
            expectThrow("FT08", () -> LI.interpolate(x, y), NotFiniteNumberException.class);
        }

        // FT09 
        headline("FT09 non-monotone x");
        {
            int n = 5;
            double[] x = randMonotone(R, n, -5.0, 0.1, 3.0);
            double[] y = randArray(R, n, 4.0);
            x[2] = x[1] - 1e-6;
            expectThrow("FT09", () -> LI.interpolate(x, y), NonMonotonicSequenceException.class);
        }

        // FT10
        headline("FT10 length mismatch");
        {
            double[] x = new double[]{0, 1, 2, 3};
            double[] y = new double[]{0, 1, 2};
            expectThrow("FT10", () -> LI.interpolate(x, y), DimensionMismatchException.class);
        }

        System.out.println("\n[Done] LinearInterpolator FT01–FT10 executed.");
    }
}

//z3
class LI_Z3 {

    /* ---------------- helpers ---------------- */
    @FunctionalInterface private interface Throwing { void run() throws Exception; }

    private static void headline(String name){ System.out.println("\n==== " + name + " ===="); }

    private static void expectThrow(String name, Throwing r, Class<?> expected){
        System.out.println("---- " + name + " ----");
        try {
            r.run();
            System.out.printf("[FAIL] %s should throw %s%n",
                    name, expected.getSimpleName());
        } catch (Throwable t){
            System.out.println("threw: " + t.getClass().getName() + " - " + t.getMessage());
            System.out.printf("[%s] %s threw expected%n",
                    t.getClass().equals(expected) ? "PASS" : "FAIL", name);
        }
    }

    private static String fmt(double v){
        if (Double.isNaN(v)) return "NaN";
        if (v == Double.POSITIVE_INFINITY) return "+Inf";
        if (v == Double.NEGATIVE_INFINITY) return "-Inf";
        if (v == 0.0) return (Double.doubleToRawLongBits(v)>>>63)==1 ? "-0.0" : "0.0";
        return String.format(java.util.Locale.ROOT, "%.17g", v);
    }

    private static void checkEquals(String name, double expected, double actual, double relTol){
        boolean ok;
        if (Double.isNaN(expected) || Double.isNaN(actual)) {
            ok = (Double.isNaN(expected) && Double.isNaN(actual));
        } else if (Double.isInfinite(expected) || Double.isInfinite(actual)) {
            ok = (Double.doubleToRawLongBits(expected) == Double.doubleToRawLongBits(actual));
        } else {
            double tolAbs = Math.max(1.0, Math.max(Math.abs(expected), Math.abs(actual))) * relTol;
            ok = (expected == actual) || (Math.abs(expected - actual) <= tolAbs);
        }
        System.out.printf("[%s] %s  expected=%s  actual=%s  (relTol=%.1e)%n",
                ok ? "PASS" : "FAIL", name, fmt(expected), fmt(actual), relTol);
    }

    public void Z3test() throws Exception {
        final LinearInterpolator LI = new LinearInterpolator();

        // Z301 ------------------------------------------------------------------
        expectThrow("Z301 x=null or y=null → NullArgumentException",
                () -> LI.interpolate(null, new double[]{1.0}),
                NullArgumentException.class);

        // Z302 ------------------------------------------------------------------
        expectThrow("Z302 |x|=0 or |y|=0 → NoDataException",
                () -> LI.interpolate(new double[]{}, new double[]{1,2,3,4,5}),
                NoDataException.class);

        // Z303 ------------------------------------------------------------------
        expectThrow("Z303 |x|≠|y| → DimensionMismatchException",
                () -> LI.interpolate(new double[]{0,1,2,3,4}, new double[]{10,11,12,13}),
                DimensionMismatchException.class);

        // Z304 ------------------------------------------------------------------
        expectThrow("Z304 |x|<2 → NumberIsTooSmallException",
                () -> LI.interpolate(new double[]{7.0}, new double[]{3.0}),
                NumberIsTooSmallException.class);

        // Z305 ------------------------------------------------------------------
        expectThrow("Z305 ∃ non-finite in x/y → NotFiniteNumberException",
                () -> LI.interpolate(new double[]{0.0, 1.0, 2.0},
                                     new double[]{5.0, Double.NaN, 9.0}),
                NotFiniteNumberException.class);

        // Z306 ------------------------------------------------------------------
        expectThrow("Z306 x not strictly increasing → NonMonotonicSequenceException",
                () -> LI.interpolate(new double[]{0.0, 1.0, 1.0, 3.0},
                                     new double[]{0.0, 1.0, 2.0, 3.0}),
                NonMonotonicSequenceException.class);

        // Z307 ------------------------------------------------------------------
        headline("Z307 success: valid monotone & finite, |x|=|y|≥2 → None");
        {
            double[] x = new double[]{0, 1, 2, 3, 4, 5};
            double[] y = new double[]{1, 3, 5, 7, 9, 11};
            PolynomialSplineFunction s = LI.interpolate(x, y);
            double t = 2.5;
            double got = s.value(t);
            double exp = 2.0*t + 1.0;
            checkEquals("Z307 y(2.5) == 6.0", exp, got, 1e-15);
        }

        // Z308 ------------------------------------------------------------------
        expectThrow("Z308 |y|=0 (|x|>0) → NoDataException",
                () -> LI.interpolate(new double[]{0.0, 1.0}, new double[]{}),
                NoDataException.class);

        // Z309 ------------------------------------------------------------------
        expectThrow("Z309 |x|=3, |y|=2 → DimensionMismatchException",
                () -> LI.interpolate(new double[]{-1.0, 0.0, 2.0},
                                     new double[]{4.0, 8.0}),
                DimensionMismatchException.class);

        // Z310 ------------------------------------------------------------------
        expectThrow("Z310 NonMonotonic edge (equal neighbors) → NonMonotonicSequenceException",
                () -> LI.interpolate(new double[]{10.0, 10.0},
                                     new double[]{-2.0, -2.0}),
                NonMonotonicSequenceException.class);

        System.out.println("\n[Done] LinearInterpolator Z301–Z310 executed.");
    }
}

class LI_Runner {
    public static void main(String[] args) throws Exception {
        new LI_VT().Vtest();
//    	new LI_FT().Ftest();
//    	new LI_Z3().Z3test();
    	
    }
}