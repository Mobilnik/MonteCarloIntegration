package ru.iauli;

public class Executor {
    public static void main(String[] args) {
        //specify args in MonteCarloIntegration.java before running
        MonteCarloIntegration mci = new MonteCarloIntegration();
        mci.resultXORSDoubleH = mci.monteCarloIntegrationXOR(mci.leftBorder, mci.rightBorder, mci.iterations / 2);
        mci.resultJRandDoubleH = mci.monteCarloIntegrationJRand(mci.leftBorder, mci.rightBorder, mci.iterations / 2);
        mci.resultXORSH = mci.monteCarloIntegrationXOR(mci.leftBorder, mci.rightBorder, mci.iterations);
        mci.resultJRandH = mci.monteCarloIntegrationJRand(mci.leftBorder, mci.rightBorder, mci.iterations);

        System.out.println("\njava.util.random:");
        System.out.println("The exact value is " + mci.formatter.format(mci.exact));
        System.out.println("h: The calculation result equals " + mci.formatter.format(mci.resultJRandDoubleH));
        System.out.println("h: Absolute error equals " +
                mci.formatter.format(Math.abs(mci.exact - mci.resultJRandDoubleH)));
        if (mci.exact != 0) {
            System.out.println("h: Relative error equals " +
                    mci.formatter.format(Math.abs((mci.exact - mci.resultJRandDoubleH) / mci.exact) * 100) + "%");
        }
        System.out.println("h/2: The calculation result equals " + mci.formatter.format(mci.resultJRandH));
        System.out.println("h/2: Absolute error equals " +
                mci.formatter.format(Math.abs(mci.exact - mci.resultJRandH)));
        if (mci.exact != 0) {
            System.out.println("h/2: Relative error equals " +
                    mci.formatter.format(Math.abs((mci.exact - mci.resultJRandH) / mci.exact) * 100) + "%");
        }
        System.out.println("The method's exponent equals " + mci.exponentFormatter.format(Math.log
                (Math.abs((mci.exact - mci.resultJRandDoubleH) / (mci.exact - mci.resultJRandH))) / Math.log(2)));


        System.out.println("\n\n\nNumber of iterations: " + mci.iterations);
        System.out.println("XORShift:");
        System.out.println("The exact value is " + mci.formatter.format(mci.exact));
        System.out.println("h: The calculation result equals " + mci.formatter.format(mci.resultXORSDoubleH));
        System.out.println("h: Absolute error equals " +
                mci.formatter.format(Math.abs(mci.exact - mci.resultXORSDoubleH)));
        if (mci.exact != 0) {
            System.out.println("h: Relative error equals " +
                    mci.formatter.format(Math.abs((mci.exact - mci.resultXORSDoubleH) / mci.exact) * 100) + "%");
        }
        System.out.println("h/2: The calculation result equals " + mci.formatter.format(mci.resultXORSH));
        System.out.println("h/2: Absolute error equals " +
                mci.formatter.format(Math.abs(mci.exact - mci.resultXORSH)));
        if (mci.exact != 0) {
            System.out.println("h/2: Relative error equals " +
                    mci.formatter.format(Math.abs((mci.exact - mci.resultXORSH) / mci.exact) * 100) + "%");
        }
        System.out.println("The method's exponent equals " + mci.exponentFormatter.format(Math.log(Math.abs
                ((mci.exact - mci.resultXORSDoubleH) / (mci.exact - mci.resultXORSH))) / Math.log(2)));
    }
}
