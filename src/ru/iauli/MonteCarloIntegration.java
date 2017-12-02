package ru.iauli;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MonteCarloIntegration {

    NumberFormat formatter = new DecimalFormat("#0.00000000");
    NumberFormat exponentFormatter = new DecimalFormat("#0.00");
    //the block of data required for all the calculations starts here
    double leftBorder = 0;
    double rightBorder = Math.PI / 2;
    long iterations = 10_000_000L;
    double exact = 1.0;

    //specify the function for integrating
    double function(double x) {
        return Math.cos(x);
    }
    //and it ends here

    /*regulates the number of possible results to return
    it's good enough to make it equal to iterations number:
    xorShiftMaxInt divides the interval into N parts and N values of function are returned by number of iterations
    That provides a more slide distribution of returned values*/
    long xorShiftMaxInt;

    double resultXORSDoubleH = 0, resultJRandDoubleH = 0;
    double resultXORSH = 0, resultJRandH = 0;

    double monteCarloIntegrationXOR(double leftBorder, double rightBorder, long iterations) {
        if (leftBorder > rightBorder) {
            return monteCarloIntegrationXOR(rightBorder, leftBorder, iterations);
        } else {
            double sum = 0, x;
            xorShiftMaxInt = iterations;
            XORShiftRandom xors = new XORShiftRandom();
            for (long i = 1; i < iterations; i++) {
                x = leftBorder + ((double) xors.nextLong(xorShiftMaxInt)) / xorShiftMaxInt * (rightBorder - leftBorder);
                sum += function(x);
            }
            sum *= ((rightBorder - leftBorder) / iterations);
            return sum;
        }
    }

    double monteCarloIntegrationJRand(double leftBorder, double rightBorder, long iterations) {
        if (leftBorder > rightBorder) {
            return monteCarloIntegrationJRand(rightBorder, leftBorder, iterations);
        } else {
            double sum = 0, x;
            for (long i = 1; i < iterations; i++) {
                x = leftBorder + Math.random() * (rightBorder - leftBorder);
                sum += function(x);
            }
            sum *= ((rightBorder - leftBorder) / iterations);
            return sum;
        }
    }

}
