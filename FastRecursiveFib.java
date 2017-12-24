//******************************************************************************
//Name: Luciano Caminata
//Class: COP 3337
//Section: U04
//Assignment: 6
//Due Date: December 1, 2016
// 
// I hereby certify that this collective work is my own
// and none of it is the work of any other person or entity.
//
// How to compile and execute this program:
//    javac FastRecursiveFib.java
//******************************************************************************
/**
 * This is a faster method to compute the Fibonacci class recursively.
 */
public class FastRecursiveFib implements FibonacciInterface {
    /*
     Declare an array named listOfFibonacci to store previous Fibonacci numbers.
     once they are computed.
     */
    final static int LIMIT = 50;
    static long[] listOfFibonacci = new long[LIMIT];
    /**
     * This if statement will check if the current spot in the array has no
     * value, if it does not it will move forward with the method to compute it.
     * The first two Fibonacci numbers are set to 1, this if statement will give
     * them the values. This alternate method will recursively compute the
     * remaining Fibonacci numbers by calling out the the two previous values of
     * the same method and adding them. The difference between this method and
     * the other recursion method is that this method will also store the
     * current value in the array to document it.
     *
     * @param currentFastRecursion is the current Fibonacci number in the set
     * that the method will attempt to compute using the fast recursive method
     * of finding Fibonacci numbers.
     * @return the current element in the array of Fibonacci numbers.
     */
    public long computeFibonacci(int currentFastRecursion) {
        final int EMPTY = 0; //Constant to validate if the current array element is empty.
        final int FIRST_FIBONACCI_NUMBER = 1; //The first and second value in the fibonacci sequence.
        final int FIRST_TWO_ITERATIONS = 2; //Used to set the first two numbers in the table.
        if (listOfFibonacci[currentFastRecursion] == EMPTY) {
            if (currentFastRecursion <= FIRST_TWO_ITERATIONS) {
                listOfFibonacci[currentFastRecursion] = FIRST_FIBONACCI_NUMBER;
            } else {
                final int SUBTRACT_BY_ONE = 1; //Constant used to find a previous Fibonacci number in the sequence.
                final int SUBTRACT_BY_TWO = 2; //Constant used to find a previous Fibonacci number in the sequence.
                listOfFibonacci[currentFastRecursion] = computeFibonacci(currentFastRecursion - SUBTRACT_BY_ONE)
                        + computeFibonacci(currentFastRecursion - SUBTRACT_BY_TWO);
            }
        }
        return listOfFibonacci[currentFastRecursion];
    }
}
