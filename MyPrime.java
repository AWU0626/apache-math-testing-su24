public class MyPrime {

    /*
     * DO NOT CHANGE THIS CODE!
     * Please notify the instructor if you feel that it is necessary to do so.
     */

    /**
     * Return the smallest prime greater than or equal to n.
     * Note that 2 is the smallest prime number; 1 is not prime.
     *
     * @param n a positive number.
     * @return the smallest prime greater than or equal to n.
     * @throws IllegalArgumentException if n &lt; 0.
     */
    public static int nextPrime(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Arguments to the function must not be negative.");
        }
        if (n == 2) {
            return 2;
        }
        n |= 1;// make sure n is odd
        if (n == 1) {
            return 1;
        }

        if (isPrime(n)) {
            return n;
        }

        final int rem = n % 3;
        System.out.println(rem);
        if (0 == rem) {
            n += 2;
        } else if (1 == rem) {
            n += 4;
        }

        while (true) {
            if (isPrime(n)) {
                return n;
            }
            n += 2;
            if (isPrime(n)) {
                return n;
            }
            n += 4;
        }
    }

    /**
     * Method to determine if a number is prime.
     * Note that you do NOT need to write tests for this method.
     *
     * @param n number to test.
     * @return true if n is prime. (All numbers &lt; 2 return false).
     */
    public static boolean isPrime(int n) {
        if (n < 2 || n % 2 == 0) {
            return false;
        }

        for (int p = 3; p <= Math.sqrt(n); p += 2) {
            if (n % p == 0) {
                return false;
            }
        }
        return true;
    }
}
