package algorithms;

import static java.lang.Math.abs;
import java.math.BigInteger;

public class Fibonacci extends AbsAlgorithm {

    public Fibonacci() {
        name = "Fibonacci";
    }

    public BigInteger executeAlgorithm(int num) {
        num = abs(num);
        BigInteger num1 = BigInteger.valueOf(0);
        BigInteger num2 = BigInteger.valueOf(1);
        BigInteger tmp;
        if (num == 0) {
            return num1;
        } else if ( num == 1) {
            return num2;
        } else {
            for(int n = 0; n < num-1; n++) {
                tmp = num2;
                num2 = num2.add(num1);
                num1 = tmp;
            }
        }
        return num2;
    }
}
